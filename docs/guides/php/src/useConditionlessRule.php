<?php

require __DIR__.'/../vendor/autoload.php';
use Algolia\AlgoliaSearch\Api\SearchClient;
use Algolia\AlgoliaSearch\Model\Search\Consequence;
use Algolia\AlgoliaSearch\Model\Search\Rule;
use Algolia\AlgoliaSearch\Model\Search\TimeRange;

try {
    $client = SearchClient::create('ALGOLIA_APPLICATION_ID', 'ALGOLIA_API_KEY');

    $objectID = 'a-rule-id';

    $rule = (new Rule())
        ->setObjectID($objectID)
        ->setConsequence(new Consequence(/* Set relevant consequence */))
    ;

    // Set validity (optional)
    $rule->setValidity(
        [
            (new TimeRange())
                ->setFrom(1688774400)
                ->setUntil(1738972800),
        ]
    );

    $client->saveRule(
        '<YOUR_INDEX_NAME>',
        $objectID,
        $rule,
    );
} catch (Exception $e) {
    echo $e->getMessage().PHP_EOL;
}
