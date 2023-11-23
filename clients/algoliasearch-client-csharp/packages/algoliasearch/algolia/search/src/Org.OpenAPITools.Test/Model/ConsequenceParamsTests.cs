/*
 * Search API
 *
 * Use the Search REST API  to manage your data (indices and records), implement search, and improve relevance (with Rules, synonyms, and language dictionaries).  Although Algolia provides a REST API, you should use the official open source API [clients, libraries, and tools](https://www.algolia.com/doc/guides/getting-started/how-algolia-works/in-depth/ecosystem/) instead. There's no [SLA](https://www.algolia.com/policies/sla/) if you use the REST API directly.
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


using Xunit;

using System;
using System.Linq;
using System.IO;
using System.Collections.Generic;
using Org.OpenAPITools.Model;
using Org.OpenAPITools.Client;
using System.Reflection;
using Newtonsoft.Json;

namespace Org.OpenAPITools.Test.Model
{
    /// <summary>
    ///  Class for testing ConsequenceParams
    /// </summary>
    /// <remarks>
    /// This file is automatically generated by OpenAPI Generator (https://openapi-generator.tech).
    /// Please update the test case below to test the model.
    /// </remarks>
    public class ConsequenceParamsTests : IDisposable
    {
        // TODO uncomment below to declare an instance variable for ConsequenceParams
        //private ConsequenceParams instance;

        public ConsequenceParamsTests()
        {
            // TODO uncomment below to create an instance of ConsequenceParams
            //instance = new ConsequenceParams();
        }

        public void Dispose()
        {
            // Cleanup when everything is done.
        }

        /// <summary>
        /// Test an instance of ConsequenceParams
        /// </summary>
        [Fact]
        public void ConsequenceParamsInstanceTest()
        {
            // TODO uncomment below to test "IsType" ConsequenceParams
            //Assert.IsType<ConsequenceParams>(instance);
        }

        /// <summary>
        /// Test the property 'SimilarQuery'
        /// </summary>
        [Fact]
        public void SimilarQueryTest()
        {
            // TODO unit test for the property 'SimilarQuery'
        }

        /// <summary>
        /// Test the property 'Filters'
        /// </summary>
        [Fact]
        public void FiltersTest()
        {
            // TODO unit test for the property 'Filters'
        }

        /// <summary>
        /// Test the property 'FacetFilters'
        /// </summary>
        [Fact]
        public void FacetFiltersTest()
        {
            // TODO unit test for the property 'FacetFilters'
        }

        /// <summary>
        /// Test the property 'OptionalFilters'
        /// </summary>
        [Fact]
        public void OptionalFiltersTest()
        {
            // TODO unit test for the property 'OptionalFilters'
        }

        /// <summary>
        /// Test the property 'NumericFilters'
        /// </summary>
        [Fact]
        public void NumericFiltersTest()
        {
            // TODO unit test for the property 'NumericFilters'
        }

        /// <summary>
        /// Test the property 'TagFilters'
        /// </summary>
        [Fact]
        public void TagFiltersTest()
        {
            // TODO unit test for the property 'TagFilters'
        }

        /// <summary>
        /// Test the property 'SumOrFiltersScores'
        /// </summary>
        [Fact]
        public void SumOrFiltersScoresTest()
        {
            // TODO unit test for the property 'SumOrFiltersScores'
        }

        /// <summary>
        /// Test the property 'RestrictSearchableAttributes'
        /// </summary>
        [Fact]
        public void RestrictSearchableAttributesTest()
        {
            // TODO unit test for the property 'RestrictSearchableAttributes'
        }

        /// <summary>
        /// Test the property 'Facets'
        /// </summary>
        [Fact]
        public void FacetsTest()
        {
            // TODO unit test for the property 'Facets'
        }

        /// <summary>
        /// Test the property 'FacetingAfterDistinct'
        /// </summary>
        [Fact]
        public void FacetingAfterDistinctTest()
        {
            // TODO unit test for the property 'FacetingAfterDistinct'
        }

        /// <summary>
        /// Test the property 'Page'
        /// </summary>
        [Fact]
        public void PageTest()
        {
            // TODO unit test for the property 'Page'
        }

        /// <summary>
        /// Test the property 'Offset'
        /// </summary>
        [Fact]
        public void OffsetTest()
        {
            // TODO unit test for the property 'Offset'
        }

        /// <summary>
        /// Test the property 'Length'
        /// </summary>
        [Fact]
        public void LengthTest()
        {
            // TODO unit test for the property 'Length'
        }

        /// <summary>
        /// Test the property 'AroundLatLng'
        /// </summary>
        [Fact]
        public void AroundLatLngTest()
        {
            // TODO unit test for the property 'AroundLatLng'
        }

        /// <summary>
        /// Test the property 'AroundLatLngViaIP'
        /// </summary>
        [Fact]
        public void AroundLatLngViaIPTest()
        {
            // TODO unit test for the property 'AroundLatLngViaIP'
        }

        /// <summary>
        /// Test the property 'AroundRadius'
        /// </summary>
        [Fact]
        public void AroundRadiusTest()
        {
            // TODO unit test for the property 'AroundRadius'
        }

        /// <summary>
        /// Test the property 'AroundPrecision'
        /// </summary>
        [Fact]
        public void AroundPrecisionTest()
        {
            // TODO unit test for the property 'AroundPrecision'
        }

        /// <summary>
        /// Test the property 'MinimumAroundRadius'
        /// </summary>
        [Fact]
        public void MinimumAroundRadiusTest()
        {
            // TODO unit test for the property 'MinimumAroundRadius'
        }

        /// <summary>
        /// Test the property 'InsideBoundingBox'
        /// </summary>
        [Fact]
        public void InsideBoundingBoxTest()
        {
            // TODO unit test for the property 'InsideBoundingBox'
        }

        /// <summary>
        /// Test the property 'InsidePolygon'
        /// </summary>
        [Fact]
        public void InsidePolygonTest()
        {
            // TODO unit test for the property 'InsidePolygon'
        }

        /// <summary>
        /// Test the property 'NaturalLanguages'
        /// </summary>
        [Fact]
        public void NaturalLanguagesTest()
        {
            // TODO unit test for the property 'NaturalLanguages'
        }

        /// <summary>
        /// Test the property 'RuleContexts'
        /// </summary>
        [Fact]
        public void RuleContextsTest()
        {
            // TODO unit test for the property 'RuleContexts'
        }

        /// <summary>
        /// Test the property 'PersonalizationImpact'
        /// </summary>
        [Fact]
        public void PersonalizationImpactTest()
        {
            // TODO unit test for the property 'PersonalizationImpact'
        }

        /// <summary>
        /// Test the property 'UserToken'
        /// </summary>
        [Fact]
        public void UserTokenTest()
        {
            // TODO unit test for the property 'UserToken'
        }

        /// <summary>
        /// Test the property 'GetRankingInfo'
        /// </summary>
        [Fact]
        public void GetRankingInfoTest()
        {
            // TODO unit test for the property 'GetRankingInfo'
        }

        /// <summary>
        /// Test the property 'Explain'
        /// </summary>
        [Fact]
        public void ExplainTest()
        {
            // TODO unit test for the property 'Explain'
        }

        /// <summary>
        /// Test the property 'Synonyms'
        /// </summary>
        [Fact]
        public void SynonymsTest()
        {
            // TODO unit test for the property 'Synonyms'
        }

        /// <summary>
        /// Test the property 'ClickAnalytics'
        /// </summary>
        [Fact]
        public void ClickAnalyticsTest()
        {
            // TODO unit test for the property 'ClickAnalytics'
        }

        /// <summary>
        /// Test the property 'Analytics'
        /// </summary>
        [Fact]
        public void AnalyticsTest()
        {
            // TODO unit test for the property 'Analytics'
        }

        /// <summary>
        /// Test the property 'AnalyticsTags'
        /// </summary>
        [Fact]
        public void AnalyticsTagsTest()
        {
            // TODO unit test for the property 'AnalyticsTags'
        }

        /// <summary>
        /// Test the property 'PercentileComputation'
        /// </summary>
        [Fact]
        public void PercentileComputationTest()
        {
            // TODO unit test for the property 'PercentileComputation'
        }

        /// <summary>
        /// Test the property 'EnableABTest'
        /// </summary>
        [Fact]
        public void EnableABTestTest()
        {
            // TODO unit test for the property 'EnableABTest'
        }

        /// <summary>
        /// Test the property 'AttributesForFaceting'
        /// </summary>
        [Fact]
        public void AttributesForFacetingTest()
        {
            // TODO unit test for the property 'AttributesForFaceting'
        }

        /// <summary>
        /// Test the property 'AttributesToRetrieve'
        /// </summary>
        [Fact]
        public void AttributesToRetrieveTest()
        {
            // TODO unit test for the property 'AttributesToRetrieve'
        }

        /// <summary>
        /// Test the property 'Ranking'
        /// </summary>
        [Fact]
        public void RankingTest()
        {
            // TODO unit test for the property 'Ranking'
        }

        /// <summary>
        /// Test the property 'CustomRanking'
        /// </summary>
        [Fact]
        public void CustomRankingTest()
        {
            // TODO unit test for the property 'CustomRanking'
        }

        /// <summary>
        /// Test the property 'RelevancyStrictness'
        /// </summary>
        [Fact]
        public void RelevancyStrictnessTest()
        {
            // TODO unit test for the property 'RelevancyStrictness'
        }

        /// <summary>
        /// Test the property 'AttributesToHighlight'
        /// </summary>
        [Fact]
        public void AttributesToHighlightTest()
        {
            // TODO unit test for the property 'AttributesToHighlight'
        }

        /// <summary>
        /// Test the property 'AttributesToSnippet'
        /// </summary>
        [Fact]
        public void AttributesToSnippetTest()
        {
            // TODO unit test for the property 'AttributesToSnippet'
        }

        /// <summary>
        /// Test the property 'HighlightPreTag'
        /// </summary>
        [Fact]
        public void HighlightPreTagTest()
        {
            // TODO unit test for the property 'HighlightPreTag'
        }

        /// <summary>
        /// Test the property 'HighlightPostTag'
        /// </summary>
        [Fact]
        public void HighlightPostTagTest()
        {
            // TODO unit test for the property 'HighlightPostTag'
        }

        /// <summary>
        /// Test the property 'SnippetEllipsisText'
        /// </summary>
        [Fact]
        public void SnippetEllipsisTextTest()
        {
            // TODO unit test for the property 'SnippetEllipsisText'
        }

        /// <summary>
        /// Test the property 'RestrictHighlightAndSnippetArrays'
        /// </summary>
        [Fact]
        public void RestrictHighlightAndSnippetArraysTest()
        {
            // TODO unit test for the property 'RestrictHighlightAndSnippetArrays'
        }

        /// <summary>
        /// Test the property 'HitsPerPage'
        /// </summary>
        [Fact]
        public void HitsPerPageTest()
        {
            // TODO unit test for the property 'HitsPerPage'
        }

        /// <summary>
        /// Test the property 'MinWordSizefor1Typo'
        /// </summary>
        [Fact]
        public void MinWordSizefor1TypoTest()
        {
            // TODO unit test for the property 'MinWordSizefor1Typo'
        }

        /// <summary>
        /// Test the property 'MinWordSizefor2Typos'
        /// </summary>
        [Fact]
        public void MinWordSizefor2TyposTest()
        {
            // TODO unit test for the property 'MinWordSizefor2Typos'
        }

        /// <summary>
        /// Test the property 'TypoTolerance'
        /// </summary>
        [Fact]
        public void TypoToleranceTest()
        {
            // TODO unit test for the property 'TypoTolerance'
        }

        /// <summary>
        /// Test the property 'AllowTyposOnNumericTokens'
        /// </summary>
        [Fact]
        public void AllowTyposOnNumericTokensTest()
        {
            // TODO unit test for the property 'AllowTyposOnNumericTokens'
        }

        /// <summary>
        /// Test the property 'DisableTypoToleranceOnAttributes'
        /// </summary>
        [Fact]
        public void DisableTypoToleranceOnAttributesTest()
        {
            // TODO unit test for the property 'DisableTypoToleranceOnAttributes'
        }

        /// <summary>
        /// Test the property 'IgnorePlurals'
        /// </summary>
        [Fact]
        public void IgnorePluralsTest()
        {
            // TODO unit test for the property 'IgnorePlurals'
        }

        /// <summary>
        /// Test the property 'RemoveStopWords'
        /// </summary>
        [Fact]
        public void RemoveStopWordsTest()
        {
            // TODO unit test for the property 'RemoveStopWords'
        }

        /// <summary>
        /// Test the property 'KeepDiacriticsOnCharacters'
        /// </summary>
        [Fact]
        public void KeepDiacriticsOnCharactersTest()
        {
            // TODO unit test for the property 'KeepDiacriticsOnCharacters'
        }

        /// <summary>
        /// Test the property 'QueryLanguages'
        /// </summary>
        [Fact]
        public void QueryLanguagesTest()
        {
            // TODO unit test for the property 'QueryLanguages'
        }

        /// <summary>
        /// Test the property 'DecompoundQuery'
        /// </summary>
        [Fact]
        public void DecompoundQueryTest()
        {
            // TODO unit test for the property 'DecompoundQuery'
        }

        /// <summary>
        /// Test the property 'EnableRules'
        /// </summary>
        [Fact]
        public void EnableRulesTest()
        {
            // TODO unit test for the property 'EnableRules'
        }

        /// <summary>
        /// Test the property 'EnablePersonalization'
        /// </summary>
        [Fact]
        public void EnablePersonalizationTest()
        {
            // TODO unit test for the property 'EnablePersonalization'
        }

        /// <summary>
        /// Test the property 'QueryType'
        /// </summary>
        [Fact]
        public void QueryTypeTest()
        {
            // TODO unit test for the property 'QueryType'
        }

        /// <summary>
        /// Test the property 'RemoveWordsIfNoResults'
        /// </summary>
        [Fact]
        public void RemoveWordsIfNoResultsTest()
        {
            // TODO unit test for the property 'RemoveWordsIfNoResults'
        }

        /// <summary>
        /// Test the property 'Mode'
        /// </summary>
        [Fact]
        public void ModeTest()
        {
            // TODO unit test for the property 'Mode'
        }

        /// <summary>
        /// Test the property 'SemanticSearch'
        /// </summary>
        [Fact]
        public void SemanticSearchTest()
        {
            // TODO unit test for the property 'SemanticSearch'
        }

        /// <summary>
        /// Test the property 'AdvancedSyntax'
        /// </summary>
        [Fact]
        public void AdvancedSyntaxTest()
        {
            // TODO unit test for the property 'AdvancedSyntax'
        }

        /// <summary>
        /// Test the property 'OptionalWords'
        /// </summary>
        [Fact]
        public void OptionalWordsTest()
        {
            // TODO unit test for the property 'OptionalWords'
        }

        /// <summary>
        /// Test the property 'DisableExactOnAttributes'
        /// </summary>
        [Fact]
        public void DisableExactOnAttributesTest()
        {
            // TODO unit test for the property 'DisableExactOnAttributes'
        }

        /// <summary>
        /// Test the property 'ExactOnSingleWordQuery'
        /// </summary>
        [Fact]
        public void ExactOnSingleWordQueryTest()
        {
            // TODO unit test for the property 'ExactOnSingleWordQuery'
        }

        /// <summary>
        /// Test the property 'AlternativesAsExact'
        /// </summary>
        [Fact]
        public void AlternativesAsExactTest()
        {
            // TODO unit test for the property 'AlternativesAsExact'
        }

        /// <summary>
        /// Test the property 'AdvancedSyntaxFeatures'
        /// </summary>
        [Fact]
        public void AdvancedSyntaxFeaturesTest()
        {
            // TODO unit test for the property 'AdvancedSyntaxFeatures'
        }

        /// <summary>
        /// Test the property 'Distinct'
        /// </summary>
        [Fact]
        public void DistinctTest()
        {
            // TODO unit test for the property 'Distinct'
        }

        /// <summary>
        /// Test the property 'ReplaceSynonymsInHighlight'
        /// </summary>
        [Fact]
        public void ReplaceSynonymsInHighlightTest()
        {
            // TODO unit test for the property 'ReplaceSynonymsInHighlight'
        }

        /// <summary>
        /// Test the property 'MinProximity'
        /// </summary>
        [Fact]
        public void MinProximityTest()
        {
            // TODO unit test for the property 'MinProximity'
        }

        /// <summary>
        /// Test the property 'ResponseFields'
        /// </summary>
        [Fact]
        public void ResponseFieldsTest()
        {
            // TODO unit test for the property 'ResponseFields'
        }

        /// <summary>
        /// Test the property 'MaxFacetHits'
        /// </summary>
        [Fact]
        public void MaxFacetHitsTest()
        {
            // TODO unit test for the property 'MaxFacetHits'
        }

        /// <summary>
        /// Test the property 'MaxValuesPerFacet'
        /// </summary>
        [Fact]
        public void MaxValuesPerFacetTest()
        {
            // TODO unit test for the property 'MaxValuesPerFacet'
        }

        /// <summary>
        /// Test the property 'SortFacetValuesBy'
        /// </summary>
        [Fact]
        public void SortFacetValuesByTest()
        {
            // TODO unit test for the property 'SortFacetValuesBy'
        }

        /// <summary>
        /// Test the property 'AttributeCriteriaComputedByMinProximity'
        /// </summary>
        [Fact]
        public void AttributeCriteriaComputedByMinProximityTest()
        {
            // TODO unit test for the property 'AttributeCriteriaComputedByMinProximity'
        }

        /// <summary>
        /// Test the property 'RenderingContent'
        /// </summary>
        [Fact]
        public void RenderingContentTest()
        {
            // TODO unit test for the property 'RenderingContent'
        }

        /// <summary>
        /// Test the property 'EnableReRanking'
        /// </summary>
        [Fact]
        public void EnableReRankingTest()
        {
            // TODO unit test for the property 'EnableReRanking'
        }

        /// <summary>
        /// Test the property 'ReRankingApplyFilter'
        /// </summary>
        [Fact]
        public void ReRankingApplyFilterTest()
        {
            // TODO unit test for the property 'ReRankingApplyFilter'
        }

        /// <summary>
        /// Test the property 'Query'
        /// </summary>
        [Fact]
        public void QueryTest()
        {
            // TODO unit test for the property 'Query'
        }

        /// <summary>
        /// Test the property 'AutomaticFacetFilters'
        /// </summary>
        [Fact]
        public void AutomaticFacetFiltersTest()
        {
            // TODO unit test for the property 'AutomaticFacetFilters'
        }

        /// <summary>
        /// Test the property 'AutomaticOptionalFacetFilters'
        /// </summary>
        [Fact]
        public void AutomaticOptionalFacetFiltersTest()
        {
            // TODO unit test for the property 'AutomaticOptionalFacetFilters'
        }
    }
}
