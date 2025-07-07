package com.algolia.codegen.utils;

import com.algolia.codegen.exceptions.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.swagger.v3.core.util.Json;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.CodegenServer;
import org.openapitools.codegen.CodegenServerVariable;
import org.openapitools.codegen.SupportingFile;
import org.openapitools.codegen.model.OperationsMap;

public class Helpers {

  /** The suffix of our client names. */
  public static final String API_SUFFIX = "Client";

  public static final Set<String> CUSTOM_METHODS = Set.of("customDelete", "customGet", "customPost", "customPut");

  private static JsonNode cacheConfig;

  private Helpers() {}

  public static String capitalize(String str) {
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }

  public static String camelize(String kebabStr) {
    String[] parts = kebabStr.split("-");
    String camel = parts[0].toLowerCase();
    for (int i = 1; i < parts.length; i++) {
      camel += capitalize(parts[i]);
    }
    return camel;
  }

  // convert camelCase77String to CAMEL_CASE_77_STRING
  public static String toScreamingSnakeCase(String camelCase) {
    return camelCase
      .replaceAll("-", "_")
      .replaceAll("/", "_")
      .replaceAll("(?<=.)([A-Z]+|\\d+)", "_$1")
      .replaceAll("__", "_")
      .toUpperCase(Locale.ROOT);
  }

  /**
   * Will add the boolean `vendorExtensions.x-is-custom-request` to operations if they should not
   * escape '/' in the path variable
   */
  public static CodegenOperation specifyCustomRequest(CodegenOperation ope) {
    if (CUSTOM_METHODS.contains(ope.operationIdOriginal)) {
      ope.vendorExtensions.put("x-is-custom-request", true);
    }
    return ope;
  }

  /** Returns the client name for the given language */
  public static String createClientName(String client, String language) {
    switch (language) {
      case "javascript":
        return camelize(client);
      case "python":
        return toSnakeCase(client);
      case "go":
        return client;
      case "dart":
        return StringUtils.lowerCase(client);
      case "csharp":
        return capitalize(camelize(client));
      case "ruby":
        return toSnakeCase(client);
      default:
        return capitalize(camelize(client));
    }
  }

  // testInput -> test-input
  public static String toKebabCase(String camelStr) {
    return camelStr.replaceAll("(.+?)([A-Z]|[0-9])", "$1-$2").toLowerCase(Locale.ROOT);
  }

  // testInput -> test_input
  // test-input -> test_input
  public static String toSnakeCase(String s) {
    return s.replace('-', '_').replaceAll("(.+?)([A-Z])", "$1_$2").toLowerCase(Locale.ROOT);
  }

  // test_input -> TestInput
  // test-input -> TestInput
  public static String toPascalCase(String s) {
    return Arrays.stream(s.split("[_-]")).map(Helpers::capitalize).reduce("", String::concat);
  }

  /** Inject server info into the client to generate the right URL */
  public static void generateServers(List<CodegenServer> servers, Map<String, Object> bundle) throws ConfigException {
    try {
      boolean hasRegionalHost = false;
      boolean fallbackToAliasHost = false;
      boolean hasVariables = false;
      String regionalHost = "";
      String hostWithFallback = "";
      Set<String> allowedRegions = new HashSet<>();
      for (CodegenServer server : servers) {
        if (server.url.isEmpty()) {
          throw new ConfigException("Invalid server, does not contains 'url'");
        }

        // Determine if the current URL with `region` also have an alias without
        // variables.
        for (CodegenServer otherServer : servers) {
          if (server == otherServer) {
            continue;
          }
          if (otherServer.url.replace(".{region}", "").equals(server.url)) {
            URL fallbackURL = new URL(otherServer.url.replace(".{region}", ""));
            fallbackToAliasHost = true;
            hostWithFallback = fallbackURL.getHost();
            break;
          }
        }

        if (server.variables == null || server.variables.isEmpty()) {
          continue;
        }
        hasVariables = true;
        CodegenServerVariable regionVar = server.variables
          .stream()
          .filter(v -> v.name.equals("region"))
          .findFirst()
          .orElse(null);
        if (regionVar == null || regionVar.enumValues == null || regionVar.enumValues.isEmpty()) {
          continue;
        }

        hasRegionalHost = true;
        for (String region : regionVar.enumValues) {
          allowedRegions.add(region);
        }

        // This is used for hosts like `insights` that uses `.io`
        regionalHost = server.url.replace("http://", "").replace("https://", "");
      }

      if (!hasRegionalHost) {
        if (!hasVariables && hostWithFallback.isEmpty()) {
          List<String> hostsWithoutVariables = new ArrayList<>();
          for (CodegenServer otherServer : servers) {
            URL url = new URL(otherServer.url);
            hostsWithoutVariables.add(url.getHost());
          }
          bundle.put("hostsWithoutVariables", hostsWithoutVariables);
        } else {
          bundle.put("hostWithAppID", true);
        }
      }

      bundle.put("hostWithFallback", hostWithFallback);
      bundle.put("hasRegionalHost", hasRegionalHost);
      bundle.put("fallbackToAliasHost", fallbackToAliasHost);
      bundle.put("regionalHost", regionalHost);
      bundle.put("allowedRegions", allowedRegions.toArray(new String[0]));
    } catch (MalformedURLException e) {
      throw new ConfigException("Invalid server URL", e);
    }
  }

  public static void removeHelpers(OperationsMap operations) {
    operations
      .getOperations()
      .getOperation()
      .removeIf(entry -> (boolean) entry.vendorExtensions.getOrDefault("x-helper", false));
  }

  /**
   * Get the current version of the given client from the
   * `clients/algoliasearch-client-javascript/packages/${client}/package.json` file, defaults to
   * 0.0.1-alpha.0 if not found
   */
  public static String getPackageJsonVersion(String client) throws ConfigException {
    try {
      JsonNode packageJson = Helpers.readJsonFile("clients/algoliasearch-client-javascript/packages/" + client + "/package.json");
      String value = packageJson.get("version").asText();

      if (value.isEmpty()) {
        return "0.0.1-alpha.0";
      }

      return value;
    } catch (ConfigException e) {
      return "0.0.1-alpha.0";
    }
  }

  /** Get the `field` value in the `config/clients.config.json` file for the given language */
  public static String getClientConfigField(String language, String... fields) throws ConfigException {
    if (fields.length == 0) {
      throw new ConfigException("getClientConfigField requires at least one field");
    }
    JsonNode value = getClientConfig(language);
    for (String field : fields) {
      value = value.get(field);
    }
    if (!value.isTextual()) {
      throw new ConfigException(fields[fields.length - 1] + " is not a string");
    }
    return value.asText();
  }

  /** Get the `field` value in the `config/clients.config.json` file for the given language */
  public static List<Map<String, Object>> getClientConfigList(String language, String... fields) throws ConfigException {
    if (fields.length == 0) {
      throw new ConfigException("getClientConfigList requires at least one field");
    }
    JsonNode value = getClientConfig(language);
    for (String field : fields) {
      value = value.get(field);
    }
    try {
      return new ObjectMapper().readerForListOf(Map.class).readValue(value);
    } catch (IOException e) {
      throw new ConfigException("Cannot convert value", e);
    }
  }

  public static List<String> getClientListForLanguage(String language) throws ConfigException {
    JsonNode value = getClientConfig(language);
    value = value.get("clients");
    if (value == null || !value.isArray()) {
      throw new ConfigException("'clients' is not an array");
    }

    ArrayNode arrayNode = (ArrayNode) value;
    List<String> resultList = new ArrayList<>();
    for (JsonNode node : arrayNode) {
      if (!node.isTextual()) {
        resultList.add(node.get("name").asText());
      } else {
        resultList.add(node.asText());
      }
    }
    return resultList;
  }

  public static JsonNode getClientConfig(String language) {
    if (cacheConfig == null) {
      cacheConfig = readJsonFile("config/clients.config.json");
    }

    return cacheConfig.get(language);
  }

  public static JsonNode readJsonFile(String filePath) throws ConfigException {
    try {
      return Json.mapper().readTree(new File(filePath));
    } catch (IOException e) {
      throw new ConfigException("Cannot read json file " + filePath, e);
    }
  }

  /**
   * If more than 2 variant are List<?>, the types are compatible and we cannot create override of
   * the `of` method, so we need to explicitly set the `of` method name, like `ofListofString` and
   * `ofListofList`.
   */
  public static boolean shouldUseExplicitOneOfName(Collection<String> oneOf) {
    return (
      oneOf
        .stream()
        .filter(type -> type != null && type.startsWith("List"))
        .count() >=
      2
    );
  }

  /**
   * Sets a `generationBanner` variable on the mustache templates, to display the generation banner
   * on generated files.
   */
  public static String setGenerationBanner(Map<String, Object> additionalProperties) {
    String banner =
      "Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will" +
      " be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT" +
      " EDIT.";
    additionalProperties.put("generationBanner", banner);
    return banner;
  }

  public static void prettyPrint(Object o) {
    Json.prettyPrint(o);
  }

  public static void addCommonSupportingFiles(List<SupportingFile> supportingFiles, String root) {
    supportingFiles.add(new SupportingFile("LICENSE", "", root + "LICENSE"));
    supportingFiles.add(new SupportingFile("issue.yml", root + ".github/workflows", "issue.yml"));
    supportingFiles.add(new SupportingFile("Bug_report.yml", root + ".github/ISSUE_TEMPLATE", "Bug_report.yml"));
    supportingFiles.add(
      new SupportingFile("do-not-edit-this-repository.yml", root + ".github/workflows", "do-not-edit-this-repository.yml")
    );
  }

  public static String getLanguageVersion(String language) throws IOException {
    String versionFile = language.equals("javascript")
      ? ".nvmrc"
      : "config/." + (language.equals("kotlin") || language.equals("scala") ? "java" : language) + "-version";
    return Files.readString(new File(versionFile).toPath()).trim();
  }

  public static List<Object> deepCopy(List<Object> obj) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(mapper.writeValueAsString(obj), List.class);
  }
}
