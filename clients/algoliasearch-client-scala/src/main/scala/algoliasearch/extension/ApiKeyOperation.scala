package algoliasearch.extension

sealed trait ApiKeyOperation

object ApiKeyOperation {
  case object Create extends ApiKeyOperation
  case object Update extends ApiKeyOperation
  case object Delete extends ApiKeyOperation
}
