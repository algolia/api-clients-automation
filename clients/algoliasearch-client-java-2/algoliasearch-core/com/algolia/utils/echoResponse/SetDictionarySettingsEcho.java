package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class SetDictionarySettingsEcho
  extends UpdatedAtResponse
  implements EchoResponse {

  private Request request;

  public SetDictionarySettingsEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
