//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using System;
using System.Text;
using System.Linq;
using System.Text.Json.Serialization;
using System.Collections.Generic;
using Algolia.Search.Serializer;
using System.Text.Json;

namespace Algolia.Search.Models.Usage;

/// <summary>
/// Defines Statistic
/// </summary>
public enum Statistic
{
  /// <summary>
  /// Enum Star for value: *
  /// </summary>
  [JsonPropertyName("*")]
  Star = 1,

  /// <summary>
  /// Enum SearchOperations for value: search_operations
  /// </summary>
  [JsonPropertyName("search_operations")]
  SearchOperations = 2,

  /// <summary>
  /// Enum TotalSearchOperations for value: total_search_operations
  /// </summary>
  [JsonPropertyName("total_search_operations")]
  TotalSearchOperations = 3,

  /// <summary>
  /// Enum TotalSearchRequests for value: total_search_requests
  /// </summary>
  [JsonPropertyName("total_search_requests")]
  TotalSearchRequests = 4,

  /// <summary>
  /// Enum QueriesOperations for value: queries_operations
  /// </summary>
  [JsonPropertyName("queries_operations")]
  QueriesOperations = 5,

  /// <summary>
  /// Enum MultiQueriesOperations for value: multi_queries_operations
  /// </summary>
  [JsonPropertyName("multi_queries_operations")]
  MultiQueriesOperations = 6,

  /// <summary>
  /// Enum AclOperations for value: acl_operations
  /// </summary>
  [JsonPropertyName("acl_operations")]
  AclOperations = 7,

  /// <summary>
  /// Enum TotalAclOperations for value: total_acl_operations
  /// </summary>
  [JsonPropertyName("total_acl_operations")]
  TotalAclOperations = 8,

  /// <summary>
  /// Enum GetApiKeysOperations for value: get_api_keys_operations
  /// </summary>
  [JsonPropertyName("get_api_keys_operations")]
  GetApiKeysOperations = 9,

  /// <summary>
  /// Enum GetApiKeyOperations for value: get_api_key_operations
  /// </summary>
  [JsonPropertyName("get_api_key_operations")]
  GetApiKeyOperations = 10,

  /// <summary>
  /// Enum AddApiKeyOperations for value: add_api_key_operations
  /// </summary>
  [JsonPropertyName("add_api_key_operations")]
  AddApiKeyOperations = 11,

  /// <summary>
  /// Enum UpdateApiKeyOperations for value: update_api_key_operations
  /// </summary>
  [JsonPropertyName("update_api_key_operations")]
  UpdateApiKeyOperations = 12,

  /// <summary>
  /// Enum DeleteApiKeyOperations for value: delete_api_key_operations
  /// </summary>
  [JsonPropertyName("delete_api_key_operations")]
  DeleteApiKeyOperations = 13,

  /// <summary>
  /// Enum ListApiKeyOperations for value: list_api_key_operations
  /// </summary>
  [JsonPropertyName("list_api_key_operations")]
  ListApiKeyOperations = 14,

  /// <summary>
  /// Enum IndexingOperations for value: indexing_operations
  /// </summary>
  [JsonPropertyName("indexing_operations")]
  IndexingOperations = 15,

  /// <summary>
  /// Enum TotalIndexingOperations for value: total_indexing_operations
  /// </summary>
  [JsonPropertyName("total_indexing_operations")]
  TotalIndexingOperations = 16,

  /// <summary>
  /// Enum BrowseOperations for value: browse_operations
  /// </summary>
  [JsonPropertyName("browse_operations")]
  BrowseOperations = 17,

  /// <summary>
  /// Enum ClearIndexOperations for value: clear_index_operations
  /// </summary>
  [JsonPropertyName("clear_index_operations")]
  ClearIndexOperations = 18,

  /// <summary>
  /// Enum CopyMoveOperations for value: copy_move_operations
  /// </summary>
  [JsonPropertyName("copy_move_operations")]
  CopyMoveOperations = 19,

  /// <summary>
  /// Enum DeleteIndexOperations for value: delete_index_operations
  /// </summary>
  [JsonPropertyName("delete_index_operations")]
  DeleteIndexOperations = 20,

  /// <summary>
  /// Enum GetLogOperations for value: get_log_operations
  /// </summary>
  [JsonPropertyName("get_log_operations")]
  GetLogOperations = 21,

  /// <summary>
  /// Enum GetSettingsOperations for value: get_settings_operations
  /// </summary>
  [JsonPropertyName("get_settings_operations")]
  GetSettingsOperations = 22,

  /// <summary>
  /// Enum SetSettingsOperations for value: set_settings_operations
  /// </summary>
  [JsonPropertyName("set_settings_operations")]
  SetSettingsOperations = 23,

  /// <summary>
  /// Enum ListIndicesOperations for value: list_indices_operations
  /// </summary>
  [JsonPropertyName("list_indices_operations")]
  ListIndicesOperations = 24,

  /// <summary>
  /// Enum WaitTaskOperations for value: wait_task_operations
  /// </summary>
  [JsonPropertyName("wait_task_operations")]
  WaitTaskOperations = 25,

  /// <summary>
  /// Enum RecordOperations for value: record_operations
  /// </summary>
  [JsonPropertyName("record_operations")]
  RecordOperations = 26,

  /// <summary>
  /// Enum TotalRecordsOperations for value: total_records_operations
  /// </summary>
  [JsonPropertyName("total_records_operations")]
  TotalRecordsOperations = 27,

  /// <summary>
  /// Enum AddRecordOperations for value: add_record_operations
  /// </summary>
  [JsonPropertyName("add_record_operations")]
  AddRecordOperations = 28,

  /// <summary>
  /// Enum BatchOperations for value: batch_operations
  /// </summary>
  [JsonPropertyName("batch_operations")]
  BatchOperations = 29,

  /// <summary>
  /// Enum DeleteByQueryOperations for value: delete_by_query_operations
  /// </summary>
  [JsonPropertyName("delete_by_query_operations")]
  DeleteByQueryOperations = 30,

  /// <summary>
  /// Enum DeleteRecordOperations for value: delete_record_operations
  /// </summary>
  [JsonPropertyName("delete_record_operations")]
  DeleteRecordOperations = 31,

  /// <summary>
  /// Enum GetRecordOperations for value: get_record_operations
  /// </summary>
  [JsonPropertyName("get_record_operations")]
  GetRecordOperations = 32,

  /// <summary>
  /// Enum PartialUpdateRecordOperations for value: partial_update_record_operations
  /// </summary>
  [JsonPropertyName("partial_update_record_operations")]
  PartialUpdateRecordOperations = 33,

  /// <summary>
  /// Enum UpdateRecordOperations for value: update_record_operations
  /// </summary>
  [JsonPropertyName("update_record_operations")]
  UpdateRecordOperations = 34,

  /// <summary>
  /// Enum SynonymOperations for value: synonym_operations
  /// </summary>
  [JsonPropertyName("synonym_operations")]
  SynonymOperations = 35,

  /// <summary>
  /// Enum TotalSynonymOperations for value: total_synonym_operations
  /// </summary>
  [JsonPropertyName("total_synonym_operations")]
  TotalSynonymOperations = 36,

  /// <summary>
  /// Enum BatchSynonymOperations for value: batch_synonym_operations
  /// </summary>
  [JsonPropertyName("batch_synonym_operations")]
  BatchSynonymOperations = 37,

  /// <summary>
  /// Enum ClearSynonymOperations for value: clear_synonym_operations
  /// </summary>
  [JsonPropertyName("clear_synonym_operations")]
  ClearSynonymOperations = 38,

  /// <summary>
  /// Enum DeleteSynonymOperations for value: delete_synonym_operations
  /// </summary>
  [JsonPropertyName("delete_synonym_operations")]
  DeleteSynonymOperations = 39,

  /// <summary>
  /// Enum GetSynonymOperations for value: get_synonym_operations
  /// </summary>
  [JsonPropertyName("get_synonym_operations")]
  GetSynonymOperations = 40,

  /// <summary>
  /// Enum QuerySynonymOperations for value: query_synonym_operations
  /// </summary>
  [JsonPropertyName("query_synonym_operations")]
  QuerySynonymOperations = 41,

  /// <summary>
  /// Enum UpdateSynonymOperations for value: update_synonym_operations
  /// </summary>
  [JsonPropertyName("update_synonym_operations")]
  UpdateSynonymOperations = 42,

  /// <summary>
  /// Enum RuleOperations for value: rule_operations
  /// </summary>
  [JsonPropertyName("rule_operations")]
  RuleOperations = 43,

  /// <summary>
  /// Enum TotalRulesOperations for value: total_rules_operations
  /// </summary>
  [JsonPropertyName("total_rules_operations")]
  TotalRulesOperations = 44,

  /// <summary>
  /// Enum BatchRulesOperations for value: batch_rules_operations
  /// </summary>
  [JsonPropertyName("batch_rules_operations")]
  BatchRulesOperations = 45,

  /// <summary>
  /// Enum ClearRulesOperations for value: clear_rules_operations
  /// </summary>
  [JsonPropertyName("clear_rules_operations")]
  ClearRulesOperations = 46,

  /// <summary>
  /// Enum DeleteRulesOperations for value: delete_rules_operations
  /// </summary>
  [JsonPropertyName("delete_rules_operations")]
  DeleteRulesOperations = 47,

  /// <summary>
  /// Enum GetRulesOperations for value: get_rules_operations
  /// </summary>
  [JsonPropertyName("get_rules_operations")]
  GetRulesOperations = 48,

  /// <summary>
  /// Enum SaveRulesOperations for value: save_rules_operations
  /// </summary>
  [JsonPropertyName("save_rules_operations")]
  SaveRulesOperations = 49,

  /// <summary>
  /// Enum SearchRulesOperations for value: search_rules_operations
  /// </summary>
  [JsonPropertyName("search_rules_operations")]
  SearchRulesOperations = 50,

  /// <summary>
  /// Enum TotalRecommendRequests for value: total_recommend_requests
  /// </summary>
  [JsonPropertyName("total_recommend_requests")]
  TotalRecommendRequests = 51,

  /// <summary>
  /// Enum TotalWriteOperations for value: total_write_operations
  /// </summary>
  [JsonPropertyName("total_write_operations")]
  TotalWriteOperations = 52,

  /// <summary>
  /// Enum TotalReadOperations for value: total_read_operations
  /// </summary>
  [JsonPropertyName("total_read_operations")]
  TotalReadOperations = 53,

  /// <summary>
  /// Enum TotalOperations for value: total_operations
  /// </summary>
  [JsonPropertyName("total_operations")]
  TotalOperations = 54,

  /// <summary>
  /// Enum QuerysuggestionsTotalSearchOperations for value: querysuggestions_total_search_operations
  /// </summary>
  [JsonPropertyName("querysuggestions_total_search_operations")]
  QuerysuggestionsTotalSearchOperations = 55,

  /// <summary>
  /// Enum QuerysuggestionsTotalSearchRequests for value: querysuggestions_total_search_requests
  /// </summary>
  [JsonPropertyName("querysuggestions_total_search_requests")]
  QuerysuggestionsTotalSearchRequests = 56,

  /// <summary>
  /// Enum QuerysuggestionsTotalAclOperations for value: querysuggestions_total_acl_operations
  /// </summary>
  [JsonPropertyName("querysuggestions_total_acl_operations")]
  QuerysuggestionsTotalAclOperations = 57,

  /// <summary>
  /// Enum QuerysuggestionsTotalIndexingOperations for value: querysuggestions_total_indexing_operations
  /// </summary>
  [JsonPropertyName("querysuggestions_total_indexing_operations")]
  QuerysuggestionsTotalIndexingOperations = 58,

  /// <summary>
  /// Enum QuerysuggestionsTotalRecordsOperations for value: querysuggestions_total_records_operations
  /// </summary>
  [JsonPropertyName("querysuggestions_total_records_operations")]
  QuerysuggestionsTotalRecordsOperations = 59,

  /// <summary>
  /// Enum QuerysuggestionsTotalSynonymOperations for value: querysuggestions_total_synonym_operations
  /// </summary>
  [JsonPropertyName("querysuggestions_total_synonym_operations")]
  QuerysuggestionsTotalSynonymOperations = 60,

  /// <summary>
  /// Enum QuerysuggestionsTotalRulesOperations for value: querysuggestions_total_rules_operations
  /// </summary>
  [JsonPropertyName("querysuggestions_total_rules_operations")]
  QuerysuggestionsTotalRulesOperations = 61,

  /// <summary>
  /// Enum QuerysuggestionsTotalWriteOperations for value: querysuggestions_total_write_operations
  /// </summary>
  [JsonPropertyName("querysuggestions_total_write_operations")]
  QuerysuggestionsTotalWriteOperations = 62,

  /// <summary>
  /// Enum QuerysuggestionsTotalReadOperations for value: querysuggestions_total_read_operations
  /// </summary>
  [JsonPropertyName("querysuggestions_total_read_operations")]
  QuerysuggestionsTotalReadOperations = 63,

  /// <summary>
  /// Enum QuerysuggestionsTotalOperations for value: querysuggestions_total_operations
  /// </summary>
  [JsonPropertyName("querysuggestions_total_operations")]
  QuerysuggestionsTotalOperations = 64,

  /// <summary>
  /// Enum AvgProcessingTime for value: avg_processing_time
  /// </summary>
  [JsonPropertyName("avg_processing_time")]
  AvgProcessingTime = 65,

  /// <summary>
  /// Enum _90pProcessingTime for value: 90p_processing_time
  /// </summary>
  [JsonPropertyName("90p_processing_time")]
  _90pProcessingTime = 66,

  /// <summary>
  /// Enum _99pProcessingTime for value: 99p_processing_time
  /// </summary>
  [JsonPropertyName("99p_processing_time")]
  _99pProcessingTime = 67,

  /// <summary>
  /// Enum QueriesAboveLastMsProcessingTime for value: queries_above_last_ms_processing_time
  /// </summary>
  [JsonPropertyName("queries_above_last_ms_processing_time")]
  QueriesAboveLastMsProcessingTime = 68,

  /// <summary>
  /// Enum Records for value: records
  /// </summary>
  [JsonPropertyName("records")]
  Records = 69,

  /// <summary>
  /// Enum DataSize for value: data_size
  /// </summary>
  [JsonPropertyName("data_size")]
  DataSize = 70,

  /// <summary>
  /// Enum FileSize for value: file_size
  /// </summary>
  [JsonPropertyName("file_size")]
  FileSize = 71,

  /// <summary>
  /// Enum MaxQps for value: max_qps
  /// </summary>
  [JsonPropertyName("max_qps")]
  MaxQps = 72,

  /// <summary>
  /// Enum RegionMaxQps for value: region_max_qps
  /// </summary>
  [JsonPropertyName("region_max_qps")]
  RegionMaxQps = 73,

  /// <summary>
  /// Enum TotalMaxQps for value: total_max_qps
  /// </summary>
  [JsonPropertyName("total_max_qps")]
  TotalMaxQps = 74,

  /// <summary>
  /// Enum UsedSearchCapacity for value: used_search_capacity
  /// </summary>
  [JsonPropertyName("used_search_capacity")]
  UsedSearchCapacity = 75,

  /// <summary>
  /// Enum AvgUsedSearchCapacity for value: avg_used_search_capacity
  /// </summary>
  [JsonPropertyName("avg_used_search_capacity")]
  AvgUsedSearchCapacity = 76,

  /// <summary>
  /// Enum RegionUsedSearchCapacity for value: region_used_search_capacity
  /// </summary>
  [JsonPropertyName("region_used_search_capacity")]
  RegionUsedSearchCapacity = 77,

  /// <summary>
  /// Enum RegionAvgUsedSearchCapacity for value: region_avg_used_search_capacity
  /// </summary>
  [JsonPropertyName("region_avg_used_search_capacity")]
  RegionAvgUsedSearchCapacity = 78,

  /// <summary>
  /// Enum TotalUsedSearchCapacity for value: total_used_search_capacity
  /// </summary>
  [JsonPropertyName("total_used_search_capacity")]
  TotalUsedSearchCapacity = 79,

  /// <summary>
  /// Enum TotalAvgUsedSearchCapacity for value: total_avg_used_search_capacity
  /// </summary>
  [JsonPropertyName("total_avg_used_search_capacity")]
  TotalAvgUsedSearchCapacity = 80,

  /// <summary>
  /// Enum DegradedQueriesSsdUsedQueriesImpacted for value: degraded_queries_ssd_used_queries_impacted
  /// </summary>
  [JsonPropertyName("degraded_queries_ssd_used_queries_impacted")]
  DegradedQueriesSsdUsedQueriesImpacted = 81,

  /// <summary>
  /// Enum DegradedQueriesSsdUsedSecondsImpacted for value: degraded_queries_ssd_used_seconds_impacted
  /// </summary>
  [JsonPropertyName("degraded_queries_ssd_used_seconds_impacted")]
  DegradedQueriesSsdUsedSecondsImpacted = 82,

  /// <summary>
  /// Enum DegradedQueriesMaxCapacityQueriesImpacted for value: degraded_queries_max_capacity_queries_impacted
  /// </summary>
  [JsonPropertyName("degraded_queries_max_capacity_queries_impacted")]
  DegradedQueriesMaxCapacityQueriesImpacted = 83,

  /// <summary>
  /// Enum DegradedQueriesMaxCapacitySecondsImpacted for value: degraded_queries_max_capacity_seconds_impacted
  /// </summary>
  [JsonPropertyName("degraded_queries_max_capacity_seconds_impacted")]
  DegradedQueriesMaxCapacitySecondsImpacted = 84
}

