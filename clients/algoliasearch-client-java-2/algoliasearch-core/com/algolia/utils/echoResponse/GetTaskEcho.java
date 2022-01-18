package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class GetTaskEcho extends GetTaskResponse implements EchoResponse {

  private Request request;

  public GetTaskEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
