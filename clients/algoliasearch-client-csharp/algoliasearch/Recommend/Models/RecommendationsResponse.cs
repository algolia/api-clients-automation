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

namespace Algolia.Search.Recommend.Models
{
  /// <summary>
  /// RecommendationsResponse
  /// </summary>
  [DataContract(Name = "recommendationsResponse")]
  public partial class RecommendationsResponse
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="RecommendationsResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected RecommendationsResponse() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="RecommendationsResponse" /> class.
    /// </summary>
    /// <param name="abTestID">A/B test ID. This is only included in the response for indices that are part of an A/B test..</param>
    /// <param name="abTestVariantID">Variant ID. This is only included in the response for indices that are part of an A/B test..</param>
    /// <param name="aroundLatLng">Computed geographical location..</param>
    /// <param name="automaticRadius">Automatically-computed radius..</param>
    /// <param name="exhaustive">exhaustive.</param>
    /// <param name="exhaustiveFacetsCount">See the &#x60;facetsCount&#x60; field of the &#x60;exhaustive&#x60; object in the response..</param>
    /// <param name="exhaustiveNbHits">See the &#x60;nbHits&#x60; field of the &#x60;exhaustive&#x60; object in the response..</param>
    /// <param name="exhaustiveTypo">See the &#x60;typo&#x60; field of the &#x60;exhaustive&#x60; object in the response..</param>
    /// <param name="facets">Mapping of each facet name to the corresponding facet counts..</param>
    /// <param name="facetsStats">Statistics for numerical facets..</param>
    /// <param name="hitsPerPage">Number of hits per page. (required) (default to 20).</param>
    /// <param name="index">Index name used for the query..</param>
    /// <param name="indexUsed">Index name used for the query. During A/B testing, the targeted index isn&#39;t always the index used by the query..</param>
    /// <param name="message">Warnings about the query..</param>
    /// <param name="nbHits">Number of hits the search query matched. (required).</param>
    /// <param name="nbPages">Number of pages of results for the current query. (required).</param>
    /// <param name="nbSortedHits">Number of hits selected and sorted by the relevant sort algorithm..</param>
    /// <param name="page">Page to retrieve (the first page is &#x60;0&#x60;, not &#x60;1&#x60;). (required) (default to 0).</param>
    /// <param name="parsedQuery">Post-[normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean) query string that will be searched..</param>
    /// <param name="processingTimeMS">Time the server took to process the request, in milliseconds. (required).</param>
    /// <param name="processingTimingsMS">Experimental. List of processing steps and their times, in milliseconds. You can use this list to investigate performance issues..</param>
    /// <param name="queryAfterRemoval">Markup text indicating which parts of the original query have been removed to retrieve a non-empty result set..</param>
    /// <param name="redirect">redirect.</param>
    /// <param name="renderingContent">renderingContent.</param>
    /// <param name="serverTimeMS">Time the server took to process the request, in milliseconds..</param>
    /// <param name="serverUsed">Host name of the server that processed the request..</param>
    /// <param name="userData">Lets you store custom data in your indices..</param>
    /// <param name="hits">hits (required).</param>
    /// <param name="query">Text to search for in an index. (default to &quot;&quot;).</param>
    /// <param name="varParams">URL-encoded string of all search parameters..</param>
    public RecommendationsResponse(int abTestID = default(int), int abTestVariantID = default(int), string aroundLatLng = default(string), string automaticRadius = default(string), Exhaustive exhaustive = default(Exhaustive), bool exhaustiveFacetsCount = default(bool), bool exhaustiveNbHits = default(bool), bool exhaustiveTypo = default(bool), Dictionary<string, Dictionary<string, int>> facets = default(Dictionary<string, Dictionary<string, int>>), Dictionary<string, FacetsStats> facetsStats = default(Dictionary<string, FacetsStats>), int hitsPerPage = 20, string index = default(string), string indexUsed = default(string), string message = default(string), int nbHits = default(int), int nbPages = default(int), int nbSortedHits = default(int), int page = 0, string parsedQuery = default(string), int processingTimeMS = default(int), Object processingTimingsMS = default(Object), string queryAfterRemoval = default(string), Redirect redirect = default(Redirect), RenderingContent renderingContent = default(RenderingContent), int serverTimeMS = default(int), string serverUsed = default(string), Object userData = default(Object), List<RecommendHit> hits = default(List<RecommendHit>), string query = @"", string varParams = default(string))
    {
      this.HitsPerPage = hitsPerPage;
      this.NbHits = nbHits;
      this.NbPages = nbPages;
      this.Page = page;
      this.ProcessingTimeMS = processingTimeMS;
      // to ensure "hits" is required (not null)
      if (hits == null)
      {
        throw new ArgumentNullException("hits is a required property for RecommendationsResponse and cannot be null");
      }
      this.Hits = hits;
      this.AbTestID = abTestID;
      this.AbTestVariantID = abTestVariantID;
      this.AroundLatLng = aroundLatLng;
      this.AutomaticRadius = automaticRadius;
      this.Exhaustive = exhaustive;
      this.ExhaustiveFacetsCount = exhaustiveFacetsCount;
      this.ExhaustiveNbHits = exhaustiveNbHits;
      this.ExhaustiveTypo = exhaustiveTypo;
      this.Facets = facets;
      this.FacetsStats = facetsStats;
      this.Index = index;
      this.IndexUsed = indexUsed;
      this.Message = message;
      this.NbSortedHits = nbSortedHits;
      this.ParsedQuery = parsedQuery;
      this.ProcessingTimingsMS = processingTimingsMS;
      this.QueryAfterRemoval = queryAfterRemoval;
      this.Redirect = redirect;
      this.RenderingContent = renderingContent;
      this.ServerTimeMS = serverTimeMS;
      this.ServerUsed = serverUsed;
      this.UserData = userData;
      // use default value if no "query" provided
      this.Query = query ?? @"";
      this.VarParams = varParams;
    }

    /// <summary>
    /// A/B test ID. This is only included in the response for indices that are part of an A/B test.
    /// </summary>
    /// <value>A/B test ID. This is only included in the response for indices that are part of an A/B test.</value>
    [DataMember(Name = "abTestID", EmitDefaultValue = false)]
    public int AbTestID { get; set; }

    /// <summary>
    /// Variant ID. This is only included in the response for indices that are part of an A/B test.
    /// </summary>
    /// <value>Variant ID. This is only included in the response for indices that are part of an A/B test.</value>
    [DataMember(Name = "abTestVariantID", EmitDefaultValue = false)]
    public int AbTestVariantID { get; set; }

    /// <summary>
    /// Computed geographical location.
    /// </summary>
    /// <value>Computed geographical location.</value>
    [DataMember(Name = "aroundLatLng", EmitDefaultValue = false)]
    public string AroundLatLng { get; set; }

    /// <summary>
    /// Automatically-computed radius.
    /// </summary>
    /// <value>Automatically-computed radius.</value>
    [DataMember(Name = "automaticRadius", EmitDefaultValue = false)]
    public string AutomaticRadius { get; set; }

    /// <summary>
    /// Gets or Sets Exhaustive
    /// </summary>
    [DataMember(Name = "exhaustive", EmitDefaultValue = false)]
    public Exhaustive Exhaustive { get; set; }

    /// <summary>
    /// See the &#x60;facetsCount&#x60; field of the &#x60;exhaustive&#x60; object in the response.
    /// </summary>
    /// <value>See the &#x60;facetsCount&#x60; field of the &#x60;exhaustive&#x60; object in the response.</value>
    [DataMember(Name = "exhaustiveFacetsCount", EmitDefaultValue = true)]
    [Obsolete]
    public bool ExhaustiveFacetsCount { get; set; }

    /// <summary>
    /// See the &#x60;nbHits&#x60; field of the &#x60;exhaustive&#x60; object in the response.
    /// </summary>
    /// <value>See the &#x60;nbHits&#x60; field of the &#x60;exhaustive&#x60; object in the response.</value>
    [DataMember(Name = "exhaustiveNbHits", EmitDefaultValue = true)]
    [Obsolete]
    public bool ExhaustiveNbHits { get; set; }

    /// <summary>
    /// See the &#x60;typo&#x60; field of the &#x60;exhaustive&#x60; object in the response.
    /// </summary>
    /// <value>See the &#x60;typo&#x60; field of the &#x60;exhaustive&#x60; object in the response.</value>
    [DataMember(Name = "exhaustiveTypo", EmitDefaultValue = true)]
    [Obsolete]
    public bool ExhaustiveTypo { get; set; }

    /// <summary>
    /// Mapping of each facet name to the corresponding facet counts.
    /// </summary>
    /// <value>Mapping of each facet name to the corresponding facet counts.</value>
    [DataMember(Name = "facets", EmitDefaultValue = false)]
    public Dictionary<string, Dictionary<string, int>> Facets { get; set; }

    /// <summary>
    /// Statistics for numerical facets.
    /// </summary>
    /// <value>Statistics for numerical facets.</value>
    [DataMember(Name = "facets_stats", EmitDefaultValue = false)]
    public Dictionary<string, FacetsStats> FacetsStats { get; set; }

    /// <summary>
    /// Number of hits per page.
    /// </summary>
    /// <value>Number of hits per page.</value>
    [DataMember(Name = "hitsPerPage", IsRequired = true, EmitDefaultValue = true)]
    public int HitsPerPage { get; set; }

    /// <summary>
    /// Index name used for the query.
    /// </summary>
    /// <value>Index name used for the query.</value>
    [DataMember(Name = "index", EmitDefaultValue = false)]
    public string Index { get; set; }

    /// <summary>
    /// Index name used for the query. During A/B testing, the targeted index isn&#39;t always the index used by the query.
    /// </summary>
    /// <value>Index name used for the query. During A/B testing, the targeted index isn&#39;t always the index used by the query.</value>
    [DataMember(Name = "indexUsed", EmitDefaultValue = false)]
    public string IndexUsed { get; set; }

    /// <summary>
    /// Warnings about the query.
    /// </summary>
    /// <value>Warnings about the query.</value>
    [DataMember(Name = "message", EmitDefaultValue = false)]
    public string Message { get; set; }

    /// <summary>
    /// Number of hits the search query matched.
    /// </summary>
    /// <value>Number of hits the search query matched.</value>
    [DataMember(Name = "nbHits", IsRequired = true, EmitDefaultValue = true)]
    public int NbHits { get; set; }

    /// <summary>
    /// Number of pages of results for the current query.
    /// </summary>
    /// <value>Number of pages of results for the current query.</value>
    [DataMember(Name = "nbPages", IsRequired = true, EmitDefaultValue = true)]
    public int NbPages { get; set; }

    /// <summary>
    /// Number of hits selected and sorted by the relevant sort algorithm.
    /// </summary>
    /// <value>Number of hits selected and sorted by the relevant sort algorithm.</value>
    [DataMember(Name = "nbSortedHits", EmitDefaultValue = false)]
    public int NbSortedHits { get; set; }

    /// <summary>
    /// Page to retrieve (the first page is &#x60;0&#x60;, not &#x60;1&#x60;).
    /// </summary>
    /// <value>Page to retrieve (the first page is &#x60;0&#x60;, not &#x60;1&#x60;).</value>
    [DataMember(Name = "page", IsRequired = true, EmitDefaultValue = true)]
    public int Page { get; set; }

    /// <summary>
    /// Post-[normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean) query string that will be searched.
    /// </summary>
    /// <value>Post-[normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean) query string that will be searched.</value>
    [DataMember(Name = "parsedQuery", EmitDefaultValue = false)]
    public string ParsedQuery { get; set; }

    /// <summary>
    /// Time the server took to process the request, in milliseconds.
    /// </summary>
    /// <value>Time the server took to process the request, in milliseconds.</value>
    [DataMember(Name = "processingTimeMS", IsRequired = true, EmitDefaultValue = true)]
    public int ProcessingTimeMS { get; set; }

    /// <summary>
    /// Experimental. List of processing steps and their times, in milliseconds. You can use this list to investigate performance issues.
    /// </summary>
    /// <value>Experimental. List of processing steps and their times, in milliseconds. You can use this list to investigate performance issues.</value>
    [DataMember(Name = "processingTimingsMS", EmitDefaultValue = false)]
    public Object ProcessingTimingsMS { get; set; }

    /// <summary>
    /// Markup text indicating which parts of the original query have been removed to retrieve a non-empty result set.
    /// </summary>
    /// <value>Markup text indicating which parts of the original query have been removed to retrieve a non-empty result set.</value>
    [DataMember(Name = "queryAfterRemoval", EmitDefaultValue = false)]
    public string QueryAfterRemoval { get; set; }

    /// <summary>
    /// Gets or Sets Redirect
    /// </summary>
    [DataMember(Name = "redirect", EmitDefaultValue = false)]
    public Redirect Redirect { get; set; }

    /// <summary>
    /// Gets or Sets RenderingContent
    /// </summary>
    [DataMember(Name = "renderingContent", EmitDefaultValue = false)]
    public RenderingContent RenderingContent { get; set; }

    /// <summary>
    /// Time the server took to process the request, in milliseconds.
    /// </summary>
    /// <value>Time the server took to process the request, in milliseconds.</value>
    [DataMember(Name = "serverTimeMS", EmitDefaultValue = false)]
    public int ServerTimeMS { get; set; }

    /// <summary>
    /// Host name of the server that processed the request.
    /// </summary>
    /// <value>Host name of the server that processed the request.</value>
    [DataMember(Name = "serverUsed", EmitDefaultValue = false)]
    public string ServerUsed { get; set; }

    /// <summary>
    /// Lets you store custom data in your indices.
    /// </summary>
    /// <value>Lets you store custom data in your indices.</value>
    [DataMember(Name = "userData", EmitDefaultValue = false)]
    public Object UserData { get; set; }

    /// <summary>
    /// Gets or Sets Hits
    /// </summary>
    [DataMember(Name = "hits", IsRequired = true, EmitDefaultValue = true)]
    public List<RecommendHit> Hits { get; set; }

    /// <summary>
    /// Text to search for in an index.
    /// </summary>
    /// <value>Text to search for in an index.</value>
    [DataMember(Name = "query", EmitDefaultValue = false)]
    public string Query { get; set; }

    /// <summary>
    /// URL-encoded string of all search parameters.
    /// </summary>
    /// <value>URL-encoded string of all search parameters.</value>
    [DataMember(Name = "params", EmitDefaultValue = false)]
    public string VarParams { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class RecommendationsResponse {\n");
      sb.Append("  AbTestID: ").Append(AbTestID).Append("\n");
      sb.Append("  AbTestVariantID: ").Append(AbTestVariantID).Append("\n");
      sb.Append("  AroundLatLng: ").Append(AroundLatLng).Append("\n");
      sb.Append("  AutomaticRadius: ").Append(AutomaticRadius).Append("\n");
      sb.Append("  Exhaustive: ").Append(Exhaustive).Append("\n");
      sb.Append("  ExhaustiveFacetsCount: ").Append(ExhaustiveFacetsCount).Append("\n");
      sb.Append("  ExhaustiveNbHits: ").Append(ExhaustiveNbHits).Append("\n");
      sb.Append("  ExhaustiveTypo: ").Append(ExhaustiveTypo).Append("\n");
      sb.Append("  Facets: ").Append(Facets).Append("\n");
      sb.Append("  FacetsStats: ").Append(FacetsStats).Append("\n");
      sb.Append("  HitsPerPage: ").Append(HitsPerPage).Append("\n");
      sb.Append("  Index: ").Append(Index).Append("\n");
      sb.Append("  IndexUsed: ").Append(IndexUsed).Append("\n");
      sb.Append("  Message: ").Append(Message).Append("\n");
      sb.Append("  NbHits: ").Append(NbHits).Append("\n");
      sb.Append("  NbPages: ").Append(NbPages).Append("\n");
      sb.Append("  NbSortedHits: ").Append(NbSortedHits).Append("\n");
      sb.Append("  Page: ").Append(Page).Append("\n");
      sb.Append("  ParsedQuery: ").Append(ParsedQuery).Append("\n");
      sb.Append("  ProcessingTimeMS: ").Append(ProcessingTimeMS).Append("\n");
      sb.Append("  ProcessingTimingsMS: ").Append(ProcessingTimingsMS).Append("\n");
      sb.Append("  QueryAfterRemoval: ").Append(QueryAfterRemoval).Append("\n");
      sb.Append("  Redirect: ").Append(Redirect).Append("\n");
      sb.Append("  RenderingContent: ").Append(RenderingContent).Append("\n");
      sb.Append("  ServerTimeMS: ").Append(ServerTimeMS).Append("\n");
      sb.Append("  ServerUsed: ").Append(ServerUsed).Append("\n");
      sb.Append("  UserData: ").Append(UserData).Append("\n");
      sb.Append("  Hits: ").Append(Hits).Append("\n");
      sb.Append("  Query: ").Append(Query).Append("\n");
      sb.Append("  VarParams: ").Append(VarParams).Append("\n");
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
