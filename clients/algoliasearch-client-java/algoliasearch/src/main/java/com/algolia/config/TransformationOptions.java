package com.algolia.config;

import com.algolia.exceptions.AlgoliaRuntimeException;
import com.algolia.internal.HttpRequester;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import javax.annotation.Nonnull;

/**
 * Configuration options for the ingestion transporter used by {@code *WithTransformation} helpers.
 *
 * <p>When set on {@link ClientOptions}, the search client eagerly creates an ingestion transporter
 * using Ingestion API defaults (25 s connect/read/write timeouts, region-derived hosts, no
 * compression). Only the fields explicitly set here override those defaults; the parent search
 * {@link ClientOptions} is never forwarded to the ingestion transporter.
 */
public final class TransformationOptions {

  private final String region;
  private Duration connectTimeout;
  private Duration readTimeout;
  private Duration writeTimeout;
  private List<Host> hosts;
  private CompressionType compressionType;
  private Map<String, String> defaultHeaders;
  private Requester customRequester;
  private Logger logger;
  private LogLevel logLevel;
  private Consumer<HttpRequester.Builder> requesterConfig;
  private Consumer<JsonMapper.Builder> mapperConfig;

  /**
   * @param region Algolia region for the Ingestion API (e.g. {@code "us"} or {@code "eu"}).
   *     Required.
   */
  public TransformationOptions(@Nonnull String region) {
    if (region == null || region.isEmpty()) {
      throw new AlgoliaRuntimeException(
          "region is required in transformationOptions."
              + " See https://www.algolia.com/doc/api-client/methods/push/#transformation-options");
    }
    this.region = region;
  }

  public String getRegion() {
    return region;
  }

  public TransformationOptions setConnectTimeout(Duration connectTimeout) {
    this.connectTimeout = connectTimeout;
    return this;
  }

  public TransformationOptions setReadTimeout(Duration readTimeout) {
    this.readTimeout = readTimeout;
    return this;
  }

  public TransformationOptions setWriteTimeout(Duration writeTimeout) {
    this.writeTimeout = writeTimeout;
    return this;
  }

  public TransformationOptions setHosts(List<Host> hosts) {
    this.hosts = hosts;
    return this;
  }

  public TransformationOptions setCompressionType(CompressionType compressionType) {
    this.compressionType = compressionType;
    return this;
  }

  public TransformationOptions addDefaultHeader(String key, String value) {
    if (this.defaultHeaders == null) {
      this.defaultHeaders = new HashMap<>();
    }
    this.defaultHeaders.put(key, value);
    return this;
  }

  public TransformationOptions setCustomRequester(Requester customRequester) {
    this.customRequester = customRequester;
    return this;
  }

  public TransformationOptions setLogger(Logger logger) {
    this.logger = logger;
    return this;
  }

  public TransformationOptions setLogLevel(LogLevel logLevel) {
    this.logLevel = logLevel;
    return this;
  }

  public TransformationOptions setRequesterConfig(Consumer<HttpRequester.Builder> requesterConfig) {
    this.requesterConfig = requesterConfig;
    return this;
  }

  public TransformationOptions setMapperConfig(Consumer<JsonMapper.Builder> mapperConfig) {
    this.mapperConfig = mapperConfig;
    return this;
  }

  /**
   * Converts the explicitly-set fields into a {@link ClientOptions}. Fields that were not set
   * remain at {@link ClientOptions.Builder} defaults ({@code Duration.ZERO} for timeouts), which
   * causes the {@code IngestionClient} constructor to apply its own 25 s defaults.
   */
  public ClientOptions toClientOptions() {
    ClientOptions.Builder builder = ClientOptions.builder();
    if (connectTimeout != null) builder.setConnectTimeout(connectTimeout);
    if (readTimeout != null) builder.setReadTimeout(readTimeout);
    if (writeTimeout != null) builder.setWriteTimeout(writeTimeout);
    if (hosts != null) builder.setHosts(hosts);
    if (compressionType != null) builder.setCompressionType(compressionType);
    if (customRequester != null) builder.setCustomRequester(customRequester);
    if (logger != null) builder.setLogger(logger);
    if (logLevel != null) builder.setLogLevel(logLevel);
    if (requesterConfig != null) builder.setRequesterConfig(requesterConfig);
    if (mapperConfig != null) builder.setMapperConfig(mapperConfig);
    if (defaultHeaders != null) {
      for (Map.Entry<String, String> entry : defaultHeaders.entrySet()) {
        builder.addDefaultHeader(entry.getKey(), entry.getValue());
      }
    }
    return builder.build();
  }
}
