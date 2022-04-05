package com.algolia.codegen;

import java.util.List;

import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.languages.TypeScriptNodeClientCodegen;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.ArraySchema;
import org.openapitools.codegen.utils.ModelUtils;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.servers.Server;

public class AlgoliaJavascriptGenerator extends TypeScriptNodeClientCodegen {
  @Override
  public String getName() {
    return "algolia-javascript";
  }

  @Override
  public CodegenOperation fromOperation(String path, String httpMethod, Operation operation, List<Server> servers) {
    return Utils.specifyCustomRequest(super.fromOperation(path, httpMethod, operation, servers));
  }

  @Override
  public String getTypeDeclaration(Schema p) {
    String type = super.getTypeDeclaration(p);
    // openapi generator is wrong, 'object' is not a fit all object, we need 'any'
    // we use replace because there might be more to this type, like '| undefined'
    return type.replace("{ [key: string]: object; }", "Record<String, any>");
  }
}
