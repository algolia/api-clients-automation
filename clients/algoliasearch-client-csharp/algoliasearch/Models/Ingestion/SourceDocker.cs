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
/// SourceDocker
/// </summary>
[DataContract(Name = "SourceDocker")]
[JsonObject(MemberSerialization.OptOut)]
public partial class SourceDocker
{

  /// <summary>
  /// Gets or Sets ImageType
  /// </summary>
  [DataMember(Name = "imageType", IsRequired = true, EmitDefaultValue = false)]
  public DockerImageType ImageType { get; set; }

  /// <summary>
  /// Gets or Sets Registry
  /// </summary>
  [DataMember(Name = "registry", IsRequired = true, EmitDefaultValue = false)]
  public DockerRegistry Registry { get; set; }
  /// <summary>
  /// Initializes a new instance of the SourceDocker class.
  /// </summary>
  [JsonConstructor]
  public SourceDocker() { }
  /// <summary>
  /// Initializes a new instance of the SourceDocker class.
  /// </summary>
  /// <param name="imageType">imageType (required).</param>
  /// <param name="registry">registry (required).</param>
  /// <param name="image">The name of the image to pull. (required).</param>
  /// <param name="varConfiguration">The configuration of the spec. (required).</param>
  public SourceDocker(DockerImageType imageType, DockerRegistry registry, string image, object varConfiguration)
  {
    ImageType = imageType;
    Registry = registry;
    Image = image ?? throw new ArgumentNullException(nameof(image));
    VarConfiguration = varConfiguration ?? throw new ArgumentNullException(nameof(varConfiguration));
  }

  /// <summary>
  /// The name of the image to pull.
  /// </summary>
  /// <value>The name of the image to pull.</value>
  [DataMember(Name = "image", IsRequired = true, EmitDefaultValue = false)]
  public string Image { get; set; }

  /// <summary>
  /// The version of the image, defaults to `latest`.
  /// </summary>
  /// <value>The version of the image, defaults to `latest`.</value>
  [DataMember(Name = "version", EmitDefaultValue = false)]
  public string VarVersion { get; set; }

  /// <summary>
  /// The configuration of the spec.
  /// </summary>
  /// <value>The configuration of the spec.</value>
  [DataMember(Name = "configuration", IsRequired = true, EmitDefaultValue = false)]
  public object VarConfiguration { get; set; }

  /// <summary>
  /// Returns the string presentation of the object
  /// </summary>
  /// <returns>String presentation of the object</returns>
  public override string ToString()
  {
    StringBuilder sb = new StringBuilder();
    sb.Append("class SourceDocker {\n");
    sb.Append("  ImageType: ").Append(ImageType).Append("\n");
    sb.Append("  Registry: ").Append(Registry).Append("\n");
    sb.Append("  Image: ").Append(Image).Append("\n");
    sb.Append("  VarVersion: ").Append(VarVersion).Append("\n");
    sb.Append("  VarConfiguration: ").Append(VarConfiguration).Append("\n");
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

