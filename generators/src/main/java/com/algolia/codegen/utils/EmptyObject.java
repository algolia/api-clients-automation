package com.algolia.codegen.utils;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.function.UnaryOperator;
import org.openapitools.codegen.model.ModelsMap;
import org.openapitools.codegen.utils.ModelUtils;

/**
 * A closed empty object ({@code type: object}, no properties, {@code additionalProperties: false})
 * only accepts {@code {}}. OpenAPI Generator treats it as a free-form object and inlines every
 * {@code $ref} to it, which erases the type from unions; keeping the ref makes it a named model.
 */
public class EmptyObject {

  private EmptyObject() {
    // Empty.
  }

  public static void markNotFreeForm(OpenAPI openAPI) {
    if (openAPI.getComponents() == null || openAPI.getComponents().getSchemas() == null) return;
    for (Schema schema : openAPI.getComponents().getSchemas().values()) {
      if (isClosedEmptyObject(schema)) {
        schema.addExtension("x-is-free-form", false);
      }
    }
  }

  public static void markModels(OpenAPI openAPI, Map<String, ModelsMap> models) {
    if (openAPI.getComponents() == null || openAPI.getComponents().getSchemas() == null) return;
    for (ModelsMap modelContainer : models.values()) {
      var model = modelContainer.getModels().get(0).getModel();
      if (isClosedEmptyObject(openAPI.getComponents().getSchemas().get(model.name))) {
        model.vendorExtensions.put("x-is-empty-object", true);
      }
    }
  }

  /** An empty object matches any JSON object, so union members must be tried before it. */
  public static void moveOneOfMembersLast(OpenAPI openAPI, Map<String, ModelsMap> models) {
    if (openAPI.getComponents() == null || openAPI.getComponents().getSchemas() == null) return;
    var schemas = openAPI.getComponents().getSchemas();
    for (ModelsMap modelContainer : models.values()) {
      var model = modelContainer.getModels().get(0).getModel();
      if (model.oneOf == null || model.oneOf.stream().noneMatch(name -> isClosedEmptyObject(schemas.get(name)))) continue;
      var reordered = new LinkedHashSet<String>();
      model.oneOf
        .stream()
        .filter(name -> !isClosedEmptyObject(schemas.get(name)))
        .forEach(reordered::add);
      model.oneOf
        .stream()
        .filter(name -> isClosedEmptyObject(schemas.get(name)))
        .forEach(reordered::add);
      model.oneOf = reordered;
    }
  }

  public static Schema unalias(OpenAPI openAPI, Schema schema, UnaryOperator<Schema> fallback) {
    return isRefToClosedEmptyObject(openAPI, schema) ? schema : fallback.apply(schema);
  }

  public static boolean isRefToClosedEmptyObject(OpenAPI openAPI, Schema schema) {
    if (schema == null || schema.get$ref() == null || openAPI == null || openAPI.getComponents() == null) return false;
    var schemas = openAPI.getComponents().getSchemas();
    return schemas != null && isClosedEmptyObject(schemas.get(ModelUtils.getSimpleRef(schema.get$ref())));
  }

  public static boolean isClosedEmptyObject(Schema schema) {
    return (
      schema != null &&
      "object".equals(ModelUtils.getType(schema)) &&
      (schema.getProperties() == null || schema.getProperties().isEmpty()) &&
      Boolean.FALSE.equals(schema.getAdditionalProperties()) &&
      !ModelUtils.isComposedSchema(schema)
    );
  }
}
