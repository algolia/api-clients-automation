package com.algolia.client.dsl.live.p0

import com.algolia.client.dsl.*
import com.algolia.client.dsl.filter.*
import com.algolia.client.dsl.testkit.LiveIndex
import com.algolia.client.dsl.testkit.ServerContract
import com.algolia.client.dsl.testkit.assertDelete
import com.algolia.client.dsl.testkit.assertRow
import com.algolia.client.dsl.testkit.live
import kotlin.test.Test
import kotlin.time.Duration.Companion.seconds
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.long
import org.junit.AfterClass
import org.junit.BeforeClass

/**
 * Server-contract suite (plan §Server-contract suite): every L and D row of [ServerContract] sent
 * raw through the generated `SearchClient` (no DSL) against one fixture index, pinning what the
 * engine accepts, rejects and returns. One test per group (id without the letter suffix); the
 * sub-rows are asserted inside. Delete rows run on a per-test copy of the fixture.
 */
internal class ServerContractLiveTest {

  companion object {
    private lateinit var fx: LiveIndex

    @JvmStatic
    @BeforeClass
    fun createFixture() {
      fx = LiveIndex.create("p0contract")
    }

    @JvmStatic
    @AfterClass
    fun deleteFixture() {
      if (::fx.isInitialized) fx.close()
    }
  }

  // ── Evidence rows L01–L22 ─────────────────────────────────────────────────────────────────────

  @Test fun L01_sqlAndOfTwoFacets() = live { fx.assertRow(ServerContract.L01) }

  @Test fun L02_parenthesisedSqlAnd() = live { fx.assertRow(ServerContract.L02) }

  @Test
  fun L03_sqlOrOfNegatedLeaves() = live {
    fx.assertRow(ServerContract.L03a)
    fx.assertRow(ServerContract.L03b)
  }

  @Test fun L04_sqlOrWithOneNegatedLeaf() = live { fx.assertRow(ServerContract.L04) }

  @Test fun L05_sqlAndOfNegatedLeaves() = live { fx.assertRow(ServerContract.L05) }

  @Test
  fun L06_sqlNotBeforeGroupIsRejected() = live {
    fx.assertRow(ServerContract.L06a)
    fx.assertRow(ServerContract.L06b)
  }

  @Test
  fun L07_sqlNestedGroupsOnlyOrThenAnd() = live {
    fx.assertRow(ServerContract.L07a)
    fx.assertRow(ServerContract.L07b)
  }

  @Test fun L08_sqlMixedTypesInOrAreRejected() = live { fx.assertRow(ServerContract.L08) }

  @Test
  fun L09_sqlOrScoresWithAndWithoutSum() = live {
    fx.assertRow(ServerContract.L09a)
    fx.assertRow(ServerContract.L09b)
  }

  @Test fun L10_sqlAndScoreAddsOne() = live { fx.assertRow(ServerContract.L10) }

  @Test
  fun L11_sqlAndOfOrGroupAndNumericNegation() = live {
    fx.assertRow(ServerContract.L11a)
    fx.assertRow(ServerContract.L11b)
  }

  @Test
  fun L12_sqlDashIsLiteral() = live {
    fx.assertRow(ServerContract.L12a)
    fx.assertRow(ServerContract.L12b)
    fx.assertRow(ServerContract.L12c)
    fx.assertRow(ServerContract.L12d)
    fx.assertRow(ServerContract.L12e)
    fx.assertRow(ServerContract.L12f)
  }

  @Test
  fun L13_legacyFacetLeadingDashNeedsEscape() = live {
    fx.assertRow(ServerContract.L13a)
    fx.assertRow(ServerContract.L13b)
    fx.assertRow(ServerContract.L13c)
    fx.assertRow(ServerContract.L13d)
    fx.assertRow(ServerContract.L13e)
  }

  @Test
  fun L14_legacyFacetNegationForms() = live {
    fx.assertRow(ServerContract.L14a)
    fx.assertRow(ServerContract.L14b)
    fx.assertRow(ServerContract.L14c)
    fx.assertRow(ServerContract.L14d)
    fx.assertRow(ServerContract.L14e)
  }

  @Test
  fun L15_legacyFacetNegatedDashValue() = live {
    fx.assertRow(ServerContract.L15a)
    fx.assertRow(ServerContract.L15b)
    fx.assertRow(ServerContract.L15c)
    fx.assertRow(ServerContract.L15d)
    fx.assertRow(ServerContract.L15e)
  }

  @Test
  fun L16_legacyFacetUnquotedSpecialValues() = live {
    fx.assertRow(ServerContract.L16a)
    fx.assertRow(ServerContract.L16b)
    fx.assertRow(ServerContract.L16c)
    fx.assertRow(ServerContract.L16d)
    fx.assertRow(ServerContract.L16e)
    fx.assertRow(ServerContract.L16f)
    fx.assertRow(ServerContract.L16g)
    fx.assertRow(ServerContract.L16h)
    fx.assertRow(ServerContract.L16i)
  }

  @Test
  fun L17_legacyTagDashForms() = live {
    fx.assertRow(ServerContract.L17a)
    fx.assertRow(ServerContract.L17b)
    fx.assertRow(ServerContract.L17c)
    fx.assertRow(ServerContract.L17d)
    fx.assertRow(ServerContract.L17e)
    fx.assertRow(ServerContract.L17f)
    fx.assertRow(ServerContract.L17g)
  }

  @Test
  fun L18_optionalFiltersQuotedFormsAreNoOps() = live {
    fx.assertRow(ServerContract.L18a)
    fx.assertRow(ServerContract.L18b)
    fx.assertRow(ServerContract.L18c)
    fx.assertRow(ServerContract.L18d)
    fx.assertRow(ServerContract.L18e)
    fx.assertRow(ServerContract.L18f)
  }

  @Test
  fun L19_optionalFiltersScoresAndNegation() = live {
    fx.assertRow(ServerContract.L19a)
    fx.assertRow(ServerContract.L19b)
    fx.assertRow(ServerContract.L19c)
    fx.assertRow(ServerContract.L19d)
    fx.assertRow(ServerContract.L19e)
  }

  @Test
  fun L20_optionalFiltersAndVersusOrScores() = live {
    fx.assertRow(ServerContract.L20a)
    fx.assertRow(ServerContract.L20b)
  }

  @Test
  fun L21_optionalFiltersSpecialValues() = live {
    fx.assertRow(ServerContract.L21a)
    fx.assertRow(ServerContract.L21b)
    fx.assertRow(ServerContract.L21c)
    fx.assertRow(ServerContract.L21d)
  }

  @Test
  fun L22_responseFieldsAreExact() = live {
    fx.assertRow(ServerContract.L22a)
    fx.assertRow(ServerContract.L22b)
  }

  // ── Doc-driven rows L23–L53 ───────────────────────────────────────────────────────────────────

  @Test
  fun L23_booleanAndNumberFacetValues() = live {
    fx.assertRow(ServerContract.L23a)
    fx.assertRow(ServerContract.L23b)
    fx.assertRow(ServerContract.L23c)
    fx.assertRow(ServerContract.L23d)
  }

  @Test fun L24_sqlNotWithScoreZero() = live { fx.assertRow(ServerContract.L24) }

  @Test fun L25_optionalOrRowSumsScores() = live { fx.assertRow(ServerContract.L25) }

  @Test
  fun L26_localeFiltersWithNumericAndTag() = live {
    fx.assertRow(ServerContract.L26a)
    fx.assertRow(ServerContract.L26b)
    fx.assertRow(ServerContract.L26c)
  }

  @Test fun L27_localeAndPinnedWithOptionalBoost() = live { fx.assertRow(ServerContract.L27) }

  @Test
  fun L28_lookupByIdInjection() = live {
    fx.assertRow(ServerContract.L28a)
    fx.assertRow(ServerContract.L28b)
    fx.assertRow(ServerContract.L28c)
  }

  @Test fun L29_wrapperQueryWithRuleContext() = live { fx.assertRow(ServerContract.L29) }

  @Test fun L30_composerQueryWithRuleContexts() = live { fx.assertRow(ServerContract.L30) }

  @Test
  fun L31_localeWithQueryLanguages() = live {
    fx.assertRow(ServerContract.L31a)
    fx.assertRow(ServerContract.L31b)
  }

  @Test fun L32_restrictAndHighlightTitle() = live { fx.assertRow(ServerContract.L32) }

  @Test fun L33_optionalBoostWithSum() = live { fx.assertRow(ServerContract.L33) }

  @Test fun L34_assembledContributors() = live { fx.assertRow(ServerContract.L34) }

  @Test fun L35_sqlAndOfThreeTypedFacets() = live { fx.assertRow(ServerContract.L35) }

  @Test
  fun L36_negatedFacetsSqlAndLegacy() = live {
    fx.assertRow(ServerContract.L36a)
    fx.assertRow(ServerContract.L36b)
  }

  @Test
  fun L37_requestMapModulesWithScoreZero() = live {
    fx.assertRow(ServerContract.L37a)
    fx.assertRow(ServerContract.L37b)
    fx.assertRow(ServerContract.L37c)
    fx.assertRow(ServerContract.L37d)
  }

  @Test fun L38_deleteQueryFiltersAsSearch() = live { fx.assertRow(ServerContract.L38) }

  @Test fun L39_sqlOrOfEntityIds() = live { fx.assertRow(ServerContract.L39) }

  @Test fun L40_queryScalars() = live { fx.assertRow(ServerContract.L40) }

  @Test
  fun L41_fullSnippetWithSearchableRestriction() = live {
    fx.assertRow(ServerContract.L41a)
    fx.assertRow(ServerContract.L41b)
  }

  @Test fun L42_sqlOrGroupsByFamily() = live { fx.assertRow(ServerContract.L42) }

  @Test fun L43_legacyNumericAndTagOr() = live { fx.assertRow(ServerContract.L43) }

  @Test fun L44_optionalAndOrWithScoreAndNegation() = live { fx.assertRow(ServerContract.L44) }

  @Test
  fun L45_restrictSearchableAttributes() = live {
    fx.assertRow(ServerContract.L45a)
    fx.assertRow(ServerContract.L45b)
  }

  @Test fun L46_attributesToHighlight() = live { fx.assertRow(ServerContract.L46) }

  @Test fun L47_attributesToRetrieve() = live { fx.assertRow(ServerContract.L47) }

  @Test
  fun L48_stopWordsPerQueryLanguage() = live {
    fx.assertRow(ServerContract.L48a)
    fx.assertRow(ServerContract.L48b)
  }

  @Test
  fun L49_ruleContextsUserData() = live {
    fx.assertRow(ServerContract.L49a)
    fx.assertRow(ServerContract.L49b)
  }

  @Test
  fun L50_addFacetScoreDefaultZero() = live {
    fx.assertRow(ServerContract.L50a)
    fx.assertRow(ServerContract.L50b)
  }

  @Test fun L51_scoreOmittedVersusExplicitZeroInSqlOr() = live { fx.assertRow(ServerContract.L51) }

  @Test fun L52_explicitZeroInOptionalFilters() = live { fx.assertRow(ServerContract.L52) }

  @Test fun L53_typedCompanionsAcceptedTogether() = live { fx.assertRow(ServerContract.L53) }

  // ── Delete rows D1–D2 (raw deleteByQuery on a copy of the fixture) ────────────────────────────

  @Test
  fun D1_deleteByOrOfIds() =
    live(timeout = DELETE_TIMEOUT) {
      fx.assertDelete(ServerContract.D1) { copy -> copy.deleteByQuery(ServerContract.D1.params) }
    }

  @Test
  fun D2_deleteByOrOfIdsAndNegatedBatch() =
    live(timeout = DELETE_TIMEOUT) {
      fx.assertDelete(ServerContract.D2) { copy -> copy.deleteByQuery(ServerContract.D2.params) }
    }
}

/** Copy + deleteBy + two waits: more than one query round-trip. */
private val DELETE_TIMEOUT = 180.seconds

/** Raw `deleteByQuery` with the row's body; returns the engine's `taskID`. */
private suspend fun LiveIndex.deleteByQuery(params: JsonObject): Long {
  val response = client.customPost("1/indexes/$name/deleteByQuery", body = params)
  return checkNotNull(response["taskID"]) { "deleteByQuery on $name returned no taskID: $response" }
    .jsonPrimitive
    .long
}
