package com.algolia.config;

import com.fasterxml.jackson.databind.JavaType;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

public interface Requester extends AutoCloseable {
  Call newCall(Request request);

  <T> T handleResponse(Response response, JavaType returnType);
}
