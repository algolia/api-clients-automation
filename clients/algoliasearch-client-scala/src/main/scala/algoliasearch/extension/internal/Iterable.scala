package algoliasearch.extension.internal

import scala.concurrent.{ExecutionContext, Future, blocking}
import scala.concurrent.duration.Duration

private[algoliasearch] object Iterable {
  case class Error[T](
      validate: T => Boolean,
      message: Option[T => String] = None
  )

  def createIterable[T](
      execute: Option[T] => Future[T],
      validate: T => Boolean,
      aggregator: Option[T => Unit] = None,
      timeout: () => Duration = () => Duration.Zero,
      error: Option[Iterable.Error[T]] = None
  )(implicit ec: ExecutionContext): Future[T] = {
    def executor(previousResponse: Option[T] = None): Future[T] = {
      execute(previousResponse).flatMap { response =>
        // Call aggregator if defined
        aggregator.foreach(agg => agg(response))

        // Validate the response
        if (validate(response)) {
          Future.successful(response)
        } else {
          // Check for error validation
          error match {
            case Some(err) if err.validate(response) =>
              err.message match {
                case Some(errMsg) => Future.failed(new Exception(errMsg(response)))
                case None         => Future.failed(new Exception("An error occurred"))
              }
            case _ =>
              // Sleep for timeout duration, then retry
              blocking(Thread.sleep(timeout().toMillis))
              executor(Some(response))
          }
        }
      }
    }

    executor()
  }
}
