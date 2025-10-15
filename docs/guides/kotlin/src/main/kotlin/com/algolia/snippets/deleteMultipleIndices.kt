import com.algolia.client.api.SearchClient
import com.algolia.client.configuration.*
import com.algolia.client.extensions.*
import com.algolia.client.model.search.*
import com.algolia.client.transport.*

suspend fun deleteMultipleIndices() {
  // You need an API key with `deleteIndex`
  val client = SearchClient(appId = "ALGOLIA_APPLICATION_ID", apiKey = "ALGOLIA_API_KEY")

  // List all indices
  val indices = client.listIndices()

  // Primary indices don't have a `primary` key
  val primaryIndices = indices.items.filter { it.primary == null }
  val replicaIndices = indices.items.filter { it.primary != null }

  // Delete primary indices first
  if (primaryIndices.isNotEmpty()) {
    val requests =
      primaryIndices.map { MultipleBatchRequest(action = Action.Delete, indexName = it.name) }
    client.multipleBatch(batchParams = BatchParams(requests = requests))
    println("Deleted primary indices.")
  }

  // Now, delete replica indices
  if (replicaIndices.isNotEmpty()) {
    val requests =
      replicaIndices.map { MultipleBatchRequest(action = Action.Delete, indexName = it.name) }
    client.multipleBatch(batchParams = BatchParams(requests = requests))
    println("Deleted replica indices.")
  }
}
