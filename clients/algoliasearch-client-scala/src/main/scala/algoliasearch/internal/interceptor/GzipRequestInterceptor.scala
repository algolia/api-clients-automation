package algoliasearch.internal.interceptor

import okhttp3._
import okio.{BufferedSink, GzipSink, Okio}

import scala.util.Using

/** Interceptor that compresses the request body using GZIP.
  */
private[internal] class GzipRequestInterceptor extends Interceptor {

  override def intercept(chain: Interceptor.Chain): Response = {
    val originalRequest: Request = chain.request()

    if (
      originalRequest
        .body() == null || originalRequest.header("Content-Encoding") != null
    ) {
      return chain.proceed(originalRequest)
    }

    val compressedRequest: Request = originalRequest
      .newBuilder()
      .header("Content-Encoding", "gzip")
      .method(originalRequest.method(), gzip(originalRequest.body()))
      .build()

    chain.proceed(compressedRequest)
  }

  private def gzip(body: RequestBody): RequestBody = new RequestBody {
    override def contentType(): MediaType = body.contentType()

    override def contentLength(): Long =
      -1 // We don't know the compressed length in advance!

    override def writeTo(sink: BufferedSink): Unit = {
      Using(Okio.buffer(new GzipSink(sink))) { gzipSink =>
        body.writeTo(gzipSink)
      }
    }
  }
}
