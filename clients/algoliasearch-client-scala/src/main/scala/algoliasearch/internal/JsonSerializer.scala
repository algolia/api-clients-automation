package algoliasearch.internal

import algoliasearch.exception.AlgoliaClientException
import org.json4s._
import org.json4s.native.JsonParser.parse
import org.json4s.native.Serialization.write

import java.io.{InputStream, InputStreamReader, OutputStream, OutputStreamWriter}

/** Utility class for JSON serialization and deserialization using JSON4S. It provides functionality to convert Scala
  * objects to their JSON representation and vice versa.
  */
class JsonSerializer(implicit val formats: Formats) {

  /** Serializes a Scala object into its JSON representation.
    *
    * @param stream
    *   output stream.
    * @param obj
    *   The Scala object to serialize.
    */
  def serialize[T](stream: OutputStream, obj: T): Unit = {
    val writer = new OutputStreamWriter(stream)
    try {
      val json = write[T](obj)
      writer.write(json)
      writer.flush()
    } catch {
      case e: Exception => throw AlgoliaClientException(cause = e)
    } finally {
      writer.close()
    }
  }

  /** Deserializes a JSON InputStream into a Scala object of a given type.
    *
    * @param stream
    *   InputStream containing JSON.
    * @tparam T
    *   The type of the Scala object.
    * @return
    *   The deserialized Scala object.
    */
  def deserialize[T: Manifest](stream: InputStream): T = {
    val reader = new InputStreamReader(stream)
    try {
      val json = parse(reader)
      json.extract[T]
    } catch {
      case e: Exception => throw AlgoliaClientException(cause = e)
    } finally {
      reader.close()
    }
  }
}

object JsonSerializer {

  /** Creates a new instance of the JsonSerializer class.
    * @param formats
    *   JSON formats
    */
  def apply()(implicit formats: Formats): JsonSerializer =
    new JsonSerializer()(formats)
}
