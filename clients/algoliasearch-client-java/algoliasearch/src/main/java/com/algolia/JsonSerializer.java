package com.algolia;

import com.algolia.exceptions.AlgoliaApiException;
import com.algolia.exceptions.AlgoliaRuntimeException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
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
final class JsonSerializer {

  private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json");

  private final ObjectMapper mapper;

  /**
   * Initializes a new JsonSerializer instance with a given ObjectMapper.
   *
   * @param mapper The Jackson ObjectMapper to be used for JSON operations.
   */
  public JsonSerializer(@NotNull ObjectMapper mapper) {
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
}
