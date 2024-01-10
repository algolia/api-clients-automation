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

namespace Algolia.Search.Models.Search
{
  /// <summary>
  /// SearchForFacetValuesRequest
  /// </summary>
  [DataContract(Name = "searchForFacetValuesRequest")]
  public partial class SearchForFacetValuesRequest
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="SearchForFacetValuesRequest" /> class.
    /// </summary>
    public SearchForFacetValuesRequest()
    {
    }

    /// <summary>
    /// Search parameters as a URL-encoded query string.
    /// </summary>
    /// <value>Search parameters as a URL-encoded query string.</value>
    [DataMember(Name = "params", EmitDefaultValue = false)]
    public string VarParams { get; set; }

    /// <summary>
    /// Text to search inside the facet&#39;s values.
    /// </summary>
    /// <value>Text to search inside the facet&#39;s values.</value>
    [DataMember(Name = "facetQuery", EmitDefaultValue = false)]
    public string FacetQuery { get; set; }

    /// <summary>
    /// Maximum number of facet hits to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).
    /// </summary>
    /// <value>Maximum number of facet hits to return when [searching for facet values](https://www.algolia.com/doc/guides/managing-results/refine-results/faceting/#search-for-facet-values).</value>
    [DataMember(Name = "maxFacetHits", EmitDefaultValue = false)]
    public int? MaxFacetHits { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class SearchForFacetValuesRequest {\n");
      sb.Append("  VarParams: ").Append(VarParams).Append("\n");
      sb.Append("  FacetQuery: ").Append(FacetQuery).Append("\n");
      sb.Append("  MaxFacetHits: ").Append(MaxFacetHits).Append("\n");
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
