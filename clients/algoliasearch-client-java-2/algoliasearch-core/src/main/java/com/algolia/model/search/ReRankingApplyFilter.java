// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.search;

import com.algolia.exceptions.AlgoliaRuntimeException;
import com.algolia.utils.CompoundType;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * When [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/) is enabled,
 * only records that match these filters will be affected by Dynamic Re-Ranking.
 */
@JsonDeserialize(using = ReRankingApplyFilter.ReRankingApplyFilterDeserializer.class)
@JsonSerialize(using = ReRankingApplyFilter.ReRankingApplyFilterSerializer.class)
public abstract class ReRankingApplyFilter implements CompoundType {

  private static final Logger LOGGER = Logger.getLogger(ReRankingApplyFilter.class.getName());

  public static ReRankingApplyFilter of(List<MixedSearchFilters> inside) {
    return new ReRankingApplyFilterListOfMixedSearchFilters(inside);
  }

  public static ReRankingApplyFilter of(String inside) {
    return new ReRankingApplyFilterString(inside);
  }

  public static class ReRankingApplyFilterSerializer extends StdSerializer<ReRankingApplyFilter> {

    public ReRankingApplyFilterSerializer(Class<ReRankingApplyFilter> t) {
      super(t);
    }

    public ReRankingApplyFilterSerializer() {
      this(null);
    }

    @Override
    public void serialize(ReRankingApplyFilter value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
      jgen.writeObject(value.getInsideValue());
    }
  }

  public static class ReRankingApplyFilterDeserializer extends StdDeserializer<ReRankingApplyFilter> {

    public ReRankingApplyFilterDeserializer() {
      this(ReRankingApplyFilter.class);
    }

    public ReRankingApplyFilterDeserializer(Class<?> vc) {
      super(vc);
    }

    @Override
    public ReRankingApplyFilter deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
      JsonNode tree = jp.readValueAsTree();

      // deserialize List<MixedSearchFilters>
      if (tree.isArray()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          List<MixedSearchFilters> value = parser.readValueAs(new TypeReference<List<MixedSearchFilters>>() {});
          return ReRankingApplyFilter.of(value);
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
          String value = parser.readValueAs(new TypeReference<String>() {});
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

class ReRankingApplyFilterListOfMixedSearchFilters extends ReRankingApplyFilter {

  private final List<MixedSearchFilters> insideValue;

  ReRankingApplyFilterListOfMixedSearchFilters(List<MixedSearchFilters> insideValue) {
    this.insideValue = insideValue;
  }

  @Override
  public List<MixedSearchFilters> getInsideValue() {
    return insideValue;
  }
}

class ReRankingApplyFilterString extends ReRankingApplyFilter {

  private final String insideValue;

  ReRankingApplyFilterString(String insideValue) {
    this.insideValue = insideValue;
  }

  @Override
  public String getInsideValue() {
    return insideValue;
  }
}
