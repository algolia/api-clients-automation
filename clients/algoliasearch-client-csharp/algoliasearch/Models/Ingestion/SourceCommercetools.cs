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

namespace Algolia.Search.Models.Ingestion;

/// <summary>
/// SourceCommercetools
/// </summary>
[DataContract(Name = "SourceCommercetools")]
public partial class SourceCommercetools
{
  /// <summary>
  /// Initializes a new instance of the SourceCommercetools class.
  /// </summary>
  [JsonConstructor]
  public SourceCommercetools() { }
  /// <summary>
  /// Initializes a new instance of the SourceCommercetools class.
  /// </summary>
  /// <param name="url">url (required).</param>
  /// <param name="projectKey">projectKey (required).</param>
  public SourceCommercetools(string url, string projectKey)
  {
    Url = url ?? throw new ArgumentNullException(nameof(url));
    ProjectKey = projectKey ?? throw new ArgumentNullException(nameof(projectKey));
  }

  /// <summary>
  /// Gets or Sets StoreKeys
  /// </summary>
  [DataMember(Name = "storeKeys")]
  public List<string> StoreKeys { get; set; }

  /// <summary>
  /// Array of locales that must match the following pattern: ^[a-z]{2}(-[A-Z]{2})?$. For example [\"fr-FR\", \"en\"]. 
  /// </summary>
  /// <value>Array of locales that must match the following pattern: ^[a-z]{2}(-[A-Z]{2})?$. For example [\"fr-FR\", \"en\"]. </value>
  [DataMember(Name = "locales")]
  public List<string> Locales { get; set; }

  /// <summary>
  /// Gets or Sets Url
  /// </summary>
  [DataMember(Name = "url")]
  public string Url { get; set; }

  /// <summary>
  /// Gets or Sets ProjectKey
  /// </summary>
  [DataMember(Name = "projectKey")]
  public string ProjectKey { get; set; }

  /// <summary>
  /// Determines the value that will be stored in the Algolia record if there's no inventory information on the product. 
  /// </summary>
  /// <value>Determines the value that will be stored in the Algolia record if there's no inventory information on the product. </value>
  [DataMember(Name = "fallbackIsInStockValue")]
  public bool? FallbackIsInStockValue { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class SourceCommercetools {\n");
    sb.Append("  StoreKeys: ").Append(StoreKeys).Append("\n");
    sb.Append("  Locales: ").Append(Locales).Append("\n");
    sb.Append("  Url: ").Append(Url).Append("\n");
    sb.Append("  ProjectKey: ").Append(ProjectKey).Append("\n");
    sb.Append("  FallbackIsInStockValue: ").Append(FallbackIsInStockValue).Append("\n");
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

