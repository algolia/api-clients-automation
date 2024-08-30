# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
require "algolia"
require "test/unit"
require "dotenv"

require_relative "../helpers"

Dotenv.load("../../.env")

class TestSearchClientE2E < Test::Unit::TestCase
  include Algolia::Search
  def setup
    @client = Algolia::SearchClient.create(
      ENV.fetch("ALGOLIA_APPLICATION_ID", nil),
      ENV.fetch("ALGOLIA_ADMIN_KEY", nil)
    )
  end

  # browse with minimal parameters
  def test_browse
    res = @client.browse_with_http_info("cts_e2e_browse")

    assert_equal(res.status, 200)
    res = @client.browse("cts_e2e_browse")
    expected_body = JSON.parse(
      "{\"page\":0,\"nbHits\":33191,\"nbPages\":34,\"hitsPerPage\":1000,\"query\":\"\",\"params\":\"\"}"
    )
    assert_equal(expected_body, union(expected_body, JSON.parse(res.to_json)))
  end

  # getRule
  def test_get_rule
    res = @client.get_rule_with_http_info("cts_e2e_browse", "qr-1725004648916")

    assert_equal(res.status, 200)
    res = @client.get_rule("cts_e2e_browse", "qr-1725004648916")
    expected_body = JSON.parse(
      "{\"description\":\"test_rule\",\"enabled\":true,\"objectID\":\"qr-1725004648916\",\"conditions\":[{\"alternatives\":true,\"anchoring\":\"contains\",\"pattern\":\"zorro\"}],\"consequence\":{\"params\":{\"ignorePlurals\":\"true\"},\"filterPromotes\":true,\"promote\":[{\"objectIDs\":[\"\u00C6on Flux\"],\"position\":0}]}}"
    )
    assert_equal(expected_body, union(expected_body, JSON.parse(res.to_json)))
  end

  # getSettings
  def test_get_settings
    res = @client.get_settings_with_http_info("cts_e2e_settings")

    assert_equal(res.status, 200)
    res = @client.get_settings("cts_e2e_settings")
    expected_body = JSON.parse(
      "{\"minWordSizefor1Typo\":4,\"minWordSizefor2Typos\":8,\"hitsPerPage\":100,\"maxValuesPerFacet\":100,\"paginationLimitedTo\":10,\"exactOnSingleWordQuery\":\"attribute\",\"ranking\":[\"typo\",\"geo\",\"words\",\"filters\",\"proximity\",\"attribute\",\"exact\",\"custom\"],\"separatorsToIndex\":\"\",\"removeWordsIfNoResults\":\"none\",\"queryType\":\"prefixLast\",\"highlightPreTag\":\"<em>\",\"highlightPostTag\":\"</em>\",\"alternativesAsExact\":[\"ignorePlurals\",\"singleWordSynonym\"]}"
    )
    assert_equal(expected_body, union(expected_body, JSON.parse(res.to_json)))
  end

  # search for a single hits request with minimal parameters
  def test_search4
    res = @client.search_with_http_info(
      SearchMethodParams.new(requests: [SearchForHits.new(index_name: "cts_e2e_search_empty_index")])
    )

    assert_equal(res.status, 200)
    res = @client.search(
      SearchMethodParams.new(requests: [SearchForHits.new(index_name: "cts_e2e_search_empty_index")])
    )
    expected_body = JSON.parse(
      "{\"results\":[{\"hits\":[],\"page\":0,\"nbHits\":0,\"nbPages\":0,\"hitsPerPage\":20,\"exhaustiveNbHits\":true,\"exhaustiveTypo\":true,\"exhaustive\":{\"nbHits\":true,\"typo\":true},\"query\":\"\",\"params\":\"\",\"index\":\"cts_e2e_search_empty_index\",\"renderingContent\":{}}]}"
    )
    assert_equal(expected_body, union(expected_body, JSON.parse(res.to_json)))
  end

  # search with highlight and snippet results
  def test_search5
    res = @client.search_with_http_info(
      SearchMethodParams.new(
        requests: [
          SearchForHits.new(
            index_name: "cts_e2e_highlight_snippet_results",
            query: "vim",
            attributes_to_snippet: ["*:20"],
            attributes_to_highlight: ["*"],
            attributes_to_retrieve: ["*"]
          )
        ]
      )
    )

    assert_equal(res.status, 200)
    res = @client.search(
      SearchMethodParams.new(
        requests: [
          SearchForHits.new(
            index_name: "cts_e2e_highlight_snippet_results",
            query: "vim",
            attributes_to_snippet: ["*:20"],
            attributes_to_highlight: ["*"],
            attributes_to_retrieve: ["*"]
          )
        ]
      )
    )
    expected_body = JSON.parse(
      "{\"results\":[{\"hits\":[{\"editor\":{\"name\":\"vim\",\"type\":\"beforeneovim\"},\"names\":[\"vim\",\":q\"],\"_snippetResult\":{\"editor\":{\"name\":{\"value\":\"<em>vim</em>\",\"matchLevel\":\"full\"},\"type\":{\"value\":\"beforeneovim\",\"matchLevel\":\"none\"}},\"names\":[{\"value\":\"<em>vim</em>\",\"matchLevel\":\"full\"},{\"value\":\":q\",\"matchLevel\":\"none\"}]},\"_highlightResult\":{\"editor\":{\"name\":{\"value\":\"<em>vim</em>\",\"matchLevel\":\"full\",\"fullyHighlighted\":true,\"matchedWords\":[\"vim\"]},\"type\":{\"value\":\"beforeneovim\",\"matchLevel\":\"none\",\"matchedWords\":[]}},\"names\":[{\"value\":\"<em>vim</em>\",\"matchLevel\":\"full\",\"fullyHighlighted\":true,\"matchedWords\":[\"vim\"]},{\"value\":\":q\",\"matchLevel\":\"none\",\"matchedWords\":[]}]}}],\"nbHits\":1,\"page\":0,\"nbPages\":1,\"hitsPerPage\":20,\"exhaustiveNbHits\":true,\"exhaustiveTypo\":true,\"exhaustive\":{\"nbHits\":true,\"typo\":true},\"query\":\"vim\",\"index\":\"cts_e2e_highlight_snippet_results\",\"renderingContent\":{}}]}"
    )
    assert_equal(expected_body, union(expected_body, JSON.parse(res.to_json)))
  end

  # search for a single facet request with minimal parameters
  def test_search8
    res = @client.search_with_http_info(
      SearchMethodParams.new(
        requests: [SearchForFacets.new(index_name: "cts_e2e_search_facet", type: "facet", facet: "editor")],
        strategy: "stopIfEnoughMatches"
      )
    )

    assert_equal(res.status, 200)
    res = @client.search(
      SearchMethodParams.new(
        requests: [SearchForFacets.new(index_name: "cts_e2e_search_facet", type: "facet", facet: "editor")],
        strategy: "stopIfEnoughMatches"
      )
    )
    expected_body = JSON.parse(
      "{\"results\":[{\"exhaustiveFacetsCount\":true,\"facetHits\":[{\"count\":1,\"highlighted\":\"goland\",\"value\":\"goland\"},{\"count\":1,\"highlighted\":\"neovim\",\"value\":\"neovim\"},{\"count\":1,\"highlighted\":\"visual studio\",\"value\":\"visual studio\"},{\"count\":1,\"highlighted\":\"vscode\",\"value\":\"vscode\"}]}]}"
    )
    assert_equal(expected_body, union(expected_body, JSON.parse(res.to_json)))
  end

  # search filters end to end
  def test_search14
    res = @client.search_with_http_info(
      SearchMethodParams.new(
        requests: [
          SearchForHits.new(index_name: "cts_e2e_search_facet", filters: "editor:'visual studio' OR editor:neovim"),
          SearchForHits.new(
            index_name: "cts_e2e_search_facet",
            facet_filters: ["editor:'visual studio'", "editor:neovim"]
          ),
          SearchForHits.new(
            index_name: "cts_e2e_search_facet",
            facet_filters: ["editor:'visual studio'", ["editor:neovim"]]
          ),
          SearchForHits.new(
            index_name: "cts_e2e_search_facet",
            facet_filters: ["editor:'visual studio'", ["editor:neovim", ["editor:goland"]]]
          )
        ]
      )
    )

    assert_equal(res.status, 200)
    res = @client.search(
      SearchMethodParams.new(
        requests: [
          SearchForHits.new(index_name: "cts_e2e_search_facet", filters: "editor:'visual studio' OR editor:neovim"),
          SearchForHits.new(
            index_name: "cts_e2e_search_facet",
            facet_filters: ["editor:'visual studio'", "editor:neovim"]
          ),
          SearchForHits.new(
            index_name: "cts_e2e_search_facet",
            facet_filters: ["editor:'visual studio'", ["editor:neovim"]]
          ),
          SearchForHits.new(
            index_name: "cts_e2e_search_facet",
            facet_filters: ["editor:'visual studio'", ["editor:neovim", ["editor:goland"]]]
          )
        ]
      )
    )
    expected_body = JSON.parse(
      "{\"results\":[{\"hitsPerPage\":20,\"index\":\"cts_e2e_search_facet\",\"nbHits\":2,\"nbPages\":1,\"page\":0,\"hits\":[{\"editor\":\"visual studio\",\"_highlightResult\":{\"editor\":{\"value\":\"visual studio\",\"matchLevel\":\"none\"}}},{\"editor\":\"neovim\",\"_highlightResult\":{\"editor\":{\"value\":\"neovim\",\"matchLevel\":\"none\"}}}],\"query\":\"\",\"params\":\"filters=editor%3A%27visual+studio%27+OR+editor%3Aneovim\"},{\"hitsPerPage\":20,\"index\":\"cts_e2e_search_facet\",\"nbHits\":0,\"nbPages\":0,\"page\":0,\"hits\":[],\"query\":\"\",\"params\":\"facetFilters=%5B%22editor%3A%27visual+studio%27%22%2C%22editor%3Aneovim%22%5D\"},{\"hitsPerPage\":20,\"index\":\"cts_e2e_search_facet\",\"nbHits\":0,\"nbPages\":0,\"page\":0,\"hits\":[],\"query\":\"\",\"params\":\"facetFilters=%5B%22editor%3A%27visual+studio%27%22%2C%5B%22editor%3Aneovim%22%5D%5D\"},{\"hitsPerPage\":20,\"index\":\"cts_e2e_search_facet\",\"nbHits\":0,\"nbPages\":0,\"page\":0,\"hits\":[],\"query\":\"\",\"params\":\"facetFilters=%5B%22editor%3A%27visual+studio%27%22%2C%5B%22editor%3Aneovim%22%2C%5B%22editor%3Agoland%22%5D%5D%5D\"}]}"
    )
    assert_equal(expected_body, union(expected_body, JSON.parse(res.to_json)))
  end

  # get searchDictionaryEntries results with minimal parameters
  def test_search_dictionary_entries
    res = @client.search_dictionary_entries_with_http_info(
      "stopwords",
      SearchDictionaryEntriesParams.new(query: "about")
    )

    assert_equal(res.status, 200)
    res = @client.search_dictionary_entries("stopwords", SearchDictionaryEntriesParams.new(query: "about"))
    expected_body = JSON.parse(
      "{\"hits\":[{\"objectID\":\"86ef58032f47d976ca7130a896086783\",\"language\":\"en\",\"word\":\"about\"}],\"page\":0,\"nbHits\":1,\"nbPages\":1}"
    )
    assert_equal(expected_body, union(expected_body, JSON.parse(res.to_json)))
  end

  # searchRules
  def test_search_rules
    res = @client.search_rules_with_http_info("cts_e2e_browse", SearchRulesParams.new(query: "zorro"))

    assert_equal(res.status, 200)
    res = @client.search_rules("cts_e2e_browse", SearchRulesParams.new(query: "zorro"))
    expected_body = JSON.parse(
      "{\"hits\":[{\"conditions\":[{\"alternatives\":true,\"anchoring\":\"contains\",\"pattern\":\"zorro\"}],\"consequence\":{\"params\":{\"ignorePlurals\":\"true\"},\"filterPromotes\":true,\"promote\":[{\"objectIDs\":[\"\u00C6on Flux\"],\"position\":0}]},\"description\":\"test_rule\",\"enabled\":true,\"objectID\":\"qr-1725004648916\"}],\"nbHits\":1,\"nbPages\":1,\"page\":0}"
    )
    assert_equal(expected_body, union(expected_body, JSON.parse(res.to_json)))
  end

  # search with special characters in indexName
  def test_search_single_index1
    res = @client.search_single_index_with_http_info("cts_e2e_space in index")

    assert_equal(res.status, 200)
  end

  # single search retrieve snippets
  def test_search_single_index3
    res = @client.search_single_index_with_http_info(
      "cts_e2e_browse",
      SearchParamsObject.new(
        query: "batman mask of the phantasm",
        attributes_to_retrieve: ["*"],
        attributes_to_snippet: ["*:20"]
      )
    )

    assert_equal(res.status, 200)
    res = @client.search_single_index(
      "cts_e2e_browse",
      SearchParamsObject.new(
        query: "batman mask of the phantasm",
        attributes_to_retrieve: ["*"],
        attributes_to_snippet: ["*:20"]
      )
    )
    expected_body = JSON.parse(
      "{\"nbHits\":1,\"hits\":[{\"_snippetResult\":{\"genres\":[{\"value\":\"Animated\",\"matchLevel\":\"none\"},{\"value\":\"Superhero\",\"matchLevel\":\"none\"},{\"value\":\"Romance\",\"matchLevel\":\"none\"}],\"year\":{\"value\":\"1993\",\"matchLevel\":\"none\"}},\"_highlightResult\":{\"genres\":[{\"value\":\"Animated\",\"matchLevel\":\"none\",\"matchedWords\":[]},{\"value\":\"Superhero\",\"matchLevel\":\"none\",\"matchedWords\":[]},{\"value\":\"Romance\",\"matchLevel\":\"none\",\"matchedWords\":[]}],\"year\":{\"value\":\"1993\",\"matchLevel\":\"none\",\"matchedWords\":[]}}}]}"
    )
    assert_equal(expected_body, union(expected_body, JSON.parse(res.to_json)))
  end

  # setSettings with minimal parameters
  def test_set_settings1
    res = @client.set_settings_with_http_info("cts_e2e_settings", IndexSettings.new(pagination_limited_to: 10), true)

    assert_equal(res.status, 200)
  end

end
