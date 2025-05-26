require "algolia"

def get_all_app_id_configurations
  # A list of your MCM AppID/ApiKey pairs
  []
end

# Your records
playlists = []

# Fetch from your own data storage and with your own code
# the list of application IDs and API keys to target each cluster
configurations = get_all_app_id_configurations

# Send the records to each cluster
configurations.each do |appID, apiKey|
  begin
    client = Algolia::SearchClient.create(appID, apiKey)
    client.save_objects("<YOUR_INDEX_NAME>", playlists)
  rescue Exception => e
    puts("An error occurred: #{e}")
  end
end
