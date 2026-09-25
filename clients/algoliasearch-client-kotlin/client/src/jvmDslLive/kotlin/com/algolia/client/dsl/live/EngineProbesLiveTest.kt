package com.algolia.client.dsl.live

import com.algolia.client.dsl.cases.EngineProbes
import com.algolia.client.dsl.live.testkit.LiveIndex
import com.algolia.client.dsl.live.testkit.assertCase
import com.algolia.client.dsl.live.testkit.live
import kotlin.test.Test
import org.junit.AfterClass
import org.junit.BeforeClass

/**
 * Live half of [EngineProbes]: raw bodies the DSL never builds, sent as-is to pin what the engine
 * accepts, rejects and returns — the evidence the encoder rules rest on.
 */
internal class EngineProbesLiveTest {

  companion object {
    private lateinit var fx: LiveIndex

    @JvmStatic
    @BeforeClass
    fun createFixture() {
      fx = LiveIndex.create("probes")
    }

    @JvmStatic
    @AfterClass
    fun deleteFixture() {
      if (::fx.isInitialized) fx.close()
    }
  }

  @Test
  fun notBeforeOrGroupRejected() = live { fx.assertCase(EngineProbes.notBeforeOrGroupRejected) }

  @Test
  fun notBeforeAndGroupRejected() = live { fx.assertCase(EngineProbes.notBeforeAndGroupRejected) }

  @Test fun nestedGroupsRejected() = live { fx.assertCase(EngineProbes.nestedGroupsRejected) }

  @Test
  fun mixedFamiliesInOrRejected() = live { fx.assertCase(EngineProbes.mixedFamiliesInOrRejected) }

  @Test
  fun unquotedParenthesisRejected() = live {
    fx.assertCase(EngineProbes.unquotedParenthesisRejected)
  }

  @Test
  fun unquotedColonInValueRejected() = live {
    fx.assertCase(EngineProbes.unquotedColonInValueRejected)
  }

  @Test
  fun unquotedColonInAttributeRejected() = live {
    fx.assertCase(EngineProbes.unquotedColonInAttributeRejected)
  }

  @Test
  fun unquotedLessThanRejected() = live { fx.assertCase(EngineProbes.unquotedLessThanRejected) }

  @Test
  fun unquotedGreaterThanRejected() = live {
    fx.assertCase(EngineProbes.unquotedGreaterThanRejected)
  }

  @Test fun unquotedEqualsRejected() = live { fx.assertCase(EngineProbes.unquotedEqualsRejected) }

  @Test
  fun unquotedExclamationRejected() = live {
    fx.assertCase(EngineProbes.unquotedExclamationRejected)
  }

  @Test
  fun unescapedTrailingBackslashRejected() = live {
    fx.assertCase(EngineProbes.unescapedTrailingBackslashRejected)
  }

  @Test
  fun quotedAttributeAndValueIgnored() = live {
    fx.assertCase(EngineProbes.quotedAttributeAndValueIgnored)
  }

  @Test fun quotedValueIgnored() = live { fx.assertCase(EngineProbes.quotedValueIgnored) }

  @Test fun quotedAttributeIgnored() = live { fx.assertCase(EngineProbes.quotedAttributeIgnored) }

  @Test fun quotedWithScoreIgnored() = live { fx.assertCase(EngineProbes.quotedWithScoreIgnored) }

  @Test
  fun quotedNegationMatchesEveryRecord() = live {
    fx.assertCase(EngineProbes.quotedNegationMatchesEveryRecord)
  }

  @Test
  fun quotedLeadingDashIgnored() = live { fx.assertCase(EngineProbes.quotedLeadingDashIgnored) }

  @Test fun escapedQuotesNeverMatch() = live { fx.assertCase(EngineProbes.escapedQuotesNeverMatch) }
}
