require 'algolia'
require 'test/unit'
require 'dotenv'
require_relative '../helpers'

Dotenv.load('../../.env')

class TestSearchClient < Test::Unit::TestCase
  include Algolia::Search
  def setup
    @client = Algolia::SearchClient.create(
      'APP_ID',
      'API_KEY',
      { requester: Algolia::Transport::EchoRequester.new }
    )

    @e2e_client = Algolia::SearchClient.create(
      ENV.fetch('ALGOLIA_APPLICATION_ID', nil),
      ENV.fetch('ALGOLIA_ADMIN_KEY', nil)
    )
  end

  # addApiKey0
  def test_add_api_key0
    req = @client.add_api_key_with_http_info(
      ApiKey.new(
        acl: ['search', 'addObject'],
        description: "my new api key",
        validity: 300,
        max_queries_per_ip_per_hour: 100,
        max_hits_per_query: 20
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/keys', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"acl":["search","addObject"],"description":"my new api key","validity":300,"maxQueriesPerIPPerHour":100,"maxHitsPerQuery":20}'), JSON.parse(req.body)
    )
  end

  # addOrUpdateObject0
  def test_add_or_update_object0
    req = @client.add_or_update_object_with_http_info(
      "indexName",
      "uniqueID",
      { key: "value" }
    )

    assert_equal(:put, req.method)
    assert_equal('/1/indexes/indexName/uniqueID', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"key":"value"}'), JSON.parse(req.body))
  end

  # appendSource0
  def test_append_source0
    req = @client.append_source_with_http_info(
      Source.new(
        source: "theSource",
        description: "theDescription"
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/security/sources/append', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"source":"theSource","description":"theDescription"}'),
      JSON.parse(req.body)
    )
  end

  # assignUserId0
  def test_assign_user_id0
    req = @client.assign_user_id_with_http_info(
      "userID",
      AssignUserIdParams.new(cluster: "theCluster")
    )

    assert_equal(:post, req.method)
    assert_equal('/1/clusters/mapping', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(
      ({ 'x-algolia-user-id': "userID" }.transform_keys(&:to_s).to_a - req.headers.to_a).empty?,
      req.headers.to_s
    )
    assert_equal(JSON.parse('{"cluster":"theCluster"}'), JSON.parse(req.body))
  end

  # allows batch method with `addObject` action
  def test_batch0
    req = @client.batch_with_http_info(
      "theIndexName",
      BatchWriteParams.new(
        requests: [BatchRequest.new(
          action: 'addObject',
          body: { key: "value" }
        )]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/theIndexName/batch', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"action":"addObject","body":{"key":"value"}}]}'),
      JSON.parse(req.body)
    )
  end

  # allows batch method with `clear` action
  def test_batch1
    req = @client.batch_with_http_info(
      "theIndexName",
      BatchWriteParams.new(requests: [BatchRequest.new(action: 'clear', body: { key: "value" })])
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/theIndexName/batch', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"action":"clear","body":{"key":"value"}}]}'),
      JSON.parse(req.body)
    )
  end

  # allows batch method with `delete` action
  def test_batch2
    req = @client.batch_with_http_info(
      "theIndexName",
      BatchWriteParams.new(requests: [BatchRequest.new(action: 'delete', body: { key: "value" })])
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/theIndexName/batch', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"action":"delete","body":{"key":"value"}}]}'),
      JSON.parse(req.body)
    )
  end

  # allows batch method with `deleteObject` action
  def test_batch3
    req = @client.batch_with_http_info(
      "theIndexName",
      BatchWriteParams.new(
        requests: [BatchRequest.new(
          action: 'deleteObject',
          body: { key: "value" }
        )]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/theIndexName/batch', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"action":"deleteObject","body":{"key":"value"}}]}'),
      JSON.parse(req.body)
    )
  end

  # allows batch method with `partialUpdateObject` action
  def test_batch4
    req = @client.batch_with_http_info(
      "theIndexName",
      BatchWriteParams.new(
        requests: [BatchRequest.new(
          action: 'partialUpdateObject',
          body: { key: "value" }
        )]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/theIndexName/batch', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"action":"partialUpdateObject","body":{"key":"value"}}]}'), JSON.parse(req.body)
    )
  end

  # allows batch method with `partialUpdateObjectNoCreate` action
  def test_batch5
    req = @client.batch_with_http_info(
      "theIndexName",
      BatchWriteParams.new(
        requests: [BatchRequest.new(
          action: 'partialUpdateObjectNoCreate',
          body: { key: "value" }
        )]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/theIndexName/batch', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"action":"partialUpdateObjectNoCreate","body":{"key":"value"}}]}'), JSON.parse(req.body)
    )
  end

  # allows batch method with `updateObject` action
  def test_batch6
    req = @client.batch_with_http_info(
      "theIndexName",
      BatchWriteParams.new(
        requests: [BatchRequest.new(
          action: 'updateObject',
          body: { key: "value" }
        )]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/theIndexName/batch', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"action":"updateObject","body":{"key":"value"}}]}'),
      JSON.parse(req.body)
    )
  end

  # batchAssignUserIds0
  def test_batch_assign_user_ids0
    req = @client.batch_assign_user_ids_with_http_info(
      "userID",
      BatchAssignUserIdsParams.new(cluster: "theCluster", users: ["user1", "user2"])
    )

    assert_equal(:post, req.method)
    assert_equal('/1/clusters/mapping/batch', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(
      ({ 'x-algolia-user-id': "userID" }.transform_keys(&:to_s).to_a - req.headers.to_a).empty?,
      req.headers.to_s
    )
    assert_equal(
      JSON.parse('{"cluster":"theCluster","users":["user1","user2"]}'),
      JSON.parse(req.body)
    )
  end

  # get batchDictionaryEntries results with minimal parameters
  def test_batch_dictionary_entries0
    req = @client.batch_dictionary_entries_with_http_info(
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

    assert_equal(:post, req.method)
    assert_equal('/1/dictionaries/compounds/batch', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"action":"addEntry","body":{"objectID":"1","language":"en"}},{"action":"deleteEntry","body":{"objectID":"2","language":"fr"}}]}'), JSON.parse(req.body)
    )
  end

  # get batchDictionaryEntries results with all parameters
  def test_batch_dictionary_entries1
    req = @client.batch_dictionary_entries_with_http_info(
      'compounds',
      BatchDictionaryEntriesParams.new(
        clear_existing_dictionary_entries: false,
        requests: [
          BatchDictionaryEntriesRequest.new(
            action: 'addEntry',
            body: DictionaryEntry.new(
              object_id: "1",
              language: "en",
              word: "fancy",
              words: ["believe", "algolia"],
              decomposition: ["trust", "algolia"],
              state: 'enabled'
            )
          ),
          BatchDictionaryEntriesRequest.new(
            action: 'deleteEntry',
            body: DictionaryEntry.new(
              object_id: "2",
              language: "fr",
              word: "humility",
              words: ["candor", "algolia"],
              decomposition: ["grit", "algolia"],
              state: 'enabled'
            )
          )
        ]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/dictionaries/compounds/batch', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"clearExistingDictionaryEntries":false,"requests":[{"action":"addEntry","body":{"objectID":"1","language":"en","word":"fancy","words":["believe","algolia"],"decomposition":["trust","algolia"],"state":"enabled"}},{"action":"deleteEntry","body":{"objectID":"2","language":"fr","word":"humility","words":["candor","algolia"],"decomposition":["grit","algolia"],"state":"enabled"}}]}'), JSON.parse(req.body)
    )
  end

  # get batchDictionaryEntries results additional properties
  def test_batch_dictionary_entries2
    req = @client.batch_dictionary_entries_with_http_info(
      'compounds',
      BatchDictionaryEntriesParams.new(
        requests: [BatchDictionaryEntriesRequest.new(
          action: 'addEntry',
          body: DictionaryEntry.new(object_id: "1", language: "en", additional: "try me")
        )]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/dictionaries/compounds/batch', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"action":"addEntry","body":{"objectID":"1","language":"en","additional":"try me"}}]}'), JSON.parse(req.body)
    )
  end

  # browse with minimal parameters
  def test_browse0
    req = @client.browse_with_http_info("cts_e2e_browse")

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/cts_e2e_browse/browse', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{}'), JSON.parse(req.body))

    res = @e2e_client.browse_with_http_info("cts_e2e_browse")

    assert_equal(res.status, 200)
    res = @e2e_client.browse("cts_e2e_browse")
    expected_body = JSON.parse('{"page":0,"nbHits":33191,"nbPages":34,"hitsPerPage":1000,"query":"","params":""}')
    assert_equal(expected_body, union(expected_body, JSON.parse(res.to_json)))
  end

  # browse with search parameters
  def test_browse1
    req = @client.browse_with_http_info(
      "indexName",
      BrowseParamsObject.new(query: "myQuery", facet_filters: ["tags:algolia"])
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/indexName/browse', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"query":"myQuery","facetFilters":["tags:algolia"]}'),
      JSON.parse(req.body)
    )
  end

  # browse allow a cursor in parameters
  def test_browse2
    req = @client.browse_with_http_info("indexName", BrowseParamsObject.new(cursor: "test"))

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/indexName/browse', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"cursor":"test"}'), JSON.parse(req.body))
  end

  # clearObjects0
  def test_clear_objects0
    req = @client.clear_objects_with_http_info("theIndexName")

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/theIndexName/clear', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
  end

  # clearRules0
  def test_clear_rules0
    req = @client.clear_rules_with_http_info("indexName")

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/indexName/rules/clear', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
  end

  # clearSynonyms0
  def test_clear_synonyms0
    req = @client.clear_synonyms_with_http_info("indexName")

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/indexName/synonyms/clear', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
  end

  # allow del method for a custom path with minimal parameters
  def test_custom_delete0
    req = @client.custom_delete_with_http_info("/test/minimal")

    assert_equal(:delete, req.method)
    assert_equal('/1/test/minimal', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # allow del method for a custom path with all parameters
  def test_custom_delete1
    req = @client.custom_delete_with_http_info("/test/all", { query: "parameters" })

    assert_equal(:delete, req.method)
    assert_equal('/1/test/all', req.path)
    assert(({ 'query': "parameters" }.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # allow get method for a custom path with minimal parameters
  def test_custom_get0
    req = @client.custom_get_with_http_info("/test/minimal")

    assert_equal(:get, req.method)
    assert_equal('/1/test/minimal', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # allow get method for a custom path with all parameters
  def test_custom_get1
    req = @client.custom_get_with_http_info("/test/all", { query: "parameters" })

    assert_equal(:get, req.method)
    assert_equal('/1/test/all', req.path)
    assert(({ 'query': "parameters" }.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # allow post method for a custom path with minimal parameters
  def test_custom_post0
    req = @client.custom_post_with_http_info("/test/minimal")

    assert_equal(:post, req.method)
    assert_equal('/1/test/minimal', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{}'), JSON.parse(req.body))
  end

  # allow post method for a custom path with all parameters
  def test_custom_post1
    req = @client.custom_post_with_http_info(
      "/test/all",
      { query: "parameters" },
      { body: "parameters" }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/all', req.path)
    assert(({ 'query': "parameters" }.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"body":"parameters"}'), JSON.parse(req.body))
  end

  # requestOptions can override default query parameters
  def test_custom_post2
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"query":"myQueryParameter"}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert(
      ({ 'query': "myQueryParameter" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions merges query parameters with default ones
  def test_custom_post3
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"query2":"myQueryParameter"}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert(
      ({ 'query': "parameters",
         'query2': "myQueryParameter" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions can override default headers
  def test_custom_post4
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :header_params => JSON.parse('{"x-algolia-api-key":"myApiKey"}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert(({ 'query': "parameters" }.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(
      ({ 'x-algolia-api-key': "myApiKey" }.transform_keys(&:to_s).to_a - req.headers.to_a).empty?, req.headers.to_s
    )
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions merges headers with default ones
  def test_custom_post5
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :header_params => JSON.parse('{"x-algolia-api-key":"myApiKey"}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert(({ 'query': "parameters" }.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(
      ({ 'x-algolia-api-key': "myApiKey" }.transform_keys(&:to_s).to_a - req.headers.to_a).empty?, req.headers.to_s
    )
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions queryParameters accepts booleans
  def test_custom_post6
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"isItWorking":true}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert(
      ({ 'query': "parameters", 'isItWorking': "true" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions queryParameters accepts integers
  def test_custom_post7
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"myParam":2}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert(
      ({ 'query': "parameters", 'myParam': "2" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions queryParameters accepts list of string
  def test_custom_post8
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"myParam":["c","d"]}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert(
      ({ 'query': "parameters", 'myParam': "c,d" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions queryParameters accepts list of booleans
  def test_custom_post9
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"myParam":[true,true,false]}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert(
      ({ 'query': "parameters",
         'myParam': "true,true,false" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # requestOptions queryParameters accepts list of integers
  def test_custom_post10
    req = @client.custom_post_with_http_info(
      "/test/requestOptions",
      { query: "parameters" },
      { facet: "filters" },
      { :query_params => JSON.parse('{"myParam":[1,2]}', :symbolize_names => true) }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/test/requestOptions', req.path)
    assert(
      ({ 'query': "parameters", 'myParam': "1,2" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"facet":"filters"}'), JSON.parse(req.body))
  end

  # allow put method for a custom path with minimal parameters
  def test_custom_put0
    req = @client.custom_put_with_http_info("/test/minimal")

    assert_equal(:put, req.method)
    assert_equal('/1/test/minimal', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{}'), JSON.parse(req.body))
  end

  # allow put method for a custom path with all parameters
  def test_custom_put1
    req = @client.custom_put_with_http_info(
      "/test/all",
      { query: "parameters" },
      { body: "parameters" }
    )

    assert_equal(:put, req.method)
    assert_equal('/1/test/all', req.path)
    assert(({ 'query': "parameters" }.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"body":"parameters"}'), JSON.parse(req.body))
  end

  # deleteApiKey0
  def test_delete_api_key0
    req = @client.delete_api_key_with_http_info("myTestApiKey")

    assert_equal(:delete, req.method)
    assert_equal('/1/keys/myTestApiKey', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # deleteBy0
  def test_delete_by0
    req = @client.delete_by_with_http_info(
      "theIndexName",
      DeleteByParams.new(filters: "brand:brandName")
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/theIndexName/deleteByQuery', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"filters":"brand:brandName"}'), JSON.parse(req.body))
  end

  # deleteIndex0
  def test_delete_index0
    req = @client.delete_index_with_http_info("theIndexName")

    assert_equal(:delete, req.method)
    assert_equal('/1/indexes/theIndexName', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # deleteObject0
  def test_delete_object0
    req = @client.delete_object_with_http_info("theIndexName", "uniqueID")

    assert_equal(:delete, req.method)
    assert_equal('/1/indexes/theIndexName/uniqueID', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # delete rule simple case
  def test_delete_rule0
    req = @client.delete_rule_with_http_info("indexName", "id1")

    assert_equal(:delete, req.method)
    assert_equal('/1/indexes/indexName/rules/id1', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # delete rule with simple characters to encode in objectID
  def test_delete_rule1
    req = @client.delete_rule_with_http_info("indexName", "test/with/slash")

    assert_equal(:delete, req.method)
    assert_equal('/1/indexes/indexName/rules/test%2Fwith%2Fslash', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # deleteSource0
  def test_delete_source0
    req = @client.delete_source_with_http_info("theSource")

    assert_equal(:delete, req.method)
    assert_equal('/1/security/sources/theSource', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # deleteSynonym0
  def test_delete_synonym0
    req = @client.delete_synonym_with_http_info("indexName", "id1")

    assert_equal(:delete, req.method)
    assert_equal('/1/indexes/indexName/synonyms/id1', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getApiKey0
  def test_get_api_key0
    req = @client.get_api_key_with_http_info("myTestApiKey")

    assert_equal(:get, req.method)
    assert_equal('/1/keys/myTestApiKey', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getDictionaryLanguages
  def test_get_dictionary_languages0
    req = @client.get_dictionary_languages_with_http_info

    assert_equal(:get, req.method)
    assert_equal('/1/dictionaries/*/languages', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # get getDictionarySettings results
  def test_get_dictionary_settings0
    req = @client.get_dictionary_settings_with_http_info

    assert_equal(:get, req.method)
    assert_equal('/1/dictionaries/*/settings', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getLogs with minimal parameters
  def test_get_logs0
    req = @client.get_logs_with_http_info

    assert_equal(:get, req.method)
    assert_equal('/1/logs', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getLogs with parameters
  def test_get_logs1
    req = @client.get_logs_with_http_info(5, 10, "theIndexName", 'all')

    assert_equal(:get, req.method)
    assert_equal('/1/logs', req.path)
    assert(
      ({ 'offset': "5",
         'length': "10",
         'indexName': "theIndexName",
         'type': "all" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getObject0
  def test_get_object0
    req = @client.get_object_with_http_info(
      "theIndexName",
      "uniqueID",
      ["attr1", "attr2"]
    )

    assert_equal(:get, req.method)
    assert_equal('/1/indexes/theIndexName/uniqueID', req.path)
    assert(
      ({ 'attributesToRetrieve': "attr1,attr2" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getObjects0
  def test_get_objects0
    req = @client.get_objects_with_http_info(
      GetObjectsParams.new(
        requests: [GetObjectsRequest.new(
          attributes_to_retrieve: ["attr1",
            "attr2"],
          object_id: "uniqueID",
          index_name: "theIndexName"
        )]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/*/objects', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"attributesToRetrieve":["attr1","attr2"],"objectID":"uniqueID","indexName":"theIndexName"}]}'), JSON.parse(req.body)
    )
  end

  # getRule0
  def test_get_rule0
    req = @client.get_rule_with_http_info("indexName", "id1")

    assert_equal(:get, req.method)
    assert_equal('/1/indexes/indexName/rules/id1', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getSettings0
  def test_get_settings0
    req = @client.get_settings_with_http_info("cts_e2e_settings")

    assert_equal(:get, req.method)
    assert_equal('/1/indexes/cts_e2e_settings/settings', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')

    res = @e2e_client.get_settings_with_http_info("cts_e2e_settings")

    assert_equal(res.status, 200)
    res = @e2e_client.get_settings("cts_e2e_settings")
    expected_body = JSON.parse('{"minWordSizefor1Typo":4,"minWordSizefor2Typos":8,"hitsPerPage":20,"maxValuesPerFacet":100,"paginationLimitedTo":10,"exactOnSingleWordQuery":"attribute","ranking":["typo","geo","words","filters","proximity","attribute","exact","custom"],"separatorsToIndex":"","removeWordsIfNoResults":"none","queryType":"prefixLast","highlightPreTag":"<em>","highlightPostTag":"</em>","alternativesAsExact":["ignorePlurals","singleWordSynonym"]}')
    assert_equal(expected_body, union(expected_body, JSON.parse(res.to_json)))
  end

  # getSources0
  def test_get_sources0
    req = @client.get_sources_with_http_info

    assert_equal(:get, req.method)
    assert_equal('/1/security/sources', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getSynonym0
  def test_get_synonym0
    req = @client.get_synonym_with_http_info("indexName", "id1")

    assert_equal(:get, req.method)
    assert_equal('/1/indexes/indexName/synonyms/id1', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getTask0
  def test_get_task0
    req = @client.get_task_with_http_info("theIndexName", 123)

    assert_equal(:get, req.method)
    assert_equal('/1/indexes/theIndexName/task/123', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getTopUserIds0
  def test_get_top_user_ids0
    req = @client.get_top_user_ids_with_http_info

    assert_equal(:get, req.method)
    assert_equal('/1/clusters/mapping/top', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # getUserId0
  def test_get_user_id0
    req = @client.get_user_id_with_http_info("uniqueID")

    assert_equal(:get, req.method)
    assert_equal('/1/clusters/mapping/uniqueID', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # hasPendingMappings with minimal parameters
  def test_has_pending_mappings0
    req = @client.has_pending_mappings_with_http_info

    assert_equal(:get, req.method)
    assert_equal('/1/clusters/mapping/pending', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # hasPendingMappings with parameters
  def test_has_pending_mappings1
    req = @client.has_pending_mappings_with_http_info(true)

    assert_equal(:get, req.method)
    assert_equal('/1/clusters/mapping/pending', req.path)
    assert(({ 'getClusters': "true" }.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # listApiKeys0
  def test_list_api_keys0
    req = @client.list_api_keys_with_http_info

    assert_equal(:get, req.method)
    assert_equal('/1/keys', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # listClusters0
  def test_list_clusters0
    req = @client.list_clusters_with_http_info

    assert_equal(:get, req.method)
    assert_equal('/1/clusters', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # listIndices with minimal parameters
  def test_list_indices0
    req = @client.list_indices_with_http_info

    assert_equal(:get, req.method)
    assert_equal('/1/indexes', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # listIndices with parameters
  def test_list_indices1
    req = @client.list_indices_with_http_info(8, 3)

    assert_equal(:get, req.method)
    assert_equal('/1/indexes', req.path)
    assert(
      ({ 'page': "8", 'hitsPerPage': "3" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # listUserIds with minimal parameters
  def test_list_user_ids0
    req = @client.list_user_ids_with_http_info

    assert_equal(:get, req.method)
    assert_equal('/1/clusters/mapping', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # listUserIds with parameters
  def test_list_user_ids1
    req = @client.list_user_ids_with_http_info(8, 100)

    assert_equal(:get, req.method)
    assert_equal('/1/clusters/mapping', req.path)
    assert(
      ({ 'page': "8", 'hitsPerPage': "100" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # multipleBatch0
  def test_multiple_batch0
    req = @client.multiple_batch_with_http_info(
      BatchParams.new(
        requests: [MultipleBatchRequest.new(
          action: 'addObject', body: { key: "value" }, index_name: "theIndexName"
        )]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/*/batch', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"action":"addObject","body":{"key":"value"},"indexName":"theIndexName"}]}'), JSON.parse(req.body)
    )
  end

  # operationIndex0
  def test_operation_index0
    req = @client.operation_index_with_http_info(
      "theIndexName",
      OperationIndexParams.new(
        operation: 'copy',
        destination: "dest",
        scope: ['rules', 'settings']
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/theIndexName/operation', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"operation":"copy","destination":"dest","scope":["rules","settings"]}'), JSON.parse(req.body)
    )
  end

  # partialUpdateObject0
  def test_partial_update_object0
    req = @client.partial_update_object_with_http_info(
      "theIndexName",
      "uniqueID",
      { id1: "test", id2: BuiltInOperation.new(_operation: 'AddUnique', value: "test2") },
      true
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/theIndexName/uniqueID/partial', req.path)
    assert(
      ({ 'createIfNotExists': "true" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"id1":"test","id2":{"_operation":"AddUnique","value":"test2"}}'),
      JSON.parse(req.body)
    )
  end

  # removeUserId0
  def test_remove_user_id0
    req = @client.remove_user_id_with_http_info("uniqueID")

    assert_equal(:delete, req.method)
    assert_equal('/1/clusters/mapping/uniqueID', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)

    assert(req.body.nil?, 'body is not nil')
  end

  # replaceSources0
  def test_replace_sources0
    req = @client.replace_sources_with_http_info(
      [Source.new(
        source: "theSource",
        description: "theDescription"
      )]
    )

    assert_equal(:put, req.method)
    assert_equal('/1/security/sources', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('[{"source":"theSource","description":"theDescription"}]'),
      JSON.parse(req.body)
    )
  end

  # restoreApiKey0
  def test_restore_api_key0
    req = @client.restore_api_key_with_http_info("myApiKey")

    assert_equal(:post, req.method)
    assert_equal('/1/keys/myApiKey/restore', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
  end

  # saveObject0
  def test_save_object0
    req = @client.save_object_with_http_info(
      "theIndexName",
      { objectID: "id", test: "val" }
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/theIndexName', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"objectID":"id","test":"val"}'), JSON.parse(req.body))
  end

  # saveRule with minimal parameters
  def test_save_rule0
    req = @client.save_rule_with_http_info(
      "indexName",
      "id1",
      Rule.new(
        object_id: "id1",
        conditions: [Condition.new(pattern: "apple", anchoring: 'contains')]
      )
    )

    assert_equal(:put, req.method)
    assert_equal('/1/indexes/indexName/rules/id1', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"objectID":"id1","conditions":[{"pattern":"apple","anchoring":"contains"}]}'), JSON.parse(req.body)
    )
  end

  # saveRule with all parameters
  def test_save_rule1
    req = @client.save_rule_with_http_info(
      "indexName",
      "id1",
      Rule.new(
        object_id: "id1",
        conditions: [Condition.new(
          pattern: "apple",
          anchoring: 'contains',
          alternatives: false,
          context: "search"
        )],
        consequence: Consequence.new(
          params: ConsequenceParams.new(
            filters: "brand:apple",
            query: ConsequenceQueryObject.new(
              remove: ["algolia"],
              edits: [Edit.new(type: 'remove', delete: "abc", insert: "cde"),
                Edit.new(type: 'replace', delete: "abc", insert: "cde")]
            )
          ),
          hide: [ConsequenceHide.new(object_id: "321")],
          filter_promotes: false,
          user_data: { 'algolia': "aloglia" },
          promote: [PromoteObjectID.new(object_id: "abc", position: 3),
            PromoteObjectIDs.new(object_ids: ["abc", "def"], position: 1)]
        ),
        description: "test",
        enabled: true,
        validity: [TimeRange.new(from: 1_656_670_273, _until: 1_656_670_277)]
      ),
      true
    )

    assert_equal(:put, req.method)
    assert_equal('/1/indexes/indexName/rules/id1', req.path)
    assert(
      ({ 'forwardToReplicas': "true" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"objectID":"id1","conditions":[{"pattern":"apple","anchoring":"contains","alternatives":false,"context":"search"}],"consequence":{"params":{"filters":"brand:apple","query":{"remove":["algolia"],"edits":[{"type":"remove","delete":"abc","insert":"cde"},{"type":"replace","delete":"abc","insert":"cde"}]}},"hide":[{"objectID":"321"}],"filterPromotes":false,"userData":{"algolia":"aloglia"},"promote":[{"objectID":"abc","position":3},{"objectIDs":["abc","def"],"position":1}]},"description":"test","enabled":true,"validity":[{"from":1656670273,"until":1656670277}]}'), JSON.parse(req.body)
    )
  end

  # saveRules with minimal parameters
  def test_save_rules0
    req = @client.save_rules_with_http_info(
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

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/indexName/rules/batch', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('[{"objectID":"a-rule-id","conditions":[{"pattern":"smartphone","anchoring":"contains"}]},{"objectID":"a-second-rule-id","conditions":[{"pattern":"apple","anchoring":"contains"}]}]'), JSON.parse(req.body)
    )
  end

  # saveRules with all parameters
  def test_save_rules1
    req = @client.save_rules_with_http_info(
      "indexName",
      [Rule.new(
        object_id: "id1",
        conditions: [Condition.new(
          pattern: "apple",
          anchoring: 'contains',
          alternatives: false,
          context: "search"
        )],
        consequence: Consequence.new(
          params: ConsequenceParams.new(
            filters: "brand:apple",
            query: ConsequenceQueryObject.new(
              remove: ["algolia"],
              edits: [Edit.new(type: 'remove', delete: "abc", insert: "cde"),
                Edit.new(type: 'replace', delete: "abc", insert: "cde")]
            )
          ),
          hide: [ConsequenceHide.new(object_id: "321")],
          filter_promotes: false,
          user_data: { 'algolia': "aloglia" },
          promote: [PromoteObjectID.new(object_id: "abc", position: 3),
            PromoteObjectIDs.new(object_ids: ["abc", "def"], position: 1)]
        ),
        description: "test",
        enabled: true,
        validity: [TimeRange.new(from: 1_656_670_273, _until: 1_656_670_277)]
      )],
      true,
      true
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/indexName/rules/batch', req.path)
    assert(
      ({ 'forwardToReplicas': "true",
         'clearExistingRules': "true" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('[{"objectID":"id1","conditions":[{"pattern":"apple","anchoring":"contains","alternatives":false,"context":"search"}],"consequence":{"params":{"filters":"brand:apple","query":{"remove":["algolia"],"edits":[{"type":"remove","delete":"abc","insert":"cde"},{"type":"replace","delete":"abc","insert":"cde"}]}},"hide":[{"objectID":"321"}],"filterPromotes":false,"userData":{"algolia":"aloglia"},"promote":[{"objectID":"abc","position":3},{"objectIDs":["abc","def"],"position":1}]},"description":"test","enabled":true,"validity":[{"from":1656670273,"until":1656670277}]}]'), JSON.parse(req.body)
    )
  end

  # saveSynonym0
  def test_save_synonym0
    req = @client.save_synonym_with_http_info(
      "indexName",
      "id1",
      SynonymHit.new(object_id: "id1", type: 'synonym', synonyms: ["car", "vehicule", "auto"]),
      true
    )

    assert_equal(:put, req.method)
    assert_equal('/1/indexes/indexName/synonyms/id1', req.path)
    assert(
      ({ 'forwardToReplicas': "true" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"objectID":"id1","type":"synonym","synonyms":["car","vehicule","auto"]}'), JSON.parse(req.body)
    )
  end

  # saveSynonyms0
  def test_save_synonyms0
    req = @client.save_synonyms_with_http_info(
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

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/indexName/synonyms/batch', req.path)
    assert(
      ({ 'forwardToReplicas': "true",
         'replaceExistingSynonyms': "false" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('[{"objectID":"id1","type":"synonym","synonyms":["car","vehicule","auto"]},{"objectID":"id2","type":"onewaysynonym","input":"iphone","synonyms":["ephone","aphone","yphone"]}]'), JSON.parse(req.body)
    )
  end

  # search for a single hits request with minimal parameters
  def test_search0
    req = @client.search_with_http_info(SearchMethodParams.new(requests: [SearchForHits.new(index_name: "cts_e2e_search_empty_index")]))

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/*/queries', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"indexName":"cts_e2e_search_empty_index"}]}'),
      JSON.parse(req.body)
    )

    res = @e2e_client.search_with_http_info(SearchMethodParams.new(requests: [SearchForHits.new(index_name: "cts_e2e_search_empty_index")]))

    assert_equal(res.status, 200)
    res = @e2e_client.search(SearchMethodParams.new(requests: [SearchForHits.new(index_name: "cts_e2e_search_empty_index")]))
    expected_body = JSON.parse('{"results":[{"hits":[],"page":0,"nbHits":0,"nbPages":0,"hitsPerPage":20,"exhaustiveNbHits":true,"exhaustiveTypo":true,"exhaustive":{"nbHits":true,"typo":true},"query":"","params":"","index":"cts_e2e_search_empty_index","renderingContent":{}}]}')
    assert_equal(expected_body, union(expected_body, JSON.parse(res.to_json)))
  end

  # search for a single facet request with minimal parameters
  def test_search1
    req = @client.search_with_http_info(
      SearchMethodParams.new(
        requests: [SearchForFacets.new(
          index_name: "cts_e2e_search_facet",
          type: 'facet',
          facet: "editor"
        )],
        strategy: 'stopIfEnoughMatches'
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/*/queries', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"indexName":"cts_e2e_search_facet","type":"facet","facet":"editor"}],"strategy":"stopIfEnoughMatches"}'), JSON.parse(req.body)
    )

    res = @e2e_client.search_with_http_info(
      SearchMethodParams.new(
        requests: [SearchForFacets.new(
          index_name: "cts_e2e_search_facet",
          type: 'facet',
          facet: "editor"
        )],
        strategy: 'stopIfEnoughMatches'
      )
    )

    assert_equal(res.status, 200)
    res = @e2e_client.search(
      SearchMethodParams.new(
        requests: [SearchForFacets.new(
          index_name: "cts_e2e_search_facet",
          type: 'facet',
          facet: "editor"
        )],
        strategy: 'stopIfEnoughMatches'
      )
    )
    expected_body = JSON.parse('{"results":[{"exhaustiveFacetsCount":true,"facetHits":[{"count":1,"highlighted":"goland","value":"goland"},{"count":1,"highlighted":"neovim","value":"neovim"},{"count":1,"highlighted":"vscode","value":"vscode"}]}]}')
    assert_equal(expected_body, union(expected_body, JSON.parse(res.to_json)))
  end

  # search for a single hits request with all parameters
  def test_search2
    req = @client.search_with_http_info(
      SearchMethodParams.new(
        requests: [SearchForHits.new(
          index_name: "theIndexName", query: "myQuery", hits_per_page: 50, type: 'default'
        )]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/*/queries', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"indexName":"theIndexName","query":"myQuery","hitsPerPage":50,"type":"default"}]}'), JSON.parse(req.body)
    )
  end

  # search for a single facet request with all parameters
  def test_search3
    req = @client.search_with_http_info(
      SearchMethodParams.new(
        requests: [SearchForFacets.new(
          index_name: "theIndexName",
          type: 'facet',
          facet: "theFacet",
          facet_query: "theFacetQuery",
          query: "theQuery",
          max_facet_hits: 50
        )],
        strategy: 'stopIfEnoughMatches'
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/*/queries', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"indexName":"theIndexName","type":"facet","facet":"theFacet","facetQuery":"theFacetQuery","query":"theQuery","maxFacetHits":50}],"strategy":"stopIfEnoughMatches"}'), JSON.parse(req.body)
    )
  end

  # search for multiple mixed requests in multiple indices with minimal parameters
  def test_search4
    req = @client.search_with_http_info(
      SearchMethodParams.new(
        requests: [SearchForHits.new(index_name: "theIndexName"),
          SearchForFacets.new(
            index_name: "theIndexName2",
            type: 'facet',
            facet: "theFacet"
          ),
          SearchForHits.new(index_name: "theIndexName", type: 'default')],
        strategy: 'stopIfEnoughMatches'
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/*/queries', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"indexName":"theIndexName"},{"indexName":"theIndexName2","type":"facet","facet":"theFacet"},{"indexName":"theIndexName","type":"default"}],"strategy":"stopIfEnoughMatches"}'), JSON.parse(req.body)
    )
  end

  # search for multiple mixed requests in multiple indices with all parameters
  def test_search5
    req = @client.search_with_http_info(
      SearchMethodParams.new(
        requests: [
          SearchForFacets.new(
            index_name: "theIndexName",
            type: 'facet',
            facet: "theFacet",
            facet_query: "theFacetQuery",
            query: "theQuery",
            max_facet_hits: 50
          ),
          SearchForHits.new(
            index_name: "theIndexName",
            query: "myQuery",
            hits_per_page: 50,
            type: 'default'
          )
        ],
        strategy: 'stopIfEnoughMatches'
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/*/queries', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"indexName":"theIndexName","type":"facet","facet":"theFacet","facetQuery":"theFacetQuery","query":"theQuery","maxFacetHits":50},{"indexName":"theIndexName","query":"myQuery","hitsPerPage":50,"type":"default"}],"strategy":"stopIfEnoughMatches"}'), JSON.parse(req.body)
    )
  end

  # search filters accept all of the possible shapes
  def test_search6
    req = @client.search_with_http_info(
      SearchMethodParams.new(
        requests: [
          SearchForHits.new(
            index_name: "theIndexName",
            facet_filters: "mySearch:filters",
            re_ranking_apply_filter: "mySearch:filters",
            tag_filters: "mySearch:filters",
            numeric_filters: "mySearch:filters",
            optional_filters: "mySearch:filters"
          ),
          SearchForHits.new(
            index_name: "theIndexName",
            facet_filters: ["mySearch:filters", ["mySearch:filters"]],
            re_ranking_apply_filter: ["mySearch:filters", ["mySearch:filters"]],
            tag_filters: ["mySearch:filters", ["mySearch:filters"]],
            numeric_filters: ["mySearch:filters", ["mySearch:filters"]],
            optional_filters: ["mySearch:filters", ["mySearch:filters"]]
          )
        ]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/*/queries', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"indexName":"theIndexName","facetFilters":"mySearch:filters","reRankingApplyFilter":"mySearch:filters","tagFilters":"mySearch:filters","numericFilters":"mySearch:filters","optionalFilters":"mySearch:filters"},{"indexName":"theIndexName","facetFilters":["mySearch:filters",["mySearch:filters"]],"reRankingApplyFilter":["mySearch:filters",["mySearch:filters"]],"tagFilters":["mySearch:filters",["mySearch:filters"]],"numericFilters":["mySearch:filters",["mySearch:filters"]],"optionalFilters":["mySearch:filters",["mySearch:filters"]]}]}'), JSON.parse(req.body)
    )
  end

  # search with all search parameters
  def test_search7
    req = @client.search_with_http_info(
      SearchMethodParams.new(
        requests: [SearchForHits.new(
          advanced_syntax: true,
          advanced_syntax_features: ['exactPhrase'],
          allow_typos_on_numeric_tokens: true,
          alternatives_as_exact: ['multiWordsSynonym'],
          analytics: true,
          analytics_tags: [""],
          around_lat_lng: "",
          around_lat_lng_via_ip: true,
          around_precision: 0,
          around_radius: 'all',
          attribute_criteria_computed_by_min_proximity: true,
          attributes_for_faceting: [""],
          attributes_to_highlight: [""],
          attributes_to_retrieve: [""],
          attributes_to_snippet: [""],
          click_analytics: true,
          custom_ranking: [""],
          decompound_query: true,
          disable_exact_on_attributes: [""],
          disable_typo_tolerance_on_attributes: [""],
          distinct: 0,
          enable_ab_test: true,
          enable_personalization: true,
          enable_re_ranking: true,
          enable_rules: true,
          exact_on_single_word_query: 'attribute',
          explain: [
            "foo", "bar"
          ],
          facet_filters: [""],
          faceting_after_distinct: true,
          facets: [""],
          filters: "",
          get_ranking_info: true,
          highlight_post_tag: "",
          highlight_pre_tag: "",
          hits_per_page: 1,
          ignore_plurals: false,
          index_name: "theIndexName",
          inside_bounding_box: [[47.3165, 4.9665, 47.3424, 5.0201],
            [40.9234, 2.1185, 38.643, 1.9916]],
          inside_polygon: [[47.3165, 4.9665, 47.3424, 5.0201, 47.32, 4.9],
            [40.9234, 2.1185, 38.643, 1.9916, 39.2587, 2.0104]],
          keep_diacritics_on_characters: "",
          length: 1,
          max_values_per_facet: 0,
          min_proximity: 1,
          min_word_sizefor1_typo: 0,
          min_word_sizefor2_typos: 0,
          minimum_around_radius: 1,
          natural_languages: [""],
          numeric_filters: [""],
          offset: 0,
          optional_filters: [""],
          optional_words: [""],
          page: 0,
          percentile_computation: true,
          personalization_impact: 0,
          query: "",
          query_languages: [""],
          query_type: 'prefixAll',
          ranking: [""],
          re_ranking_apply_filter: [""],
          relevancy_strictness: 0,
          remove_stop_words: true,
          remove_words_if_no_results: 'allOptional',
          rendering_content: RenderingContent.new(
            facet_ordering: FacetOrdering.new(
              facets: Facets.new(
                order: ["a",
                  "b"]
              ),
              values: { a: Value.new(order: ["b"], sort_remaining_by: 'count') }
            )
          ),
          replace_synonyms_in_highlight: true,
          response_fields: [""],
          restrict_highlight_and_snippet_arrays: true,
          restrict_searchable_attributes: [""],
          rule_contexts: [""],
          similar_query: "",
          snippet_ellipsis_text: "",
          sort_facet_values_by: "",
          sum_or_filters_scores: true,
          synonyms: true,
          tag_filters: [""],
          type: 'default',
          typo_tolerance: 'min',
          user_token: ""
        )]
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/*/queries', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"requests":[{"advancedSyntax":true,"advancedSyntaxFeatures":["exactPhrase"],"allowTyposOnNumericTokens":true,"alternativesAsExact":["multiWordsSynonym"],"analytics":true,"analyticsTags":[""],"aroundLatLng":"","aroundLatLngViaIP":true,"aroundPrecision":0,"aroundRadius":"all","attributeCriteriaComputedByMinProximity":true,"attributesForFaceting":[""],"attributesToHighlight":[""],"attributesToRetrieve":[""],"attributesToSnippet":[""],"clickAnalytics":true,"customRanking":[""],"decompoundQuery":true,"disableExactOnAttributes":[""],"disableTypoToleranceOnAttributes":[""],"distinct":0,"enableABTest":true,"enablePersonalization":true,"enableReRanking":true,"enableRules":true,"exactOnSingleWordQuery":"attribute","explain":["foo","bar"],"facetFilters":[""],"facetingAfterDistinct":true,"facets":[""],"filters":"","getRankingInfo":true,"highlightPostTag":"","highlightPreTag":"","hitsPerPage":1,"ignorePlurals":false,"indexName":"theIndexName","insideBoundingBox":[[47.3165,4.9665,47.3424,5.0201],[40.9234,2.1185,38.643,1.9916]],"insidePolygon":[[47.3165,4.9665,47.3424,5.0201,47.32,4.9],[40.9234,2.1185,38.643,1.9916,39.2587,2.0104]],"keepDiacriticsOnCharacters":"","length":1,"maxValuesPerFacet":0,"minProximity":1,"minWordSizefor1Typo":0,"minWordSizefor2Typos":0,"minimumAroundRadius":1,"naturalLanguages":[""],"numericFilters":[""],"offset":0,"optionalFilters":[""],"optionalWords":[""],"page":0,"percentileComputation":true,"personalizationImpact":0,"query":"","queryLanguages":[""],"queryType":"prefixAll","ranking":[""],"reRankingApplyFilter":[""],"relevancyStrictness":0,"removeStopWords":true,"removeWordsIfNoResults":"allOptional","renderingContent":{"facetOrdering":{"facets":{"order":["a","b"]},"values":{"a":{"order":["b"],"sortRemainingBy":"count"}}}},"replaceSynonymsInHighlight":true,"responseFields":[""],"restrictHighlightAndSnippetArrays":true,"restrictSearchableAttributes":[""],"ruleContexts":[""],"similarQuery":"","snippetEllipsisText":"","sortFacetValuesBy":"","sumOrFiltersScores":true,"synonyms":true,"tagFilters":[""],"type":"default","typoTolerance":"min","userToken":""}]}'), JSON.parse(req.body)
    )
  end

  # get searchDictionaryEntries results with minimal parameters
  def test_search_dictionary_entries0
    req = @client.search_dictionary_entries_with_http_info(
      'compounds',
      SearchDictionaryEntriesParams.new(query: "foo")
    )

    assert_equal(:post, req.method)
    assert_equal('/1/dictionaries/compounds/search', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"query":"foo"}'), JSON.parse(req.body))
  end

  # get searchDictionaryEntries results with all parameters
  def test_search_dictionary_entries1
    req = @client.search_dictionary_entries_with_http_info(
      'compounds',
      SearchDictionaryEntriesParams.new(query: "foo", page: 4, hits_per_page: 2, language: "fr")
    )

    assert_equal(:post, req.method)
    assert_equal('/1/dictionaries/compounds/search', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"query":"foo","page":4,"hitsPerPage":2,"language":"fr"}'),
      JSON.parse(req.body)
    )
  end

  # get searchForFacetValues results with minimal parameters
  def test_search_for_facet_values0
    req = @client.search_for_facet_values_with_http_info("indexName", "facetName")

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/indexName/facets/facetName/query', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{}'), JSON.parse(req.body))
  end

  # get searchForFacetValues results with all parameters
  def test_search_for_facet_values1
    req = @client.search_for_facet_values_with_http_info(
      "indexName",
      "facetName",
      SearchForFacetValuesRequest.new(
        params: "query=foo&facetFilters=['bar']",
        facet_query: "foo",
        max_facet_hits: 42
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/indexName/facets/facetName/query', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse(%q({"params":"query=foo&facetFilters=['bar']","facetQuery":"foo","maxFacetHits":42})), JSON.parse(req.body)
    )
  end

  # searchRules0
  def test_search_rules0
    req = @client.search_rules_with_http_info(
      "indexName",
      SearchRulesParams.new(query: "something")
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/indexName/rules/search', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"query":"something"}'), JSON.parse(req.body))
  end

  # search with minimal parameters
  def test_search_single_index0
    req = @client.search_single_index_with_http_info("indexName")

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/indexName/query', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{}'), JSON.parse(req.body))
  end

  # search with special characters in indexName
  def test_search_single_index1
    req = @client.search_single_index_with_http_info("cts_e2e_space in index")

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/cts_e2e_space%20in%20index/query', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{}'), JSON.parse(req.body))

    res = @e2e_client.search_single_index_with_http_info("cts_e2e_space in index")

    assert_equal(res.status, 200)
  end

  # search with searchParams
  def test_search_single_index2
    req = @client.search_single_index_with_http_info(
      "indexName",
      SearchParamsObject.new(query: "myQuery", facet_filters: ["tags:algolia"])
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/indexName/query', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"query":"myQuery","facetFilters":["tags:algolia"]}'),
      JSON.parse(req.body)
    )
  end

  # searchSynonyms with minimal parameters
  def test_search_synonyms0
    req = @client.search_synonyms_with_http_info("indexName")

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/indexName/synonyms/search', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{}'), JSON.parse(req.body))
  end

  # searchSynonyms with all parameters
  def test_search_synonyms1
    req = @client.search_synonyms_with_http_info(
      "indexName",
      'altcorrection1',
      10,
      10,
      SearchSynonymsParams.new(query: "myQuery")
    )

    assert_equal(:post, req.method)
    assert_equal('/1/indexes/indexName/synonyms/search', req.path)
    assert(
      ({ 'type': "altcorrection1",
         'page': "10",
         'hitsPerPage': "10" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"query":"myQuery"}'), JSON.parse(req.body))
  end

  # searchUserIds0
  def test_search_user_ids0
    req = @client.search_user_ids_with_http_info(
      SearchUserIdsParams.new(
        query: "test",
        cluster_name: "theClusterName",
        page: 5,
        hits_per_page: 10
      )
    )

    assert_equal(:post, req.method)
    assert_equal('/1/clusters/mapping/search', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"query":"test","clusterName":"theClusterName","page":5,"hitsPerPage":10}'), JSON.parse(req.body)
    )
  end

  # get setDictionarySettings results with minimal parameters
  def test_set_dictionary_settings0
    req = @client.set_dictionary_settings_with_http_info(
      DictionarySettingsParams.new(
        disable_standard_entries: StandardEntries.new(
          plurals: {
            fr: false, en: false, ru: true
          }
        )
      )
    )

    assert_equal(:put, req.method)
    assert_equal('/1/dictionaries/*/settings', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"disableStandardEntries":{"plurals":{"fr":false,"en":false,"ru":true}}}'), JSON.parse(req.body)
    )
  end

  # get setDictionarySettings results with all parameters
  def test_set_dictionary_settings1
    req = @client.set_dictionary_settings_with_http_info(
      DictionarySettingsParams.new(
        disable_standard_entries: StandardEntries.new(
          plurals: { fr: false,
                     en: false,
                     ru: true },
          stopwords: { fr: false },
          compounds: { ru: true }
        )
      )
    )

    assert_equal(:put, req.method)
    assert_equal('/1/dictionaries/*/settings', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"disableStandardEntries":{"plurals":{"fr":false,"en":false,"ru":true},"stopwords":{"fr":false},"compounds":{"ru":true}}}'), JSON.parse(req.body)
    )
  end

  # setSettings with minimal parameters
  def test_set_settings0
    req = @client.set_settings_with_http_info(
      "cts_e2e_settings",
      IndexSettings.new(pagination_limited_to: 10),
      true
    )

    assert_equal(:put, req.method)
    assert_equal('/1/indexes/cts_e2e_settings/settings', req.path)
    assert(
      ({ 'forwardToReplicas': "true" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"paginationLimitedTo":10}'), JSON.parse(req.body))

    res = @e2e_client.set_settings_with_http_info(
      "cts_e2e_settings",
      IndexSettings.new(pagination_limited_to: 10),
      true
    )

    assert_equal(res.status, 200)
  end

  # setSettings allow boolean `typoTolerance`
  def test_set_settings1
    req = @client.set_settings_with_http_info(
      "theIndexName",
      IndexSettings.new(typo_tolerance: true),
      true
    )

    assert_equal(:put, req.method)
    assert_equal('/1/indexes/theIndexName/settings', req.path)
    assert(
      ({ 'forwardToReplicas': "true" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"typoTolerance":true}'), JSON.parse(req.body))
  end

  # setSettings allow enum `typoTolerance`
  def test_set_settings2
    req = @client.set_settings_with_http_info(
      "theIndexName",
      IndexSettings.new(typo_tolerance: 'min'),
      true
    )

    assert_equal(:put, req.method)
    assert_equal('/1/indexes/theIndexName/settings', req.path)
    assert(
      ({ 'forwardToReplicas': "true" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"typoTolerance":"min"}'), JSON.parse(req.body))
  end

  # setSettings allow boolean `ignorePlurals`
  def test_set_settings3
    req = @client.set_settings_with_http_info(
      "theIndexName",
      IndexSettings.new(ignore_plurals: true),
      true
    )

    assert_equal(:put, req.method)
    assert_equal('/1/indexes/theIndexName/settings', req.path)
    assert(
      ({ 'forwardToReplicas': "true" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"ignorePlurals":true}'), JSON.parse(req.body))
  end

  # setSettings allow list of string `ignorePlurals`
  def test_set_settings4
    req = @client.set_settings_with_http_info(
      "theIndexName",
      IndexSettings.new(ignore_plurals: ["algolia"]),
      true
    )

    assert_equal(:put, req.method)
    assert_equal('/1/indexes/theIndexName/settings', req.path)
    assert(
      ({ 'forwardToReplicas': "true" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"ignorePlurals":["algolia"]}'), JSON.parse(req.body))
  end

  # setSettings allow boolean `removeStopWords`
  def test_set_settings5
    req = @client.set_settings_with_http_info(
      "theIndexName",
      IndexSettings.new(remove_stop_words: true),
      true
    )

    assert_equal(:put, req.method)
    assert_equal('/1/indexes/theIndexName/settings', req.path)
    assert(
      ({ 'forwardToReplicas': "true" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"removeStopWords":true}'), JSON.parse(req.body))
  end

  # setSettings allow list of string `removeStopWords`
  def test_set_settings6
    req = @client.set_settings_with_http_info(
      "theIndexName",
      IndexSettings.new(remove_stop_words: ["algolia"]),
      true
    )

    assert_equal(:put, req.method)
    assert_equal('/1/indexes/theIndexName/settings', req.path)
    assert(
      ({ 'forwardToReplicas': "true" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"removeStopWords":["algolia"]}'), JSON.parse(req.body))
  end

  # setSettings allow boolean `distinct`
  def test_set_settings7
    req = @client.set_settings_with_http_info(
      "theIndexName",
      IndexSettings.new(distinct: true),
      true
    )

    assert_equal(:put, req.method)
    assert_equal('/1/indexes/theIndexName/settings', req.path)
    assert(
      ({ 'forwardToReplicas': "true" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"distinct":true}'), JSON.parse(req.body))
  end

  # setSettings allow integers for `distinct`
  def test_set_settings8
    req = @client.set_settings_with_http_info(
      "theIndexName",
      IndexSettings.new(distinct: 1),
      true
    )

    assert_equal(:put, req.method)
    assert_equal('/1/indexes/theIndexName/settings', req.path)
    assert(
      ({ 'forwardToReplicas': "true" }.to_a - req.query_params.to_a).empty?,
      req.query_params.to_s
    )
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(JSON.parse('{"distinct":1}'), JSON.parse(req.body))
  end

  # setSettings allow all `indexSettings`
  def test_set_settings9
    req = @client.set_settings_with_http_info(
      "theIndexName",
      IndexSettings.new(
        advanced_syntax: true,
        advanced_syntax_features: ['exactPhrase'],
        allow_compression_of_integer_array: true,
        allow_typos_on_numeric_tokens: true,
        alternatives_as_exact: ['singleWordSynonym'],
        attribute_criteria_computed_by_min_proximity: true,
        attribute_for_distinct: "test",
        attributes_for_faceting: ["algolia"],
        attributes_to_highlight: ["algolia"],
        attributes_to_retrieve: ["algolia"],
        attributes_to_snippet: ["algolia"],
        attributes_to_transliterate: ["algolia"],
        camel_case_attributes: ["algolia"],
        custom_normalization: { algolia: { aloglia: "aglolia" }},
        custom_ranking: ["algolia"],
        decompound_query: false,
        decompounded_attributes: { algolia: "aloglia" },
        disable_exact_on_attributes: ["algolia"],
        disable_prefix_on_attributes: ["algolia"],
        disable_typo_tolerance_on_attributes: ["algolia"],
        disable_typo_tolerance_on_words: ["algolia"],
        distinct: 3,
        enable_personalization: true,
        enable_re_ranking: false,
        enable_rules: true,
        exact_on_single_word_query: 'attribute',
        highlight_pre_tag: "<span>",
        highlight_post_tag: "</span>",
        hits_per_page: 10,
        ignore_plurals: false,
        index_languages: ["algolia"],
        keep_diacritics_on_characters: "abc",
        max_facet_hits: 20,
        max_values_per_facet: 30,
        min_proximity: 6,
        min_word_sizefor1_typo: 5,
        min_word_sizefor2_typos: 11,
        mode: 'neuralSearch',
        numeric_attributes_for_filtering: ["algolia"],
        optional_words: ["myspace"],
        pagination_limited_to: 0,
        query_languages: ["algolia"],
        query_type: 'prefixLast',
        ranking: ["geo"],
        re_ranking_apply_filter: "mySearch:filters",
        relevancy_strictness: 10,
        remove_stop_words: false,
        remove_words_if_no_results: 'lastWords',
        rendering_content: RenderingContent.new(
          facet_ordering: FacetOrdering.new(
            facets: Facets.new(
              order: ["a",
                "b"]
            ),
            values: { a: Value.new(order: ["b"], sort_remaining_by: 'count') }
          )
        ),
        replace_synonyms_in_highlight: true,
        replicas: [""],
        response_fields: ["algolia"],
        restrict_highlight_and_snippet_arrays: true,
        searchable_attributes: ["foo"],
        semantic_search: SemanticSearch.new(event_sources: ["foo"]),
        separators_to_index: "bar",
        snippet_ellipsis_text: "---",
        sort_facet_values_by: "date",
        typo_tolerance: false,
        unretrievable_attributes: ["foo"],
        user_data: { user: "data" }
      )
    )

    assert_equal(:put, req.method)
    assert_equal('/1/indexes/theIndexName/settings', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"advancedSyntax":true,"advancedSyntaxFeatures":["exactPhrase"],"allowCompressionOfIntegerArray":true,"allowTyposOnNumericTokens":true,"alternativesAsExact":["singleWordSynonym"],"attributeCriteriaComputedByMinProximity":true,"attributeForDistinct":"test","attributesForFaceting":["algolia"],"attributesToHighlight":["algolia"],"attributesToRetrieve":["algolia"],"attributesToSnippet":["algolia"],"attributesToTransliterate":["algolia"],"camelCaseAttributes":["algolia"],"customNormalization":{"algolia":{"aloglia":"aglolia"}},"customRanking":["algolia"],"decompoundQuery":false,"decompoundedAttributes":{"algolia":"aloglia"},"disableExactOnAttributes":["algolia"],"disablePrefixOnAttributes":["algolia"],"disableTypoToleranceOnAttributes":["algolia"],"disableTypoToleranceOnWords":["algolia"],"distinct":3,"enablePersonalization":true,"enableReRanking":false,"enableRules":true,"exactOnSingleWordQuery":"attribute","highlightPreTag":"<span>","highlightPostTag":"</span>","hitsPerPage":10,"ignorePlurals":false,"indexLanguages":["algolia"],"keepDiacriticsOnCharacters":"abc","maxFacetHits":20,"maxValuesPerFacet":30,"minProximity":6,"minWordSizefor1Typo":5,"minWordSizefor2Typos":11,"mode":"neuralSearch","numericAttributesForFiltering":["algolia"],"optionalWords":["myspace"],"paginationLimitedTo":0,"queryLanguages":["algolia"],"queryType":"prefixLast","ranking":["geo"],"reRankingApplyFilter":"mySearch:filters","relevancyStrictness":10,"removeStopWords":false,"removeWordsIfNoResults":"lastWords","renderingContent":{"facetOrdering":{"facets":{"order":["a","b"]},"values":{"a":{"order":["b"],"sortRemainingBy":"count"}}}},"replaceSynonymsInHighlight":true,"replicas":[""],"responseFields":["algolia"],"restrictHighlightAndSnippetArrays":true,"searchableAttributes":["foo"],"semanticSearch":{"eventSources":["foo"]},"separatorsToIndex":"bar","snippetEllipsisText":"---","sortFacetValuesBy":"date","typoTolerance":false,"unretrievableAttributes":["foo"],"userData":{"user":"data"}}'), JSON.parse(req.body)
    )
  end

  # updateApiKey0
  def test_update_api_key0
    req = @client.update_api_key_with_http_info(
      "myApiKey",
      ApiKey.new(
        acl: ['search', 'addObject'],
        validity: 300,
        max_queries_per_ip_per_hour: 100,
        max_hits_per_query: 20
      )
    )

    assert_equal(:put, req.method)
    assert_equal('/1/keys/myApiKey', req.path)
    assert(({}.to_a - req.query_params.to_a).empty?, req.query_params.to_s)
    assert(({}.to_a - req.headers.to_a).empty?, req.headers.to_s)
    assert_equal(
      JSON.parse('{"acl":["search","addObject"],"validity":300,"maxQueriesPerIPPerHour":100,"maxHitsPerQuery":20}'), JSON.parse(req.body)
    )
  end
end
