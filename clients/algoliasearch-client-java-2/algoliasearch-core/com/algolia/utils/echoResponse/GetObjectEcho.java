package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import java.util.HashMap;
import okhttp3.Request;

public class GetObjectEcho
  extends HashMap<String, String>
  implements EchoResponse {

  private Request request;

  public GetObjectEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
