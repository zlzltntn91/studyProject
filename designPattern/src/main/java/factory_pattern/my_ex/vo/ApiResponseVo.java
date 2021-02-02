package factory_pattern.my_ex.vo;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.ToString;

@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiResponseVo {
  
  private String resultCode;
  private String resultMessage;
  private String code;
  private String message;
  private String responseBody;
  private String description;

  public String getResultCode() {
    return resultCode;
  }

  public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
  }

  public String getResultMessage() {
    return resultMessage;
  }

  public void setResultMessage(String resultMessage) {
    this.resultMessage = resultMessage;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getResponseBody() {
    return responseBody;
  }

  public void setResponseBody(String responseBody) {
    this.responseBody = responseBody;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}

