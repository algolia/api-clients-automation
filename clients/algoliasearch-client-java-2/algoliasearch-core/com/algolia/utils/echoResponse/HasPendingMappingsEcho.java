package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class HasPendingMappingsEcho
  extends CreatedAtResponse
  implements EchoResponse {

  private Request request;

  public HasPendingMappingsEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
