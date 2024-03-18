// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.search;

import com.algolia.exceptions.AlgoliaRuntimeException;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Treat singular, plurals, and other forms of declensions as equivalent. You should only use this
 * feature for the languages used in your index.
 */
@JsonDeserialize(using = IgnorePlurals.Deserializer.class)
public interface IgnorePlurals {
  // IgnorePlurals as List<SupportedLanguage> wrapper.
  static IgnorePlurals of(List<SupportedLanguage> value) {
    return new ListOfSupportedLanguageWrapper(value);
  }

  // IgnorePlurals as Boolean wrapper.
  static IgnorePlurals of(Boolean value) {
    return new BooleanWrapper(value);
  }

  // IgnorePlurals as List<SupportedLanguage> wrapper.
  @JsonSerialize(using = ListOfSupportedLanguageWrapper.Serializer.class)
  class ListOfSupportedLanguageWrapper implements IgnorePlurals {

    private final List<SupportedLanguage> value;

    ListOfSupportedLanguageWrapper(List<SupportedLanguage> value) {
      this.value = value;
    }

    public List<SupportedLanguage> getValue() {
      return value;
    }

    static class Serializer extends JsonSerializer<ListOfSupportedLanguageWrapper> {

      @Override
      public void serialize(ListOfSupportedLanguageWrapper value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeObject(value.getValue());
      }
    }
  }

  // IgnorePlurals as Boolean wrapper.
  @JsonSerialize(using = BooleanWrapper.Serializer.class)
  class BooleanWrapper implements IgnorePlurals {

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

  class Deserializer extends JsonDeserializer<IgnorePlurals> {

    private static final Logger LOGGER = Logger.getLogger(Deserializer.class.getName());

    @Override
    public IgnorePlurals deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
      JsonNode tree = jp.readValueAsTree();
      // deserialize List<SupportedLanguage>
      if (tree.isArray()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          List<SupportedLanguage> value = parser.readValueAs(new TypeReference<List<SupportedLanguage>>() {});
          return new IgnorePlurals.ListOfSupportedLanguageWrapper(value);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest(
            "Failed to deserialize oneOf List<SupportedLanguage> (error: " + e.getMessage() + ") (type: List<SupportedLanguage>)"
          );
        }
      }
      // deserialize Boolean
      if (tree.isBoolean()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          Boolean value = parser.readValueAs(Boolean.class);
          return new IgnorePlurals.BooleanWrapper(value);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf Boolean (error: " + e.getMessage() + ") (type: Boolean)");
        }
      }
      throw new AlgoliaRuntimeException(String.format("Failed to deserialize json element: %s", tree));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public IgnorePlurals getNullValue(DeserializationContext ctxt) throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "IgnorePlurals cannot be null");
    }
  }
}
