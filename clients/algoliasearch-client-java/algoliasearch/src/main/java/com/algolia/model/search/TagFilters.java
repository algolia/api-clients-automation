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
 * Filter the search by values of the special `_tags` attribute. **Prefer using the `filters`
 * parameter, which supports all filter types and combinations with boolean operators.** Different
 * from regular facets, `_tags` can only be used for filtering (including or excluding records). You
 * won't get a facet count. The same combination and escaping rules apply as for `facetFilters`.
 */
@JsonDeserialize(using = TagFilters.Deserializer.class)
public interface TagFilters {
  // TagFilters as List<TagFilters> wrapper.
  static TagFilters of(List<TagFilters> value) {
    return new ListOfTagFiltersWrapper(value);
  }

  // TagFilters as String wrapper.
  static TagFilters of(String value) {
    return new StringWrapper(value);
  }

  // TagFilters as List<TagFilters> wrapper.
  @JsonSerialize(using = ListOfTagFiltersWrapper.Serializer.class)
  class ListOfTagFiltersWrapper implements TagFilters {

    private final List<TagFilters> value;

    ListOfTagFiltersWrapper(List<TagFilters> value) {
      this.value = value;
    }

    public List<TagFilters> getValue() {
      return value;
    }

    static class Serializer extends JsonSerializer<ListOfTagFiltersWrapper> {

      @Override
      public void serialize(ListOfTagFiltersWrapper value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeObject(value.getValue());
      }
    }
  }

  // TagFilters as String wrapper.
  @JsonSerialize(using = StringWrapper.Serializer.class)
  class StringWrapper implements TagFilters {

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

  class Deserializer extends JsonDeserializer<TagFilters> {

    private static final Logger LOGGER = Logger.getLogger(Deserializer.class.getName());

    @Override
    public TagFilters deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
      JsonNode tree = jp.readValueAsTree();
      // deserialize List<TagFilters>
      if (tree.isArray()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          List<TagFilters> value = parser.readValueAs(new TypeReference<List<TagFilters>>() {});
          return new TagFilters.ListOfTagFiltersWrapper(value);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf List<TagFilters> (error: " + e.getMessage() + ") (type: List<TagFilters>)");
        }
      }
      // deserialize String
      if (tree.isTextual()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          String value = parser.readValueAs(String.class);
          return new TagFilters.StringWrapper(value);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf String (error: " + e.getMessage() + ") (type: String)");
        }
      }
      throw new AlgoliaRuntimeException(String.format("Failed to deserialize json element: %s", tree));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public TagFilters getNullValue(DeserializationContext ctxt) throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "TagFilters cannot be null");
    }
  }
}
