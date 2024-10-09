<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Test\RequestE2E;

use Algolia\AlgoliaSearch\Api\SearchClient;
use Dotenv\Dotenv;
use PHPUnit\Framework\Attributes\CoversClass;
use PHPUnit\Framework\Attributes\TestDox;
use PHPUnit\Framework\TestCase;

// we only read .env file if we run locally
if (getenv('ALGOLIA_APPLICATION_ID')) {
    $_ENV = getenv();
} else {
    $dotenv = Dotenv::createImmutable('tests');
    $dotenv->load();
}

/**
 * @internal
 */
#[CoversClass(SearchClient::class)]
class SearchTest extends TestCase
{
    #[TestDox('browse with minimal parameters')]
    public function testBrowse(): void
    {
        $client = $this->getClient();
        $resp = $client->browse(
            'cts_e2e_browse',
        );

        $expected = json_decode('{"page":0,"nbHits":33191,"nbPages":34,"hitsPerPage":1000,"query":"","params":""}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    #[TestDox('search with a real object')]
    public function testGetObject1(): void
    {
        $client = $this->getClient();
        $resp = $client->getObject(
            'cts_e2e_browse',
            'Batman and Robin',
        );

        $expected = json_decode('{"objectID":"Batman and Robin","title":"Batman and Robin","year":1949,"cast":["Robert Lowery","Johnny Duncan","Jane Adams"]}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    #[TestDox('getRule')]
    public function testGetRule(): void
    {
        $client = $this->getClient();
        $resp = $client->getRule(
            'cts_e2e_browse',
            'qr-1725004648916',
        );

        $expected = json_decode('{"description":"test_rule","enabled":true,"objectID":"qr-1725004648916","conditions":[{"alternatives":true,"anchoring":"contains","pattern":"zorro"}],"consequence":{"params":{"ignorePlurals":"true"},"filterPromotes":true,"promote":[{"objectIDs":["Æon Flux"],"position":0}]}}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    #[TestDox('getSettings')]
    public function testGetSettings(): void
    {
        $client = $this->getClient();
        $resp = $client->getSettings(
            'cts_e2e_settings',
        );

        $expected = json_decode('{"minWordSizefor1Typo":4,"minWordSizefor2Typos":8,"hitsPerPage":100,"maxValuesPerFacet":100,"paginationLimitedTo":10,"exactOnSingleWordQuery":"attribute","ranking":["typo","geo","words","filters","proximity","attribute","exact","custom"],"separatorsToIndex":"","removeWordsIfNoResults":"none","queryType":"prefixLast","highlightPreTag":"<em>","highlightPostTag":"</em>","alternativesAsExact":["ignorePlurals","singleWordSynonym"]}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    #[TestDox('search for a single hits request with minimal parameters')]
    public function testSearch4(): void
    {
        $client = $this->getClient();
        $resp = $client->search(
            ['requests' => [
                ['indexName' => 'cts_e2e_search_empty_index',
                ],
            ],
            ],
        );

        $expected = json_decode('{"results":[{"hits":[],"page":0,"nbHits":0,"nbPages":0,"hitsPerPage":20,"exhaustiveNbHits":true,"exhaustiveTypo":true,"exhaustive":{"nbHits":true,"typo":true},"query":"","params":"","index":"cts_e2e_search_empty_index","renderingContent":{}}]}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    #[TestDox('search with highlight and snippet results')]
    public function testSearch5(): void
    {
        $client = $this->getClient();
        $resp = $client->search(
            ['requests' => [
                ['indexName' => 'cts_e2e_highlight_snippet_results',
                    'query' => 'vim',
                    'attributesToSnippet' => [
                        '*:20',
                    ],
                    'attributesToHighlight' => [
                        '*',
                    ],
                    'attributesToRetrieve' => [
                        '*',
                    ],
                ],
            ],
            ],
        );

        $expected = json_decode('{"results":[{"hits":[{"editor":{"name":"vim","type":"beforeneovim"},"names":["vim",":q"],"_snippetResult":{"editor":{"name":{"value":"<em>vim</em>","matchLevel":"full"},"type":{"value":"beforeneovim","matchLevel":"none"}},"names":[{"value":"<em>vim</em>","matchLevel":"full"},{"value":":q","matchLevel":"none"}]},"_highlightResult":{"editor":{"name":{"value":"<em>vim</em>","matchLevel":"full","fullyHighlighted":true,"matchedWords":["vim"]},"type":{"value":"beforeneovim","matchLevel":"none","matchedWords":[]}},"names":[{"value":"<em>vim</em>","matchLevel":"full","fullyHighlighted":true,"matchedWords":["vim"]},{"value":":q","matchLevel":"none","matchedWords":[]}]}}],"nbHits":1,"page":0,"nbPages":1,"hitsPerPage":20,"exhaustiveNbHits":true,"exhaustiveTypo":true,"exhaustive":{"nbHits":true,"typo":true},"query":"vim","index":"cts_e2e_highlight_snippet_results","renderingContent":{}}]}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    #[TestDox('search for a single facet request with minimal parameters')]
    public function testSearch8(): void
    {
        $client = $this->getClient();
        $resp = $client->search(
            ['requests' => [
                ['indexName' => 'cts_e2e_search_facet',
                    'type' => 'facet',
                    'facet' => 'editor',
                ],
            ],
                'strategy' => 'stopIfEnoughMatches',
            ],
        );

        $expected = json_decode('{"results":[{"exhaustiveFacetsCount":true,"facetHits":[{"count":1,"highlighted":"goland","value":"goland"},{"count":1,"highlighted":"neovim","value":"neovim"},{"count":1,"highlighted":"visual studio","value":"visual studio"},{"count":1,"highlighted":"vscode","value":"vscode"}]}]}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    #[TestDox('search filters end to end')]
    public function testSearch14(): void
    {
        $client = $this->getClient();
        $resp = $client->search(
            ['requests' => [
                ['indexName' => 'cts_e2e_search_facet',
                    'filters' => "editor:'visual studio' OR editor:neovim",
                ],

                ['indexName' => 'cts_e2e_search_facet',
                    'facetFilters' => [
                        "editor:'visual studio'",

                        'editor:neovim',
                    ],
                ],

                ['indexName' => 'cts_e2e_search_facet',
                    'facetFilters' => [
                        "editor:'visual studio'",

                        [
                            'editor:neovim',
                        ],
                    ],
                ],

                ['indexName' => 'cts_e2e_search_facet',
                    'facetFilters' => [
                        "editor:'visual studio'",

                        [
                            'editor:neovim',

                            [
                                'editor:goland',
                            ],
                        ],
                    ],
                ],
            ],
            ],
        );

        $expected = json_decode('{"results":[{"hitsPerPage":20,"index":"cts_e2e_search_facet","nbHits":2,"nbPages":1,"page":0,"hits":[{"editor":"visual studio","_highlightResult":{"editor":{"value":"visual studio","matchLevel":"none"}}},{"editor":"neovim","_highlightResult":{"editor":{"value":"neovim","matchLevel":"none"}}}],"query":"","params":"filters=editor%3A%27visual+studio%27+OR+editor%3Aneovim"},{"hitsPerPage":20,"index":"cts_e2e_search_facet","nbHits":0,"nbPages":0,"page":0,"hits":[],"query":"","params":"facetFilters=%5B%22editor%3A%27visual+studio%27%22%2C%22editor%3Aneovim%22%5D"},{"hitsPerPage":20,"index":"cts_e2e_search_facet","nbHits":0,"nbPages":0,"page":0,"hits":[],"query":"","params":"facetFilters=%5B%22editor%3A%27visual+studio%27%22%2C%5B%22editor%3Aneovim%22%5D%5D"},{"hitsPerPage":20,"index":"cts_e2e_search_facet","nbHits":0,"nbPages":0,"page":0,"hits":[],"query":"","params":"facetFilters=%5B%22editor%3A%27visual+studio%27%22%2C%5B%22editor%3Aneovim%22%2C%5B%22editor%3Agoland%22%5D%5D%5D"}]}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    #[TestDox('get searchDictionaryEntries results with minimal parameters')]
    public function testSearchDictionaryEntries(): void
    {
        $client = $this->getClient();
        $resp = $client->searchDictionaryEntries(
            'stopwords',
            ['query' => 'about',
            ],
        );

        $expected = json_decode('{"hits":[{"objectID":"86ef58032f47d976ca7130a896086783","language":"en","word":"about"}],"page":0,"nbHits":1,"nbPages":1}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    #[TestDox('searchRules')]
    public function testSearchRules(): void
    {
        $client = $this->getClient();
        $resp = $client->searchRules(
            'cts_e2e_browse',
            ['query' => 'zorro',
            ],
        );

        $expected = json_decode('{"hits":[{"conditions":[{"alternatives":true,"anchoring":"contains","pattern":"zorro"}],"consequence":{"params":{"ignorePlurals":"true"},"filterPromotes":true,"promote":[{"objectIDs":["Æon Flux"],"position":0}]},"description":"test_rule","enabled":true,"objectID":"qr-1725004648916"}],"nbHits":1,"nbPages":1,"page":0}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    #[TestDox('search with special characters in indexName')]
    public function testSearchSingleIndex1(): void
    {
        $client = $this->getClient();
        $resp = $client->searchSingleIndex(
            'cts_e2e_space in index',
        );
    }

    #[TestDox('single search retrieve snippets')]
    public function testSearchSingleIndex3(): void
    {
        $client = $this->getClient();
        $resp = $client->searchSingleIndex(
            'cts_e2e_browse',
            ['query' => 'batman mask of the phantasm',
                'attributesToRetrieve' => [
                    '*',
                ],
                'attributesToSnippet' => [
                    '*:20',
                ],
            ],
        );

        $expected = json_decode('{"nbHits":1,"hits":[{"_snippetResult":{"genres":[{"value":"Animated","matchLevel":"none"},{"value":"Superhero","matchLevel":"none"},{"value":"Romance","matchLevel":"none"}],"year":{"value":"1993","matchLevel":"none"}},"_highlightResult":{"genres":[{"value":"Animated","matchLevel":"none","matchedWords":[]},{"value":"Superhero","matchLevel":"none","matchedWords":[]},{"value":"Romance","matchLevel":"none","matchedWords":[]}],"year":{"value":"1993","matchLevel":"none","matchedWords":[]}}}]}', true);

        $this->assertEquals($this->union($expected, $resp), $expected);
    }

    #[TestDox('setSettings with minimal parameters')]
    public function testSetSettings1(): void
    {
        $client = $this->getClient();
        $resp = $client->setSettings(
            'cts_e2e_settings',
            ['paginationLimitedTo' => 10,
            ],
            true,
        );
    }

    protected function union($expected, $received): mixed
    {
        if (is_array($expected)) {
            $res = [];
            // array and object are the same thing in PHP (magic ✨)
            foreach ($expected as $k => $v) {
                $res[$k] = $this->union($v, $received[$k]);
            }

            return $res;
        }

        return $received;
    }

    protected function getClient(): SearchClient
    {
        return SearchClient::create($_ENV['ALGOLIA_APPLICATION_ID'], $_ENV['ALGOLIA_ADMIN_KEY']);
    }
}
