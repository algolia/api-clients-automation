package com.algolia.config;

import com.algolia.exceptions.AlgoliaRuntimeException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Configuration options for the ingestion transporter used by {@code *WithTransformation} helpers.
 *
 * <p>When passed to a {@code SearchClient} constructor, an ingestion transporter is eagerly created
 * using Ingestion API defaults (25 s connect/read/write timeouts, region-derived hosts, no
 * compression). Pass a {@link ClientOptions} as the second argument to override specific defaults;
 * only the fields set there replace the Ingestion API defaults.
 */
public final class TransformationOptions {

  private final String region;
  private final ClientOptions clientOptions;

  /**
   * @param region Algolia region for the Ingestion API (e.g. {@code "us"} or {@code "eu"}).
   *     Required.
   */
  public TransformationOptions(@Nonnull String region) {
    this(region, null);
  }

  /**
   * @param region Algolia region for the Ingestion API (e.g. {@code "us"} or {@code "eu"}).
   *     Required.
   * @param clientOptions Optional {@link ClientOptions} forwarded to the ingestion transporter.
   *     Only fields explicitly set here override the Ingestion API defaults.
   */
  public TransformationOptions(@Nonnull String region, @Nullable ClientOptions clientOptions) {
    if (region == null || region.trim().isEmpty()) {
      throw new AlgoliaRuntimeException(
        "region is required in transformationOptions." + " See https://www.algolia.com/doc/libraries/sdk/methods/ingestion"
      );
    }
    this.region = region;
    this.clientOptions = clientOptions;
  }

  public String getRegion() {
    return region;
  }

  /** Returns the {@link ClientOptions} to forward to the ingestion transporter, or {@code null}. */
  @Nullable
  public ClientOptions getClientOptions() {
    return clientOptions;
  }
}
