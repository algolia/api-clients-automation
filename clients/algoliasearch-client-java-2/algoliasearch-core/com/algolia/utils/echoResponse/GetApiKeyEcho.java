package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class GetApiKeyEcho extends KeyObject implements EchoResponse {

  private Request request;

  public GetApiKeyEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
