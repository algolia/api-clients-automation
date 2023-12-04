//
// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
//
using Newtonsoft.Json.Converters;

namespace Algolia.Search.QuerySuggestions.Client
{
  /// <summary>
  /// Formatter for 'date' openapi formats ss defined by full-date - RFC3339
  /// see https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.0.md#data-types
  /// </summary>
  public class OpenAPIDateConverter : IsoDateTimeConverter
  {
    /// <summary>
    /// Initializes a new instance of the <see cref="OpenAPIDateConverter" /> class.
    /// </summary>
    public OpenAPIDateConverter()
    {
      // full-date   = date-fullyear "-" date-month "-" date-mday
      DateTimeFormat = "yyyy-MM-dd";
    }
  }
}
