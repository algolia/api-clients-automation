//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//

using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.IO;
using System.Runtime.Serialization;
using System.Text;
using System.Text.RegularExpressions;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using Newtonsoft.Json.Linq;
using Algolia.Search.Models;

namespace Algolia.Search.Search.Models
{
  /// <summary>
  /// BaseSearchParams
  /// </summary>
  [DataContract(Name = "baseSearchParams")]
  public partial class BaseSearchParams
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="BaseSearchParams" /> class.
    /// </summary>
    /// <param name="query">Text to search for in an index. (default to &quot;&quot;).</param>
    /// <param name="similarQuery">Overrides the query parameter and performs a more generic search. (default to &quot;&quot;).</param>
    /// <param name="filters">[Filter](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/) the query with numeric, facet, or tag filters.  (default to &quot;&quot;).</param>
    /// <param name="facetFilters">facetFilters.</param>
    /// <param name="optionalFilters">optionalFilters.</param>
    /// <param name="numericFilters">numericFilters.</param>
    /// <param name="tagFilters">tagFilters.</param>
    /// <param name="sumOrFiltersScores">Determines how to calculate [filter scores](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/filter-scoring/#accumulating-scores-with-sumorfiltersscores). If &#x60;false&#x60;, maximum score is kept. If &#x60;true&#x60;, score is summed.  (default to false).</param>
    /// <param name="restrictSearchableAttributes">Restricts a query to only look at a subset of your [searchable attributes](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/)..</param>
    /// <param name="facets">Returns [facets](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#contextual-facet-values-and-counts), their facet values, and the number of matching facet values..</param>
    /// <param name="facetingAfterDistinct">Forces faceting to be applied after [de-duplication](https://www.algolia.com/doc/guides/managing-results/refine-results/grouping/) (with the distinct feature). Alternatively, the &#x60;afterDistinct&#x60; [modifier](https://www.algolia.com/doc/api-reference/api-parameters/attributesForFaceting/#modifiers) of &#x60;attributesForFaceting&#x60; allows for more granular control.  (default to false).</param>
    /// <param name="page">Page to retrieve (the first page is &#x60;0&#x60;, not &#x60;1&#x60;). (default to 0).</param>
    /// <param name="offset">Specifies the offset of the first hit to return. &gt; **Note**: Using &#x60;page&#x60; and &#x60;hitsPerPage&#x60; is the recommended method for [paging results](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/). However, you can use &#x60;offset&#x60; and &#x60;length&#x60; to implement [an alternative approach to paging](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/#retrieving-a-subset-of-records-with-offset-and-length). .</param>
    /// <param name="length">Sets the number of hits to retrieve (for use with &#x60;offset&#x60;). &gt; **Note**: Using &#x60;page&#x60; and &#x60;hitsPerPage&#x60; is the recommended method for [paging results](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/). However, you can use &#x60;offset&#x60; and &#x60;length&#x60; to implement [an alternative approach to paging](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/#retrieving-a-subset-of-records-with-offset-and-length). .</param>
    /// <param name="aroundLatLng">Search for entries [around a central location](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filter-around-a-central-point), enabling a geographical search within a circular area. (default to &quot;&quot;).</param>
    /// <param name="aroundLatLngViaIP">Search for entries around a location. The location is automatically computed from the requester&#39;s IP address. (default to false).</param>
    /// <param name="aroundRadius">aroundRadius.</param>
    /// <param name="aroundPrecision">aroundPrecision.</param>
    /// <param name="minimumAroundRadius">Minimum radius (in meters) used for a geographical search when &#x60;aroundRadius&#x60; isn&#39;t set..</param>
    /// <param name="insideBoundingBox">Search inside a [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates)..</param>
    /// <param name="insidePolygon">Search inside a [polygon](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates)..</param>
    /// <param name="naturalLanguages">Changes the default values of parameters that work best for a natural language query, such as &#x60;ignorePlurals&#x60;, &#x60;removeStopWords&#x60;, &#x60;removeWordsIfNoResults&#x60;, &#x60;analyticsTags&#x60;, and &#x60;ruleContexts&#x60;. These parameters work well together when the query consists of fuller natural language strings instead of keywords, for example when processing voice search queries..</param>
    /// <param name="ruleContexts">Assigns [rule contexts](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#whats-a-context) to search queries..</param>
    /// <param name="personalizationImpact">Defines how much [Personalization affects results](https://www.algolia.com/doc/guides/personalization/personalizing-results/in-depth/configuring-personalization/#understanding-personalization-impact). (default to 100).</param>
    /// <param name="userToken">Associates a [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/) with the current search..</param>
    /// <param name="getRankingInfo">Incidates whether the search response includes [detailed ranking information](https://www.algolia.com/doc/guides/building-search-ui/going-further/backend-search/in-depth/understanding-the-api-response/#ranking-information). (default to false).</param>
    /// <param name="explain">Enriches the API&#39;s response with information about how the query was processed..</param>
    /// <param name="synonyms">Whether to take into account an index&#39;s synonyms for a particular search. (default to true).</param>
    /// <param name="clickAnalytics">Indicates whether a query ID parameter is included in the search response. This is required for [tracking click and conversion events](https://www.algolia.com/doc/guides/sending-events/concepts/event-types/#events-related-to-algolia-requests). (default to false).</param>
    /// <param name="analytics">Indicates whether this query will be included in [analytics](https://www.algolia.com/doc/guides/search-analytics/guides/exclude-queries/). (default to true).</param>
    /// <param name="analyticsTags">Tags to apply to the query for [segmenting analytics data](https://www.algolia.com/doc/guides/search-analytics/guides/segments/)..</param>
    /// <param name="percentileComputation">Whether to include or exclude a query from the processing-time percentile computation. (default to true).</param>
    /// <param name="enableABTest">Incidates whether this search will be considered in A/B testing. (default to true).</param>
    public BaseSearchParams(string query = @"", string similarQuery = @"", string filters = @"", FacetFilters facetFilters = default(FacetFilters), OptionalFilters optionalFilters = default(OptionalFilters), NumericFilters numericFilters = default(NumericFilters), TagFilters tagFilters = default(TagFilters), bool sumOrFiltersScores = false, List<string> restrictSearchableAttributes = default(List<string>), List<string> facets = default(List<string>), bool facetingAfterDistinct = false, int page = 0, int offset = default(int), int length = default(int), string aroundLatLng = @"", bool aroundLatLngViaIP = false, AroundRadius aroundRadius = default(AroundRadius), AroundPrecision aroundPrecision = default(AroundPrecision), int minimumAroundRadius = default(int), List<List<double>> insideBoundingBox = default(List<List<double>>), List<List<double>> insidePolygon = default(List<List<double>>), List<string> naturalLanguages = default(List<string>), List<string> ruleContexts = default(List<string>), int personalizationImpact = 100, string userToken = default(string), bool getRankingInfo = false, List<string> explain = default(List<string>), bool synonyms = true, bool clickAnalytics = false, bool analytics = true, List<string> analyticsTags = default(List<string>), bool percentileComputation = true, bool enableABTest = true)
    {
      // use default value if no "query" provided
      this.Query = query ?? @"";
      // use default value if no "similarQuery" provided
      this.SimilarQuery = similarQuery ?? @"";
      // use default value if no "filters" provided
      this.Filters = filters ?? @"";
      this.FacetFilters = facetFilters;
      this.OptionalFilters = optionalFilters;
      this.NumericFilters = numericFilters;
      this.TagFilters = tagFilters;
      this.SumOrFiltersScores = sumOrFiltersScores;
      this.RestrictSearchableAttributes = restrictSearchableAttributes;
      this.Facets = facets;
      this.FacetingAfterDistinct = facetingAfterDistinct;
      this.Page = page;
      this.Offset = offset;
      this.Length = length;
      // use default value if no "aroundLatLng" provided
      this.AroundLatLng = aroundLatLng ?? @"";
      this.AroundLatLngViaIP = aroundLatLngViaIP;
      this.AroundRadius = aroundRadius;
      this.AroundPrecision = aroundPrecision;
      this.MinimumAroundRadius = minimumAroundRadius;
      this.InsideBoundingBox = insideBoundingBox;
      this.InsidePolygon = insidePolygon;
      this.NaturalLanguages = naturalLanguages;
      this.RuleContexts = ruleContexts;
      this.PersonalizationImpact = personalizationImpact;
      this.UserToken = userToken;
      this.GetRankingInfo = getRankingInfo;
      this.Explain = explain;
      this.Synonyms = synonyms;
      this.ClickAnalytics = clickAnalytics;
      this.Analytics = analytics;
      this.AnalyticsTags = analyticsTags;
      this.PercentileComputation = percentileComputation;
      this.EnableABTest = enableABTest;
    }

    /// <summary>
    /// Text to search for in an index.
    /// </summary>
    /// <value>Text to search for in an index.</value>
    [DataMember(Name = "query", EmitDefaultValue = false)]
    public string Query { get; set; }

    /// <summary>
    /// Overrides the query parameter and performs a more generic search.
    /// </summary>
    /// <value>Overrides the query parameter and performs a more generic search.</value>
    [DataMember(Name = "similarQuery", EmitDefaultValue = false)]
    public string SimilarQuery { get; set; }

    /// <summary>
    /// [Filter](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/) the query with numeric, facet, or tag filters. 
    /// </summary>
    /// <value>[Filter](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/) the query with numeric, facet, or tag filters. </value>
    [DataMember(Name = "filters", EmitDefaultValue = false)]
    public string Filters { get; set; }

    /// <summary>
    /// Gets or Sets FacetFilters
    /// </summary>
    [DataMember(Name = "facetFilters", EmitDefaultValue = false)]
    public FacetFilters FacetFilters { get; set; }

    /// <summary>
    /// Gets or Sets OptionalFilters
    /// </summary>
    [DataMember(Name = "optionalFilters", EmitDefaultValue = false)]
    public OptionalFilters OptionalFilters { get; set; }

    /// <summary>
    /// Gets or Sets NumericFilters
    /// </summary>
    [DataMember(Name = "numericFilters", EmitDefaultValue = false)]
    public NumericFilters NumericFilters { get; set; }

    /// <summary>
    /// Gets or Sets TagFilters
    /// </summary>
    [DataMember(Name = "tagFilters", EmitDefaultValue = false)]
    public TagFilters TagFilters { get; set; }

    /// <summary>
    /// Determines how to calculate [filter scores](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/filter-scoring/#accumulating-scores-with-sumorfiltersscores). If &#x60;false&#x60;, maximum score is kept. If &#x60;true&#x60;, score is summed. 
    /// </summary>
    /// <value>Determines how to calculate [filter scores](https://www.algolia.com/doc/guides/managing-results/refine-results/filtering/in-depth/filter-scoring/#accumulating-scores-with-sumorfiltersscores). If &#x60;false&#x60;, maximum score is kept. If &#x60;true&#x60;, score is summed. </value>
    [DataMember(Name = "sumOrFiltersScores", EmitDefaultValue = true)]
    public bool SumOrFiltersScores { get; set; }

    /// <summary>
    /// Restricts a query to only look at a subset of your [searchable attributes](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/).
    /// </summary>
    /// <value>Restricts a query to only look at a subset of your [searchable attributes](https://www.algolia.com/doc/guides/managing-results/must-do/searchable-attributes/).</value>
    [DataMember(Name = "restrictSearchableAttributes", EmitDefaultValue = false)]
    public List<string> RestrictSearchableAttributes { get; set; }

    /// <summary>
    /// Returns [facets](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#contextual-facet-values-and-counts), their facet values, and the number of matching facet values.
    /// </summary>
    /// <value>Returns [facets](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#contextual-facet-values-and-counts), their facet values, and the number of matching facet values.</value>
    [DataMember(Name = "facets", EmitDefaultValue = false)]
    public List<string> Facets { get; set; }

    /// <summary>
    /// Forces faceting to be applied after [de-duplication](https://www.algolia.com/doc/guides/managing-results/refine-results/grouping/) (with the distinct feature). Alternatively, the &#x60;afterDistinct&#x60; [modifier](https://www.algolia.com/doc/api-reference/api-parameters/attributesForFaceting/#modifiers) of &#x60;attributesForFaceting&#x60; allows for more granular control. 
    /// </summary>
    /// <value>Forces faceting to be applied after [de-duplication](https://www.algolia.com/doc/guides/managing-results/refine-results/grouping/) (with the distinct feature). Alternatively, the &#x60;afterDistinct&#x60; [modifier](https://www.algolia.com/doc/api-reference/api-parameters/attributesForFaceting/#modifiers) of &#x60;attributesForFaceting&#x60; allows for more granular control. </value>
    [DataMember(Name = "facetingAfterDistinct", EmitDefaultValue = true)]
    public bool FacetingAfterDistinct { get; set; }

    /// <summary>
    /// Page to retrieve (the first page is &#x60;0&#x60;, not &#x60;1&#x60;).
    /// </summary>
    /// <value>Page to retrieve (the first page is &#x60;0&#x60;, not &#x60;1&#x60;).</value>
    [DataMember(Name = "page", EmitDefaultValue = false)]
    public int Page { get; set; }

    /// <summary>
    /// Specifies the offset of the first hit to return. &gt; **Note**: Using &#x60;page&#x60; and &#x60;hitsPerPage&#x60; is the recommended method for [paging results](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/). However, you can use &#x60;offset&#x60; and &#x60;length&#x60; to implement [an alternative approach to paging](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/#retrieving-a-subset-of-records-with-offset-and-length). 
    /// </summary>
    /// <value>Specifies the offset of the first hit to return. &gt; **Note**: Using &#x60;page&#x60; and &#x60;hitsPerPage&#x60; is the recommended method for [paging results](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/). However, you can use &#x60;offset&#x60; and &#x60;length&#x60; to implement [an alternative approach to paging](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/#retrieving-a-subset-of-records-with-offset-and-length). </value>
    [DataMember(Name = "offset", EmitDefaultValue = false)]
    public int Offset { get; set; }

    /// <summary>
    /// Sets the number of hits to retrieve (for use with &#x60;offset&#x60;). &gt; **Note**: Using &#x60;page&#x60; and &#x60;hitsPerPage&#x60; is the recommended method for [paging results](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/). However, you can use &#x60;offset&#x60; and &#x60;length&#x60; to implement [an alternative approach to paging](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/#retrieving-a-subset-of-records-with-offset-and-length). 
    /// </summary>
    /// <value>Sets the number of hits to retrieve (for use with &#x60;offset&#x60;). &gt; **Note**: Using &#x60;page&#x60; and &#x60;hitsPerPage&#x60; is the recommended method for [paging results](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/). However, you can use &#x60;offset&#x60; and &#x60;length&#x60; to implement [an alternative approach to paging](https://www.algolia.com/doc/guides/building-search-ui/ui-and-ux-patterns/pagination/js/#retrieving-a-subset-of-records-with-offset-and-length). </value>
    [DataMember(Name = "length", EmitDefaultValue = false)]
    public int Length { get; set; }

    /// <summary>
    /// Search for entries [around a central location](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filter-around-a-central-point), enabling a geographical search within a circular area.
    /// </summary>
    /// <value>Search for entries [around a central location](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filter-around-a-central-point), enabling a geographical search within a circular area.</value>
    [DataMember(Name = "aroundLatLng", EmitDefaultValue = false)]
    public string AroundLatLng { get; set; }

    /// <summary>
    /// Search for entries around a location. The location is automatically computed from the requester&#39;s IP address.
    /// </summary>
    /// <value>Search for entries around a location. The location is automatically computed from the requester&#39;s IP address.</value>
    [DataMember(Name = "aroundLatLngViaIP", EmitDefaultValue = true)]
    public bool AroundLatLngViaIP { get; set; }

    /// <summary>
    /// Gets or Sets AroundRadius
    /// </summary>
    [DataMember(Name = "aroundRadius", EmitDefaultValue = false)]
    public AroundRadius AroundRadius { get; set; }

    /// <summary>
    /// Gets or Sets AroundPrecision
    /// </summary>
    [DataMember(Name = "aroundPrecision", EmitDefaultValue = false)]
    public AroundPrecision AroundPrecision { get; set; }

    /// <summary>
    /// Minimum radius (in meters) used for a geographical search when &#x60;aroundRadius&#x60; isn&#39;t set.
    /// </summary>
    /// <value>Minimum radius (in meters) used for a geographical search when &#x60;aroundRadius&#x60; isn&#39;t set.</value>
    [DataMember(Name = "minimumAroundRadius", EmitDefaultValue = false)]
    public int MinimumAroundRadius { get; set; }

    /// <summary>
    /// Search inside a [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates).
    /// </summary>
    /// <value>Search inside a [rectangular area](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates).</value>
    [DataMember(Name = "insideBoundingBox", EmitDefaultValue = false)]
    public List<List<double>> InsideBoundingBox { get; set; }

    /// <summary>
    /// Search inside a [polygon](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates).
    /// </summary>
    /// <value>Search inside a [polygon](https://www.algolia.com/doc/guides/managing-results/refine-results/geolocation/#filtering-inside-rectangular-or-polygonal-areas) (in geographical coordinates).</value>
    [DataMember(Name = "insidePolygon", EmitDefaultValue = false)]
    public List<List<double>> InsidePolygon { get; set; }

    /// <summary>
    /// Changes the default values of parameters that work best for a natural language query, such as &#x60;ignorePlurals&#x60;, &#x60;removeStopWords&#x60;, &#x60;removeWordsIfNoResults&#x60;, &#x60;analyticsTags&#x60;, and &#x60;ruleContexts&#x60;. These parameters work well together when the query consists of fuller natural language strings instead of keywords, for example when processing voice search queries.
    /// </summary>
    /// <value>Changes the default values of parameters that work best for a natural language query, such as &#x60;ignorePlurals&#x60;, &#x60;removeStopWords&#x60;, &#x60;removeWordsIfNoResults&#x60;, &#x60;analyticsTags&#x60;, and &#x60;ruleContexts&#x60;. These parameters work well together when the query consists of fuller natural language strings instead of keywords, for example when processing voice search queries.</value>
    [DataMember(Name = "naturalLanguages", EmitDefaultValue = false)]
    public List<string> NaturalLanguages { get; set; }

    /// <summary>
    /// Assigns [rule contexts](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#whats-a-context) to search queries.
    /// </summary>
    /// <value>Assigns [rule contexts](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/how-to/customize-search-results-by-platform/#whats-a-context) to search queries.</value>
    [DataMember(Name = "ruleContexts", EmitDefaultValue = false)]
    public List<string> RuleContexts { get; set; }

    /// <summary>
    /// Defines how much [Personalization affects results](https://www.algolia.com/doc/guides/personalization/personalizing-results/in-depth/configuring-personalization/#understanding-personalization-impact).
    /// </summary>
    /// <value>Defines how much [Personalization affects results](https://www.algolia.com/doc/guides/personalization/personalizing-results/in-depth/configuring-personalization/#understanding-personalization-impact).</value>
    [DataMember(Name = "personalizationImpact", EmitDefaultValue = false)]
    public int PersonalizationImpact { get; set; }

    /// <summary>
    /// Associates a [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/) with the current search.
    /// </summary>
    /// <value>Associates a [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/) with the current search.</value>
    [DataMember(Name = "userToken", EmitDefaultValue = false)]
    public string UserToken { get; set; }

    /// <summary>
    /// Incidates whether the search response includes [detailed ranking information](https://www.algolia.com/doc/guides/building-search-ui/going-further/backend-search/in-depth/understanding-the-api-response/#ranking-information).
    /// </summary>
    /// <value>Incidates whether the search response includes [detailed ranking information](https://www.algolia.com/doc/guides/building-search-ui/going-further/backend-search/in-depth/understanding-the-api-response/#ranking-information).</value>
    [DataMember(Name = "getRankingInfo", EmitDefaultValue = true)]
    public bool GetRankingInfo { get; set; }

    /// <summary>
    /// Enriches the API&#39;s response with information about how the query was processed.
    /// </summary>
    /// <value>Enriches the API&#39;s response with information about how the query was processed.</value>
    [DataMember(Name = "explain", EmitDefaultValue = false)]
    public List<string> Explain { get; set; }

    /// <summary>
    /// Whether to take into account an index&#39;s synonyms for a particular search.
    /// </summary>
    /// <value>Whether to take into account an index&#39;s synonyms for a particular search.</value>
    [DataMember(Name = "synonyms", EmitDefaultValue = true)]
    public bool Synonyms { get; set; }

    /// <summary>
    /// Indicates whether a query ID parameter is included in the search response. This is required for [tracking click and conversion events](https://www.algolia.com/doc/guides/sending-events/concepts/event-types/#events-related-to-algolia-requests).
    /// </summary>
    /// <value>Indicates whether a query ID parameter is included in the search response. This is required for [tracking click and conversion events](https://www.algolia.com/doc/guides/sending-events/concepts/event-types/#events-related-to-algolia-requests).</value>
    [DataMember(Name = "clickAnalytics", EmitDefaultValue = true)]
    public bool ClickAnalytics { get; set; }

    /// <summary>
    /// Indicates whether this query will be included in [analytics](https://www.algolia.com/doc/guides/search-analytics/guides/exclude-queries/).
    /// </summary>
    /// <value>Indicates whether this query will be included in [analytics](https://www.algolia.com/doc/guides/search-analytics/guides/exclude-queries/).</value>
    [DataMember(Name = "analytics", EmitDefaultValue = true)]
    public bool Analytics { get; set; }

    /// <summary>
    /// Tags to apply to the query for [segmenting analytics data](https://www.algolia.com/doc/guides/search-analytics/guides/segments/).
    /// </summary>
    /// <value>Tags to apply to the query for [segmenting analytics data](https://www.algolia.com/doc/guides/search-analytics/guides/segments/).</value>
    [DataMember(Name = "analyticsTags", EmitDefaultValue = false)]
    public List<string> AnalyticsTags { get; set; }

    /// <summary>
    /// Whether to include or exclude a query from the processing-time percentile computation.
    /// </summary>
    /// <value>Whether to include or exclude a query from the processing-time percentile computation.</value>
    [DataMember(Name = "percentileComputation", EmitDefaultValue = true)]
    public bool PercentileComputation { get; set; }

    /// <summary>
    /// Incidates whether this search will be considered in A/B testing.
    /// </summary>
    /// <value>Incidates whether this search will be considered in A/B testing.</value>
    [DataMember(Name = "enableABTest", EmitDefaultValue = true)]
    public bool EnableABTest { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class BaseSearchParams {\n");
      sb.Append("  Query: ").Append(Query).Append("\n");
      sb.Append("  SimilarQuery: ").Append(SimilarQuery).Append("\n");
      sb.Append("  Filters: ").Append(Filters).Append("\n");
      sb.Append("  FacetFilters: ").Append(FacetFilters).Append("\n");
      sb.Append("  OptionalFilters: ").Append(OptionalFilters).Append("\n");
      sb.Append("  NumericFilters: ").Append(NumericFilters).Append("\n");
      sb.Append("  TagFilters: ").Append(TagFilters).Append("\n");
      sb.Append("  SumOrFiltersScores: ").Append(SumOrFiltersScores).Append("\n");
      sb.Append("  RestrictSearchableAttributes: ").Append(RestrictSearchableAttributes).Append("\n");
      sb.Append("  Facets: ").Append(Facets).Append("\n");
      sb.Append("  FacetingAfterDistinct: ").Append(FacetingAfterDistinct).Append("\n");
      sb.Append("  Page: ").Append(Page).Append("\n");
      sb.Append("  Offset: ").Append(Offset).Append("\n");
      sb.Append("  Length: ").Append(Length).Append("\n");
      sb.Append("  AroundLatLng: ").Append(AroundLatLng).Append("\n");
      sb.Append("  AroundLatLngViaIP: ").Append(AroundLatLngViaIP).Append("\n");
      sb.Append("  AroundRadius: ").Append(AroundRadius).Append("\n");
      sb.Append("  AroundPrecision: ").Append(AroundPrecision).Append("\n");
      sb.Append("  MinimumAroundRadius: ").Append(MinimumAroundRadius).Append("\n");
      sb.Append("  InsideBoundingBox: ").Append(InsideBoundingBox).Append("\n");
      sb.Append("  InsidePolygon: ").Append(InsidePolygon).Append("\n");
      sb.Append("  NaturalLanguages: ").Append(NaturalLanguages).Append("\n");
      sb.Append("  RuleContexts: ").Append(RuleContexts).Append("\n");
      sb.Append("  PersonalizationImpact: ").Append(PersonalizationImpact).Append("\n");
      sb.Append("  UserToken: ").Append(UserToken).Append("\n");
      sb.Append("  GetRankingInfo: ").Append(GetRankingInfo).Append("\n");
      sb.Append("  Explain: ").Append(Explain).Append("\n");
      sb.Append("  Synonyms: ").Append(Synonyms).Append("\n");
      sb.Append("  ClickAnalytics: ").Append(ClickAnalytics).Append("\n");
      sb.Append("  Analytics: ").Append(Analytics).Append("\n");
      sb.Append("  AnalyticsTags: ").Append(AnalyticsTags).Append("\n");
      sb.Append("  PercentileComputation: ").Append(PercentileComputation).Append("\n");
      sb.Append("  EnableABTest: ").Append(EnableABTest).Append("\n");
      sb.Append("}\n");
      return sb.ToString();
    }

    /// <summary>
    /// Returns the JSON string presentation of the object
    /// </summary>
    /// <returns>JSON string presentation of the object</returns>
    public virtual string ToJson()
    {
      return Newtonsoft.Json.JsonConvert.SerializeObject(this, Newtonsoft.Json.Formatting.Indented);
    }

  }

}
