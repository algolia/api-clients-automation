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
import java.util.Map;
import java.util.logging.Logger;

/** HighlightResult */
@JsonDeserialize(using = HighlightResult.Deserializer.class)
public interface HighlightResult {
  // HighlightResult as Map<String, HighlightResultOption> wrapper.
  static HighlightResult of(Map<String, HighlightResultOption> value) {
    return new MapOfStringHighlightResultOptionWrapper(value);
  }

  // HighlightResult as List<HighlightResultOption> wrapper.
  static HighlightResult of(List<HighlightResultOption> value) {
    return new ListOfHighlightResultOptionWrapper(value);
  }

  // HighlightResult as Map<String, HighlightResultOption> wrapper.
  @JsonSerialize(using = MapOfStringHighlightResultOptionWrapper.Serializer.class)
  class MapOfStringHighlightResultOptionWrapper implements HighlightResult {

    private final Map<String, HighlightResultOption> value;

    MapOfStringHighlightResultOptionWrapper(Map<String, HighlightResultOption> value) {
      this.value = value;
    }

    public Map<String, HighlightResultOption> getValue() {
      return value;
    }

    static class Serializer extends JsonSerializer<MapOfStringHighlightResultOptionWrapper> {

      @Override
      public void serialize(MapOfStringHighlightResultOptionWrapper value, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
        gen.writeObject(value.getValue());
      }
    }
  }

  // HighlightResult as List<HighlightResultOption> wrapper.
  @JsonSerialize(using = ListOfHighlightResultOptionWrapper.Serializer.class)
  class ListOfHighlightResultOptionWrapper implements HighlightResult {

    private final List<HighlightResultOption> value;

    ListOfHighlightResultOptionWrapper(List<HighlightResultOption> value) {
      this.value = value;
    }

    public List<HighlightResultOption> getValue() {
      return value;
    }

    static class Serializer extends JsonSerializer<ListOfHighlightResultOptionWrapper> {

      @Override
      public void serialize(ListOfHighlightResultOptionWrapper value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeObject(value.getValue());
      }
    }
  }

  class Deserializer extends JsonDeserializer<HighlightResult> {

    private static final Logger LOGGER = Logger.getLogger(Deserializer.class.getName());

    @Override
    public HighlightResult deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
      JsonNode tree = jp.readValueAsTree();
      // deserialize HighlightResultOption
      if (tree.isObject()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          return parser.readValueAs(HighlightResultOption.class);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf HighlightResultOption (error: " + e.getMessage() + ") (type: HighlightResultOption)");
        }
      }
      // deserialize Map<String, HighlightResultOption>
      if (tree.isObject()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          Map<String, HighlightResultOption> value = parser.readValueAs(new TypeReference<Map<String, HighlightResultOption>>() {});
          return new HighlightResult.MapOfStringHighlightResultOptionWrapper(value);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest(
            "Failed to deserialize oneOf Map<String, HighlightResultOption> (error: " +
            e.getMessage() +
            ") (type: Map<String, HighlightResultOption>)"
          );
        }
      }
      // deserialize List<HighlightResultOption>
      if (tree.isArray()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          List<HighlightResultOption> value = parser.readValueAs(new TypeReference<List<HighlightResultOption>>() {});
          return new HighlightResult.ListOfHighlightResultOptionWrapper(value);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest(
            "Failed to deserialize oneOf List<HighlightResultOption> (error: " + e.getMessage() + ") (type: List<HighlightResultOption>)"
          );
        }
      }
      throw new AlgoliaRuntimeException(String.format("Failed to deserialize json element: %s", tree));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public HighlightResult getNullValue(DeserializationContext ctxt) throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "HighlightResult cannot be null");
    }
  }
}
