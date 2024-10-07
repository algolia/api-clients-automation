// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.recommend;

import com.algolia.exceptions.AlgoliaRuntimeException;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Whether [typo
 * tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/)
 * is enabled and how it is applied. If typo tolerance is true, `min`, or `strict`, [word splitting
 * and
 * concatenation](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/splitting-and-concatenation/)
 * are also active.
 */
@JsonDeserialize(using = TypoTolerance.Deserializer.class)
public interface TypoTolerance {
  // TypoTolerance as Boolean wrapper.
  static TypoTolerance of(Boolean value) {
    return new BooleanWrapper(value);
  }

  // TypoTolerance as Boolean wrapper.
  @JsonSerialize(using = BooleanWrapper.Serializer.class)
  class BooleanWrapper implements TypoTolerance {

    private final Boolean value;

    BooleanWrapper(Boolean value) {
      this.value = value;
    }

    public Boolean getValue() {
      return value;
    }

    static class Serializer extends JsonSerializer<BooleanWrapper> {

      @Override
      public void serialize(BooleanWrapper value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeObject(value.getValue());
      }
    }
  }

  class Deserializer extends JsonDeserializer<TypoTolerance> {

    private static final Logger LOGGER = Logger.getLogger(Deserializer.class.getName());

    @Override
    public TypoTolerance deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
      JsonNode tree = jp.readValueAsTree();
      // deserialize Boolean
      if (tree.isBoolean()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          Boolean value = parser.readValueAs(Boolean.class);
          return new TypoTolerance.BooleanWrapper(value);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf Boolean (error: " + e.getMessage() + ") (type: Boolean)");
        }
      }
      // deserialize TypoToleranceEnum
      if (tree.isTextual()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          return parser.readValueAs(TypoToleranceEnum.class);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf TypoToleranceEnum (error: " + e.getMessage() + ") (type: TypoToleranceEnum)");
        }
      }
      throw new AlgoliaRuntimeException(String.format("Failed to deserialize json element: %s", tree));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public TypoTolerance getNullValue(DeserializationContext ctxt) throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "TypoTolerance cannot be null");
    }
  }
}
