package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class GetTopUserIdsEcho
  extends GetTopUserIdsResponse
  implements EchoResponse {

  private Request request;

  public GetTopUserIdsEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
