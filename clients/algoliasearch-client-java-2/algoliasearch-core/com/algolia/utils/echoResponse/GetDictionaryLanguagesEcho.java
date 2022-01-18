package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import java.util.HashMap;
import okhttp3.Request;

public class GetDictionaryLanguagesEcho
  extends HashMap<String, Languages>
  implements EchoResponse {

  private Request request;

  public GetDictionaryLanguagesEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
