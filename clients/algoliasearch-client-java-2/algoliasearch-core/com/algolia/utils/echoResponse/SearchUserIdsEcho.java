package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class SearchUserIdsEcho
  extends SearchUserIdsResponse
  implements EchoResponse {

  private Request request;

  public SearchUserIdsEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
