package algoliasearch.extension.internal

import algoliasearch.exception.AlgoliaWaitException

import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Future, Promise}

private[algoliasearch] object RetryUntil {

  /** Retry a function until a condition is met.
    */
  def retryUntil[T](
      retry: () => Future[T],
      until: T => Boolean,
      maxRetries: Int,
      timeout: Option[Duration],
      initialDelay: Duration,
      maxDelay: Duration
  )(implicit ec: ExecutionContext): Future[T] = {

    val startTime = System.currentTimeMillis()

    def attempt(retryCount: Int, currentDelay: Duration): Future[T] = {
      if (retryCount >= maxRetries) {
        Future.failed(AlgoliaWaitException("The maximum number of retries exceeded."))
      } else {
        retry().flatMap { result =>
          if (until(result)) {
            Future.successful(result)
          } else if (timeout.exists(System.currentTimeMillis() - startTime > _.toMillis)) {
            Future.failed(AlgoliaWaitException("Timeout exceeded."))
          } else {
            val nextDelay = (currentDelay * 2).min(maxDelay)
            after(nextDelay)(attempt(retryCount + 1, nextDelay))
          }
        }
      }
    }

    attempt(0, initialDelay)
  }

  private def after[T](delay: Duration)(block: => Future[T])(implicit ec: ExecutionContext): Future[T] = {
    val promise = Promise[T]()
    ec.execute(() => {
      try {
        Thread.sleep(delay.toMillis)
        block.onComplete(promise.complete)
      } catch {
        case e: InterruptedException => promise.failure(e)
      }
    })
    promise.future
  }
}
