<?php

namespace Algolia\AlgoliaSearch\Test\Api;

use Algolia\AlgoliaSearch\Api\SearchApi;
use Algolia\AlgoliaSearch\Configuration\SearchConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * SearchTest
 *
 * @category Class
 * @package  Algolia\AlgoliaSearch
 */
class SearchTest extends TestCase implements HttpClientInterface
{
    /**
     * @var RequestInterface[]
     */
    private $recordedRequests = [];

    protected function assertRequests(array $requests)
    {
        $this->assertGreaterThan(0, count($requests));
        $this->assertEquals(count($requests), count($this->recordedRequests));

        foreach ($requests as $i => $request) {
            $recordedRequest = $this->recordedRequests[$i];

            $this->assertEquals($request['method'], $recordedRequest->getMethod());
            $this->assertEquals($request['path'], $recordedRequest->getUri()->getPath());
            $this->assertEquals($request['body'], $recordedRequest->getBody()->getContents());
        }
    }

    public function sendRequest(RequestInterface $request, $timeout, $connectTimeout)
    {
        $this->recordedRequests[] = $request;

        return new Response(200, [], '{}');
    }

    protected function getClient()
    {
        $api = new ApiWrapper($this, SearchConfig::create(), ClusterHosts::create('127.0.0.1'));
        $config = SearchConfig::create('foo', 'bar');

        return new SearchApi($api, $config);
    }

    /**
     * Test case for addApiKey
     * AddApiKey
     */
    public function testAddApiKey0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"acl\":[\"search\",\"addObject\"],\"description\":\"my new api key\",\"validity\":300,\"maxQueriesPerIPPerHour\":100,\"maxHitsPerQuery\":20}", true);

        $client->addApiKey($params);

        $this->assertRequests([
            [
                "path" => "/1/keys",
                "method" => "POST",
                "body" => "{\"acl\":[\"search\",\"addObject\"],\"description\":\"my new api key\",\"validity\":300,\"maxQueriesPerIPPerHour\":100,\"maxHitsPerQuery\":20}",
            ],
        ]);
    }

    /**
     * Test case for addOrUpdateObject
     * AddOrUpdateObject
     */
    public function testAddOrUpdateObject0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\",\"objectID\":\"uniqueID\",\"body\":{\"key\":\"value\"}}", true);

        $client->addOrUpdateObject($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/uniqueID",
                "method" => "PUT",
                "body" => "{\"key\":\"value\"}",
            ],
        ]);
    }

    /**
     * Test case for appendSource
     * AppendSource
     */
    public function testAppendSource0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"source\":\"theSource\",\"description\":\"theDescription\"}", true);

        $client->appendSource($params);

        $this->assertRequests([
            [
                "path" => "/1/security/sources/append",
                "method" => "POST",
                "body" => "{\"source\":\"theSource\",\"description\":\"theDescription\"}",
            ],
        ]);
    }

    /**
     * Test case for assignUserId
     * AssignUserId
     */
    public function testAssignUserId0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"xAlgoliaUserID\":\"userID\",\"assignUserIdParams\":{\"cluster\":\"theCluster\"}}", true);

        $client->assignUserId($params);

        $this->assertRequests([
            [
                "path" => "/1/clusters/mapping",
                "method" => "POST",
                "body" => "{\"cluster\":\"theCluster\"}",
            ],
        ]);
    }

    /**
     * Test case for batch
     * Batch
     */
    public function testBatch0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"theIndexName\",\"batchWriteParams\":{\"requests\":[{\"action\":\"delete\",\"body\":{\"key\":\"value\"},\"indexName\":\"otherIndexName\"}]}}", true);

        $client->batch($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/theIndexName/batch",
                "method" => "POST",
                "body" => "{\"requests\":[{\"action\":\"delete\",\"body\":{\"key\":\"value\"},\"indexName\":\"otherIndexName\"}]}",
            ],
        ]);
    }

    /**
     * Test case for batchAssignUserIds
     * BatchAssignUserIds
     */
    public function testBatchAssignUserIds0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"xAlgoliaUserID\":\"userID\",\"batchAssignUserIdsParams\":{\"cluster\":\"theCluster\",\"users\":[\"user1\",\"user2\"]}}", true);

        $client->batchAssignUserIds($params);

        $this->assertRequests([
            [
                "path" => "/1/clusters/mapping/batch",
                "method" => "POST",
                "body" => "{\"cluster\":\"theCluster\",\"users\":[\"user1\",\"user2\"]}",
            ],
        ]);
    }

    /**
     * Test case for batchDictionaryEntries
     * Get batchDictionaryEntries results with minimal parameters
     */
    public function testBatchDictionaryEntries0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"dictionaryName\":\"compounds\",\"batchDictionaryEntriesParams\":{\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\"}},{\"action\":\"deleteEntry\",\"body\":{\"objectID\":\"2\",\"language\":\"fr\"}}]}}", true);

        $client->batchDictionaryEntries($params);

        $this->assertRequests([
            [
                "path" => "/1/dictionaries/compounds/batch",
                "method" => "POST",
                "body" => "{\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\"}},{\"action\":\"deleteEntry\",\"body\":{\"objectID\":\"2\",\"language\":\"fr\"}}]}",
            ],
        ]);
    }

    /**
     * Test case for batchDictionaryEntries
     * Get batchDictionaryEntries results with all parameters
     */
    public function testBatchDictionaryEntries1()
    {
        $client = $this->getClient();
        $params = json_decode("{\"dictionaryName\":\"compounds\",\"batchDictionaryEntriesParams\":{\"clearExistingDictionaryEntries\":false,\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\",\"word\":\"yo\",\"words\":[\"yo\",\"algolia\"],\"decomposition\":[\"yo\",\"algolia\"],\"state\":\"enabled\"}},{\"action\":\"deleteEntry\",\"body\":{\"objectID\":\"2\",\"language\":\"fr\",\"word\":\"salut\",\"words\":[\"salut\",\"algolia\"],\"decomposition\":[\"salut\",\"algolia\"],\"state\":\"enabled\"}}]}}", true);

        $client->batchDictionaryEntries($params);

        $this->assertRequests([
            [
                "path" => "/1/dictionaries/compounds/batch",
                "method" => "POST",
                "body" => "{\"clearExistingDictionaryEntries\":false,\"requests\":[{\"action\":\"addEntry\",\"body\":{\"objectID\":\"1\",\"language\":\"en\",\"word\":\"yo\",\"words\":[\"yo\",\"algolia\"],\"decomposition\":[\"yo\",\"algolia\"],\"state\":\"enabled\"}},{\"action\":\"deleteEntry\",\"body\":{\"objectID\":\"2\",\"language\":\"fr\",\"word\":\"salut\",\"words\":[\"salut\",\"algolia\"],\"decomposition\":[\"salut\",\"algolia\"],\"state\":\"enabled\"}}]}",
            ],
        ]);
    }

    /**
     * Test case for batchRules
     * BatchRules
     */
    public function testBatchRules0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\",\"rule\":[{\"objectID\":\"a-rule-id\",\"conditions\":[{\"pattern\":\"smartphone\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"filters\":\"category:smartphone\"}}},{\"objectID\":\"a-second-rule-id\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"filters\":\"brand:apple\"}}}],\"forwardToReplicas\":true,\"clearExistingRules\":true}", true);

        $client->batchRules($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/rules/batch",
                "method" => "POST",
                "body" => "[{\"objectID\":\"a-rule-id\",\"conditions\":[{\"pattern\":\"smartphone\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"filters\":\"category:smartphone\"}}},{\"objectID\":\"a-second-rule-id\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"filters\":\"brand:apple\"}}}]",
            ],
        ]);
    }

    /**
     * Test case for browse
     * Get browse results with minimal parameters
     */
    public function testBrowse0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\"}", true);

        $client->browse($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/browse",
                "method" => "POST",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for browse
     * Get browse results with all parameters
     */
    public function testBrowse1()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\",\"browseRequest\":{\"params\":\"query=foo&facetFilters=['bar']\",\"cursor\":\"cts\"}}", true);

        $client->browse($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/browse",
                "method" => "POST",
                "body" => "{\"params\":\"query=foo&facetFilters=['bar']\",\"cursor\":\"cts\"}",
            ],
        ]);
    }

    /**
     * Test case for clearAllSynonyms
     * ClearAllSynonyms
     */
    public function testClearAllSynonyms0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\"}", true);

        $client->clearAllSynonyms($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/synonyms/clear",
                "method" => "POST",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for clearObjects
     * ClearObjects
     */
    public function testClearObjects0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"theIndexName\"}", true);

        $client->clearObjects($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/theIndexName/clear",
                "method" => "POST",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for clearRules
     * ClearRules
     */
    public function testClearRules0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\"}", true);

        $client->clearRules($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/rules/clear",
                "method" => "POST",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for deleteApiKey
     * DeleteApiKey
     */
    public function testDeleteApiKey0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"key\":\"myTestApiKey\"}", true);

        $client->deleteApiKey($params);

        $this->assertRequests([
            [
                "path" => "/1/keys/myTestApiKey",
                "method" => "DELETE",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for deleteBy
     * DeleteBy
     */
    public function testDeleteBy0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"theIndexName\",\"searchParams\":{\"query\":\"testQuery\"}}", true);

        $client->deleteBy($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/theIndexName/deleteByQuery",
                "method" => "POST",
                "body" => "{\"query\":\"testQuery\"}",
            ],
        ]);
    }

    /**
     * Test case for deleteIndex
     * DeleteIndex
     */
    public function testDeleteIndex0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"theIndexName\"}", true);

        $client->deleteIndex($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/theIndexName",
                "method" => "DELETE",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for deleteObject
     * DeleteObject
     */
    public function testDeleteObject0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"theIndexName\",\"objectID\":\"uniqueID\"}", true);

        $client->deleteObject($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/theIndexName/uniqueID",
                "method" => "DELETE",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for deleteRule
     * DeleteRule
     */
    public function testDeleteRule0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\",\"objectID\":\"id1\"}", true);

        $client->deleteRule($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/rules/id1",
                "method" => "DELETE",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for deleteSource
     * DeleteSource
     */
    public function testDeleteSource0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"source\":\"theSource\"}", true);

        $client->deleteSource($params);

        $this->assertRequests([
            [
                "path" => "/1/security/sources/theSource",
                "method" => "DELETE",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for deleteSynonym
     * DeleteSynonym
     */
    public function testDeleteSynonym0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\",\"objectID\":\"id1\"}", true);

        $client->deleteSynonym($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/synonyms/id1",
                "method" => "DELETE",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for getApiKey
     * GetApiKey
     */
    public function testGetApiKey0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"key\":\"myTestApiKey\"}", true);

        $client->getApiKey($params);

        $this->assertRequests([
            [
                "path" => "/1/keys/myTestApiKey",
                "method" => "GET",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for getDictionaryLanguages
     * Get getDictionaryLanguages
     */
    public function testGetDictionaryLanguages0()
    {
        $client = $this->getClient();

        $client->getDictionaryLanguages();

        $this->assertRequests([
            [
                "path" => "/1/dictionaries/*/languages",
                "method" => "GET",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for getDictionarySettings
     * Get getDictionarySettings results
     */
    public function testGetDictionarySettings0()
    {
        $client = $this->getClient();

        $client->getDictionarySettings();

        $this->assertRequests([
            [
                "path" => "/1/dictionaries/*/settings",
                "method" => "GET",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for getLogs
     * GetLogs
     */
    public function testGetLogs0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"offset\":5,\"length\":10,\"indexName\":\"theIndexName\",\"type\":\"all\"}", true);

        $client->getLogs($params);

        $this->assertRequests([
            [
                "path" => "/1/logs",
                "method" => "GET",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for getObject
     * GetObject
     */
    public function testGetObject0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"theIndexName\",\"objectID\":\"uniqueID\",\"attributesToRetrieve\":[\"attr1\",\"attr2\"]}", true);

        $client->getObject($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/theIndexName/uniqueID",
                "method" => "GET",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for getObjects
     * GetObjects
     */
    public function testGetObjects0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"requests\":[{\"attributesToRetrieve\":[\"attr1\",\"attr2\"],\"objectID\":\"uniqueID\",\"indexName\":\"theIndexName\"}]}", true);

        $client->getObjects($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/*/objects",
                "method" => "POST",
                "body" => "{\"requests\":[{\"attributesToRetrieve\":[\"attr1\",\"attr2\"],\"objectID\":\"uniqueID\",\"indexName\":\"theIndexName\"}]}",
            ],
        ]);
    }

    /**
     * Test case for getRule
     * GetRule
     */
    public function testGetRule0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\",\"objectID\":\"id1\"}", true);

        $client->getRule($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/rules/id1",
                "method" => "GET",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for getSettings
     * GetSettings
     */
    public function testGetSettings0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"theIndexName\"}", true);

        $client->getSettings($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/theIndexName/settings",
                "method" => "GET",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for getSources
     * GetSources
     */
    public function testGetSources0()
    {
        $client = $this->getClient();

        $client->getSources();

        $this->assertRequests([
            [
                "path" => "/1/security/sources",
                "method" => "GET",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for getSynonym
     * GetSynonym
     */
    public function testGetSynonym0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\",\"objectID\":\"id1\"}", true);

        $client->getSynonym($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/synonyms/id1",
                "method" => "GET",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for getTask
     * GetTask
     */
    public function testGetTask0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"theIndexName\",\"taskID\":123}", true);

        $client->getTask($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/theIndexName/task/123",
                "method" => "GET",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for getTopUserIds
     * GetTopUserIds
     */
    public function testGetTopUserIds0()
    {
        $client = $this->getClient();

        $client->getTopUserIds();

        $this->assertRequests([
            [
                "path" => "/1/clusters/mapping/top",
                "method" => "GET",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for getUserId
     * GetUserId
     */
    public function testGetUserId0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"userID\":\"uniqueID\"}", true);

        $client->getUserId($params);

        $this->assertRequests([
            [
                "path" => "/1/clusters/mapping/uniqueID",
                "method" => "GET",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for hasPendingMappings
     * HasPendingMappings
     */
    public function testHasPendingMappings0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"getClusters\":true}", true);

        $client->hasPendingMappings($params);

        $this->assertRequests([
            [
                "path" => "/1/clusters/mapping/pending",
                "method" => "GET",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for listApiKeys
     * ListApiKeys
     */
    public function testListApiKeys0()
    {
        $client = $this->getClient();

        $client->listApiKeys();

        $this->assertRequests([
            [
                "path" => "/1/keys",
                "method" => "GET",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for listClusters
     * ListClusters
     */
    public function testListClusters0()
    {
        $client = $this->getClient();

        $client->listClusters();

        $this->assertRequests([
            [
                "path" => "/1/clusters",
                "method" => "GET",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for listIndices
     * ListIndices
     */
    public function testListIndices0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"page\":8}", true);

        $client->listIndices($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes",
                "method" => "GET",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for listUserIds
     * ListUserIds
     */
    public function testListUserIds0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"page\":8,\"hitsPerPage\":100}", true);

        $client->listUserIds($params);

        $this->assertRequests([
            [
                "path" => "/1/clusters/mapping",
                "method" => "GET",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for multipleBatch
     * MultipleBatch
     */
    public function testMultipleBatch0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"requests\":[{\"action\":\"addObject\",\"body\":{\"key\":\"value\"},\"indexName\":\"theIndexName\"}]}", true);

        $client->multipleBatch($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/*/batch",
                "method" => "POST",
                "body" => "{\"requests\":[{\"action\":\"addObject\",\"body\":{\"key\":\"value\"},\"indexName\":\"theIndexName\"}]}",
            ],
        ]);
    }

    /**
     * Test case for multipleQueries
     * MultipleQueries
     */
    public function testMultipleQueries0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"requests\":[{\"indexName\":\"theIndexName\",\"query\":\"test\",\"type\":\"facet\",\"facet\":\"theFacet\",\"params\":\"testParam\"}],\"strategy\":\"stopIfEnoughMatches\"}", true);

        $client->multipleQueries($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/*/queries",
                "method" => "POST",
                "body" => "{\"requests\":[{\"indexName\":\"theIndexName\",\"query\":\"test\",\"type\":\"facet\",\"facet\":\"theFacet\",\"params\":\"testParam\"}],\"strategy\":\"stopIfEnoughMatches\"}",
            ],
        ]);
    }

    /**
     * Test case for operationIndex
     * OperationIndex
     */
    public function testOperationIndex0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"theIndexName\",\"operationIndexParams\":{\"operation\":\"copy\",\"destination\":\"dest\",\"scope\":[\"rules\",\"settings\"]}}", true);

        $client->operationIndex($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/theIndexName/operation",
                "method" => "POST",
                "body" => "{\"operation\":\"copy\",\"destination\":\"dest\",\"scope\":[\"rules\",\"settings\"]}",
            ],
        ]);
    }

    /**
     * Test case for partialUpdateObject
     * PartialUpdateObject
     */
    public function testPartialUpdateObject0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"theIndexName\",\"objectID\":\"uniqueID\",\"stringBuiltInOperation\":[{\"id1\":\"test\",\"id2\":{\"_operation\":\"AddUnique\",\"value\":\"test2\"}}],\"createIfNotExists\":true}", true);

        $client->partialUpdateObject($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/theIndexName/uniqueID/partial",
                "method" => "POST",
                "body" => "[{\"id1\":\"test\",\"id2\":{\"_operation\":\"AddUnique\",\"value\":\"test2\"}}]",
            ],
        ]);
    }

    /**
     * Test case for removeUserId
     * RemoveUserId
     */
    public function testRemoveUserId0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"userID\":\"uniqueID\"}", true);

        $client->removeUserId($params);

        $this->assertRequests([
            [
                "path" => "/1/clusters/mapping/uniqueID",
                "method" => "DELETE",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for replaceSources
     * ReplaceSources
     */
    public function testReplaceSources0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"source\":[{\"source\":\"theSource\",\"description\":\"theDescription\"}]}", true);

        $client->replaceSources($params);

        $this->assertRequests([
            [
                "path" => "/1/security/sources",
                "method" => "PUT",
                "body" => "[{\"source\":\"theSource\",\"description\":\"theDescription\"}]",
            ],
        ]);
    }

    /**
     * Test case for restoreApiKey
     * RestoreApiKey
     */
    public function testRestoreApiKey0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"key\":\"myApiKey\"}", true);

        $client->restoreApiKey($params);

        $this->assertRequests([
            [
                "path" => "/1/keys/myApiKey/restore",
                "method" => "POST",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for saveObject
     * SaveObject
     */
    public function testSaveObject0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"theIndexName\",\"body\":{\"objectID\":\"id\",\"test\":\"val\"}}", true);

        $client->saveObject($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/theIndexName",
                "method" => "POST",
                "body" => "{\"objectID\":\"id\",\"test\":\"val\"}",
            ],
        ]);
    }

    /**
     * Test case for saveRule
     * SaveRule
     */
    public function testSaveRule0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\",\"objectID\":\"id1\",\"rule\":{\"objectID\":\"id1\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"filters\":\"brand:apple\"}}},\"forwardToReplicas\":true}", true);

        $client->saveRule($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/rules/id1",
                "method" => "PUT",
                "body" => "{\"objectID\":\"id1\",\"conditions\":[{\"pattern\":\"apple\",\"anchoring\":\"contains\"}],\"consequence\":{\"params\":{\"filters\":\"brand:apple\"}}}",
            ],
        ]);
    }

    /**
     * Test case for saveSynonym
     * SaveSynonym
     */
    public function testSaveSynonym0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\",\"objectID\":\"id1\",\"synonymHit\":{\"objectID\":\"id1\",\"type\":\"synonym\",\"synonyms\":[\"car\",\"vehicule\",\"auto\"]},\"forwardToReplicas\":true}", true);

        $client->saveSynonym($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/synonyms/id1",
                "method" => "PUT",
                "body" => "{\"objectID\":\"id1\",\"type\":\"synonym\",\"synonyms\":[\"car\",\"vehicule\",\"auto\"]}",
            ],
        ]);
    }

    /**
     * Test case for saveSynonyms
     * SaveSynonyms
     */
    public function testSaveSynonyms0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\",\"synonymHit\":[{\"objectID\":\"id1\",\"type\":\"synonym\",\"synonyms\":[\"car\",\"vehicule\",\"auto\"]},{\"objectID\":\"id2\",\"type\":\"onewaysynonym\",\"input\":\"iphone\",\"synonyms\":[\"ephone\",\"aphone\",\"yphone\"]}],\"forwardToReplicas\":true,\"replaceExistingSynonyms\":false}", true);

        $client->saveSynonyms($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/synonyms/batch",
                "method" => "POST",
                "body" => "[{\"objectID\":\"id1\",\"type\":\"synonym\",\"synonyms\":[\"car\",\"vehicule\",\"auto\"]},{\"objectID\":\"id2\",\"type\":\"onewaysynonym\",\"input\":\"iphone\",\"synonyms\":[\"ephone\",\"aphone\",\"yphone\"]}]",
            ],
        ]);
    }

    /**
     * Test case for search
     * Search
     */
    public function testSearch0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\",\"searchParams\":{\"query\":\"myQuery\"}}", true);

        $client->search($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/query",
                "method" => "POST",
                "body" => "{\"query\":\"myQuery\"}",
            ],
        ]);
    }

    /**
     * Test case for searchDictionaryEntries
     * Get searchDictionaryEntries results with minimal parameters
     */
    public function testSearchDictionaryEntries0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"dictionaryName\":\"compounds\",\"searchDictionaryEntriesParams\":{\"query\":\"foo\"}}", true);

        $client->searchDictionaryEntries($params);

        $this->assertRequests([
            [
                "path" => "/1/dictionaries/compounds/search",
                "method" => "POST",
                "body" => "{\"query\":\"foo\"}",
            ],
        ]);
    }

    /**
     * Test case for searchDictionaryEntries
     * Get searchDictionaryEntries results with all parameters
     */
    public function testSearchDictionaryEntries1()
    {
        $client = $this->getClient();
        $params = json_decode("{\"dictionaryName\":\"compounds\",\"searchDictionaryEntriesParams\":{\"query\":\"foo\",\"page\":4,\"hitsPerPage\":2,\"language\":\"fr\"}}", true);

        $client->searchDictionaryEntries($params);

        $this->assertRequests([
            [
                "path" => "/1/dictionaries/compounds/search",
                "method" => "POST",
                "body" => "{\"query\":\"foo\",\"page\":4,\"hitsPerPage\":2,\"language\":\"fr\"}",
            ],
        ]);
    }

    /**
     * Test case for searchForFacetValues
     * Get searchForFacetValues results with minimal parameters
     */
    public function testSearchForFacetValues0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\",\"facetName\":\"facetName\"}", true);

        $client->searchForFacetValues($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/facets/facetName/query",
                "method" => "POST",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for searchForFacetValues
     * Get searchForFacetValues results with all parameters
     */
    public function testSearchForFacetValues1()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\",\"facetName\":\"facetName\",\"searchForFacetValuesRequest\":{\"params\":\"query=foo&facetFilters=['bar']\",\"facetQuery\":\"foo\",\"maxFacetHits\":42}}", true);

        $client->searchForFacetValues($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/facets/facetName/query",
                "method" => "POST",
                "body" => "{\"params\":\"query=foo&facetFilters=['bar']\",\"facetQuery\":\"foo\",\"maxFacetHits\":42}",
            ],
        ]);
    }

    /**
     * Test case for searchRules
     * SearchRules
     */
    public function testSearchRules0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\",\"searchRulesParams\":{\"query\":\"something\"}}", true);

        $client->searchRules($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/rules/search",
                "method" => "POST",
                "body" => "{\"query\":\"something\"}",
            ],
        ]);
    }

    /**
     * Test case for searchSynonyms
     * SearchSynonyms
     */
    public function testSearchSynonyms0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"indexName\"}", true);

        $client->searchSynonyms($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/indexName/synonyms/search",
                "method" => "POST",
                "body" => "",
            ],
        ]);
    }

    /**
     * Test case for searchUserIds
     * SearchUserIds
     */
    public function testSearchUserIds0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"query\":\"test\",\"clusterName\":\"theClusterName\",\"page\":5,\"hitsPerPage\":10}", true);

        $client->searchUserIds($params);

        $this->assertRequests([
            [
                "path" => "/1/clusters/mapping/search",
                "method" => "POST",
                "body" => "{\"query\":\"test\",\"clusterName\":\"theClusterName\",\"page\":5,\"hitsPerPage\":10}",
            ],
        ]);
    }

    /**
     * Test case for setDictionarySettings
     * Get setDictionarySettings results with minimal parameters
     */
    public function testSetDictionarySettings0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"disableStandardEntries\":{\"plurals\":{\"fr\":false,\"en\":false,\"ru\":true}}}", true);

        $client->setDictionarySettings($params);

        $this->assertRequests([
            [
                "path" => "/1/dictionaries/*/settings",
                "method" => "PUT",
                "body" => "{\"disableStandardEntries\":{\"plurals\":{\"fr\":false,\"en\":false,\"ru\":true}}}",
            ],
        ]);
    }

    /**
     * Test case for setDictionarySettings
     * Get setDictionarySettings results with all parameters
     */
    public function testSetDictionarySettings1()
    {
        $client = $this->getClient();
        $params = json_decode("{\"disableStandardEntries\":{\"plurals\":{\"fr\":false,\"en\":false,\"ru\":true},\"stopwords\":{\"fr\":false},\"compounds\":{\"ru\":true}}}", true);

        $client->setDictionarySettings($params);

        $this->assertRequests([
            [
                "path" => "/1/dictionaries/*/settings",
                "method" => "PUT",
                "body" => "{\"disableStandardEntries\":{\"plurals\":{\"fr\":false,\"en\":false,\"ru\":true},\"stopwords\":{\"fr\":false},\"compounds\":{\"ru\":true}}}",
            ],
        ]);
    }

    /**
     * Test case for setSettings
     * SetSettings
     */
    public function testSetSettings0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"indexName\":\"theIndexName\",\"indexSettings\":{\"paginationLimitedTo\":10},\"forwardToReplicas\":true}", true);

        $client->setSettings($params);

        $this->assertRequests([
            [
                "path" => "/1/indexes/theIndexName/settings",
                "method" => "PUT",
                "body" => "{\"paginationLimitedTo\":10}",
            ],
        ]);
    }

    /**
     * Test case for updateApiKey
     * UpdateApiKey
     */
    public function testUpdateApiKey0()
    {
        $client = $this->getClient();
        $params = json_decode("{\"key\":\"myApiKey\",\"apiKey\":{\"acl\":[\"search\",\"addObject\"],\"validity\":300,\"maxQueriesPerIPPerHour\":100,\"maxHitsPerQuery\":20}}", true);

        $client->updateApiKey($params);

        $this->assertRequests([
            [
                "path" => "/1/keys/myApiKey",
                "method" => "PUT",
                "body" => "{\"acl\":[\"search\",\"addObject\"],\"validity\":300,\"maxQueriesPerIPPerHour\":100,\"maxHitsPerQuery\":20}",
            ],
        ]);
    }
}
