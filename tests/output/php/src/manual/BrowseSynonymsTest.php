<?php

namespace Algolia\AlgoliaSearch\Tests;

use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Configuration\SearchConfig;
use Algolia\AlgoliaSearch\Http\HttpClientInterface;
use Algolia\AlgoliaSearch\Http\Psr7\Response;
use Algolia\AlgoliaSearch\RequestOptions\RequestOptionsFactory;
use Algolia\AlgoliaSearch\RetryStrategy\ApiWrapper;
use Algolia\AlgoliaSearch\RetryStrategy\ClusterHosts;
use PHPUnit\Framework\TestCase;
use Psr\Http\Message\RequestInterface;

/**
 * Regression test for the `browseSynonyms` pagination: the page-based iterator must keep paginating
 * while a page is full and stop on the first non-full page. It previously stopped after the first
 * full page, silently truncating the results to `hitsPerPage`.
 *
 * @internal
 *
 * @coversNothing
 */
class BrowseSynonymsTest extends TestCase
{
    public const HITS_PER_PAGE = 1000;

    public function testBrowseSynonymsPaginatesAndStops(): void
    {
        $mockHttp = new class implements HttpClientInterface {
            /** @var int[] */
            public array $pagesRequested = [];

            public function sendRequest(RequestInterface $request, $timeout, $connectTimeout)
            {
                $body = json_decode((string) $request->getBody(), true) ?: [];
                $page = $body['page'] ?? 0;
                $this->pagesRequested[] = $page;

                // Full page for page 0, partial page afterwards, so a correct iterator walks page 0 then page 1.
                $count = 0 === $page ? BrowseSynonymsTest::HITS_PER_PAGE : 3;
                $hits = [];
                for ($i = 0; $i < $count; ++$i) {
                    $hits[] = ['objectID' => "page{$page}-hit{$i}"];
                }

                return new Response(
                    200,
                    ['Content-Type' => 'application/json'],
                    (string) json_encode(['hits' => $hits, 'nbHits' => BrowseSynonymsTest::HITS_PER_PAGE + 3])
                );
            }
        };

        $config = SearchConfig::create('test-app-id', 'test-api-key')
            ->setFullHosts(['http://localhost:9999'])
        ;

        $client = new SearchClient(
            new ApiWrapper($mockHttp, $config, ClusterHosts::create(['http://localhost:9999']), new RequestOptionsFactory($config)),
            $config
        );

        $synonyms = [];
        foreach ($client->browseSynonyms('my-index') as $synonym) {
            $synonyms[] = $synonym;
            // Safety net so a regression can never hang the suite.
            if (count($synonyms) > self::HITS_PER_PAGE + 100) {
                $this->fail('browseSynonyms did not terminate');
            }
        }

        $this->assertEquals([0, 1], $mockHttp->pagesRequested, 'browseSynonyms must request page 0 then page 1');
        $this->assertCount(self::HITS_PER_PAGE + 3, $synonyms, 'browseSynonyms must aggregate every hit from both pages');

        $objectIDs = array_map(static fn ($hit) => $hit['objectID'], $synonyms);
        $this->assertCount(self::HITS_PER_PAGE + 3, array_unique($objectIDs), 'browseSynonyms must not return duplicate or truncated hits');
    }
}
