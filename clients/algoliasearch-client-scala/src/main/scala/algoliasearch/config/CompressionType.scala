package algoliasearch.config

/** Compression type used for HTTP requests.
  */
sealed trait CompressionType

/** Companion object of [[CompressionType]].
  */
object CompressionType {

  /** No compression.
    */
  case object None extends CompressionType

  /** Gzip compression.
    */
  case object Gzip extends CompressionType
}
