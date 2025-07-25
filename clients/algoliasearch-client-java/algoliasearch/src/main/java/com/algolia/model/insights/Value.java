// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.insights;

import com.algolia.exceptions.AlgoliaRuntimeException;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Total monetary value of this event in units of `currency`. This should be equal to the sum of
 * `price` times `quantity`.
 */
@JsonDeserialize(using = Value.Deserializer.class)
public interface Value {
  // Value as Double wrapper.
  static Value of(Double value) {
    return new DoubleWrapper(value);
  }

  // Value as String wrapper.
  static Value of(String value) {
    return new StringWrapper(value);
  }

  // Value as Double wrapper.
  @JsonSerialize(using = DoubleWrapper.Serializer.class)
  class DoubleWrapper implements Value {

    private final Double value;

    DoubleWrapper(Double value) {
      this.value = value;
    }

    public Double getValue() {
      return value;
    }

    static class Serializer extends JsonSerializer<DoubleWrapper> {

      @Override
      public void serialize(DoubleWrapper value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeObject(value.getValue());
      }
    }
  }

  // Value as String wrapper.
  @JsonSerialize(using = StringWrapper.Serializer.class)
  class StringWrapper implements Value {

    private final String value;

    StringWrapper(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    static class Serializer extends JsonSerializer<StringWrapper> {

      @Override
      public void serialize(StringWrapper value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeObject(value.getValue());
      }
    }
  }

  class Deserializer extends JsonDeserializer<Value> {

    private static final Logger LOGGER = Logger.getLogger(Deserializer.class.getName());

    @Override
    public Value deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
      JsonNode tree = jp.readValueAsTree();
      // deserialize Double
      if (tree.isDouble()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          Double value = parser.readValueAs(Double.class);
          return new Value.DoubleWrapper(value);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf Double (error: " + e.getMessage() + ") (type: Double)");
        }
      }
      // deserialize String
      if (tree.isTextual()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          String value = parser.readValueAs(String.class);
          return new Value.StringWrapper(value);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf String (error: " + e.getMessage() + ") (type: String)");
        }
      }
      throw new AlgoliaRuntimeException(String.format("Failed to deserialize json element: %s", tree));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public Value getNullValue(DeserializationContext ctxt) throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "Value cannot be null");
    }
  }
}
