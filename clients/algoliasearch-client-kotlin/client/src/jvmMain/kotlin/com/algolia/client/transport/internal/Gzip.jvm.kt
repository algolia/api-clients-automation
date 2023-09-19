package com.algolia.client.transport.internal

import io.ktor.client.plugins.api.*
import io.ktor.client.request.*
import io.ktor.http.content.*
import io.ktor.util.*
import io.ktor.utils.io.*

internal actual val GzipPlugin: ClientPlugin<Unit> = createClientPlugin("GzipPlugin") {
  on(Send) { request ->
    val body = request.body
    if (body is TextContent) {
      val encoded = ByteReadChannel(body.text).deflated(gzip = true).toByteArray()
      val content = ByteArrayContent(encoded, contentType = body.contentType)
      request.header("Content-Encoding", "gzip")
      request.setBody(content)
    }
    proceed(request)
  }
}
