# frozen_string_literal: true

require 'algolia'
require 'test/unit'

class TestSearchClient < Test::Unit::TestCase
  def setup
    @client = Algolia::SearchClient.create_with_config(
      Algolia::Configuration.new(
        'APP_ID',
        'API_KEY',
        [Algolia::Transport::StatefulHost.new('localhost')],
        'search',
        { requester: Algolia::Transport::EchoRequester.new }
      )
    )
  end

  # addApiKey
  def test_add_api_key0
    _, res = @client.add_api_key_with_http_info({ :acl => %w[search addObject],
                                                  :description => 'my new api key', :validity => 300, :maxQueriesPerIPPerHour => 100, :maxHitsPerQuery => 20 })

    assert_equal(:post, res.method)
    assert_equal('/1/keys', res.path)
    assert_equal(
      '{"acl":["search","addObject"],"description":"my new api key","validity":300,"maxQueriesPerIPPerHour":100,"maxHitsPerQuery":20}', res.body
    )
  end

  # addOrUpdateObject
  def test_add_or_update_object0
    _, res = @client.add_or_update_object_with_http_info('indexName', 'uniqueID', { :key => 'value' })

    assert_equal(:put, res.method)
    assert_equal('/1/indexes/indexName/uniqueID', res.path)
    assert_equal('{"key":"value"}', res.body)
  end

  # appendSource
  def test_append_source0
    _, res = @client.append_source_with_http_info({ :source => 'theSource', :description => 'theDescription' })

    assert_equal(:post, res.method)
    assert_equal('/1/security/sources/append', res.path)
    assert_equal('{"source":"theSource","description":"theDescription"}', res.body)
  end

  # assignUserId
  def test_assign_user_id0
    _, res = @client.assign_user_id_with_http_info('userID', { :cluster => 'theCluster' })

    assert_equal(:post, res.method)
    assert_equal('/1/clusters/mapping', res.path)
    assert_equal('{"cluster":"theCluster"}', res.body)
  end

  # allows batch method with `addObject` action
  def test_batch0
    _, res = @client.batch_with_http_info('theIndexName',
                                          { :requests => [{ :action => 'addObject', :body => { :key => 'value' } }] })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/theIndexName/batch', res.path)
    assert_equal('{"requests":[{"action":"addObject","body":{"key":"value"}}]}', res.body)
  end

  # allows batch method with `clear` action
  def test_batch1
    _, res = @client.batch_with_http_info('theIndexName',
                                          { :requests => [{ :action => 'clear', :body => { :key => 'value' } }] })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/theIndexName/batch', res.path)
    assert_equal('{"requests":[{"action":"clear","body":{"key":"value"}}]}', res.body)
  end

  # allows batch method with `delete` action
  def test_batch2
    _, res = @client.batch_with_http_info('theIndexName',
                                          { :requests => [{ :action => 'delete', :body => { :key => 'value' } }] })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/theIndexName/batch', res.path)
    assert_equal('{"requests":[{"action":"delete","body":{"key":"value"}}]}', res.body)
  end

  # allows batch method with `deleteObject` action
  def test_batch3
    _, res = @client.batch_with_http_info('theIndexName',
                                          { :requests => [{ :action => 'deleteObject',
                                                            :body => { :key => 'value' } }] })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/theIndexName/batch', res.path)
    assert_equal('{"requests":[{"action":"deleteObject","body":{"key":"value"}}]}', res.body)
  end

  # allows batch method with `partialUpdateObject` action
  def test_batch4
    _, res = @client.batch_with_http_info('theIndexName',
                                          { :requests => [{ :action => 'partialUpdateObject',
                                                            :body => { :key => 'value' } }] })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/theIndexName/batch', res.path)
    assert_equal('{"requests":[{"action":"partialUpdateObject","body":{"key":"value"}}]}', res.body)
  end

  # allows batch method with `partialUpdateObjectNoCreate` action
  def test_batch5
    _, res = @client.batch_with_http_info('theIndexName',
                                          { :requests => [{ :action => 'partialUpdateObjectNoCreate',
                                                            :body => { :key => 'value' } }] })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/theIndexName/batch', res.path)
    assert_equal('{"requests":[{"action":"partialUpdateObjectNoCreate","body":{"key":"value"}}]}', res.body)
  end

  # allows batch method with `updateObject` action
  def test_batch6
    _, res = @client.batch_with_http_info('theIndexName',
                                          { :requests => [{ :action => 'updateObject',
                                                            :body => { :key => 'value' } }] })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/theIndexName/batch', res.path)
    assert_equal('{"requests":[{"action":"updateObject","body":{"key":"value"}}]}', res.body)
  end

  # batchAssignUserIds
  def test_batch_assign_user_ids0
    _, res = @client.batch_assign_user_ids_with_http_info('userID',
                                                          { :cluster => 'theCluster', :users => %w[user1 user2] })

    assert_equal(:post, res.method)
    assert_equal('/1/clusters/mapping/batch', res.path)
    assert_equal('{"cluster":"theCluster","users":["user1","user2"]}', res.body)
  end

  # get batchDictionaryEntries results with minimal parameters
  def test_batch_dictionary_entries0
    _, res = @client.batch_dictionary_entries_with_http_info('compounds',
                                                             { :requests => [{ :action => 'addEntry', :body => { :objectID => '1', :language => 'en' } },
                                                                             { :action => 'deleteEntry',
                                                                               :body => { :objectID => '2',
                                                                                          :language => 'fr' } }] })

    assert_equal(:post, res.method)
    assert_equal('/1/dictionaries/compounds/batch', res.path)
    assert_equal(
      '{"requests":[{"action":"addEntry","body":{"objectID":"1","language":"en"}},{"action":"deleteEntry","body":{"objectID":"2","language":"fr"}}]}', res.body
    )
  end

  # get batchDictionaryEntries results with all parameters
  def test_batch_dictionary_entries1
    _, res = @client.batch_dictionary_entries_with_http_info('compounds',
                                                             { :clearExistingDictionaryEntries => false,
                                                               :requests => [
                                                                 { :action => 'addEntry',
                                                                   :body => { :objectID => '1', :language => 'en', :word => 'fancy', :words => %w[believe algolia],
                                                                              :decomposition => %w[trust algolia], :state => 'enabled' } }, { :action => 'deleteEntry', :body => { :objectID => '2', :language => 'fr', :word => 'humility', :words => %w[candor algolia], :decomposition => %w[grit algolia], :state => 'enabled' } }
                                                               ] })

    assert_equal(:post, res.method)
    assert_equal('/1/dictionaries/compounds/batch', res.path)
    assert_equal(
      '{"clearExistingDictionaryEntries":false,"requests":[{"action":"addEntry","body":{"objectID":"1","language":"en","word":"fancy","words":["believe","algolia"],"decomposition":["trust","algolia"],"state":"enabled"}},{"action":"deleteEntry","body":{"objectID":"2","language":"fr","word":"humility","words":["candor","algolia"],"decomposition":["grit","algolia"],"state":"enabled"}}]}', res.body
    )
  end

  # get batchDictionaryEntries results additional properties
  def test_batch_dictionary_entries2
    _, res = @client.batch_dictionary_entries_with_http_info('compounds',
                                                             { :requests => [{ :action => 'addEntry',
                                                                               :body => { :objectID => '1',
                                                                                          :language => 'en', :additional => 'try me' } }] })

    assert_equal(:post, res.method)
    assert_equal('/1/dictionaries/compounds/batch', res.path)
    assert_equal(
      '{"requests":[{"action":"addEntry","body":{"objectID":"1","language":"en","additional":"try me"}}]}', res.body
    )
  end

  # browse with minimal parameters
  def test_browse0
    _, res = @client.browse_with_http_info('indexName')

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/indexName/browse', res.path)
    assert_equal('{}', res.body)
  end

  # browse with search parameters
  def test_browse1
    _, res = @client.browse_with_http_info('indexName',
                                           { :query => 'myQuery', :facetFilters => ['tags:algolia'] })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/indexName/browse', res.path)
    assert_equal('{"query":"myQuery","facetFilters":["tags:algolia"]}', res.body)
  end

  # browse allow a cursor in parameters
  def test_browse2
    _, res = @client.browse_with_http_info('indexName', { :cursor => 'test' })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/indexName/browse', res.path)
    assert_equal('{"cursor":"test"}', res.body)
  end

  # clearAllSynonyms
  def test_clear_all_synonyms0
    _, res = @client.clear_all_synonyms_with_http_info('indexName')

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/indexName/synonyms/clear', res.path)
    assert_equal('', res.body)
  end

  # clearObjects
  def test_clear_objects0
    _, res = @client.clear_objects_with_http_info('theIndexName')

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/theIndexName/clear', res.path)
    assert_equal('', res.body)
  end

  # clearRules
  def test_clear_rules0
    _, res = @client.clear_rules_with_http_info('indexName')

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/indexName/rules/clear', res.path)
    assert_equal('', res.body)
  end

  # allow del method for a custom path with minimal parameters
  def test_custom_delete0
    _, res = @client.custom_delete_with_http_info('/test/minimal')

    assert_equal(:delete, res.method)
    assert_equal('/1/test/minimal', res.path)
    assert_equal('', res.body)
  end

  # allow del method for a custom path with all parameters
  def test_custom_delete1
    _, res = @client.custom_delete_with_http_info('/test/all', { :query => 'parameters' })

    assert_equal(:delete, res.method)
    assert_equal('/1/test/all', res.path)
    assert_equal('', res.body)
  end

  # allow get method for a custom path with minimal parameters
  def test_custom_get0
    _, res = @client.custom_get_with_http_info('/test/minimal')

    assert_equal(:get, res.method)
    assert_equal('/1/test/minimal', res.path)
    assert_equal('', res.body)
  end

  # allow get method for a custom path with all parameters
  def test_custom_get1
    _, res = @client.custom_get_with_http_info('/test/all', { :query => 'parameters' })

    assert_equal(:get, res.method)
    assert_equal('/1/test/all', res.path)
    assert_equal('', res.body)
  end

  # allow post method for a custom path with minimal parameters
  def test_custom_post0
    _, res = @client.custom_post_with_http_info('/test/minimal')

    assert_equal(:post, res.method)
    assert_equal('/1/test/minimal', res.path)
    assert_equal('{}', res.body)
  end

  # allow post method for a custom path with all parameters
  def test_custom_post1
    _, res = @client.custom_post_with_http_info('/test/all', { :query => 'parameters' },
                                                { :body => 'parameters' })

    assert_equal(:post, res.method)
    assert_equal('/1/test/all', res.path)
    assert_equal('{"body":"parameters"}', res.body)
  end

  # requestOptions can override default query parameters
  def test_custom_post2
    _, res = @client.custom_post_with_http_info('/test/requestOptions', { :query => 'parameters' },
                                                { :facet => 'filters' })

    assert_equal(:post, res.method)
    assert_equal('/1/test/requestOptions', res.path)
    assert_equal('{"facet":"filters"}', res.body)
  end

  # requestOptions merges query parameters with default ones
  def test_custom_post3
    _, res = @client.custom_post_with_http_info('/test/requestOptions', { :query => 'parameters' },
                                                { :facet => 'filters' })

    assert_equal(:post, res.method)
    assert_equal('/1/test/requestOptions', res.path)
    assert_equal('{"facet":"filters"}', res.body)
  end

  # requestOptions can override default headers
  def test_custom_post4
    _, res = @client.custom_post_with_http_info('/test/requestOptions', { :query => 'parameters' },
                                                { :facet => 'filters' })

    assert_equal(:post, res.method)
    assert_equal('/1/test/requestOptions', res.path)
    assert_equal('{"facet":"filters"}', res.body)
  end

  # requestOptions merges headers with default ones
  def test_custom_post5
    _, res = @client.custom_post_with_http_info('/test/requestOptions', { :query => 'parameters' },
                                                { :facet => 'filters' })

    assert_equal(:post, res.method)
    assert_equal('/1/test/requestOptions', res.path)
    assert_equal('{"facet":"filters"}', res.body)
  end

  # requestOptions queryParameters accepts booleans
  def test_custom_post6
    _, res = @client.custom_post_with_http_info('/test/requestOptions', { :query => 'parameters' },
                                                { :facet => 'filters' })

    assert_equal(:post, res.method)
    assert_equal('/1/test/requestOptions', res.path)
    assert_equal('{"facet":"filters"}', res.body)
  end

  # requestOptions queryParameters accepts integers
  def test_custom_post7
    _, res = @client.custom_post_with_http_info('/test/requestOptions', { :query => 'parameters' },
                                                { :facet => 'filters' })

    assert_equal(:post, res.method)
    assert_equal('/1/test/requestOptions', res.path)
    assert_equal('{"facet":"filters"}', res.body)
  end

  # requestOptions queryParameters accepts list of string
  def test_custom_post8
    _, res = @client.custom_post_with_http_info('/test/requestOptions', { :query => 'parameters' },
                                                { :facet => 'filters' })

    assert_equal(:post, res.method)
    assert_equal('/1/test/requestOptions', res.path)
    assert_equal('{"facet":"filters"}', res.body)
  end

  # requestOptions queryParameters accepts list of booleans
  def test_custom_post9
    _, res = @client.custom_post_with_http_info('/test/requestOptions', { :query => 'parameters' },
                                                { :facet => 'filters' })

    assert_equal(:post, res.method)
    assert_equal('/1/test/requestOptions', res.path)
    assert_equal('{"facet":"filters"}', res.body)
  end

  # requestOptions queryParameters accepts list of integers
  def test_custom_post10
    _, res = @client.custom_post_with_http_info('/test/requestOptions', { :query => 'parameters' },
                                                { :facet => 'filters' })

    assert_equal(:post, res.method)
    assert_equal('/1/test/requestOptions', res.path)
    assert_equal('{"facet":"filters"}', res.body)
  end

  # allow put method for a custom path with minimal parameters
  def test_custom_put0
    _, res = @client.custom_put_with_http_info('/test/minimal')

    assert_equal(:put, res.method)
    assert_equal('/1/test/minimal', res.path)
    assert_equal('{}', res.body)
  end

  # allow put method for a custom path with all parameters
  def test_custom_put1
    _, res = @client.custom_put_with_http_info('/test/all', { :query => 'parameters' },
                                               { :body => 'parameters' })

    assert_equal(:put, res.method)
    assert_equal('/1/test/all', res.path)
    assert_equal('{"body":"parameters"}', res.body)
  end

  # deleteApiKey
  def test_delete_api_key0
    _, res = @client.delete_api_key_with_http_info('myTestApiKey')

    assert_equal(:delete, res.method)
    assert_equal('/1/keys/myTestApiKey', res.path)
    assert_equal('', res.body)
  end

  # deleteBy
  def test_delete_by0
    _, res = @client.delete_by_with_http_info('theIndexName', { :filters => 'brand:brandName' })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/theIndexName/deleteByQuery', res.path)
    assert_equal('{"filters":"brand:brandName"}', res.body)
  end

  # deleteIndex
  def test_delete_index0
    _, res = @client.delete_index_with_http_info('theIndexName')

    assert_equal(:delete, res.method)
    assert_equal('/1/indexes/theIndexName', res.path)
    assert_equal('', res.body)
  end

  # deleteObject
  def test_delete_object0
    _, res = @client.delete_object_with_http_info('theIndexName', 'uniqueID')

    assert_equal(:delete, res.method)
    assert_equal('/1/indexes/theIndexName/uniqueID', res.path)
    assert_equal('', res.body)
  end

  # deleteRule
  def test_delete_rule0
    _, res = @client.delete_rule_with_http_info('indexName', 'id1')

    assert_equal(:delete, res.method)
    assert_equal('/1/indexes/indexName/rules/id1', res.path)
    assert_equal('', res.body)
  end

  # deleteSource
  def test_delete_source0
    _, res = @client.delete_source_with_http_info('theSource')

    assert_equal(:delete, res.method)
    assert_equal('/1/security/sources/theSource', res.path)
    assert_equal('', res.body)
  end

  # deleteSynonym
  def test_delete_synonym0
    _, res = @client.delete_synonym_with_http_info('indexName', 'id1')

    assert_equal(:delete, res.method)
    assert_equal('/1/indexes/indexName/synonyms/id1', res.path)
    assert_equal('', res.body)
  end

  # getApiKey
  def test_get_api_key0
    _, res = @client.get_api_key_with_http_info('myTestApiKey')

    assert_equal(:get, res.method)
    assert_equal('/1/keys/myTestApiKey', res.path)
    assert_equal('', res.body)
  end

  # get getDictionaryLanguages
  def test_get_dictionary_languages0
    _, res = @client.get_dictionary_languages_with_http_info

    assert_equal(:get, res.method)
    assert_equal('/1/dictionaries/*/languages', res.path)
    assert_equal('', res.body)
  end

  # get getDictionarySettings results
  def test_get_dictionary_settings0
    _, res = @client.get_dictionary_settings_with_http_info

    assert_equal(:get, res.method)
    assert_equal('/1/dictionaries/*/settings', res.path)
    assert_equal('', res.body)
  end

  # getLogs with minimal parameters
  def test_get_logs0
    _, res = @client.get_logs_with_http_info

    assert_equal(:get, res.method)
    assert_equal('/1/logs', res.path)
    assert_equal('', res.body)
  end

  # getLogs with parameters
  def test_get_logs1
    _, res = @client.get_logs_with_http_info(5, 10, 'theIndexName', 'all')

    assert_equal(:get, res.method)
    assert_equal('/1/logs', res.path)
    assert_equal('', res.body)
  end

  # getObject
  def test_get_object0
    _, res = @client.get_object_with_http_info('theIndexName', 'uniqueID', %w[attr1 attr2])

    assert_equal(:get, res.method)
    assert_equal('/1/indexes/theIndexName/uniqueID', res.path)
    assert_equal('', res.body)
  end

  # getObjects
  def test_get_objects0
    _, res = @client.get_objects_with_http_info({ :requests => [{
                                                  :attributesToRetrieve => %w[attr1
                                                                              attr2], :objectID => 'uniqueID', :indexName => 'theIndexName'
                                                }] })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/*/objects', res.path)
    assert_equal(
      '{"requests":[{"attributesToRetrieve":["attr1","attr2"],"objectID":"uniqueID","indexName":"theIndexName"}]}', res.body
    )
  end

  # getRule
  def test_get_rule0
    _, res = @client.get_rule_with_http_info('indexName', 'id1')

    assert_equal(:get, res.method)
    assert_equal('/1/indexes/indexName/rules/id1', res.path)
    assert_equal('', res.body)
  end

  # getSettings
  def test_get_settings0
    _, res = @client.get_settings_with_http_info('theIndexName')

    assert_equal(:get, res.method)
    assert_equal('/1/indexes/theIndexName/settings', res.path)
    assert_equal('', res.body)
  end

  # getSources
  def test_get_sources0
    _, res = @client.get_sources_with_http_info

    assert_equal(:get, res.method)
    assert_equal('/1/security/sources', res.path)
    assert_equal('', res.body)
  end

  # getSynonym
  def test_get_synonym0
    _, res = @client.get_synonym_with_http_info('indexName', 'id1')

    assert_equal(:get, res.method)
    assert_equal('/1/indexes/indexName/synonyms/id1', res.path)
    assert_equal('', res.body)
  end

  # getTask
  def test_get_task0
    _, res = @client.get_task_with_http_info('theIndexName', 123)

    assert_equal(:get, res.method)
    assert_equal('/1/indexes/theIndexName/task/123', res.path)
    assert_equal('', res.body)
  end

  # getTopUserIds
  def test_get_top_user_ids0
    _, res = @client.get_top_user_ids_with_http_info

    assert_equal(:get, res.method)
    assert_equal('/1/clusters/mapping/top', res.path)
    assert_equal('', res.body)
  end

  # getUserId
  def test_get_user_id0
    _, res = @client.get_user_id_with_http_info('uniqueID')

    assert_equal(:get, res.method)
    assert_equal('/1/clusters/mapping/uniqueID', res.path)
    assert_equal('', res.body)
  end

  # hasPendingMappings with minimal parameters
  def test_has_pending_mappings0
    _, res = @client.has_pending_mappings_with_http_info

    assert_equal(:get, res.method)
    assert_equal('/1/clusters/mapping/pending', res.path)
    assert_equal('', res.body)
  end

  # hasPendingMappings with parameters
  def test_has_pending_mappings1
    _, res = @client.has_pending_mappings_with_http_info(true)

    assert_equal(:get, res.method)
    assert_equal('/1/clusters/mapping/pending', res.path)
    assert_equal('', res.body)
  end

  # listApiKeys
  def test_list_api_keys0
    _, res = @client.list_api_keys_with_http_info

    assert_equal(:get, res.method)
    assert_equal('/1/keys', res.path)
    assert_equal('', res.body)
  end

  # listClusters
  def test_list_clusters0
    _, res = @client.list_clusters_with_http_info

    assert_equal(:get, res.method)
    assert_equal('/1/clusters', res.path)
    assert_equal('', res.body)
  end

  # listIndices with minimal parameters
  def test_list_indices0
    _, res = @client.list_indices_with_http_info

    assert_equal(:get, res.method)
    assert_equal('/1/indexes', res.path)
    assert_equal('', res.body)
  end

  # listIndices with parameters
  def test_list_indices1
    _, res = @client.list_indices_with_http_info(8, 3)

    assert_equal(:get, res.method)
    assert_equal('/1/indexes', res.path)
    assert_equal('', res.body)
  end

  # listUserIds with minimal parameters
  def test_list_user_ids0
    _, res = @client.list_user_ids_with_http_info

    assert_equal(:get, res.method)
    assert_equal('/1/clusters/mapping', res.path)
    assert_equal('', res.body)
  end

  # listUserIds with parameters
  def test_list_user_ids1
    _, res = @client.list_user_ids_with_http_info(8, 100)

    assert_equal(:get, res.method)
    assert_equal('/1/clusters/mapping', res.path)
    assert_equal('', res.body)
  end

  # multipleBatch
  def test_multiple_batch0
    _, res = @client.multiple_batch_with_http_info({ :requests => [{ :action => 'addObject',
                                                                     :body => { :key => 'value' }, :indexName => 'theIndexName' }] })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/*/batch', res.path)
    assert_equal('{"requests":[{"action":"addObject","body":{"key":"value"},"indexName":"theIndexName"}]}', res.body)
  end

  # operationIndex
  def test_operation_index0
    _, res = @client.operation_index_with_http_info('theIndexName',
                                                    { :operation => 'copy', :destination => 'dest',
                                                      :scope => %w[rules settings] })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/theIndexName/operation', res.path)
    assert_equal('{"operation":"copy","destination":"dest","scope":["rules","settings"]}', res.body)
  end

  # partialUpdateObject
  def test_partial_update_object0
    _, res = @client.partial_update_object_with_http_info('theIndexName', 'uniqueID',
                                                          { :id1 => 'test', :id2 => { :_operation => 'AddUnique', :value => 'test2' } }, true)

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/theIndexName/uniqueID/partial', res.path)
    assert_equal('{"id1":"test","id2":{"_operation":"AddUnique","value":"test2"}}', res.body)
  end

  # removeUserId
  def test_remove_user_id0
    _, res = @client.remove_user_id_with_http_info('uniqueID')

    assert_equal(:delete, res.method)
    assert_equal('/1/clusters/mapping/uniqueID', res.path)
    assert_equal('', res.body)
  end

  # replaceSources
  def test_replace_sources0
    _, res = @client.replace_sources_with_http_info([{ :source => 'theSource',
                                                       :description => 'theDescription' }])

    assert_equal(:put, res.method)
    assert_equal('/1/security/sources', res.path)
    assert_equal('[{"source":"theSource","description":"theDescription"}]', res.body)
  end

  # restoreApiKey
  def test_restore_api_key0
    _, res = @client.restore_api_key_with_http_info('myApiKey')

    assert_equal(:post, res.method)
    assert_equal('/1/keys/myApiKey/restore', res.path)
    assert_equal('', res.body)
  end

  # saveObject
  def test_save_object0
    _, res = @client.save_object_with_http_info('theIndexName', { :objectID => 'id', :test => 'val' })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/theIndexName', res.path)
    assert_equal('{"objectID":"id","test":"val"}', res.body)
  end

  # saveRule with minimal parameters
  def test_save_rule0
    _, res = @client.save_rule_with_http_info('indexName', 'id1',
                                              { :objectID => 'id1', :conditions => [{ :pattern => 'apple', :anchoring => 'contains' }] })

    assert_equal(:put, res.method)
    assert_equal('/1/indexes/indexName/rules/id1', res.path)
    assert_equal('{"objectID":"id1","conditions":[{"pattern":"apple","anchoring":"contains"}]}', res.body)
  end

  # saveRule with all parameters
  def test_save_rule1
    _, res = @client.save_rule_with_http_info('indexName', 'id1',
                                              { :objectID => 'id1', :conditions => [{ :pattern => 'apple', :anchoring => 'contains', :alternatives => false, :context => 'search' }], :consequence => { :params => { :filters => 'brand:apple', :query => { :remove => ['algolia'], :edits => [{ :type => 'remove', :delete => 'abc', :insert => 'cde' }, { :type => 'replace', :delete => 'abc', :insert => 'cde' }] } }, :hide => [{ :objectID => '321' }], :filterPromotes => false, :userData => { algolia: 'aloglia' }, :promote => [{ :objectID => 'abc', :position => 3 }, { :objectIDs => %w[abc def], :position => 1 }] }, :description => 'test', :enabled => true, :validity => [{ :from => 1_656_670_273, :until => 1_656_670_277 }] }, true)

    assert_equal(:put, res.method)
    assert_equal('/1/indexes/indexName/rules/id1', res.path)
    assert_equal(
      '{"objectID":"id1","conditions":[{"pattern":"apple","anchoring":"contains","alternatives":false,"context":"search"}],"consequence":{"params":{"filters":"brand:apple","query":{"remove":["algolia"],"edits":[{"type":"remove","delete":"abc","insert":"cde"},{"type":"replace","delete":"abc","insert":"cde"}]}},"hide":[{"objectID":"321"}],"filterPromotes":false,"userData":{"algolia":"aloglia"},"promote":[{"objectID":"abc","position":3},{"objectIDs":["abc","def"],"position":1}]},"description":"test","enabled":true,"validity":[{"from":1656670273,"until":1656670277}]}', res.body
    )
  end

  # saveRules with minimal parameters
  def test_save_rules0
    _, res = @client.save_rules_with_http_info('indexName',
                                               [{ :objectID => 'a-rule-id', :conditions => [{ :pattern => 'smartphone', :anchoring => 'contains' }] },
                                                { :objectID => 'a-second-rule-id',
                                                  :conditions => [{ :pattern => 'apple', :anchoring => 'contains' }] }])

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/indexName/rules/batch', res.path)
    assert_equal(
      '[{"objectID":"a-rule-id","conditions":[{"pattern":"smartphone","anchoring":"contains"}]},{"objectID":"a-second-rule-id","conditions":[{"pattern":"apple","anchoring":"contains"}]}]', res.body
    )
  end

  # saveRules with all parameters
  def test_save_rules1
    _, res = @client.save_rules_with_http_info('indexName',
                                               [{ :objectID => 'id1', :conditions => [{ :pattern => 'apple', :anchoring => 'contains', :alternatives => false, :context => 'search' }], :consequence => { :params => { :filters => 'brand:apple', :query => { :remove => ['algolia'], :edits => [{ :type => 'remove', :delete => 'abc', :insert => 'cde' }, { :type => 'replace', :delete => 'abc', :insert => 'cde' }] } }, :hide => [{ :objectID => '321' }], :filterPromotes => false, :userData => { algolia: 'aloglia' }, :promote => [{ :objectID => 'abc', :position => 3 }, { :objectIDs => %w[abc def], :position => 1 }] }, :description => 'test', :enabled => true, :validity => [{ :from => 1_656_670_273, :until => 1_656_670_277 }] }], true, true)

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/indexName/rules/batch', res.path)
    assert_equal(
      '[{"objectID":"id1","conditions":[{"pattern":"apple","anchoring":"contains","alternatives":false,"context":"search"}],"consequence":{"params":{"filters":"brand:apple","query":{"remove":["algolia"],"edits":[{"type":"remove","delete":"abc","insert":"cde"},{"type":"replace","delete":"abc","insert":"cde"}]}},"hide":[{"objectID":"321"}],"filterPromotes":false,"userData":{"algolia":"aloglia"},"promote":[{"objectID":"abc","position":3},{"objectIDs":["abc","def"],"position":1}]},"description":"test","enabled":true,"validity":[{"from":1656670273,"until":1656670277}]}]', res.body
    )
  end

  # saveSynonym
  def test_save_synonym0
    _, res = @client.save_synonym_with_http_info('indexName', 'id1',
                                                 { :objectID => 'id1', :type => 'synonym', :synonyms => %w[car vehicule auto] }, true)

    assert_equal(:put, res.method)
    assert_equal('/1/indexes/indexName/synonyms/id1', res.path)
    assert_equal('{"objectID":"id1","type":"synonym","synonyms":["car","vehicule","auto"]}', res.body)
  end

  # saveSynonyms
  def test_save_synonyms0
    _, res = @client.save_synonyms_with_http_info('indexName',
                                                  [{ :objectID => 'id1', :type => 'synonym', :synonyms => %w[car vehicule auto] }, { :objectID => 'id2', :type => 'onewaysynonym', :input => 'iphone', :synonyms => %w[ephone aphone yphone] }], true, false)

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/indexName/synonyms/batch', res.path)
    assert_equal(
      '[{"objectID":"id1","type":"synonym","synonyms":["car","vehicule","auto"]},{"objectID":"id2","type":"onewaysynonym","input":"iphone","synonyms":["ephone","aphone","yphone"]}]', res.body
    )
  end

  # search for a single hits request with minimal parameters
  def test_search0
    _, res = @client.search_with_http_info({ :requests => [{ :indexName => 'theIndexName' }] })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/*/queries', res.path)
    assert_equal('{"requests":[{"indexName":"theIndexName"}]}', res.body)
  end

  # search for a single facet request with minimal parameters
  def test_search1
    _, res = @client.search_with_http_info({
                                             :requests => [{ :indexName => 'theIndexName', :type => 'facet',
                                                             :facet => 'theFacet' }], :strategy => 'stopIfEnoughMatches'
                                           })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/*/queries', res.path)
    assert_equal(
      '{"requests":[{"indexName":"theIndexName","type":"facet","facet":"theFacet"}],"strategy":"stopIfEnoughMatches"}', res.body
    )
  end

  # search for a single hits request with all parameters
  def test_search2
    _, res = @client.search_with_http_info({ :requests => [{ :indexName => 'theIndexName',
                                                             :query => 'myQuery', :hitsPerPage => 50, :type => 'default' }] })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/*/queries', res.path)
    assert_equal('{"requests":[{"indexName":"theIndexName","query":"myQuery","hitsPerPage":50,"type":"default"}]}',
                 res.body)
  end

  # search for a single facet request with all parameters
  def test_search3
    _, res = @client.search_with_http_info({
                                             :requests => [{ :indexName => 'theIndexName', :type => 'facet', :facet => 'theFacet', :facetQuery => 'theFacetQuery',
                                                             :query => 'theQuery', :maxFacetHits => 50 }], :strategy => 'stopIfEnoughMatches'
                                           })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/*/queries', res.path)
    assert_equal(
      '{"requests":[{"indexName":"theIndexName","type":"facet","facet":"theFacet","facetQuery":"theFacetQuery","query":"theQuery","maxFacetHits":50}],"strategy":"stopIfEnoughMatches"}', res.body
    )
  end

  # search for multiple mixed requests in multiple indices with minimal parameters
  def test_search4
    _, res = @client.search_with_http_info({
                                             :requests => [{ :indexName => 'theIndexName' },
                                                           { :indexName => 'theIndexName2', :type => 'facet', :facet => 'theFacet' }, { :indexName => 'theIndexName', :type => 'default' }], :strategy => 'stopIfEnoughMatches'
                                           })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/*/queries', res.path)
    assert_equal(
      '{"requests":[{"indexName":"theIndexName"},{"indexName":"theIndexName2","type":"facet","facet":"theFacet"},{"indexName":"theIndexName","type":"default"}],"strategy":"stopIfEnoughMatches"}', res.body
    )
  end

  # search for multiple mixed requests in multiple indices with all parameters
  def test_search5
    _, res = @client.search_with_http_info({
                                             :requests => [
                                               { :indexName => 'theIndexName', :type => 'facet', :facet => 'theFacet', :facetQuery => 'theFacetQuery',
                                                 :query => 'theQuery', :maxFacetHits => 50 }, { :indexName => 'theIndexName', :query => 'myQuery', :hitsPerPage => 50, :type => 'default' }
                                             ], :strategy => 'stopIfEnoughMatches'
                                           })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/*/queries', res.path)
    assert_equal(
      '{"requests":[{"indexName":"theIndexName","type":"facet","facet":"theFacet","facetQuery":"theFacetQuery","query":"theQuery","maxFacetHits":50},{"indexName":"theIndexName","query":"myQuery","hitsPerPage":50,"type":"default"}],"strategy":"stopIfEnoughMatches"}', res.body
    )
  end

  # search filters accept all of the possible shapes
  def test_search6
    _, res = @client.search_with_http_info({ :requests => [
                                             { :indexName => 'theIndexName', :facetFilters => 'mySearch:filters', :reRankingApplyFilter => 'mySearch:filters',
                                               :tagFilters => 'mySearch:filters', :numericFilters => 'mySearch:filters', :optionalFilters => 'mySearch:filters' }, { :indexName => 'theIndexName', :facetFilters => ['mySearch:filters', ['mySearch:filters']], :reRankingApplyFilter => ['mySearch:filters', ['mySearch:filters']], :tagFilters => ['mySearch:filters', ['mySearch:filters']], :numericFilters => ['mySearch:filters', ['mySearch:filters']], :optionalFilters => ['mySearch:filters', ['mySearch:filters']] }
                                           ] })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/*/queries', res.path)
    assert_equal(
      '{"requests":[{"indexName":"theIndexName","facetFilters":"mySearch:filters","reRankingApplyFilter":"mySearch:filters","tagFilters":"mySearch:filters","numericFilters":"mySearch:filters","optionalFilters":"mySearch:filters"},{"indexName":"theIndexName","facetFilters":["mySearch:filters",["mySearch:filters"]],"reRankingApplyFilter":["mySearch:filters",["mySearch:filters"]],"tagFilters":["mySearch:filters",["mySearch:filters"]],"numericFilters":["mySearch:filters",["mySearch:filters"]],"optionalFilters":["mySearch:filters",["mySearch:filters"]]}]}', res.body
    )
  end

  # search with all search parameters
  def test_search7
    _, res = @client.search_with_http_info({ :requests => [{ :advancedSyntax => true,
                                                             :advancedSyntaxFeatures => ['exactPhrase'], :allowTyposOnNumericTokens => true, :alternativesAsExact => ['multiWordsSynonym'], :analytics => true, :analyticsTags => [''], :aroundLatLng => '', :aroundLatLngViaIP => true, :aroundPrecision => 0, :aroundRadius => 'all', :attributeCriteriaComputedByMinProximity => true, :attributesForFaceting => [''], :attributesToHighlight => [''], :attributesToRetrieve => [''], :attributesToSnippet => [''], :clickAnalytics => true, :customRanking => [''], :decompoundQuery => true, :disableExactOnAttributes => [''], :disableTypoToleranceOnAttributes => [''], :distinct => 0, :enableABTest => true, :enablePersonalization => true, :enableReRanking => true, :enableRules => true, :exactOnSingleWordQuery => 'attribute', :explain => %w[foo bar], :facetFilters => [''], :facetingAfterDistinct => true, :facets => [''], :filters => '', :getRankingInfo => true, :highlightPostTag => '', :highlightPreTag => '', :hitsPerPage => 0, :ignorePlurals => false, :indexName => 'theIndexName', :insideBoundingBox => [[47.3165, 4.9665, 47.3424, 5.0201], [40.9234, 2.1185, 38.643, 1.9916]], :insidePolygon => [[47.3165, 4.9665, 47.3424, 5.0201, 47.32, 4.9], [40.9234, 2.1185, 38.643, 1.9916, 39.2587, 2.0104]], :keepDiacriticsOnCharacters => '', :length => 0, :maxValuesPerFacet => 0, :minProximity => 0, :minWordSizefor1Typo => 0, :minWordSizefor2Typos => 0, :minimumAroundRadius => 0, :naturalLanguages => [''], :numericFilters => [''], :offset => 0, :optionalFilters => [''], :optionalWords => [''], :page => 0, :percentileComputation => true, :personalizationImpact => 0, :query => '', :queryLanguages => [''], :queryType => 'prefixAll', :ranking => [''], :reRankingApplyFilter => [''], :relevancyStrictness => 0, :removeStopWords => true, :removeWordsIfNoResults => 'allOptional', :renderingContent => { :facetOrdering => { :facets => { :order => %w[a b] }, :values => { :a => { :order => ['b'], :sortRemainingBy => 'count' } } } }, :replaceSynonymsInHighlight => true, :responseFields => [''], :restrictHighlightAndSnippetArrays => true, :restrictSearchableAttributes => [''], :ruleContexts => [''], :similarQuery => '', :snippetEllipsisText => '', :sortFacetValuesBy => '', :sumOrFiltersScores => true, :synonyms => true, :tagFilters => [''], :type => 'default', :typoTolerance => 'min', :userToken => '' }] })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/*/queries', res.path)
    assert_equal(
      '{"requests":[{"advancedSyntax":true,"advancedSyntaxFeatures":["exactPhrase"],"allowTyposOnNumericTokens":true,"alternativesAsExact":["multiWordsSynonym"],"analytics":true,"analyticsTags":[""],"aroundLatLng":"","aroundLatLngViaIP":true,"aroundPrecision":0,"aroundRadius":"all","attributeCriteriaComputedByMinProximity":true,"attributesForFaceting":[""],"attributesToHighlight":[""],"attributesToRetrieve":[""],"attributesToSnippet":[""],"clickAnalytics":true,"customRanking":[""],"decompoundQuery":true,"disableExactOnAttributes":[""],"disableTypoToleranceOnAttributes":[""],"distinct":0,"enableABTest":true,"enablePersonalization":true,"enableReRanking":true,"enableRules":true,"exactOnSingleWordQuery":"attribute","explain":["foo","bar"],"facetFilters":[""],"facetingAfterDistinct":true,"facets":[""],"filters":"","getRankingInfo":true,"highlightPostTag":"","highlightPreTag":"","hitsPerPage":0,"ignorePlurals":false,"indexName":"theIndexName","insideBoundingBox":[[47.3165,4.9665,47.3424,5.0201],[40.9234,2.1185,38.643,1.9916]],"insidePolygon":[[47.3165,4.9665,47.3424,5.0201,47.32,4.9],[40.9234,2.1185,38.643,1.9916,39.2587,2.0104]],"keepDiacriticsOnCharacters":"","length":0,"maxValuesPerFacet":0,"minProximity":0,"minWordSizefor1Typo":0,"minWordSizefor2Typos":0,"minimumAroundRadius":0,"naturalLanguages":[""],"numericFilters":[""],"offset":0,"optionalFilters":[""],"optionalWords":[""],"page":0,"percentileComputation":true,"personalizationImpact":0,"query":"","queryLanguages":[""],"queryType":"prefixAll","ranking":[""],"reRankingApplyFilter":[""],"relevancyStrictness":0,"removeStopWords":true,"removeWordsIfNoResults":"allOptional","renderingContent":{"facetOrdering":{"facets":{"order":["a","b"]},"values":{"a":{"order":["b"],"sortRemainingBy":"count"}}}},"replaceSynonymsInHighlight":true,"responseFields":[""],"restrictHighlightAndSnippetArrays":true,"restrictSearchableAttributes":[""],"ruleContexts":[""],"similarQuery":"","snippetEllipsisText":"","sortFacetValuesBy":"","sumOrFiltersScores":true,"synonyms":true,"tagFilters":[""],"type":"default","typoTolerance":"min","userToken":""}]}', res.body
    )
  end

  # get searchDictionaryEntries results with minimal parameters
  def test_search_dictionary_entries0
    _, res = @client.search_dictionary_entries_with_http_info('compounds', { :query => 'foo' })

    assert_equal(:post, res.method)
    assert_equal('/1/dictionaries/compounds/search', res.path)
    assert_equal('{"query":"foo"}', res.body)
  end

  # get searchDictionaryEntries results with all parameters
  def test_search_dictionary_entries1
    _, res = @client.search_dictionary_entries_with_http_info('compounds',
                                                              { :query => 'foo', :page => 4, :hitsPerPage => 2,
                                                                :language => 'fr' })

    assert_equal(:post, res.method)
    assert_equal('/1/dictionaries/compounds/search', res.path)
    assert_equal('{"query":"foo","page":4,"hitsPerPage":2,"language":"fr"}', res.body)
  end

  # get searchForFacetValues results with minimal parameters
  def test_search_for_facet_values0
    _, res = @client.search_for_facet_values_with_http_info('indexName', 'facetName')

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/indexName/facets/facetName/query', res.path)
    assert_equal('{}', res.body)
  end

  # get searchForFacetValues results with all parameters
  def test_search_for_facet_values1
    _, res = @client.search_for_facet_values_with_http_info('indexName', 'facetName',
                                                            { :params => "query=foo&facetFilters=['bar']", :facetQuery => 'foo', :maxFacetHits => 42 })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/indexName/facets/facetName/query', res.path)
    assert_equal(%q({"params":"query=foo&facetFilters=['bar']","facetQuery":"foo","maxFacetHits":42}), res.body)
  end

  # searchRules
  def test_search_rules0
    _, res = @client.search_rules_with_http_info('indexName', { :query => 'something' })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/indexName/rules/search', res.path)
    assert_equal('{"query":"something"}', res.body)
  end

  # search with minimal parameters
  def test_search_single_index0
    _, res = @client.search_single_index_with_http_info('indexName')

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/indexName/query', res.path)
    assert_equal('{}', res.body)
  end

  # search with searchParams
  def test_search_single_index1
    _, res = @client.search_single_index_with_http_info('indexName',
                                                        { :query => 'myQuery', :facetFilters => ['tags:algolia'] })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/indexName/query', res.path)
    assert_equal('{"query":"myQuery","facetFilters":["tags:algolia"]}', res.body)
  end

  # searchSynonyms with minimal parameters
  def test_search_synonyms0
    _, res = @client.search_synonyms_with_http_info('indexName')

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/indexName/synonyms/search', res.path)
    assert_equal('{}', res.body)
  end

  # searchSynonyms with all parameters
  def test_search_synonyms1
    _, res = @client.search_synonyms_with_http_info('indexName', 'altcorrection1', 10, 10,
                                                    { :query => 'myQuery' })

    assert_equal(:post, res.method)
    assert_equal('/1/indexes/indexName/synonyms/search', res.path)
    assert_equal('{"query":"myQuery"}', res.body)
  end

  # searchUserIds
  def test_search_user_ids0
    _, res = @client.search_user_ids_with_http_info({ :query => 'test', :clusterName => 'theClusterName',
                                                      :page => 5, :hitsPerPage => 10 })

    assert_equal(:post, res.method)
    assert_equal('/1/clusters/mapping/search', res.path)
    assert_equal('{"query":"test","clusterName":"theClusterName","page":5,"hitsPerPage":10}', res.body)
  end

  # get setDictionarySettings results with minimal parameters
  def test_set_dictionary_settings0
    _, res = @client.set_dictionary_settings_with_http_info({ :disableStandardEntries => { :plurals => {
                                                              :fr => false, :en => false, :ru => true
                                                            } } })

    assert_equal(:put, res.method)
    assert_equal('/1/dictionaries/*/settings', res.path)
    assert_equal('{"disableStandardEntries":{"plurals":{"fr":false,"en":false,"ru":true}}}', res.body)
  end

  # get setDictionarySettings results with all parameters
  def test_set_dictionary_settings1
    _, res = @client.set_dictionary_settings_with_http_info({ :disableStandardEntries => {
                                                              :plurals => { :fr => false, :en => false,
                                                                            :ru => true }, :stopwords => { :fr => false }, :compounds => { :ru => true }
                                                            } })

    assert_equal(:put, res.method)
    assert_equal('/1/dictionaries/*/settings', res.path)
    assert_equal(
      '{"disableStandardEntries":{"plurals":{"fr":false,"en":false,"ru":true},"stopwords":{"fr":false},"compounds":{"ru":true}}}', res.body
    )
  end

  # setSettings with minimal parameters
  def test_set_settings0
    _, res = @client.set_settings_with_http_info('theIndexName', { :paginationLimitedTo => 10 }, true)

    assert_equal(:put, res.method)
    assert_equal('/1/indexes/theIndexName/settings', res.path)
    assert_equal('{"paginationLimitedTo":10}', res.body)
  end

  # setSettings allow boolean `typoTolerance`
  def test_set_settings1
    _, res = @client.set_settings_with_http_info('theIndexName', { :typoTolerance => true }, true)

    assert_equal(:put, res.method)
    assert_equal('/1/indexes/theIndexName/settings', res.path)
    assert_equal('{"typoTolerance":true}', res.body)
  end

  # setSettings allow enum `typoTolerance`
  def test_set_settings2
    _, res = @client.set_settings_with_http_info('theIndexName', { :typoTolerance => 'min' }, true)

    assert_equal(:put, res.method)
    assert_equal('/1/indexes/theIndexName/settings', res.path)
    assert_equal('{"typoTolerance":"min"}', res.body)
  end

  # setSettings allow boolean `ignorePlurals`
  def test_set_settings3
    _, res = @client.set_settings_with_http_info('theIndexName', { :ignorePlurals => true }, true)

    assert_equal(:put, res.method)
    assert_equal('/1/indexes/theIndexName/settings', res.path)
    assert_equal('{"ignorePlurals":true}', res.body)
  end

  # setSettings allow list of string `ignorePlurals`
  def test_set_settings4
    _, res = @client.set_settings_with_http_info('theIndexName', { :ignorePlurals => ['algolia'] }, true)

    assert_equal(:put, res.method)
    assert_equal('/1/indexes/theIndexName/settings', res.path)
    assert_equal('{"ignorePlurals":["algolia"]}', res.body)
  end

  # setSettings allow boolean `removeStopWords`
  def test_set_settings5
    _, res = @client.set_settings_with_http_info('theIndexName', { :removeStopWords => true }, true)

    assert_equal(:put, res.method)
    assert_equal('/1/indexes/theIndexName/settings', res.path)
    assert_equal('{"removeStopWords":true}', res.body)
  end

  # setSettings allow list of string `removeStopWords`
  def test_set_settings6
    _, res = @client.set_settings_with_http_info('theIndexName', { :removeStopWords => ['algolia'] },
                                                 true)

    assert_equal(:put, res.method)
    assert_equal('/1/indexes/theIndexName/settings', res.path)
    assert_equal('{"removeStopWords":["algolia"]}', res.body)
  end

  # setSettings allow boolean `distinct`
  def test_set_settings7
    _, res = @client.set_settings_with_http_info('theIndexName', { :distinct => true }, true)

    assert_equal(:put, res.method)
    assert_equal('/1/indexes/theIndexName/settings', res.path)
    assert_equal('{"distinct":true}', res.body)
  end

  # setSettings allow integers for `distinct`
  def test_set_settings8
    _, res = @client.set_settings_with_http_info('theIndexName', { :distinct => 1 }, true)

    assert_equal(:put, res.method)
    assert_equal('/1/indexes/theIndexName/settings', res.path)
    assert_equal('{"distinct":1}', res.body)
  end

  # setSettings allow all `indexSettings`
  def test_set_settings9
    _, res = @client.set_settings_with_http_info('theIndexName',
                                                 { :advancedSyntax => true, :advancedSyntaxFeatures => ['exactPhrase'], :allowCompressionOfIntegerArray => true,
                                                   :allowTyposOnNumericTokens => true, :alternativesAsExact => ['singleWordSynonym'], :attributeCriteriaComputedByMinProximity => true, :attributeForDistinct => 'test', :attributesForFaceting => ['algolia'], :attributesToHighlight => ['algolia'], :attributesToRetrieve => ['algolia'], :attributesToSnippet => ['algolia'], :attributesToTransliterate => ['algolia'], :camelCaseAttributes => ['algolia'], :customNormalization => { :algolia => { :aloglia => 'aglolia' } }, :customRanking => ['algolia'], :decompoundQuery => false, :decompoundedAttributes => { :algolia => 'aloglia' }, :disableExactOnAttributes => ['algolia'], :disablePrefixOnAttributes => ['algolia'], :disableTypoToleranceOnAttributes => ['algolia'], :disableTypoToleranceOnWords => ['algolia'], :distinct => 3, :enablePersonalization => true, :enableReRanking => false, :enableRules => true, :exactOnSingleWordQuery => 'attribute', :highlightPreTag => '<span>', :highlightPostTag => '</span>', :hitsPerPage => 10, :ignorePlurals => false, :indexLanguages => ['algolia'], :keepDiacriticsOnCharacters => 'abc', :maxFacetHits => 20, :maxValuesPerFacet => 30, :minProximity => 6, :minWordSizefor1Typo => 5, :minWordSizefor2Typos => 11, :mode => 'neuralSearch', :numericAttributesForFiltering => ['algolia'], :optionalWords => ['myspace'], :paginationLimitedTo => 0, :queryLanguages => ['algolia'], :queryType => 'prefixLast', :ranking => ['geo'], :reRankingApplyFilter => 'mySearch:filters', :relevancyStrictness => 10, :removeStopWords => false, :removeWordsIfNoResults => 'lastWords', :renderingContent => { :facetOrdering => { :facets => { :order => %w[a b] }, :values => { :a => { :order => ['b'], :sortRemainingBy => 'count' } } } }, :replaceSynonymsInHighlight => true, :replicas => [''], :responseFields => ['algolia'], :restrictHighlightAndSnippetArrays => true, :searchableAttributes => ['foo'], :semanticSearch => { :eventSources => ['foo'] }, :separatorsToIndex => 'bar', :snippetEllipsisText => '---', :sortFacetValuesBy => 'date', :typoTolerance => false, :unretrievableAttributes => ['foo'], :userData => { :user => 'data' } })

    assert_equal(:put, res.method)
    assert_equal('/1/indexes/theIndexName/settings', res.path)
    assert_equal(
      '{"advancedSyntax":true,"advancedSyntaxFeatures":["exactPhrase"],"allowCompressionOfIntegerArray":true,"allowTyposOnNumericTokens":true,"alternativesAsExact":["singleWordSynonym"],"attributeCriteriaComputedByMinProximity":true,"attributeForDistinct":"test","attributesForFaceting":["algolia"],"attributesToHighlight":["algolia"],"attributesToRetrieve":["algolia"],"attributesToSnippet":["algolia"],"attributesToTransliterate":["algolia"],"camelCaseAttributes":["algolia"],"customNormalization":{"algolia":{"aloglia":"aglolia"}},"customRanking":["algolia"],"decompoundQuery":false,"decompoundedAttributes":{"algolia":"aloglia"},"disableExactOnAttributes":["algolia"],"disablePrefixOnAttributes":["algolia"],"disableTypoToleranceOnAttributes":["algolia"],"disableTypoToleranceOnWords":["algolia"],"distinct":3,"enablePersonalization":true,"enableReRanking":false,"enableRules":true,"exactOnSingleWordQuery":"attribute","highlightPreTag":"<span>","highlightPostTag":"</span>","hitsPerPage":10,"ignorePlurals":false,"indexLanguages":["algolia"],"keepDiacriticsOnCharacters":"abc","maxFacetHits":20,"maxValuesPerFacet":30,"minProximity":6,"minWordSizefor1Typo":5,"minWordSizefor2Typos":11,"mode":"neuralSearch","numericAttributesForFiltering":["algolia"],"optionalWords":["myspace"],"paginationLimitedTo":0,"queryLanguages":["algolia"],"queryType":"prefixLast","ranking":["geo"],"reRankingApplyFilter":"mySearch:filters","relevancyStrictness":10,"removeStopWords":false,"removeWordsIfNoResults":"lastWords","renderingContent":{"facetOrdering":{"facets":{"order":["a","b"]},"values":{"a":{"order":["b"],"sortRemainingBy":"count"}}}},"replaceSynonymsInHighlight":true,"replicas":[""],"responseFields":["algolia"],"restrictHighlightAndSnippetArrays":true,"searchableAttributes":["foo"],"semanticSearch":{"eventSources":["foo"]},"separatorsToIndex":"bar","snippetEllipsisText":"---","sortFacetValuesBy":"date","typoTolerance":false,"unretrievableAttributes":["foo"],"userData":{"user":"data"}}', res.body
    )
  end

  # updateApiKey
  def test_update_api_key0
    _, res = @client.update_api_key_with_http_info('myApiKey',
                                                   { :acl => %w[search addObject], :validity => 300,
                                                     :maxQueriesPerIPPerHour => 100, :maxHitsPerQuery => 20 })

    assert_equal(:put, res.method)
    assert_equal('/1/keys/myApiKey', res.path)
    assert_equal('{"acl":["search","addObject"],"validity":300,"maxQueriesPerIPPerHour":100,"maxHitsPerQuery":20}',
                 res.body)
  end
end
