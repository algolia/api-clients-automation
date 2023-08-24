package com.algolia.utils;

import com.algolia.utils.retry.StatefulHost;
import com.fasterxml.jackson.databind.JavaType;
import java.util.List;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

public interface Requester extends AutoCloseable {
  public Call newCall(Request request);

  public <T> T handleResponse(Response response, JavaType returnType);

  public void setHosts(List<StatefulHost> hosts);
}
