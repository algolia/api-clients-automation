package com.algolia.utils.echo;

import com.algolia.utils.JSON;
import com.algolia.Pair;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.Timeout;

public class CallEcho implements Call {

  private final Request request;

  public CallEcho(Request request) {
    this.request = request;
  }

  @Override
  public Request request() {
    return request;
  }

  @Override
  public void cancel() {}

  @Override
  public Call clone() {
    return null;
  }

  private List<Pair> buildQueryParams() {
    List<Pair> params = new ArrayList<Pair>();
    HttpUrl url = request.url();
    for (String name : url.queryParameterNames()) {
      for (String value : url.queryParameterValues(name)) {
        params.add(new Pair(name, value));
      }
    }
    return params;
  }

  @Override
  public void enqueue(Callback callback) {
    Response.Builder builder = new Response.Builder();
    builder.code(200);
    builder.request(request);
    builder.protocol(Protocol.HTTP_2);
    builder.message("EchoRequest");
    try {
      JsonObject body = new JsonObject();
      body.addProperty("path", request.url().encodedPath());
      body.addProperty("method", request.method());
      body.add(
        "queryParameters",
        (JsonArray) JSON.deserialize(
          JSON.serialize(buildQueryParams()),
          JsonArray.class
        )
      );
      try {
        final Request copy = request.newBuilder().build();
        final Buffer buffer = new Buffer();
        if (copy.body() == null) {
          body.addProperty("body", "");
        } else {
          copy.body().writeTo(buffer);
          body.addProperty("body", buffer.readUtf8());
        }
      } catch (final IOException e) {
        body.addProperty("body", "error");
      }
      System.out.println(body);
      builder.body(
        ResponseBody.create(
          JSON.serialize(body),
          MediaType.parse("application/json")
        )
      );
      callback.onResponse(this, builder.build());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public Response execute() throws IOException {
    return null;
  }

  @Override
  public boolean isExecuted() {
    return false;
  }

  @Override
  public boolean isCanceled() {
    return false;
  }

  @Override
  public Timeout timeout() {
    return null;
  }
}
