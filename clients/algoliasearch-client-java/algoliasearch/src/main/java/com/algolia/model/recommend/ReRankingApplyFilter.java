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

/**
 * When [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/) is enabled,
 * only records that match these filters will be affected by Dynamic Re-Ranking.
 */
@JsonDeserialize(using = ReRankingApplyFilter.Deserializer.class)
public interface ReRankingApplyFilter {
  /** ReRankingApplyFilter as List<MixedSearchFilters> wrapper. */
  static ReRankingApplyFilter of(List<MixedSearchFilters> value) {
    return new ListOfMixedSearchFiltersWrapper(value);
  }

  /** ReRankingApplyFilter as String wrapper. */
  static ReRankingApplyFilter of(String value) {
    return new StringWrapper(value);
  }

  /** ReRankingApplyFilter as List<MixedSearchFilters> wrapper. */
  @JsonSerialize(using = ListOfMixedSearchFiltersWrapper.Serializer.class)
  class ListOfMixedSearchFiltersWrapper implements ReRankingApplyFilter {

    private final List<MixedSearchFilters> value;

    ListOfMixedSearchFiltersWrapper(List<MixedSearchFilters> value) {
      this.value = value;
    }

    public List<MixedSearchFilters> getValue() {
      return value;
    }

    static class Serializer extends JsonSerializer<ListOfMixedSearchFiltersWrapper> {

      @Override
      public void serialize(ListOfMixedSearchFiltersWrapper value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeObject(value.getValue());
      }
    }
  }

  /** ReRankingApplyFilter as String wrapper. */
  @JsonSerialize(using = StringWrapper.Serializer.class)
  class StringWrapper implements ReRankingApplyFilter {

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

  class Deserializer extends JsonDeserializer<ReRankingApplyFilter> {

    private static final Logger LOGGER = Logger.getLogger(Deserializer.class.getName());

    @Override
    public ReRankingApplyFilter deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
      JsonNode tree = jp.readValueAsTree();

      // deserialize List<MixedSearchFilters>
      if (tree.isArray()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          return parser.readValueAs(new TypeReference<List<MixedSearchFilters>>() {});
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest(
            "Failed to deserialize oneOf List<MixedSearchFilters> (error: " + e.getMessage() + ") (type: List<MixedSearchFilters>)"
          );
        }
      }

      // deserialize String
      if (tree.isValueNode()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          String value = parser.readValueAs(String.class);
          return ReRankingApplyFilter.of(value);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf String (error: " + e.getMessage() + ") (type: String)");
        }
      }
      throw new AlgoliaRuntimeException(String.format("Failed to deserialize json element: %s", tree));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public ReRankingApplyFilter getNullValue(DeserializationContext ctxt) throws JsonMappingException {
      return null;
    }
  }
}
