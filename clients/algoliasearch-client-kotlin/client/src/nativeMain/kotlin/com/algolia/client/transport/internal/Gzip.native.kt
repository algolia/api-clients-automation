package com.algolia.client.transport.internal

import io.ktor.client.plugins.api.*
import io.ktor.client.request.*
import io.ktor.content.*
import io.ktor.http.content.ByteArrayContent
import kotlinx.cinterop.*
import platform.Foundation.*
import platform.posix.memcpy
import platform.zlib.*

internal actual val GzipPlugin: ClientPlugin<Unit> = createClientPlugin("GzipPlugin") {
  on(Send) { request ->
    val body = request.body
    if (body is TextContent) {
      val encoded = body.text.asNSData()
        ?.compress()
        ?.toByteArray()
        ?: throw IllegalStateException("unable to compress data")
      val content = ByteArrayContent(encoded, contentType = body.contentType)
      request.header("Content-Encoding", "gzip")
      request.setBody(content)
    }
    proceed(request)
  }
}

internal const val CHUNK = 16384u // 16K chunks for expansion

@OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)
private fun NSData.compress(): NSData? {
  return memScoped {
    val stream: z_stream = alloc()
    val compressed: NSMutableData
    try {
      stream.zalloc = null
      stream.zfree = null
      stream.opaque = null
      stream.avail_in = length.convert()
      stream.next_in = bytes!!.reinterpret()
      stream.total_out = 0u
      stream.avail_out = 0u

      if (deflateInit2(
          strm = stream.ptr,
          level = Z_DEFAULT_COMPRESSION,
          method = Z_DEFLATED,
          windowBits = 31, // (15+16) for gzip
          memLevel = MAX_MEM_LEVEL,
          strategy = Z_DEFAULT_STRATEGY,
        ) != Z_OK
      ) {
        return null
      }

      compressed = NSMutableData.dataWithLength(CHUNK.convert())!!
      do {
        if (stream.total_out >= compressed.length) compressed.increaseLengthBy(CHUNK.convert())
        stream.next_out = compressed.mutableBytes!!.reinterpret<uBytefVar>() + stream.total_out.toInt()
        val avail = compressed.length - stream.total_out
        stream.avail_out = avail.convert()
        deflate(stream.ptr, Z_FINISH)
      } while (stream.avail_out == 0u)
    } finally {
      deflateEnd(stream.ptr)
    }

    NSData.create(data = compressed)
  }
}

@OptIn(ExperimentalForeignApi::class)
private fun NSData.toByteArray(): ByteArray = memScoped {
  val size = length.toInt()
  val nsData = ByteArray(size)
  memcpy(nsData.refTo(0), bytes, size.convert())
  return nsData
}

/**
 * Converts [String] to [NSData] using UTF-8 encoding.
 */
@Suppress("CAST_NEVER_SUCCEEDS")
private fun String.asNSData(): NSData? {
  return (this as NSString).dataUsingEncoding(NSUTF8StringEncoding)
}
