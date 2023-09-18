package com.algolia.client.configuration.internal

import com.algolia.client.configuration.AgentSegment
import platform.UIKit.UIDevice
import platform.UIKit.UIUserInterfaceIdiomPad
import platform.UIKit.UIUserInterfaceIdiomPhone
import kotlin.experimental.ExperimentalNativeApi

internal actual fun platformAgentSegment(): AgentSegment {
  val osName =
    @OptIn(ExperimentalNativeApi::class)
    when (UIDevice.currentDevice.userInterfaceIdiom) {
      UIUserInterfaceIdiomPhone -> "iOS"
      UIUserInterfaceIdiomPad -> "iPadOS"
      else -> Platform.osFamily.name
    }
  val version = UIDevice.currentDevice.systemVersion
  return AgentSegment(osName, version)
}
