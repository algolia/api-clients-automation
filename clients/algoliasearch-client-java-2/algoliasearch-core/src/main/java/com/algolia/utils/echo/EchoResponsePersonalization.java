package com.algolia.utils.echo;

import com.algolia.model.personalization.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okio.Buffer;

public class EchoResponsePersonalization {

  private static String parseRequestBody(Request req) {
    try {
      final Request copy = req.newBuilder().build();
      final Buffer buffer = new Buffer();
      copy.body().writeTo(buffer);
      return buffer.readUtf8();
    } catch (final IOException e) {
      return "error";
    }
  }

  private static Map<String, String> buildQueryParams(Request req) {
    Map<String, String> params = new HashMap<String, String>();
    HttpUrl url = req.url();
    for (String name : url.queryParameterNames()) {
      for (String value : url.queryParameterValues(name)) {
        params.put(name, value);
      }
    }
    return params;
  }

  public static class Del extends Object implements EchoResponseInterface {

    private Request request;

    public Del(Request request) {
      this.request = request;
    }

    public String getPath() {
      return request.url().encodedPath();
    }

    public String getMethod() {
      return request.method();
    }

    public String getBody() {
      return parseRequestBody(request);
    }

    public Map<String, String> getQueryParams() {
      return buildQueryParams(request);
    }

    // to satisfy CompoundType in case it's a parent
    public Object getInsideValue() {
      return null;
    }
  }

  public static class DeleteUserProfile
    extends DeleteUserProfileResponse
    implements EchoResponseInterface {

    private Request request;

    public DeleteUserProfile(Request request) {
      this.request = request;
    }

    public String getPath() {
      return request.url().encodedPath();
    }

    public String getMethod() {
      return request.method();
    }

    public String getBody() {
      return parseRequestBody(request);
    }

    public Map<String, String> getQueryParams() {
      return buildQueryParams(request);
    }

    // to satisfy CompoundType in case it's a parent
    public Object getInsideValue() {
      return null;
    }
  }

  public static class Get extends Object implements EchoResponseInterface {

    private Request request;

    public Get(Request request) {
      this.request = request;
    }

    public String getPath() {
      return request.url().encodedPath();
    }

    public String getMethod() {
      return request.method();
    }

    public String getBody() {
      return parseRequestBody(request);
    }

    public Map<String, String> getQueryParams() {
      return buildQueryParams(request);
    }

    // to satisfy CompoundType in case it's a parent
    public Object getInsideValue() {
      return null;
    }
  }

  public static class GetPersonalizationStrategy
    extends PersonalizationStrategyParams
    implements EchoResponseInterface {

    private Request request;

    public GetPersonalizationStrategy(Request request) {
      this.request = request;
    }

    public String getPath() {
      return request.url().encodedPath();
    }

    public String getMethod() {
      return request.method();
    }

    public String getBody() {
      return parseRequestBody(request);
    }

    public Map<String, String> getQueryParams() {
      return buildQueryParams(request);
    }

    // to satisfy CompoundType in case it's a parent
    public Object getInsideValue() {
      return null;
    }
  }

  public static class GetUserTokenProfile
    extends GetUserTokenResponse
    implements EchoResponseInterface {

    private Request request;

    public GetUserTokenProfile(Request request) {
      this.request = request;
    }

    public String getPath() {
      return request.url().encodedPath();
    }

    public String getMethod() {
      return request.method();
    }

    public String getBody() {
      return parseRequestBody(request);
    }

    public Map<String, String> getQueryParams() {
      return buildQueryParams(request);
    }

    // to satisfy CompoundType in case it's a parent
    public Object getInsideValue() {
      return null;
    }
  }

  public static class Post extends Object implements EchoResponseInterface {

    private Request request;

    public Post(Request request) {
      this.request = request;
    }

    public String getPath() {
      return request.url().encodedPath();
    }

    public String getMethod() {
      return request.method();
    }

    public String getBody() {
      return parseRequestBody(request);
    }

    public Map<String, String> getQueryParams() {
      return buildQueryParams(request);
    }

    // to satisfy CompoundType in case it's a parent
    public Object getInsideValue() {
      return null;
    }
  }

  public static class Put extends Object implements EchoResponseInterface {

    private Request request;

    public Put(Request request) {
      this.request = request;
    }

    public String getPath() {
      return request.url().encodedPath();
    }

    public String getMethod() {
      return request.method();
    }

    public String getBody() {
      return parseRequestBody(request);
    }

    public Map<String, String> getQueryParams() {
      return buildQueryParams(request);
    }

    // to satisfy CompoundType in case it's a parent
    public Object getInsideValue() {
      return null;
    }
  }

  public static class SetPersonalizationStrategy
    extends SetPersonalizationStrategyResponse
    implements EchoResponseInterface {

    private Request request;

    public SetPersonalizationStrategy(Request request) {
      this.request = request;
    }

    public String getPath() {
      return request.url().encodedPath();
    }

    public String getMethod() {
      return request.method();
    }

    public String getBody() {
      return parseRequestBody(request);
    }

    public Map<String, String> getQueryParams() {
      return buildQueryParams(request);
    }

    // to satisfy CompoundType in case it's a parent
    public Object getInsideValue() {
      return null;
    }
  }
}
