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
using OpenAPIDateConverter = Org.OpenAPITools.Client.OpenAPIDateConverter;

namespace Org.OpenAPITools.Model
{
    /// <summary>
    /// OK
    /// </summary>
    [DataContract(Name = "searchUserIdsParams")]
    public partial class SearchUserIdsParams : IEquatable<SearchUserIdsParams>, IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="SearchUserIdsParams" /> class.
        /// </summary>
        [JsonConstructorAttribute]
        protected SearchUserIdsParams() { }
        /// <summary>
        /// Initializes a new instance of the <see cref="SearchUserIdsParams" /> class.
        /// </summary>
        /// <param name="query">Query to search. The search is a prefix search with [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/) enabled. An empty query will retrieve all users. (required).</param>
        /// <param name="clusterName">Cluster name..</param>
        /// <param name="page">Page to retrieve (the first page is &#x60;0&#x60;, not &#x60;1&#x60;). (default to 0).</param>
        /// <param name="hitsPerPage">Number of hits per page. (default to 20).</param>
        public SearchUserIdsParams(string query = default(string), string clusterName = default(string), int page = 0, int hitsPerPage = 20)
        {
            // to ensure "query" is required (not null)
            if (query == null)
            {
                throw new ArgumentNullException("query is a required property for SearchUserIdsParams and cannot be null");
            }
            this.Query = query;
            this.ClusterName = clusterName;
            this.Page = page;
            this.HitsPerPage = hitsPerPage;
        }

        /// <summary>
        /// Query to search. The search is a prefix search with [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/) enabled. An empty query will retrieve all users.
        /// </summary>
        /// <value>Query to search. The search is a prefix search with [typo tolerance](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/typo-tolerance/) enabled. An empty query will retrieve all users.</value>
        [DataMember(Name = "query", IsRequired = true, EmitDefaultValue = true)]
        public string Query { get; set; }

        /// <summary>
        /// Cluster name.
        /// </summary>
        /// <value>Cluster name.</value>
        /// <example>c11-test</example>
        [DataMember(Name = "clusterName", EmitDefaultValue = false)]
        public string ClusterName { get; set; }

        /// <summary>
        /// Page to retrieve (the first page is &#x60;0&#x60;, not &#x60;1&#x60;).
        /// </summary>
        /// <value>Page to retrieve (the first page is &#x60;0&#x60;, not &#x60;1&#x60;).</value>
        [DataMember(Name = "page", EmitDefaultValue = false)]
        public int Page { get; set; }

        /// <summary>
        /// Number of hits per page.
        /// </summary>
        /// <value>Number of hits per page.</value>
        [DataMember(Name = "hitsPerPage", EmitDefaultValue = false)]
        public int HitsPerPage { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class SearchUserIdsParams {\n");
            sb.Append("  Query: ").Append(Query).Append("\n");
            sb.Append("  ClusterName: ").Append(ClusterName).Append("\n");
            sb.Append("  Page: ").Append(Page).Append("\n");
            sb.Append("  HitsPerPage: ").Append(HitsPerPage).Append("\n");
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
            return this.Equals(input as SearchUserIdsParams);
        }

        /// <summary>
        /// Returns true if SearchUserIdsParams instances are equal
        /// </summary>
        /// <param name="input">Instance of SearchUserIdsParams to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(SearchUserIdsParams input)
        {
            if (input == null)
            {
                return false;
            }
            return 
                (
                    this.Query == input.Query ||
                    (this.Query != null &&
                    this.Query.Equals(input.Query))
                ) && 
                (
                    this.ClusterName == input.ClusterName ||
                    (this.ClusterName != null &&
                    this.ClusterName.Equals(input.ClusterName))
                ) && 
                (
                    this.Page == input.Page ||
                    this.Page.Equals(input.Page)
                ) && 
                (
                    this.HitsPerPage == input.HitsPerPage ||
                    this.HitsPerPage.Equals(input.HitsPerPage)
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
                if (this.Query != null)
                {
                    hashCode = (hashCode * 59) + this.Query.GetHashCode();
                }
                if (this.ClusterName != null)
                {
                    hashCode = (hashCode * 59) + this.ClusterName.GetHashCode();
                }
                hashCode = (hashCode * 59) + this.Page.GetHashCode();
                hashCode = (hashCode * 59) + this.HitsPerPage.GetHashCode();
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
            // HitsPerPage (int) maximum
            if (this.HitsPerPage > (int)1000)
            {
                yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for HitsPerPage, must be a value less than or equal to 1000.", new [] { "HitsPerPage" });
            }

            // HitsPerPage (int) minimum
            if (this.HitsPerPage < (int)1)
            {
                yield return new System.ComponentModel.DataAnnotations.ValidationResult("Invalid value for HitsPerPage, must be a value greater than or equal to 1.", new [] { "HitsPerPage" });
            }

            yield break;
        }
    }

}
