package com.algolia.client

import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.ClientOptions
import com.algolia.client.configuration.Host
import com.sun.net.httpserver.HttpServer
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.apache5.Apache5
import io.ktor.client.engine.cio.CIO
import io.ktor.client.engine.java.Java
import io.ktor.client.engine.okhttp.OkHttp
import java.io.ByteArrayOutputStream
import java.net.InetSocketAddress
import java.util.zip.GZIPOutputStream
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.jsonPrimitive

/**
 * Every JVM engine must advertise `Accept-Encoding: gzip` and decode gzipped responses, mirroring
 * the CTS "test the response decompression strategy" (which only runs with OkHttp).
 */
class TestResponseDecompression {

  private val responseBody = """{"message":"ok decompression test server response"}"""

  private lateinit var server: HttpServer

  @BeforeTest
  fun startServer() {
    server = HttpServer.create(InetSocketAddress("localhost", 0), 0)
    server.createContext("/1/test/gzip-response") { exchange ->
      exchange.use {
        val acceptEncoding = it.requestHeaders.getFirst("Accept-Encoding").orEmpty()
        if (!acceptEncoding.contains("gzip")) {
          val error = """{"message":"client did not send accept-encoding: gzip"}""".toByteArray()
          it.sendResponseHeaders(400, error.size.toLong())
          it.responseBody.write(error)
          return@use
        }
        val compressed =
          ByteArrayOutputStream().use { bos ->
            GZIPOutputStream(bos).use { gzip -> gzip.write(responseBody.toByteArray()) }
            bos.toByteArray()
          }
        it.responseHeaders.add("Content-Type", "application/json")
        it.responseHeaders.add("Content-Encoding", "gzip")
        it.sendResponseHeaders(200, compressed.size.toLong())
        it.responseBody.write(compressed)
      }
    }
    server.start()
  }

  @AfterTest
  fun stopServer() {
    server.stop(0)
  }

  private fun assertDecompressed(engine: HttpClientEngine) = runBlocking {
    val client =
      SearchClient(
        appId = "test-app-id",
        apiKey = "test-api-key",
        options =
          ClientOptions(
            engine = engine,
            hosts = listOf(Host(url = "localhost", protocol = "http", port = server.address.port)),
          ),
      )
    client.use {
      val response = it.customGet(path = "1/test/gzip-response")
      assertEquals(
        "ok decompression test server response",
        response["message"]?.jsonPrimitive?.content,
      )
    }
  }

  @Test fun okHttpEngine() = assertDecompressed(OkHttp.create())

  @Test fun cioEngine() = assertDecompressed(CIO.create())

  @Test fun javaEngine() = assertDecompressed(Java.create())

  @Test fun apache5Engine() = assertDecompressed(Apache5.create())
}
