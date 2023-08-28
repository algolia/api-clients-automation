package com.algolia.transport;

import com.algolia.exceptions.AlgoliaApiException;
import com.algolia.exceptions.AlgoliaRuntimeException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Utility class for JSON serialization and deserialization using Jackson.
 * It provides functionality to convert Java objects to their JSON representation and vice versa.
 */
public class JsonSerializer {

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
     * Serializes a Java object into its JSON representation.
     *
     * @param obj The Java object to serialize.
     * @return A string representing the JSON form of the provided object.
     * @throws JsonProcessingException if there's an error during serialization.
     */
    public String serialize(@NotNull Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }


    /**
     * Deserializes a JSON ResponseBody into a Java object of a given type.
     *
     * @param response The ResponseBody containing the JSON to deserialize.
     * @param returnType   The JavaType representation of the desired return object.
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

    /**
     * Deserialize ResponseBody to the provided JavaType (T).
     */
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
     * @param innerType  The parameterized type.
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
