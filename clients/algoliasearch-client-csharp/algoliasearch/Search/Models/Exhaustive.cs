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
  /// Whether certain properties of the search response are calculated exhaustive (exact) or approximated.
  /// </summary>
  [DataContract(Name = "exhaustive")]
  [JsonObject(MemberSerialization.OptOut)]
  public partial class Exhaustive
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="Exhaustive" /> class.
    /// </summary>
    public Exhaustive()
    {
    }

    /// <summary>
    /// Whether the facet count is exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). See the [related discussion](https://support.algolia.com/hc/en-us/articles/4406975248145-Why-are-my-facet-and-hit-counts-not-accurate-).
    /// </summary>
    /// <value>Whether the facet count is exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). See the [related discussion](https://support.algolia.com/hc/en-us/articles/4406975248145-Why-are-my-facet-and-hit-counts-not-accurate-).</value>
    [DataMember(Name = "facetsCount", EmitDefaultValue = false)]
    public bool? FacetsCount { get; set; }

    /// <summary>
    /// The value is &#x60;false&#x60; if not all facet values are retrieved.
    /// </summary>
    /// <value>The value is &#x60;false&#x60; if not all facet values are retrieved.</value>
    [DataMember(Name = "facetValues", EmitDefaultValue = false)]
    public bool? FacetValues { get; set; }

    /// <summary>
    /// Whether the &#x60;nbHits&#x60; is exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). When the query takes more than 50ms to be processed, the engine makes an approximation. This can happen when using complex filters on millions of records, when typo-tolerance was not exhaustive, or when enough hits have been retrieved (for example, after the engine finds 10,000 exact matches). &#x60;nbHits&#x60; is reported as non-exhaustive whenever an approximation is made, even if the approximation didn’t, in the end, impact the exhaustivity of the query.
    /// </summary>
    /// <value>Whether the &#x60;nbHits&#x60; is exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). When the query takes more than 50ms to be processed, the engine makes an approximation. This can happen when using complex filters on millions of records, when typo-tolerance was not exhaustive, or when enough hits have been retrieved (for example, after the engine finds 10,000 exact matches). &#x60;nbHits&#x60; is reported as non-exhaustive whenever an approximation is made, even if the approximation didn’t, in the end, impact the exhaustivity of the query.</value>
    [DataMember(Name = "nbHits", EmitDefaultValue = false)]
    public bool? NbHits { get; set; }

    /// <summary>
    /// Rules matching exhaustivity. The value is &#x60;false&#x60; if rules were enable for this query, and could not be fully processed due a timeout. This is generally caused by the number of alternatives (such as typos) which is too large.
    /// </summary>
    /// <value>Rules matching exhaustivity. The value is &#x60;false&#x60; if rules were enable for this query, and could not be fully processed due a timeout. This is generally caused by the number of alternatives (such as typos) which is too large.</value>
    [DataMember(Name = "rulesMatch", EmitDefaultValue = false)]
    public bool? RulesMatch { get; set; }

    /// <summary>
    /// Whether the typo search was exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). An approximation is done when the typo search query part takes more than 10% of the query budget (ie. 5ms by default) to be processed (this can happen when a lot of typo alternatives exist for the query). This field will not be included when typo-tolerance is entirely disabled.
    /// </summary>
    /// <value>Whether the typo search was exhaustive (&#x60;true&#x60;) or approximate (&#x60;false&#x60;). An approximation is done when the typo search query part takes more than 10% of the query budget (ie. 5ms by default) to be processed (this can happen when a lot of typo alternatives exist for the query). This field will not be included when typo-tolerance is entirely disabled.</value>
    [DataMember(Name = "typo", EmitDefaultValue = false)]
    public bool? Typo { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class Exhaustive {\n");
      sb.Append("  FacetsCount: ").Append(FacetsCount).Append("\n");
      sb.Append("  FacetValues: ").Append(FacetValues).Append("\n");
      sb.Append("  NbHits: ").Append(NbHits).Append("\n");
      sb.Append("  RulesMatch: ").Append(RulesMatch).Append("\n");
      sb.Append("  Typo: ").Append(Typo).Append("\n");
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
