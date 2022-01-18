package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class ReplaceSourcesEcho
  extends ReplaceSourceResponse
  implements EchoResponse {

  private Request request;

  public ReplaceSourcesEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
