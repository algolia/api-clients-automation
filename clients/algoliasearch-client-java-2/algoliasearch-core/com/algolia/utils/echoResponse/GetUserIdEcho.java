package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class GetUserIdEcho extends UserId implements EchoResponse {

  private Request request;

  public GetUserIdEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
