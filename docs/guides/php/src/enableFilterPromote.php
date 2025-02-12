<?php

require __DIR__.'/../vendor/autoload.php';

use Algolia\AlgoliaSearch\Model\Search\Anchoring;
use Algolia\AlgoliaSearch\Model\Search\Condition;
use Algolia\AlgoliaSearch\Model\Search\Consequence;
use Algolia\AlgoliaSearch\Model\Search\Rule;

$condition = (new Condition())
    ->setAnchoring((new Anchoring())::IS)
    ->setPattern('{facet:brand}')
;

$consequence = (new Consequence())
    ->setFilterPromotes(true)
;

$rule = (new Rule())
    ->setObjectID('rule_with_filterPromotes')
    ->setConditions([$condition])
    ->setConsequence($consequence);
