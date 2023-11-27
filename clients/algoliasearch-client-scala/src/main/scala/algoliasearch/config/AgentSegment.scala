package algoliasearch.config

/** Represents a segment of algolia agent header.
  * @param value
  *   segment string value
  * @param version
  *   optional version
  */
case class AgentSegment(value: String, version: Option[String] = None) {
  override def toString: String = version match {
    case Some(ver) => s"$value ($ver)"
    case None      => s"$value"
  }
}

object AgentSegment {

  /** Creates a new AgentSegment instance with the given value and version. */
  def apply(value: String, version: String): AgentSegment = new AgentSegment(value, Some(version))

  /** Creates a new AgentSegment instance with the given value. */
  def apply(value: String): AgentSegment = new AgentSegment(value)
}
