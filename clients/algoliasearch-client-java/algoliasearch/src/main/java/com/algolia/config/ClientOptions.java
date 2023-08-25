package com.algolia.config;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public final class ClientOptions implements ClientConfig {

  private final List<AlgoliaAgent.Segment> algoliaAgentSegments;
  private final List<Host> hosts;
  private final LogLevel logLevel;
  private final Duration connectTimeout;
  private final Duration writeTimeout;
  private final Duration readTimeout;
  private final Map<String, String> defaultHeaders;
  private final CompressionType compressionType;
  private final Requester customRequester;

  public ClientOptions() {
    this(new Builder());
  }

  ClientOptions(Builder builder) {
    this.algoliaAgentSegments = builder.algoliaAgentSegments;
    this.hosts = builder.hosts;
    this.customRequester = builder.customRequester;
    this.logLevel = builder.logLevel;
    this.connectTimeout = builder.connectTimeout;
    this.writeTimeout = builder.writeTimeout;
    this.readTimeout = builder.readTimeout;
    this.defaultHeaders = builder.defaultHeaders;
    this.compressionType = builder.compressionType;
  }

  @NotNull
  public List<AlgoliaAgent.Segment> getAlgoliaAgentSegments() {
    return algoliaAgentSegments;
  }

  public List<Host> getHosts() {
    return hosts;
  }

  @NotNull
  public LogLevel getLogLevel() {
    return logLevel;
  }

  @NotNull
  public Duration getConnectTimeout() {
    return connectTimeout;
  }

  @NotNull
  public Duration getWriteTimeout() {
    return writeTimeout;
  }

  @NotNull
  public Duration getReadTimeout() {
    return readTimeout;
  }

  @NotNull
  public Map<String, String> getDefaultHeaders() {
    return defaultHeaders;
  }

  @NotNull
  public CompressionType getCompressionType() {
    return compressionType;
  }

  public Requester getCustomRequester() {
    return customRequester;
  }

  public static class Builder {

    private Requester customRequester;
    private List<Host> hosts;
    private final List<AlgoliaAgent.Segment> algoliaAgentSegments = new ArrayList<>();
    private final Map<String, String> defaultHeaders = new HashMap<>();
    private LogLevel logLevel = LogLevel.NONE;
    private Duration connectTimeout = Duration.ofSeconds(2);
    private Duration writeTimeout = Duration.ofSeconds(30);
    private Duration readTimeout = Duration.ofSeconds(5);
    private CompressionType compressionType = CompressionType.GZIP;

    public Builder setRequester(Requester requester) {
      this.customRequester = requester;
      return this;
    }

    public Builder addAlgoliaAgentSegment(AlgoliaAgent.Segment segment) {
      this.algoliaAgentSegments.add(segment);
      return this;
    }

    public Builder addAlgoliaAgentSegments(List<AlgoliaAgent.Segment> segments) {
      this.algoliaAgentSegments.addAll(segments);
      return this;
    }

    public Builder addDefaultHeader(String header, String value) {
      this.defaultHeaders.put(header, value);
      return this;
    }

    public Builder setHosts(List<Host> hosts) {
      this.hosts = hosts;
      return this;
    }

    public Builder setLogLevel(LogLevel logLevel) {
      this.logLevel = logLevel;
      return this;
    }

    public Builder setConnectTimeout(Duration connectTimeout) {
      this.connectTimeout = connectTimeout;
      return this;
    }

    public Builder setWriteTimeout(Duration writeTimeout) {
      this.writeTimeout = writeTimeout;
      return this;
    }

    public Builder setReadTimeout(Duration readTimeout) {
      this.readTimeout = readTimeout;
      return this;
    }

    public Builder setCompressionType(CompressionType compressionType) {
      this.compressionType = compressionType;
      return this;
    }

    public ClientOptions build() {
      return new ClientOptions(this);
    }
  }
}
