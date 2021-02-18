package toby.restTemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Slf4j
public class Rest {

  public void getTest(){
    String url = "https://api.docuchain.kr";
    RestTemplate restTemplate = new RestTemplate();
    String result = restTemplate.getForObject(url, String.class);
    log.debug(result);
  }
}
