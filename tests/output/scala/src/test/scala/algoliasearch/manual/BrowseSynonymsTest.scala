package algoliasearch.manual

import algoliasearch.api.SearchClient
import algoliasearch.config.ClientOptions
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.{SearchSynonymsParams, SearchSynonymsResponse, SynonymHit}

import okhttp3.Interceptor.Chain
import okhttp3.{Interceptor, MediaType, Protocol, Response, ResponseBody}
import okio.Buffer
import org.json4s.{JInt, JLong, JObject}
import org.json4s.native.JsonMethods.parse
import org.scalatest.funsuite.AnyFunSuite

import java.util.concurrent.ConcurrentLinkedQueue
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext}
import scala.jdk.CollectionConverters._

/** Fully offline HTTP stub for the `browseSynonyms` pagination regression test (Jira CR-11727).
  *
  * It is installed as an OkHttp application interceptor (same mechanism as the generated `EchoInterceptor`), so the
  * whole real request path runs -- the params are serialized to a JSON body, this stub short-circuits the network, and
  * the canned JSON is deserialized back into a `SearchSynonymsResponse` -- without ever touching the network.
  *
  * For every `/synonyms/search` call it reads the `page` from the request body, records it, and answers with:
  *   - page 0    -> a FULL page of 1000 hits ("page0-hit0".."page0-hit999")
  *   - page >= 1 -> a PARTIAL page of 3 hits ("page1-hit0".."page1-hit2")
  *
  * The partial page is the signal that stops pagination, so a correct implementation must request exactly pages 0 then
  * 1. The Java bug this guards against never wrote the incremented page back into the request, so it re-fetched page 0
  * forever.
  */
private class BrowseSynonymsMockInterceptor extends Interceptor {

  /** Pages, in the order they were requested (FIFO). */
  val requestedPages: ConcurrentLinkedQueue[Int] = new ConcurrentLinkedQueue[Int]()

  private def hitsArray(prefix: String, count: Int): String =
    (0 until count)
      .map(i => s"""{"objectID":"$prefix-hit$i","type":"synonym"}""")
      .mkString("[", ",", "]")

  override def intercept(chain: Chain): Response = {
    val request = chain.request()

    val requestBody = Option(request.body) match {
      case Some(body) =>
        val buffer = new Buffer()
        body.writeTo(buffer)
        buffer.readUtf8()
      case None => ""
    }

    val responseJson =
      if (request.url.encodedPath.endsWith("/synonyms/search")) {
        val page = parse(requestBody) match {
          case JObject(fields) =>
            fields.collectFirst {
              case ("page", JInt(value))  => value.toInt
              case ("page", JLong(value)) => value.toInt
            }.getOrElse(0)
          case _ => 0
        }
        requestedPages.add(page)

        if (page == 0) s"""{"hits":${hitsArray("page0", 1000)},"nbHits":1003}"""
        else s"""{"hits":${hitsArray("page1", 3)},"nbHits":1003}"""
      } else {
        "{}"
      }

    new Response.Builder()
      .code(200)
      .request(request)
      .protocol(Protocol.HTTP_2)
      .message("OK")
      .body(ResponseBody.create(responseJson, MediaType.parse("application/json")))
      .build()
  }
}

class BrowseSynonymsTest extends AnyFunSuite {
  implicit val ec: ExecutionContext = scala.concurrent.ExecutionContext.global

  test("browseSynonyms paginates until a partial page and aggregates every hit") {
    val mock = new BrowseSynonymsMockInterceptor()
    val client = SearchClient(
      appId = "appId",
      apiKey = "apiKey",
      clientOptions = ClientOptions
        .builder()
        .withRequesterConfig(requester => requester.withInterceptor(mock))
        .build()
    )

    val collectedHits = new ConcurrentLinkedQueue[SynonymHit]()

    try {
      Await.result(
        client.browseSynonyms(
          indexName = "my-index",
          searchSynonymsParams = SearchSynonymsParams(),
          aggregator = (response: SearchSynonymsResponse) => response.hits.foreach(collectedHits.add)
        ),
        Duration.Inf
      )
    } finally {
      client.close()
    }

    val pages = mock.requestedPages.asScala.toList
    val objectIDs = collectedHits.asScala.toList.map(_.objectID)

    assert(pages == List(0, 1), s"expected pages Seq(0, 1) but requested $pages")
    assert(objectIDs.size == 1003, s"expected 1003 aggregated hits but got ${objectIDs.size}")
    assert(
      objectIDs.distinct.size == 1003,
      s"expected 1003 distinct objectIDs but got ${objectIDs.distinct.size}"
    )
  }
}
