require "algolia"

def get_user_token
  # Implement your logic here
  ""
end

client = Algolia::SearchClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

# Set the searchParams and get the current user token
search_params = Algolia::Search::SearchParamsObject.new(
  query: "User search query",
  enable_ab_test: true
)
user_token = get_user_token

# Is the user token anonymous?
if user_token.nil? || user_token.empty? || user_token == "YOUR_ANONYMOUS_USER_TOKEN"
  # Disable A/B testing for this request
  search_params.enable_ab_test = false
else
  # Set the user token to the current user token
  search_params.user_token = user_token
end

begin
  # Perform the searchSingleIndex
  result = client.search_single_index("<YOUR_INDEX_NAME>", search_params)
  # SearchSingleIndex results
  puts(result)
rescue => err
  # SearchSingleIndex errors
  puts(err)
end
