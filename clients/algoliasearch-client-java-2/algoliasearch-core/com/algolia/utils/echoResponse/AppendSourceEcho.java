package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class AppendSourceEcho
  extends CreatedAtResponse
  implements EchoResponse {

  private Request request;

  public AppendSourceEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
