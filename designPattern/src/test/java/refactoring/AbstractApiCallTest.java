package refactoring;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@Slf4j
public class AbstractApiCallTest {

  @Test
  public void conectionFactoryTest () {
    ConcreteApiCall apiCall = new ConcreteApiCall();
    HttpURLConnection connection = apiCall.connectionFactory("http://tapi.docuchain.kr");
  }

  abstract class AbstractApiCall {

    protected abstract void setRequestProperties(HttpURLConnection connection);

    // 팩토리 메서드 패턴
    public HttpURLConnection connectionFactory (String url) {
      HttpURLConnection connection = null;
      try {
        URL urlInstance = new URL(url);
        connection = (HttpURLConnection) urlInstance.openConnection();
        setRequestProperties(connection);
      } catch (IOException e) {
        log.error(e.getMessage());
      }
      return connection;
    }
  }

  class ConcreteApiCall extends AbstractApiCall {

    @Override
    protected void setRequestProperties (HttpURLConnection connection) {
      connection.setRequestProperty("test", "test");
    }
  }


}
