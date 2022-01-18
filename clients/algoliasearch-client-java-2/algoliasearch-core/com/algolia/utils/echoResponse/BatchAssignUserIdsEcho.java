package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class BatchAssignUserIdsEcho
  extends CreatedAtResponse
  implements EchoResponse {

  private Request request;

  public BatchAssignUserIdsEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
