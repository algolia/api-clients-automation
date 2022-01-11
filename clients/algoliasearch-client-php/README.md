# OpenAPIClient-php

API powering the Search feature of Algolia.


## Installation & Usage

### Requirements

PHP 7.3 and later.
Should also work with PHP 8.0 but has not been tested.

### Composer

To install the bindings via [Composer](https://getcomposer.org/), add the following to `composer.json`:

```json
{
  "repositories": [
    {
      "type": "vcs",
      "url": "https://algolia/algolia/algoliasearch-client-php.git"
    }
  ],
  "require": {
    "algolia/algoliasearch-client-php": "*@dev"
  }
}
```

Then run `composer install`

### Manual Installation

Download the files and include `autoload.php`:

```php
<?php
require_once('/path/to/OpenAPIClient-php/vendor/autoload.php');
```

## Getting Started

Please follow the [installation procedure](#installation--usage) and then run the following:

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

## API Endpoints

All URIs are relative to *http://localhost*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*SearchApi* | [**addApiKey**](docs/Api/SearchApi.md#addapikey) | **POST** /1/keys | Create a new API key.
*SearchApi* | [**addOrUpdateObject**](docs/Api/SearchApi.md#addorupdateobject) | **PUT** /1/indexes/{indexName}/{objectID} | Add or replace an object with a given object ID.
*SearchApi* | [**appendSource**](docs/Api/SearchApi.md#appendsource) | **POST** /1/security/sources/append | 
*SearchApi* | [**assignUserId**](docs/Api/SearchApi.md#assignuserid) | **POST** /1/clusters/mapping | Assign or Move userID
*SearchApi* | [**batch**](docs/Api/SearchApi.md#batch) | **POST** /1/indexes/{indexName}/batch | 
*SearchApi* | [**batchAssignUserIds**](docs/Api/SearchApi.md#batchassignuserids) | **POST** /1/clusters/mapping/batch | Batch assign userIDs
*SearchApi* | [**batchDictionaryEntries**](docs/Api/SearchApi.md#batchdictionaryentries) | **POST** /1/dictionaries/{dictionaryName}/batch | Send a batch of dictionary entries.
*SearchApi* | [**batchRules**](docs/Api/SearchApi.md#batchrules) | **POST** /1/indexes/{indexName}/rules/batch | Batch Rules.
*SearchApi* | [**browse**](docs/Api/SearchApi.md#browse) | **POST** /1/indexes/{indexName}/browse | Retrieve all index content.
*SearchApi* | [**clearAllSynonyms**](docs/Api/SearchApi.md#clearallsynonyms) | **POST** /1/indexes/{indexName}/synonyms/clear | Clear all synonyms.
*SearchApi* | [**clearObjects**](docs/Api/SearchApi.md#clearobjects) | **POST** /1/indexes/{indexName}/clear | clear all objects from an index.
*SearchApi* | [**clearRules**](docs/Api/SearchApi.md#clearrules) | **POST** /1/indexes/{indexName}/rules/clear | Clear Rules.
*SearchApi* | [**deleteApiKey**](docs/Api/SearchApi.md#deleteapikey) | **DELETE** /1/keys/{key} | Delete an API key.
*SearchApi* | [**deleteBy**](docs/Api/SearchApi.md#deleteby) | **POST** /1/indexes/{indexName}/deleteByQuery | Delete all records matching the query.
*SearchApi* | [**deleteIndex**](docs/Api/SearchApi.md#deleteindex) | **DELETE** /1/indexes/{indexName} | Delete index.
*SearchApi* | [**deleteObject**](docs/Api/SearchApi.md#deleteobject) | **DELETE** /1/indexes/{indexName}/{objectID} | Delete object.
*SearchApi* | [**deleteRule**](docs/Api/SearchApi.md#deleterule) | **DELETE** /1/indexes/{indexName}/rules/{objectID} | Delete a rule.
*SearchApi* | [**deleteSource**](docs/Api/SearchApi.md#deletesource) | **DELETE** /1/security/sources/{source} | 
*SearchApi* | [**deleteSynonym**](docs/Api/SearchApi.md#deletesynonym) | **DELETE** /1/indexes/{indexName}/synonyms/{objectID} | Delete synonym.
*SearchApi* | [**getApiKey**](docs/Api/SearchApi.md#getapikey) | **GET** /1/keys/{key} | Get an API key.
*SearchApi* | [**getDictionaryLanguages**](docs/Api/SearchApi.md#getdictionarylanguages) | **GET** /1/dictionaries/*/languages | List dictionaries supported per language.
*SearchApi* | [**getDictionarySettings**](docs/Api/SearchApi.md#getdictionarysettings) | **GET** /1/dictionaries/*/settings | Retrieve dictionaries settings. The API stores languages whose standard entries are disabled. Fetch settings does not return false values.
*SearchApi* | [**getLogs**](docs/Api/SearchApi.md#getlogs) | **GET** /1/logs | 
*SearchApi* | [**getObject**](docs/Api/SearchApi.md#getobject) | **GET** /1/indexes/{indexName}/{objectID} | Retrieve one object from the index.
*SearchApi* | [**getObjects**](docs/Api/SearchApi.md#getobjects) | **POST** /1/indexes/*/objects | Retrieve one or more objects.
*SearchApi* | [**getRule**](docs/Api/SearchApi.md#getrule) | **GET** /1/indexes/{indexName}/rules/{objectID} | Get a rule.
*SearchApi* | [**getSettings**](docs/Api/SearchApi.md#getsettings) | **GET** /1/indexes/{indexName}/settings | 
*SearchApi* | [**getSources**](docs/Api/SearchApi.md#getsources) | **GET** /1/security/sources | 
*SearchApi* | [**getSynonym**](docs/Api/SearchApi.md#getsynonym) | **GET** /1/indexes/{indexName}/synonyms/{objectID} | Get synonym.
*SearchApi* | [**getTask**](docs/Api/SearchApi.md#gettask) | **GET** /1/indexes/{indexName}/task/{taskID} | 
*SearchApi* | [**getTopUserIds**](docs/Api/SearchApi.md#gettopuserids) | **GET** /1/clusters/mapping/top | Get top userID
*SearchApi* | [**getUserId**](docs/Api/SearchApi.md#getuserid) | **GET** /1/clusters/mapping/{userID} | Get userID
*SearchApi* | [**hasPendingMappings**](docs/Api/SearchApi.md#haspendingmappings) | **GET** /1/clusters/mapping/pending | Has pending mappings
*SearchApi* | [**listApiKeys**](docs/Api/SearchApi.md#listapikeys) | **GET** /1/keys | Get the full list of API Keys.
*SearchApi* | [**listClusters**](docs/Api/SearchApi.md#listclusters) | **GET** /1/clusters | List clusters
*SearchApi* | [**listIndices**](docs/Api/SearchApi.md#listindices) | **GET** /1/indexes | List existing indexes.
*SearchApi* | [**listUserIds**](docs/Api/SearchApi.md#listuserids) | **GET** /1/clusters/mapping | List userIDs
*SearchApi* | [**multipleBatch**](docs/Api/SearchApi.md#multiplebatch) | **POST** /1/indexes/*/batch | 
*SearchApi* | [**multipleQueries**](docs/Api/SearchApi.md#multiplequeries) | **POST** /1/indexes/*/queries | 
*SearchApi* | [**operationIndex**](docs/Api/SearchApi.md#operationindex) | **POST** /1/indexes/{indexName}/operation | Copy/move index.
*SearchApi* | [**partialUpdateObject**](docs/Api/SearchApi.md#partialupdateobject) | **POST** /1/indexes/{indexName}/{objectID}/partial | Partially update an object.
*SearchApi* | [**removeUserId**](docs/Api/SearchApi.md#removeuserid) | **DELETE** /1/clusters/mapping/{userID} | Remove userID
*SearchApi* | [**replaceSources**](docs/Api/SearchApi.md#replacesources) | **PUT** /1/security/sources | 
*SearchApi* | [**restoreApiKey**](docs/Api/SearchApi.md#restoreapikey) | **POST** /1/keys/{key}/restore | Restore an API key.
*SearchApi* | [**saveObject**](docs/Api/SearchApi.md#saveobject) | **POST** /1/indexes/{indexName} | 
*SearchApi* | [**saveRule**](docs/Api/SearchApi.md#saverule) | **PUT** /1/indexes/{indexName}/rules/{objectID} | Save/Update a rule.
*SearchApi* | [**saveSynonym**](docs/Api/SearchApi.md#savesynonym) | **PUT** /1/indexes/{indexName}/synonyms/{objectID} | Save synonym.
*SearchApi* | [**saveSynonyms**](docs/Api/SearchApi.md#savesynonyms) | **POST** /1/indexes/{indexName}/synonyms/batch | Save a batch of synonyms.
*SearchApi* | [**search**](docs/Api/SearchApi.md#search) | **POST** /1/indexes/{indexName}/query | 
*SearchApi* | [**searchDictionaryEntries**](docs/Api/SearchApi.md#searchdictionaryentries) | **POST** /1/dictionaries/{dictionaryName}/search | Search the dictionary entries.
*SearchApi* | [**searchForFacetValues**](docs/Api/SearchApi.md#searchforfacetvalues) | **POST** /1/indexes/{indexName}/facets/{facetName}/query | Search for values of a given facet
*SearchApi* | [**searchRules**](docs/Api/SearchApi.md#searchrules) | **POST** /1/indexes/{indexName}/rules/search | Search for rules.
*SearchApi* | [**searchSynonyms**](docs/Api/SearchApi.md#searchsynonyms) | **POST** /1/indexes/{indexName}/synonyms/search | Get all synonyms that match a query.
*SearchApi* | [**searchUserIds**](docs/Api/SearchApi.md#searchuserids) | **POST** /1/clusters/mapping/search | Search userID
*SearchApi* | [**setDictionarySettings**](docs/Api/SearchApi.md#setdictionarysettings) | **PUT** /1/dictionaries/*/settings | Set dictionary settings.
*SearchApi* | [**setSettings**](docs/Api/SearchApi.md#setsettings) | **PUT** /1/indexes/{indexName}/settings | 
*SearchApi* | [**updateApiKey**](docs/Api/SearchApi.md#updateapikey) | **PUT** /1/keys/{key} | Update an API key.

## Models

- [Action](docs/Model/Action.md)
- [AddApiKeyResponse](docs/Model/AddApiKeyResponse.md)
- [Anchoring](docs/Model/Anchoring.md)
- [ApiKey](docs/Model/ApiKey.md)
- [AssignUserIdObject](docs/Model/AssignUserIdObject.md)
- [AutomaticFacetFilter](docs/Model/AutomaticFacetFilter.md)
- [BaseBrowseResponse](docs/Model/BaseBrowseResponse.md)
- [BaseIndexSettings](docs/Model/BaseIndexSettings.md)
- [BaseSearchParams](docs/Model/BaseSearchParams.md)
- [BaseSearchResponse](docs/Model/BaseSearchResponse.md)
- [BaseSearchResponseFacetsStats](docs/Model/BaseSearchResponseFacetsStats.md)
- [BatchAssignUserIdsObject](docs/Model/BatchAssignUserIdsObject.md)
- [BatchDictionaryEntries](docs/Model/BatchDictionaryEntries.md)
- [BatchDictionaryEntriesRequest](docs/Model/BatchDictionaryEntriesRequest.md)
- [BatchObject](docs/Model/BatchObject.md)
- [BatchResponse](docs/Model/BatchResponse.md)
- [BatchWriteObject](docs/Model/BatchWriteObject.md)
- [BrowseRequest](docs/Model/BrowseRequest.md)
- [BrowseResponse](docs/Model/BrowseResponse.md)
- [BuildInOperation](docs/Model/BuildInOperation.md)
- [Condition](docs/Model/Condition.md)
- [Consequence](docs/Model/Consequence.md)
- [ConsequenceHide](docs/Model/ConsequenceHide.md)
- [ConsequenceParams](docs/Model/ConsequenceParams.md)
- [CreatedAtObject](docs/Model/CreatedAtObject.md)
- [CreatedAtResponse](docs/Model/CreatedAtResponse.md)
- [DeleteApiKeyResponse](docs/Model/DeleteApiKeyResponse.md)
- [DeleteSourceResponse](docs/Model/DeleteSourceResponse.md)
- [DeletedAtResponse](docs/Model/DeletedAtResponse.md)
- [DictionaryEntry](docs/Model/DictionaryEntry.md)
- [DictionaryLanguage](docs/Model/DictionaryLanguage.md)
- [DictionarySettingsRequest](docs/Model/DictionarySettingsRequest.md)
- [ErrorBase](docs/Model/ErrorBase.md)
- [GetDictionarySettingsResponse](docs/Model/GetDictionarySettingsResponse.md)
- [GetLogsResponse](docs/Model/GetLogsResponse.md)
- [GetLogsResponseInnerQueries](docs/Model/GetLogsResponseInnerQueries.md)
- [GetLogsResponseLogs](docs/Model/GetLogsResponseLogs.md)
- [GetObjectsObject](docs/Model/GetObjectsObject.md)
- [GetObjectsResponse](docs/Model/GetObjectsResponse.md)
- [GetTaskResponse](docs/Model/GetTaskResponse.md)
- [GetTopUserIdsResponse](docs/Model/GetTopUserIdsResponse.md)
- [HighlightResult](docs/Model/HighlightResult.md)
- [Index](docs/Model/Index.md)
- [IndexSettings](docs/Model/IndexSettings.md)
- [IndexSettingsAsSearchParams](docs/Model/IndexSettingsAsSearchParams.md)
- [KeyObject](docs/Model/KeyObject.md)
- [Languages](docs/Model/Languages.md)
- [ListApiKeysResponse](docs/Model/ListApiKeysResponse.md)
- [ListClustersResponse](docs/Model/ListClustersResponse.md)
- [ListIndicesResponse](docs/Model/ListIndicesResponse.md)
- [ListUserIdsResponse](docs/Model/ListUserIdsResponse.md)
- [MultipleBatchResponse](docs/Model/MultipleBatchResponse.md)
- [MultipleGetObjectsObject](docs/Model/MultipleGetObjectsObject.md)
- [MultipleQueries](docs/Model/MultipleQueries.md)
- [MultipleQueriesObject](docs/Model/MultipleQueriesObject.md)
- [MultipleQueriesResponse](docs/Model/MultipleQueriesResponse.md)
- [Operation](docs/Model/Operation.md)
- [OperationIndexObject](docs/Model/OperationIndexObject.md)
- [Params](docs/Model/Params.md)
- [Promote](docs/Model/Promote.md)
- [RankingInfo](docs/Model/RankingInfo.md)
- [RankingInfoMatchedGeoLocation](docs/Model/RankingInfoMatchedGeoLocation.md)
- [Record](docs/Model/Record.md)
- [RemoveUserIdResponse](docs/Model/RemoveUserIdResponse.md)
- [ReplaceSourceResponse](docs/Model/ReplaceSourceResponse.md)
- [RequiredSearchParams](docs/Model/RequiredSearchParams.md)
- [Rule](docs/Model/Rule.md)
- [SaveObjectResponse](docs/Model/SaveObjectResponse.md)
- [SaveSynonymResponse](docs/Model/SaveSynonymResponse.md)
- [SearchDictionaryEntries](docs/Model/SearchDictionaryEntries.md)
- [SearchForFacetValuesRequest](docs/Model/SearchForFacetValuesRequest.md)
- [SearchForFacetValuesResponse](docs/Model/SearchForFacetValuesResponse.md)
- [SearchForFacetValuesResponseFacetHits](docs/Model/SearchForFacetValuesResponseFacetHits.md)
- [SearchHits](docs/Model/SearchHits.md)
- [SearchParams](docs/Model/SearchParams.md)
- [SearchParamsObject](docs/Model/SearchParamsObject.md)
- [SearchParamsString](docs/Model/SearchParamsString.md)
- [SearchResponse](docs/Model/SearchResponse.md)
- [SearchRulesParams](docs/Model/SearchRulesParams.md)
- [SearchRulesResponse](docs/Model/SearchRulesResponse.md)
- [SearchSynonymsResponse](docs/Model/SearchSynonymsResponse.md)
- [SearchUserIdsObject](docs/Model/SearchUserIdsObject.md)
- [SearchUserIdsResponse](docs/Model/SearchUserIdsResponse.md)
- [SearchUserIdsResponseHighlightResult](docs/Model/SearchUserIdsResponseHighlightResult.md)
- [SearchUserIdsResponseHits](docs/Model/SearchUserIdsResponseHits.md)
- [SnippetResult](docs/Model/SnippetResult.md)
- [Source](docs/Model/Source.md)
- [StandardEntries](docs/Model/StandardEntries.md)
- [SynonymHit](docs/Model/SynonymHit.md)
- [SynonymHitHighlightResult](docs/Model/SynonymHitHighlightResult.md)
- [TimeRange](docs/Model/TimeRange.md)
- [UpdateApiKeyResponse](docs/Model/UpdateApiKeyResponse.md)
- [UpdatedAtResponse](docs/Model/UpdatedAtResponse.md)
- [UpdatedAtWithObjectIdResponse](docs/Model/UpdatedAtWithObjectIdResponse.md)
- [UpdatedRuleResponse](docs/Model/UpdatedRuleResponse.md)
- [UserId](docs/Model/UserId.md)

## Authorization

### apiKey

- **Type**: API key
- **API key parameter name**: X-Algolia-API-Key
- **Location**: HTTP header



### appId

- **Type**: API key
- **API key parameter name**: X-Algolia-Application-Id
- **Location**: HTTP header


## Tests

To run the tests, use:

```bash
composer install
vendor/bin/phpunit
```

## Author



## About this package

This PHP package is automatically generated by the [OpenAPI Generator](https://openapi-generator.tech) project:

- API version: `0.1.0`
- Build package: `org.openapitools.codegen.languages.PhpClientCodegen`
