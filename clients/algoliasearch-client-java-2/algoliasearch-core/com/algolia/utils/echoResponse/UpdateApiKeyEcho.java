package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class UpdateApiKeyEcho
  extends UpdateApiKeyResponse
  implements EchoResponse {

  private Request request;

  public UpdateApiKeyEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
