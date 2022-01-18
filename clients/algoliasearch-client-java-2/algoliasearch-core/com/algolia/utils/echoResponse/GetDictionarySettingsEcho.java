package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class GetDictionarySettingsEcho
  extends GetDictionarySettingsResponse
  implements EchoResponse {

  private Request request;

  public GetDictionarySettingsEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
