package algoliasearch.config

/** Indicate whether the HTTP call performed is of type read (GET) or write (POST, PUT ..). Used to determine which
  * timeout duration to use.
  */
sealed trait CallType

/** Companion object of [[CallType]].
  */
object CallType {

  /** Read call type. */
  case object Read extends CallType

  /** Write call type. */
  case object Write extends CallType
}
