/*
 * Search API
 *
 * Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


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
using System.ComponentModel.DataAnnotations;
using OpenAPIDateConverter = Org.OpenAPITools.Client.OpenAPIDateConverter;

namespace Org.OpenAPITools.Model
{
  /// <summary>
  /// BaseSearchResponse
  /// </summary>
  [DataContract(Name = "baseSearchResponse")]
  public partial class BaseSearchResponse : Dictionary<String, Object>, IEquatable<BaseSearchResponse>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="BaseSearchResponse" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected BaseSearchResponse()
    {
      this.AdditionalProperties = new Dictionary<string, object>();
    }
    /// <summary>
    /// Initializes a new instance of the <see cref="BaseSearchResponse" /> class.
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
    public BaseSearchResponse(int abTestID = default(int), int abTestVariantID = default(int), string aroundLatLng = default(string), string automaticRadius = default(string), Exhaustive exhaustive = default(Exhaustive), bool exhaustiveFacetsCount = default(bool), bool exhaustiveNbHits = default(bool), bool exhaustiveTypo = default(bool), Dictionary<string, Dictionary<string, int>> facets = default(Dictionary<string, Dictionary<string, int>>), Dictionary<string, FacetsStats> facetsStats = default(Dictionary<string, FacetsStats>), int hitsPerPage = 20, string index = default(string), string indexUsed = default(string), string message = default(string), int nbHits = default(int), int nbPages = default(int), int nbSortedHits = default(int), int page = 0, string parsedQuery = default(string), int processingTimeMS = default(int), Object processingTimingsMS = default(Object), string queryAfterRemoval = default(string), Redirect redirect = default(Redirect), RenderingContent renderingContent = default(RenderingContent), int serverTimeMS = default(int), string serverUsed = default(string), Object userData = default(Object)) : base()
    {
      this.HitsPerPage = hitsPerPage;
      this.NbHits = nbHits;
      this.NbPages = nbPages;
      this.Page = page;
      this.ProcessingTimeMS = processingTimeMS;
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
      this.AdditionalProperties = new Dictionary<string, object>();
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
    /// <example>40.71,-74.01</example>
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
    /// <example>{&quot;category&quot;:{&quot;food&quot;:1,&quot;tech&quot;:42}}</example>
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
    /// <example>indexName</example>
    [DataMember(Name = "index", EmitDefaultValue = false)]
    public string Index { get; set; }

    /// <summary>
    /// Index name used for the query. During A/B testing, the targeted index isn&#39;t always the index used by the query.
    /// </summary>
    /// <value>Index name used for the query. During A/B testing, the targeted index isn&#39;t always the index used by the query.</value>
    /// <example>indexNameAlt</example>
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
    /// <example>20</example>
    [DataMember(Name = "nbHits", IsRequired = true, EmitDefaultValue = true)]
    public int NbHits { get; set; }

    /// <summary>
    /// Number of pages of results for the current query.
    /// </summary>
    /// <value>Number of pages of results for the current query.</value>
    /// <example>1</example>
    [DataMember(Name = "nbPages", IsRequired = true, EmitDefaultValue = true)]
    public int NbPages { get; set; }

    /// <summary>
    /// Number of hits selected and sorted by the relevant sort algorithm.
    /// </summary>
    /// <value>Number of hits selected and sorted by the relevant sort algorithm.</value>
    /// <example>20</example>
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
    /// <example>george clo</example>
    [DataMember(Name = "parsedQuery", EmitDefaultValue = false)]
    public string ParsedQuery { get; set; }

    /// <summary>
    /// Time the server took to process the request, in milliseconds.
    /// </summary>
    /// <value>Time the server took to process the request, in milliseconds.</value>
    /// <example>20</example>
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
    /// <example>20</example>
    [DataMember(Name = "serverTimeMS", EmitDefaultValue = false)]
    public int ServerTimeMS { get; set; }

    /// <summary>
    /// Host name of the server that processed the request.
    /// </summary>
    /// <value>Host name of the server that processed the request.</value>
    /// <example>c2-uk-3.algolia.net</example>
    [DataMember(Name = "serverUsed", EmitDefaultValue = false)]
    public string ServerUsed { get; set; }

    /// <summary>
    /// Lets you store custom data in your indices.
    /// </summary>
    /// <value>Lets you store custom data in your indices.</value>
    /// <example>{&quot;settingID&quot;:&quot;f2a7b51e3503acc6a39b3784ffb84300&quot;,&quot;pluginVersion&quot;:&quot;1.6.0&quot;}</example>
    [DataMember(Name = "userData", EmitDefaultValue = true)]
    public Object UserData { get; set; }

    /// <summary>
    /// Gets or Sets additional properties
    /// </summary>
    [JsonExtensionData]
    public IDictionary<string, object> AdditionalProperties { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class BaseSearchResponse {\n");
      sb.Append("  ").Append(base.ToString().Replace("\n", "\n  ")).Append("\n");
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
      sb.Append("  AdditionalProperties: ").Append(AdditionalProperties).Append("\n");
      sb.Append("}\n");
      return sb.ToString();
    }

    /// <summary>
    /// Returns the JSON string presentation of the object
    /// </summary>
    /// <returns>JSON string presentation of the object</returns>
    public string ToJson()
    {
      return Newtonsoft.Json.JsonConvert.SerializeObject(this, Newtonsoft.Json.Formatting.Indented);
    }

    /// <summary>
    /// Returns true if objects are equal
    /// </summary>
    /// <param name="input">Object to be compared</param>
    /// <returns>Boolean</returns>
    public override bool Equals(object input)
    {
      return this.Equals(input as BaseSearchResponse);
    }

    /// <summary>
    /// Returns true if BaseSearchResponse instances are equal
    /// </summary>
    /// <param name="input">Instance of BaseSearchResponse to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(BaseSearchResponse input)
    {
      if (input == null)
      {
        return false;
      }
      return base.Equals(input) &&
          (
              this.AbTestID == input.AbTestID ||
              this.AbTestID.Equals(input.AbTestID)
          ) && base.Equals(input) &&
          (
              this.AbTestVariantID == input.AbTestVariantID ||
              this.AbTestVariantID.Equals(input.AbTestVariantID)
          ) && base.Equals(input) &&
          (
              this.AroundLatLng == input.AroundLatLng ||
              (this.AroundLatLng != null &&
              this.AroundLatLng.Equals(input.AroundLatLng))
          ) && base.Equals(input) &&
          (
              this.AutomaticRadius == input.AutomaticRadius ||
              (this.AutomaticRadius != null &&
              this.AutomaticRadius.Equals(input.AutomaticRadius))
          ) && base.Equals(input) &&
          (
              this.Exhaustive == input.Exhaustive ||
              (this.Exhaustive != null &&
              this.Exhaustive.Equals(input.Exhaustive))
          ) && base.Equals(input) &&
          (
              this.ExhaustiveFacetsCount == input.ExhaustiveFacetsCount ||
              this.ExhaustiveFacetsCount.Equals(input.ExhaustiveFacetsCount)
          ) && base.Equals(input) &&
          (
              this.ExhaustiveNbHits == input.ExhaustiveNbHits ||
              this.ExhaustiveNbHits.Equals(input.ExhaustiveNbHits)
          ) && base.Equals(input) &&
          (
              this.ExhaustiveTypo == input.ExhaustiveTypo ||
              this.ExhaustiveTypo.Equals(input.ExhaustiveTypo)
          ) && base.Equals(input) &&
          (
              this.Facets == input.Facets ||
              this.Facets != null &&
              input.Facets != null &&
              this.Facets.SequenceEqual(input.Facets)
          ) && base.Equals(input) &&
          (
              this.FacetsStats == input.FacetsStats ||
              this.FacetsStats != null &&
              input.FacetsStats != null &&
              this.FacetsStats.SequenceEqual(input.FacetsStats)
          ) && base.Equals(input) &&
          (
              this.HitsPerPage == input.HitsPerPage ||
              this.HitsPerPage.Equals(input.HitsPerPage)
          ) && base.Equals(input) &&
          (
              this.Index == input.Index ||
              (this.Index != null &&
              this.Index.Equals(input.Index))
          ) && base.Equals(input) &&
          (
              this.IndexUsed == input.IndexUsed ||
              (this.IndexUsed != null &&
              this.IndexUsed.Equals(input.IndexUsed))
          ) && base.Equals(input) &&
          (
              this.Message == input.Message ||
              (this.Message != null &&
              this.Message.Equals(input.Message))
          ) && base.Equals(input) &&
          (
              this.NbHits == input.NbHits ||
              this.NbHits.Equals(input.NbHits)
          ) && base.Equals(input) &&
          (
              this.NbPages == input.NbPages ||
              this.NbPages.Equals(input.NbPages)
          ) && base.Equals(input) &&
          (
              this.NbSortedHits == input.NbSortedHits ||
              this.NbSortedHits.Equals(input.NbSortedHits)
          ) && base.Equals(input) &&
          (
              this.Page == input.Page ||
              this.Page.Equals(input.Page)
          ) && base.Equals(input) &&
          (
              this.ParsedQuery == input.ParsedQuery ||
              (this.ParsedQuery != null &&
              this.ParsedQuery.Equals(input.ParsedQuery))
          ) && base.Equals(input) &&
          (
              this.ProcessingTimeMS == input.ProcessingTimeMS ||
              this.ProcessingTimeMS.Equals(input.ProcessingTimeMS)
          ) && base.Equals(input) &&
          (
              this.ProcessingTimingsMS == input.ProcessingTimingsMS ||
              (this.ProcessingTimingsMS != null &&
              this.ProcessingTimingsMS.Equals(input.ProcessingTimingsMS))
          ) && base.Equals(input) &&
          (
              this.QueryAfterRemoval == input.QueryAfterRemoval ||
              (this.QueryAfterRemoval != null &&
              this.QueryAfterRemoval.Equals(input.QueryAfterRemoval))
          ) && base.Equals(input) &&
          (
              this.Redirect == input.Redirect ||
              (this.Redirect != null &&
              this.Redirect.Equals(input.Redirect))
          ) && base.Equals(input) &&
          (
              this.RenderingContent == input.RenderingContent ||
              (this.RenderingContent != null &&
              this.RenderingContent.Equals(input.RenderingContent))
          ) && base.Equals(input) &&
          (
              this.ServerTimeMS == input.ServerTimeMS ||
              this.ServerTimeMS.Equals(input.ServerTimeMS)
          ) && base.Equals(input) &&
          (
              this.ServerUsed == input.ServerUsed ||
              (this.ServerUsed != null &&
              this.ServerUsed.Equals(input.ServerUsed))
          ) && base.Equals(input) &&
          (
              this.UserData == input.UserData ||
              (this.UserData != null &&
              this.UserData.Equals(input.UserData))
          )
          && (this.AdditionalProperties.Count == input.AdditionalProperties.Count && !this.AdditionalProperties.Except(input.AdditionalProperties).Any());
    }

    /// <summary>
    /// Gets the hash code
    /// </summary>
    /// <returns>Hash code</returns>
    public override int GetHashCode()
    {
      unchecked // Overflow is fine, just wrap
      {
        int hashCode = base.GetHashCode();
        hashCode = (hashCode * 59) + this.AbTestID.GetHashCode();
        hashCode = (hashCode * 59) + this.AbTestVariantID.GetHashCode();
        if (this.AroundLatLng != null)
        {
          hashCode = (hashCode * 59) + this.AroundLatLng.GetHashCode();
        }
        if (this.AutomaticRadius != null)
        {
          hashCode = (hashCode * 59) + this.AutomaticRadius.GetHashCode();
        }
        if (this.Exhaustive != null)
        {
          hashCode = (hashCode * 59) + this.Exhaustive.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.ExhaustiveFacetsCount.GetHashCode();
        hashCode = (hashCode * 59) + this.ExhaustiveNbHits.GetHashCode();
        hashCode = (hashCode * 59) + this.ExhaustiveTypo.GetHashCode();
        if (this.Facets != null)
        {
          hashCode = (hashCode * 59) + this.Facets.GetHashCode();
        }
        if (this.FacetsStats != null)
        {
          hashCode = (hashCode * 59) + this.FacetsStats.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.HitsPerPage.GetHashCode();
        if (this.Index != null)
        {
          hashCode = (hashCode * 59) + this.Index.GetHashCode();
        }
        if (this.IndexUsed != null)
        {
          hashCode = (hashCode * 59) + this.IndexUsed.GetHashCode();
        }
        if (this.Message != null)
        {
          hashCode = (hashCode * 59) + this.Message.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.NbHits.GetHashCode();
        hashCode = (hashCode * 59) + this.NbPages.GetHashCode();
        hashCode = (hashCode * 59) + this.NbSortedHits.GetHashCode();
        hashCode = (hashCode * 59) + this.Page.GetHashCode();
        if (this.ParsedQuery != null)
        {
          hashCode = (hashCode * 59) + this.ParsedQuery.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.ProcessingTimeMS.GetHashCode();
        if (this.ProcessingTimingsMS != null)
        {
          hashCode = (hashCode * 59) + this.ProcessingTimingsMS.GetHashCode();
        }
        if (this.QueryAfterRemoval != null)
        {
          hashCode = (hashCode * 59) + this.QueryAfterRemoval.GetHashCode();
        }
        if (this.Redirect != null)
        {
          hashCode = (hashCode * 59) + this.Redirect.GetHashCode();
        }
        if (this.RenderingContent != null)
        {
          hashCode = (hashCode * 59) + this.RenderingContent.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.ServerTimeMS.GetHashCode();
        if (this.ServerUsed != null)
        {
          hashCode = (hashCode * 59) + this.ServerUsed.GetHashCode();
        }
        if (this.UserData != null)
        {
          hashCode = (hashCode * 59) + this.UserData.GetHashCode();
        }
        if (this.AdditionalProperties != null)
        {
          hashCode = (hashCode * 59) + this.AdditionalProperties.GetHashCode();
        }
        return hashCode;
      }
    }

    /// <summary>
    /// To validate all properties of the instance
    /// </summary>
    /// <param name="validationContext">Validation context</param>
    /// <returns>Validation Result</returns>
    IEnumerable<System.ComponentModel.DataAnnotations.ValidationResult> IValidatableObject.Validate(ValidationContext validationContext)
    {
      return this.BaseValidate(validationContext);
    }

    /// <summary>
    /// To validate all properties of the instance
    /// </summary>
    /// <param name="validationContext">Validation context</param>
    /// <returns>Validation Result</returns>
    protected IEnumerable<System.ComponentModel.DataAnnotations.ValidationResult> BaseValidate(ValidationContext validationContext)
    {
      // AbTestVariantID (int) minimum
      if (this.AbTestVariantID < (int)1)
      {
        yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for AbTestVariantID, must be a value greater than or equal to 1.", new[] { "AbTestVariantID" });
      }

      if (this.AroundLatLng != null)
      {
        // AroundLatLng (string) pattern
        Regex regexAroundLatLng = new Regex(@"^(-?\d+(\.\d+)?),\s*(-?\d+(\.\d+)?)$", RegexOptions.CultureInvariant);
        if (!regexAroundLatLng.Match(this.AroundLatLng).Success)
        {
          yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for AroundLatLng, must match a pattern of " + regexAroundLatLng, new[] { "AroundLatLng" });
        }
      }

      // HitsPerPage (int) maximum
      if (this.HitsPerPage > (int)1000)
      {
        yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for HitsPerPage, must be a value less than or equal to 1000.", new[] { "HitsPerPage" });
      }

      // HitsPerPage (int) minimum
      if (this.HitsPerPage < (int)1)
      {
        yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for HitsPerPage, must be a value greater than or equal to 1.", new[] { "HitsPerPage" });
      }

      yield break;
    }
  }

}
