require 'algolia'

# Snippet for the addApiKey method.
#
# addApiKey0
def snippet_for_add_api_key
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.add_api_key(
    ApiKey.new(
      acl: ['search', 'addObject'],
      description: "my new api key",
      validity: 300,
      max_queries_per_ip_per_hour: 100,
      max_hits_per_query: 20
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the addOrUpdateObject method.
#
# addOrUpdateObject0
def snippet_for_add_or_update_object
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.add_or_update_object("indexName", "uniqueID", { key: "value" })

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the appendSource method.
#
# appendSource0
def snippet_for_append_source
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.append_source(
    Source.new(
      source: "theSource",
      description: "theDescription"
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the assignUserId method.
#
# assignUserId0
def snippet_for_assign_user_id
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.assign_user_id("userID", AssignUserIdParams.new(cluster: "theCluster"))

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the batch method.
#
# allows batch method with `addObject` action
def snippet_for_batch
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.batch(
    "theIndexName",
    BatchWriteParams.new(requests: [BatchRequest.new(action: 'addObject', body: { key: "value" })])
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the batchAssignUserIds method.
#
# batchAssignUserIds0
def snippet_for_batch_assign_user_ids
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.batch_assign_user_ids(
    "userID",
    BatchAssignUserIdsParams.new(cluster: "theCluster", users: ["user1", "user2"])
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the batchDictionaryEntries method.
#
# get batchDictionaryEntries results with minimal parameters
def snippet_for_batch_dictionary_entries
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.batch_dictionary_entries(
    'compounds',
    BatchDictionaryEntriesParams.new(
      requests: [
        BatchDictionaryEntriesRequest.new(
          action: 'addEntry',
          body: DictionaryEntry.new(
            object_id: "1",
            language: "en"
          )
        ),
        BatchDictionaryEntriesRequest.new(
          action: 'deleteEntry',
          body: DictionaryEntry.new(object_id: "2", language: "fr")
        )
      ]
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the browse method.
#
# browse with minimal parameters
def snippet_for_browse
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.browse("cts_e2e_browse")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the clearObjects method.
#
# clearObjects0
def snippet_for_clear_objects
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.clear_objects("theIndexName")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the clearRules method.
#
# clearRules0
def snippet_for_clear_rules
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.clear_rules("indexName")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the clearSynonyms method.
#
# clearSynonyms0
def snippet_for_clear_synonyms
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.clear_synonyms("indexName")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the customDelete method.
#
# allow del method for a custom path with minimal parameters
def snippet_for_custom_delete
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.custom_delete("/test/minimal")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the customGet method.
#
# allow get method for a custom path with minimal parameters
def snippet_for_custom_get
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.custom_get("/test/minimal")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the customPost method.
#
# allow post method for a custom path with minimal parameters
def snippet_for_custom_post
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.custom_post("/test/minimal")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the customPut method.
#
# allow put method for a custom path with minimal parameters
def snippet_for_custom_put
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.custom_put("/test/minimal")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the deleteApiKey method.
#
# deleteApiKey0
def snippet_for_delete_api_key
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.delete_api_key("myTestApiKey")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the deleteBy method.
#
# deleteBy0
def snippet_for_delete_by
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.delete_by("theIndexName", DeleteByParams.new(filters: "brand:brandName"))

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the deleteIndex method.
#
# deleteIndex0
def snippet_for_delete_index
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.delete_index("theIndexName")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the deleteObject method.
#
# deleteObject0
def snippet_for_delete_object
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.delete_object("theIndexName", "uniqueID")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the deleteRule method.
#
# delete rule simple case
def snippet_for_delete_rule
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.delete_rule("indexName", "id1")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the deleteSource method.
#
# deleteSource0
def snippet_for_delete_source
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.delete_source("theSource")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the deleteSynonym method.
#
# deleteSynonym0
def snippet_for_delete_synonym
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.delete_synonym("indexName", "id1")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getApiKey method.
#
# getApiKey0
def snippet_for_get_api_key
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.get_api_key("myTestApiKey")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getDictionaryLanguages method.
#
# get getDictionaryLanguages
def snippet_for_get_dictionary_languages
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.get_dictionary_languages

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getDictionarySettings method.
#
# get getDictionarySettings results
def snippet_for_get_dictionary_settings
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.get_dictionary_settings

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getLogs method.
#
# getLogs with minimal parameters
def snippet_for_get_logs
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.get_logs

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getObject method.
#
# getObject0
def snippet_for_get_object
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.get_object("theIndexName", "uniqueID", ["attr1", "attr2"])

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getObjects method.
#
# getObjects0
def snippet_for_get_objects
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.get_objects(
    GetObjectsParams.new(
      requests: [GetObjectsRequest.new(
        attributes_to_retrieve: ["attr1",
          "attr2"],
        object_id: "uniqueID",
        index_name: "theIndexName"
      )]
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getRule method.
#
# getRule0
def snippet_for_get_rule
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.get_rule("indexName", "id1")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getSettings method.
#
# getSettings0
def snippet_for_get_settings
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.get_settings("cts_e2e_settings")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getSources method.
#
# getSources0
def snippet_for_get_sources
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.get_sources

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getSynonym method.
#
# getSynonym0
def snippet_for_get_synonym
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.get_synonym("indexName", "id1")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getTask method.
#
# getTask0
def snippet_for_get_task
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.get_task("theIndexName", 123)

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getTopUserIds method.
#
# getTopUserIds0
def snippet_for_get_top_user_ids
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.get_top_user_ids

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the getUserId method.
#
# getUserId0
def snippet_for_get_user_id
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.get_user_id("uniqueID")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the hasPendingMappings method.
#
# hasPendingMappings with minimal parameters
def snippet_for_has_pending_mappings
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.has_pending_mappings

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the listApiKeys method.
#
# listApiKeys0
def snippet_for_list_api_keys
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.list_api_keys

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the listClusters method.
#
# listClusters0
def snippet_for_list_clusters
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.list_clusters

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the listIndices method.
#
# listIndices with minimal parameters
def snippet_for_list_indices
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.list_indices

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the listUserIds method.
#
# listUserIds with minimal parameters
def snippet_for_list_user_ids
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.list_user_ids

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the multipleBatch method.
#
# multipleBatch0
def snippet_for_multiple_batch
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.multiple_batch(
    BatchParams.new(
      requests: [MultipleBatchRequest.new(
        action: 'addObject', body: { key: "value" }, index_name: "theIndexName"
      )]
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the operationIndex method.
#
# operationIndex0
def snippet_for_operation_index
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.operation_index(
    "theIndexName",
    OperationIndexParams.new(operation: 'copy', destination: "dest", scope: ['rules', 'settings'])
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the partialUpdateObject method.
#
# partialUpdateObject0
def snippet_for_partial_update_object
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.partial_update_object(
    "theIndexName",
    "uniqueID",
    { id1: "test", id2: BuiltInOperation.new(_operation: 'AddUnique', value: "test2") },
    true
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the removeUserId method.
#
# removeUserId0
def snippet_for_remove_user_id
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.remove_user_id("uniqueID")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the replaceSources method.
#
# replaceSources0
def snippet_for_replace_sources
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.replace_sources(
    [Source.new(
      source: "theSource",
      description: "theDescription"
    )]
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the restoreApiKey method.
#
# restoreApiKey0
def snippet_for_restore_api_key
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.restore_api_key("myApiKey")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the saveObject method.
#
# saveObject0
def snippet_for_save_object
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.save_object("theIndexName", { objectID: "id", test: "val" })

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the saveRule method.
#
# saveRule with minimal parameters
def snippet_for_save_rule
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.save_rule(
    "indexName",
    "id1",
    Rule.new(
      object_id: "id1",
      conditions: [Condition.new(pattern: "apple", anchoring: 'contains')]
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the saveRules method.
#
# saveRules with minimal parameters
def snippet_for_save_rules
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.save_rules(
    "indexName",
    [
      Rule.new(
        object_id: "a-rule-id",
        conditions: [Condition.new(
          pattern: "smartphone",
          anchoring: 'contains'
        )]
      ),
      Rule.new(
        object_id: "a-second-rule-id",
        conditions: [Condition.new(pattern: "apple", anchoring: 'contains')]
      )
    ]
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the saveSynonym method.
#
# saveSynonym0
def snippet_for_save_synonym
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.save_synonym(
    "indexName",
    "id1",
    SynonymHit.new(object_id: "id1", type: 'synonym', synonyms: ["car", "vehicule", "auto"]),
    true
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the saveSynonyms method.
#
# saveSynonyms0
def snippet_for_save_synonyms
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.save_synonyms(
    "indexName",
    [SynonymHit.new(object_id: "id1", type: 'synonym', synonyms: ["car", "vehicule", "auto"]),
      SynonymHit.new(
        object_id: "id2",
        type: 'onewaysynonym',
        input: "iphone",
        synonyms: ["ephone", "aphone", "yphone"]
      )],
    true,
    false
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the search method.
#
# search for a single hits request with minimal parameters
def snippet_for_search
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.search(SearchMethodParams.new(requests: [SearchForHits.new(index_name: "cts_e2e_search_empty_index")]))

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the searchDictionaryEntries method.
#
# get searchDictionaryEntries results with minimal parameters
def snippet_for_search_dictionary_entries
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.search_dictionary_entries(
    'compounds',
    SearchDictionaryEntriesParams.new(query: "foo")
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the searchForFacetValues method.
#
# get searchForFacetValues results with minimal parameters
def snippet_for_search_for_facet_values
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.search_for_facet_values("indexName", "facetName")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the searchRules method.
#
# searchRules0
def snippet_for_search_rules
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.search_rules("indexName", SearchRulesParams.new(query: "something"))

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the searchSingleIndex method.
#
# search with minimal parameters
def snippet_for_search_single_index
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.search_single_index("indexName")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the searchSynonyms method.
#
# searchSynonyms with minimal parameters
def snippet_for_search_synonyms
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.search_synonyms("indexName")

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the searchUserIds method.
#
# searchUserIds0
def snippet_for_search_user_ids
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.search_user_ids(
    SearchUserIdsParams.new(
      query: "test",
      cluster_name: "theClusterName",
      page: 5,
      hits_per_page: 10
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the setDictionarySettings method.
#
# get setDictionarySettings results with minimal parameters
def snippet_for_set_dictionary_settings
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.set_dictionary_settings(
    DictionarySettingsParams.new(
      disable_standard_entries: StandardEntries.new(
        plurals: {
          fr: false, en: false, ru: true
        }
      )
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the setSettings method.
#
# setSettings with minimal parameters
def snippet_for_set_settings
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.set_settings(
    "cts_e2e_settings",
    IndexSettings.new(pagination_limited_to: 10),
    true
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end

# Snippet for the updateApiKey method.
#
# updateApiKey0
def snippet_for_update_api_key
  # Initialize the client
  client = Algolia::SearchClient.create('YOUR_APP_ID', 'YOUR_API_KEY')

  # Call the API
  resp = client.update_api_key(
    "myApiKey",
    ApiKey.new(
      acl: ['search', 'addObject'],
      validity: 300,
      max_queries_per_ip_per_hour: 100,
      max_hits_per_query: 20
    )
  )

  # use the class directly
  puts resp

  # print the JSON response
  puts resp.to_json
end
