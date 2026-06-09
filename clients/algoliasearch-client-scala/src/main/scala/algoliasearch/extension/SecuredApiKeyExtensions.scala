package algoliasearch.extension

import algoliasearch.internal.util.{escape, paramToString}
import algoliasearch.search._
import org.json4s.{Extraction, Formats, jvalue2extractable}

trait SecuredApiKeyExtensions {

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
