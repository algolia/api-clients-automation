package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class GetObjectsEcho extends GetObjectsResponse implements EchoResponse {

  private Request request;

  public GetObjectsEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
