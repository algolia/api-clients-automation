require "algolia"

def get_platform_tag
  # Implement your logic here
  ""
end

begin
  client = Algolia::SearchClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  # get the buyer account information
  platform_tag = get_platform_tag
  search_params = Algolia::Search::SearchParamsObject.new(
    query: "<YOUR_SEARCH_QUERY>",
    rule_contexts: [platform_tag]
  )

  client.search_single_index("<YOUR_INDEX_NAME>", search_params)
rescue Exception => e
  puts("An error occurred: #{e}")
end
