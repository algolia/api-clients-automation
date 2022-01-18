package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class GetRuleEcho extends Rule implements EchoResponse {

  private Request request;

  public GetRuleEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
