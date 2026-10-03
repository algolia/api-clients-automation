package algoliasearch.manual

import algoliasearch.internal.JsonSerializer

import org.json4s.{DefaultFormats, Formats}
import org.scalatest.funsuite.AnyFunSuite

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}
import java.nio.charset.StandardCharsets

/** Pins that JSON is read and written as UTF-8 regardless of the JVM default charset. */
class JsonSerializerCharsetTest extends AnyFunSuite {
  implicit val formats: Formats = DefaultFormats

  private val serializer = JsonSerializer()

  test("serializes non-ASCII text as UTF-8") {
    val out = new ByteArrayOutputStream()
    serializer.serialize(out, Map("message" -> "café 日本"))
    assert(out.toByteArray.sameElements("""{"message":"café 日本"}""".getBytes(StandardCharsets.UTF_8)))
  }

  test("deserializes UTF-8 input") {
    val in = new ByteArrayInputStream("""{"message":"café 日本"}""".getBytes(StandardCharsets.UTF_8))
    assert(serializer.deserialize[Map[String, String]](in) == Map("message" -> "café 日本"))
  }
}
