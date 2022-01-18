package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import java.util.ArrayList;
import okhttp3.Request;

public class GetSourcesEcho extends ArrayList<Source> implements EchoResponse {

  private Request request;

  public GetSourcesEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
