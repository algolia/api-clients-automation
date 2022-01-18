package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class BatchDictionaryEntriesEcho
  extends UpdatedAtResponse
  implements EchoResponse {

  private Request request;

  public BatchDictionaryEntriesEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
