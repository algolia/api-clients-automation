package com.algolia;

import static com.fasterxml.jackson.core.JsonGenerator.Feature;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.function.Consumer;

/**
 * A configuration utility for building customized instances of Jackson's ObjectMapper.
 * <p>
 * This class provides a base configuration for ObjectMapper, but also provides an option
 * for users to specify additional custom configurations via a Consumer functional interface.
 * </p>
 */
final class JsonConfig {

  /**
   * A custom configuration for the JsonMapper builder, allowing clients to customize
   * the built ObjectMapper beyond the default settings provided in this class.
   */
  private Consumer<JsonMapper.Builder> customerConfig;

  /**
   * Sets a custom configuration to be applied to the JsonMapper builder.
   *
   * @param config A consumer function that specifies additional configurations for the JsonMapper builder.
   * @return The current JsonConfig instance, useful for method chaining.
   */
  public JsonConfig setCustomConfig(Consumer<JsonMapper.Builder> config) {
    this.customerConfig = config;
    return this;
  }

  /**
   * Builds and returns a customized ObjectMapper based on the provided configurations.
   * <p>
   * The default configurations applied include settings like disabling coercion of scalars,
   * allowing automatic closing of JSON content, specifying how dates and enums are serialized/deserialized,
   * and more. If a custom configuration has been provided via {@link #setCustomConfig(Consumer)},
   * it is applied to the builder before the ObjectMapper is built.
   * </p>
   *
   * @return A customized instance of ObjectMapper.
   */
  public ObjectMapper build() {
    JsonMapper.Builder builder = JsonMapper
            .builder()
            .disable(MapperFeature.ALLOW_COERCION_OF_SCALARS)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .enable(Feature.AUTO_CLOSE_JSON_CONTENT)
            .enable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .disable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS)
            .disable(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS)
            .enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)
            .enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING)
            .serializationInclusion(JsonInclude.Include.NON_NULL);
    if (customerConfig != null) {
      customerConfig.accept(builder);
    }
    return builder.build();
  }
}
