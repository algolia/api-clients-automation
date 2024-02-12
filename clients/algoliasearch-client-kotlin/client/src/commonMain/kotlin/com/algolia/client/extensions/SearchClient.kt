package com.algolia.client.extensions

import com.algolia.client.api.SearchClient
import com.algolia.client.model.search.*
import com.algolia.client.transport.RequestOptions
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.jsonObject
import kotlin.random.Random

/**
 * Calls the `search` method but with certainty that we will only request Algolia records (hits).
 */
public suspend fun SearchClient.searchForHits(
    requests: List<SearchForHits>,
    strategy: SearchStrategy? = null,
    requestOptions: RequestOptions? = null,
): List<SearchResponse> {
    val request = SearchMethodParams(requests = requests, strategy = strategy)
    return search(searchMethodParams = request, requestOptions = requestOptions).results.map { it as SearchResponse }
}

/**
 * Calls the `search` method but with certainty that we will only request Algolia facets.
 */
public suspend fun SearchClient.searchForFacets(
    requests: List<SearchForFacets>,
    strategy: SearchStrategy? = null,
    requestOptions: RequestOptions? = null,
): List<SearchForFacetValuesResponse> {
    val request = SearchMethodParams(requests = requests, strategy = strategy)
    return search(
        searchMethodParams = request,
        requestOptions = requestOptions,
    ).results.map { it as SearchForFacetValuesResponse }
}

/**
 * Push a new set of objects and remove all previous ones. Settings, synonyms and query rules are untouched.
 * Replace all objects in an index without any downtime.
 * Internally, this method copies the existing index settings, synonyms and query rules and indexes all
 * passed objects. Finally, the temporary one replaces the existing index.
 *
 * @param serializer [KSerializer] of type [T] for serialization.
 * @param records The list of records to replace.
 * @return intermediate operations (index name to task ID).
 */
public suspend fun <T> SearchClient.replaceAllObjects(
    indexName: String,
    serializer: KSerializer<T>,
    records: List<T>,
    requestOptions: RequestOptions?,
): Map<String, Long> {
    if (records.isEmpty()) return emptyMap()

    val requests = records.map { record ->
        val body = options.json.encodeToJsonElement(serializer, record).jsonObject
        BatchRequest(action = Action.AddObject, body = body)
    }
    val destinationIndex = "${indexName}_tmp_${Random.nextInt(from = 0, until = 100)}"

    // 1. Copy index resources
    val copy = operationIndex(
        indexName = indexName,
        operationIndexParams = OperationIndexParams(
            operation = OperationType.Copy,
            destination = destinationIndex,
            scope = listOf(ScopeType.Settings, ScopeType.Rules, ScopeType.Synonyms)
        ),
        requestOptions = requestOptions
    )
    waitTask(indexName = indexName, taskID = copy.taskID)

    // 2. Save new objects
    val batch = batch(
        indexName = destinationIndex,
        batchWriteParams = BatchWriteParams(requests),
        requestOptions = requestOptions,
    )
    waitTask(indexName = destinationIndex, taskID = batch.taskID)

    // 3.  Move temporary index to source index
    val move = operationIndex(
        indexName = destinationIndex,
        operationIndexParams = OperationIndexParams(operation = OperationType.Move, destination = indexName),
        requestOptions = requestOptions,
    )
    waitTask(indexName = destinationIndex, taskID = move.taskID)

    // 4. Return the list of operations
    return mapOf(
        indexName to copy.taskID,
        destinationIndex to batch.taskID,
        destinationIndex to move.taskID,
    )
}
