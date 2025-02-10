require "algolia"

def get_google_analytics_user_id_from_browser_cookie(_cookie_name)
  # Implement your logic here
  ""
end

begin
  client = Algolia::SearchClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  user_token = get_google_analytics_user_id_from_browser_cookie("_ga")
  search_params = Algolia::Search::SearchParamsObject.new(
    query: "<YOUR_SEARCH_QUERY>",
    userToken: user_token
  )

  client.search_single_index("<YOUR_INDEX_NAME>", search_params)

  logged_in_user = nil
  search_params.user_token = logged_in_user || user_token

  client.search_single_index("<YOUR_INDEX_NAME>", search_params)
rescue Exception => e
  puts("An error occurred: #{e}")
end
