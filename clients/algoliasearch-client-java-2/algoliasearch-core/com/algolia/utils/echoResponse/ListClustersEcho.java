package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class ListClustersEcho
  extends ListClustersResponse
  implements EchoResponse {

  private Request request;

  public ListClustersEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
