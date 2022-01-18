package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class GetSynonymEcho extends SynonymHit implements EchoResponse {

  private Request request;

  public GetSynonymEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
