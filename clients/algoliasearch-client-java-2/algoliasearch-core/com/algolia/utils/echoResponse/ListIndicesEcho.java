package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class ListIndicesEcho
  extends ListIndicesResponse
  implements EchoResponse {

  private Request request;

  public ListIndicesEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
