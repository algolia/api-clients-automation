// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.search;

import com.algolia.exceptions.AlgoliaRuntimeException;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.io.IOException;
import java.util.logging.Logger;

/** SearchResult */
@JsonDeserialize(using = SearchResult.Deserializer.class)
public interface SearchResult {
  class Deserializer extends JsonDeserializer<SearchResult> {

    private static final Logger LOGGER = Logger.getLogger(Deserializer.class.getName());

    @Override
    public SearchResult deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
      JsonNode tree = jp.readValueAsTree();
      // deserialize SearchForFacetValuesResponse
      if (tree.isObject() && tree.has("facetHits")) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          return parser.readValueAs(SearchForFacetValuesResponse.class);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest(
            "Failed to deserialize oneOf SearchForFacetValuesResponse (error: " + e.getMessage() + ") (type: SearchForFacetValuesResponse)"
          );
        }
      }
      // deserialize SearchResponse
      if (tree.isObject()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          return parser.readValueAs(SearchResponse.class);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf SearchResponse (error: " + e.getMessage() + ") (type: SearchResponse)");
        }
      }
      throw new AlgoliaRuntimeException(String.format("Failed to deserialize json element: %s", tree));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public SearchResult getNullValue(DeserializationContext ctxt) throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "SearchResult cannot be null");
    }
  }
}
