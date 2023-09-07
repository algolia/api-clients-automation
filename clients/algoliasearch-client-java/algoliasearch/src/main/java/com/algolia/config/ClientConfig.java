package com.algolia.config;

import javax.annotation.Nonnull;
import java.time.Duration;
import java.util.Map;

public interface ClientConfig {
  public @Nonnull LogLevel getLogLevel();

  public Logger getLogger();

  public @Nonnull Duration getConnectTimeout();

  public @Nonnull Duration getWriteTimeout();

  public @Nonnull Duration getReadTimeout();

  public @Nonnull Map<String, String> getDefaultHeaders();

  public @Nonnull CompressionType getCompressionType();
}
