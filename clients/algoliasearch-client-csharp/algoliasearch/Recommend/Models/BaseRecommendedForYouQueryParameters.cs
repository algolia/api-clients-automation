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

namespace Algolia.Search.Models.Recommend
{
  /// <summary>
  /// BaseRecommendedForYouQueryParameters
  /// </summary>
  [DataContract(Name = "baseRecommendedForYouQueryParameters")]
  public partial class BaseRecommendedForYouQueryParameters
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="BaseRecommendedForYouQueryParameters" /> class.
    /// </summary>
    [JsonConstructorAttribute]
    public BaseRecommendedForYouQueryParameters() { }
    /// <summary>
    /// Initializes a new instance of the <see cref="BaseRecommendedForYouQueryParameters" /> class.
    /// </summary>
    /// <param name="userToken">Associates a [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/) with the current search. (required).</param>
    public BaseRecommendedForYouQueryParameters(string userToken)
    {
      this.UserToken = userToken ?? throw new ArgumentNullException("userToken is a required property for BaseRecommendedForYouQueryParameters and cannot be null");
    }

    /// <summary>
    /// Associates a [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/) with the current search.
    /// </summary>
    /// <value>Associates a [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/) with the current search.</value>
    [DataMember(Name = "userToken", IsRequired = true, EmitDefaultValue = true)]
    public string UserToken { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class BaseRecommendedForYouQueryParameters {\n");
      sb.Append("  UserToken: ").Append(UserToken).Append("\n");
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
