package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class DeleteIndexEcho extends DeletedAtResponse implements EchoResponse {

  private Request request;

  public DeleteIndexEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
