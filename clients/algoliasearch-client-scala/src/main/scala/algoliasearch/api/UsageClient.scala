/** Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on
  * https://github.com/algolia/api-clients-automation. DO NOT EDIT.
  */
package algoliasearch.api

import algoliasearch.usage.ErrorBase
import algoliasearch.usage.GetUsage200Response
import algoliasearch.usage.GetUsage400Response
import algoliasearch.usage.Granularity._
import algoliasearch.usage.Statistic._
import algoliasearch.usage._
import algoliasearch.ApiClient
import algoliasearch.api.UsageClient.hosts
import algoliasearch.config._
import algoliasearch.internal.util._

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Random

object UsageClient {

  /** Creates a new SearchApi instance using default hosts.
    *
    * @param appId
    *   application ID
    * @param apiKey
    *   api key
    *
    * @param clientOptions
    *   client options
    */
  def apply(
      appId: String,
      apiKey: String,
      clientOptions: ClientOptions = ClientOptions()
  ) = new UsageClient(
    appId = appId,
    apiKey = apiKey,
    clientOptions = clientOptions
  )

  private def hosts(appId: String): Seq[Host] = {
    val commonHosts = Random.shuffle(
      List(
        Host(appId + "-1.algolianet.net", Set(CallType.Read, CallType.Write)),
        Host(appId + "-2.algolianet.net", Set(CallType.Read, CallType.Write)),
        Host(appId + "-3.algolianet.net", Set(CallType.Read, CallType.Write))
      )
    )
    List(
      Host(appId + "-dsn.algolia.net", Set(CallType.Read)),
      Host(appId + ".algolia.net", Set(CallType.Write))
    ) ++ commonHosts
  }
}

class UsageClient(
    appId: String,
    apiKey: String,
    clientOptions: ClientOptions = ClientOptions()
) extends ApiClient(
      appId = appId,
      apiKey = apiKey,
      clientName = "Usage",
      defaultHosts = hosts(appId),
      formats = JsonSupport.format,
      options = clientOptions
    ) {

  /** This method allow you to send requests to the Algolia REST API.
    *
    * @param path
    *   Path of the endpoint, anything after \"/1\" must be specified.
    * @param parameters
    *   Query parameters to apply to the current query.
    */
  def customDelete[T: Manifest](
      path: String,
      parameters: Option[Map[String, Any]] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[T] = Future {
    requireNotNull(path, "Parameter `path` is required when calling `customDelete`.")

    val request = HttpRequest
      .builder()
      .withMethod("DELETE")
      .withPath(s"/${path}")
      .withQueryParameters(parameters)
      .build()
    execute[T](request, requestOptions)
  }

  /** This method allow you to send requests to the Algolia REST API.
    *
    * @param path
    *   Path of the endpoint, anything after \"/1\" must be specified.
    * @param parameters
    *   Query parameters to apply to the current query.
    */
  def customGet[T: Manifest](
      path: String,
      parameters: Option[Map[String, Any]] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[T] = Future {
    requireNotNull(path, "Parameter `path` is required when calling `customGet`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/${path}")
      .withQueryParameters(parameters)
      .build()
    execute[T](request, requestOptions)
  }

  /** This method allow you to send requests to the Algolia REST API.
    *
    * @param path
    *   Path of the endpoint, anything after \"/1\" must be specified.
    * @param parameters
    *   Query parameters to apply to the current query.
    * @param body
    *   Parameters to send with the custom request.
    */
  def customPost[T: Manifest](
      path: String,
      parameters: Option[Map[String, Any]] = None,
      body: Option[Any] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[T] = Future {
    requireNotNull(path, "Parameter `path` is required when calling `customPost`.")

    val request = HttpRequest
      .builder()
      .withMethod("POST")
      .withPath(s"/${path}")
      .withBody(body)
      .withQueryParameters(parameters)
      .build()
    execute[T](request, requestOptions)
  }

  /** This method allow you to send requests to the Algolia REST API.
    *
    * @param path
    *   Path of the endpoint, anything after \"/1\" must be specified.
    * @param parameters
    *   Query parameters to apply to the current query.
    * @param body
    *   Parameters to send with the custom request.
    */
  def customPut[T: Manifest](
      path: String,
      parameters: Option[Map[String, Any]] = None,
      body: Option[Any] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[T] = Future {
    requireNotNull(path, "Parameter `path` is required when calling `customPut`.")

    val request = HttpRequest
      .builder()
      .withMethod("PUT")
      .withPath(s"/${path}")
      .withBody(body)
      .withQueryParameters(parameters)
      .build()
    execute[T](request, requestOptions)
  }

  /** Retrieves the selected usage statistics for one index.
    *
    * @param statistic
    *   Usage statistics to retrieve. Use `*` to retrieve all usage metrics, otherwise add one or more of the following
    *   metrics, separated by a comma. **Search operations** - `search_operations`. All search operations. -
    *   `total_search_operations`: Sum of all search operations. - `total_search_requests`: Sum of all [search
    *   requests](https://support.algolia.com/hc/en-us/articles/4406981829777-How-does-Algolia-count-records-and-operations-).
    *   The number of billed search requests is equal to this value minus `querysuggestions_total_search_requests`. -
    *   `queries_operations`. Number of [single index search](/specs/search#tag/Search/operation/searchSingleIndex)
    *   operations. - `multi_queries_operations`. Number of [multi-index
    *   search](/specs/search#tag/Search/operation/search) operations. **ACL operations** - `acl_operations`. All ACL
    *   operations. - `total_acl_operations`. Sum of all ACL operations. - `get_api_keys_operations`. Number of [list
    *   API keys](/specs/search#tag/Api-Keys/operation/listApiKeys) operations. - `get_api_key_operations`. Number of
    *   [get API key permission](/specs/search#tag/Api-Keys/operation/getApiKey) operations. - `add_api_key_operations`.
    *   Number of [create API key](/specs/search#tag/Api-Keys/operation/addApiKey) operations. -
    *   `update_api_key_operations`. Number of [update API key](/specs/search#tag/Api-Keys/operation/updateApiKey)
    *   operations. - `delete_api_key_operations`. Number of [delete API
    *   key](/specs/search#tag/Api-Keys/operation/deleteApiKey) operations. - `list_api_key_operations`. Number of list
    *   index API keys operations. **Indexing operations** - `indexing_operations`. All indexing operations. -
    *   `total_indexing_operations`. Sum of all indexing operations. - `browse_operations`. Number of [browse
    *   index](/specs/search#tag/Search/operation/browse) operations. - `clear_index_operations`. Number of [clear
    *   records](/specs/search#tag/Records/operation/clearObjects) operations. - `copy_move_operations`. Number of [copy
    *   or move index](/specs/search#tag/Indices/operation/operationIndex) operations. - `delete_index_operations`.
    *   Number of [delete index](/specs/search#tag/Indices/operation/deleteIndex) operations. - `get_log_operations`.
    *   Number of [get logs](/specs/search#tag/Advanced/operation/getLogs) operations. - `get_settings_operations`.
    *   Number of [get settings](/specs/search#operation/getIndexUsage) operations. - `set_settings_operations`. Number
    *   of [set settings](/specs/search#tag/Indices/operation/setSettings) operations. - `list_indices_operations`.
    *   Number of [list indices](/specs/search#tag/Indices/operation/listIndices) operations. - `wait_task_operations`.
    *   Number of [wait](/specs/search#tag/Indices/operation/getTask) operations. **Record operations** -
    *   `record_operations`. All record operations. - `total_records_operations`. Sum of all record operations. -
    *   `add_record_operations`. Number of [add or replace record](/specs/search#tag/Records/operation/saveObject)
    *   operations. - `batch_operations`. Number of [batch indexing](/specs/search#tag/Records/operation/multipleBatch)
    *   operations. - `delete_by_query_operations`. Number of [delete by
    *   query](/specs/search#tag/Records/operation/deleteBy) operations. - `delete_record_operations`. Number of [delete
    *   record](/specs/search#tag/Records/operation/deleteObject) operations. - `get_record_operations`. Number of [get
    *   record](/specs/search#tag/Records/operation/getObject) operations. - `partial_update_record_operations`. Number
    *   of [partially update records](/specs/search#tag/Records/operation/partialUpdateObject) operations. -
    *   `update_record_operations`. Number of [add or replace record by
    *   objectID](/specs/search#tag/Records/operation/addOrUpdateObject) operations. **Synonym operations** -
    *   `synonym_operations`. All synonym operations. - `total_synonym_operations`. Sum of all synonym operations. -
    *   `batch_synonym_operations`. Number of [save all synonyms](/specs/search#tag/Synonyms/operation/saveSynonyms)
    *   operations. - `clear_synonym_operations`. Number of [clear
    *   synonyms](/specs/search#tag/Synonyms/operation/clearSynonyms) operations. - `delete_synonym_operations`. Number
    *   of [delete synonym](/specs/search#tag/Synonyms/operation/deleteSynonym) operations. - `get_synonym_operations`.
    *   Number of [get synonym](/specs/search#tag/Synonyms/operation/getSynonym) operations. -
    *   `query_synonym_operations`. Number of [search synonyms](/specs/search#tag/Synonyms/operation/searchSynonyms)
    *   operations. - `update_synonym_operations`. Number of [save a
    *   synonym](/specs/search#tag/Synonyms/operation/saveSynonym) operations. **Rule operations** - `rule_operations`.
    *   All rule operations. - `total_rules_operations`. Sum of all rule operations. - `batch_rules_operations`. Number
    *   of [batch rules](/specs/search#tag/Rules/operation/saveRules) operations. - `clear_rules_operations`. Number of
    *   [delete rule](/specs/search#tag/Rules/operation/deleteRule) operations. - `delete_rules_operations`. Number of
    *   [clear rules](/specs/search#tag/Rules/operation/clearRules) operations. - `get_rules_operations`. Number of [get
    *   rule](/specs/search#tag/Rules/operation/getRule) operations. - `save_rules_operations`. Number of [save
    *   rule](/specs/search#operation/getIndexUsage) operations. - `search_rules_operations`. Number of [search
    *   rules](/specs/search#tag/Rules/operation/searchRules) operations. **Total operations** -
    *   `total_recommend_requests`. Number of [Recommend
    *   requests](https://www.algolia.com/doc/guides/algolia-ai/recommend/) - `total_write_operations`. Number of Write
    *   operations - `total_read_operations`. Number of read operations - `total_operations`. Sum of all operations
    *   **Total Query Suggestions operations** Query Suggestions operations are a subset of `total_search_operations`. -
    *   `querysuggestions_total_search_operations`. Number of Query Suggestions search operations. -
    *   `querysuggestions_total_search_requests`. Number of Query Suggestions [search
    *   requests](https://support.algolia.com/hc/en-us/articles/4406981829777-How-does-Algolia-count-records-and-operations-).
    *   \- `querysuggestions_total_acl_operations`. Sum of all Query Suggestions [ACL operations](#acl-operations). -
    *   `querysuggestions_total_indexing_operations`. Number of Query Suggestions [indexing
    *   operations](#indexing-operations). - `querysuggestions_total_records_operations`. Number of Query Suggestions
    *   [record operations](#record-operations). - `querysuggestions_total_synonym_operations`. Number of Query
    *   Suggestions [synonym operations](#synonym-operations). - `querysuggestions_total_rules_operations`. Number of
    *   Query Suggestions [Rule operations](#rule-operations). - `querysuggestions_total_write_operations`. Number of
    *   Query Suggestions Write operations. - `querysuggestions_total_read_operations`. Number of Query Suggestions Read
    *   operations. - `querysuggestions_total_operations`. Sum of all Query Suggestions operations. **Processing time**
    *   \- `avg_processing_time`. Average processing time (in milliseconds). - `90p_processing_time`. 90th percentile of
    *   processing time (in milliseconds). - `99p_processing_time`. 99th percentile of processing time (in
    *   milliseconds). - `queries_above_last_ms_processing_time`. Number of queries that take one or more seconds to
    *   process. **Indices** - `records`. Number of records. - `data_size`. The size of the records (in bytes). -
    *   `file_size`. The size of the records _and_ index metadata (in bytes). **Maximum queries per second** -
    *   `max_qps`. [Maximum queries per second](https://support.algolia.com/hc/en-us/articles/4406975224721) per server.
    *   \- `region_max_qps`. Maximum queries per second per region. - `total_max_qps`. Maximum queries per second across
    *   all servers. **Used search capacity** The following capacities are reported in percent: -
    *   `used_search_capacity`. Maximum search capacity used per server. - `avg_used_search_capacity`. Average search
    *   capacity used per server. - `region_used_search_capacity`. Maximum search capacity used per region. -
    *   `region_avg_used_search_capacity`. Average search capacity used per region. - `total_used_search_capacity`.
    *   Maximum search capacity used for all servers. - `total_avg_used_search_capacity`. Average used search capacity
    *   for all servers. **Degraded queries** Check the impact of [degraded
    *   queries](https://support.algolia.com/hc/en-us/articles/4406981934481). -
    *   `degraded_queries_ssd_used_queries_impacted`. Percentage of degraded queries due to the Algolia search engine
    *   having to read from the server's SSD. - `degraded_queries_ssd_used_seconds_impacted`. Percentage of seconds
    *   affected by `ssd_used` degraded queries. - `degraded_queries_max_capacity_queries_impacted`. Percentage of
    *   degraded queries due to all search threads being used. - `degraded_queries_max_capacity_seconds_impacted`.
    *   Percentage of seconds affected by `max_capacity` degraded queries.
    * @param indexName
    *   Name of the index on which to perform the operation.
    * @param startDate
    *   Start date of the period to analyze, in `YYYY-MM-DD` format.
    * @param endDate
    *   End date of the period to analyze, in `YYYY-MM-DD` format.
    * @param granularity
    *   Granularity of the aggregated metrics. - `hourly`: the maximum time range for hourly metrics is 7 days. -
    *   `daily`: the maximum time range for daily metrics is 365 days.
    */
  def getIndexUsage(
      statistic: Statistic,
      indexName: String,
      startDate: String,
      endDate: String,
      granularity: Option[Granularity] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetUsage200Response] = Future {
    requireNotNull(statistic, "Parameter `statistic` is required when calling `getIndexUsage`.")
    requireNotNull(indexName, "Parameter `indexName` is required when calling `getIndexUsage`.")
    requireNotNull(startDate, "Parameter `startDate` is required when calling `getIndexUsage`.")
    requireNotNull(endDate, "Parameter `endDate` is required when calling `getIndexUsage`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/1/usage/${escape(statistic)}/${escape(indexName)}")
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("granularity", granularity)
      .build()
    execute[GetUsage200Response](request, requestOptions)
  }

  /** Retrieves usage statistics evaluated over a specified period.
    *
    * @param statistic
    *   Usage statistics to retrieve. Use `*` to retrieve all usage metrics, otherwise add one or more of the following
    *   metrics, separated by a comma. **Search operations** - `search_operations`. All search operations. -
    *   `total_search_operations`: Sum of all search operations. - `total_search_requests`: Sum of all [search
    *   requests](https://support.algolia.com/hc/en-us/articles/4406981829777-How-does-Algolia-count-records-and-operations-).
    *   The number of billed search requests is equal to this value minus `querysuggestions_total_search_requests`. -
    *   `queries_operations`. Number of [single index search](/specs/search#tag/Search/operation/searchSingleIndex)
    *   operations. - `multi_queries_operations`. Number of [multi-index
    *   search](/specs/search#tag/Search/operation/search) operations. **ACL operations** - `acl_operations`. All ACL
    *   operations. - `total_acl_operations`. Sum of all ACL operations. - `get_api_keys_operations`. Number of [list
    *   API keys](/specs/search#tag/Api-Keys/operation/listApiKeys) operations. - `get_api_key_operations`. Number of
    *   [get API key permission](/specs/search#tag/Api-Keys/operation/getApiKey) operations. - `add_api_key_operations`.
    *   Number of [create API key](/specs/search#tag/Api-Keys/operation/addApiKey) operations. -
    *   `update_api_key_operations`. Number of [update API key](/specs/search#tag/Api-Keys/operation/updateApiKey)
    *   operations. - `delete_api_key_operations`. Number of [delete API
    *   key](/specs/search#tag/Api-Keys/operation/deleteApiKey) operations. - `list_api_key_operations`. Number of list
    *   index API keys operations. **Indexing operations** - `indexing_operations`. All indexing operations. -
    *   `total_indexing_operations`. Sum of all indexing operations. - `browse_operations`. Number of [browse
    *   index](/specs/search#tag/Search/operation/browse) operations. - `clear_index_operations`. Number of [clear
    *   records](/specs/search#tag/Records/operation/clearObjects) operations. - `copy_move_operations`. Number of [copy
    *   or move index](/specs/search#tag/Indices/operation/operationIndex) operations. - `delete_index_operations`.
    *   Number of [delete index](/specs/search#tag/Indices/operation/deleteIndex) operations. - `get_log_operations`.
    *   Number of [get logs](/specs/search#tag/Advanced/operation/getLogs) operations. - `get_settings_operations`.
    *   Number of [get settings](/specs/search#operation/getIndexUsage) operations. - `set_settings_operations`. Number
    *   of [set settings](/specs/search#tag/Indices/operation/setSettings) operations. - `list_indices_operations`.
    *   Number of [list indices](/specs/search#tag/Indices/operation/listIndices) operations. - `wait_task_operations`.
    *   Number of [wait](/specs/search#tag/Indices/operation/getTask) operations. **Record operations** -
    *   `record_operations`. All record operations. - `total_records_operations`. Sum of all record operations. -
    *   `add_record_operations`. Number of [add or replace record](/specs/search#tag/Records/operation/saveObject)
    *   operations. - `batch_operations`. Number of [batch indexing](/specs/search#tag/Records/operation/multipleBatch)
    *   operations. - `delete_by_query_operations`. Number of [delete by
    *   query](/specs/search#tag/Records/operation/deleteBy) operations. - `delete_record_operations`. Number of [delete
    *   record](/specs/search#tag/Records/operation/deleteObject) operations. - `get_record_operations`. Number of [get
    *   record](/specs/search#tag/Records/operation/getObject) operations. - `partial_update_record_operations`. Number
    *   of [partially update records](/specs/search#tag/Records/operation/partialUpdateObject) operations. -
    *   `update_record_operations`. Number of [add or replace record by
    *   objectID](/specs/search#tag/Records/operation/addOrUpdateObject) operations. **Synonym operations** -
    *   `synonym_operations`. All synonym operations. - `total_synonym_operations`. Sum of all synonym operations. -
    *   `batch_synonym_operations`. Number of [save all synonyms](/specs/search#tag/Synonyms/operation/saveSynonyms)
    *   operations. - `clear_synonym_operations`. Number of [clear
    *   synonyms](/specs/search#tag/Synonyms/operation/clearSynonyms) operations. - `delete_synonym_operations`. Number
    *   of [delete synonym](/specs/search#tag/Synonyms/operation/deleteSynonym) operations. - `get_synonym_operations`.
    *   Number of [get synonym](/specs/search#tag/Synonyms/operation/getSynonym) operations. -
    *   `query_synonym_operations`. Number of [search synonyms](/specs/search#tag/Synonyms/operation/searchSynonyms)
    *   operations. - `update_synonym_operations`. Number of [save a
    *   synonym](/specs/search#tag/Synonyms/operation/saveSynonym) operations. **Rule operations** - `rule_operations`.
    *   All rule operations. - `total_rules_operations`. Sum of all rule operations. - `batch_rules_operations`. Number
    *   of [batch rules](/specs/search#tag/Rules/operation/saveRules) operations. - `clear_rules_operations`. Number of
    *   [delete rule](/specs/search#tag/Rules/operation/deleteRule) operations. - `delete_rules_operations`. Number of
    *   [clear rules](/specs/search#tag/Rules/operation/clearRules) operations. - `get_rules_operations`. Number of [get
    *   rule](/specs/search#tag/Rules/operation/getRule) operations. - `save_rules_operations`. Number of [save
    *   rule](/specs/search#operation/getIndexUsage) operations. - `search_rules_operations`. Number of [search
    *   rules](/specs/search#tag/Rules/operation/searchRules) operations. **Total operations** -
    *   `total_recommend_requests`. Number of [Recommend
    *   requests](https://www.algolia.com/doc/guides/algolia-ai/recommend/) - `total_write_operations`. Number of Write
    *   operations - `total_read_operations`. Number of read operations - `total_operations`. Sum of all operations
    *   **Total Query Suggestions operations** Query Suggestions operations are a subset of `total_search_operations`. -
    *   `querysuggestions_total_search_operations`. Number of Query Suggestions search operations. -
    *   `querysuggestions_total_search_requests`. Number of Query Suggestions [search
    *   requests](https://support.algolia.com/hc/en-us/articles/4406981829777-How-does-Algolia-count-records-and-operations-).
    *   \- `querysuggestions_total_acl_operations`. Sum of all Query Suggestions [ACL operations](#acl-operations). -
    *   `querysuggestions_total_indexing_operations`. Number of Query Suggestions [indexing
    *   operations](#indexing-operations). - `querysuggestions_total_records_operations`. Number of Query Suggestions
    *   [record operations](#record-operations). - `querysuggestions_total_synonym_operations`. Number of Query
    *   Suggestions [synonym operations](#synonym-operations). - `querysuggestions_total_rules_operations`. Number of
    *   Query Suggestions [Rule operations](#rule-operations). - `querysuggestions_total_write_operations`. Number of
    *   Query Suggestions Write operations. - `querysuggestions_total_read_operations`. Number of Query Suggestions Read
    *   operations. - `querysuggestions_total_operations`. Sum of all Query Suggestions operations. **Processing time**
    *   \- `avg_processing_time`. Average processing time (in milliseconds). - `90p_processing_time`. 90th percentile of
    *   processing time (in milliseconds). - `99p_processing_time`. 99th percentile of processing time (in
    *   milliseconds). - `queries_above_last_ms_processing_time`. Number of queries that take one or more seconds to
    *   process. **Indices** - `records`. Number of records. - `data_size`. The size of the records (in bytes). -
    *   `file_size`. The size of the records _and_ index metadata (in bytes). **Maximum queries per second** -
    *   `max_qps`. [Maximum queries per second](https://support.algolia.com/hc/en-us/articles/4406975224721) per server.
    *   \- `region_max_qps`. Maximum queries per second per region. - `total_max_qps`. Maximum queries per second across
    *   all servers. **Used search capacity** The following capacities are reported in percent: -
    *   `used_search_capacity`. Maximum search capacity used per server. - `avg_used_search_capacity`. Average search
    *   capacity used per server. - `region_used_search_capacity`. Maximum search capacity used per region. -
    *   `region_avg_used_search_capacity`. Average search capacity used per region. - `total_used_search_capacity`.
    *   Maximum search capacity used for all servers. - `total_avg_used_search_capacity`. Average used search capacity
    *   for all servers. **Degraded queries** Check the impact of [degraded
    *   queries](https://support.algolia.com/hc/en-us/articles/4406981934481). -
    *   `degraded_queries_ssd_used_queries_impacted`. Percentage of degraded queries due to the Algolia search engine
    *   having to read from the server's SSD. - `degraded_queries_ssd_used_seconds_impacted`. Percentage of seconds
    *   affected by `ssd_used` degraded queries. - `degraded_queries_max_capacity_queries_impacted`. Percentage of
    *   degraded queries due to all search threads being used. - `degraded_queries_max_capacity_seconds_impacted`.
    *   Percentage of seconds affected by `max_capacity` degraded queries.
    * @param startDate
    *   Start date of the period to analyze, in `YYYY-MM-DD` format.
    * @param endDate
    *   End date of the period to analyze, in `YYYY-MM-DD` format.
    * @param granularity
    *   Granularity of the aggregated metrics. - `hourly`: the maximum time range for hourly metrics is 7 days. -
    *   `daily`: the maximum time range for daily metrics is 365 days.
    */
  def getUsage(
      statistic: Statistic,
      startDate: String,
      endDate: String,
      granularity: Option[Granularity] = None,
      requestOptions: Option[RequestOptions] = None
  )(implicit ec: ExecutionContext): Future[GetUsage200Response] = Future {
    requireNotNull(statistic, "Parameter `statistic` is required when calling `getUsage`.")
    requireNotNull(startDate, "Parameter `startDate` is required when calling `getUsage`.")
    requireNotNull(endDate, "Parameter `endDate` is required when calling `getUsage`.")

    val request = HttpRequest
      .builder()
      .withMethod("GET")
      .withPath(s"/1/usage/${escape(statistic)}")
      .withQueryParameter("startDate", startDate)
      .withQueryParameter("endDate", endDate)
      .withQueryParameter("granularity", granularity)
      .build()
    execute[GetUsage200Response](request, requestOptions)
  }

}
