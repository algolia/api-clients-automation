require "algolia"

def get_app_id_for(_user)
  # Implement your own logic here
  ""
end

def get_indexing_api_key_for(_user)
  # Implement your own logic here
  ""
end

# Your records
playlists = []

playlists.each do |playlist|
  begin
    app_id = get_app_id_for(playlist["user"])
    api_key = get_indexing_api_key_for(playlist["user"])

    client = Algolia::SearchClient.create(app_id, api_key)

    settings = Algolia::Search::IndexSettings.new(
      attributes_for_faceting: ["filterOnly(user)"]
    )
    client.set_settings("<YOUR_INDEX_NAME>", settings)

    client.save_objects("<YOUR_INDEX_NAME>", playlists)
  rescue Exception => e
    puts("An error occurred: #{e}")
  end
end
