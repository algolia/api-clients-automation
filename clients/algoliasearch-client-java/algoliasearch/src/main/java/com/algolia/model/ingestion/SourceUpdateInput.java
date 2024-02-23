// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.ingestion;

import com.algolia.exceptions.AlgoliaRuntimeException;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import java.io.IOException;
import java.util.logging.Logger;

/** SourceUpdateInput */
@JsonDeserialize(using = SourceUpdateInput.Deserializer.class)
public interface SourceUpdateInput {
  class Deserializer extends JsonDeserializer<SourceUpdateInput> {

    private static final Logger LOGGER = Logger.getLogger(Deserializer.class.getName());

    @Override
    public SourceUpdateInput deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
      JsonNode tree = jp.readValueAsTree();
      // deserialize SourceBigQuery
      if (tree.isObject() && tree.has("projectID")) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          return parser.readValueAs(SourceBigQuery.class);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf SourceBigQuery (error: " + e.getMessage() + ") (type: SourceBigQuery)");
        }
      }
      // deserialize SourceUpdateCommercetools
      if (tree.isObject()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          return parser.readValueAs(SourceUpdateCommercetools.class);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest(
            "Failed to deserialize oneOf SourceUpdateCommercetools (error: " + e.getMessage() + ") (type: SourceUpdateCommercetools)"
          );
        }
      }
      // deserialize SourceJSON
      if (tree.isObject()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          return parser.readValueAs(SourceJSON.class);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf SourceJSON (error: " + e.getMessage() + ") (type: SourceJSON)");
        }
      }
      // deserialize SourceCSV
      if (tree.isObject()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          return parser.readValueAs(SourceCSV.class);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf SourceCSV (error: " + e.getMessage() + ") (type: SourceCSV)");
        }
      }
      // deserialize SourceUpdateDocker
      if (tree.isObject()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          return parser.readValueAs(SourceUpdateDocker.class);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf SourceUpdateDocker (error: " + e.getMessage() + ") (type: SourceUpdateDocker)");
        }
      }
      throw new AlgoliaRuntimeException(String.format("Failed to deserialize json element: %s", tree));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public SourceUpdateInput getNullValue(DeserializationContext ctxt) throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "SourceUpdateInput cannot be null");
    }
  }
}
