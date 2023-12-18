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

namespace Algolia.Search.Ingestion.Models
{
  /// <summary>
  /// BigCommerceChannel
  /// </summary>
  [DataContract(Name = "BigCommerceChannel")]
  public partial class BigCommerceChannel
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="BigCommerceChannel" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    protected BigCommerceChannel() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="BigCommerceChannel" /> class.
    /// </summary>
    /// <param name="id">The ID of the bigcommerce channel. (required).</param>
    /// <param name="currencies">An array of currencies for the given channel &#x60;ID&#x60;, a currency is a trigram string that represents the currency code..</param>
    public BigCommerceChannel(int id = default(int), List<string> currencies = default(List<string>))
    {
      this.Id = id;
      this.Currencies = currencies;
    }

    /// <summary>
    /// The ID of the bigcommerce channel.
    /// </summary>
    /// <value>The ID of the bigcommerce channel.</value>
    [DataMember(Name = "id", IsRequired = true, EmitDefaultValue = true)]
    public int Id { get; set; }

    /// <summary>
    /// An array of currencies for the given channel &#x60;ID&#x60;, a currency is a trigram string that represents the currency code.
    /// </summary>
    /// <value>An array of currencies for the given channel &#x60;ID&#x60;, a currency is a trigram string that represents the currency code.</value>
    [DataMember(Name = "currencies", EmitDefaultValue = false)]
    public List<string> Currencies { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class BigCommerceChannel {\n");
      sb.Append("  Id: ").Append(Id).Append("\n");
      sb.Append("  Currencies: ").Append(Currencies).Append("\n");
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
