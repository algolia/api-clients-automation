package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class ListUserIdsEcho
  extends ListUserIdsResponse
  implements EchoResponse {

  private Request request;

  public ListUserIdsEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
