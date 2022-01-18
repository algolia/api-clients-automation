package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class MultipleBatchEcho
  extends MultipleBatchResponse
  implements EchoResponse {

  private Request request;

  public MultipleBatchEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
