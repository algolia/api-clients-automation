require "algolia"

begin
  # You need an API key with `deleteIndex`
  client = Algolia::SearchClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # List all indices
  indices = client.list_indices

  # Primary indices don't have a `primary` key
  primary_indices, replica_indices = indices.items.partition { |index| index.primary.nil? }.map(&:to_a)

  # Delete primary indices first
  if primary_indices.any?
    requests = primary_indices.map { |index|
      Algolia::Search::BatchRequest.new(action: Algolia::Search::Action::DELETE, indexName: index.name)
    }
    client.multiple_batch(Algolia::Search::BatchParams.new(requests: requests))
    print("Deleted primary indices.")
  end

  # Now, delete replica indices
  if replica_indices.any?
    requests = replica_indices.map { |index|
      Algolia::Search::BatchRequest.new(action: Algolia::Search::Action::DELETE, indexName: index.name)
    }
    client.multiple_batch(Algolia::Search::BatchParams.new(requests: requests))
    print("Deleted replica indices.\n")
  end

rescue Exception => e
  puts("An error occurred: #{e}")
end
