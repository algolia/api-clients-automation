import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import algoliasearch.api.SearchClient
import algoliasearch.config.*
import algoliasearch.extension.SearchClientExtensions
import algoliasearch.search.{Action, BatchParams, MultipleBatchRequest}

def deleteMultipleIndices(): Future[Unit] = {
  // You need an API key with `deleteIndex`
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  client
    .listIndices(
    )
    .flatMap { indices =>
      val (primaryIndices, replicaIndices) = indices.items.partition(_.primary.isEmpty)

      val deletePrimary = if (primaryIndices.nonEmpty) {
        val requests = primaryIndices.map(index => MultipleBatchRequest(Action.Delete, None, index.name))
        client
          .multipleBatch(
            batchParams = BatchParams(
              requests = requests
            )
          )
          .map { _ =>
            println("Deleted primary indices.")
          }
      } else Future.unit

      val deleteReplica = if (replicaIndices.nonEmpty) {
        val requests = replicaIndices.map(index => MultipleBatchRequest(Action.Delete, None, index.name))
        client
          .multipleBatch(
            batchParams = BatchParams(
              requests = requests
            )
          )
          .map { _ =>
            println("Deleted replica indices.")
          }
      } else Future.unit

      for {
        _ <- deletePrimary
        _ <- deleteReplica
      } yield ()
    }
    .recover { case ex: Exception =>
      println(s"An error occurred: ${ex.getMessage}")
    }
}
