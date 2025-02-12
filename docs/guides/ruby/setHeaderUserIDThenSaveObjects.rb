require "algolia"

# Your records
playlists = []

client = Algolia::SearchClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

playlists.each do |playlist|
  playlist_user_id = playlist["userID"]
  client.save_objects(
    "<YOUR_INDEX_NAME>",
    playlists,
    false,
    1000,
    {:header_params => {"X-Algolia-User-ID" => playlist_user_id}}
  )
end
