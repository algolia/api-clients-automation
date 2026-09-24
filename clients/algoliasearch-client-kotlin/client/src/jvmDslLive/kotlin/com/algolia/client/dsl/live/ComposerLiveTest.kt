package com.algolia.client.dsl.live

import com.algolia.client.dsl.cases.ComposerCases
import com.algolia.client.dsl.live.testkit.LiveIndex
import com.algolia.client.dsl.live.testkit.assertCase
import com.algolia.client.dsl.live.testkit.live
import kotlin.test.Test
import org.junit.AfterClass
import org.junit.BeforeClass

/**
 * Live half of [ComposerCases]: the bodies the composer and the user-side wrapper build are sent to
 * the fixture index and checked against the case's expectations.
 */
internal class ComposerLiveTest {

  companion object {
    private lateinit var fx: LiveIndex

    @JvmStatic
    @BeforeClass
    fun createFixture() {
      fx = LiveIndex.create("composer")
    }

    @JvmStatic
    @AfterClass
    fun deleteFixture() {
      if (::fx.isInitialized) fx.close()
    }
  }

  @Test fun queryWrapperPort() = live { fx.assertCase(ComposerCases.queryWrapperPort) }

  @Test fun addAndOverride() = live { fx.assertCase(ComposerCases.addAndOverride) }

  @Test
  fun localeModuleWithoutSecondary() = live {
    fx.assertCase(ComposerCases.localeModuleWithoutSecondary)
  }

  @Test
  fun localeModuleWithSecondary() = live { fx.assertCase(ComposerCases.localeModuleWithSecondary) }

  @Test fun searchableTitleModule() = live { fx.assertCase(ComposerCases.searchableTitleModule) }

  @Test fun boostModule() = live { fx.assertCase(ComposerCases.boostModule) }

  @Test
  fun assembledContributorsAppliedOnce() = live {
    fx.assertCase(ComposerCases.assembledContributorsAppliedOnce)
  }

  @Test fun requestMapModules() = live { fx.assertCase(ComposerCases.requestMapModules) }

  @Test
  fun requestMapModulesSkipUnparsablePriority() = live {
    fx.assertCase(ComposerCases.requestMapModulesSkipUnparsablePriority)
  }
}
