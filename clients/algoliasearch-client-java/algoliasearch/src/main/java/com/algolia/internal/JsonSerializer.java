package com.algolia.internal;

import com.algolia.exceptions.AlgoliaApiException;
import com.algolia.exceptions.AlgoliaRuntimeException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.io.IOException;
import java.util.function.Consumer;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;

/**
 * Utility class for JSON serialization and deserialization using Jackson. It provides functionality
 * to convert Java objects to their JSON representation and vice versa.
 */
public final class JsonSerializer {

  private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json");

  private final ObjectMapper mapper;

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Initializes a new JsonSerializer instance with a given ObjectMapper.
   *
   * @param mapper The Jackson ObjectMapper to be used for JSON operations.
   */
  JsonSerializer(@NotNull ObjectMapper mapper) {
    this.mapper = mapper;
  }

  /**
   * Serializes a Java object into its JSON representation and creates a RequestBody.
   *
   * @param object The Java object to serialize.
   * @return A RequestBody representing the JSON form of the provided object.
   */
  public RequestBody serialize(@NotNull Object object) {
    return new RequestBody() {
      @Override
      public MediaType contentType() {
        return JSON_MEDIA_TYPE;
      }

      @Override
      public void writeTo(@NotNull BufferedSink bufferedSink) {
        try {
          mapper.writeValue(bufferedSink.outputStream(), object);
        } catch (IOException e) {
          throw new AlgoliaRuntimeException(e);
        }
      }
    };
  }

  /**
   * Deserializes a JSON ResponseBody into a Java object of a given type.
   *
   * @param response The ResponseBody containing the JSON to deserialize.
   * @param returnType The JavaType representation of the desired return object.
   * @return The deserialized object of the given type.
   */
  public <T> T deserialize(Response response, JavaType returnType) {
    try (ResponseBody responseBody = response.body()) {
      if (response.isSuccessful()) {
        if (returnType == null || responseBody == null) {
          return null; // No need to deserialize, either no content or no type provided
        }
        return deserializeJsonBody(responseBody, returnType);
      }
      throw new AlgoliaApiException(response.message(), response.code());
    } catch (IOException e) {
      throw new AlgoliaRuntimeException(e);
    } catch (Exception e) {
      throw new AlgoliaApiException(response.message(), e, response.code());
    }
  }

  /** Deserialize ResponseBody to the provided JavaType (T). */
  private <T> T deserializeJsonBody(ResponseBody responseBody, JavaType returnType) throws IOException {
    if (byte[].class.equals(returnType.getRawClass())) {
      return (T) responseBody.bytes();
    }
    if (responseBody.contentLength() == 0) {
      return null;
    }
    return mapper.readValue(responseBody.byteStream(), returnType);
  }

  /**
   * Constructs a JavaType representation for a class with parameterized types.
   *
   * @param returnType The main class type.
   * @param innerType The parameterized type.
   * @return A JavaType representation of the parameterized class.
   */
  public JavaType getJavaType(@NotNull Class<?> returnType, @NotNull Class<?> innerType) {
    return mapper.getTypeFactory().constructParametricType(returnType, innerType);
  }

  /**
   * Constructs a JavaType representation for a class.
   *
   * @param returnType The main class type.
   * @return A JavaType representation of the parameterized class.
   */
  public JavaType getJavaType(@NotNull TypeReference<?> returnType) {
    return mapper.getTypeFactory().constructType(returnType);
  }

  public static class Builder {

    /**
     * A custom configuration for the JsonMapper builder, allowing clients to customize the built
     * ObjectMapper beyond the default settings provided in this class.
     */
    private Consumer<JsonMapper.Builder> customerConfig;

    /**
     * Sets a custom configuration to be applied to the JsonMapper builder.
     *
     * @param config A consumer function that specifies additional configurations for the JsonMapper
     *     builder.
     * @return The current JsonConfig instance, useful for method chaining.
     */
    public Builder setCustomConfig(Consumer<JsonMapper.Builder> config) {
      this.customerConfig = config;
      return this;
    }

    /** Builds JsonSerializer instance. */
    public JsonSerializer build() {
      JsonMapper.Builder builder = JsonMapper
        .builder()
        .disable(MapperFeature.ALLOW_COERCION_OF_SCALARS)
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        .enable(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)
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
      JsonMapper build = builder.build();
      return new JsonSerializer(build);
    }
  }
}
