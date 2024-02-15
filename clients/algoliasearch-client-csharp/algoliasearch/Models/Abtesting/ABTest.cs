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

namespace Algolia.Search.Models.Abtesting;

/// <summary>
/// ABTest
/// </summary>
[DataContract(Name = "ABTest")]
public partial class ABTest
{
  /// <summary>
  /// Initializes a new instance of the ABTest class.
  /// </summary>
  [JsonConstructor]
  public ABTest() { }
  /// <summary>
  /// Initializes a new instance of the ABTest class.
  /// </summary>
  /// <param name="abTestID">Unique A/B test ID. (required).</param>
  /// <param name="clickSignificance">[A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on click data. A value of 0.95 or over is considered to be _significant_.  (required).</param>
  /// <param name="conversionSignificance">[A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on conversion. A value of 0.95 or over is considered to be _significant_.  (required).</param>
  /// <param name="addToCartSignificance">[A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on add-to-cart data. A value of 0.95 or over is considered to be _significant_.  (required).</param>
  /// <param name="purchaseSignificance">[A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on purchase data. A value of 0.95 or over is considered to be _significant_.  (required).</param>
  /// <param name="revenueSignificance">[A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on revenue data. A value of 0.95 or over is considered to be _significant_.  (required).</param>
  /// <param name="updatedAt">Update date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format. (required).</param>
  /// <param name="createdAt">Creation date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format. (required).</param>
  /// <param name="endAt">End date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format. (required).</param>
  /// <param name="name">A/B test name. (required).</param>
  /// <param name="status">A/B test status. (required).</param>
  /// <param name="variants">A/B test variants. (required).</param>
  public ABTest(int abTestID, double? clickSignificance, double? conversionSignificance, double? addToCartSignificance, double? purchaseSignificance, Dictionary<string, double> revenueSignificance, string updatedAt, string createdAt, string endAt, string name, string status, List<Variant> variants)
  {
    AbTestID = abTestID;
    ClickSignificance = clickSignificance ?? throw new ArgumentNullException(nameof(clickSignificance));
    ConversionSignificance = conversionSignificance ?? throw new ArgumentNullException(nameof(conversionSignificance));
    AddToCartSignificance = addToCartSignificance ?? throw new ArgumentNullException(nameof(addToCartSignificance));
    PurchaseSignificance = purchaseSignificance ?? throw new ArgumentNullException(nameof(purchaseSignificance));
    RevenueSignificance = revenueSignificance ?? throw new ArgumentNullException(nameof(revenueSignificance));
    UpdatedAt = updatedAt ?? throw new ArgumentNullException(nameof(updatedAt));
    CreatedAt = createdAt ?? throw new ArgumentNullException(nameof(createdAt));
    EndAt = endAt ?? throw new ArgumentNullException(nameof(endAt));
    Name = name ?? throw new ArgumentNullException(nameof(name));
    Status = status ?? throw new ArgumentNullException(nameof(status));
    Variants = variants ?? throw new ArgumentNullException(nameof(variants));
  }

  /// <summary>
  /// Unique A/B test ID.
  /// </summary>
  /// <value>Unique A/B test ID.</value>
  [DataMember(Name = "abTestID")]
  public int AbTestID { get; set; }

  /// <summary>
  /// [A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on click data. A value of 0.95 or over is considered to be _significant_. 
  /// </summary>
  /// <value>[A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on click data. A value of 0.95 or over is considered to be _significant_. </value>
  [DataMember(Name = "clickSignificance")]
  public double? ClickSignificance { get; set; }

  /// <summary>
  /// [A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on conversion. A value of 0.95 or over is considered to be _significant_. 
  /// </summary>
  /// <value>[A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on conversion. A value of 0.95 or over is considered to be _significant_. </value>
  [DataMember(Name = "conversionSignificance")]
  public double? ConversionSignificance { get; set; }

  /// <summary>
  /// [A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on add-to-cart data. A value of 0.95 or over is considered to be _significant_. 
  /// </summary>
  /// <value>[A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on add-to-cart data. A value of 0.95 or over is considered to be _significant_. </value>
  [DataMember(Name = "addToCartSignificance")]
  public double? AddToCartSignificance { get; set; }

  /// <summary>
  /// [A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on purchase data. A value of 0.95 or over is considered to be _significant_. 
  /// </summary>
  /// <value>[A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on purchase data. A value of 0.95 or over is considered to be _significant_. </value>
  [DataMember(Name = "purchaseSignificance")]
  public double? PurchaseSignificance { get; set; }

  /// <summary>
  /// [A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on revenue data. A value of 0.95 or over is considered to be _significant_. 
  /// </summary>
  /// <value>[A/B test significance](https://www.algolia.com/doc/guides/ab-testing/what-is-ab-testing/in-depth/how-ab-test-scores-are-calculated/#statistical-significance-or-chance) based on revenue data. A value of 0.95 or over is considered to be _significant_. </value>
  [DataMember(Name = "revenueSignificance")]
  public Dictionary<string, double> RevenueSignificance { get; set; }

  /// <summary>
  /// Update date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format.
  /// </summary>
  /// <value>Update date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format.</value>
  [DataMember(Name = "updatedAt")]
  public string UpdatedAt { get; set; }

  /// <summary>
  /// Creation date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format.
  /// </summary>
  /// <value>Creation date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format.</value>
  [DataMember(Name = "createdAt")]
  public string CreatedAt { get; set; }

  /// <summary>
  /// End date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format.
  /// </summary>
  /// <value>End date timestamp in [ISO-8601](https://wikipedia.org/wiki/ISO_8601) format.</value>
  [DataMember(Name = "endAt")]
  public string EndAt { get; set; }

  /// <summary>
  /// A/B test name.
  /// </summary>
  /// <value>A/B test name.</value>
  [DataMember(Name = "name")]
  public string Name { get; set; }

  /// <summary>
  /// A/B test status.
  /// </summary>
  /// <value>A/B test status.</value>
  [DataMember(Name = "status")]
  public string Status { get; set; }

  /// <summary>
  /// A/B test variants.
  /// </summary>
  /// <value>A/B test variants.</value>
  [DataMember(Name = "variants")]
  public List<Variant> Variants { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class ABTest {\n");
    sb.Append("  AbTestID: ").Append(AbTestID).Append("\n");
    sb.Append("  ClickSignificance: ").Append(ClickSignificance).Append("\n");
    sb.Append("  ConversionSignificance: ").Append(ConversionSignificance).Append("\n");
    sb.Append("  AddToCartSignificance: ").Append(AddToCartSignificance).Append("\n");
    sb.Append("  PurchaseSignificance: ").Append(PurchaseSignificance).Append("\n");
    sb.Append("  RevenueSignificance: ").Append(RevenueSignificance).Append("\n");
    sb.Append("  UpdatedAt: ").Append(UpdatedAt).Append("\n");
    sb.Append("  CreatedAt: ").Append(CreatedAt).Append("\n");
    sb.Append("  EndAt: ").Append(EndAt).Append("\n");
    sb.Append("  Name: ").Append(Name).Append("\n");
    sb.Append("  Status: ").Append(Status).Append("\n");
    sb.Append("  Variants: ").Append(Variants).Append("\n");
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

