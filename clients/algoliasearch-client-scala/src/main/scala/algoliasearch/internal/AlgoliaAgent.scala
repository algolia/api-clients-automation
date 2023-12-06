package algoliasearch.internal

import algoliasearch.config.AgentSegment

import scala.collection.mutable

/** Handles Algolia agent segments.
  *
  * An instance of this class maintains a set of [AgentSegment]s, and provides methods to add, remove, and format these
  * segments.
  *
  * @param clientVersion
  *   client version
  */
class AlgoliaAgent(clientVersion: String) {
  private val segs = mutable.LinkedHashSet[AgentSegment](
    AgentSegment("Algolia for scala", clientVersion),
    AgentSegment("JVM", System.getProperty("java.version"))
  )

  /** Adds a new segment to the agent segments. */
  def addSegment(seg: AgentSegment): AlgoliaAgent = {
    if (!segs.contains(seg)) {
      segs += seg
    }
    this
  }

  /** Adds all segments to the agent segments */
  def addSegments(segments: Seq[AgentSegment]): AlgoliaAgent = {
    segs.addAll(segments)
    this
  }

  override def toString: String = {
    segs.mkString("; ")
  }
}

object AlgoliaAgent {

  /** Creates a new AlgoliaAgent instance with the given client version. */
  def apply(clientVersion: String): AlgoliaAgent =
    new AlgoliaAgent(clientVersion)
}
