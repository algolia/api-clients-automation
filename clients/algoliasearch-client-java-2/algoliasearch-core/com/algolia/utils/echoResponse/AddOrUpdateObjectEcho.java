package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class AddOrUpdateObjectEcho
  extends UpdatedAtWithObjectIdResponse
  implements EchoResponse {

  private Request request;

  public AddOrUpdateObjectEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
