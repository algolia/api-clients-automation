package com.algolia.client.dsl.live.p0

import com.algolia.client.dsl.testkit.LiveIndex
import com.algolia.client.dsl.testkit.ServerContract
import com.algolia.client.dsl.testkit.assertRow
import com.algolia.client.dsl.testkit.live
import kotlin.test.Test
import org.junit.AfterClass
import org.junit.BeforeClass

/**
 * Server-contract suite, engine-only rows: shapes the DSL never builds (parentheses, rejects,
 * quoted no-ops, controls), sent raw through the generated `SearchClient` against one fixture index
 * to pin what the engine accepts, rejects and returns. Every row the DSL does build is asserted by
 * the `MatrixP<n>LiveTest` classes on the DSL's own bytes. One test per group (id without the
 * letter suffix); the sub-rows are asserted inside.
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

  @Test fun L02_parenthesisedSqlAnd() = live { fx.assertRow(ServerContract.L02) }

  @Test fun L03_sqlOrOfNegatedLeavesNoParens() = live { fx.assertRow(ServerContract.L03b) }

  @Test
  fun L06_sqlNotBeforeGroupIsRejected() = live {
    fx.assertRow(ServerContract.L06a)
    fx.assertRow(ServerContract.L06b)
  }

  @Test fun L07_sqlNestedGroupsAreRejected() = live { fx.assertRow(ServerContract.L07a) }

  @Test fun L08_sqlMixedTypesInOrAreRejected() = live { fx.assertRow(ServerContract.L08) }

  @Test
  fun L12_sqlQuotedDashIsLiteral() = live {
    fx.assertRow(ServerContract.L12c)
    fx.assertRow(ServerContract.L12d)
    fx.assertRow(ServerContract.L12e)
    fx.assertRow(ServerContract.L12f)
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

  @Test fun L21_optionalFiltersEscapedQuotesAreNoOps() = live { fx.assertRow(ServerContract.L21d) }

  @Test fun L22_responseFieldsAreExact() = live { fx.assertRow(ServerContract.L22b) }

  // ── Doc-driven rows L23–L53 ───────────────────────────────────────────────────────────────────

  @Test
  fun L23_booleanAndNumberFacetValues() = live {
    fx.assertRow(ServerContract.L23a)
    fx.assertRow(ServerContract.L23c)
  }

  @Test fun L26_parenthesisedLocaleOr() = live { fx.assertRow(ServerContract.L26b) }

  @Test fun L41_searchableRestrictionControl() = live { fx.assertRow(ServerContract.L41b) }

  @Test fun L49_ruleContextsControl() = live { fx.assertRow(ServerContract.L49b) }
}
