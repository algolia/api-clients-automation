package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class PartialUpdateObjectEcho
  extends UpdatedAtWithObjectIdResponse
  implements EchoResponse {

  private Request request;

  public PartialUpdateObjectEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
