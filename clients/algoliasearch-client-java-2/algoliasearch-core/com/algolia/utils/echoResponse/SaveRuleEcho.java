package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class SaveRuleEcho extends UpdatedRuleResponse implements EchoResponse {

  private Request request;

  public SaveRuleEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
