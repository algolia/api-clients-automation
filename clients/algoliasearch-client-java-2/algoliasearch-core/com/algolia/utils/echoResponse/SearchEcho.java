package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class SearchEcho extends SearchResponse implements EchoResponse {

  private Request request;

  public SearchEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
