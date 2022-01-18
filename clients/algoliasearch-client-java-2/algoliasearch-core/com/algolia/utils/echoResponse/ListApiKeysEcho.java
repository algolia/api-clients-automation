package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class ListApiKeysEcho
  extends ListApiKeysResponse
  implements EchoResponse {

  private Request request;

  public ListApiKeysEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
