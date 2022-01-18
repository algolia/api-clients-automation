package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class AddApiKeyEcho extends AddApiKeyResponse implements EchoResponse {

  private Request request;

  public AddApiKeyEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
