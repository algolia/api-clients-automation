using System.Collections.Generic;
using Algolia.Search.Models.Search;

namespace Algolia.Search.Models.Common
{
    /// <summary>
    /// Secured Api Key restrictions
    /// </summary>
    public class SecuredApiKeyRestriction
    {
        /// <summary>
        /// Search query parameters
        /// </summary>
        public IndexSettingsAsSearchParams Query { get; set; }

        /// <summary>
        /// A Unix timestamp used to define the expiration date of the API key.
        /// </summary>
        public long? ValidUntil { get; set; }

        /// <summary>
        /// List of index names that can be queried.
        /// </summary>
        public List<string> RestrictIndices { get; set; }

        /// <summary>
        /// IPv4 network allowed to use the generated key. This is used for more protection against API key leaking and reuse.
        /// </summary>
        public List<string> RestrictSources { get; set; }

        /// <summary>
        /// Specify a user identifier. This is often used with rate limits.
        /// </summary>
        public string UserToken { get; set; }
    }
}
