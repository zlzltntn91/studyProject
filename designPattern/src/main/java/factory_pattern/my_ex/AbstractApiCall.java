package factory_pattern.my_ex;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import factory_pattern.my_ex.vo.ApiRequestVo;
import factory_pattern.my_ex.vo.ApiResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 리팩토링
 * TODO 21-02-02 변하는 부분, 변하지 않는 부분 찾기
 */
@Slf4j
public abstract class AbstractApiCall {

  final String DEFAULT_CONTENT_TYPE = MediaType.APPLICATION_JSON_UTF8_VALUE;

  public <R extends ApiResponseVo, P extends ApiRequestVo> R send (String method, String sUrl, P p, R r, HttpHeaders headers) throws Exception {
    String data = null;
    URL url = null;
    HttpURLConnection con = null;
    
    try {
      // 변하지 않는 부분
      url = new URL(sUrl);
      con = (HttpURLConnection) url.openConnection();

      // 변하는 부분
      con.setRequestMethod(method);
      setRequestProperties(con, headers);

      if (p != null) {
        data = setData(con, p);
        writer(con, data);
      }

      r = reader(con, r);
    } finally {
      if (con != null) {
        con.disconnect();
      }
    }
    return r;
  }

  public void setRequestProperties (HttpURLConnection connection) {
    setRequestProperties(connection, new HttpHeaders());
  }

  abstract void setRequestProperties (HttpURLConnection con, HttpHeaders headers);

  public <R extends ApiResponseVo, P extends ApiRequestVo> R post (String sUrl, P p, R r) throws Exception {
    return this.send("POST", sUrl, p, r, new HttpHeaders());
  }

  public <R extends ApiResponseVo, P extends ApiRequestVo> R send (String method, String sUrl, P p, R r) throws Exception {
    return this.send(method, sUrl, p, r, new HttpHeaders());
  }

  public <R extends ApiResponseVo, P extends ApiRequestVo> R noContentSend (String method, String sUrl, HttpHeaders headers) throws Exception {
    return this.send(method, sUrl, null, null, headers);
  }

  protected <R extends ApiResponseVo> R reader (HttpURLConnection con, R r) {
    StringBuilder sb = new StringBuilder();
    String result = null;
    try (
      BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
    ) {
      String readOneLine;
      while ((readOneLine = br.readLine()) != null) {
        sb.append(readOneLine).append("\n");
      }
      if (sb.length() > 0) {
        sb.delete(sb.lastIndexOf("\n"), sb.length());
      }
      result = sb.toString();

      if (r != null) {
        try {
          r = getResponseVo(result, r);
        } catch (IOException e) {
          r.setResponseBody(result);
        }
      }

    } catch (IOException e) {
      log.error(e.getMessage());
    }
    return r;
  }

  protected <R extends ApiResponseVo> R getResponseVo (String result, R r) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    r = (R) mapper.readValue(result, r.getClass());
    return r;
  }

  protected <ReqVo extends ApiRequestVo> String setData (HttpURLConnection con, ReqVo vo) {
    ObjectMapper mapper = new ObjectMapper();
    String httpMessage = "";
    try {
      httpMessage = mapper.writeValueAsString(vo);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    String contentType = con.getRequestProperty("content-type").replace(" ", "").toLowerCase();
    if (contentType.contains("x-www-form-urlencoded")) {
      String queryString = "";
      try {
        final Map<String, String> map = mapper.readValue(httpMessage, new TypeReference<Map<String, String>>() {
        });
        queryString = map.keySet().stream()
          .map(x -> {
            try {
              return URLEncoder.encode(x, "utf-8") + "=" + URLEncoder.encode(map.get(x), "utf-8");
            } catch (UnsupportedEncodingException e) {
              return x;
            }
          })
          .collect(Collectors.joining("&"));
      } catch (Exception e) {
      }
      log.info(queryString);
      httpMessage = queryString;
    }
    return httpMessage;
  }

  protected void writer (HttpURLConnection con, String data) {
    try (
      OutputStreamWriter os = new OutputStreamWriter(con.getOutputStream());
      PrintWriter pw = new PrintWriter(os);
    ) {
      pw.write(data);
      pw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
