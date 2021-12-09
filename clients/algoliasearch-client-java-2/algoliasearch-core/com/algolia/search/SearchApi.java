package com.algolia.search;

import com.algolia.ApiClient;
import com.algolia.EncodingUtils;
import com.algolia.model.ApiResponse;
import com.algolia.model.BatchObject;
import com.algolia.model.BatchResponse;
import com.algolia.model.DeleteIndexResponse;
import com.algolia.model.ErrorBase;
import com.algolia.model.IndexSettings;
import com.algolia.model.ListIndicesResponse;
import com.algolia.model.MultipleQueriesObject;
import com.algolia.model.MultipleQueriesResponse;
import com.algolia.model.OneOfsearchParamsAsStringsearchParams;
import com.algolia.model.OperationIndexObject;
import com.algolia.model.OperationIndexResponse;
import com.algolia.model.SaveObjectResponse;
import com.algolia.model.SearchResponse;
import com.algolia.model.SetSettingsResponse;
import com.algolia.model.UNKNOWN_BASE_TYPE;
import feign.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(
  value = "org.openapitools.codegen.languages.JavaClientCodegen",
  date = "2021-12-09T15:22:27.248809+01:00[Europe/Paris]"
)
public interface SearchApi extends ApiClient.Api {
  /**
   *
   * Performs multiple write operations in a single API call.
   * @param indexName The index in which to perform the request. (required)
   * @param batchObject  (required)
   * @return BatchResponse
   */
  @RequestLine("POST /1/indexes/{indexName}/batch")
  @Headers({ "Content-Type: application/json", "Accept: application/json" })
  BatchResponse batch(
    @Param("indexName") String indexName,
    BatchObject batchObject
  );

  /**
   *
   * Similar to <code>batch</code> but it also returns the http response headers .
   * Performs multiple write operations in a single API call.
   * @param indexName The index in which to perform the request. (required)
   * @param batchObject  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /1/indexes/{indexName}/batch")
  @Headers({ "Content-Type: application/json", "Accept: application/json" })
  ApiResponse<BatchResponse> batchWithHttpInfo(
    @Param("indexName") String indexName,
    BatchObject batchObject
  );

  /**
   * Delete index.
   * Delete an existing index.
   * @param indexName The index in which to perform the request. (required)
   * @return DeleteIndexResponse
   */
  @RequestLine("DELETE /1/indexes/{indexName}")
  @Headers({ "Accept: application/json" })
  DeleteIndexResponse deleteIndex(@Param("indexName") String indexName);

  /**
   * Delete index.
   * Similar to <code>deleteIndex</code> but it also returns the http response headers .
   * Delete an existing index.
   * @param indexName The index in which to perform the request. (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("DELETE /1/indexes/{indexName}")
  @Headers({ "Accept: application/json" })
  ApiResponse<DeleteIndexResponse> deleteIndexWithHttpInfo(
    @Param("indexName") String indexName
  );

  /**
   *
   * Retrieve settings of a given indexName.
   * @param indexName The index in which to perform the request. (required)
   * @return IndexSettings
   */
  @RequestLine("GET /1/indexes/{indexName}/settings")
  @Headers({ "Accept: application/json" })
  IndexSettings getSettings(@Param("indexName") String indexName);

  /**
   *
   * Similar to <code>getSettings</code> but it also returns the http response headers .
   * Retrieve settings of a given indexName.
   * @param indexName The index in which to perform the request. (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /1/indexes/{indexName}/settings")
  @Headers({ "Accept: application/json" })
  ApiResponse<IndexSettings> getSettingsWithHttpInfo(
    @Param("indexName") String indexName
  );

  /**
   * List existing indexes.
   * List existing indexes from an application.
   * @param page Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination). (optional)
   * @return ListIndicesResponse
   */
  @RequestLine("GET /1/indexes?Page={page}")
  @Headers({ "Accept: application/json" })
  ListIndicesResponse listIndices(@Param("page") Integer page);

  /**
   * List existing indexes.
   * Similar to <code>listIndices</code> but it also returns the http response headers .
   * List existing indexes from an application.
   * @param page Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination). (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /1/indexes?Page={page}")
  @Headers({ "Accept: application/json" })
  ApiResponse<ListIndicesResponse> listIndicesWithHttpInfo(
    @Param("page") Integer page
  );

  /**
   * List existing indexes.
   * List existing indexes from an application.
   * Note, this is equivalent to the other <code>listIndices</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link ListIndicesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page - Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination). (optional)</li>
   *   </ul>
   * @return ListIndicesResponse
   */
  @RequestLine("GET /1/indexes?Page={page}")
  @Headers({ "Accept: application/json" })
  ListIndicesResponse listIndices(
    @QueryMap(encoded = true) Map<String, Object> queryParams
  );

  /**
   * List existing indexes.
   * List existing indexes from an application.
   * Note, this is equivalent to the other <code>listIndices</code> that receives the query parameters as a map,
   * but this one also exposes the Http response headers
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page - Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination). (optional)</li>
   *   </ul>
   * @return ListIndicesResponse
   */
  @RequestLine("GET /1/indexes?Page={page}")
  @Headers({ "Accept: application/json" })
  ApiResponse<ListIndicesResponse> listIndicesWithHttpInfo(
    @QueryMap(encoded = true) Map<String, Object> queryParams
  );

  /**
   * A convenience class for generating query parameters for the
   * <code>listIndices</code> method in a fluent style.
   */
  public static class ListIndicesQueryParams extends HashMap<String, Object> {

    public ListIndicesQueryParams page(final Integer value) {
      put("Page", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   *
   * Get search results for the given requests.
   * @param multipleQueriesObject  (required)
   * @return MultipleQueriesResponse
   */
  @RequestLine("POST /1/indexes/*/queries")
  @Headers({ "Content-Type: application/json", "Accept: application/json" })
  MultipleQueriesResponse multipleQueries(
    MultipleQueriesObject multipleQueriesObject
  );

  /**
   *
   * Similar to <code>multipleQueries</code> but it also returns the http response headers .
   * Get search results for the given requests.
   * @param multipleQueriesObject  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /1/indexes/*/queries")
  @Headers({ "Content-Type: application/json", "Accept: application/json" })
  ApiResponse<MultipleQueriesResponse> multipleQueriesWithHttpInfo(
    MultipleQueriesObject multipleQueriesObject
  );

  /**
   * Copy/move index.
   * Peforms a copy or a move operation on a index.
   * @param indexName The index in which to perform the request. (required)
   * @param operationIndexObject  (required)
   * @return OperationIndexResponse
   */
  @RequestLine("POST /1/indexes/{indexName}/operation")
  @Headers({ "Content-Type: application/json", "Accept: application/json" })
  OperationIndexResponse operationIndex(
    @Param("indexName") String indexName,
    OperationIndexObject operationIndexObject
  );

  /**
   * Copy/move index.
   * Similar to <code>operationIndex</code> but it also returns the http response headers .
   * Peforms a copy or a move operation on a index.
   * @param indexName The index in which to perform the request. (required)
   * @param operationIndexObject  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /1/indexes/{indexName}/operation")
  @Headers({ "Content-Type: application/json", "Accept: application/json" })
  ApiResponse<OperationIndexResponse> operationIndexWithHttpInfo(
    @Param("indexName") String indexName,
    OperationIndexObject operationIndexObject
  );

  /**
   *
   * Add an object to the index, automatically assigning it an object ID.
   * @param indexName The index in which to perform the request. (required)
   * @param requestBody The Algolia object. (required)
   * @return SaveObjectResponse
   */
  @RequestLine("POST /1/indexes/{indexName}")
  @Headers({ "Content-Type: application/json", "Accept: application/json" })
  SaveObjectResponse saveObject(
    @Param("indexName") String indexName,
    Map<String, Object> requestBody
  );

  /**
   *
   * Similar to <code>saveObject</code> but it also returns the http response headers .
   * Add an object to the index, automatically assigning it an object ID.
   * @param indexName The index in which to perform the request. (required)
   * @param requestBody The Algolia object. (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /1/indexes/{indexName}")
  @Headers({ "Content-Type: application/json", "Accept: application/json" })
  ApiResponse<SaveObjectResponse> saveObjectWithHttpInfo(
    @Param("indexName") String indexName,
    Map<String, Object> requestBody
  );

  /**
   *
   * Get search results.
   * @param indexName The index in which to perform the request. (required)
   * @param UNKNOWN_BASE_TYPE  (required)
   * @return SearchResponse
   */
  @RequestLine("POST /1/indexes/{indexName}/query")
  @Headers({ "Content-Type: application/json", "Accept: application/json" })
  SearchResponse search(
    @Param("indexName") String indexName,
    UNKNOWN_BASE_TYPE UNKNOWN_BASE_TYPE
  );

  /**
   *
   * Similar to <code>search</code> but it also returns the http response headers .
   * Get search results.
   * @param indexName The index in which to perform the request. (required)
   * @param UNKNOWN_BASE_TYPE  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /1/indexes/{indexName}/query")
  @Headers({ "Content-Type: application/json", "Accept: application/json" })
  ApiResponse<SearchResponse> searchWithHttpInfo(
    @Param("indexName") String indexName,
    UNKNOWN_BASE_TYPE UNKNOWN_BASE_TYPE
  );

  /**
   *
   * Update settings of a given indexName. Only specified settings are overridden; unspecified settings are left unchanged. Specifying null for a setting resets it to its default value.
   * @param indexName The index in which to perform the request. (required)
   * @param indexSettings  (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given indexName. (optional)
   * @return SetSettingsResponse
   */
  @RequestLine(
    "PUT /1/indexes/{indexName}/settings?forwardToReplicas={forwardToReplicas}"
  )
  @Headers({ "Content-Type: application/json", "Accept: application/json" })
  SetSettingsResponse setSettings(
    @Param("indexName") String indexName,
    IndexSettings indexSettings,
    @Param("forwardToReplicas") Boolean forwardToReplicas
  );

  /**
   *
   * Similar to <code>setSettings</code> but it also returns the http response headers .
   * Update settings of a given indexName. Only specified settings are overridden; unspecified settings are left unchanged. Specifying null for a setting resets it to its default value.
   * @param indexName The index in which to perform the request. (required)
   * @param indexSettings  (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given indexName. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine(
    "PUT /1/indexes/{indexName}/settings?forwardToReplicas={forwardToReplicas}"
  )
  @Headers({ "Content-Type: application/json", "Accept: application/json" })
  ApiResponse<SetSettingsResponse> setSettingsWithHttpInfo(
    @Param("indexName") String indexName,
    IndexSettings indexSettings,
    @Param("forwardToReplicas") Boolean forwardToReplicas
  );

  /**
   *
   * Update settings of a given indexName. Only specified settings are overridden; unspecified settings are left unchanged. Specifying null for a setting resets it to its default value.
   * Note, this is equivalent to the other <code>setSettings</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SetSettingsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param indexName The index in which to perform the request. (required)
   * @param indexSettings  (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>forwardToReplicas - When true, changes are also propagated to replicas of the given indexName. (optional)</li>
   *   </ul>
   * @return SetSettingsResponse
   */
  @RequestLine(
    "PUT /1/indexes/{indexName}/settings?forwardToReplicas={forwardToReplicas}"
  )
  @Headers({ "Content-Type: application/json", "Accept: application/json" })
  SetSettingsResponse setSettings(
    @Param("indexName") String indexName,
    IndexSettings indexSettings,
    @QueryMap(encoded = true) Map<String, Object> queryParams
  );

  /**
   *
   * Update settings of a given indexName. Only specified settings are overridden; unspecified settings are left unchanged. Specifying null for a setting resets it to its default value.
   * Note, this is equivalent to the other <code>setSettings</code> that receives the query parameters as a map,
   * but this one also exposes the Http response headers
   * @param indexName The index in which to perform the request. (required)
   * @param indexSettings  (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>forwardToReplicas - When true, changes are also propagated to replicas of the given indexName. (optional)</li>
   *   </ul>
   * @return SetSettingsResponse
   */
  @RequestLine(
    "PUT /1/indexes/{indexName}/settings?forwardToReplicas={forwardToReplicas}"
  )
  @Headers({ "Content-Type: application/json", "Accept: application/json" })
  ApiResponse<SetSettingsResponse> setSettingsWithHttpInfo(
    @Param("indexName") String indexName,
    IndexSettings indexSettings,
    @QueryMap(encoded = true) Map<String, Object> queryParams
  );

  /**
   * A convenience class for generating query parameters for the
   * <code>setSettings</code> method in a fluent style.
   */
  public static class SetSettingsQueryParams extends HashMap<String, Object> {

    public SetSettingsQueryParams forwardToReplicas(final Boolean value) {
      put("forwardToReplicas", EncodingUtils.encode(value));
      return this;
    }
  }
}
