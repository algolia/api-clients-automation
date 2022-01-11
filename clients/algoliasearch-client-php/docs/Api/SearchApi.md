# Algolia\AlgoliaSearch\SearchApi

All URIs are relative to http://localhost.

Method | HTTP request | Description
------------- | ------------- | -------------
[**addApiKey()**](SearchApi.md#addApiKey) | **POST** /1/keys | Create a new API key.
[**addOrUpdateObject()**](SearchApi.md#addOrUpdateObject) | **PUT** /1/indexes/{indexName}/{objectID} | Add or replace an object with a given object ID.
[**appendSource()**](SearchApi.md#appendSource) | **POST** /1/security/sources/append | 
[**assignUserId()**](SearchApi.md#assignUserId) | **POST** /1/clusters/mapping | Assign or Move userID
[**batch()**](SearchApi.md#batch) | **POST** /1/indexes/{indexName}/batch | 
[**batchAssignUserIds()**](SearchApi.md#batchAssignUserIds) | **POST** /1/clusters/mapping/batch | Batch assign userIDs
[**batchDictionaryEntries()**](SearchApi.md#batchDictionaryEntries) | **POST** /1/dictionaries/{dictionaryName}/batch | Send a batch of dictionary entries.
[**batchRules()**](SearchApi.md#batchRules) | **POST** /1/indexes/{indexName}/rules/batch | Batch Rules.
[**browse()**](SearchApi.md#browse) | **POST** /1/indexes/{indexName}/browse | Retrieve all index content.
[**clearAllSynonyms()**](SearchApi.md#clearAllSynonyms) | **POST** /1/indexes/{indexName}/synonyms/clear | Clear all synonyms.
[**clearObjects()**](SearchApi.md#clearObjects) | **POST** /1/indexes/{indexName}/clear | clear all objects from an index.
[**clearRules()**](SearchApi.md#clearRules) | **POST** /1/indexes/{indexName}/rules/clear | Clear Rules.
[**deleteApiKey()**](SearchApi.md#deleteApiKey) | **DELETE** /1/keys/{key} | Delete an API key.
[**deleteBy()**](SearchApi.md#deleteBy) | **POST** /1/indexes/{indexName}/deleteByQuery | Delete all records matching the query.
[**deleteIndex()**](SearchApi.md#deleteIndex) | **DELETE** /1/indexes/{indexName} | Delete index.
[**deleteObject()**](SearchApi.md#deleteObject) | **DELETE** /1/indexes/{indexName}/{objectID} | Delete object.
[**deleteRule()**](SearchApi.md#deleteRule) | **DELETE** /1/indexes/{indexName}/rules/{objectID} | Delete a rule.
[**deleteSource()**](SearchApi.md#deleteSource) | **DELETE** /1/security/sources/{source} | 
[**deleteSynonym()**](SearchApi.md#deleteSynonym) | **DELETE** /1/indexes/{indexName}/synonyms/{objectID} | Delete synonym.
[**getApiKey()**](SearchApi.md#getApiKey) | **GET** /1/keys/{key} | Get an API key.
[**getDictionaryLanguages()**](SearchApi.md#getDictionaryLanguages) | **GET** /1/dictionaries/*/languages | List dictionaries supported per language.
[**getDictionarySettings()**](SearchApi.md#getDictionarySettings) | **GET** /1/dictionaries/*/settings | Retrieve dictionaries settings. The API stores languages whose standard entries are disabled. Fetch settings does not return false values.
[**getLogs()**](SearchApi.md#getLogs) | **GET** /1/logs | 
[**getObject()**](SearchApi.md#getObject) | **GET** /1/indexes/{indexName}/{objectID} | Retrieve one object from the index.
[**getObjects()**](SearchApi.md#getObjects) | **POST** /1/indexes/*/objects | Retrieve one or more objects.
[**getRule()**](SearchApi.md#getRule) | **GET** /1/indexes/{indexName}/rules/{objectID} | Get a rule.
[**getSettings()**](SearchApi.md#getSettings) | **GET** /1/indexes/{indexName}/settings | 
[**getSources()**](SearchApi.md#getSources) | **GET** /1/security/sources | 
[**getSynonym()**](SearchApi.md#getSynonym) | **GET** /1/indexes/{indexName}/synonyms/{objectID} | Get synonym.
[**getTask()**](SearchApi.md#getTask) | **GET** /1/indexes/{indexName}/task/{taskID} | 
[**getTopUserIds()**](SearchApi.md#getTopUserIds) | **GET** /1/clusters/mapping/top | Get top userID
[**getUserId()**](SearchApi.md#getUserId) | **GET** /1/clusters/mapping/{userID} | Get userID
[**hasPendingMappings()**](SearchApi.md#hasPendingMappings) | **GET** /1/clusters/mapping/pending | Has pending mappings
[**listApiKeys()**](SearchApi.md#listApiKeys) | **GET** /1/keys | Get the full list of API Keys.
[**listClusters()**](SearchApi.md#listClusters) | **GET** /1/clusters | List clusters
[**listIndices()**](SearchApi.md#listIndices) | **GET** /1/indexes | List existing indexes.
[**listUserIds()**](SearchApi.md#listUserIds) | **GET** /1/clusters/mapping | List userIDs
[**multipleBatch()**](SearchApi.md#multipleBatch) | **POST** /1/indexes/*/batch | 
[**multipleQueries()**](SearchApi.md#multipleQueries) | **POST** /1/indexes/*/queries | 
[**operationIndex()**](SearchApi.md#operationIndex) | **POST** /1/indexes/{indexName}/operation | Copy/move index.
[**partialUpdateObject()**](SearchApi.md#partialUpdateObject) | **POST** /1/indexes/{indexName}/{objectID}/partial | Partially update an object.
[**removeUserId()**](SearchApi.md#removeUserId) | **DELETE** /1/clusters/mapping/{userID} | Remove userID
[**replaceSources()**](SearchApi.md#replaceSources) | **PUT** /1/security/sources | 
[**restoreApiKey()**](SearchApi.md#restoreApiKey) | **POST** /1/keys/{key}/restore | Restore an API key.
[**saveObject()**](SearchApi.md#saveObject) | **POST** /1/indexes/{indexName} | 
[**saveRule()**](SearchApi.md#saveRule) | **PUT** /1/indexes/{indexName}/rules/{objectID} | Save/Update a rule.
[**saveSynonym()**](SearchApi.md#saveSynonym) | **PUT** /1/indexes/{indexName}/synonyms/{objectID} | Save synonym.
[**saveSynonyms()**](SearchApi.md#saveSynonyms) | **POST** /1/indexes/{indexName}/synonyms/batch | Save a batch of synonyms.
[**search()**](SearchApi.md#search) | **POST** /1/indexes/{indexName}/query | 
[**searchDictionaryEntries()**](SearchApi.md#searchDictionaryEntries) | **POST** /1/dictionaries/{dictionaryName}/search | Search the dictionary entries.
[**searchForFacetValues()**](SearchApi.md#searchForFacetValues) | **POST** /1/indexes/{indexName}/facets/{facetName}/query | Search for values of a given facet
[**searchRules()**](SearchApi.md#searchRules) | **POST** /1/indexes/{indexName}/rules/search | Search for rules.
[**searchSynonyms()**](SearchApi.md#searchSynonyms) | **POST** /1/indexes/{indexName}/synonyms/search | Get all synonyms that match a query.
[**searchUserIds()**](SearchApi.md#searchUserIds) | **POST** /1/clusters/mapping/search | Search userID
[**setDictionarySettings()**](SearchApi.md#setDictionarySettings) | **PUT** /1/dictionaries/*/settings | Set dictionary settings.
[**setSettings()**](SearchApi.md#setSettings) | **PUT** /1/indexes/{indexName}/settings | 
[**updateApiKey()**](SearchApi.md#updateApiKey) | **PUT** /1/keys/{key} | Update an API key.


## `addApiKey()`

```php
addApiKey($apiKey): \Algolia\AlgoliaSearch\Model\AddApiKeyResponse
```

Create a new API key.

Add a new API Key with specific permissions/restrictions.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$apiKey = new \Algolia\AlgoliaSearch\Model\ApiKey(); // \Algolia\AlgoliaSearch\Model\ApiKey

try {
    $result = $apiInstance->addApiKey($apiKey);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->addApiKey: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **apiKey** | [**\Algolia\AlgoliaSearch\Model\ApiKey**](../Model/ApiKey.md)|  |

### Return type

[**\Algolia\AlgoliaSearch\Model\AddApiKeyResponse**](../Model/AddApiKeyResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `addOrUpdateObject()`

```php
addOrUpdateObject($indexName, $objectID, $requestBody): \Algolia\AlgoliaSearch\Model\UpdatedAtWithObjectIdResponse
```

Add or replace an object with a given object ID.

Add or replace an object with a given object ID. If the object does not exist, it will be created. If it already exists, it will be replaced.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$objectID = 123; // string | Unique identifier of an object.
$requestBody = array('key' => new \stdClass); // array<string,object> | The Algolia object.

try {
    $result = $apiInstance->addOrUpdateObject($indexName, $objectID, $requestBody);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->addOrUpdateObject: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **objectID** | **string**| Unique identifier of an object. |
 **requestBody** | [**array<string,object>**](../Model/object.md)| The Algolia object. |

### Return type

[**\Algolia\AlgoliaSearch\Model\UpdatedAtWithObjectIdResponse**](../Model/UpdatedAtWithObjectIdResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `appendSource()`

```php
appendSource($source): \Algolia\AlgoliaSearch\Model\CreatedAtResponse
```



Add a single source to the list of allowed sources.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$source = new \Algolia\AlgoliaSearch\Model\Source(); // \Algolia\AlgoliaSearch\Model\Source | The source to add.

try {
    $result = $apiInstance->appendSource($source);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->appendSource: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **source** | [**\Algolia\AlgoliaSearch\Model\Source**](../Model/Source.md)| The source to add. |

### Return type

[**\Algolia\AlgoliaSearch\Model\CreatedAtResponse**](../Model/CreatedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `assignUserId()`

```php
assignUserId($xAlgoliaUserID, $assignUserIdObject): \Algolia\AlgoliaSearch\Model\CreatedAtResponse
```

Assign or Move userID

Assign or Move a userID to a cluster. The time it takes to migrate (move) a user is proportional to the amount of data linked to the userID. Upon success, the response is 200 OK. A successful response indicates that the operation has been taken into account, and the userID is directly usable.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$xAlgoliaUserID = new \stdClass; // object | userID to assign.
$assignUserIdObject = new \Algolia\AlgoliaSearch\Model\AssignUserIdObject(); // \Algolia\AlgoliaSearch\Model\AssignUserIdObject

try {
    $result = $apiInstance->assignUserId($xAlgoliaUserID, $assignUserIdObject);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->assignUserId: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **xAlgoliaUserID** | [**object**](../Model/.md)| userID to assign. |
 **assignUserIdObject** | [**\Algolia\AlgoliaSearch\Model\AssignUserIdObject**](../Model/AssignUserIdObject.md)|  |

### Return type

[**\Algolia\AlgoliaSearch\Model\CreatedAtResponse**](../Model/CreatedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `batch()`

```php
batch($indexName, $batchWriteObject): \Algolia\AlgoliaSearch\Model\BatchResponse
```



Performs multiple write operations in a single API call.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$batchWriteObject = new \Algolia\AlgoliaSearch\Model\BatchWriteObject(); // \Algolia\AlgoliaSearch\Model\BatchWriteObject

try {
    $result = $apiInstance->batch($indexName, $batchWriteObject);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->batch: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **batchWriteObject** | [**\Algolia\AlgoliaSearch\Model\BatchWriteObject**](../Model/BatchWriteObject.md)|  |

### Return type

[**\Algolia\AlgoliaSearch\Model\BatchResponse**](../Model/BatchResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `batchAssignUserIds()`

```php
batchAssignUserIds($xAlgoliaUserID, $batchAssignUserIdsObject): \Algolia\AlgoliaSearch\Model\CreatedAtResponse
```

Batch assign userIDs

Assign multiple userIDs to a cluster. Upon success, the response is 200 OK. A successful response indicates that the operation has been taken into account, and the userIDs are directly usable.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$xAlgoliaUserID = new \stdClass; // object | userID to assign.
$batchAssignUserIdsObject = new \Algolia\AlgoliaSearch\Model\BatchAssignUserIdsObject(); // \Algolia\AlgoliaSearch\Model\BatchAssignUserIdsObject

try {
    $result = $apiInstance->batchAssignUserIds($xAlgoliaUserID, $batchAssignUserIdsObject);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->batchAssignUserIds: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **xAlgoliaUserID** | [**object**](../Model/.md)| userID to assign. |
 **batchAssignUserIdsObject** | [**\Algolia\AlgoliaSearch\Model\BatchAssignUserIdsObject**](../Model/BatchAssignUserIdsObject.md)|  |

### Return type

[**\Algolia\AlgoliaSearch\Model\CreatedAtResponse**](../Model/CreatedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `batchDictionaryEntries()`

```php
batchDictionaryEntries($dictionaryName, $batchDictionaryEntries): \Algolia\AlgoliaSearch\Model\UpdatedAtResponse
```

Send a batch of dictionary entries.

Send a batch of dictionary entries.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$dictionaryName = 'dictionaryName_example'; // string | The dictionary to search in.
$batchDictionaryEntries = new \Algolia\AlgoliaSearch\Model\BatchDictionaryEntries(); // \Algolia\AlgoliaSearch\Model\BatchDictionaryEntries

try {
    $result = $apiInstance->batchDictionaryEntries($dictionaryName, $batchDictionaryEntries);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->batchDictionaryEntries: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dictionaryName** | **string**| The dictionary to search in. |
 **batchDictionaryEntries** | [**\Algolia\AlgoliaSearch\Model\BatchDictionaryEntries**](../Model/BatchDictionaryEntries.md)|  |

### Return type

[**\Algolia\AlgoliaSearch\Model\UpdatedAtResponse**](../Model/UpdatedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `batchRules()`

```php
batchRules($indexName, $rule, $forwardToReplicas, $clearExistingRules): \Algolia\AlgoliaSearch\Model\UpdatedAtResponse
```

Batch Rules.

Create or update a batch of Rules.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$rule = array(new \Algolia\AlgoliaSearch\Model\Rule()); // \Algolia\AlgoliaSearch\Model\Rule[]
$forwardToReplicas = True; // bool | When true, changes are also propagated to replicas of the given indexName.
$clearExistingRules = True; // bool | When true, existing Rules are cleared before adding this batch. When false, existing Rules are kept.

try {
    $result = $apiInstance->batchRules($indexName, $rule, $forwardToReplicas, $clearExistingRules);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->batchRules: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **rule** | [**\Algolia\AlgoliaSearch\Model\Rule[]**](../Model/Rule.md)|  |
 **forwardToReplicas** | **bool**| When true, changes are also propagated to replicas of the given indexName. | [optional]
 **clearExistingRules** | **bool**| When true, existing Rules are cleared before adding this batch. When false, existing Rules are kept. | [optional]

### Return type

[**\Algolia\AlgoliaSearch\Model\UpdatedAtResponse**](../Model/UpdatedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `browse()`

```php
browse($indexName, $browseRequest): \Algolia\AlgoliaSearch\Model\BrowseResponse
```

Retrieve all index content.

This method allows you to retrieve all index content. It can retrieve up to 1,000 records per call and supports full text search and filters. For performance reasons, some features are not supported, including `distinct`, sorting by `typos`, `words` or `geo distance`. When there is more content to be browsed, the response contains a cursor field. This cursor has to be passed to the subsequent call to browse in order to get the next page of results. When the end of the index has been reached, the cursor field is absent from the response.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$browseRequest = new \Algolia\AlgoliaSearch\Model\BrowseRequest(); // \Algolia\AlgoliaSearch\Model\BrowseRequest

try {
    $result = $apiInstance->browse($indexName, $browseRequest);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->browse: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **browseRequest** | [**\Algolia\AlgoliaSearch\Model\BrowseRequest**](../Model/BrowseRequest.md)|  | [optional]

### Return type

[**\Algolia\AlgoliaSearch\Model\BrowseResponse**](../Model/BrowseResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `clearAllSynonyms()`

```php
clearAllSynonyms($indexName, $forwardToReplicas): \Algolia\AlgoliaSearch\Model\UpdatedAtResponse
```

Clear all synonyms.

Remove all synonyms from an index.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$forwardToReplicas = True; // bool | When true, changes are also propagated to replicas of the given indexName.

try {
    $result = $apiInstance->clearAllSynonyms($indexName, $forwardToReplicas);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->clearAllSynonyms: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **forwardToReplicas** | **bool**| When true, changes are also propagated to replicas of the given indexName. | [optional]

### Return type

[**\Algolia\AlgoliaSearch\Model\UpdatedAtResponse**](../Model/UpdatedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `clearObjects()`

```php
clearObjects($indexName): \Algolia\AlgoliaSearch\Model\UpdatedAtResponse
```

clear all objects from an index.

Delete an index's content, but leave settings and index-specific API keys untouched.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.

try {
    $result = $apiInstance->clearObjects($indexName);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->clearObjects: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |

### Return type

[**\Algolia\AlgoliaSearch\Model\UpdatedAtResponse**](../Model/UpdatedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `clearRules()`

```php
clearRules($indexName, $forwardToReplicas): \Algolia\AlgoliaSearch\Model\UpdatedAtResponse
```

Clear Rules.

Delete all Rules in the index.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$forwardToReplicas = True; // bool | When true, changes are also propagated to replicas of the given indexName.

try {
    $result = $apiInstance->clearRules($indexName, $forwardToReplicas);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->clearRules: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **forwardToReplicas** | **bool**| When true, changes are also propagated to replicas of the given indexName. | [optional]

### Return type

[**\Algolia\AlgoliaSearch\Model\UpdatedAtResponse**](../Model/UpdatedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `deleteApiKey()`

```php
deleteApiKey($key): \Algolia\AlgoliaSearch\Model\DeleteApiKeyResponse
```

Delete an API key.

Delete an existing API Key.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$key = myAPIKey; // string | API Key string.

try {
    $result = $apiInstance->deleteApiKey($key);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->deleteApiKey: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **string**| API Key string. |

### Return type

[**\Algolia\AlgoliaSearch\Model\DeleteApiKeyResponse**](../Model/DeleteApiKeyResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `deleteBy()`

```php
deleteBy($indexName, $searchParams): \Algolia\AlgoliaSearch\Model\DeletedAtResponse
```

Delete all records matching the query.

Remove all objects matching a filter (including geo filters). This method enables you to delete one or more objects based on filters (numeric, facet, tag or geo queries). It doesn't accept empty filters or a query.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$searchParams = new \Algolia\AlgoliaSearch\Model\SearchParams(); // \Algolia\AlgoliaSearch\Model\SearchParams

try {
    $result = $apiInstance->deleteBy($indexName, $searchParams);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->deleteBy: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **searchParams** | [**\Algolia\AlgoliaSearch\Model\SearchParams**](../Model/SearchParams.md)|  |

### Return type

[**\Algolia\AlgoliaSearch\Model\DeletedAtResponse**](../Model/DeletedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `deleteIndex()`

```php
deleteIndex($indexName): \Algolia\AlgoliaSearch\Model\DeletedAtResponse
```

Delete index.

Delete an existing index.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.

try {
    $result = $apiInstance->deleteIndex($indexName);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->deleteIndex: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |

### Return type

[**\Algolia\AlgoliaSearch\Model\DeletedAtResponse**](../Model/DeletedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `deleteObject()`

```php
deleteObject($indexName, $objectID): \Algolia\AlgoliaSearch\Model\DeletedAtResponse
```

Delete object.

Delete an existing object.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$objectID = 123; // string | Unique identifier of an object.

try {
    $result = $apiInstance->deleteObject($indexName, $objectID);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->deleteObject: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **objectID** | **string**| Unique identifier of an object. |

### Return type

[**\Algolia\AlgoliaSearch\Model\DeletedAtResponse**](../Model/DeletedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `deleteRule()`

```php
deleteRule($indexName, $objectID, $forwardToReplicas): \Algolia\AlgoliaSearch\Model\UpdatedAtResponse
```

Delete a rule.

Delete the Rule with the specified objectID.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$objectID = 123; // string | Unique identifier of an object.
$forwardToReplicas = True; // bool | When true, changes are also propagated to replicas of the given indexName.

try {
    $result = $apiInstance->deleteRule($indexName, $objectID, $forwardToReplicas);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->deleteRule: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **objectID** | **string**| Unique identifier of an object. |
 **forwardToReplicas** | **bool**| When true, changes are also propagated to replicas of the given indexName. | [optional]

### Return type

[**\Algolia\AlgoliaSearch\Model\UpdatedAtResponse**](../Model/UpdatedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `deleteSource()`

```php
deleteSource($source): \Algolia\AlgoliaSearch\Model\DeleteSourceResponse
```



Remove a single source from the list of allowed sources.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$source = 10.0.0.1/32; // string | The IP range of the source.

try {
    $result = $apiInstance->deleteSource($source);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->deleteSource: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **source** | **string**| The IP range of the source. |

### Return type

[**\Algolia\AlgoliaSearch\Model\DeleteSourceResponse**](../Model/DeleteSourceResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `deleteSynonym()`

```php
deleteSynonym($indexName, $objectID, $forwardToReplicas): \Algolia\AlgoliaSearch\Model\DeletedAtResponse
```

Delete synonym.

Delete a single synonyms set, identified by the given objectID.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$objectID = 123; // string | Unique identifier of an object.
$forwardToReplicas = True; // bool | When true, changes are also propagated to replicas of the given indexName.

try {
    $result = $apiInstance->deleteSynonym($indexName, $objectID, $forwardToReplicas);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->deleteSynonym: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **objectID** | **string**| Unique identifier of an object. |
 **forwardToReplicas** | **bool**| When true, changes are also propagated to replicas of the given indexName. | [optional]

### Return type

[**\Algolia\AlgoliaSearch\Model\DeletedAtResponse**](../Model/DeletedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getApiKey()`

```php
getApiKey($key): \Algolia\AlgoliaSearch\Model\KeyObject
```

Get an API key.

Get the permissions of an API key.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$key = myAPIKey; // string | API Key string.

try {
    $result = $apiInstance->getApiKey($key);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->getApiKey: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **string**| API Key string. |

### Return type

[**\Algolia\AlgoliaSearch\Model\KeyObject**](../Model/KeyObject.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getDictionaryLanguages()`

```php
getDictionaryLanguages(): array<string,\Algolia\AlgoliaSearch\Model\Languages>
```

List dictionaries supported per language.

List dictionaries supported per language.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);

try {
    $result = $apiInstance->getDictionaryLanguages();
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->getDictionaryLanguages: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**array<string,\Algolia\AlgoliaSearch\Model\Languages>**](../Model/Languages.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getDictionarySettings()`

```php
getDictionarySettings(): \Algolia\AlgoliaSearch\Model\GetDictionarySettingsResponse
```

Retrieve dictionaries settings. The API stores languages whose standard entries are disabled. Fetch settings does not return false values.

Retrieve dictionaries settings.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);

try {
    $result = $apiInstance->getDictionarySettings();
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->getDictionarySettings: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**\Algolia\AlgoliaSearch\Model\GetDictionarySettingsResponse**](../Model/GetDictionarySettingsResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getLogs()`

```php
getLogs($offset, $length, $indexName, $type): \Algolia\AlgoliaSearch\Model\GetLogsResponse
```



Return the lastest log entries.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$offset = 0; // int | First entry to retrieve (zero-based). Log entries are sorted by decreasing date, therefore 0 designates the most recent log entry.
$length = 10; // int | Maximum number of entries to retrieve. The maximum allowed value is 1000.
$indexName = 'indexName_example'; // string | Index for which log entries should be retrieved. When omitted, log entries are retrieved across all indices.
$type = 'all'; // string | Type of log entries to retrieve. When omitted, all log entries are retrieved.

try {
    $result = $apiInstance->getLogs($offset, $length, $indexName, $type);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->getLogs: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **offset** | **int**| First entry to retrieve (zero-based). Log entries are sorted by decreasing date, therefore 0 designates the most recent log entry. | [optional] [default to 0]
 **length** | **int**| Maximum number of entries to retrieve. The maximum allowed value is 1000. | [optional] [default to 10]
 **indexName** | **string**| Index for which log entries should be retrieved. When omitted, log entries are retrieved across all indices. | [optional]
 **type** | **string**| Type of log entries to retrieve. When omitted, all log entries are retrieved. | [optional] [default to &#39;all&#39;]

### Return type

[**\Algolia\AlgoliaSearch\Model\GetLogsResponse**](../Model/GetLogsResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getObject()`

```php
getObject($indexName, $objectID, $attributesToRetrieve): array<string,string>
```

Retrieve one object from the index.

Retrieve one object from the index.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$objectID = 123; // string | Unique identifier of an object.
$attributesToRetrieve = array('attributesToRetrieve_example'); // string[]

try {
    $result = $apiInstance->getObject($indexName, $objectID, $attributesToRetrieve);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->getObject: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **objectID** | **string**| Unique identifier of an object. |
 **attributesToRetrieve** | [**string[]**](../Model/string.md)|  | [optional]

### Return type

**array<string,string>**

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getObjects()`

```php
getObjects($getObjectsObject): \Algolia\AlgoliaSearch\Model\GetObjectsResponse
```

Retrieve one or more objects.

Retrieve one or more objects, potentially from different indices, in a single API call.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$getObjectsObject = new \Algolia\AlgoliaSearch\Model\GetObjectsObject(); // \Algolia\AlgoliaSearch\Model\GetObjectsObject

try {
    $result = $apiInstance->getObjects($getObjectsObject);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->getObjects: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **getObjectsObject** | [**\Algolia\AlgoliaSearch\Model\GetObjectsObject**](../Model/GetObjectsObject.md)|  |

### Return type

[**\Algolia\AlgoliaSearch\Model\GetObjectsResponse**](../Model/GetObjectsResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getRule()`

```php
getRule($indexName, $objectID): \Algolia\AlgoliaSearch\Model\Rule
```

Get a rule.

Retrieve the Rule with the specified objectID.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$objectID = 123; // string | Unique identifier of an object.

try {
    $result = $apiInstance->getRule($indexName, $objectID);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->getRule: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **objectID** | **string**| Unique identifier of an object. |

### Return type

[**\Algolia\AlgoliaSearch\Model\Rule**](../Model/Rule.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getSettings()`

```php
getSettings($indexName): \Algolia\AlgoliaSearch\Model\IndexSettings
```



Retrieve settings of a given indexName.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.

try {
    $result = $apiInstance->getSettings($indexName);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->getSettings: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |

### Return type

[**\Algolia\AlgoliaSearch\Model\IndexSettings**](../Model/IndexSettings.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getSources()`

```php
getSources(): \Algolia\AlgoliaSearch\Model\Source[]
```



List all allowed sources.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);

try {
    $result = $apiInstance->getSources();
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->getSources: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**\Algolia\AlgoliaSearch\Model\Source[]**](../Model/Source.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getSynonym()`

```php
getSynonym($indexName, $objectID): \Algolia\AlgoliaSearch\Model\SynonymHit
```

Get synonym.

Fetch a synonym object identified by its objectID.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$objectID = 123; // string | Unique identifier of an object.

try {
    $result = $apiInstance->getSynonym($indexName, $objectID);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->getSynonym: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **objectID** | **string**| Unique identifier of an object. |

### Return type

[**\Algolia\AlgoliaSearch\Model\SynonymHit**](../Model/SynonymHit.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getTask()`

```php
getTask($indexName, $taskID): \Algolia\AlgoliaSearch\Model\GetTaskResponse
```



Check the current status of a given task.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$taskID = 13235; // int | Unique identifier of an task. Numeric value (up to 64bits)

try {
    $result = $apiInstance->getTask($indexName, $taskID);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->getTask: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **taskID** | **int**| Unique identifier of an task. Numeric value (up to 64bits) |

### Return type

[**\Algolia\AlgoliaSearch\Model\GetTaskResponse**](../Model/GetTaskResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getTopUserIds()`

```php
getTopUserIds(): \Algolia\AlgoliaSearch\Model\GetTopUserIdsResponse
```

Get top userID

Get the top 10 userIDs with the highest number of records per cluster. The data returned will usually be a few seconds behind real time, because userID usage may take up to a few seconds to propagate to the different clusters. Upon success, the response is 200 OK and contains the following array of userIDs and clusters.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);

try {
    $result = $apiInstance->getTopUserIds();
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->getTopUserIds: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**\Algolia\AlgoliaSearch\Model\GetTopUserIdsResponse**](../Model/GetTopUserIdsResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `getUserId()`

```php
getUserId($userID): \Algolia\AlgoliaSearch\Model\UserId
```

Get userID

Returns the userID data stored in the mapping. The data returned will usually be a few seconds behind real time, because userID usage may take up to a few seconds to propagate to the different clusters. Upon success, the response is 200 OK and contains the following userID data.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$userID = new \stdClass; // object | userID to assign.

try {
    $result = $apiInstance->getUserId($userID);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->getUserId: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userID** | [**object**](../Model/.md)| userID to assign. |

### Return type

[**\Algolia\AlgoliaSearch\Model\UserId**](../Model/UserId.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `hasPendingMappings()`

```php
hasPendingMappings($getClusters): \Algolia\AlgoliaSearch\Model\CreatedAtResponse
```

Has pending mappings

Get the status of your clusters' migrations or user creations. Creating a large batch of users or migrating your multi-cluster may take quite some time. This method lets you retrieve the status of the migration, so you can know when it's done. Upon success, the response is 200 OK. A successful response indicates that the operation has been taken into account, and the userIDs are directly usable.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$getClusters = True; // bool

try {
    $result = $apiInstance->hasPendingMappings($getClusters);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->hasPendingMappings: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **getClusters** | **bool**|  | [optional]

### Return type

[**\Algolia\AlgoliaSearch\Model\CreatedAtResponse**](../Model/CreatedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `listApiKeys()`

```php
listApiKeys(): \Algolia\AlgoliaSearch\Model\ListApiKeysResponse
```

Get the full list of API Keys.

List API keys, along with their associated rights.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);

try {
    $result = $apiInstance->listApiKeys();
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->listApiKeys: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**\Algolia\AlgoliaSearch\Model\ListApiKeysResponse**](../Model/ListApiKeysResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `listClusters()`

```php
listClusters(): \Algolia\AlgoliaSearch\Model\ListClustersResponse
```

List clusters

List the clusters available in a multi-clusters setup for a single appID. Upon success, the response is 200 OK and contains the following clusters.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);

try {
    $result = $apiInstance->listClusters();
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->listClusters: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**\Algolia\AlgoliaSearch\Model\ListClustersResponse**](../Model/ListClustersResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `listIndices()`

```php
listIndices($page): \Algolia\AlgoliaSearch\Model\ListIndicesResponse
```

List existing indexes.

List existing indexes from an application.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$page = 56; // int | Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination).

try {
    $result = $apiInstance->listIndices($page);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->listIndices: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination). | [optional]

### Return type

[**\Algolia\AlgoliaSearch\Model\ListIndicesResponse**](../Model/ListIndicesResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `listUserIds()`

```php
listUserIds($page, $hitsPerPage): \Algolia\AlgoliaSearch\Model\ListUserIdsResponse
```

List userIDs

List the userIDs assigned to a multi-clusters appID. The data returned will usually be a few seconds behind real time, because userID usage may take up to a few seconds to propagate to the different clusters. Upon success, the response is 200 OK and contains the following userIDs data.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$page = 56; // int | Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination).
$hitsPerPage = 100; // int | Maximum number of objects to retrieve.

try {
    $result = $apiInstance->listUserIds($page, $hitsPerPage);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->listUserIds: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **int**| Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination). | [optional]
 **hitsPerPage** | **int**| Maximum number of objects to retrieve. | [optional] [default to 100]

### Return type

[**\Algolia\AlgoliaSearch\Model\ListUserIdsResponse**](../Model/ListUserIdsResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `multipleBatch()`

```php
multipleBatch($batchObject): \Algolia\AlgoliaSearch\Model\MultipleBatchResponse
```



Perform multiple write operations, potentially targeting multiple indices, in a single API call.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$batchObject = new \Algolia\AlgoliaSearch\Model\BatchObject(); // \Algolia\AlgoliaSearch\Model\BatchObject

try {
    $result = $apiInstance->multipleBatch($batchObject);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->multipleBatch: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **batchObject** | [**\Algolia\AlgoliaSearch\Model\BatchObject**](../Model/BatchObject.md)|  |

### Return type

[**\Algolia\AlgoliaSearch\Model\MultipleBatchResponse**](../Model/MultipleBatchResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `multipleQueries()`

```php
multipleQueries($multipleQueriesObject): \Algolia\AlgoliaSearch\Model\MultipleQueriesResponse
```



Get search results for the given requests.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$multipleQueriesObject = new \Algolia\AlgoliaSearch\Model\MultipleQueriesObject(); // \Algolia\AlgoliaSearch\Model\MultipleQueriesObject

try {
    $result = $apiInstance->multipleQueries($multipleQueriesObject);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->multipleQueries: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **multipleQueriesObject** | [**\Algolia\AlgoliaSearch\Model\MultipleQueriesObject**](../Model/MultipleQueriesObject.md)|  |

### Return type

[**\Algolia\AlgoliaSearch\Model\MultipleQueriesResponse**](../Model/MultipleQueriesResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `operationIndex()`

```php
operationIndex($indexName, $operationIndexObject): \Algolia\AlgoliaSearch\Model\UpdatedAtResponse
```

Copy/move index.

Peforms a copy or a move operation on a index.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$operationIndexObject = new \Algolia\AlgoliaSearch\Model\OperationIndexObject(); // \Algolia\AlgoliaSearch\Model\OperationIndexObject

try {
    $result = $apiInstance->operationIndex($indexName, $operationIndexObject);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->operationIndex: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **operationIndexObject** | [**\Algolia\AlgoliaSearch\Model\OperationIndexObject**](../Model/OperationIndexObject.md)|  |

### Return type

[**\Algolia\AlgoliaSearch\Model\UpdatedAtResponse**](../Model/UpdatedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `partialUpdateObject()`

```php
partialUpdateObject($indexName, $objectID, $oneOfStringBuildInOperation, $createIfNotExists): \Algolia\AlgoliaSearch\Model\UpdatedAtWithObjectIdResponse
```

Partially update an object.

Update one or more attributes of an existing object. This method lets you update only a part of an existing object, either by adding new attributes or updating existing ones. You can partially update several objects in a single method call. If the index targeted by this operation doesn't exist yet, it's automatically created.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$objectID = 123; // string | Unique identifier of an object.
$oneOfStringBuildInOperation = NULL; // array<string,OneOfStringBuildInOperation>[] | The Algolia object.
$createIfNotExists = true; // bool | Creates the record if it does not exist yet.

try {
    $result = $apiInstance->partialUpdateObject($indexName, $objectID, $oneOfStringBuildInOperation, $createIfNotExists);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->partialUpdateObject: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **objectID** | **string**| Unique identifier of an object. |
 **oneOfStringBuildInOperation** | [**array<string,OneOfStringBuildInOperation>[]**](../Model/array.md)| The Algolia object. |
 **createIfNotExists** | **bool**| Creates the record if it does not exist yet. | [optional] [default to true]

### Return type

[**\Algolia\AlgoliaSearch\Model\UpdatedAtWithObjectIdResponse**](../Model/UpdatedAtWithObjectIdResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `removeUserId()`

```php
removeUserId($userID): \Algolia\AlgoliaSearch\Model\RemoveUserIdResponse
```

Remove userID

Remove a userID and its associated data from the multi-clusters. Upon success, the response is 200 OK and a task is created to remove the userID data and mapping.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$userID = new \stdClass; // object | userID to assign.

try {
    $result = $apiInstance->removeUserId($userID);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->removeUserId: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userID** | [**object**](../Model/.md)| userID to assign. |

### Return type

[**\Algolia\AlgoliaSearch\Model\RemoveUserIdResponse**](../Model/RemoveUserIdResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `replaceSources()`

```php
replaceSources($source): \Algolia\AlgoliaSearch\Model\ReplaceSourceResponse
```



Replace all allowed sources.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$source = array(new \Algolia\AlgoliaSearch\Model\Source()); // \Algolia\AlgoliaSearch\Model\Source[] | The sources to allow.

try {
    $result = $apiInstance->replaceSources($source);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->replaceSources: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **source** | [**\Algolia\AlgoliaSearch\Model\Source[]**](../Model/Source.md)| The sources to allow. |

### Return type

[**\Algolia\AlgoliaSearch\Model\ReplaceSourceResponse**](../Model/ReplaceSourceResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `restoreApiKey()`

```php
restoreApiKey($key): \Algolia\AlgoliaSearch\Model\AddApiKeyResponse
```

Restore an API key.

Restore a deleted API key, along with its associated rights.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$key = myAPIKey; // string | API Key string.

try {
    $result = $apiInstance->restoreApiKey($key);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->restoreApiKey: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **string**| API Key string. |

### Return type

[**\Algolia\AlgoliaSearch\Model\AddApiKeyResponse**](../Model/AddApiKeyResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `saveObject()`

```php
saveObject($indexName, $requestBody): \Algolia\AlgoliaSearch\Model\SaveObjectResponse
```



Add an object to the index, automatically assigning it an object ID.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$requestBody = array('key' => new \stdClass); // array<string,object> | The Algolia object.

try {
    $result = $apiInstance->saveObject($indexName, $requestBody);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->saveObject: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **requestBody** | [**array<string,object>**](../Model/object.md)| The Algolia object. |

### Return type

[**\Algolia\AlgoliaSearch\Model\SaveObjectResponse**](../Model/SaveObjectResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `saveRule()`

```php
saveRule($indexName, $objectID, $rule, $forwardToReplicas): \Algolia\AlgoliaSearch\Model\UpdatedRuleResponse
```

Save/Update a rule.

Create or update the Rule with the specified objectID.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$objectID = 123; // string | Unique identifier of an object.
$rule = new \Algolia\AlgoliaSearch\Model\Rule(); // \Algolia\AlgoliaSearch\Model\Rule
$forwardToReplicas = True; // bool | When true, changes are also propagated to replicas of the given indexName.

try {
    $result = $apiInstance->saveRule($indexName, $objectID, $rule, $forwardToReplicas);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->saveRule: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **objectID** | **string**| Unique identifier of an object. |
 **rule** | [**\Algolia\AlgoliaSearch\Model\Rule**](../Model/Rule.md)|  |
 **forwardToReplicas** | **bool**| When true, changes are also propagated to replicas of the given indexName. | [optional]

### Return type

[**\Algolia\AlgoliaSearch\Model\UpdatedRuleResponse**](../Model/UpdatedRuleResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `saveSynonym()`

```php
saveSynonym($indexName, $objectID, $synonymHit, $forwardToReplicas): \Algolia\AlgoliaSearch\Model\SaveSynonymResponse
```

Save synonym.

Create a new synonym object or update the existing synonym object with the given object ID.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$objectID = 123; // string | Unique identifier of an object.
$synonymHit = new \Algolia\AlgoliaSearch\Model\SynonymHit(); // \Algolia\AlgoliaSearch\Model\SynonymHit
$forwardToReplicas = True; // bool | When true, changes are also propagated to replicas of the given indexName.

try {
    $result = $apiInstance->saveSynonym($indexName, $objectID, $synonymHit, $forwardToReplicas);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->saveSynonym: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **objectID** | **string**| Unique identifier of an object. |
 **synonymHit** | [**\Algolia\AlgoliaSearch\Model\SynonymHit**](../Model/SynonymHit.md)|  |
 **forwardToReplicas** | **bool**| When true, changes are also propagated to replicas of the given indexName. | [optional]

### Return type

[**\Algolia\AlgoliaSearch\Model\SaveSynonymResponse**](../Model/SaveSynonymResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `saveSynonyms()`

```php
saveSynonyms($indexName, $synonymHit, $forwardToReplicas, $replaceExistingSynonyms): \Algolia\AlgoliaSearch\Model\UpdatedAtResponse
```

Save a batch of synonyms.

Create/update multiple synonym objects at once, potentially replacing the entire list of synonyms if replaceExistingSynonyms is true.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$synonymHit = array(new \Algolia\AlgoliaSearch\Model\SynonymHit()); // \Algolia\AlgoliaSearch\Model\SynonymHit[]
$forwardToReplicas = True; // bool | When true, changes are also propagated to replicas of the given indexName.
$replaceExistingSynonyms = True; // bool | Replace all synonyms of the index with the ones sent with this request.

try {
    $result = $apiInstance->saveSynonyms($indexName, $synonymHit, $forwardToReplicas, $replaceExistingSynonyms);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->saveSynonyms: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **synonymHit** | [**\Algolia\AlgoliaSearch\Model\SynonymHit[]**](../Model/SynonymHit.md)|  |
 **forwardToReplicas** | **bool**| When true, changes are also propagated to replicas of the given indexName. | [optional]
 **replaceExistingSynonyms** | **bool**| Replace all synonyms of the index with the ones sent with this request. | [optional]

### Return type

[**\Algolia\AlgoliaSearch\Model\UpdatedAtResponse**](../Model/UpdatedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `search()`

```php
search($indexName, $searchParams): \Algolia\AlgoliaSearch\Model\SearchResponse
```



Get search results.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$searchParams = new \Algolia\AlgoliaSearch\Model\SearchParams(); // \Algolia\AlgoliaSearch\Model\SearchParams

try {
    $result = $apiInstance->search($indexName, $searchParams);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->search: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **searchParams** | [**\Algolia\AlgoliaSearch\Model\SearchParams**](../Model/SearchParams.md)|  |

### Return type

[**\Algolia\AlgoliaSearch\Model\SearchResponse**](../Model/SearchResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `searchDictionaryEntries()`

```php
searchDictionaryEntries($dictionaryName, $searchDictionaryEntries): \Algolia\AlgoliaSearch\Model\UpdatedAtResponse
```

Search the dictionary entries.

Search the dictionary entries.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$dictionaryName = 'dictionaryName_example'; // string | The dictionary to search in.
$searchDictionaryEntries = new \Algolia\AlgoliaSearch\Model\SearchDictionaryEntries(); // \Algolia\AlgoliaSearch\Model\SearchDictionaryEntries

try {
    $result = $apiInstance->searchDictionaryEntries($dictionaryName, $searchDictionaryEntries);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->searchDictionaryEntries: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dictionaryName** | **string**| The dictionary to search in. |
 **searchDictionaryEntries** | [**\Algolia\AlgoliaSearch\Model\SearchDictionaryEntries**](../Model/SearchDictionaryEntries.md)|  |

### Return type

[**\Algolia\AlgoliaSearch\Model\UpdatedAtResponse**](../Model/UpdatedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `searchForFacetValues()`

```php
searchForFacetValues($indexName, $facetName, $searchForFacetValuesRequest): \Algolia\AlgoliaSearch\Model\SearchForFacetValuesResponse
```

Search for values of a given facet

Search for values of a given facet, optionally restricting the returned values to those contained in objects matching other search criteria.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$facetName = 'facetName_example'; // string | The facet name.
$searchForFacetValuesRequest = new \Algolia\AlgoliaSearch\Model\SearchForFacetValuesRequest(); // \Algolia\AlgoliaSearch\Model\SearchForFacetValuesRequest

try {
    $result = $apiInstance->searchForFacetValues($indexName, $facetName, $searchForFacetValuesRequest);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->searchForFacetValues: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **facetName** | **string**| The facet name. |
 **searchForFacetValuesRequest** | [**\Algolia\AlgoliaSearch\Model\SearchForFacetValuesRequest**](../Model/SearchForFacetValuesRequest.md)|  | [optional]

### Return type

[**\Algolia\AlgoliaSearch\Model\SearchForFacetValuesResponse**](../Model/SearchForFacetValuesResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `searchRules()`

```php
searchRules($indexName, $searchRulesParams): \Algolia\AlgoliaSearch\Model\SearchRulesResponse
```

Search for rules.

Search for rules matching various criteria.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$searchRulesParams = new \Algolia\AlgoliaSearch\Model\SearchRulesParams(); // \Algolia\AlgoliaSearch\Model\SearchRulesParams

try {
    $result = $apiInstance->searchRules($indexName, $searchRulesParams);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->searchRules: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **searchRulesParams** | [**\Algolia\AlgoliaSearch\Model\SearchRulesParams**](../Model/SearchRulesParams.md)|  |

### Return type

[**\Algolia\AlgoliaSearch\Model\SearchRulesResponse**](../Model/SearchRulesResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `searchSynonyms()`

```php
searchSynonyms($indexName, $query, $type, $page, $hitsPerPage): \Algolia\AlgoliaSearch\Model\SearchSynonymsResponse
```

Get all synonyms that match a query.

Search or browse all synonyms, optionally filtering them by type.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$query = ''; // string | Search for specific synonyms matching this string.
$type = 'type_example'; // string | Only search for specific types of synonyms.
$page = 0; // int | Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination).
$hitsPerPage = 100; // int | Maximum number of objects to retrieve.

try {
    $result = $apiInstance->searchSynonyms($indexName, $query, $type, $page, $hitsPerPage);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->searchSynonyms: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **query** | **string**| Search for specific synonyms matching this string. | [optional] [default to &#39;&#39;]
 **type** | **string**| Only search for specific types of synonyms. | [optional]
 **page** | **int**| Requested page (zero-based). When specified, will retrieve a specific page; the page size is implicitly set to 100. When null, will retrieve all indices (no pagination). | [optional] [default to 0]
 **hitsPerPage** | **int**| Maximum number of objects to retrieve. | [optional] [default to 100]

### Return type

[**\Algolia\AlgoliaSearch\Model\SearchSynonymsResponse**](../Model/SearchSynonymsResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `searchUserIds()`

```php
searchUserIds($searchUserIdsObject): \Algolia\AlgoliaSearch\Model\SearchUserIdsResponse
```

Search userID

Search for userIDs. The data returned will usually be a few seconds behind real time, because userID usage may take up to a few seconds propagate to the different clusters. To keep updates moving quickly, the index of userIDs isn't built synchronously with the mapping. Instead, the index is built once every 12h, at the same time as the update of userID usage. For example, when you perform a modification like adding or moving a userID, the search will report an outdated value until the next rebuild of the mapping, which takes place every 12h. Upon success, the response is 200 OK and contains the following userIDs data.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$searchUserIdsObject = new \Algolia\AlgoliaSearch\Model\SearchUserIdsObject(); // \Algolia\AlgoliaSearch\Model\SearchUserIdsObject

try {
    $result = $apiInstance->searchUserIds($searchUserIdsObject);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->searchUserIds: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **searchUserIdsObject** | [**\Algolia\AlgoliaSearch\Model\SearchUserIdsObject**](../Model/SearchUserIdsObject.md)|  |

### Return type

[**\Algolia\AlgoliaSearch\Model\SearchUserIdsResponse**](../Model/SearchUserIdsResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `setDictionarySettings()`

```php
setDictionarySettings($dictionarySettingsRequest): \Algolia\AlgoliaSearch\Model\UpdatedAtResponse
```

Set dictionary settings.

Set dictionary settings.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$dictionarySettingsRequest = new \Algolia\AlgoliaSearch\Model\DictionarySettingsRequest(); // \Algolia\AlgoliaSearch\Model\DictionarySettingsRequest

try {
    $result = $apiInstance->setDictionarySettings($dictionarySettingsRequest);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->setDictionarySettings: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **dictionarySettingsRequest** | [**\Algolia\AlgoliaSearch\Model\DictionarySettingsRequest**](../Model/DictionarySettingsRequest.md)|  |

### Return type

[**\Algolia\AlgoliaSearch\Model\UpdatedAtResponse**](../Model/UpdatedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `setSettings()`

```php
setSettings($indexName, $indexSettings, $forwardToReplicas): \Algolia\AlgoliaSearch\Model\UpdatedAtResponse
```



Update settings of a given indexName. Only specified settings are overridden; unspecified settings are left unchanged. Specifying null for a setting resets it to its default value.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$indexName = myIndexName; // string | The index in which to perform the request.
$indexSettings = new \Algolia\AlgoliaSearch\Model\IndexSettings(); // \Algolia\AlgoliaSearch\Model\IndexSettings
$forwardToReplicas = True; // bool | When true, changes are also propagated to replicas of the given indexName.

try {
    $result = $apiInstance->setSettings($indexName, $indexSettings, $forwardToReplicas);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->setSettings: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **indexName** | **string**| The index in which to perform the request. |
 **indexSettings** | [**\Algolia\AlgoliaSearch\Model\IndexSettings**](../Model/IndexSettings.md)|  |
 **forwardToReplicas** | **bool**| When true, changes are also propagated to replicas of the given indexName. | [optional]

### Return type

[**\Algolia\AlgoliaSearch\Model\UpdatedAtResponse**](../Model/UpdatedAtResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)

## `updateApiKey()`

```php
updateApiKey($key, $apiKey): \Algolia\AlgoliaSearch\Model\UpdateApiKeyResponse
```

Update an API key.

Replace every permission of an existing API key.

### Example

```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');


// Configure API key authorization: apiKey
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-API-Key', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-API-Key', 'Bearer');

// Configure API key authorization: appId
$config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKey('X-Algolia-Application-Id', 'YOUR_API_KEY');
// Uncomment below to setup prefix (e.g. Bearer) for API key, if needed
// $config = Algolia\AlgoliaSearch\Configuration::getDefaultConfiguration()->setApiKeyPrefix('X-Algolia-Application-Id', 'Bearer');


$apiInstance = new Algolia\AlgoliaSearch\Api\SearchApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client(),
    $config
);
$key = myAPIKey; // string | API Key string.
$apiKey = new \Algolia\AlgoliaSearch\Model\ApiKey(); // \Algolia\AlgoliaSearch\Model\ApiKey

try {
    $result = $apiInstance->updateApiKey($key, $apiKey);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling SearchApi->updateApiKey: ', $e->getMessage(), PHP_EOL;
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **key** | **string**| API Key string. |
 **apiKey** | [**\Algolia\AlgoliaSearch\Model\ApiKey**](../Model/ApiKey.md)|  |

### Return type

[**\Algolia\AlgoliaSearch\Model\UpdateApiKeyResponse**](../Model/UpdateApiKeyResponse.md)

### Authorization

[apiKey](../../README.md#apiKey), [appId](../../README.md#appId)

### HTTP request headers

- **Content-Type**: `application/json`
- **Accept**: `application/json`

[[Back to top]](#) [[Back to API list]](../../README.md#endpoints)
[[Back to Model list]](../../README.md#models)
[[Back to README]](../../README.md)
