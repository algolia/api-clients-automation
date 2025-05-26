require "algolia"

def get_buyer_account_id
  # Implement your logic here
  ""
end

client = Algolia::SearchClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

# get the buyer account information
buyer = get_buyer_account_id
search_params = Algolia::Search::SearchParamsObject.new(
  query: "<YOUR_SEARCH_QUERY>",
  rule_contexts: [buyer]
)

client.search_single_index("<YOUR_INDEX_NAME>", search_params)
