package algoliasearch.internal.interceptor

import algoliasearch.config.{LogLevel, Logger, Logging}
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.{Interceptor, Response}

/** Interceptor that logs HTTP requests and responses.
  *
  * @param logger
  *   Optional logger.
  * @param logLevel
  *   Log level.
  */
private[internal] class LogInterceptor(
    logging: Logging
) extends Interceptor {

  private val httpLogger: HttpLoggingInterceptor = {
    val logr: HttpLoggingInterceptor.Logger = logging.logger match {
      case Logger.Default => HttpLoggingInterceptor.Logger.DEFAULT
      case logger         => (message: String) => logger.log(message)
    }
    val level: HttpLoggingInterceptor.Level = logging.level match {
      case LogLevel.None    => HttpLoggingInterceptor.Level.NONE
      case LogLevel.Body    => HttpLoggingInterceptor.Level.BODY
      case LogLevel.Basic   => HttpLoggingInterceptor.Level.BASIC
      case LogLevel.Headers => HttpLoggingInterceptor.Level.HEADERS
      case _ =>
        throw new UnsupportedOperationException(
          s"Unsupported LogLevel ${logging.level}"
        )
    }
    new HttpLoggingInterceptor(logr).setLevel(level)
  }

  override def intercept(chain: Interceptor.Chain): Response =
    httpLogger.intercept(chain)
}
