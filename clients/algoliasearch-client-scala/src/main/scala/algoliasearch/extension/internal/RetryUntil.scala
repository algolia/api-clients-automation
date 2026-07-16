package algoliasearch.extension.internal

import algoliasearch.exception.AlgoliaWaitException

import scala.concurrent.duration._
import scala.concurrent.{ExecutionContext, Future, Promise}

private[algoliasearch] object RetryUntil {

  val DEFAULT_DELAY: Long => Long = (retries: Long) => Math.min(retries * 200, 5000)

  /** Retry a function until a condition is met.
    */
  def retryUntil[T](
      retry: () => Future[T],
      until: T => Boolean,
      maxRetries: Int,
      delay: Long => Long = DEFAULT_DELAY
  )(implicit ec: ExecutionContext): Future[T] = {

    def attempt(retryCount: Int): Future[T] = {
      if (retryCount >= maxRetries) {
        Future.failed(
          AlgoliaWaitException(
            s"Stopped waiting for the task after $maxRetries retries. This does not mean the operation failed; it may still complete. If you need to keep polling, retry with a higher maxRetries."
          )
        )
      } else {
        retry().flatMap { result =>
          if (until(result)) {
            Future.successful(result)
          } else {
            val nextDelay = delay(retryCount)
            after(nextDelay)(attempt(retryCount + 1))
          }
        }
      }
    }

    attempt(0)
  }

  private def after[T](delay: Long)(block: => Future[T])(implicit ec: ExecutionContext): Future[T] = {
    val promise = Promise[T]()
    ec.execute(() => {
      try {
        Thread.sleep(delay)
        block.onComplete(promise.complete)
      } catch {
        case e: InterruptedException => promise.failure(e)
      }
    })
    promise.future
  }
}
