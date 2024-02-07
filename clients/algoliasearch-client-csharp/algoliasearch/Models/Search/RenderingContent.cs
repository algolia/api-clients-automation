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
using Algolia.Search.Models.Common;
using Algolia.Search.Serializer;

namespace Algolia.Search.Models.Search;

/// <summary>
/// Extra content for the search UI, for example, to control the [ordering and display of facets](https://www.algolia.com/doc/guides/managing-results/rules/merchandising-and-promoting/how-to/merchandising-facets/#merchandise-facets-and-their-values-in-the-manual-editor). You can set a default value and dynamically override it with [Rules](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/).
/// </summary>
[DataContract(Name = "renderingContent")]
[JsonObject(MemberSerialization.OptOut)]
public partial class RenderingContent
{
  /// <summary>
  /// Initializes a new instance of the RenderingContent class.
  /// </summary>
  public RenderingContent()
  {
  }

  /// <summary>
  /// Gets or Sets FacetOrdering
  /// </summary>
  [DataMember(Name = "facetOrdering")]
  public FacetOrdering? FacetOrdering { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class RenderingContent {\n");
    sb.Append("  FacetOrdering: ").Append(FacetOrdering).Append("\n");
    sb.Append("}\n");
    return sb.ToString();
  }

  /// <summary>
  /// Returns the JSON string presentation of the object
  /// </summary>
  /// <returns>JSON string presentation of the object</returns>
  public virtual string ToJson()
  {
    return JsonConvert.SerializeObject(this, Formatting.Indented);
  }

}

