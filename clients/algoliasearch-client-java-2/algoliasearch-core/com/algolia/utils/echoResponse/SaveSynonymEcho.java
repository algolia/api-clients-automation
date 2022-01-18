package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class SaveSynonymEcho
  extends SaveSynonymResponse
  implements EchoResponse {

  private Request request;

  public SaveSynonymEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
