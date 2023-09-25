// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.recommend;

import com.algolia.exceptions.AlgoliaRuntimeException;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/** SnippetResult */
@JsonDeserialize(using = SnippetResult.Deserializer.class)
public interface SnippetResult {
  /** SnippetResult as List<SnippetResultOption> wrapper. */
  static SnippetResult of(List<SnippetResultOption> value) {
    return new ListOfSnippetResultOptionWrapper(value);
  }

  /** SnippetResult as List<SnippetResultOption> wrapper. */
  @JsonSerialize(using = ListOfSnippetResultOptionWrapper.Serializer.class)
  class ListOfSnippetResultOptionWrapper implements SnippetResult {

    private final List<SnippetResultOption> value;

    ListOfSnippetResultOptionWrapper(List<SnippetResultOption> value) {
      this.value = value;
    }

    public List<SnippetResultOption> getValue() {
      return value;
    }

    static class Serializer extends JsonSerializer<ListOfSnippetResultOptionWrapper> {

      @Override
      public void serialize(ListOfSnippetResultOptionWrapper value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeObject(value.getValue());
      }
    }
  }

  class Deserializer extends JsonDeserializer<SnippetResult> {

    private static final Logger LOGGER = Logger.getLogger(Deserializer.class.getName());

    @Override
    public SnippetResult deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
      JsonNode tree = jp.readValueAsTree();

      // deserialize List<SnippetResultOption>
      if (tree.isArray()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          return parser.readValueAs(new TypeReference<List<SnippetResultOption>>() {});
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest(
            "Failed to deserialize oneOf List<SnippetResultOption> (error: " + e.getMessage() + ") (type: List<SnippetResultOption>)"
          );
        }
      }

      // deserialize SnippetResultOption
      if (tree.isObject()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          return parser.readValueAs(SnippetResultOption.class);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf SnippetResultOption (error: " + e.getMessage() + ") (type: SnippetResultOption)");
        }
      }
      throw new AlgoliaRuntimeException(String.format("Failed to deserialize json element: %s", tree));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public SnippetResult getNullValue(DeserializationContext ctxt) throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "SnippetResult cannot be null");
    }
  }
}
