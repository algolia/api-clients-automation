package com.algolia.client.configuration.internal

import io.ktor.client.plugins.api.*

internal class AuthConfig {
    var appId: String? = null
    var apiKey: String? = null
}

internal val AlgoliaAuth = createClientPlugin("AlgoliaAuthPlugin", ::AuthConfig) {
    val appId = requireNotNull(pluginConfig.appId) { "Application ID is required" }
    val apiKey = requireNotNull(pluginConfig.apiKey) { "API key is required" }
    onRequest { request, _ ->
        request.headers["x-algolia-application-id"] = appId
        request.headers["x-algolia-api-key"] = apiKey
    }
}
