package algoliasearch.extension

import algoliasearch.api.IngestionClient
import algoliasearch.config.RequestOptions
import algoliasearch.exception.{AlgoliaApiException, AlgoliaClientException}
import algoliasearch.extension.internal.RetryUntil.retryUntil
import algoliasearch.ingestion.{
  PushTaskPayload,
  PushTaskRecords,
  Action => IngestionAction,
  Event => IngestionEvent,
  WatchResponse => IngestionWatchResponse
}
import org.json4s.{Extraction, Formats, jvalue2extractable}

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

trait IngestionExtensions {

  implicit class IngestionClientExtensions(val client: IngestionClient) {

    /** Helper: Chunks `objects` into requests of at most `batchSize` records and pushes each chunk through the
      * Ingestion API's transformation pipeline.
      *
      * If `waitForTasks` is true, the helper polls the Ingestion API after every `max(1, batchSize / 10)` pushes for
      * the corresponding events, providing backpressure on long jobs.
      *
      * @param indexName
      *   The index in which to perform the request.
      * @param objects
      *   The list of objects to push.
      * @param action
      *   The action to perform on the objects.
      * @param waitForTasks
      *   Whether to wait for the server to finish processing each push.
      * @param batchSize
      *   The size of the chunk. Default is 1000.
      * @param referenceIndexName
      *   Required when targeting an index that does not have a push connector setup, but you wish to attach another
      *   index's transformation to it.
      * @param requestOptions
      *   Additional request configuration.
      * @return
      *   A future containing the responses from each push.
      */
    def chunkedPush(
        indexName: String,
        objects: Seq[Any],
        action: IngestionAction,
        waitForTasks: Boolean,
        batchSize: Int = 1000,
        referenceIndexName: Option[String] = None,
        requestOptions: Option[RequestOptions] = None,
        chunkedOptions: ChunkedHelperOptions = ChunkedHelperOptions()
    )(implicit ec: ExecutionContext): Future[Seq[IngestionWatchResponse]] = {
      if (batchSize < 1) return Future.failed(new AlgoliaClientException("`batchSize` must be greater than 0"))

      val batches = objects.grouped(batchSize).toSeq
      if (batches.isEmpty) return Future.successful(Seq.empty)

      val pollInterval = math.max(1, batchSize / 10)
      val superBatches = batches.grouped(pollInterval).toSeq

      def pushSuperBatch(superBatch: Seq[Seq[Any]]): Future[Seq[IngestionWatchResponse]] =
        superBatch.foldLeft(Future.successful(Vector.empty[IngestionWatchResponse])) { (acc, batch) =>
          acc.flatMap { rs =>
            client
              .push(
                indexName = indexName,
                pushTaskPayload = PushTaskPayload(action = action, records = objectsToPushTaskRecords(batch)),
                watch = Some(false),
                referenceIndexName = referenceIndexName,
                requestOptions = requestOptions
              )
              .map(rs :+ _)
          }
        }

      superBatches
        .foldLeft(Future.successful(Vector.empty[IngestionWatchResponse])) { (acc, superBatch) =>
          for {
            responsesSoFar <- acc
            pushed <- pushSuperBatch(superBatch)
            _ <-
              if (waitForTasks)
                pushed.foldLeft(Future.unit) { (a, r) =>
                  a.flatMap(_ => pollEvent(r, requestOptions, chunkedOptions.maxRetries).map(_ => ()))
                }
              else Future.unit
          } yield responsesSoFar ++ pushed
        }
        .map(_.toSeq)
    }

    private def pollEvent(
        response: IngestionWatchResponse,
        requestOptions: Option[RequestOptions],
        maxRetries: Int
    )(implicit ec: ExecutionContext): Future[Option[IngestionEvent]] = {
      response.eventID match {
        case None =>
          Future.failed(
            new AlgoliaClientException(
              "received unexpected response from the push endpoint, eventID must not be undefined"
            )
          )
        case Some(eventID) =>
          retryUntil(
            retry = () =>
              client
                .getEvent(response.runID, eventID, requestOptions)
                .map(Option(_))
                .recover {
                  case e: AlgoliaApiException if e.httpErrorCode == 404 => None
                },
            until = (event: Option[IngestionEvent]) => event.isDefined,
            maxRetries = maxRetries,
            delay = retries => math.min(retries * 1500, 5000L)
          )
      }
    }

    private def objectsToPushTaskRecords(objects: Seq[Any]): Seq[PushTaskRecords] = {
      implicit val formats: Formats = algoliasearch.ingestion.JsonSupport.format
      Try {
        val jValue = Extraction.decompose(objects)
        jValue.extract[Seq[PushTaskRecords]]
      } match {
        case Success(records) => records
        case Failure(e) =>
          throw new AlgoliaClientException(
            "each object must have an `objectID` key in order to be indexed",
            e
          )
      }
    }
  }
}
