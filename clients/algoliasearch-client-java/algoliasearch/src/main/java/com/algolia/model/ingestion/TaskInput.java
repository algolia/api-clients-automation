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

/** Configuration of the task, depending on its type. */
@JsonDeserialize(using = TaskInput.Deserializer.class)
public interface TaskInput {
  class Deserializer extends JsonDeserializer<TaskInput> {

    private static final Logger LOGGER = Logger.getLogger(Deserializer.class.getName());

    @Override
    public TaskInput deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
      JsonNode tree = jp.readValueAsTree();
      // deserialize StreamingInput
      if (tree.isObject() && tree.has("mapping")) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          return parser.readValueAs(StreamingInput.class);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf StreamingInput (error: " + e.getMessage() + ") (type: StreamingInput)");
        }
      }
      // deserialize DockerStreamsInput
      if (tree.isObject() && tree.has("streams")) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          return parser.readValueAs(DockerStreamsInput.class);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf DockerStreamsInput (error: " + e.getMessage() + ") (type: DockerStreamsInput)");
        }
      }
      // deserialize ShopifyInput
      if (tree.isObject()) {
        try (JsonParser parser = tree.traverse(jp.getCodec())) {
          return parser.readValueAs(ShopifyInput.class);
        } catch (Exception e) {
          // deserialization failed, continue
          LOGGER.finest("Failed to deserialize oneOf ShopifyInput (error: " + e.getMessage() + ") (type: ShopifyInput)");
        }
      }
      throw new AlgoliaRuntimeException(String.format("Failed to deserialize json element: %s", tree));
    }

    /** Handle deserialization of the 'null' value. */
    @Override
    public TaskInput getNullValue(DeserializationContext ctxt) throws JsonMappingException {
      throw new JsonMappingException(ctxt.getParser(), "TaskInput cannot be null");
    }
  }
}
