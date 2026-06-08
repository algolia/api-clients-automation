package algoliasearch.extension

import algoliasearch.api.{IngestionClient, SearchClient}
import algoliasearch.config.{RequestOptions, TransformationOptions}
import algoliasearch.exception.{AlgoliaApiException, AlgoliaClientException}
import algoliasearch.extension.ChunkedHelperOptions.DefaultMaxRetries
import algoliasearch.extension.internal.Iterable.createIterable
import algoliasearch.extension.internal.RetryUntil.{DEFAULT_DELAY, retryUntil}
import algoliasearch.ingestion.{
  Action => IngestionAction,
  Event => IngestionEvent,
  PushTaskPayload,
  PushTaskRecords,
  WatchResponse => IngestionWatchResponse
}
import algoliasearch.internal.util.{escape, paramToString}
import algoliasearch.search._
import org.json4s.native.Serialization.read
import org.json4s.{DefaultFormats, Extraction, Formats, jvalue2extractable}

import java.nio.charset.StandardCharsets
import java.util.Base64
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import scala.concurrent.duration.Duration
import scala.concurrent.{ExecutionContext, Future}
import scala.util.matching.Regex
import scala.util.{Failure, Success, Try}

trait SecuredApiKeyImplicits {

  implicit class SecuredApiKeyRestrictionsExtension(val restrictions: SecuredApiKeyRestrictions) {

    /** Converts the restrictions to a URL-encoded string. Only includes fields that are defined (Some).
      */
    def toUrlEncoded: String = {
      implicit val formats: Formats = JsonSupport.format

      val jValue = Extraction.decompose(restrictions.searchParams)
      var baseParams = jValue.extract[Map[String, Any]]

      if (restrictions.filters.isDefined) {
        baseParams += ("filters" -> restrictions.filters.get)
      }

      if (restrictions.validUntil.isDefined) {
        baseParams += ("validUntil" -> restrictions.validUntil.get)
      }

      if (restrictions.restrictIndices.isDefined) {
        baseParams += ("restrictIndices" -> restrictions.restrictIndices.get)
      }

      if (restrictions.restrictSources.isDefined) {
        baseParams += ("restrictSources" -> restrictions.restrictSources.get)
      }

      if (restrictions.userToken.isDefined) {
        baseParams += ("userToken" -> restrictions.userToken.get)
      }

      val params = baseParams.toList
        .sortBy(_._1)
        .map { case (k, v) => s"${escape(k)}=${escape(paramToString(v))}" }

      params.mkString("&")
    }
  }
}
