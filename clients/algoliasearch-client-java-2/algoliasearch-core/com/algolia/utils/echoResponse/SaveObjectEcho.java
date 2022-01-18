package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class SaveObjectEcho extends SaveObjectResponse implements EchoResponse {

  private Request request;

  public SaveObjectEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
