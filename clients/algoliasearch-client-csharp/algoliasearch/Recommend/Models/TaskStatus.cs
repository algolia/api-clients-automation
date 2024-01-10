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
  /// _published_ if the task has been processed, _notPublished_ otherwise.
  /// </summary>
  /// <value>_published_ if the task has been processed, _notPublished_ otherwise.</value>
  [JsonConverter(typeof(StringEnumConverter))]
  public enum TaskStatus
  {
    /// <summary>
    /// Enum Published for value: published
    /// </summary>
    [EnumMember(Value = "published")]
    Published = 1,

    /// <summary>
    /// Enum NotPublished for value: notPublished
    /// </summary>
    [EnumMember(Value = "notPublished")]
    NotPublished = 2
  }

}
