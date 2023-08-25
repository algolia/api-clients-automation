package com.algolia.utils;

import com.algolia.utils.retry.StatefulHost;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ClientConfig {

    public @NotNull List<AlgoliaAgent.Segment> getAlgoliaAgentSegments();

    public @NotNull List<StatefulHost> getHosts();

    public @NotNull LogLevel getLogLevel();

    public @NotNull Duration getConnectTimeout();

    public @NotNull Duration getWriteTimeout();

    public @NotNull Duration getReadTimeout();

    public @NotNull Map<String, String> getDefaultHeaders();

    public @NotNull CompressionType getCompressionType();

    public @NotNull Set<AlgoliaAgent.Segment> getAgentSegments();
}
