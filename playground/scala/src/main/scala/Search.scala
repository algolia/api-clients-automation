import algoliasearch.api.SearchClient
import algoliasearch.config.{ClientOptions, Logging}
import algoliasearch.search.{JsonSupport, SearchForHits, SearchMethodParams, SearchResponse, SearchResponses, SearchResult}
import io.github.cdimascio.dotenv.Dotenv
import org.json4s.{Extraction, Formats, jvalue2extractable}
import org.json4s.native.JsonParser
import org.json4s.native.Serialization.{read, write}

import java.lang.reflect.Field
import java.sql.Timestamp
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor}

object Search {
  // Recursively get all the fields; this will grab vals declared in parents of case classes.
  def getFields(cls: Class[_]): List[Field] =
    Option(cls.getSuperclass).map(getFields).getOrElse(Nil) ++
      cls.getDeclaredFields.toList.filterNot(f => f.isSynthetic || java.lang.reflect.Modifier.isStatic(f.getModifiers))

  // FIXME fix bug where indent seems to increase too much
  def prettyfy(a: Any, indentSize: Int = 0): String = {
    val indent = List.fill(indentSize)(" ").mkString

    val newIndentSize = indentSize + 2
    (a match {
      // Make Strings look similar to their literal form.
      case string: String =>
        val conversionMap = Map('\n' -> "\\n", '\r' -> "\\r", '\t' -> "\\t", '\"' -> "\\\"", '\\' -> "\\\\")
        string.map(c => conversionMap.getOrElse(c, c)).mkString("\"", "", "\"")
      case xs: Seq[_] =>
        xs.map(prettyfy(_, newIndentSize)).toString
      case xs: Array[_] =>
        s"Array(${xs.map(prettyfy(_, newIndentSize)).mkString(", ")})"
      case map: Map[_, _] =>
        s"Map(\n" + map
          .map { case (key, value) =>
            "  " + prettyfy(key, newIndentSize) + " -> " + prettyfy(value, newIndentSize)
          }
          .mkString(",\n") + "\n)"
      case None                 => "None"
      case Some(x)              => "Some(" + prettyfy(x, newIndentSize) + ")"
      case timestamp: Timestamp => "new Timestamp(" + timestamp.getTime + "L)"
      case p: Product =>
        s"${p.productPrefix}(\n${getFields(p.getClass)
            .map { f =>
              f.setAccessible(true)
              s"  ${f.getName} = ${prettyfy(f.get(p), newIndentSize)}"
            }
            .mkString(",\n")}\n)"
      // General objects and primitives end up here.
      case q =>
        Option(q).map(_.toString).getOrElse("null")
    })
      .split("\n", -1)
      .mkString("\n" + indent)
  }

  private case class Contact(firstname: String, lastname: String, company: String, followers: Long, objectID: String)
  def main(args: Array[String]): Unit = {
    implicit val ec: ExecutionContextExecutor = scala.concurrent.ExecutionContext.global
    implicit val formats: Formats = JsonSupport.format

    val dotenv = Dotenv.configure.directory("../").load
    val appId = dotenv.get("ALGOLIA_APPLICATION_ID")
    val apiKey = dotenv.get("ALGOLIA_ADMIN_KEY")

    val client = SearchClient(
      appId = appId,
      apiKey = apiKey,
      clientOptions = ClientOptions
        .builder()
        .withLogging(Logging.Full)
        .withAgentSegment("playground")
        .build()
    )

    val params = SearchMethodParams(
      requests = Seq(
        SearchForHits(
          indexName = "contacts",
          query = Some("Jimmie")
        )
      )
    )
    val res = client.search(searchMethodParams = params)
    val value = Await.result[SearchResponses](res, Duration(100, "sec"))

    val responses = jvalue2extractable(Extraction.decompose(value)).extract[SearchResponses]

    println(prettyfy(responses))

    val json = write[SearchResponses](responses)
    println(json)
  }
}
