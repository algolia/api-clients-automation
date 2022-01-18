package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class SearchSynonymsEcho
  extends SearchSynonymsResponse
  implements EchoResponse {

  private Request request;

  public SearchSynonymsEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
