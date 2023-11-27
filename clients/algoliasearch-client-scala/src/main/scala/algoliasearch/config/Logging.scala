package algoliasearch.config

/** Logger configuration.
  *
  * @param level
  *   Log level.
  * @param logger
  *   Logger.
  */
case class Logging(
    level: LogLevel,
    logger: Logger
)

object Logging {

  /** Default logging.
    */
  val Default: Logging = Logging(logger = Logger.Default, level = LogLevel.Basic)

  /** Full logging.
    */
  val Full: Logging = Logging(logger = Logger.Default, level = LogLevel.Body)
}

/** Logger interface.
  */
trait Logger {

  /** Log a message.
    *
    * @param message
    *   Message to log.
    */
  def log(message: String): Unit
}

object Logger {

  /** Default logger.
    *
    * Important: OkHttp will use the platform's default logger instead of println.
    */
  val Default: Logger = (message: String) => println(message)
}

/** Log level used for HTTP requests.
  */
sealed trait LogLevel

/** Companion object of [[LogLevel]].
  */
object LogLevel {

  /** No logs. */
  case object None extends LogLevel

  /** Logs request and response lines and their respective headers. */
  case object Headers extends LogLevel

  /** Logs request and response lines and their respective headers and bodies (if present).
    */
  case object Body extends LogLevel

  /** Logs request and response lines. */
  case object Basic extends LogLevel
}
