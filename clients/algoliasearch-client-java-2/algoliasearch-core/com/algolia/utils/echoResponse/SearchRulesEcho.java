package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class SearchRulesEcho
  extends SearchRulesResponse
  implements EchoResponse {

  private Request request;

  public SearchRulesEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
