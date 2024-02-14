package algoliasearch.config

/** Represents an Algolia host.
  *
  * @param url
  *   Host url
  * @param callTypes
  *   Whether this host should be used for read and/or write requests.
  * @param scheme
  *   Host protocol (i.e. `http`, `https`)
  * @param port
  *   Host port
  */
case class Host(url: String, callTypes: Set[CallType], scheme: String = "https", port: Option[Int] = None)
