package com.algolia.search;

import com.algolia.ApiCallback;
import com.algolia.ApiClient;
import com.algolia.ApiException;
import com.algolia.ApiResponse;
import com.algolia.Pair;
import com.algolia.model.AddApiKeyResponse;
import com.algolia.model.ApiKey;
import com.algolia.model.AssignUserIdObject;
import com.algolia.model.BatchAssignUserIdsObject;
import com.algolia.model.BatchDictionaryEntries;
import com.algolia.model.BatchObject;
import com.algolia.model.BatchResponse;
import com.algolia.model.BatchWriteObject;
import com.algolia.model.BrowseRequest;
import com.algolia.model.BrowseResponse;
import com.algolia.model.CreatedAtResponse;
import com.algolia.model.DeleteApiKeyResponse;
import com.algolia.model.DeleteSourceResponse;
import com.algolia.model.DeletedAtResponse;
import com.algolia.model.DictionarySettingsRequest;
import com.algolia.model.GetDictionarySettingsResponse;
import com.algolia.model.GetLogsResponse;
import com.algolia.model.GetObjectsObject;
import com.algolia.model.GetObjectsResponse;
import com.algolia.model.GetTaskResponse;
import com.algolia.model.GetTopUserIdsResponse;
import com.algolia.model.IndexSettings;
import com.algolia.model.KeyObject;
import com.algolia.model.Languages;
import com.algolia.model.ListApiKeysResponse;
import com.algolia.model.ListClustersResponse;
import com.algolia.model.ListIndicesResponse;
import com.algolia.model.ListUserIdsResponse;
import com.algolia.model.MultipleBatchResponse;
import com.algolia.model.MultipleQueriesObject;
import com.algolia.model.MultipleQueriesResponse;
import com.algolia.model.OneOfstringbuiltInOperation;
import com.algolia.model.OperationIndexObject;
import com.algolia.model.RemoveUserIdResponse;
import com.algolia.model.ReplaceSourceResponse;
import com.algolia.model.Rule;
import com.algolia.model.SaveObjectResponse;
import com.algolia.model.SaveSynonymResponse;
import com.algolia.model.SearchDictionaryEntries;
import com.algolia.model.SearchForFacetValuesRequest;
import com.algolia.model.SearchForFacetValuesResponse;
import com.algolia.model.SearchParams;
import com.algolia.model.SearchResponse;
import com.algolia.model.SearchRulesParams;
import com.algolia.model.SearchRulesResponse;
import com.algolia.model.SearchSynonymsResponse;
import com.algolia.model.SearchUserIdsObject;
import com.algolia.model.SearchUserIdsResponse;
import com.algolia.model.Source;
import com.algolia.model.SynonymHit;
import com.algolia.model.UpdateApiKeyResponse;
import com.algolia.model.UpdatedAtResponse;
import com.algolia.model.UpdatedAtWithObjectIdResponse;
import com.algolia.model.UpdatedRuleResponse;
import com.algolia.model.UserId;
import com.algolia.utils.*;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Call;

public class SearchApi extends ApiClient {

  public SearchApi(String appId, String apiKey) {
    super(appId, apiKey, new HttpRequester());
  }

  public SearchApi(String appId, String apiKey, Requester requester) {
    super(appId, apiKey, requester);
  }

  /**
   * Build call for addApiKey
   *
   * @param apiKey (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object addApiKeyCall(ApiKey apiKey, final ApiCallback _callback)
    throws ApiException {
    Object bodyObj = apiKey;

    // create path and map variables
    String path = "/1/keys";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object addApiKeyValidateBeforeCall(
    ApiKey apiKey,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'apiKey' is set
    if (apiKey == null) {
      throw new ApiException(
        "Missing the required parameter 'apiKey' when calling addApiKey(Async)"
      );
    }

    return addApiKeyCall(apiKey, _callback);
  }

  /**
   * Add a new API Key with specific permissions/restrictions.
   *
   * @param apiKey (required)
   * @return AddApiKeyResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T addApiKey(ApiKey apiKey) throws ApiException {
    Object req = addApiKeyValidateBeforeCall(apiKey, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<AddApiKeyResponse>() {}.getType();
      ApiResponse<AddApiKeyResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Add a new API Key with specific permissions/restrictions.
   *
   * @param apiKey (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call addApiKeyAsync(
    ApiKey apiKey,
    final ApiCallback<AddApiKeyResponse> _callback
  ) throws ApiException {
    Call call = (Call) addApiKeyValidateBeforeCall(apiKey, _callback);
    Type returnType = new TypeToken<AddApiKeyResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for addOrUpdateObject
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param body The Algolia object. (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object addOrUpdateObjectCall(
    String indexName,
    String objectID,
    Object body,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = body;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/{objectID}".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        )
        .replaceAll(
          "\\{" + "objectID" + "\\}",
          this.escapeString(objectID.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "PUT",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object addOrUpdateObjectValidateBeforeCall(
    String indexName,
    String objectID,
    Object body,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling addOrUpdateObject(Async)"
      );
    }

    // verify the required parameter 'objectID' is set
    if (objectID == null) {
      throw new ApiException(
        "Missing the required parameter 'objectID' when calling addOrUpdateObject(Async)"
      );
    }

    // verify the required parameter 'body' is set
    if (body == null) {
      throw new ApiException(
        "Missing the required parameter 'body' when calling addOrUpdateObject(Async)"
      );
    }

    return addOrUpdateObjectCall(indexName, objectID, body, _callback);
  }

  /**
   * Add or replace an object with a given object ID. If the object does not exist, it will be
   * created. If it already exists, it will be replaced.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param body The Algolia object. (required)
   * @return UpdatedAtWithObjectIdResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T addOrUpdateObject(
    String indexName,
    String objectID,
    Object body
  ) throws ApiException {
    Object req = addOrUpdateObjectValidateBeforeCall(
      indexName,
      objectID,
      body,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<UpdatedAtWithObjectIdResponse>() {}
        .getType();
      ApiResponse<UpdatedAtWithObjectIdResponse> res =
        this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Add or replace an object with a given object ID. If the object does not exist,
   * it will be created. If it already exists, it will be replaced.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param body The Algolia object. (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call addOrUpdateObjectAsync(
    String indexName,
    String objectID,
    Object body,
    final ApiCallback<UpdatedAtWithObjectIdResponse> _callback
  ) throws ApiException {
    Call call = (Call) addOrUpdateObjectValidateBeforeCall(
      indexName,
      objectID,
      body,
      _callback
    );
    Type returnType = new TypeToken<UpdatedAtWithObjectIdResponse>() {}
      .getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for appendSource
   *
   * @param source The source to add. (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object appendSourceCall(Source source, final ApiCallback _callback)
    throws ApiException {
    Object bodyObj = source;

    // create path and map variables
    String path = "/1/security/sources/append";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object appendSourceValidateBeforeCall(
    Source source,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'source' is set
    if (source == null) {
      throw new ApiException(
        "Missing the required parameter 'source' when calling appendSource(Async)"
      );
    }

    return appendSourceCall(source, _callback);
  }

  /**
   * Add a single source to the list of allowed sources.
   *
   * @param source The source to add. (required)
   * @return CreatedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T appendSource(Source source) throws ApiException {
    Object req = appendSourceValidateBeforeCall(source, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<CreatedAtResponse>() {}.getType();
      ApiResponse<CreatedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Add a single source to the list of allowed sources.
   *
   * @param source The source to add. (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call appendSourceAsync(
    Source source,
    final ApiCallback<CreatedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) appendSourceValidateBeforeCall(source, _callback);
    Type returnType = new TypeToken<CreatedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for assignUserId
   *
   * @param xAlgoliaUserID userID to assign. (required)
   * @param assignUserIdObject (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object assignUserIdCall(
    String xAlgoliaUserID,
    AssignUserIdObject assignUserIdObject,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = assignUserIdObject;

    // create path and map variables
    String path = "/1/clusters/mapping";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (xAlgoliaUserID != null) {
      queryParams.addAll(
        this.parameterToPair("X-Algolia-User-ID", xAlgoliaUserID)
      );
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object assignUserIdValidateBeforeCall(
    String xAlgoliaUserID,
    AssignUserIdObject assignUserIdObject,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'xAlgoliaUserID' is set
    if (xAlgoliaUserID == null) {
      throw new ApiException(
        "Missing the required parameter 'xAlgoliaUserID' when calling assignUserId(Async)"
      );
    }

    // verify the required parameter 'assignUserIdObject' is set
    if (assignUserIdObject == null) {
      throw new ApiException(
        "Missing the required parameter 'assignUserIdObject' when calling assignUserId(Async)"
      );
    }

    return assignUserIdCall(xAlgoliaUserID, assignUserIdObject, _callback);
  }

  /**
   * Assign or Move a userID to a cluster. The time it takes to migrate (move) a user is
   * proportional to the amount of data linked to the userID. Upon success, the response is 200 OK.
   * A successful response indicates that the operation has been taken into account, and the userID
   * is directly usable.
   *
   * @param xAlgoliaUserID userID to assign. (required)
   * @param assignUserIdObject (required)
   * @return CreatedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T assignUserId(
    String xAlgoliaUserID,
    AssignUserIdObject assignUserIdObject
  ) throws ApiException {
    Object req = assignUserIdValidateBeforeCall(
      xAlgoliaUserID,
      assignUserIdObject,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<CreatedAtResponse>() {}.getType();
      ApiResponse<CreatedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Assign or Move a userID to a cluster. The time it takes to migrate (move) a
   * user is proportional to the amount of data linked to the userID. Upon success, the response is
   * 200 OK. A successful response indicates that the operation has been taken into account, and the
   * userID is directly usable.
   *
   * @param xAlgoliaUserID userID to assign. (required)
   * @param assignUserIdObject (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call assignUserIdAsync(
    String xAlgoliaUserID,
    AssignUserIdObject assignUserIdObject,
    final ApiCallback<CreatedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) assignUserIdValidateBeforeCall(
      xAlgoliaUserID,
      assignUserIdObject,
      _callback
    );
    Type returnType = new TypeToken<CreatedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for batch
   *
   * @param indexName The index in which to perform the request. (required)
   * @param batchWriteObject (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object batchCall(
    String indexName,
    BatchWriteObject batchWriteObject,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = batchWriteObject;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/batch".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object batchValidateBeforeCall(
    String indexName,
    BatchWriteObject batchWriteObject,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling batch(Async)"
      );
    }

    // verify the required parameter 'batchWriteObject' is set
    if (batchWriteObject == null) {
      throw new ApiException(
        "Missing the required parameter 'batchWriteObject' when calling batch(Async)"
      );
    }

    return batchCall(indexName, batchWriteObject, _callback);
  }

  /**
   * Performs multiple write operations in a single API call.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param batchWriteObject (required)
   * @return BatchResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T batch(String indexName, BatchWriteObject batchWriteObject)
    throws ApiException {
    Object req = batchValidateBeforeCall(indexName, batchWriteObject, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<BatchResponse>() {}.getType();
      ApiResponse<BatchResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Performs multiple write operations in a single API call.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param batchWriteObject (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call batchAsync(
    String indexName,
    BatchWriteObject batchWriteObject,
    final ApiCallback<BatchResponse> _callback
  ) throws ApiException {
    Call call = (Call) batchValidateBeforeCall(
      indexName,
      batchWriteObject,
      _callback
    );
    Type returnType = new TypeToken<BatchResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for batchAssignUserIds
   *
   * @param xAlgoliaUserID userID to assign. (required)
   * @param batchAssignUserIdsObject (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object batchAssignUserIdsCall(
    String xAlgoliaUserID,
    BatchAssignUserIdsObject batchAssignUserIdsObject,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = batchAssignUserIdsObject;

    // create path and map variables
    String path = "/1/clusters/mapping/batch";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (xAlgoliaUserID != null) {
      queryParams.addAll(
        this.parameterToPair("X-Algolia-User-ID", xAlgoliaUserID)
      );
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object batchAssignUserIdsValidateBeforeCall(
    String xAlgoliaUserID,
    BatchAssignUserIdsObject batchAssignUserIdsObject,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'xAlgoliaUserID' is set
    if (xAlgoliaUserID == null) {
      throw new ApiException(
        "Missing the required parameter 'xAlgoliaUserID' when calling batchAssignUserIds(Async)"
      );
    }

    // verify the required parameter 'batchAssignUserIdsObject' is set
    if (batchAssignUserIdsObject == null) {
      throw new ApiException(
        "Missing the required parameter 'batchAssignUserIdsObject' when calling" +
        " batchAssignUserIds(Async)"
      );
    }

    return batchAssignUserIdsCall(
      xAlgoliaUserID,
      batchAssignUserIdsObject,
      _callback
    );
  }

  /**
   * Assign multiple userIDs to a cluster. Upon success, the response is 200 OK. A successful
   * response indicates that the operation has been taken into account, and the userIDs are directly
   * usable.
   *
   * @param xAlgoliaUserID userID to assign. (required)
   * @param batchAssignUserIdsObject (required)
   * @return CreatedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T batchAssignUserIds(
    String xAlgoliaUserID,
    BatchAssignUserIdsObject batchAssignUserIdsObject
  ) throws ApiException {
    Object req = batchAssignUserIdsValidateBeforeCall(
      xAlgoliaUserID,
      batchAssignUserIdsObject,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<CreatedAtResponse>() {}.getType();
      ApiResponse<CreatedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Assign multiple userIDs to a cluster. Upon success, the response is 200 OK. A
   * successful response indicates that the operation has been taken into account, and the userIDs
   * are directly usable.
   *
   * @param xAlgoliaUserID userID to assign. (required)
   * @param batchAssignUserIdsObject (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call batchAssignUserIdsAsync(
    String xAlgoliaUserID,
    BatchAssignUserIdsObject batchAssignUserIdsObject,
    final ApiCallback<CreatedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) batchAssignUserIdsValidateBeforeCall(
      xAlgoliaUserID,
      batchAssignUserIdsObject,
      _callback
    );
    Type returnType = new TypeToken<CreatedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for batchDictionaryEntries
   *
   * @param dictionaryName The dictionary to search in. (required)
   * @param batchDictionaryEntries (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object batchDictionaryEntriesCall(
    String dictionaryName,
    BatchDictionaryEntries batchDictionaryEntries,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = batchDictionaryEntries;

    // create path and map variables
    String path =
      "/1/dictionaries/{dictionaryName}/batch".replaceAll(
          "\\{" + "dictionaryName" + "\\}",
          this.escapeString(dictionaryName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object batchDictionaryEntriesValidateBeforeCall(
    String dictionaryName,
    BatchDictionaryEntries batchDictionaryEntries,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'dictionaryName' is set
    if (dictionaryName == null) {
      throw new ApiException(
        "Missing the required parameter 'dictionaryName' when calling" +
        " batchDictionaryEntries(Async)"
      );
    }

    // verify the required parameter 'batchDictionaryEntries' is set
    if (batchDictionaryEntries == null) {
      throw new ApiException(
        "Missing the required parameter 'batchDictionaryEntries' when calling" +
        " batchDictionaryEntries(Async)"
      );
    }

    return batchDictionaryEntriesCall(
      dictionaryName,
      batchDictionaryEntries,
      _callback
    );
  }

  /**
   * Send a batch of dictionary entries.
   *
   * @param dictionaryName The dictionary to search in. (required)
   * @param batchDictionaryEntries (required)
   * @return UpdatedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T batchDictionaryEntries(
    String dictionaryName,
    BatchDictionaryEntries batchDictionaryEntries
  ) throws ApiException {
    Object req = batchDictionaryEntriesValidateBeforeCall(
      dictionaryName,
      batchDictionaryEntries,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
      ApiResponse<UpdatedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Send a batch of dictionary entries.
   *
   * @param dictionaryName The dictionary to search in. (required)
   * @param batchDictionaryEntries (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call batchDictionaryEntriesAsync(
    String dictionaryName,
    BatchDictionaryEntries batchDictionaryEntries,
    final ApiCallback<UpdatedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) batchDictionaryEntriesValidateBeforeCall(
      dictionaryName,
      batchDictionaryEntries,
      _callback
    );
    Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for batchRules
   *
   * @param indexName The index in which to perform the request. (required)
   * @param rule (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param clearExistingRules When true, existing Rules are cleared before adding this batch. When
   *     false, existing Rules are kept. (optional)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object batchRulesCall(
    String indexName,
    List<Rule> rule,
    Boolean forwardToReplicas,
    Boolean clearExistingRules,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = rule;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/rules/batch".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (forwardToReplicas != null) {
      queryParams.addAll(
        this.parameterToPair("forwardToReplicas", forwardToReplicas)
      );
    }

    if (clearExistingRules != null) {
      queryParams.addAll(
        this.parameterToPair("clearExistingRules", clearExistingRules)
      );
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object batchRulesValidateBeforeCall(
    String indexName,
    List<Rule> rule,
    Boolean forwardToReplicas,
    Boolean clearExistingRules,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling batchRules(Async)"
      );
    }

    // verify the required parameter 'rule' is set
    if (rule == null) {
      throw new ApiException(
        "Missing the required parameter 'rule' when calling batchRules(Async)"
      );
    }

    return batchRulesCall(
      indexName,
      rule,
      forwardToReplicas,
      clearExistingRules,
      _callback
    );
  }

  /**
   * Create or update a batch of Rules.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param rule (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param clearExistingRules When true, existing Rules are cleared before adding this batch. When
   *     false, existing Rules are kept. (optional)
   * @return UpdatedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T batchRules(
    String indexName,
    List<Rule> rule,
    Boolean forwardToReplicas,
    Boolean clearExistingRules
  ) throws ApiException {
    Object req = batchRulesValidateBeforeCall(
      indexName,
      rule,
      forwardToReplicas,
      clearExistingRules,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
      ApiResponse<UpdatedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Create or update a batch of Rules.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param rule (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param clearExistingRules When true, existing Rules are cleared before adding this batch. When
   *     false, existing Rules are kept. (optional)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call batchRulesAsync(
    String indexName,
    List<Rule> rule,
    Boolean forwardToReplicas,
    Boolean clearExistingRules,
    final ApiCallback<UpdatedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) batchRulesValidateBeforeCall(
      indexName,
      rule,
      forwardToReplicas,
      clearExistingRules,
      _callback
    );
    Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for browse
   *
   * @param indexName The index in which to perform the request. (required)
   * @param browseRequest (optional)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object browseCall(
    String indexName,
    BrowseRequest browseRequest,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = browseRequest;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/browse".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object browseValidateBeforeCall(
    String indexName,
    BrowseRequest browseRequest,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling browse(Async)"
      );
    }

    return browseCall(indexName, browseRequest, _callback);
  }

  /**
   * This method allows you to retrieve all index content. It can retrieve up to 1,000 records per
   * call and supports full text search and filters. For performance reasons, some features are not
   * supported, including `distinct`, sorting by `typos`, `words` or `geo distance`. When there is
   * more content to be browsed, the response contains a cursor field. This cursor has to be passed
   * to the subsequent call to browse in order to get the next page of results. When the end of the
   * index has been reached, the cursor field is absent from the response.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param browseRequest (optional)
   * @return BrowseResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T browse(String indexName, BrowseRequest browseRequest)
    throws ApiException {
    Object req = browseValidateBeforeCall(indexName, browseRequest, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<BrowseResponse>() {}.getType();
      ApiResponse<BrowseResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) This method allows you to retrieve all index content. It can retrieve up to
   * 1,000 records per call and supports full text search and filters. For performance reasons, some
   * features are not supported, including &#x60;distinct&#x60;, sorting by &#x60;typos&#x60;,
   * &#x60;words&#x60; or &#x60;geo distance&#x60;. When there is more content to be browsed, the
   * response contains a cursor field. This cursor has to be passed to the subsequent call to browse
   * in order to get the next page of results. When the end of the index has been reached, the
   * cursor field is absent from the response.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param browseRequest (optional)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call browseAsync(
    String indexName,
    BrowseRequest browseRequest,
    final ApiCallback<BrowseResponse> _callback
  ) throws ApiException {
    Call call = (Call) browseValidateBeforeCall(
      indexName,
      browseRequest,
      _callback
    );
    Type returnType = new TypeToken<BrowseResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for clearAllSynonyms
   *
   * @param indexName The index in which to perform the request. (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object clearAllSynonymsCall(
    String indexName,
    Boolean forwardToReplicas,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/synonyms/clear".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (forwardToReplicas != null) {
      queryParams.addAll(
        this.parameterToPair("forwardToReplicas", forwardToReplicas)
      );
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object clearAllSynonymsValidateBeforeCall(
    String indexName,
    Boolean forwardToReplicas,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling clearAllSynonyms(Async)"
      );
    }

    return clearAllSynonymsCall(indexName, forwardToReplicas, _callback);
  }

  /**
   * Remove all synonyms from an index.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @return UpdatedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T clearAllSynonyms(String indexName, Boolean forwardToReplicas)
    throws ApiException {
    Object req = clearAllSynonymsValidateBeforeCall(
      indexName,
      forwardToReplicas,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
      ApiResponse<UpdatedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Remove all synonyms from an index.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call clearAllSynonymsAsync(
    String indexName,
    Boolean forwardToReplicas,
    final ApiCallback<UpdatedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) clearAllSynonymsValidateBeforeCall(
      indexName,
      forwardToReplicas,
      _callback
    );
    Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for clearObjects
   *
   * @param indexName The index in which to perform the request. (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object clearObjectsCall(
    String indexName,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/clear".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object clearObjectsValidateBeforeCall(
    String indexName,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling clearObjects(Async)"
      );
    }

    return clearObjectsCall(indexName, _callback);
  }

  /**
   * Delete an index's content, but leave settings and index-specific API keys untouched.
   *
   * @param indexName The index in which to perform the request. (required)
   * @return UpdatedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T clearObjects(String indexName) throws ApiException {
    Object req = clearObjectsValidateBeforeCall(indexName, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
      ApiResponse<UpdatedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Delete an index&#39;s content, but leave settings and index-specific API keys
   * untouched.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call clearObjectsAsync(
    String indexName,
    final ApiCallback<UpdatedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) clearObjectsValidateBeforeCall(indexName, _callback);
    Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for clearRules
   *
   * @param indexName The index in which to perform the request. (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object clearRulesCall(
    String indexName,
    Boolean forwardToReplicas,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/rules/clear".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (forwardToReplicas != null) {
      queryParams.addAll(
        this.parameterToPair("forwardToReplicas", forwardToReplicas)
      );
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object clearRulesValidateBeforeCall(
    String indexName,
    Boolean forwardToReplicas,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling clearRules(Async)"
      );
    }

    return clearRulesCall(indexName, forwardToReplicas, _callback);
  }

  /**
   * Delete all Rules in the index.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @return UpdatedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T clearRules(String indexName, Boolean forwardToReplicas)
    throws ApiException {
    Object req = clearRulesValidateBeforeCall(
      indexName,
      forwardToReplicas,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
      ApiResponse<UpdatedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Delete all Rules in the index.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call clearRulesAsync(
    String indexName,
    Boolean forwardToReplicas,
    final ApiCallback<UpdatedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) clearRulesValidateBeforeCall(
      indexName,
      forwardToReplicas,
      _callback
    );
    Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for deleteApiKey
   *
   * @param key API Key string. (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object deleteApiKeyCall(String key, final ApiCallback _callback)
    throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/keys/{key}".replaceAll(
          "\\{" + "key" + "\\}",
          this.escapeString(key.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "DELETE",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object deleteApiKeyValidateBeforeCall(
    String key,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(
        "Missing the required parameter 'key' when calling deleteApiKey(Async)"
      );
    }

    return deleteApiKeyCall(key, _callback);
  }

  /**
   * Delete an existing API Key.
   *
   * @param key API Key string. (required)
   * @return DeleteApiKeyResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T deleteApiKey(String key) throws ApiException {
    Object req = deleteApiKeyValidateBeforeCall(key, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<DeleteApiKeyResponse>() {}.getType();
      ApiResponse<DeleteApiKeyResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Delete an existing API Key.
   *
   * @param key API Key string. (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call deleteApiKeyAsync(
    String key,
    final ApiCallback<DeleteApiKeyResponse> _callback
  ) throws ApiException {
    Call call = (Call) deleteApiKeyValidateBeforeCall(key, _callback);
    Type returnType = new TypeToken<DeleteApiKeyResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for deleteBy
   *
   * @param indexName The index in which to perform the request. (required)
   * @param searchParams (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object deleteByCall(
    String indexName,
    SearchParams searchParams,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = searchParams;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/deleteByQuery".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object deleteByValidateBeforeCall(
    String indexName,
    SearchParams searchParams,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling deleteBy(Async)"
      );
    }

    // verify the required parameter 'searchParams' is set
    if (searchParams == null) {
      throw new ApiException(
        "Missing the required parameter 'searchParams' when calling deleteBy(Async)"
      );
    }

    return deleteByCall(indexName, searchParams, _callback);
  }

  /**
   * Remove all objects matching a filter (including geo filters). This method enables you to delete
   * one or more objects based on filters (numeric, facet, tag or geo queries). It doesn't accept
   * empty filters or a query.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param searchParams (required)
   * @return DeletedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T deleteBy(String indexName, SearchParams searchParams)
    throws ApiException {
    Object req = deleteByValidateBeforeCall(indexName, searchParams, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<DeletedAtResponse>() {}.getType();
      ApiResponse<DeletedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Remove all objects matching a filter (including geo filters). This method
   * enables you to delete one or more objects based on filters (numeric, facet, tag or geo
   * queries). It doesn&#39;t accept empty filters or a query.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param searchParams (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call deleteByAsync(
    String indexName,
    SearchParams searchParams,
    final ApiCallback<DeletedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) deleteByValidateBeforeCall(
      indexName,
      searchParams,
      _callback
    );
    Type returnType = new TypeToken<DeletedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for deleteIndex
   *
   * @param indexName The index in which to perform the request. (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object deleteIndexCall(String indexName, final ApiCallback _callback)
    throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "DELETE",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object deleteIndexValidateBeforeCall(
    String indexName,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling deleteIndex(Async)"
      );
    }

    return deleteIndexCall(indexName, _callback);
  }

  /**
   * Delete an existing index.
   *
   * @param indexName The index in which to perform the request. (required)
   * @return DeletedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T deleteIndex(String indexName) throws ApiException {
    Object req = deleteIndexValidateBeforeCall(indexName, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<DeletedAtResponse>() {}.getType();
      ApiResponse<DeletedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Delete an existing index.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call deleteIndexAsync(
    String indexName,
    final ApiCallback<DeletedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) deleteIndexValidateBeforeCall(indexName, _callback);
    Type returnType = new TypeToken<DeletedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for deleteObject
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object deleteObjectCall(
    String indexName,
    String objectID,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/{objectID}".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        )
        .replaceAll(
          "\\{" + "objectID" + "\\}",
          this.escapeString(objectID.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "DELETE",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object deleteObjectValidateBeforeCall(
    String indexName,
    String objectID,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling deleteObject(Async)"
      );
    }

    // verify the required parameter 'objectID' is set
    if (objectID == null) {
      throw new ApiException(
        "Missing the required parameter 'objectID' when calling deleteObject(Async)"
      );
    }

    return deleteObjectCall(indexName, objectID, _callback);
  }

  /**
   * Delete an existing object.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @return DeletedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T deleteObject(String indexName, String objectID)
    throws ApiException {
    Object req = deleteObjectValidateBeforeCall(indexName, objectID, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<DeletedAtResponse>() {}.getType();
      ApiResponse<DeletedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Delete an existing object.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call deleteObjectAsync(
    String indexName,
    String objectID,
    final ApiCallback<DeletedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) deleteObjectValidateBeforeCall(
      indexName,
      objectID,
      _callback
    );
    Type returnType = new TypeToken<DeletedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for deleteRule
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object deleteRuleCall(
    String indexName,
    String objectID,
    Boolean forwardToReplicas,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/rules/{objectID}".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        )
        .replaceAll(
          "\\{" + "objectID" + "\\}",
          this.escapeString(objectID.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (forwardToReplicas != null) {
      queryParams.addAll(
        this.parameterToPair("forwardToReplicas", forwardToReplicas)
      );
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "DELETE",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object deleteRuleValidateBeforeCall(
    String indexName,
    String objectID,
    Boolean forwardToReplicas,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling deleteRule(Async)"
      );
    }

    // verify the required parameter 'objectID' is set
    if (objectID == null) {
      throw new ApiException(
        "Missing the required parameter 'objectID' when calling deleteRule(Async)"
      );
    }

    return deleteRuleCall(indexName, objectID, forwardToReplicas, _callback);
  }

  /**
   * Delete the Rule with the specified objectID.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @return UpdatedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T deleteRule(
    String indexName,
    String objectID,
    Boolean forwardToReplicas
  ) throws ApiException {
    Object req = deleteRuleValidateBeforeCall(
      indexName,
      objectID,
      forwardToReplicas,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
      ApiResponse<UpdatedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Delete the Rule with the specified objectID.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call deleteRuleAsync(
    String indexName,
    String objectID,
    Boolean forwardToReplicas,
    final ApiCallback<UpdatedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) deleteRuleValidateBeforeCall(
      indexName,
      objectID,
      forwardToReplicas,
      _callback
    );
    Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for deleteSource
   *
   * @param source The IP range of the source. (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object deleteSourceCall(String source, final ApiCallback _callback)
    throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/security/sources/{source}".replaceAll(
          "\\{" + "source" + "\\}",
          this.escapeString(source.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "DELETE",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object deleteSourceValidateBeforeCall(
    String source,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'source' is set
    if (source == null) {
      throw new ApiException(
        "Missing the required parameter 'source' when calling deleteSource(Async)"
      );
    }

    return deleteSourceCall(source, _callback);
  }

  /**
   * Remove a single source from the list of allowed sources.
   *
   * @param source The IP range of the source. (required)
   * @return DeleteSourceResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T deleteSource(String source) throws ApiException {
    Object req = deleteSourceValidateBeforeCall(source, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<DeleteSourceResponse>() {}.getType();
      ApiResponse<DeleteSourceResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Remove a single source from the list of allowed sources.
   *
   * @param source The IP range of the source. (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call deleteSourceAsync(
    String source,
    final ApiCallback<DeleteSourceResponse> _callback
  ) throws ApiException {
    Call call = (Call) deleteSourceValidateBeforeCall(source, _callback);
    Type returnType = new TypeToken<DeleteSourceResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for deleteSynonym
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object deleteSynonymCall(
    String indexName,
    String objectID,
    Boolean forwardToReplicas,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/synonyms/{objectID}".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        )
        .replaceAll(
          "\\{" + "objectID" + "\\}",
          this.escapeString(objectID.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (forwardToReplicas != null) {
      queryParams.addAll(
        this.parameterToPair("forwardToReplicas", forwardToReplicas)
      );
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "DELETE",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object deleteSynonymValidateBeforeCall(
    String indexName,
    String objectID,
    Boolean forwardToReplicas,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling deleteSynonym(Async)"
      );
    }

    // verify the required parameter 'objectID' is set
    if (objectID == null) {
      throw new ApiException(
        "Missing the required parameter 'objectID' when calling deleteSynonym(Async)"
      );
    }

    return deleteSynonymCall(indexName, objectID, forwardToReplicas, _callback);
  }

  /**
   * Delete a single synonyms set, identified by the given objectID.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @return DeletedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T deleteSynonym(
    String indexName,
    String objectID,
    Boolean forwardToReplicas
  ) throws ApiException {
    Object req = deleteSynonymValidateBeforeCall(
      indexName,
      objectID,
      forwardToReplicas,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<DeletedAtResponse>() {}.getType();
      ApiResponse<DeletedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Delete a single synonyms set, identified by the given objectID.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call deleteSynonymAsync(
    String indexName,
    String objectID,
    Boolean forwardToReplicas,
    final ApiCallback<DeletedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) deleteSynonymValidateBeforeCall(
      indexName,
      objectID,
      forwardToReplicas,
      _callback
    );
    Type returnType = new TypeToken<DeletedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for getApiKey
   *
   * @param key API Key string. (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object getApiKeyCall(String key, final ApiCallback _callback)
    throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/keys/{key}".replaceAll(
          "\\{" + "key" + "\\}",
          this.escapeString(key.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "GET",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object getApiKeyValidateBeforeCall(
    String key,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(
        "Missing the required parameter 'key' when calling getApiKey(Async)"
      );
    }

    return getApiKeyCall(key, _callback);
  }

  /**
   * Get the permissions of an API key.
   *
   * @param key API Key string. (required)
   * @return KeyObject
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T getApiKey(String key) throws ApiException {
    Object req = getApiKeyValidateBeforeCall(key, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<KeyObject>() {}.getType();
      ApiResponse<KeyObject> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Get the permissions of an API key.
   *
   * @param key API Key string. (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call getApiKeyAsync(
    String key,
    final ApiCallback<KeyObject> _callback
  ) throws ApiException {
    Call call = (Call) getApiKeyValidateBeforeCall(key, _callback);
    Type returnType = new TypeToken<KeyObject>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for getDictionaryLanguages
   *
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object getDictionaryLanguagesCall(final ApiCallback _callback)
    throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path = "/1/dictionaries/*/languages";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "GET",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object getDictionaryLanguagesValidateBeforeCall(
    final ApiCallback _callback
  ) throws ApiException {
    return getDictionaryLanguagesCall(_callback);
  }

  /**
   * List dictionaries supported per language.
   *
   * @return Map&lt;String, Languages&gt;
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T getDictionaryLanguages() throws ApiException {
    Object req = getDictionaryLanguagesValidateBeforeCall(null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<Map<String, Languages>>() {}.getType();
      ApiResponse<Map<String, Languages>> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) List dictionaries supported per language.
   *
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call getDictionaryLanguagesAsync(
    final ApiCallback<Map<String, Languages>> _callback
  ) throws ApiException {
    Call call = (Call) getDictionaryLanguagesValidateBeforeCall(_callback);
    Type returnType = new TypeToken<Map<String, Languages>>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for getDictionarySettings
   *
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object getDictionarySettingsCall(final ApiCallback _callback)
    throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path = "/1/dictionaries/*/settings";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "GET",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object getDictionarySettingsValidateBeforeCall(
    final ApiCallback _callback
  ) throws ApiException {
    return getDictionarySettingsCall(_callback);
  }

  /**
   * Retrieve dictionaries settings.
   *
   * @return GetDictionarySettingsResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T getDictionarySettings() throws ApiException {
    Object req = getDictionarySettingsValidateBeforeCall(null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<GetDictionarySettingsResponse>() {}
        .getType();
      ApiResponse<GetDictionarySettingsResponse> res =
        this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Retrieve dictionaries settings.
   *
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call getDictionarySettingsAsync(
    final ApiCallback<GetDictionarySettingsResponse> _callback
  ) throws ApiException {
    Call call = (Call) getDictionarySettingsValidateBeforeCall(_callback);
    Type returnType = new TypeToken<GetDictionarySettingsResponse>() {}
      .getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for getLogs
   *
   * @param offset First entry to retrieve (zero-based). Log entries are sorted by decreasing date,
   *     therefore 0 designates the most recent log entry. (optional, default to 0)
   * @param length Maximum number of entries to retrieve. The maximum allowed value is 1000.
   *     (optional, default to 10)
   * @param indexName Index for which log entries should be retrieved. When omitted, log entries are
   *     retrieved across all indices. (optional, default to null)
   * @param type Type of log entries to retrieve. When omitted, all log entries are retrieved.
   *     (optional, default to all)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object getLogsCall(
    Integer offset,
    Integer length,
    String indexName,
    String type,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path = "/1/logs";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (offset != null) {
      queryParams.addAll(this.parameterToPair("offset", offset));
    }

    if (length != null) {
      queryParams.addAll(this.parameterToPair("length", length));
    }

    if (indexName != null) {
      queryParams.addAll(this.parameterToPair("indexName", indexName));
    }

    if (type != null) {
      queryParams.addAll(this.parameterToPair("type", type));
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "GET",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object getLogsValidateBeforeCall(
    Integer offset,
    Integer length,
    String indexName,
    String type,
    final ApiCallback _callback
  ) throws ApiException {
    return getLogsCall(offset, length, indexName, type, _callback);
  }

  /**
   * Return the lastest log entries.
   *
   * @param offset First entry to retrieve (zero-based). Log entries are sorted by decreasing date,
   *     therefore 0 designates the most recent log entry. (optional, default to 0)
   * @param length Maximum number of entries to retrieve. The maximum allowed value is 1000.
   *     (optional, default to 10)
   * @param indexName Index for which log entries should be retrieved. When omitted, log entries are
   *     retrieved across all indices. (optional, default to null)
   * @param type Type of log entries to retrieve. When omitted, all log entries are retrieved.
   *     (optional, default to all)
   * @return GetLogsResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T getLogs(
    Integer offset,
    Integer length,
    String indexName,
    String type
  ) throws ApiException {
    Object req = getLogsValidateBeforeCall(
      offset,
      length,
      indexName,
      type,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<GetLogsResponse>() {}.getType();
      ApiResponse<GetLogsResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Return the lastest log entries.
   *
   * @param offset First entry to retrieve (zero-based). Log entries are sorted by decreasing date,
   *     therefore 0 designates the most recent log entry. (optional, default to 0)
   * @param length Maximum number of entries to retrieve. The maximum allowed value is 1000.
   *     (optional, default to 10)
   * @param indexName Index for which log entries should be retrieved. When omitted, log entries are
   *     retrieved across all indices. (optional, default to null)
   * @param type Type of log entries to retrieve. When omitted, all log entries are retrieved.
   *     (optional, default to all)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call getLogsAsync(
    Integer offset,
    Integer length,
    String indexName,
    String type,
    final ApiCallback<GetLogsResponse> _callback
  ) throws ApiException {
    Call call = (Call) getLogsValidateBeforeCall(
      offset,
      length,
      indexName,
      type,
      _callback
    );
    Type returnType = new TypeToken<GetLogsResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for getObject
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param attributesToRetrieve List of attributes to retrieve. If not specified, all retrievable
   *     attributes are returned. (optional)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object getObjectCall(
    String indexName,
    String objectID,
    List<String> attributesToRetrieve,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/{objectID}".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        )
        .replaceAll(
          "\\{" + "objectID" + "\\}",
          this.escapeString(objectID.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (attributesToRetrieve != null) {
      queryParams.addAll(
        this.parameterToPair("attributesToRetrieve", attributesToRetrieve)
      );
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "GET",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object getObjectValidateBeforeCall(
    String indexName,
    String objectID,
    List<String> attributesToRetrieve,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling getObject(Async)"
      );
    }

    // verify the required parameter 'objectID' is set
    if (objectID == null) {
      throw new ApiException(
        "Missing the required parameter 'objectID' when calling getObject(Async)"
      );
    }

    return getObjectCall(indexName, objectID, attributesToRetrieve, _callback);
  }

  /**
   * Retrieve one object from the index.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param attributesToRetrieve List of attributes to retrieve. If not specified, all retrievable
   *     attributes are returned. (optional)
   * @return Map&lt;String, String&gt;
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T getObject(
    String indexName,
    String objectID,
    List<String> attributesToRetrieve
  ) throws ApiException {
    Object req = getObjectValidateBeforeCall(
      indexName,
      objectID,
      attributesToRetrieve,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<Map<String, String>>() {}.getType();
      ApiResponse<Map<String, String>> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Retrieve one object from the index.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param attributesToRetrieve List of attributes to retrieve. If not specified, all retrievable
   *     attributes are returned. (optional)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call getObjectAsync(
    String indexName,
    String objectID,
    List<String> attributesToRetrieve,
    final ApiCallback<Map<String, String>> _callback
  ) throws ApiException {
    Call call = (Call) getObjectValidateBeforeCall(
      indexName,
      objectID,
      attributesToRetrieve,
      _callback
    );
    Type returnType = new TypeToken<Map<String, String>>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for getObjects
   *
   * @param getObjectsObject (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object getObjectsCall(
    GetObjectsObject getObjectsObject,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = getObjectsObject;

    // create path and map variables
    String path = "/1/indexes/*/objects";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object getObjectsValidateBeforeCall(
    GetObjectsObject getObjectsObject,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'getObjectsObject' is set
    if (getObjectsObject == null) {
      throw new ApiException(
        "Missing the required parameter 'getObjectsObject' when calling getObjects(Async)"
      );
    }

    return getObjectsCall(getObjectsObject, _callback);
  }

  /**
   * Retrieve one or more objects, potentially from different indices, in a single API call.
   *
   * @param getObjectsObject (required)
   * @return GetObjectsResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T getObjects(GetObjectsObject getObjectsObject)
    throws ApiException {
    Object req = getObjectsValidateBeforeCall(getObjectsObject, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<GetObjectsResponse>() {}.getType();
      ApiResponse<GetObjectsResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Retrieve one or more objects, potentially from different indices, in a single
   * API call.
   *
   * @param getObjectsObject (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call getObjectsAsync(
    GetObjectsObject getObjectsObject,
    final ApiCallback<GetObjectsResponse> _callback
  ) throws ApiException {
    Call call = (Call) getObjectsValidateBeforeCall(
      getObjectsObject,
      _callback
    );
    Type returnType = new TypeToken<GetObjectsResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for getRule
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object getRuleCall(
    String indexName,
    String objectID,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/rules/{objectID}".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        )
        .replaceAll(
          "\\{" + "objectID" + "\\}",
          this.escapeString(objectID.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "GET",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object getRuleValidateBeforeCall(
    String indexName,
    String objectID,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling getRule(Async)"
      );
    }

    // verify the required parameter 'objectID' is set
    if (objectID == null) {
      throw new ApiException(
        "Missing the required parameter 'objectID' when calling getRule(Async)"
      );
    }

    return getRuleCall(indexName, objectID, _callback);
  }

  /**
   * Retrieve the Rule with the specified objectID.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @return Rule
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T getRule(String indexName, String objectID) throws ApiException {
    Object req = getRuleValidateBeforeCall(indexName, objectID, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<Rule>() {}.getType();
      ApiResponse<Rule> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Retrieve the Rule with the specified objectID.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call getRuleAsync(
    String indexName,
    String objectID,
    final ApiCallback<Rule> _callback
  ) throws ApiException {
    Call call = (Call) getRuleValidateBeforeCall(
      indexName,
      objectID,
      _callback
    );
    Type returnType = new TypeToken<Rule>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for getSettings
   *
   * @param indexName The index in which to perform the request. (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object getSettingsCall(String indexName, final ApiCallback _callback)
    throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/settings".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "GET",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object getSettingsValidateBeforeCall(
    String indexName,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling getSettings(Async)"
      );
    }

    return getSettingsCall(indexName, _callback);
  }

  /**
   * Retrieve settings of a given indexName.
   *
   * @param indexName The index in which to perform the request. (required)
   * @return IndexSettings
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T getSettings(String indexName) throws ApiException {
    Object req = getSettingsValidateBeforeCall(indexName, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<IndexSettings>() {}.getType();
      ApiResponse<IndexSettings> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Retrieve settings of a given indexName.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call getSettingsAsync(
    String indexName,
    final ApiCallback<IndexSettings> _callback
  ) throws ApiException {
    Call call = (Call) getSettingsValidateBeforeCall(indexName, _callback);
    Type returnType = new TypeToken<IndexSettings>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for getSources
   *
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object getSourcesCall(final ApiCallback _callback)
    throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path = "/1/security/sources";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "GET",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object getSourcesValidateBeforeCall(final ApiCallback _callback)
    throws ApiException {
    return getSourcesCall(_callback);
  }

  /**
   * List all allowed sources.
   *
   * @return List&lt;Source&gt;
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T getSources() throws ApiException {
    Object req = getSourcesValidateBeforeCall(null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<List<Source>>() {}.getType();
      ApiResponse<List<Source>> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) List all allowed sources.
   *
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call getSourcesAsync(final ApiCallback<List<Source>> _callback)
    throws ApiException {
    Call call = (Call) getSourcesValidateBeforeCall(_callback);
    Type returnType = new TypeToken<List<Source>>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for getSynonym
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object getSynonymCall(
    String indexName,
    String objectID,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/synonyms/{objectID}".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        )
        .replaceAll(
          "\\{" + "objectID" + "\\}",
          this.escapeString(objectID.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "GET",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object getSynonymValidateBeforeCall(
    String indexName,
    String objectID,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling getSynonym(Async)"
      );
    }

    // verify the required parameter 'objectID' is set
    if (objectID == null) {
      throw new ApiException(
        "Missing the required parameter 'objectID' when calling getSynonym(Async)"
      );
    }

    return getSynonymCall(indexName, objectID, _callback);
  }

  /**
   * Fetch a synonym object identified by its objectID.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @return SynonymHit
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T getSynonym(String indexName, String objectID)
    throws ApiException {
    Object req = getSynonymValidateBeforeCall(indexName, objectID, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<SynonymHit>() {}.getType();
      ApiResponse<SynonymHit> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Fetch a synonym object identified by its objectID.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call getSynonymAsync(
    String indexName,
    String objectID,
    final ApiCallback<SynonymHit> _callback
  ) throws ApiException {
    Call call = (Call) getSynonymValidateBeforeCall(
      indexName,
      objectID,
      _callback
    );
    Type returnType = new TypeToken<SynonymHit>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for getTask
   *
   * @param indexName The index in which to perform the request. (required)
   * @param taskID Unique identifier of an task. Numeric value (up to 64bits) (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object getTaskCall(
    String indexName,
    Integer taskID,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/task/{taskID}".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        )
        .replaceAll(
          "\\{" + "taskID" + "\\}",
          this.escapeString(taskID.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "GET",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object getTaskValidateBeforeCall(
    String indexName,
    Integer taskID,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling getTask(Async)"
      );
    }

    // verify the required parameter 'taskID' is set
    if (taskID == null) {
      throw new ApiException(
        "Missing the required parameter 'taskID' when calling getTask(Async)"
      );
    }

    return getTaskCall(indexName, taskID, _callback);
  }

  /**
   * Check the current status of a given task.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param taskID Unique identifier of an task. Numeric value (up to 64bits) (required)
   * @return GetTaskResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T getTask(String indexName, Integer taskID) throws ApiException {
    Object req = getTaskValidateBeforeCall(indexName, taskID, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<GetTaskResponse>() {}.getType();
      ApiResponse<GetTaskResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Check the current status of a given task.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param taskID Unique identifier of an task. Numeric value (up to 64bits) (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call getTaskAsync(
    String indexName,
    Integer taskID,
    final ApiCallback<GetTaskResponse> _callback
  ) throws ApiException {
    Call call = (Call) getTaskValidateBeforeCall(indexName, taskID, _callback);
    Type returnType = new TypeToken<GetTaskResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for getTopUserIds
   *
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object getTopUserIdsCall(final ApiCallback _callback)
    throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path = "/1/clusters/mapping/top";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "GET",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object getTopUserIdsValidateBeforeCall(final ApiCallback _callback)
    throws ApiException {
    return getTopUserIdsCall(_callback);
  }

  /**
   * Get the top 10 userIDs with the highest number of records per cluster. The data returned will
   * usually be a few seconds behind real time, because userID usage may take up to a few seconds to
   * propagate to the different clusters. Upon success, the response is 200 OK and contains the
   * following array of userIDs and clusters.
   *
   * @return GetTopUserIdsResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T getTopUserIds() throws ApiException {
    Object req = getTopUserIdsValidateBeforeCall(null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<GetTopUserIdsResponse>() {}.getType();
      ApiResponse<GetTopUserIdsResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Get the top 10 userIDs with the highest number of records per cluster. The
   * data returned will usually be a few seconds behind real time, because userID usage may take up
   * to a few seconds to propagate to the different clusters. Upon success, the response is 200 OK
   * and contains the following array of userIDs and clusters.
   *
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call getTopUserIdsAsync(
    final ApiCallback<GetTopUserIdsResponse> _callback
  ) throws ApiException {
    Call call = (Call) getTopUserIdsValidateBeforeCall(_callback);
    Type returnType = new TypeToken<GetTopUserIdsResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for getUserId
   *
   * @param userID userID to assign. (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object getUserIdCall(String userID, final ApiCallback _callback)
    throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/clusters/mapping/{userID}".replaceAll(
          "\\{" + "userID" + "\\}",
          this.escapeString(userID.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "GET",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object getUserIdValidateBeforeCall(
    String userID,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'userID' is set
    if (userID == null) {
      throw new ApiException(
        "Missing the required parameter 'userID' when calling getUserId(Async)"
      );
    }

    return getUserIdCall(userID, _callback);
  }

  /**
   * Returns the userID data stored in the mapping. The data returned will usually be a few seconds
   * behind real time, because userID usage may take up to a few seconds to propagate to the
   * different clusters. Upon success, the response is 200 OK and contains the following userID
   * data.
   *
   * @param userID userID to assign. (required)
   * @return UserId
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T getUserId(String userID) throws ApiException {
    Object req = getUserIdValidateBeforeCall(userID, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<UserId>() {}.getType();
      ApiResponse<UserId> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Returns the userID data stored in the mapping. The data returned will usually
   * be a few seconds behind real time, because userID usage may take up to a few seconds to
   * propagate to the different clusters. Upon success, the response is 200 OK and contains the
   * following userID data.
   *
   * @param userID userID to assign. (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call getUserIdAsync(
    String userID,
    final ApiCallback<UserId> _callback
  ) throws ApiException {
    Call call = (Call) getUserIdValidateBeforeCall(userID, _callback);
    Type returnType = new TypeToken<UserId>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for hasPendingMappings
   *
   * @param getClusters Whether to get clusters or not. (optional)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object hasPendingMappingsCall(
    Boolean getClusters,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path = "/1/clusters/mapping/pending";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (getClusters != null) {
      queryParams.addAll(this.parameterToPair("getClusters", getClusters));
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "GET",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object hasPendingMappingsValidateBeforeCall(
    Boolean getClusters,
    final ApiCallback _callback
  ) throws ApiException {
    return hasPendingMappingsCall(getClusters, _callback);
  }

  /**
   * Get the status of your clusters' migrations or user creations. Creating a large batch of users
   * or migrating your multi-cluster may take quite some time. This method lets you retrieve the
   * status of the migration, so you can know when it's done. Upon success, the response is 200 OK.
   * A successful response indicates that the operation has been taken into account, and the userIDs
   * are directly usable.
   *
   * @param getClusters Whether to get clusters or not. (optional)
   * @return CreatedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T hasPendingMappings(Boolean getClusters) throws ApiException {
    Object req = hasPendingMappingsValidateBeforeCall(getClusters, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<CreatedAtResponse>() {}.getType();
      ApiResponse<CreatedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Get the status of your clusters&#39; migrations or user creations. Creating a
   * large batch of users or migrating your multi-cluster may take quite some time. This method lets
   * you retrieve the status of the migration, so you can know when it&#39;s done. Upon success, the
   * response is 200 OK. A successful response indicates that the operation has been taken into
   * account, and the userIDs are directly usable.
   *
   * @param getClusters Whether to get clusters or not. (optional)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call hasPendingMappingsAsync(
    Boolean getClusters,
    final ApiCallback<CreatedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) hasPendingMappingsValidateBeforeCall(
      getClusters,
      _callback
    );
    Type returnType = new TypeToken<CreatedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for listApiKeys
   *
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object listApiKeysCall(final ApiCallback _callback)
    throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path = "/1/keys";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "GET",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object listApiKeysValidateBeforeCall(final ApiCallback _callback)
    throws ApiException {
    return listApiKeysCall(_callback);
  }

  /**
   * List API keys, along with their associated rights.
   *
   * @return ListApiKeysResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T listApiKeys() throws ApiException {
    Object req = listApiKeysValidateBeforeCall(null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<ListApiKeysResponse>() {}.getType();
      ApiResponse<ListApiKeysResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) List API keys, along with their associated rights.
   *
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call listApiKeysAsync(
    final ApiCallback<ListApiKeysResponse> _callback
  ) throws ApiException {
    Call call = (Call) listApiKeysValidateBeforeCall(_callback);
    Type returnType = new TypeToken<ListApiKeysResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for listClusters
   *
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object listClustersCall(final ApiCallback _callback)
    throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path = "/1/clusters";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "GET",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object listClustersValidateBeforeCall(final ApiCallback _callback)
    throws ApiException {
    return listClustersCall(_callback);
  }

  /**
   * List the clusters available in a multi-clusters setup for a single appID. Upon success, the
   * response is 200 OK and contains the following clusters.
   *
   * @return ListClustersResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T listClusters() throws ApiException {
    Object req = listClustersValidateBeforeCall(null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<ListClustersResponse>() {}.getType();
      ApiResponse<ListClustersResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) List the clusters available in a multi-clusters setup for a single appID. Upon
   * success, the response is 200 OK and contains the following clusters.
   *
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call listClustersAsync(
    final ApiCallback<ListClustersResponse> _callback
  ) throws ApiException {
    Call call = (Call) listClustersValidateBeforeCall(_callback);
    Type returnType = new TypeToken<ListClustersResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for listIndices
   *
   * @param page Requested page (zero-based). When specified, will retrieve a specific page; the
   *     page size is implicitly set to 100. When null, will retrieve all indices (no pagination).
   *     (optional)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object listIndicesCall(Integer page, final ApiCallback _callback)
    throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path = "/1/indexes";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (page != null) {
      queryParams.addAll(this.parameterToPair("page", page));
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "GET",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object listIndicesValidateBeforeCall(
    Integer page,
    final ApiCallback _callback
  ) throws ApiException {
    return listIndicesCall(page, _callback);
  }

  /**
   * List existing indexes from an application.
   *
   * @param page Requested page (zero-based). When specified, will retrieve a specific page; the
   *     page size is implicitly set to 100. When null, will retrieve all indices (no pagination).
   *     (optional)
   * @return ListIndicesResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T listIndices(Integer page) throws ApiException {
    Object req = listIndicesValidateBeforeCall(page, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<ListIndicesResponse>() {}.getType();
      ApiResponse<ListIndicesResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) List existing indexes from an application.
   *
   * @param page Requested page (zero-based). When specified, will retrieve a specific page; the
   *     page size is implicitly set to 100. When null, will retrieve all indices (no pagination).
   *     (optional)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call listIndicesAsync(
    Integer page,
    final ApiCallback<ListIndicesResponse> _callback
  ) throws ApiException {
    Call call = (Call) listIndicesValidateBeforeCall(page, _callback);
    Type returnType = new TypeToken<ListIndicesResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for listUserIds
   *
   * @param page Requested page (zero-based). When specified, will retrieve a specific page; the
   *     page size is implicitly set to 100. When null, will retrieve all indices (no pagination).
   *     (optional)
   * @param hitsPerPage Maximum number of objects to retrieve. (optional, default to 100)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object listUserIdsCall(
    Integer page,
    Integer hitsPerPage,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path = "/1/clusters/mapping";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (page != null) {
      queryParams.addAll(this.parameterToPair("page", page));
    }

    if (hitsPerPage != null) {
      queryParams.addAll(this.parameterToPair("hitsPerPage", hitsPerPage));
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "GET",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object listUserIdsValidateBeforeCall(
    Integer page,
    Integer hitsPerPage,
    final ApiCallback _callback
  ) throws ApiException {
    return listUserIdsCall(page, hitsPerPage, _callback);
  }

  /**
   * List the userIDs assigned to a multi-clusters appID. The data returned will usually be a few
   * seconds behind real time, because userID usage may take up to a few seconds to propagate to the
   * different clusters. Upon success, the response is 200 OK and contains the following userIDs
   * data.
   *
   * @param page Requested page (zero-based). When specified, will retrieve a specific page; the
   *     page size is implicitly set to 100. When null, will retrieve all indices (no pagination).
   *     (optional)
   * @param hitsPerPage Maximum number of objects to retrieve. (optional, default to 100)
   * @return ListUserIdsResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T listUserIds(Integer page, Integer hitsPerPage)
    throws ApiException {
    Object req = listUserIdsValidateBeforeCall(page, hitsPerPage, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<ListUserIdsResponse>() {}.getType();
      ApiResponse<ListUserIdsResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) List the userIDs assigned to a multi-clusters appID. The data returned will
   * usually be a few seconds behind real time, because userID usage may take up to a few seconds to
   * propagate to the different clusters. Upon success, the response is 200 OK and contains the
   * following userIDs data.
   *
   * @param page Requested page (zero-based). When specified, will retrieve a specific page; the
   *     page size is implicitly set to 100. When null, will retrieve all indices (no pagination).
   *     (optional)
   * @param hitsPerPage Maximum number of objects to retrieve. (optional, default to 100)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call listUserIdsAsync(
    Integer page,
    Integer hitsPerPage,
    final ApiCallback<ListUserIdsResponse> _callback
  ) throws ApiException {
    Call call = (Call) listUserIdsValidateBeforeCall(
      page,
      hitsPerPage,
      _callback
    );
    Type returnType = new TypeToken<ListUserIdsResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for multipleBatch
   *
   * @param batchObject (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object multipleBatchCall(
    BatchObject batchObject,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = batchObject;

    // create path and map variables
    String path = "/1/indexes/*/batch";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object multipleBatchValidateBeforeCall(
    BatchObject batchObject,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'batchObject' is set
    if (batchObject == null) {
      throw new ApiException(
        "Missing the required parameter 'batchObject' when calling multipleBatch(Async)"
      );
    }

    return multipleBatchCall(batchObject, _callback);
  }

  /**
   * Perform multiple write operations, potentially targeting multiple indices, in a single API
   * call.
   *
   * @param batchObject (required)
   * @return MultipleBatchResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T multipleBatch(BatchObject batchObject) throws ApiException {
    Object req = multipleBatchValidateBeforeCall(batchObject, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<MultipleBatchResponse>() {}.getType();
      ApiResponse<MultipleBatchResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Perform multiple write operations, potentially targeting multiple indices, in
   * a single API call.
   *
   * @param batchObject (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call multipleBatchAsync(
    BatchObject batchObject,
    final ApiCallback<MultipleBatchResponse> _callback
  ) throws ApiException {
    Call call = (Call) multipleBatchValidateBeforeCall(batchObject, _callback);
    Type returnType = new TypeToken<MultipleBatchResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for multipleQueries
   *
   * @param multipleQueriesObject (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object multipleQueriesCall(
    MultipleQueriesObject multipleQueriesObject,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = multipleQueriesObject;

    // create path and map variables
    String path = "/1/indexes/*/queries";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object multipleQueriesValidateBeforeCall(
    MultipleQueriesObject multipleQueriesObject,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'multipleQueriesObject' is set
    if (multipleQueriesObject == null) {
      throw new ApiException(
        "Missing the required parameter 'multipleQueriesObject' when calling" +
        " multipleQueries(Async)"
      );
    }

    return multipleQueriesCall(multipleQueriesObject, _callback);
  }

  /**
   * Get search results for the given requests.
   *
   * @param multipleQueriesObject (required)
   * @return MultipleQueriesResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T multipleQueries(MultipleQueriesObject multipleQueriesObject)
    throws ApiException {
    Object req = multipleQueriesValidateBeforeCall(multipleQueriesObject, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<MultipleQueriesResponse>() {}.getType();
      ApiResponse<MultipleQueriesResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Get search results for the given requests.
   *
   * @param multipleQueriesObject (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call multipleQueriesAsync(
    MultipleQueriesObject multipleQueriesObject,
    final ApiCallback<MultipleQueriesResponse> _callback
  ) throws ApiException {
    Call call = (Call) multipleQueriesValidateBeforeCall(
      multipleQueriesObject,
      _callback
    );
    Type returnType = new TypeToken<MultipleQueriesResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for operationIndex
   *
   * @param indexName The index in which to perform the request. (required)
   * @param operationIndexObject (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object operationIndexCall(
    String indexName,
    OperationIndexObject operationIndexObject,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = operationIndexObject;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/operation".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object operationIndexValidateBeforeCall(
    String indexName,
    OperationIndexObject operationIndexObject,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling operationIndex(Async)"
      );
    }

    // verify the required parameter 'operationIndexObject' is set
    if (operationIndexObject == null) {
      throw new ApiException(
        "Missing the required parameter 'operationIndexObject' when calling" +
        " operationIndex(Async)"
      );
    }

    return operationIndexCall(indexName, operationIndexObject, _callback);
  }

  /**
   * Peforms a copy or a move operation on a index.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param operationIndexObject (required)
   * @return UpdatedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T operationIndex(
    String indexName,
    OperationIndexObject operationIndexObject
  ) throws ApiException {
    Object req = operationIndexValidateBeforeCall(
      indexName,
      operationIndexObject,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
      ApiResponse<UpdatedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Peforms a copy or a move operation on a index.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param operationIndexObject (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call operationIndexAsync(
    String indexName,
    OperationIndexObject operationIndexObject,
    final ApiCallback<UpdatedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) operationIndexValidateBeforeCall(
      indexName,
      operationIndexObject,
      _callback
    );
    Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for partialUpdateObject
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param oneOfstringbuiltInOperation List of attributes to update. (required)
   * @param createIfNotExists Creates the record if it does not exist yet. (optional, default to
   *     true)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object partialUpdateObjectCall(
    String indexName,
    String objectID,
    List<Map<String, OneOfstringbuiltInOperation>> oneOfstringbuiltInOperation,
    Boolean createIfNotExists,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = oneOfstringbuiltInOperation;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/{objectID}/partial".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        )
        .replaceAll(
          "\\{" + "objectID" + "\\}",
          this.escapeString(objectID.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (createIfNotExists != null) {
      queryParams.addAll(
        this.parameterToPair("createIfNotExists", createIfNotExists)
      );
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object partialUpdateObjectValidateBeforeCall(
    String indexName,
    String objectID,
    List<Map<String, OneOfstringbuiltInOperation>> oneOfstringbuiltInOperation,
    Boolean createIfNotExists,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling partialUpdateObject(Async)"
      );
    }

    // verify the required parameter 'objectID' is set
    if (objectID == null) {
      throw new ApiException(
        "Missing the required parameter 'objectID' when calling partialUpdateObject(Async)"
      );
    }

    // verify the required parameter 'oneOfstringbuiltInOperation' is set
    if (oneOfstringbuiltInOperation == null) {
      throw new ApiException(
        "Missing the required parameter 'oneOfstringbuiltInOperation' when calling" +
        " partialUpdateObject(Async)"
      );
    }

    return partialUpdateObjectCall(
      indexName,
      objectID,
      oneOfstringbuiltInOperation,
      createIfNotExists,
      _callback
    );
  }

  /**
   * Update one or more attributes of an existing object. This method lets you update only a part of
   * an existing object, either by adding new attributes or updating existing ones. You can
   * partially update several objects in a single method call. If the index targeted by this
   * operation doesn't exist yet, it's automatically created.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param oneOfstringbuiltInOperation List of attributes to update. (required)
   * @param createIfNotExists Creates the record if it does not exist yet. (optional, default to
   *     true)
   * @return UpdatedAtWithObjectIdResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T partialUpdateObject(
    String indexName,
    String objectID,
    List<Map<String, OneOfstringbuiltInOperation>> oneOfstringbuiltInOperation,
    Boolean createIfNotExists
  ) throws ApiException {
    Object req = partialUpdateObjectValidateBeforeCall(
      indexName,
      objectID,
      oneOfstringbuiltInOperation,
      createIfNotExists,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<UpdatedAtWithObjectIdResponse>() {}
        .getType();
      ApiResponse<UpdatedAtWithObjectIdResponse> res =
        this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Update one or more attributes of an existing object. This method lets you
   * update only a part of an existing object, either by adding new attributes or updating existing
   * ones. You can partially update several objects in a single method call. If the index targeted
   * by this operation doesn&#39;t exist yet, it&#39;s automatically created.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param oneOfstringbuiltInOperation List of attributes to update. (required)
   * @param createIfNotExists Creates the record if it does not exist yet. (optional, default to
   *     true)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call partialUpdateObjectAsync(
    String indexName,
    String objectID,
    List<Map<String, OneOfstringbuiltInOperation>> oneOfstringbuiltInOperation,
    Boolean createIfNotExists,
    final ApiCallback<UpdatedAtWithObjectIdResponse> _callback
  ) throws ApiException {
    Call call = (Call) partialUpdateObjectValidateBeforeCall(
      indexName,
      objectID,
      oneOfstringbuiltInOperation,
      createIfNotExists,
      _callback
    );
    Type returnType = new TypeToken<UpdatedAtWithObjectIdResponse>() {}
      .getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for removeUserId
   *
   * @param userID userID to assign. (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object removeUserIdCall(String userID, final ApiCallback _callback)
    throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/clusters/mapping/{userID}".replaceAll(
          "\\{" + "userID" + "\\}",
          this.escapeString(userID.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "DELETE",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object removeUserIdValidateBeforeCall(
    String userID,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'userID' is set
    if (userID == null) {
      throw new ApiException(
        "Missing the required parameter 'userID' when calling removeUserId(Async)"
      );
    }

    return removeUserIdCall(userID, _callback);
  }

  /**
   * Remove a userID and its associated data from the multi-clusters. Upon success, the response is
   * 200 OK and a task is created to remove the userID data and mapping.
   *
   * @param userID userID to assign. (required)
   * @return RemoveUserIdResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T removeUserId(String userID) throws ApiException {
    Object req = removeUserIdValidateBeforeCall(userID, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<RemoveUserIdResponse>() {}.getType();
      ApiResponse<RemoveUserIdResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Remove a userID and its associated data from the multi-clusters. Upon success,
   * the response is 200 OK and a task is created to remove the userID data and mapping.
   *
   * @param userID userID to assign. (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call removeUserIdAsync(
    String userID,
    final ApiCallback<RemoveUserIdResponse> _callback
  ) throws ApiException {
    Call call = (Call) removeUserIdValidateBeforeCall(userID, _callback);
    Type returnType = new TypeToken<RemoveUserIdResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for replaceSources
   *
   * @param source The sources to allow. (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object replaceSourcesCall(
    List<Source> source,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = source;

    // create path and map variables
    String path = "/1/security/sources";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "PUT",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object replaceSourcesValidateBeforeCall(
    List<Source> source,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'source' is set
    if (source == null) {
      throw new ApiException(
        "Missing the required parameter 'source' when calling replaceSources(Async)"
      );
    }

    return replaceSourcesCall(source, _callback);
  }

  /**
   * Replace all allowed sources.
   *
   * @param source The sources to allow. (required)
   * @return ReplaceSourceResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T replaceSources(List<Source> source) throws ApiException {
    Object req = replaceSourcesValidateBeforeCall(source, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<ReplaceSourceResponse>() {}.getType();
      ApiResponse<ReplaceSourceResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Replace all allowed sources.
   *
   * @param source The sources to allow. (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call replaceSourcesAsync(
    List<Source> source,
    final ApiCallback<ReplaceSourceResponse> _callback
  ) throws ApiException {
    Call call = (Call) replaceSourcesValidateBeforeCall(source, _callback);
    Type returnType = new TypeToken<ReplaceSourceResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for restoreApiKey
   *
   * @param key API Key string. (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object restoreApiKeyCall(String key, final ApiCallback _callback)
    throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/keys/{key}/restore".replaceAll(
          "\\{" + "key" + "\\}",
          this.escapeString(key.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object restoreApiKeyValidateBeforeCall(
    String key,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(
        "Missing the required parameter 'key' when calling restoreApiKey(Async)"
      );
    }

    return restoreApiKeyCall(key, _callback);
  }

  /**
   * Restore a deleted API key, along with its associated rights.
   *
   * @param key API Key string. (required)
   * @return AddApiKeyResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T restoreApiKey(String key) throws ApiException {
    Object req = restoreApiKeyValidateBeforeCall(key, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<AddApiKeyResponse>() {}.getType();
      ApiResponse<AddApiKeyResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Restore a deleted API key, along with its associated rights.
   *
   * @param key API Key string. (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call restoreApiKeyAsync(
    String key,
    final ApiCallback<AddApiKeyResponse> _callback
  ) throws ApiException {
    Call call = (Call) restoreApiKeyValidateBeforeCall(key, _callback);
    Type returnType = new TypeToken<AddApiKeyResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for saveObject
   *
   * @param indexName The index in which to perform the request. (required)
   * @param body The Algolia object. (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object saveObjectCall(
    String indexName,
    Object body,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = body;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object saveObjectValidateBeforeCall(
    String indexName,
    Object body,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling saveObject(Async)"
      );
    }

    // verify the required parameter 'body' is set
    if (body == null) {
      throw new ApiException(
        "Missing the required parameter 'body' when calling saveObject(Async)"
      );
    }

    return saveObjectCall(indexName, body, _callback);
  }

  /**
   * Add an object to the index, automatically assigning it an object ID.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param body The Algolia object. (required)
   * @return SaveObjectResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T saveObject(String indexName, Object body) throws ApiException {
    Object req = saveObjectValidateBeforeCall(indexName, body, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<SaveObjectResponse>() {}.getType();
      ApiResponse<SaveObjectResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Add an object to the index, automatically assigning it an object ID.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param body The Algolia object. (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call saveObjectAsync(
    String indexName,
    Object body,
    final ApiCallback<SaveObjectResponse> _callback
  ) throws ApiException {
    Call call = (Call) saveObjectValidateBeforeCall(indexName, body, _callback);
    Type returnType = new TypeToken<SaveObjectResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for saveRule
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param rule (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object saveRuleCall(
    String indexName,
    String objectID,
    Rule rule,
    Boolean forwardToReplicas,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = rule;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/rules/{objectID}".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        )
        .replaceAll(
          "\\{" + "objectID" + "\\}",
          this.escapeString(objectID.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (forwardToReplicas != null) {
      queryParams.addAll(
        this.parameterToPair("forwardToReplicas", forwardToReplicas)
      );
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "PUT",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object saveRuleValidateBeforeCall(
    String indexName,
    String objectID,
    Rule rule,
    Boolean forwardToReplicas,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling saveRule(Async)"
      );
    }

    // verify the required parameter 'objectID' is set
    if (objectID == null) {
      throw new ApiException(
        "Missing the required parameter 'objectID' when calling saveRule(Async)"
      );
    }

    // verify the required parameter 'rule' is set
    if (rule == null) {
      throw new ApiException(
        "Missing the required parameter 'rule' when calling saveRule(Async)"
      );
    }

    return saveRuleCall(
      indexName,
      objectID,
      rule,
      forwardToReplicas,
      _callback
    );
  }

  /**
   * Create or update the Rule with the specified objectID.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param rule (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @return UpdatedRuleResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T saveRule(
    String indexName,
    String objectID,
    Rule rule,
    Boolean forwardToReplicas
  ) throws ApiException {
    Object req = saveRuleValidateBeforeCall(
      indexName,
      objectID,
      rule,
      forwardToReplicas,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<UpdatedRuleResponse>() {}.getType();
      ApiResponse<UpdatedRuleResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Create or update the Rule with the specified objectID.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param rule (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call saveRuleAsync(
    String indexName,
    String objectID,
    Rule rule,
    Boolean forwardToReplicas,
    final ApiCallback<UpdatedRuleResponse> _callback
  ) throws ApiException {
    Call call = (Call) saveRuleValidateBeforeCall(
      indexName,
      objectID,
      rule,
      forwardToReplicas,
      _callback
    );
    Type returnType = new TypeToken<UpdatedRuleResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for saveSynonym
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param synonymHit (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object saveSynonymCall(
    String indexName,
    String objectID,
    SynonymHit synonymHit,
    Boolean forwardToReplicas,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = synonymHit;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/synonyms/{objectID}".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        )
        .replaceAll(
          "\\{" + "objectID" + "\\}",
          this.escapeString(objectID.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (forwardToReplicas != null) {
      queryParams.addAll(
        this.parameterToPair("forwardToReplicas", forwardToReplicas)
      );
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "PUT",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object saveSynonymValidateBeforeCall(
    String indexName,
    String objectID,
    SynonymHit synonymHit,
    Boolean forwardToReplicas,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling saveSynonym(Async)"
      );
    }

    // verify the required parameter 'objectID' is set
    if (objectID == null) {
      throw new ApiException(
        "Missing the required parameter 'objectID' when calling saveSynonym(Async)"
      );
    }

    // verify the required parameter 'synonymHit' is set
    if (synonymHit == null) {
      throw new ApiException(
        "Missing the required parameter 'synonymHit' when calling saveSynonym(Async)"
      );
    }

    return saveSynonymCall(
      indexName,
      objectID,
      synonymHit,
      forwardToReplicas,
      _callback
    );
  }

  /**
   * Create a new synonym object or update the existing synonym object with the given object ID.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param synonymHit (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @return SaveSynonymResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T saveSynonym(
    String indexName,
    String objectID,
    SynonymHit synonymHit,
    Boolean forwardToReplicas
  ) throws ApiException {
    Object req = saveSynonymValidateBeforeCall(
      indexName,
      objectID,
      synonymHit,
      forwardToReplicas,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<SaveSynonymResponse>() {}.getType();
      ApiResponse<SaveSynonymResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Create a new synonym object or update the existing synonym object with the
   * given object ID.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param objectID Unique identifier of an object. (required)
   * @param synonymHit (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call saveSynonymAsync(
    String indexName,
    String objectID,
    SynonymHit synonymHit,
    Boolean forwardToReplicas,
    final ApiCallback<SaveSynonymResponse> _callback
  ) throws ApiException {
    Call call = (Call) saveSynonymValidateBeforeCall(
      indexName,
      objectID,
      synonymHit,
      forwardToReplicas,
      _callback
    );
    Type returnType = new TypeToken<SaveSynonymResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for saveSynonyms
   *
   * @param indexName The index in which to perform the request. (required)
   * @param synonymHit (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param replaceExistingSynonyms Replace all synonyms of the index with the ones sent with this
   *     request. (optional)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object saveSynonymsCall(
    String indexName,
    List<SynonymHit> synonymHit,
    Boolean forwardToReplicas,
    Boolean replaceExistingSynonyms,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = synonymHit;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/synonyms/batch".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (forwardToReplicas != null) {
      queryParams.addAll(
        this.parameterToPair("forwardToReplicas", forwardToReplicas)
      );
    }

    if (replaceExistingSynonyms != null) {
      queryParams.addAll(
        this.parameterToPair("replaceExistingSynonyms", replaceExistingSynonyms)
      );
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object saveSynonymsValidateBeforeCall(
    String indexName,
    List<SynonymHit> synonymHit,
    Boolean forwardToReplicas,
    Boolean replaceExistingSynonyms,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling saveSynonyms(Async)"
      );
    }

    // verify the required parameter 'synonymHit' is set
    if (synonymHit == null) {
      throw new ApiException(
        "Missing the required parameter 'synonymHit' when calling saveSynonyms(Async)"
      );
    }

    return saveSynonymsCall(
      indexName,
      synonymHit,
      forwardToReplicas,
      replaceExistingSynonyms,
      _callback
    );
  }

  /**
   * Create/update multiple synonym objects at once, potentially replacing the entire list of
   * synonyms if replaceExistingSynonyms is true.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param synonymHit (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param replaceExistingSynonyms Replace all synonyms of the index with the ones sent with this
   *     request. (optional)
   * @return UpdatedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T saveSynonyms(
    String indexName,
    List<SynonymHit> synonymHit,
    Boolean forwardToReplicas,
    Boolean replaceExistingSynonyms
  ) throws ApiException {
    Object req = saveSynonymsValidateBeforeCall(
      indexName,
      synonymHit,
      forwardToReplicas,
      replaceExistingSynonyms,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
      ApiResponse<UpdatedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Create/update multiple synonym objects at once, potentially replacing the
   * entire list of synonyms if replaceExistingSynonyms is true.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param synonymHit (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param replaceExistingSynonyms Replace all synonyms of the index with the ones sent with this
   *     request. (optional)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call saveSynonymsAsync(
    String indexName,
    List<SynonymHit> synonymHit,
    Boolean forwardToReplicas,
    Boolean replaceExistingSynonyms,
    final ApiCallback<UpdatedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) saveSynonymsValidateBeforeCall(
      indexName,
      synonymHit,
      forwardToReplicas,
      replaceExistingSynonyms,
      _callback
    );
    Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for search
   *
   * @param indexName The index in which to perform the request. (required)
   * @param searchParams (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object searchCall(
    String indexName,
    SearchParams searchParams,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = searchParams;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/query".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object searchValidateBeforeCall(
    String indexName,
    SearchParams searchParams,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling search(Async)"
      );
    }

    // verify the required parameter 'searchParams' is set
    if (searchParams == null) {
      throw new ApiException(
        "Missing the required parameter 'searchParams' when calling search(Async)"
      );
    }

    return searchCall(indexName, searchParams, _callback);
  }

  /**
   * Get search results.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param searchParams (required)
   * @return SearchResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T search(String indexName, SearchParams searchParams)
    throws ApiException {
    Object req = searchValidateBeforeCall(indexName, searchParams, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<SearchResponse>() {}.getType();
      ApiResponse<SearchResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Get search results.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param searchParams (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call searchAsync(
    String indexName,
    SearchParams searchParams,
    final ApiCallback<SearchResponse> _callback
  ) throws ApiException {
    Call call = (Call) searchValidateBeforeCall(
      indexName,
      searchParams,
      _callback
    );
    Type returnType = new TypeToken<SearchResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for searchDictionaryEntries
   *
   * @param dictionaryName The dictionary to search in. (required)
   * @param searchDictionaryEntries (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object searchDictionaryEntriesCall(
    String dictionaryName,
    SearchDictionaryEntries searchDictionaryEntries,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = searchDictionaryEntries;

    // create path and map variables
    String path =
      "/1/dictionaries/{dictionaryName}/search".replaceAll(
          "\\{" + "dictionaryName" + "\\}",
          this.escapeString(dictionaryName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object searchDictionaryEntriesValidateBeforeCall(
    String dictionaryName,
    SearchDictionaryEntries searchDictionaryEntries,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'dictionaryName' is set
    if (dictionaryName == null) {
      throw new ApiException(
        "Missing the required parameter 'dictionaryName' when calling" +
        " searchDictionaryEntries(Async)"
      );
    }

    // verify the required parameter 'searchDictionaryEntries' is set
    if (searchDictionaryEntries == null) {
      throw new ApiException(
        "Missing the required parameter 'searchDictionaryEntries' when calling" +
        " searchDictionaryEntries(Async)"
      );
    }

    return searchDictionaryEntriesCall(
      dictionaryName,
      searchDictionaryEntries,
      _callback
    );
  }

  /**
   * Search the dictionary entries.
   *
   * @param dictionaryName The dictionary to search in. (required)
   * @param searchDictionaryEntries (required)
   * @return UpdatedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T searchDictionaryEntries(
    String dictionaryName,
    SearchDictionaryEntries searchDictionaryEntries
  ) throws ApiException {
    Object req = searchDictionaryEntriesValidateBeforeCall(
      dictionaryName,
      searchDictionaryEntries,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
      ApiResponse<UpdatedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Search the dictionary entries.
   *
   * @param dictionaryName The dictionary to search in. (required)
   * @param searchDictionaryEntries (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call searchDictionaryEntriesAsync(
    String dictionaryName,
    SearchDictionaryEntries searchDictionaryEntries,
    final ApiCallback<UpdatedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) searchDictionaryEntriesValidateBeforeCall(
      dictionaryName,
      searchDictionaryEntries,
      _callback
    );
    Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for searchForFacetValues
   *
   * @param indexName The index in which to perform the request. (required)
   * @param facetName The facet name. (required)
   * @param searchForFacetValuesRequest (optional)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object searchForFacetValuesCall(
    String indexName,
    String facetName,
    SearchForFacetValuesRequest searchForFacetValuesRequest,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = searchForFacetValuesRequest;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/facets/{facetName}/query".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        )
        .replaceAll(
          "\\{" + "facetName" + "\\}",
          this.escapeString(facetName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object searchForFacetValuesValidateBeforeCall(
    String indexName,
    String facetName,
    SearchForFacetValuesRequest searchForFacetValuesRequest,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling searchForFacetValues(Async)"
      );
    }

    // verify the required parameter 'facetName' is set
    if (facetName == null) {
      throw new ApiException(
        "Missing the required parameter 'facetName' when calling searchForFacetValues(Async)"
      );
    }

    return searchForFacetValuesCall(
      indexName,
      facetName,
      searchForFacetValuesRequest,
      _callback
    );
  }

  /**
   * Search for values of a given facet, optionally restricting the returned values to those
   * contained in objects matching other search criteria.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param facetName The facet name. (required)
   * @param searchForFacetValuesRequest (optional)
   * @return SearchForFacetValuesResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T searchForFacetValues(
    String indexName,
    String facetName,
    SearchForFacetValuesRequest searchForFacetValuesRequest
  ) throws ApiException {
    Object req = searchForFacetValuesValidateBeforeCall(
      indexName,
      facetName,
      searchForFacetValuesRequest,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<SearchForFacetValuesResponse>() {}
        .getType();
      ApiResponse<SearchForFacetValuesResponse> res =
        this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Search for values of a given facet, optionally restricting the returned values
   * to those contained in objects matching other search criteria.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param facetName The facet name. (required)
   * @param searchForFacetValuesRequest (optional)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call searchForFacetValuesAsync(
    String indexName,
    String facetName,
    SearchForFacetValuesRequest searchForFacetValuesRequest,
    final ApiCallback<SearchForFacetValuesResponse> _callback
  ) throws ApiException {
    Call call = (Call) searchForFacetValuesValidateBeforeCall(
      indexName,
      facetName,
      searchForFacetValuesRequest,
      _callback
    );
    Type returnType = new TypeToken<SearchForFacetValuesResponse>() {}
      .getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for searchRules
   *
   * @param indexName The index in which to perform the request. (required)
   * @param searchRulesParams (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object searchRulesCall(
    String indexName,
    SearchRulesParams searchRulesParams,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = searchRulesParams;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/rules/search".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object searchRulesValidateBeforeCall(
    String indexName,
    SearchRulesParams searchRulesParams,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling searchRules(Async)"
      );
    }

    // verify the required parameter 'searchRulesParams' is set
    if (searchRulesParams == null) {
      throw new ApiException(
        "Missing the required parameter 'searchRulesParams' when calling searchRules(Async)"
      );
    }

    return searchRulesCall(indexName, searchRulesParams, _callback);
  }

  /**
   * Search for rules matching various criteria.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param searchRulesParams (required)
   * @return SearchRulesResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T searchRules(
    String indexName,
    SearchRulesParams searchRulesParams
  ) throws ApiException {
    Object req = searchRulesValidateBeforeCall(
      indexName,
      searchRulesParams,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<SearchRulesResponse>() {}.getType();
      ApiResponse<SearchRulesResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Search for rules matching various criteria.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param searchRulesParams (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call searchRulesAsync(
    String indexName,
    SearchRulesParams searchRulesParams,
    final ApiCallback<SearchRulesResponse> _callback
  ) throws ApiException {
    Call call = (Call) searchRulesValidateBeforeCall(
      indexName,
      searchRulesParams,
      _callback
    );
    Type returnType = new TypeToken<SearchRulesResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for searchSynonyms
   *
   * @param indexName The index in which to perform the request. (required)
   * @param query Search for specific synonyms matching this string. (optional, default to )
   * @param type Only search for specific types of synonyms. (optional)
   * @param page Requested page (zero-based). When specified, will retrieve a specific page; the
   *     page size is implicitly set to 100. When null, will retrieve all indices (no pagination).
   *     (optional, default to 0)
   * @param hitsPerPage Maximum number of objects to retrieve. (optional, default to 100)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object searchSynonymsCall(
    String indexName,
    String query,
    String type,
    Integer page,
    Integer hitsPerPage,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = null;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/synonyms/search".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (query != null) {
      queryParams.addAll(this.parameterToPair("query", query));
    }

    if (type != null) {
      queryParams.addAll(this.parameterToPair("type", type));
    }

    if (page != null) {
      queryParams.addAll(this.parameterToPair("page", page));
    }

    if (hitsPerPage != null) {
      queryParams.addAll(this.parameterToPair("hitsPerPage", hitsPerPage));
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object searchSynonymsValidateBeforeCall(
    String indexName,
    String query,
    String type,
    Integer page,
    Integer hitsPerPage,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling searchSynonyms(Async)"
      );
    }

    return searchSynonymsCall(
      indexName,
      query,
      type,
      page,
      hitsPerPage,
      _callback
    );
  }

  /**
   * Search or browse all synonyms, optionally filtering them by type.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param query Search for specific synonyms matching this string. (optional, default to )
   * @param type Only search for specific types of synonyms. (optional)
   * @param page Requested page (zero-based). When specified, will retrieve a specific page; the
   *     page size is implicitly set to 100. When null, will retrieve all indices (no pagination).
   *     (optional, default to 0)
   * @param hitsPerPage Maximum number of objects to retrieve. (optional, default to 100)
   * @return SearchSynonymsResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T searchSynonyms(
    String indexName,
    String query,
    String type,
    Integer page,
    Integer hitsPerPage
  ) throws ApiException {
    Object req = searchSynonymsValidateBeforeCall(
      indexName,
      query,
      type,
      page,
      hitsPerPage,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<SearchSynonymsResponse>() {}.getType();
      ApiResponse<SearchSynonymsResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Search or browse all synonyms, optionally filtering them by type.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param query Search for specific synonyms matching this string. (optional, default to )
   * @param type Only search for specific types of synonyms. (optional)
   * @param page Requested page (zero-based). When specified, will retrieve a specific page; the
   *     page size is implicitly set to 100. When null, will retrieve all indices (no pagination).
   *     (optional, default to 0)
   * @param hitsPerPage Maximum number of objects to retrieve. (optional, default to 100)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call searchSynonymsAsync(
    String indexName,
    String query,
    String type,
    Integer page,
    Integer hitsPerPage,
    final ApiCallback<SearchSynonymsResponse> _callback
  ) throws ApiException {
    Call call = (Call) searchSynonymsValidateBeforeCall(
      indexName,
      query,
      type,
      page,
      hitsPerPage,
      _callback
    );
    Type returnType = new TypeToken<SearchSynonymsResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for searchUserIds
   *
   * @param searchUserIdsObject (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object searchUserIdsCall(
    SearchUserIdsObject searchUserIdsObject,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = searchUserIdsObject;

    // create path and map variables
    String path = "/1/clusters/mapping/search";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "POST",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object searchUserIdsValidateBeforeCall(
    SearchUserIdsObject searchUserIdsObject,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'searchUserIdsObject' is set
    if (searchUserIdsObject == null) {
      throw new ApiException(
        "Missing the required parameter 'searchUserIdsObject' when calling searchUserIds(Async)"
      );
    }

    return searchUserIdsCall(searchUserIdsObject, _callback);
  }

  /**
   * Search for userIDs. The data returned will usually be a few seconds behind real time, because
   * userID usage may take up to a few seconds propagate to the different clusters. To keep updates
   * moving quickly, the index of userIDs isn't built synchronously with the mapping. Instead, the
   * index is built once every 12h, at the same time as the update of userID usage. For example,
   * when you perform a modification like adding or moving a userID, the search will report an
   * outdated value until the next rebuild of the mapping, which takes place every 12h. Upon
   * success, the response is 200 OK and contains the following userIDs data.
   *
   * @param searchUserIdsObject (required)
   * @return SearchUserIdsResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T searchUserIds(SearchUserIdsObject searchUserIdsObject)
    throws ApiException {
    Object req = searchUserIdsValidateBeforeCall(searchUserIdsObject, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<SearchUserIdsResponse>() {}.getType();
      ApiResponse<SearchUserIdsResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Search for userIDs. The data returned will usually be a few seconds behind
   * real time, because userID usage may take up to a few seconds propagate to the different
   * clusters. To keep updates moving quickly, the index of userIDs isn&#39;t built synchronously
   * with the mapping. Instead, the index is built once every 12h, at the same time as the update of
   * userID usage. For example, when you perform a modification like adding or moving a userID, the
   * search will report an outdated value until the next rebuild of the mapping, which takes place
   * every 12h. Upon success, the response is 200 OK and contains the following userIDs data.
   *
   * @param searchUserIdsObject (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call searchUserIdsAsync(
    SearchUserIdsObject searchUserIdsObject,
    final ApiCallback<SearchUserIdsResponse> _callback
  ) throws ApiException {
    Call call = (Call) searchUserIdsValidateBeforeCall(
      searchUserIdsObject,
      _callback
    );
    Type returnType = new TypeToken<SearchUserIdsResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for setDictionarySettings
   *
   * @param dictionarySettingsRequest (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object setDictionarySettingsCall(
    DictionarySettingsRequest dictionarySettingsRequest,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = dictionarySettingsRequest;

    // create path and map variables
    String path = "/1/dictionaries/*/settings";

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "PUT",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object setDictionarySettingsValidateBeforeCall(
    DictionarySettingsRequest dictionarySettingsRequest,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'dictionarySettingsRequest' is set
    if (dictionarySettingsRequest == null) {
      throw new ApiException(
        "Missing the required parameter 'dictionarySettingsRequest' when calling" +
        " setDictionarySettings(Async)"
      );
    }

    return setDictionarySettingsCall(dictionarySettingsRequest, _callback);
  }

  /**
   * Set dictionary settings.
   *
   * @param dictionarySettingsRequest (required)
   * @return UpdatedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T setDictionarySettings(
    DictionarySettingsRequest dictionarySettingsRequest
  ) throws ApiException {
    Object req = setDictionarySettingsValidateBeforeCall(
      dictionarySettingsRequest,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
      ApiResponse<UpdatedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Set dictionary settings.
   *
   * @param dictionarySettingsRequest (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call setDictionarySettingsAsync(
    DictionarySettingsRequest dictionarySettingsRequest,
    final ApiCallback<UpdatedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) setDictionarySettingsValidateBeforeCall(
      dictionarySettingsRequest,
      _callback
    );
    Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for setSettings
   *
   * @param indexName The index in which to perform the request. (required)
   * @param indexSettings (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object setSettingsCall(
    String indexName,
    IndexSettings indexSettings,
    Boolean forwardToReplicas,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = indexSettings;

    // create path and map variables
    String path =
      "/1/indexes/{indexName}/settings".replaceAll(
          "\\{" + "indexName" + "\\}",
          this.escapeString(indexName.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    if (forwardToReplicas != null) {
      queryParams.addAll(
        this.parameterToPair("forwardToReplicas", forwardToReplicas)
      );
    }

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "PUT",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object setSettingsValidateBeforeCall(
    String indexName,
    IndexSettings indexSettings,
    Boolean forwardToReplicas,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'indexName' is set
    if (indexName == null) {
      throw new ApiException(
        "Missing the required parameter 'indexName' when calling setSettings(Async)"
      );
    }

    // verify the required parameter 'indexSettings' is set
    if (indexSettings == null) {
      throw new ApiException(
        "Missing the required parameter 'indexSettings' when calling setSettings(Async)"
      );
    }

    return setSettingsCall(
      indexName,
      indexSettings,
      forwardToReplicas,
      _callback
    );
  }

  /**
   * Update settings of a given indexName. Only specified settings are overridden; unspecified
   * settings are left unchanged. Specifying null for a setting resets it to its default value.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param indexSettings (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @return UpdatedAtResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T setSettings(
    String indexName,
    IndexSettings indexSettings,
    Boolean forwardToReplicas
  ) throws ApiException {
    Object req = setSettingsValidateBeforeCall(
      indexName,
      indexSettings,
      forwardToReplicas,
      null
    );
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
      ApiResponse<UpdatedAtResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Update settings of a given indexName. Only specified settings are overridden;
   * unspecified settings are left unchanged. Specifying null for a setting resets it to its default
   * value.
   *
   * @param indexName The index in which to perform the request. (required)
   * @param indexSettings (required)
   * @param forwardToReplicas When true, changes are also propagated to replicas of the given
   *     indexName. (optional)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call setSettingsAsync(
    String indexName,
    IndexSettings indexSettings,
    Boolean forwardToReplicas,
    final ApiCallback<UpdatedAtResponse> _callback
  ) throws ApiException {
    Call call = (Call) setSettingsValidateBeforeCall(
      indexName,
      indexSettings,
      forwardToReplicas,
      _callback
    );
    Type returnType = new TypeToken<UpdatedAtResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }

  /**
   * Build call for updateApiKey
   *
   * @param key API Key string. (required)
   * @param apiKey (required)
   * @param _callback Callback for upload/download progress
   * @return Call to execute or EchoRequest
   * @throws ApiException If fail to serialize the request body object
   */
  private Object updateApiKeyCall(
    String key,
    ApiKey apiKey,
    final ApiCallback _callback
  ) throws ApiException {
    Object bodyObj = apiKey;

    // create path and map variables
    String path =
      "/1/keys/{key}".replaceAll(
          "\\{" + "key" + "\\}",
          this.escapeString(key.toString())
        );

    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headers = new HashMap<String, String>();

    headers.put("Accept", "application/json");
    headers.put("Content-Type", "application/json");

    return this.buildCall(
        path,
        "PUT",
        queryParams,
        bodyObj,
        headers,
        _callback
      );
  }

  private Object updateApiKeyValidateBeforeCall(
    String key,
    ApiKey apiKey,
    final ApiCallback _callback
  ) throws ApiException {
    // verify the required parameter 'key' is set
    if (key == null) {
      throw new ApiException(
        "Missing the required parameter 'key' when calling updateApiKey(Async)"
      );
    }

    // verify the required parameter 'apiKey' is set
    if (apiKey == null) {
      throw new ApiException(
        "Missing the required parameter 'apiKey' when calling updateApiKey(Async)"
      );
    }

    return updateApiKeyCall(key, apiKey, _callback);
  }

  /**
   * Replace every permission of an existing API key.
   *
   * @param key API Key string. (required)
   * @param apiKey (required)
   * @return UpdateApiKeyResponse
   * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the
   *     response body
   */
  public <T> T updateApiKey(String key, ApiKey apiKey) throws ApiException {
    Object req = updateApiKeyValidateBeforeCall(key, apiKey, null);
    if (req instanceof Call) {
      Call call = (Call) req;
      Type returnType = new TypeToken<UpdateApiKeyResponse>() {}.getType();
      ApiResponse<UpdateApiKeyResponse> res = this.execute(call, returnType);
      return (T) res.getData();
    }
    return (T) req;
  }

  /**
   * (asynchronously) Replace every permission of an existing API key.
   *
   * @param key API Key string. (required)
   * @param apiKey (required)
   * @param _callback The callback to be executed when the API call finishes
   * @return The request call
   * @throws ApiException If fail to process the API call, e.g. serializing the request body object
   */
  public Call updateApiKeyAsync(
    String key,
    ApiKey apiKey,
    final ApiCallback<UpdateApiKeyResponse> _callback
  ) throws ApiException {
    Call call = (Call) updateApiKeyValidateBeforeCall(key, apiKey, _callback);
    Type returnType = new TypeToken<UpdateApiKeyResponse>() {}.getType();
    this.executeAsync(call, returnType, _callback);
    return call;
  }
}
