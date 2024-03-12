<?php

// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

namespace Algolia\AlgoliaSearch\Model\Recommend;

/**
 * BaseSearchResponse Class Doc Comment.
 *
 * @category Class
 */
class BaseSearchResponse extends \Algolia\AlgoliaSearch\Model\AbstractModel implements ModelInterface, \ArrayAccess, \JsonSerializable
{
    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelTypes = [
        'abTestID' => 'int',
        'abTestVariantID' => 'int',
        'aroundLatLng' => 'string',
        'automaticRadius' => 'string',
        'exhaustive' => '\Algolia\AlgoliaSearch\Model\Recommend\Exhaustive',
        'exhaustiveFacetsCount' => 'bool',
        'exhaustiveNbHits' => 'bool',
        'exhaustiveTypo' => 'bool',
        'facets' => 'array<string,array<string,int>>',
        'facetsStats' => 'array<string,\Algolia\AlgoliaSearch\Model\Recommend\FacetsStats>',
        'hitsPerPage' => 'int',
        'index' => 'string',
        'indexUsed' => 'string',
        'message' => 'string',
        'nbHits' => 'int',
        'nbPages' => 'int',
        'nbSortedHits' => 'int',
        'page' => 'int',
        'parsedQuery' => 'string',
        'processingTimeMS' => 'int',
        'processingTimingsMS' => 'object',
        'queryAfterRemoval' => 'string',
        'redirect' => '\Algolia\AlgoliaSearch\Model\Recommend\Redirect',
        'renderingContent' => '\Algolia\AlgoliaSearch\Model\Recommend\RenderingContent',
        'serverTimeMS' => 'int',
        'serverUsed' => 'string',
        'userData' => 'mixed',
        'queryID' => 'string',
    ];

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @var string[]
     */
    protected static $modelFormats = [
        'abTestID' => null,
        'abTestVariantID' => null,
        'aroundLatLng' => null,
        'automaticRadius' => null,
        'exhaustive' => null,
        'exhaustiveFacetsCount' => null,
        'exhaustiveNbHits' => null,
        'exhaustiveTypo' => null,
        'facets' => null,
        'facetsStats' => null,
        'hitsPerPage' => null,
        'index' => null,
        'indexUsed' => null,
        'message' => null,
        'nbHits' => null,
        'nbPages' => null,
        'nbSortedHits' => null,
        'page' => null,
        'parsedQuery' => null,
        'processingTimeMS' => null,
        'processingTimingsMS' => null,
        'queryAfterRemoval' => null,
        'redirect' => null,
        'renderingContent' => null,
        'serverTimeMS' => null,
        'serverUsed' => null,
        'userData' => null,
        'queryID' => null,
    ];

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @var string[]
     */
    protected static $attributeMap = [
        'abTestID' => 'abTestID',
        'abTestVariantID' => 'abTestVariantID',
        'aroundLatLng' => 'aroundLatLng',
        'automaticRadius' => 'automaticRadius',
        'exhaustive' => 'exhaustive',
        'exhaustiveFacetsCount' => 'exhaustiveFacetsCount',
        'exhaustiveNbHits' => 'exhaustiveNbHits',
        'exhaustiveTypo' => 'exhaustiveTypo',
        'facets' => 'facets',
        'facetsStats' => 'facets_stats',
        'hitsPerPage' => 'hitsPerPage',
        'index' => 'index',
        'indexUsed' => 'indexUsed',
        'message' => 'message',
        'nbHits' => 'nbHits',
        'nbPages' => 'nbPages',
        'nbSortedHits' => 'nbSortedHits',
        'page' => 'page',
        'parsedQuery' => 'parsedQuery',
        'processingTimeMS' => 'processingTimeMS',
        'processingTimingsMS' => 'processingTimingsMS',
        'queryAfterRemoval' => 'queryAfterRemoval',
        'redirect' => 'redirect',
        'renderingContent' => 'renderingContent',
        'serverTimeMS' => 'serverTimeMS',
        'serverUsed' => 'serverUsed',
        'userData' => 'userData',
        'queryID' => 'queryID',
    ];

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @var string[]
     */
    protected static $setters = [
        'abTestID' => 'setAbTestID',
        'abTestVariantID' => 'setAbTestVariantID',
        'aroundLatLng' => 'setAroundLatLng',
        'automaticRadius' => 'setAutomaticRadius',
        'exhaustive' => 'setExhaustive',
        'exhaustiveFacetsCount' => 'setExhaustiveFacetsCount',
        'exhaustiveNbHits' => 'setExhaustiveNbHits',
        'exhaustiveTypo' => 'setExhaustiveTypo',
        'facets' => 'setFacets',
        'facetsStats' => 'setFacetsStats',
        'hitsPerPage' => 'setHitsPerPage',
        'index' => 'setIndex',
        'indexUsed' => 'setIndexUsed',
        'message' => 'setMessage',
        'nbHits' => 'setNbHits',
        'nbPages' => 'setNbPages',
        'nbSortedHits' => 'setNbSortedHits',
        'page' => 'setPage',
        'parsedQuery' => 'setParsedQuery',
        'processingTimeMS' => 'setProcessingTimeMS',
        'processingTimingsMS' => 'setProcessingTimingsMS',
        'queryAfterRemoval' => 'setQueryAfterRemoval',
        'redirect' => 'setRedirect',
        'renderingContent' => 'setRenderingContent',
        'serverTimeMS' => 'setServerTimeMS',
        'serverUsed' => 'setServerUsed',
        'userData' => 'setUserData',
        'queryID' => 'setQueryID',
    ];

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @var string[]
     */
    protected static $getters = [
        'abTestID' => 'getAbTestID',
        'abTestVariantID' => 'getAbTestVariantID',
        'aroundLatLng' => 'getAroundLatLng',
        'automaticRadius' => 'getAutomaticRadius',
        'exhaustive' => 'getExhaustive',
        'exhaustiveFacetsCount' => 'getExhaustiveFacetsCount',
        'exhaustiveNbHits' => 'getExhaustiveNbHits',
        'exhaustiveTypo' => 'getExhaustiveTypo',
        'facets' => 'getFacets',
        'facetsStats' => 'getFacetsStats',
        'hitsPerPage' => 'getHitsPerPage',
        'index' => 'getIndex',
        'indexUsed' => 'getIndexUsed',
        'message' => 'getMessage',
        'nbHits' => 'getNbHits',
        'nbPages' => 'getNbPages',
        'nbSortedHits' => 'getNbSortedHits',
        'page' => 'getPage',
        'parsedQuery' => 'getParsedQuery',
        'processingTimeMS' => 'getProcessingTimeMS',
        'processingTimingsMS' => 'getProcessingTimingsMS',
        'queryAfterRemoval' => 'getQueryAfterRemoval',
        'redirect' => 'getRedirect',
        'renderingContent' => 'getRenderingContent',
        'serverTimeMS' => 'getServerTimeMS',
        'serverUsed' => 'getServerUsed',
        'userData' => 'getUserData',
        'queryID' => 'getQueryID',
    ];

    /**
     * Associative array for storing property values.
     *
     * @var mixed[]
     */
    protected $container = [];

    /**
     * Constructor.
     *
     * @param mixed[] $data Associated array of property values
     */
    public function __construct(array $data = null)
    {
        if (isset($data['abTestID'])) {
            $this->container['abTestID'] = $data['abTestID'];
        }
        if (isset($data['abTestVariantID'])) {
            $this->container['abTestVariantID'] = $data['abTestVariantID'];
        }
        if (isset($data['aroundLatLng'])) {
            $this->container['aroundLatLng'] = $data['aroundLatLng'];
        }
        if (isset($data['automaticRadius'])) {
            $this->container['automaticRadius'] = $data['automaticRadius'];
        }
        if (isset($data['exhaustive'])) {
            $this->container['exhaustive'] = $data['exhaustive'];
        }
        if (isset($data['exhaustiveFacetsCount'])) {
            $this->container['exhaustiveFacetsCount'] = $data['exhaustiveFacetsCount'];
        }
        if (isset($data['exhaustiveNbHits'])) {
            $this->container['exhaustiveNbHits'] = $data['exhaustiveNbHits'];
        }
        if (isset($data['exhaustiveTypo'])) {
            $this->container['exhaustiveTypo'] = $data['exhaustiveTypo'];
        }
        if (isset($data['facets'])) {
            $this->container['facets'] = $data['facets'];
        }
        if (isset($data['facetsStats'])) {
            $this->container['facetsStats'] = $data['facetsStats'];
        }
        if (isset($data['hitsPerPage'])) {
            $this->container['hitsPerPage'] = $data['hitsPerPage'];
        }
        if (isset($data['index'])) {
            $this->container['index'] = $data['index'];
        }
        if (isset($data['indexUsed'])) {
            $this->container['indexUsed'] = $data['indexUsed'];
        }
        if (isset($data['message'])) {
            $this->container['message'] = $data['message'];
        }
        if (isset($data['nbHits'])) {
            $this->container['nbHits'] = $data['nbHits'];
        }
        if (isset($data['nbPages'])) {
            $this->container['nbPages'] = $data['nbPages'];
        }
        if (isset($data['nbSortedHits'])) {
            $this->container['nbSortedHits'] = $data['nbSortedHits'];
        }
        if (isset($data['page'])) {
            $this->container['page'] = $data['page'];
        }
        if (isset($data['parsedQuery'])) {
            $this->container['parsedQuery'] = $data['parsedQuery'];
        }
        if (isset($data['processingTimeMS'])) {
            $this->container['processingTimeMS'] = $data['processingTimeMS'];
        }
        if (isset($data['processingTimingsMS'])) {
            $this->container['processingTimingsMS'] = $data['processingTimingsMS'];
        }
        if (isset($data['queryAfterRemoval'])) {
            $this->container['queryAfterRemoval'] = $data['queryAfterRemoval'];
        }
        if (isset($data['redirect'])) {
            $this->container['redirect'] = $data['redirect'];
        }
        if (isset($data['renderingContent'])) {
            $this->container['renderingContent'] = $data['renderingContent'];
        }
        if (isset($data['serverTimeMS'])) {
            $this->container['serverTimeMS'] = $data['serverTimeMS'];
        }
        if (isset($data['serverUsed'])) {
            $this->container['serverUsed'] = $data['serverUsed'];
        }
        if (isset($data['userData'])) {
            $this->container['userData'] = $data['userData'];
        }
        if (isset($data['queryID'])) {
            $this->container['queryID'] = $data['queryID'];
        }
    }

    /**
     * Array of attributes where the key is the local name,
     * and the value is the original name.
     *
     * @return array
     */
    public static function attributeMap()
    {
        return self::$attributeMap;
    }

    /**
     * Array of property to type mappings. Used for (de)serialization.
     *
     * @return array
     */
    public static function modelTypes()
    {
        return self::$modelTypes;
    }

    /**
     * Array of property to format mappings. Used for (de)serialization.
     *
     * @return array
     */
    public static function modelFormats()
    {
        return self::$modelFormats;
    }

    /**
     * Array of attributes to setter functions (for deserialization of responses).
     *
     * @return array
     */
    public static function setters()
    {
        return self::$setters;
    }

    /**
     * Array of attributes to getter functions (for serialization of requests).
     *
     * @return array
     */
    public static function getters()
    {
        return self::$getters;
    }

    /**
     * Show all the invalid properties with reasons.
     *
     * @return array invalid properties with reasons
     */
    public function listInvalidProperties()
    {
        $invalidProperties = [];

        if (isset($this->container['abTestVariantID']) && ($this->container['abTestVariantID'] < 1)) {
            $invalidProperties[] = "invalid value for 'abTestVariantID', must be bigger than or equal to 1.";
        }

        if (isset($this->container['aroundLatLng']) && !preg_match('/^(-?\\d+(\\.\\d+)?),\\s*(-?\\d+(\\.\\d+)?)$/', $this->container['aroundLatLng'])) {
            $invalidProperties[] = "invalid value for 'aroundLatLng', must be conform to the pattern /^(-?\\d+(\\.\\d+)?),\\s*(-?\\d+(\\.\\d+)?)$/.";
        }

        if (!isset($this->container['hitsPerPage']) || null === $this->container['hitsPerPage']) {
            $invalidProperties[] = "'hitsPerPage' can't be null";
        }
        if ($this->container['hitsPerPage'] > 1000) {
            $invalidProperties[] = "invalid value for 'hitsPerPage', must be smaller than or equal to 1000.";
        }

        if ($this->container['hitsPerPage'] < 1) {
            $invalidProperties[] = "invalid value for 'hitsPerPage', must be bigger than or equal to 1.";
        }

        if (!isset($this->container['nbHits']) || null === $this->container['nbHits']) {
            $invalidProperties[] = "'nbHits' can't be null";
        }
        if (!isset($this->container['nbPages']) || null === $this->container['nbPages']) {
            $invalidProperties[] = "'nbPages' can't be null";
        }
        if (!isset($this->container['page']) || null === $this->container['page']) {
            $invalidProperties[] = "'page' can't be null";
        }
        if ($this->container['page'] < 0) {
            $invalidProperties[] = "invalid value for 'page', must be bigger than or equal to 0.";
        }

        if (!isset($this->container['processingTimeMS']) || null === $this->container['processingTimeMS']) {
            $invalidProperties[] = "'processingTimeMS' can't be null";
        }

        return $invalidProperties;
    }

    /**
     * Validate all the properties in the model
     * return true if all passed.
     *
     * @return bool True if all properties are valid
     */
    public function valid()
    {
        return 0 === count($this->listInvalidProperties());
    }

    /**
     * Gets abTestID.
     *
     * @return null|int
     */
    public function getAbTestID()
    {
        return $this->container['abTestID'] ?? null;
    }

    /**
     * Sets abTestID.
     *
     * @param null|int $abTestID A/B test ID. This is only included in the response for indices that are part of an A/B test.
     *
     * @return self
     */
    public function setAbTestID($abTestID)
    {
        $this->container['abTestID'] = $abTestID;

        return $this;
    }

    /**
     * Gets abTestVariantID.
     *
     * @return null|int
     */
    public function getAbTestVariantID()
    {
        return $this->container['abTestVariantID'] ?? null;
    }

    /**
     * Sets abTestVariantID.
     *
     * @param null|int $abTestVariantID Variant ID. This is only included in the response for indices that are part of an A/B test.
     *
     * @return self
     */
    public function setAbTestVariantID($abTestVariantID)
    {
        if (!is_null($abTestVariantID) && ($abTestVariantID < 1)) {
            throw new \InvalidArgumentException('invalid value for $abTestVariantID when calling BaseSearchResponse., must be bigger than or equal to 1.');
        }

        $this->container['abTestVariantID'] = $abTestVariantID;

        return $this;
    }

    /**
     * Gets aroundLatLng.
     *
     * @return null|string
     */
    public function getAroundLatLng()
    {
        return $this->container['aroundLatLng'] ?? null;
    }

    /**
     * Sets aroundLatLng.
     *
     * @param null|string $aroundLatLng computed geographical location
     *
     * @return self
     */
    public function setAroundLatLng($aroundLatLng)
    {
        if (!is_null($aroundLatLng) && (!preg_match('/^(-?\\d+(\\.\\d+)?),\\s*(-?\\d+(\\.\\d+)?)$/', $aroundLatLng))) {
            throw new \InvalidArgumentException("invalid value for {$aroundLatLng} when calling BaseSearchResponse., must conform to the pattern /^(-?\\d+(\\.\\d+)?),\\s*(-?\\d+(\\.\\d+)?)$/.");
        }

        $this->container['aroundLatLng'] = $aroundLatLng;

        return $this;
    }

    /**
     * Gets automaticRadius.
     *
     * @return null|string
     */
    public function getAutomaticRadius()
    {
        return $this->container['automaticRadius'] ?? null;
    }

    /**
     * Sets automaticRadius.
     *
     * @param null|string $automaticRadius distance from a central coordinate provided by `aroundLatLng`
     *
     * @return self
     */
    public function setAutomaticRadius($automaticRadius)
    {
        $this->container['automaticRadius'] = $automaticRadius;

        return $this;
    }

    /**
     * Gets exhaustive.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Recommend\Exhaustive
     */
    public function getExhaustive()
    {
        return $this->container['exhaustive'] ?? null;
    }

    /**
     * Sets exhaustive.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Recommend\Exhaustive $exhaustive exhaustive
     *
     * @return self
     */
    public function setExhaustive($exhaustive)
    {
        $this->container['exhaustive'] = $exhaustive;

        return $this;
    }

    /**
     * Gets exhaustiveFacetsCount.
     *
     * @return null|bool
     *
     * @deprecated
     */
    public function getExhaustiveFacetsCount()
    {
        return $this->container['exhaustiveFacetsCount'] ?? null;
    }

    /**
     * Sets exhaustiveFacetsCount.
     *
     * @param null|bool $exhaustiveFacetsCount see the `facetsCount` field of the `exhaustive` object in the response
     *
     * @return self
     *
     * @deprecated
     */
    public function setExhaustiveFacetsCount($exhaustiveFacetsCount)
    {
        $this->container['exhaustiveFacetsCount'] = $exhaustiveFacetsCount;

        return $this;
    }

    /**
     * Gets exhaustiveNbHits.
     *
     * @return null|bool
     *
     * @deprecated
     */
    public function getExhaustiveNbHits()
    {
        return $this->container['exhaustiveNbHits'] ?? null;
    }

    /**
     * Sets exhaustiveNbHits.
     *
     * @param null|bool $exhaustiveNbHits see the `nbHits` field of the `exhaustive` object in the response
     *
     * @return self
     *
     * @deprecated
     */
    public function setExhaustiveNbHits($exhaustiveNbHits)
    {
        $this->container['exhaustiveNbHits'] = $exhaustiveNbHits;

        return $this;
    }

    /**
     * Gets exhaustiveTypo.
     *
     * @return null|bool
     *
     * @deprecated
     */
    public function getExhaustiveTypo()
    {
        return $this->container['exhaustiveTypo'] ?? null;
    }

    /**
     * Sets exhaustiveTypo.
     *
     * @param null|bool $exhaustiveTypo see the `typo` field of the `exhaustive` object in the response
     *
     * @return self
     *
     * @deprecated
     */
    public function setExhaustiveTypo($exhaustiveTypo)
    {
        $this->container['exhaustiveTypo'] = $exhaustiveTypo;

        return $this;
    }

    /**
     * Gets facets.
     *
     * @return null|array<string,array<string,int>>
     */
    public function getFacets()
    {
        return $this->container['facets'] ?? null;
    }

    /**
     * Sets facets.
     *
     * @param null|array<string,array<string,int>> $facets facet counts
     *
     * @return self
     */
    public function setFacets($facets)
    {
        $this->container['facets'] = $facets;

        return $this;
    }

    /**
     * Gets facetsStats.
     *
     * @return null|array<string,\Algolia\AlgoliaSearch\Model\Recommend\FacetsStats>
     */
    public function getFacetsStats()
    {
        return $this->container['facetsStats'] ?? null;
    }

    /**
     * Sets facetsStats.
     *
     * @param null|array<string,\Algolia\AlgoliaSearch\Model\Recommend\FacetsStats> $facetsStats statistics for numerical facets
     *
     * @return self
     */
    public function setFacetsStats($facetsStats)
    {
        $this->container['facetsStats'] = $facetsStats;

        return $this;
    }

    /**
     * Gets hitsPerPage.
     *
     * @return int
     */
    public function getHitsPerPage()
    {
        return $this->container['hitsPerPage'] ?? null;
    }

    /**
     * Sets hitsPerPage.
     *
     * @param int $hitsPerPage number of hits per page
     *
     * @return self
     */
    public function setHitsPerPage($hitsPerPage)
    {
        if ($hitsPerPage > 1000) {
            throw new \InvalidArgumentException('invalid value for $hitsPerPage when calling BaseSearchResponse., must be smaller than or equal to 1000.');
        }
        if ($hitsPerPage < 1) {
            throw new \InvalidArgumentException('invalid value for $hitsPerPage when calling BaseSearchResponse., must be bigger than or equal to 1.');
        }

        $this->container['hitsPerPage'] = $hitsPerPage;

        return $this;
    }

    /**
     * Gets index.
     *
     * @return null|string
     */
    public function getIndex()
    {
        return $this->container['index'] ?? null;
    }

    /**
     * Sets index.
     *
     * @param null|string $index index name used for the query
     *
     * @return self
     */
    public function setIndex($index)
    {
        $this->container['index'] = $index;

        return $this;
    }

    /**
     * Gets indexUsed.
     *
     * @return null|string
     */
    public function getIndexUsed()
    {
        return $this->container['indexUsed'] ?? null;
    }

    /**
     * Sets indexUsed.
     *
     * @param null|string $indexUsed Index name used for the query. During A/B testing, the targeted index isn't always the index used by the query.
     *
     * @return self
     */
    public function setIndexUsed($indexUsed)
    {
        $this->container['indexUsed'] = $indexUsed;

        return $this;
    }

    /**
     * Gets message.
     *
     * @return null|string
     */
    public function getMessage()
    {
        return $this->container['message'] ?? null;
    }

    /**
     * Sets message.
     *
     * @param null|string $message warnings about the query
     *
     * @return self
     */
    public function setMessage($message)
    {
        $this->container['message'] = $message;

        return $this;
    }

    /**
     * Gets nbHits.
     *
     * @return int
     */
    public function getNbHits()
    {
        return $this->container['nbHits'] ?? null;
    }

    /**
     * Sets nbHits.
     *
     * @param int $nbHits number of results (hits)
     *
     * @return self
     */
    public function setNbHits($nbHits)
    {
        $this->container['nbHits'] = $nbHits;

        return $this;
    }

    /**
     * Gets nbPages.
     *
     * @return int
     */
    public function getNbPages()
    {
        return $this->container['nbPages'] ?? null;
    }

    /**
     * Sets nbPages.
     *
     * @param int $nbPages number of pages of results
     *
     * @return self
     */
    public function setNbPages($nbPages)
    {
        $this->container['nbPages'] = $nbPages;

        return $this;
    }

    /**
     * Gets nbSortedHits.
     *
     * @return null|int
     */
    public function getNbSortedHits()
    {
        return $this->container['nbSortedHits'] ?? null;
    }

    /**
     * Sets nbSortedHits.
     *
     * @param null|int $nbSortedHits number of hits selected and sorted by the relevant sort algorithm
     *
     * @return self
     */
    public function setNbSortedHits($nbSortedHits)
    {
        $this->container['nbSortedHits'] = $nbSortedHits;

        return $this;
    }

    /**
     * Gets page.
     *
     * @return int
     */
    public function getPage()
    {
        return $this->container['page'] ?? null;
    }

    /**
     * Sets page.
     *
     * @param int $page page of search results to retrieve
     *
     * @return self
     */
    public function setPage($page)
    {
        if ($page < 0) {
            throw new \InvalidArgumentException('invalid value for $page when calling BaseSearchResponse., must be bigger than or equal to 0.');
        }

        $this->container['page'] = $page;

        return $this;
    }

    /**
     * Gets parsedQuery.
     *
     * @return null|string
     */
    public function getParsedQuery()
    {
        return $this->container['parsedQuery'] ?? null;
    }

    /**
     * Sets parsedQuery.
     *
     * @param null|string $parsedQuery Post-[normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean) query string that will be searched.
     *
     * @return self
     */
    public function setParsedQuery($parsedQuery)
    {
        $this->container['parsedQuery'] = $parsedQuery;

        return $this;
    }

    /**
     * Gets processingTimeMS.
     *
     * @return int
     */
    public function getProcessingTimeMS()
    {
        return $this->container['processingTimeMS'] ?? null;
    }

    /**
     * Sets processingTimeMS.
     *
     * @param int $processingTimeMS time the server took to process the request, in milliseconds
     *
     * @return self
     */
    public function setProcessingTimeMS($processingTimeMS)
    {
        $this->container['processingTimeMS'] = $processingTimeMS;

        return $this;
    }

    /**
     * Gets processingTimingsMS.
     *
     * @return null|object
     */
    public function getProcessingTimingsMS()
    {
        return $this->container['processingTimingsMS'] ?? null;
    }

    /**
     * Sets processingTimingsMS.
     *
     * @param null|object $processingTimingsMS Experimental. List of processing steps and their times, in milliseconds. You can use this list to investigate performance issues.
     *
     * @return self
     */
    public function setProcessingTimingsMS($processingTimingsMS)
    {
        $this->container['processingTimingsMS'] = $processingTimingsMS;

        return $this;
    }

    /**
     * Gets queryAfterRemoval.
     *
     * @return null|string
     */
    public function getQueryAfterRemoval()
    {
        return $this->container['queryAfterRemoval'] ?? null;
    }

    /**
     * Sets queryAfterRemoval.
     *
     * @param null|string $queryAfterRemoval markup text indicating which parts of the original query have been removed to retrieve a non-empty result set
     *
     * @return self
     */
    public function setQueryAfterRemoval($queryAfterRemoval)
    {
        $this->container['queryAfterRemoval'] = $queryAfterRemoval;

        return $this;
    }

    /**
     * Gets redirect.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Recommend\Redirect
     */
    public function getRedirect()
    {
        return $this->container['redirect'] ?? null;
    }

    /**
     * Sets redirect.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Recommend\Redirect $redirect redirect
     *
     * @return self
     */
    public function setRedirect($redirect)
    {
        $this->container['redirect'] = $redirect;

        return $this;
    }

    /**
     * Gets renderingContent.
     *
     * @return null|\Algolia\AlgoliaSearch\Model\Recommend\RenderingContent
     */
    public function getRenderingContent()
    {
        return $this->container['renderingContent'] ?? null;
    }

    /**
     * Sets renderingContent.
     *
     * @param null|\Algolia\AlgoliaSearch\Model\Recommend\RenderingContent $renderingContent renderingContent
     *
     * @return self
     */
    public function setRenderingContent($renderingContent)
    {
        $this->container['renderingContent'] = $renderingContent;

        return $this;
    }

    /**
     * Gets serverTimeMS.
     *
     * @return null|int
     */
    public function getServerTimeMS()
    {
        return $this->container['serverTimeMS'] ?? null;
    }

    /**
     * Sets serverTimeMS.
     *
     * @param null|int $serverTimeMS time the server took to process the request, in milliseconds
     *
     * @return self
     */
    public function setServerTimeMS($serverTimeMS)
    {
        $this->container['serverTimeMS'] = $serverTimeMS;

        return $this;
    }

    /**
     * Gets serverUsed.
     *
     * @return null|string
     */
    public function getServerUsed()
    {
        return $this->container['serverUsed'] ?? null;
    }

    /**
     * Sets serverUsed.
     *
     * @param null|string $serverUsed host name of the server that processed the request
     *
     * @return self
     */
    public function setServerUsed($serverUsed)
    {
        $this->container['serverUsed'] = $serverUsed;

        return $this;
    }

    /**
     * Gets userData.
     *
     * @return null|mixed
     */
    public function getUserData()
    {
        return $this->container['userData'] ?? null;
    }

    /**
     * Sets userData.
     *
     * @param null|mixed $userData An object with custom data.  You can store up to 32&nbsp;kB as custom data.
     *
     * @return self
     */
    public function setUserData($userData)
    {
        $this->container['userData'] = $userData;

        return $this;
    }

    /**
     * Gets queryID.
     *
     * @return null|string
     */
    public function getQueryID()
    {
        return $this->container['queryID'] ?? null;
    }

    /**
     * Sets queryID.
     *
     * @param null|string $queryID Unique identifier for the query. This is used for [click analytics](https://www.algolia.com/doc/guides/analytics/click-analytics/).
     *
     * @return self
     */
    public function setQueryID($queryID)
    {
        $this->container['queryID'] = $queryID;

        return $this;
    }

    /**
     * Returns true if offset exists. False otherwise.
     *
     * @param int $offset Offset
     *
     * @return bool
     */
    public function offsetExists($offset)
    {
        return isset($this->container[$offset]);
    }

    /**
     * Gets offset.
     *
     * @param int $offset Offset
     *
     * @return null|mixed
     */
    public function offsetGet($offset)
    {
        return $this->container[$offset] ?? null;
    }

    /**
     * Sets value based on offset.
     *
     * @param null|int $offset Offset
     * @param mixed    $value  Value to be set
     */
    public function offsetSet($offset, $value)
    {
        if (is_null($offset)) {
            $this->container[] = $value;
        } else {
            $this->container[$offset] = $value;
        }
    }

    /**
     * Unsets offset.
     *
     * @param int $offset Offset
     */
    public function offsetUnset($offset)
    {
        unset($this->container[$offset]);
    }
}
