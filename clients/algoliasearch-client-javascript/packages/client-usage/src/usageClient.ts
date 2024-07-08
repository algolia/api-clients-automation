// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import {
  createAuth,
  createTransporter,
  getAlgoliaAgent,
  shuffle,
} from '@algolia/client-common';
import type {
  CreateClientOptions,
  Headers,
  Host,
  QueryParameters,
  Request,
  RequestOptions,
} from '@algolia/client-common';

import type {
  CustomDeleteProps,
  CustomGetProps,
  CustomPostProps,
  CustomPutProps,
  GetIndexUsageProps,
  GetUsageProps,
} from '../model/clientMethodProps';
import type { GetUsage200Response } from '../model/getUsage200Response';

export const apiClientVersion = '0.0.2-beta.9';

function getDefaultHosts(appId: string): Host[] {
  return (
    [
      {
        url: `${appId}-dsn.algolia.net`,
        accept: 'read',
        protocol: 'https',
      },
      {
        url: `${appId}.algolia.net`,
        accept: 'write',
        protocol: 'https',
      },
    ] as Host[]
  ).concat(
    shuffle([
      {
        url: `${appId}-1.algolianet.com`,
        accept: 'readWrite',
        protocol: 'https',
      },
      {
        url: `${appId}-2.algolianet.com`,
        accept: 'readWrite',
        protocol: 'https',
      },
      {
        url: `${appId}-3.algolianet.com`,
        accept: 'readWrite',
        protocol: 'https',
      },
    ])
  );
}

// eslint-disable-next-line @typescript-eslint/explicit-function-return-type
export function createUsageClient({
  appId: appIdOption,
  apiKey: apiKeyOption,
  authMode,
  algoliaAgents,
  ...options
}: CreateClientOptions) {
  const auth = createAuth(appIdOption, apiKeyOption, authMode);
  const transporter = createTransporter({
    hosts: getDefaultHosts(appIdOption),
    ...options,
    algoliaAgent: getAlgoliaAgent({
      algoliaAgents,
      client: 'Usage',
      version: apiClientVersion,
    }),
    baseHeaders: {
      'content-type': 'text/plain',
      ...auth.headers(),
      ...options.baseHeaders,
    },
    baseQueryParameters: {
      ...auth.queryParameters(),
      ...options.baseQueryParameters,
    },
  });

  return {
    transporter,

    /**
     * The `appId` currently in use.
     */
    appId: appIdOption,

    /**
     * Clears the cache of the transporter for the `requestsCache` and `responsesCache` properties.
     */
    clearCache(): Promise<void> {
      return Promise.all([
        transporter.requestsCache.clear(),
        transporter.responsesCache.clear(),
      ]).then(() => undefined);
    },

    /**
     * Get the value of the `algoliaAgent`, used by our libraries internally and telemetry system.
     */
    get _ua(): string {
      return transporter.algoliaAgent.value;
    },

    /**
     * Adds a `segment` to the `x-algolia-agent` sent with every requests.
     *
     * @param segment - The algolia agent (user-agent) segment to add.
     * @param version - The version of the agent.
     */
    addAlgoliaAgent(segment: string, version?: string): void {
      transporter.algoliaAgent.add({ segment, version });
    },

    /**
     * This method allow you to send requests to the Algolia REST API.
     *
     * @param customDelete - The customDelete object.
     * @param customDelete.path - Path of the endpoint, anything after \"/1\" must be specified.
     * @param customDelete.parameters - Query parameters to apply to the current query.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    customDelete(
      { path, parameters }: CustomDeleteProps,
      requestOptions?: RequestOptions
    ): Promise<Record<string, any>> {
      if (!path) {
        throw new Error(
          'Parameter `path` is required when calling `customDelete`.'
        );
      }

      const requestPath = '/{path}'.replace('{path}', path);
      const headers: Headers = {};
      const queryParameters: QueryParameters = parameters ? parameters : {};

      const request: Request = {
        method: 'DELETE',
        path: requestPath,
        queryParameters,
        headers,
      };

      return transporter.request(request, requestOptions);
    },

    /**
     * This method allow you to send requests to the Algolia REST API.
     *
     * @param customGet - The customGet object.
     * @param customGet.path - Path of the endpoint, anything after \"/1\" must be specified.
     * @param customGet.parameters - Query parameters to apply to the current query.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    customGet(
      { path, parameters }: CustomGetProps,
      requestOptions?: RequestOptions
    ): Promise<Record<string, any>> {
      if (!path) {
        throw new Error(
          'Parameter `path` is required when calling `customGet`.'
        );
      }

      const requestPath = '/{path}'.replace('{path}', path);
      const headers: Headers = {};
      const queryParameters: QueryParameters = parameters ? parameters : {};

      const request: Request = {
        method: 'GET',
        path: requestPath,
        queryParameters,
        headers,
      };

      return transporter.request(request, requestOptions);
    },

    /**
     * This method allow you to send requests to the Algolia REST API.
     *
     * @param customPost - The customPost object.
     * @param customPost.path - Path of the endpoint, anything after \"/1\" must be specified.
     * @param customPost.parameters - Query parameters to apply to the current query.
     * @param customPost.body - Parameters to send with the custom request.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    customPost(
      { path, parameters, body }: CustomPostProps,
      requestOptions?: RequestOptions
    ): Promise<Record<string, any>> {
      if (!path) {
        throw new Error(
          'Parameter `path` is required when calling `customPost`.'
        );
      }

      const requestPath = '/{path}'.replace('{path}', path);
      const headers: Headers = {};
      const queryParameters: QueryParameters = parameters ? parameters : {};

      const request: Request = {
        method: 'POST',
        path: requestPath,
        queryParameters,
        headers,
        data: body ? body : {},
      };

      return transporter.request(request, requestOptions);
    },

    /**
     * This method allow you to send requests to the Algolia REST API.
     *
     * @param customPut - The customPut object.
     * @param customPut.path - Path of the endpoint, anything after \"/1\" must be specified.
     * @param customPut.parameters - Query parameters to apply to the current query.
     * @param customPut.body - Parameters to send with the custom request.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    customPut(
      { path, parameters, body }: CustomPutProps,
      requestOptions?: RequestOptions
    ): Promise<Record<string, any>> {
      if (!path) {
        throw new Error(
          'Parameter `path` is required when calling `customPut`.'
        );
      }

      const requestPath = '/{path}'.replace('{path}', path);
      const headers: Headers = {};
      const queryParameters: QueryParameters = parameters ? parameters : {};

      const request: Request = {
        method: 'PUT',
        path: requestPath,
        queryParameters,
        headers,
        data: body ? body : {},
      };

      return transporter.request(request, requestOptions);
    },

    /**
     * Retrieves the selected usage statistics for one index.
     *
     * @param getIndexUsage - The getIndexUsage object.
     * @param getIndexUsage.statistic - Usage statistics to retrieve.  Use `*` to retrieve all usage metrics, otherwise add one or more of the following metrics, separated by a comma.  **Search operations**  - `search_operations`. All search operations. - `total_search_operations`: Sum of all search operations. - `total_search_requests`: Sum of all [search requests](https://support.algolia.com/hc/en-us/articles/4406981829777-How-does-Algolia-count-records-and-operations-).    The number of billed search requests is equal to this value minus `querysuggestions_total_search_requests`. - `queries_operations`. Number of [single index search](/specs/search#tag/Search/operation/searchSingleIndex) operations. - `multi_queries_operations`. Number of [multi-index search](/specs/search#tag/Search/operation/search) operations.  **ACL operations**  - `acl_operations`. All ACL operations. - `total_acl_operations`. Sum of all ACL operations. - `get_api_keys_operations`. Number of [list API keys](/specs/search#tag/Api-Keys/operation/listApiKeys) operations. - `get_api_key_operations`. Number of [get API key permission](/specs/search#tag/Api-Keys/operation/getApiKey) operations. - `add_api_key_operations`. Number of [create API key](/specs/search#tag/Api-Keys/operation/addApiKey) operations. - `update_api_key_operations`. Number of [update API key](/specs/search#tag/Api-Keys/operation/updateApiKey) operations. - `delete_api_key_operations`. Number of [delete API key](/specs/search#tag/Api-Keys/operation/deleteApiKey) operations. - `list_api_key_operations`. Number of list index API keys operations.  **Indexing operations**  - `indexing_operations`. All indexing operations. - `total_indexing_operations`. Sum of all indexing operations. - `browse_operations`. Number of [browse index](/specs/search#tag/Search/operation/browse) operations. - `clear_index_operations`. Number of [clear records](/specs/search#tag/Records/operation/clearObjects) operations. - `copy_move_operations`. Number of [copy or move index](/specs/search#tag/Indices/operation/operationIndex) operations. - `delete_index_operations`. Number of [delete index](/specs/search#tag/Indices/operation/deleteIndex) operations. - `get_log_operations`. Number of [get logs](/specs/search#tag/Advanced/operation/getLogs) operations. - `get_settings_operations`. Number of [get settings](/specs/search#operation/getIndexUsage) operations. - `set_settings_operations`. Number of [set settings](/specs/search#tag/Indices/operation/setSettings) operations. - `list_indices_operations`. Number of [list indices](/specs/search#tag/Indices/operation/listIndices) operations. - `wait_task_operations`. Number of [wait](/specs/search#tag/Indices/operation/getTask) operations.  **Record operations**  - `record_operations`. All record operations. - `total_records_operations`. Sum of all record operations. - `add_record_operations`. Number of [add or replace record](/specs/search#tag/Records/operation/saveObject) operations. - `batch_operations`. Number of [batch indexing](/specs/search#tag/Records/operation/multipleBatch) operations. - `delete_by_query_operations`. Number of [delete by query](/specs/search#tag/Records/operation/deleteBy) operations. - `delete_record_operations`. Number of [delete record](/specs/search#tag/Records/operation/deleteObject) operations. - `get_record_operations`. Number of [get record](/specs/search#tag/Records/operation/getObject) operations. - `partial_update_record_operations`. Number of [partially update records](/specs/search#tag/Records/operation/partialUpdateObject) operations. - `update_record_operations`. Number of [add or replace record by objectID](/specs/search#tag/Records/operation/addOrUpdateObject) operations.  **Synonym operations**  - `synonym_operations`. All synonym operations. - `total_synonym_operations`. Sum of all synonym operations. - `batch_synonym_operations`. Number of [save all synonyms](/specs/search#tag/Synonyms/operation/saveSynonyms) operations. - `clear_synonym_operations`. Number of [clear synonyms](/specs/search#tag/Synonyms/operation/clearSynonyms) operations. - `delete_synonym_operations`. Number of [delete synonym](/specs/search#tag/Synonyms/operation/deleteSynonym) operations. - `get_synonym_operations`. Number of [get synonym](/specs/search#tag/Synonyms/operation/getSynonym) operations. - `query_synonym_operations`. Number of [search synonyms](/specs/search#tag/Synonyms/operation/searchSynonyms) operations. - `update_synonym_operations`. Number of [save a synonym](/specs/search#tag/Synonyms/operation/saveSynonym) operations.  **Rule operations**  - `rule_operations`. All rule operations. - `total_rules_operations`. Sum of all rule operations. - `batch_rules_operations`. Number of [batch rules](/specs/search#tag/Rules/operation/saveRules) operations. - `clear_rules_operations`. Number of [delete rule](/specs/search#tag/Rules/operation/deleteRule) operations. - `delete_rules_operations`. Number of [clear rules](/specs/search#tag/Rules/operation/clearRules) operations. - `get_rules_operations`. Number of [get rule](/specs/search#tag/Rules/operation/getRule) operations. - `save_rules_operations`. Number of [save rule](/specs/search#operation/getIndexUsage) operations. - `search_rules_operations`. Number of [search rules](/specs/search#tag/Rules/operation/searchRules) operations.  **Total operations**  - `total_recommend_requests`. Number of [Recommend requests](https://www.algolia.com/doc/guides/algolia-ai/recommend/) - `total_write_operations`. Number of Write operations - `total_read_operations`. Number of read operations - `total_operations`. Sum of all operations  **Total Query Suggestions operations**  Query Suggestions operations are a subset of `total_search_operations`.  - `querysuggestions_total_search_operations`. Number of Query Suggestions search operations. - `querysuggestions_total_search_requests`. Number of Query Suggestions [search requests](https://support.algolia.com/hc/en-us/articles/4406981829777-How-does-Algolia-count-records-and-operations-). - `querysuggestions_total_acl_operations`. Sum of all Query Suggestions [ACL operations](#acl-operations). - `querysuggestions_total_indexing_operations`. Number of Query Suggestions [indexing operations](#indexing-operations). - `querysuggestions_total_records_operations`. Number of Query Suggestions [record operations](#record-operations). - `querysuggestions_total_synonym_operations`. Number of Query Suggestions [synonym operations](#synonym-operations). - `querysuggestions_total_rules_operations`. Number of Query Suggestions [Rule operations](#rule-operations). - `querysuggestions_total_write_operations`. Number of Query Suggestions Write operations. - `querysuggestions_total_read_operations`. Number of Query Suggestions Read operations. - `querysuggestions_total_operations`. Sum of all Query Suggestions operations.  **Processing time**  - `avg_processing_time`. Average processing time (in milliseconds). - `90p_processing_time`. 90th percentile of processing time (in milliseconds). - `99p_processing_time`. 99th percentile of processing time (in milliseconds). - `queries_above_last_ms_processing_time`. Number of queries that take one or more seconds to process.  **Indices**  - `records`. Number of records. - `data_size`. The size of the records (in bytes). - `file_size`. The size of the records _and_ index metadata (in bytes).  **Maximum queries per second**  - `max_qps`. [Maximum queries per second](https://support.algolia.com/hc/en-us/articles/4406975224721) per server. - `region_max_qps`. Maximum queries per second per region. - `total_max_qps`. Maximum queries per second across all servers.  **Used search capacity**  The following capacities are reported in percent:  - `used_search_capacity`. Maximum search capacity used per server. - `avg_used_search_capacity`. Average search capacity used per server. - `region_used_search_capacity`. Maximum search capacity used per region. - `region_avg_used_search_capacity`. Average search capacity used per region. - `total_used_search_capacity`. Maximum search capacity used for all servers. - `total_avg_used_search_capacity`. Average used search capacity for all servers.  **Degraded queries**  Check the impact of [degraded queries](https://support.algolia.com/hc/en-us/articles/4406981934481).  - `degraded_queries_ssd_used_queries_impacted`. Percentage of degraded queries due to the Algolia search engine having to read from the server\'s SSD. - `degraded_queries_ssd_used_seconds_impacted`. Percentage of seconds affected by `ssd_used` degraded queries. - `degraded_queries_max_capacity_queries_impacted`. Percentage of degraded queries due to all search threads being used. - `degraded_queries_max_capacity_seconds_impacted`. Percentage of seconds affected by `max_capacity` degraded queries.
     * @param getIndexUsage.indexName - Name of the index on which to perform the operation.
     * @param getIndexUsage.startDate - Start date of the period to analyze, in `YYYY-MM-DD` format.
     * @param getIndexUsage.endDate - End date of the period to analyze, in `YYYY-MM-DD` format.
     * @param getIndexUsage.granularity - Granularity of the aggregated metrics.  - `hourly`: the maximum time range for hourly metrics is 7 days. - `daily`: the maximum time range for daily metrics is 365 days.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    getIndexUsage(
      {
        statistic,
        indexName,
        startDate,
        endDate,
        granularity,
      }: GetIndexUsageProps,
      requestOptions?: RequestOptions
    ): Promise<GetUsage200Response> {
      if (!statistic) {
        throw new Error(
          'Parameter `statistic` is required when calling `getIndexUsage`.'
        );
      }

      if (!indexName) {
        throw new Error(
          'Parameter `indexName` is required when calling `getIndexUsage`.'
        );
      }

      if (!startDate) {
        throw new Error(
          'Parameter `startDate` is required when calling `getIndexUsage`.'
        );
      }

      if (!endDate) {
        throw new Error(
          'Parameter `endDate` is required when calling `getIndexUsage`.'
        );
      }

      const requestPath = '/1/usage/{statistic}/{indexName}'
        .replace('{statistic}', encodeURIComponent(statistic))
        .replace('{indexName}', encodeURIComponent(indexName));
      const headers: Headers = {};
      const queryParameters: QueryParameters = {};

      if (startDate !== undefined) {
        queryParameters.startDate = startDate.toString();
      }

      if (endDate !== undefined) {
        queryParameters.endDate = endDate.toString();
      }

      if (granularity !== undefined) {
        queryParameters.granularity = granularity.toString();
      }

      const request: Request = {
        method: 'GET',
        path: requestPath,
        queryParameters,
        headers,
      };

      return transporter.request(request, requestOptions);
    },

    /**
     * Retrieves usage statistics evaluated over a specified period.
     *
     * @param getUsage - The getUsage object.
     * @param getUsage.statistic - Usage statistics to retrieve.  Use `*` to retrieve all usage metrics, otherwise add one or more of the following metrics, separated by a comma.  **Search operations**  - `search_operations`. All search operations. - `total_search_operations`: Sum of all search operations. - `total_search_requests`: Sum of all [search requests](https://support.algolia.com/hc/en-us/articles/4406981829777-How-does-Algolia-count-records-and-operations-).    The number of billed search requests is equal to this value minus `querysuggestions_total_search_requests`. - `queries_operations`. Number of [single index search](/specs/search#tag/Search/operation/searchSingleIndex) operations. - `multi_queries_operations`. Number of [multi-index search](/specs/search#tag/Search/operation/search) operations.  **ACL operations**  - `acl_operations`. All ACL operations. - `total_acl_operations`. Sum of all ACL operations. - `get_api_keys_operations`. Number of [list API keys](/specs/search#tag/Api-Keys/operation/listApiKeys) operations. - `get_api_key_operations`. Number of [get API key permission](/specs/search#tag/Api-Keys/operation/getApiKey) operations. - `add_api_key_operations`. Number of [create API key](/specs/search#tag/Api-Keys/operation/addApiKey) operations. - `update_api_key_operations`. Number of [update API key](/specs/search#tag/Api-Keys/operation/updateApiKey) operations. - `delete_api_key_operations`. Number of [delete API key](/specs/search#tag/Api-Keys/operation/deleteApiKey) operations. - `list_api_key_operations`. Number of list index API keys operations.  **Indexing operations**  - `indexing_operations`. All indexing operations. - `total_indexing_operations`. Sum of all indexing operations. - `browse_operations`. Number of [browse index](/specs/search#tag/Search/operation/browse) operations. - `clear_index_operations`. Number of [clear records](/specs/search#tag/Records/operation/clearObjects) operations. - `copy_move_operations`. Number of [copy or move index](/specs/search#tag/Indices/operation/operationIndex) operations. - `delete_index_operations`. Number of [delete index](/specs/search#tag/Indices/operation/deleteIndex) operations. - `get_log_operations`. Number of [get logs](/specs/search#tag/Advanced/operation/getLogs) operations. - `get_settings_operations`. Number of [get settings](/specs/search#operation/getIndexUsage) operations. - `set_settings_operations`. Number of [set settings](/specs/search#tag/Indices/operation/setSettings) operations. - `list_indices_operations`. Number of [list indices](/specs/search#tag/Indices/operation/listIndices) operations. - `wait_task_operations`. Number of [wait](/specs/search#tag/Indices/operation/getTask) operations.  **Record operations**  - `record_operations`. All record operations. - `total_records_operations`. Sum of all record operations. - `add_record_operations`. Number of [add or replace record](/specs/search#tag/Records/operation/saveObject) operations. - `batch_operations`. Number of [batch indexing](/specs/search#tag/Records/operation/multipleBatch) operations. - `delete_by_query_operations`. Number of [delete by query](/specs/search#tag/Records/operation/deleteBy) operations. - `delete_record_operations`. Number of [delete record](/specs/search#tag/Records/operation/deleteObject) operations. - `get_record_operations`. Number of [get record](/specs/search#tag/Records/operation/getObject) operations. - `partial_update_record_operations`. Number of [partially update records](/specs/search#tag/Records/operation/partialUpdateObject) operations. - `update_record_operations`. Number of [add or replace record by objectID](/specs/search#tag/Records/operation/addOrUpdateObject) operations.  **Synonym operations**  - `synonym_operations`. All synonym operations. - `total_synonym_operations`. Sum of all synonym operations. - `batch_synonym_operations`. Number of [save all synonyms](/specs/search#tag/Synonyms/operation/saveSynonyms) operations. - `clear_synonym_operations`. Number of [clear synonyms](/specs/search#tag/Synonyms/operation/clearSynonyms) operations. - `delete_synonym_operations`. Number of [delete synonym](/specs/search#tag/Synonyms/operation/deleteSynonym) operations. - `get_synonym_operations`. Number of [get synonym](/specs/search#tag/Synonyms/operation/getSynonym) operations. - `query_synonym_operations`. Number of [search synonyms](/specs/search#tag/Synonyms/operation/searchSynonyms) operations. - `update_synonym_operations`. Number of [save a synonym](/specs/search#tag/Synonyms/operation/saveSynonym) operations.  **Rule operations**  - `rule_operations`. All rule operations. - `total_rules_operations`. Sum of all rule operations. - `batch_rules_operations`. Number of [batch rules](/specs/search#tag/Rules/operation/saveRules) operations. - `clear_rules_operations`. Number of [delete rule](/specs/search#tag/Rules/operation/deleteRule) operations. - `delete_rules_operations`. Number of [clear rules](/specs/search#tag/Rules/operation/clearRules) operations. - `get_rules_operations`. Number of [get rule](/specs/search#tag/Rules/operation/getRule) operations. - `save_rules_operations`. Number of [save rule](/specs/search#operation/getIndexUsage) operations. - `search_rules_operations`. Number of [search rules](/specs/search#tag/Rules/operation/searchRules) operations.  **Total operations**  - `total_recommend_requests`. Number of [Recommend requests](https://www.algolia.com/doc/guides/algolia-ai/recommend/) - `total_write_operations`. Number of Write operations - `total_read_operations`. Number of read operations - `total_operations`. Sum of all operations  **Total Query Suggestions operations**  Query Suggestions operations are a subset of `total_search_operations`.  - `querysuggestions_total_search_operations`. Number of Query Suggestions search operations. - `querysuggestions_total_search_requests`. Number of Query Suggestions [search requests](https://support.algolia.com/hc/en-us/articles/4406981829777-How-does-Algolia-count-records-and-operations-). - `querysuggestions_total_acl_operations`. Sum of all Query Suggestions [ACL operations](#acl-operations). - `querysuggestions_total_indexing_operations`. Number of Query Suggestions [indexing operations](#indexing-operations). - `querysuggestions_total_records_operations`. Number of Query Suggestions [record operations](#record-operations). - `querysuggestions_total_synonym_operations`. Number of Query Suggestions [synonym operations](#synonym-operations). - `querysuggestions_total_rules_operations`. Number of Query Suggestions [Rule operations](#rule-operations). - `querysuggestions_total_write_operations`. Number of Query Suggestions Write operations. - `querysuggestions_total_read_operations`. Number of Query Suggestions Read operations. - `querysuggestions_total_operations`. Sum of all Query Suggestions operations.  **Processing time**  - `avg_processing_time`. Average processing time (in milliseconds). - `90p_processing_time`. 90th percentile of processing time (in milliseconds). - `99p_processing_time`. 99th percentile of processing time (in milliseconds). - `queries_above_last_ms_processing_time`. Number of queries that take one or more seconds to process.  **Indices**  - `records`. Number of records. - `data_size`. The size of the records (in bytes). - `file_size`. The size of the records _and_ index metadata (in bytes).  **Maximum queries per second**  - `max_qps`. [Maximum queries per second](https://support.algolia.com/hc/en-us/articles/4406975224721) per server. - `region_max_qps`. Maximum queries per second per region. - `total_max_qps`. Maximum queries per second across all servers.  **Used search capacity**  The following capacities are reported in percent:  - `used_search_capacity`. Maximum search capacity used per server. - `avg_used_search_capacity`. Average search capacity used per server. - `region_used_search_capacity`. Maximum search capacity used per region. - `region_avg_used_search_capacity`. Average search capacity used per region. - `total_used_search_capacity`. Maximum search capacity used for all servers. - `total_avg_used_search_capacity`. Average used search capacity for all servers.  **Degraded queries**  Check the impact of [degraded queries](https://support.algolia.com/hc/en-us/articles/4406981934481).  - `degraded_queries_ssd_used_queries_impacted`. Percentage of degraded queries due to the Algolia search engine having to read from the server\'s SSD. - `degraded_queries_ssd_used_seconds_impacted`. Percentage of seconds affected by `ssd_used` degraded queries. - `degraded_queries_max_capacity_queries_impacted`. Percentage of degraded queries due to all search threads being used. - `degraded_queries_max_capacity_seconds_impacted`. Percentage of seconds affected by `max_capacity` degraded queries.
     * @param getUsage.startDate - Start date of the period to analyze, in `YYYY-MM-DD` format.
     * @param getUsage.endDate - End date of the period to analyze, in `YYYY-MM-DD` format.
     * @param getUsage.granularity - Granularity of the aggregated metrics.  - `hourly`: the maximum time range for hourly metrics is 7 days. - `daily`: the maximum time range for daily metrics is 365 days.
     * @param requestOptions - The requestOptions to send along with the query, they will be merged with the transporter requestOptions.
     */
    getUsage(
      { statistic, startDate, endDate, granularity }: GetUsageProps,
      requestOptions?: RequestOptions
    ): Promise<GetUsage200Response> {
      if (!statistic) {
        throw new Error(
          'Parameter `statistic` is required when calling `getUsage`.'
        );
      }

      if (!startDate) {
        throw new Error(
          'Parameter `startDate` is required when calling `getUsage`.'
        );
      }

      if (!endDate) {
        throw new Error(
          'Parameter `endDate` is required when calling `getUsage`.'
        );
      }

      const requestPath = '/1/usage/{statistic}'.replace(
        '{statistic}',
        encodeURIComponent(statistic)
      );
      const headers: Headers = {};
      const queryParameters: QueryParameters = {};

      if (startDate !== undefined) {
        queryParameters.startDate = startDate.toString();
      }

      if (endDate !== undefined) {
        queryParameters.endDate = endDate.toString();
      }

      if (granularity !== undefined) {
        queryParameters.granularity = granularity.toString();
      }

      const request: Request = {
        method: 'GET',
        path: requestPath,
        queryParameters,
        headers,
      };

      return transporter.request(request, requestOptions);
    },
  };
}
