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
using FileParameter = Org.OpenAPITools.Client.FileParameter;
using OpenAPIDateConverter = Org.OpenAPITools.Client.OpenAPIDateConverter;

namespace Org.OpenAPITools.Model
{
  /// <summary>
  /// [Consequences](https://www.algolia.com/doc/guides/managing-results/rules/rules-overview/#consequences) of a rule. 
  /// </summary>
  [DataContract(Name = "consequence")]
  public partial class Consequence : IEquatable<Consequence>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="Consequence" /> class.
    /// </summary>
    /// <param name="varParams">varParams.</param>
    /// <param name="promote">Records to promote..</param>
    /// <param name="filterPromotes">Only use in combination with the &#x60;promote&#x60; consequence. When &#x60;true&#x60;, promoted results will be restricted to match the filters of the current search. When &#x60;false&#x60;, the promoted results will show up regardless of the filters. (default to false).</param>
    /// <param name="hide">Records to hide. By default, you can hide up to 50 records per rule..</param>
    /// <param name="userData">Custom JSON object that will be appended to the userData array in the response. This object isn&#39;t interpreted by the API. It&#39;s limited to 1kB of minified JSON..</param>
    public Consequence(ConsequenceParams varParams = default(ConsequenceParams), List<Promote> promote = default(List<Promote>), bool filterPromotes = false, List<ConsequenceHide> hide = default(List<ConsequenceHide>), Object userData = default(Object))
    {
      this.VarParams = varParams;
      this.Promote = promote;
      this.FilterPromotes = filterPromotes;
      this.Hide = hide;
      this.UserData = userData;
    }

    /// <summary>
    /// Gets or Sets VarParams
    /// </summary>
    [DataMember(Name = "params", EmitDefaultValue = false)]
    public ConsequenceParams VarParams { get; set; }

    /// <summary>
    /// Records to promote.
    /// </summary>
    /// <value>Records to promote.</value>
    [DataMember(Name = "promote", EmitDefaultValue = false)]
    public List<Promote> Promote { get; set; }

    /// <summary>
    /// Only use in combination with the &#x60;promote&#x60; consequence. When &#x60;true&#x60;, promoted results will be restricted to match the filters of the current search. When &#x60;false&#x60;, the promoted results will show up regardless of the filters.
    /// </summary>
    /// <value>Only use in combination with the &#x60;promote&#x60; consequence. When &#x60;true&#x60;, promoted results will be restricted to match the filters of the current search. When &#x60;false&#x60;, the promoted results will show up regardless of the filters.</value>
    [DataMember(Name = "filterPromotes", EmitDefaultValue = true)]
    public bool FilterPromotes { get; set; }

    /// <summary>
    /// Records to hide. By default, you can hide up to 50 records per rule.
    /// </summary>
    /// <value>Records to hide. By default, you can hide up to 50 records per rule.</value>
    [DataMember(Name = "hide", EmitDefaultValue = false)]
    public List<ConsequenceHide> Hide { get; set; }

    /// <summary>
    /// Custom JSON object that will be appended to the userData array in the response. This object isn&#39;t interpreted by the API. It&#39;s limited to 1kB of minified JSON.
    /// </summary>
    /// <value>Custom JSON object that will be appended to the userData array in the response. This object isn&#39;t interpreted by the API. It&#39;s limited to 1kB of minified JSON.</value>
    /// <example>{&quot;settingID&quot;:&quot;f2a7b51e3503acc6a39b3784ffb84300&quot;,&quot;pluginVersion&quot;:&quot;1.6.0&quot;}</example>
    [DataMember(Name = "userData", EmitDefaultValue = true)]
    public Object UserData { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class Consequence {\n");
      sb.Append("  VarParams: ").Append(VarParams).Append("\n");
      sb.Append("  Promote: ").Append(Promote).Append("\n");
      sb.Append("  FilterPromotes: ").Append(FilterPromotes).Append("\n");
      sb.Append("  Hide: ").Append(Hide).Append("\n");
      sb.Append("  UserData: ").Append(UserData).Append("\n");
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

    /// <summary>
    /// Returns true if objects are equal
    /// </summary>
    /// <param name="input">Object to be compared</param>
    /// <returns>Boolean</returns>
    public override bool Equals(object input)
    {
      return this.Equals(input as Consequence);
    }

    /// <summary>
    /// Returns true if Consequence instances are equal
    /// </summary>
    /// <param name="input">Instance of Consequence to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(Consequence input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.VarParams == input.VarParams ||
              (this.VarParams != null &&
              this.VarParams.Equals(input.VarParams))
          ) &&
          (
              this.Promote == input.Promote ||
              this.Promote != null &&
              input.Promote != null &&
              this.Promote.SequenceEqual(input.Promote)
          ) &&
          (
              this.FilterPromotes == input.FilterPromotes ||
              this.FilterPromotes.Equals(input.FilterPromotes)
          ) &&
          (
              this.Hide == input.Hide ||
              this.Hide != null &&
              input.Hide != null &&
              this.Hide.SequenceEqual(input.Hide)
          ) &&
          (
              this.UserData == input.UserData ||
              (this.UserData != null &&
              this.UserData.Equals(input.UserData))
          );
    }

    /// <summary>
    /// Gets the hash code
    /// </summary>
    /// <returns>Hash code</returns>
    public override int GetHashCode()
    {
      unchecked // Overflow is fine, just wrap
      {
        int hashCode = 41;
        if (this.VarParams != null)
        {
          hashCode = (hashCode * 59) + this.VarParams.GetHashCode();
        }
        if (this.Promote != null)
        {
          hashCode = (hashCode * 59) + this.Promote.GetHashCode();
        }
        hashCode = (hashCode * 59) + this.FilterPromotes.GetHashCode();
        if (this.Hide != null)
        {
          hashCode = (hashCode * 59) + this.Hide.GetHashCode();
        }
        if (this.UserData != null)
        {
          hashCode = (hashCode * 59) + this.UserData.GetHashCode();
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
      yield break;
    }
  }

}
