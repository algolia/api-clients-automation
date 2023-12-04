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
using System.ComponentModel.DataAnnotations;
using FileParameter = Algolia.Search.Recommend.Client.FileParameter;
using OpenAPIDateConverter = Algolia.Search.Recommend.Client.OpenAPIDateConverter;

namespace Algolia.Search.Recommend.Models
{
  /// <summary>
  /// MatchedGeoLocation
  /// </summary>
  [DataContract(Name = "matchedGeoLocation")]
  public partial class MatchedGeoLocation : IEquatable<MatchedGeoLocation>, IValidatableObject
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="MatchedGeoLocation" /> class.
    /// </summary>
    /// <param name="lat">Latitude of the matched location..</param>
    /// <param name="lng">Longitude of the matched location..</param>
    /// <param name="distance">Distance between the matched location and the search location (in meters)..</param>
    public MatchedGeoLocation(double lat = default(double), double lng = default(double), int distance = default(int))
    {
      this.Lat = lat;
      this.Lng = lng;
      this.Distance = distance;
    }

    /// <summary>
    /// Latitude of the matched location.
    /// </summary>
    /// <value>Latitude of the matched location.</value>
    [DataMember(Name = "lat", EmitDefaultValue = false)]
    public double Lat { get; set; }

    /// <summary>
    /// Longitude of the matched location.
    /// </summary>
    /// <value>Longitude of the matched location.</value>
    [DataMember(Name = "lng", EmitDefaultValue = false)]
    public double Lng { get; set; }

    /// <summary>
    /// Distance between the matched location and the search location (in meters).
    /// </summary>
    /// <value>Distance between the matched location and the search location (in meters).</value>
    [DataMember(Name = "distance", EmitDefaultValue = false)]
    public int Distance { get; set; }

    /// <summary>
    /// Returns the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()
    {
      StringBuilder sb = new StringBuilder();
      sb.Append("class MatchedGeoLocation {\n");
      sb.Append("  Lat: ").Append(Lat).Append("\n");
      sb.Append("  Lng: ").Append(Lng).Append("\n");
      sb.Append("  Distance: ").Append(Distance).Append("\n");
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
      return this.Equals(input as MatchedGeoLocation);
    }

    /// <summary>
    /// Returns true if MatchedGeoLocation instances are equal
    /// </summary>
    /// <param name="input">Instance of MatchedGeoLocation to be compared</param>
    /// <returns>Boolean</returns>
    public bool Equals(MatchedGeoLocation input)
    {
      if (input == null)
      {
        return false;
      }
      return
          (
              this.Lat == input.Lat ||
              this.Lat.Equals(input.Lat)
          ) &&
          (
              this.Lng == input.Lng ||
              this.Lng.Equals(input.Lng)
          ) &&
          (
              this.Distance == input.Distance ||
              this.Distance.Equals(input.Distance)
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
        hashCode = (hashCode * 59) + this.Lat.GetHashCode();
        hashCode = (hashCode * 59) + this.Lng.GetHashCode();
        hashCode = (hashCode * 59) + this.Distance.GetHashCode();
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
