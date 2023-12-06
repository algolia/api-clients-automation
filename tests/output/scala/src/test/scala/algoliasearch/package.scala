import algoliasearch.exception.AlgoliaClientException
import org.scalatest.Assertions.intercept

import scala.annotation.targetName
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContextExecutor, Future}
import scala.util.{Failure, Success}

package object algoliasearch {

  def assertError(message: String)(call: => Unit)(implicit ec: ExecutionContextExecutor): Unit = {
    val error = intercept[Exception](call)
    assert(error.getMessage == message)
  }

  @targetName("assertErrorFuture")
  def assertError(message: String)(call: => Future[_])(implicit ec: ExecutionContextExecutor): Unit = {
    Await.ready(call, Duration.Inf).value.get match {
      case Failure(exception) => assert(exception.getMessage == message, "Error message does not match")
      case Success(_)         => assert(false, "Future should have failed")
    }
  }
}
