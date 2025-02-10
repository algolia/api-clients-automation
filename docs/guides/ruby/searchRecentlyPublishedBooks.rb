import(time)

require "algolia"

begin
  client = Algolia::SearchClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # Get current timestamp
  date_timestamp = Time.now.to_i
  search_params = Algolia::Search::SearchParamsObject.new(
    query: "<YOUR_SEARCH_QUERY>",
    filters: "date_timestamp > #{date_timestamp}"
  )

  client.search_single_index("<YOUR_INDEX_NAME>", search_params)
rescue Exception => e
  puts("An error occurred: #{e}")
end
