package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class BatchEcho extends BatchResponse implements EchoResponse {

  private Request request;

  public BatchEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
