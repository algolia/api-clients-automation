package com.algolia;

import static com.fasterxml.jackson.core.JsonGenerator.Feature;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.util.function.Consumer;

class JsonConfig {

  private Consumer<JsonMapper.Builder> customerConfig;

  public JsonConfig setCustomConfig(Consumer<JsonMapper.Builder> config) {
    this.customerConfig = config;
    return this;
  }

  public ObjectMapper build() {
      JsonMapper.Builder builder = JsonMapper.builder()
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
