package com.algolia.client.transport.internal

import io.ktor.client.plugins.api.*

internal expect val GzipPlugin: ClientPlugin<Unit>
