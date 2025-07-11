// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.api;

import com.algolia.ApiClient;
import com.algolia.config.*;
import com.algolia.config.ClientOptions;
import com.algolia.exceptions.*;
import com.algolia.model.insights.*;
import com.algolia.utils.*;
import com.fasterxml.jackson.core.type.TypeReference;
import java.time.Duration;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class InsightsClient extends ApiClient {

  private static final String[] allowedRegions = { "de", "us" };

  public InsightsClient(String appId, String apiKey) {
    this(appId, apiKey, null, null);
  }

  public InsightsClient(String appId, String apiKey, ClientOptions options) {
    this(appId, apiKey, null, options);
  }

  public InsightsClient(String appId, String apiKey, String region) {
    this(appId, apiKey, region, null);
  }

  public InsightsClient(String appId, String apiKey, String region, ClientOptions options) {
    super(
      appId,
      apiKey,
      "Insights",
      options,
      getDefaultHosts(region),
      Duration.ofMillis(2000L),
      Duration.ofMillis(5000L),
      Duration.ofMillis(30000L)
    );
  }

  private static List<Host> getDefaultHosts(String region) throws AlgoliaRuntimeException {
    List<Host> hosts = new ArrayList<>();

    boolean found = region == null;
    if (region != null) {
      for (String allowed : allowedRegions) {
        if (allowed.equals(region)) {
          found = true;
          break;
        }
      }
    }

    if (!found) {
      throw new AlgoliaRuntimeException("`region` must be one of the following: de, us");
    }

    String url = region == null ? "insights.algolia.io" : "insights.{region}.algolia.io".replace("{region}", region);

    hosts.add(new Host(url, EnumSet.of(CallType.READ, CallType.WRITE)));
    return hosts;
  }

  /**
   * This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param parameters Query parameters to apply to the current query. (optional)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public Object customDelete(@Nonnull String path, Map<String, Object> parameters, @Nullable RequestOptions requestOptions)
    throws AlgoliaRuntimeException {
    return LaunderThrowable.await(customDeleteAsync(path, parameters, requestOptions));
  }

  /**
   * This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param parameters Query parameters to apply to the current query. (optional)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public Object customDelete(@Nonnull String path, Map<String, Object> parameters) throws AlgoliaRuntimeException {
    return this.customDelete(path, parameters, null);
  }

  /**
   * This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public Object customDelete(@Nonnull String path, @Nullable RequestOptions requestOptions) throws AlgoliaRuntimeException {
    return this.customDelete(path, null, requestOptions);
  }

  /**
   * This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public Object customDelete(@Nonnull String path) throws AlgoliaRuntimeException {
    return this.customDelete(path, null, null);
  }

  /**
   * (asynchronously) This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param parameters Query parameters to apply to the current query. (optional)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Object> customDeleteAsync(
    @Nonnull String path,
    Map<String, Object> parameters,
    @Nullable RequestOptions requestOptions
  ) throws AlgoliaRuntimeException {
    Parameters.requireNonNull(path, "Parameter `path` is required when calling `customDelete`.");

    HttpRequest request = HttpRequest.builder().setPathEncoded("/{path}", path).setMethod("DELETE").addQueryParameters(parameters).build();
    return executeAsync(request, requestOptions, new TypeReference<Object>() {});
  }

  /**
   * (asynchronously) This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param parameters Query parameters to apply to the current query. (optional)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Object> customDeleteAsync(@Nonnull String path, Map<String, Object> parameters) throws AlgoliaRuntimeException {
    return this.customDeleteAsync(path, parameters, null);
  }

  /**
   * (asynchronously) This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Object> customDeleteAsync(@Nonnull String path, @Nullable RequestOptions requestOptions)
    throws AlgoliaRuntimeException {
    return this.customDeleteAsync(path, null, requestOptions);
  }

  /**
   * (asynchronously) This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Object> customDeleteAsync(@Nonnull String path) throws AlgoliaRuntimeException {
    return this.customDeleteAsync(path, null, null);
  }

  /**
   * This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param parameters Query parameters to apply to the current query. (optional)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public Object customGet(@Nonnull String path, Map<String, Object> parameters, @Nullable RequestOptions requestOptions)
    throws AlgoliaRuntimeException {
    return LaunderThrowable.await(customGetAsync(path, parameters, requestOptions));
  }

  /**
   * This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param parameters Query parameters to apply to the current query. (optional)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public Object customGet(@Nonnull String path, Map<String, Object> parameters) throws AlgoliaRuntimeException {
    return this.customGet(path, parameters, null);
  }

  /**
   * This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public Object customGet(@Nonnull String path, @Nullable RequestOptions requestOptions) throws AlgoliaRuntimeException {
    return this.customGet(path, null, requestOptions);
  }

  /**
   * This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public Object customGet(@Nonnull String path) throws AlgoliaRuntimeException {
    return this.customGet(path, null, null);
  }

  /**
   * (asynchronously) This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param parameters Query parameters to apply to the current query. (optional)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Object> customGetAsync(
    @Nonnull String path,
    Map<String, Object> parameters,
    @Nullable RequestOptions requestOptions
  ) throws AlgoliaRuntimeException {
    Parameters.requireNonNull(path, "Parameter `path` is required when calling `customGet`.");

    HttpRequest request = HttpRequest.builder().setPathEncoded("/{path}", path).setMethod("GET").addQueryParameters(parameters).build();
    return executeAsync(request, requestOptions, new TypeReference<Object>() {});
  }

  /**
   * (asynchronously) This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param parameters Query parameters to apply to the current query. (optional)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Object> customGetAsync(@Nonnull String path, Map<String, Object> parameters) throws AlgoliaRuntimeException {
    return this.customGetAsync(path, parameters, null);
  }

  /**
   * (asynchronously) This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Object> customGetAsync(@Nonnull String path, @Nullable RequestOptions requestOptions)
    throws AlgoliaRuntimeException {
    return this.customGetAsync(path, null, requestOptions);
  }

  /**
   * (asynchronously) This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Object> customGetAsync(@Nonnull String path) throws AlgoliaRuntimeException {
    return this.customGetAsync(path, null, null);
  }

  /**
   * This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param parameters Query parameters to apply to the current query. (optional)
   * @param body Parameters to send with the custom request. (optional)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public Object customPost(@Nonnull String path, Map<String, Object> parameters, Object body, @Nullable RequestOptions requestOptions)
    throws AlgoliaRuntimeException {
    return LaunderThrowable.await(customPostAsync(path, parameters, body, requestOptions));
  }

  /**
   * This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param parameters Query parameters to apply to the current query. (optional)
   * @param body Parameters to send with the custom request. (optional)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public Object customPost(@Nonnull String path, Map<String, Object> parameters, Object body) throws AlgoliaRuntimeException {
    return this.customPost(path, parameters, body, null);
  }

  /**
   * This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public Object customPost(@Nonnull String path, @Nullable RequestOptions requestOptions) throws AlgoliaRuntimeException {
    return this.customPost(path, null, null, requestOptions);
  }

  /**
   * This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public Object customPost(@Nonnull String path) throws AlgoliaRuntimeException {
    return this.customPost(path, null, null, null);
  }

  /**
   * (asynchronously) This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param parameters Query parameters to apply to the current query. (optional)
   * @param body Parameters to send with the custom request. (optional)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Object> customPostAsync(
    @Nonnull String path,
    Map<String, Object> parameters,
    Object body,
    @Nullable RequestOptions requestOptions
  ) throws AlgoliaRuntimeException {
    Parameters.requireNonNull(path, "Parameter `path` is required when calling `customPost`.");

    HttpRequest request = HttpRequest.builder()
      .setPathEncoded("/{path}", path)
      .setMethod("POST")
      .setBody(body)
      .addQueryParameters(parameters)
      .build();
    return executeAsync(request, requestOptions, new TypeReference<Object>() {});
  }

  /**
   * (asynchronously) This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param parameters Query parameters to apply to the current query. (optional)
   * @param body Parameters to send with the custom request. (optional)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Object> customPostAsync(@Nonnull String path, Map<String, Object> parameters, Object body)
    throws AlgoliaRuntimeException {
    return this.customPostAsync(path, parameters, body, null);
  }

  /**
   * (asynchronously) This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Object> customPostAsync(@Nonnull String path, @Nullable RequestOptions requestOptions)
    throws AlgoliaRuntimeException {
    return this.customPostAsync(path, null, null, requestOptions);
  }

  /**
   * (asynchronously) This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Object> customPostAsync(@Nonnull String path) throws AlgoliaRuntimeException {
    return this.customPostAsync(path, null, null, null);
  }

  /**
   * This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param parameters Query parameters to apply to the current query. (optional)
   * @param body Parameters to send with the custom request. (optional)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public Object customPut(@Nonnull String path, Map<String, Object> parameters, Object body, @Nullable RequestOptions requestOptions)
    throws AlgoliaRuntimeException {
    return LaunderThrowable.await(customPutAsync(path, parameters, body, requestOptions));
  }

  /**
   * This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param parameters Query parameters to apply to the current query. (optional)
   * @param body Parameters to send with the custom request. (optional)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public Object customPut(@Nonnull String path, Map<String, Object> parameters, Object body) throws AlgoliaRuntimeException {
    return this.customPut(path, parameters, body, null);
  }

  /**
   * This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public Object customPut(@Nonnull String path, @Nullable RequestOptions requestOptions) throws AlgoliaRuntimeException {
    return this.customPut(path, null, null, requestOptions);
  }

  /**
   * This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public Object customPut(@Nonnull String path) throws AlgoliaRuntimeException {
    return this.customPut(path, null, null, null);
  }

  /**
   * (asynchronously) This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param parameters Query parameters to apply to the current query. (optional)
   * @param body Parameters to send with the custom request. (optional)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Object> customPutAsync(
    @Nonnull String path,
    Map<String, Object> parameters,
    Object body,
    @Nullable RequestOptions requestOptions
  ) throws AlgoliaRuntimeException {
    Parameters.requireNonNull(path, "Parameter `path` is required when calling `customPut`.");

    HttpRequest request = HttpRequest.builder()
      .setPathEncoded("/{path}", path)
      .setMethod("PUT")
      .setBody(body)
      .addQueryParameters(parameters)
      .build();
    return executeAsync(request, requestOptions, new TypeReference<Object>() {});
  }

  /**
   * (asynchronously) This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param parameters Query parameters to apply to the current query. (optional)
   * @param body Parameters to send with the custom request. (optional)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Object> customPutAsync(@Nonnull String path, Map<String, Object> parameters, Object body)
    throws AlgoliaRuntimeException {
    return this.customPutAsync(path, parameters, body, null);
  }

  /**
   * (asynchronously) This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Object> customPutAsync(@Nonnull String path, @Nullable RequestOptions requestOptions)
    throws AlgoliaRuntimeException {
    return this.customPutAsync(path, null, null, requestOptions);
  }

  /**
   * (asynchronously) This method lets you send requests to the Algolia REST API.
   *
   * @param path Path of the endpoint, for example `1/newFeature`. (required)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Object> customPutAsync(@Nonnull String path) throws AlgoliaRuntimeException {
    return this.customPutAsync(path, null, null, null);
  }

  /**
   * Deletes all events related to the specified user token from events metrics and analytics. The
   * deletion is asynchronous, and processed within 48 hours. To delete a personalization user
   * profile, see `Delete a user profile` in the Personalization API.
   *
   * @param userToken User token for which to delete all associated events. (required)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public void deleteUserToken(@Nonnull String userToken, @Nullable RequestOptions requestOptions) throws AlgoliaRuntimeException {
    LaunderThrowable.await(deleteUserTokenAsync(userToken, requestOptions));
    return;
  }

  /**
   * Deletes all events related to the specified user token from events metrics and analytics. The
   * deletion is asynchronous, and processed within 48 hours. To delete a personalization user
   * profile, see `Delete a user profile` in the Personalization API.
   *
   * @param userToken User token for which to delete all associated events. (required)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public void deleteUserToken(@Nonnull String userToken) throws AlgoliaRuntimeException {
    this.deleteUserToken(userToken, null);
  }

  /**
   * (asynchronously) Deletes all events related to the specified user token from events metrics and
   * analytics. The deletion is asynchronous, and processed within 48 hours. To delete a
   * personalization user profile, see `Delete a user profile` in the Personalization API.
   *
   * @param userToken User token for which to delete all associated events. (required)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Void> deleteUserTokenAsync(@Nonnull String userToken, @Nullable RequestOptions requestOptions)
    throws AlgoliaRuntimeException {
    Parameters.requireNonNull(userToken, "Parameter `userToken` is required when calling `deleteUserToken`.");

    HttpRequest request = HttpRequest.builder().setPath("/1/usertokens/{userToken}", userToken).setMethod("DELETE").build();
    return executeAsync(request, requestOptions, null);
  }

  /**
   * (asynchronously) Deletes all events related to the specified user token from events metrics and
   * analytics. The deletion is asynchronous, and processed within 48 hours. To delete a
   * personalization user profile, see `Delete a user profile` in the Personalization API.
   *
   * @param userToken User token for which to delete all associated events. (required)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<Void> deleteUserTokenAsync(@Nonnull String userToken) throws AlgoliaRuntimeException {
    return this.deleteUserTokenAsync(userToken, null);
  }

  /**
   * Sends a list of events to the Insights API. You can include up to 1,000 events in a single
   * request, but the request body must be smaller than 2&nbsp;MB.
   *
   * @param insightsEvents (required)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public EventsResponse pushEvents(@Nonnull InsightsEvents insightsEvents, @Nullable RequestOptions requestOptions)
    throws AlgoliaRuntimeException {
    return LaunderThrowable.await(pushEventsAsync(insightsEvents, requestOptions));
  }

  /**
   * Sends a list of events to the Insights API. You can include up to 1,000 events in a single
   * request, but the request body must be smaller than 2&nbsp;MB.
   *
   * @param insightsEvents (required)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public EventsResponse pushEvents(@Nonnull InsightsEvents insightsEvents) throws AlgoliaRuntimeException {
    return this.pushEvents(insightsEvents, null);
  }

  /**
   * (asynchronously) Sends a list of events to the Insights API. You can include up to 1,000 events
   * in a single request, but the request body must be smaller than 2&nbsp;MB.
   *
   * @param insightsEvents (required)
   * @param requestOptions The requestOptions to send along with the query, they will be merged with
   *     the transporter requestOptions.
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<EventsResponse> pushEventsAsync(@Nonnull InsightsEvents insightsEvents, @Nullable RequestOptions requestOptions)
    throws AlgoliaRuntimeException {
    Parameters.requireNonNull(insightsEvents, "Parameter `insightsEvents` is required when calling `pushEvents`.");

    HttpRequest request = HttpRequest.builder().setPath("/1/events").setMethod("POST").setBody(insightsEvents).build();
    return executeAsync(request, requestOptions, new TypeReference<EventsResponse>() {});
  }

  /**
   * (asynchronously) Sends a list of events to the Insights API. You can include up to 1,000 events
   * in a single request, but the request body must be smaller than 2&nbsp;MB.
   *
   * @param insightsEvents (required)
   * @throws AlgoliaRuntimeException If it fails to process the API call
   */
  public CompletableFuture<EventsResponse> pushEventsAsync(@Nonnull InsightsEvents insightsEvents) throws AlgoliaRuntimeException {
    return this.pushEventsAsync(insightsEvents, null);
  }
}
