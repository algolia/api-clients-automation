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

/** DestinationInput */
@JsonDeserialize(using = DestinationInput.Deserializer.class)
public interface DestinationInput {
  class Deserializer extends JsonDeserializer<DestinationInput> {

    private static final Logger LOGGER = Logger.getLogger(Deserializer.class.getName());

    @Override
    public DestinationInput deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
      JsonNode tree = jp.readValueAsTree();
      // deserialize DestinationIndexName
      if (tree.isObject()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          return parser.readValueAs(DestinationIndexName.class);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf DestinationIndexName (error: " + e.getMessage() + ") (type: DestinationIndexName)");
        }
      }
      throw new AlgoliaRuntimeException(String.format("Failed to deserialize json element: %s", tree));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public DestinationInput getNullValue(DeserializationContext ctxt) throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "DestinationInput cannot be null");
    }
  }
}
