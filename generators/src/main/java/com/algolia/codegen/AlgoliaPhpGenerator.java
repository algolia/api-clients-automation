package com.algolia.codegen;

import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.SupportingFile;
import org.openapitools.codegen.languages.PhpClientCodegen;

public class AlgoliaPhpGenerator extends PhpClientCodegen {

  @Override
  public String getName() {
    return "algolia-php";
  }

  @Override
  public CodegenOperation fromOperation(
    String path,
    String httpMethod,
    Operation operation,
    List<Server> servers
  ) {
    return Utils.specifyCustomRequest(
      super.fromOperation(path, httpMethod, operation, servers)
    );
  }

  @Override
  public void processOpts() {
    super.processOpts();

    // set default options of the generator for every clients
    String client = additionalProperties.get("client").toString();

    if (client.equals("search") || client.equals("recommend")) {
      additionalProperties.put("useCache", true);
    }

    additionalProperties.put(
      "configClassname",
      Utils.createClientName(client, "php") + "Config"
    );

    setParameterNamingConvention("camelCase");

    // Remove base template as we want to change its path
    supportingFiles.removeIf(file ->
      file.getTemplateFile().equals("Configuration.mustache")
    );

    supportingFiles.add(
      new SupportingFile(
        "Configuration.mustache",
        "lib/Configuration",
        "Configuration.php"
      )
    );
  }
}
