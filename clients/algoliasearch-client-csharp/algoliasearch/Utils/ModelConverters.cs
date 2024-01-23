using Algolia.Search.Models.Search;

namespace Algolia.Search.Utils
{
  public static class ModelConverters
  {
    public static ApiKey ToApiKey(this GetApiKeyResponse apiKey)
    {
      return new ApiKey
      {
        Acl = apiKey.Acl,
        Description = apiKey.Description,
        Indexes = apiKey.Indexes,
        Referers = apiKey.Referers,
        Validity = apiKey.Validity,
        QueryParameters = apiKey.QueryParameters,
        MaxHitsPerQuery = apiKey.MaxHitsPerQuery,
        MaxQueriesPerIPPerHour = apiKey.MaxQueriesPerIPPerHour
      };
    }
  }
}
