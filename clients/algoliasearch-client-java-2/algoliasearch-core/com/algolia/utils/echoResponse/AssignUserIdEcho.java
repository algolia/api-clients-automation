package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class AssignUserIdEcho
  extends CreatedAtResponse
  implements EchoResponse {

  private Request request;

  public AssignUserIdEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
