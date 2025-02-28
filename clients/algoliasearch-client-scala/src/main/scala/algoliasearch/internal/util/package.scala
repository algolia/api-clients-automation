package algoliasearch.internal

import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import java.time.{Clock, Instant, OffsetDateTime, ZoneOffset}
import scala.annotation.tailrec

package object util {

  private[internal] def currentDateTime(): OffsetDateTime = {
    val now: Instant = Clock.system(ZoneOffset.UTC).instant()
    OffsetDateTime.ofInstant(now, ZoneOffset.UTC.getRules.getOffset(now))
  }

  private[algoliasearch] def requireNotNull(param: Any, error: String): Unit = {
    if (param == null) throw new IllegalArgumentException(error)
  }

  /** Escape the given string to be used as URL query value.
    */
  private[algoliasearch] def escape(input: Any): String = input match {
    case value: String => URLEncoder.encode(value, StandardCharsets.UTF_8.toString).replaceAll("\\+", "%20")
    case _             => input.toString
  }

  /** Convert a parameter to a string.
    *
    * @param value
    *   The value to convert
    */
  private[algoliasearch] def paramToString(value: Any): String = value match {
    case _: java.util.Date | _: java.time.OffsetDateTime | _: java.time.LocalDate =>
      throw new UnsupportedOperationException(
        "Date must come as string (already serialized)"
      )
    case c: Iterable[?] => c.map(_.toString).mkString(",")
    case _              => value.toString
  }
}
