// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

import type { AroundPrecision } from './aroundPrecision';
import type { AroundRadius } from './aroundRadius';
import type { FacetFilters } from './facetFilters';
import type { NumericFilters } from './numericFilters';
import type { OptionalFilters } from './optionalFilters';
import type { SupportedLanguage } from './supportedLanguage';

export type SearchParamsSearchParams = {
  /**
   * Search query.
   */
  query?: string;

  /**
   * Filter expression to only include items that match the filter criteria in the response.  You can use these filter expressions:  - **Numeric filters.** `<facet> <op> <number>`, where `<op>` is one of `<`, `<=`, `=`, `!=`, `>`, `>=`. - **Ranges.** `<facet>:<lower> TO <upper>` where `<lower>` and `<upper>` are the lower and upper limits of the range (inclusive). - **Facet filters.** `<facet>:<value>` where `<facet>` is a facet attribute (case-sensitive) and `<value>` a facet value. - **Tag filters.** `_tags:<value>` or just `<value>` (case-sensitive). - **Boolean filters.** `<facet>: true | false`.  You can combine filters with `AND`, `OR`, and `NOT` operators with the following restrictions:  - You can only combine filters of the same type with `OR`.   **Not supported:** `facet:value OR num > 3`. - You can\'t use `NOT` with combinations of filters.   **Not supported:** `NOT(facet:value OR facet:value)` - You can\'t combine conjunctions (`AND`) with `OR`.   **Not supported:** `facet:value OR (facet:value AND facet:value)`  Use quotes around your filters, if the facet attribute name or facet value has spaces, keywords (`OR`, `AND`, `NOT`), or quotes. If a facet attribute is an array, the filter matches if it matches at least one element of the array.  For more information, see [Filters](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/).
   */
  filters?: string;

  /**
   * Page of search results to retrieve.
   */
  page?: number;

  /**
   * Whether the search response should include detailed ranking information.
   */
  getRankingInfo?: boolean;

  relevancyStrictness?: number;

  facetFilters?: FacetFilters;

  optionalFilters?: OptionalFilters;

  numericFilters?: NumericFilters;

  /**
   * Number of hits per page.
   */
  hitsPerPage?: number;

  /**
   * Coordinates for the center of a circle, expressed as a comma-separated string of latitude and longitude.  Only records included within a circle around this central location are included in the results. The radius of the circle is determined by the `aroundRadius` and `minimumAroundRadius` settings. This parameter is ignored if you also specify `insidePolygon` or `insideBoundingBox`.
   */
  aroundLatLng?: string;

  /**
   * Whether to obtain the coordinates from the request\'s IP address.
   */
  aroundLatLngViaIP?: boolean;

  aroundRadius?: AroundRadius;

  aroundPrecision?: AroundPrecision;

  /**
   * Minimum radius (in meters) for a search around a location when `aroundRadius` isn\'t set.
   */
  minimumAroundRadius?: number;

  /**
   * Coordinates for a rectangular area in which to search.  Each bounding box is defined by the two opposite points of its diagonal, and expressed as latitude and longitude pair: `[p1 lat, p1 long, p2 lat, p2 long]`. Provide multiple bounding boxes as nested arrays. For more information, see [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas).
   */
  insideBoundingBox?: Array<Array<number>>;

  /**
   * Coordinates of a polygon in which to search.  Polygons are defined by 3 to 10,000 points. Each point is represented by its latitude and longitude. Provide multiple polygons as nested arrays. For more information, see [filtering inside polygons](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas). This parameter is ignored if you also specify `insideBoundingBox`.
   */
  insidePolygon?: Array<Array<number>>;

  /**
   * Languages for language-specific query processing steps such as plurals, stop-word removal, and word-detection dictionaries.  This setting sets a default list of languages used by the `removeStopWords` and `ignorePlurals` settings. This setting also sets a dictionary for word detection in the logogram-based [CJK](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/normalization/#normalization-for-logogram-based-languages-cjk) languages. To support this, you must place the CJK language **first**.  **You should always specify a query language.** If you don\'t specify an indexing language, the search engine uses all [supported languages](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/supported-languages/), or the languages you specified with the `ignorePlurals` or `removeStopWords` parameters. This can lead to unexpected search results. For more information, see [Language-specific configuration](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/in-depth/language-specific-configurations/).
   */
  queryLanguages?: Array<SupportedLanguage>;

  /**
   * ISO language codes that adjust settings that are useful for processing natural language queries (as opposed to keyword searches):  - Sets `removeStopWords` and `ignorePlurals` to the list of provided languages. - Sets `removeWordsIfNoResults` to `allOptional`. - Adds a `natural_language` attribute to `ruleContexts` and `analyticsTags`.
   */
  naturalLanguages?: Array<SupportedLanguage>;

  /**
   * Whether to enable rules.
   */
  enableRules?: boolean;

  /**
   * Assigns a rule context to the search query.  [Rule contexts](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#whats-a-context) are strings that you can use to trigger matching rules.
   */
  ruleContexts?: Array<string>;

  /**
   * Unique pseudonymous or anonymous user identifier.  This helps with analytics and click and conversion events. For more information, see [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
   */
  userToken?: string;

  /**
   * Whether to include a `queryID` attribute in the response.  The query ID is a unique identifier for a search query and is required for tracking [click and conversion events](https://www.algolia.com/guides/sending-events/getting-started/).
   */
  clickAnalytics?: boolean;

  /**
   * Whether this search will be included in Analytics.
   */
  analytics?: boolean;

  /**
   * Tags to apply to the query for [segmenting analytics data](https://www.algolia.com/doc/guides/search-analytics/guides/segments/).
   */
  analyticsTags?: Array<string>;

  /**
   * Whether to enable A/B testing for this search.
   */
  enableABTest?: boolean;

  /**
   * Whether this search will use [Dynamic Re-Ranking](https://www.algolia.com/doc/guides/algolia-ai/re-ranking/).  This setting only has an effect if you activated Dynamic Re-Ranking for this index in the Algolia dashboard.
   */
  enableReRanking?: boolean;
};
