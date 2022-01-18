package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class MultipleQueriesEcho
  extends MultipleQueriesResponse
  implements EchoResponse {

  private Request request;

  public MultipleQueriesEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
