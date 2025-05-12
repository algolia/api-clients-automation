package com.algolia.codegen.cts.tests;

import static org.openapitools.codegen.utils.StringUtils.camelize;

import com.algolia.codegen.exceptions.CTSException;
import com.algolia.codegen.utils.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import org.openapitools.codegen.CodegenOperation;
import org.openapitools.codegen.CodegenResponse;

public class Snippet {

  public String testName;

  public String method;
  public Map<String, Object> parameters;
  public RequestOptions requestOptions;
  public List<String> skipLanguages;

  public Snippet(String method, String testName, Map<String, Object> parameters, RequestOptions requestOptions) {
    this.method = method;
    this.testName = testName;
    this.parameters = parameters;
    this.requestOptions = requestOptions;
  }

  public Snippet() {}

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Request {\n");
    sb.append("    testName: ").append(testName).append("\n");
    sb.append("    method: ").append(method).append("\n");
    sb.append("    parameters: ").append(parameters).append("\n");
    sb.append("    requestOptions: ").append(requestOptions).append("\n");
    sb.append("}");
    return sb.toString();
  }

  public void addMethodCall(Map<String, Object> context, ParametersWithDataType paramsType, CodegenOperation ope) throws CTSException {
    // for dynamic snippets, we need to reset the context because the order of generation is random
    context.put("method", method);
    context.put("returnType", null);
    context.put("requestOptions", null);
    context.put("parameters", null);
    context.put("parametersWithDataType", null);
    context.put("parametersWithDataTypeMap", null);

    if (ope.returnType != null && ope.returnType.length() > 0) {
      context.put("returnType", camelize(ope.returnType));
    }

    try {
      context.put("isGeneric", (boolean) ope.vendorExtensions.getOrDefault("x-is-generic", false));
      context.put("isCustomRequest", Helpers.CUSTOM_METHODS.contains(ope.operationIdOriginal));
      context.put("isAsyncMethod", (boolean) ope.vendorExtensions.getOrDefault("x-asynchronous-helper", true));
      context.put("hasParams", ope.getHasParams());
      context.put("isHelper", (boolean) ope.vendorExtensions.getOrDefault("x-helper", false));
      context.put("hasRequestOptions", requestOptions != null);

      if (requestOptions != null) {
        Map<String, Object> requestOptionsContext = new HashMap<>();
        if (requestOptions.queryParameters != null) {
          Map<String, Object> queryParameters = new HashMap<>();
          paramsType.enhanceParameters(requestOptions.queryParameters, queryParameters);
          requestOptionsContext.put("queryParameters", queryParameters);
        }
        if (requestOptions.headers != null) {
          Map<String, Object> headers = new HashMap<>();
          // convert the headers to an acceptable type
          paramsType.enhanceParameters(new HashMap<String, Object>(requestOptions.headers), headers);
          requestOptionsContext.put("headers", headers);
        }

        context.put("requestOptions", requestOptionsContext);
      }

      // Determines whether the endpoint is expected to return a response payload deserialized
      // and therefore a variable to store it into.
      context.put("hasResponse", true);
      for (CodegenResponse response : ope.responses) {
        if (response.code.equals("204")) {
          context.put("hasResponse", false);
        }
      }

      TestsGenerator.setOptionalParameters(ope, context, parameters);

      paramsType.enhanceParameters(parameters, context, ope);
    } catch (CTSException e) {
      e.setTestName((String) context.get("testName"));
      throw e;
    } catch (JsonProcessingException e) {
      throw new CTSException("Error while enhanching parameters for " + method, e);
    }
  }
}
