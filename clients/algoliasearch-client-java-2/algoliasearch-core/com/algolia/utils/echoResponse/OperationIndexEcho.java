package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class OperationIndexEcho
  extends UpdatedAtResponse
  implements EchoResponse {

  private Request request;

  public OperationIndexEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
