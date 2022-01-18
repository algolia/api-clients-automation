package com.algolia.utils.echoResponse;

import com.algolia.model.*;
import okhttp3.Request;

public class SearchForFacetValuesEcho
  extends SearchForFacetValuesResponse
  implements EchoResponse {

  private Request request;

  public SearchForFacetValuesEcho(Request request) {
    this.request = request;
  }

  public String getPath() {
    return request.url().encodedPath();
  }
}
