require "uri"
require "algolia"

# Fetch sample dataset
uri = URI("https://dashboard.algolia.com/sample_datasets/movie.json")
response = Net::HTTP.get_response(uri)
movies = JSON.parse(response.body)

# Connect and authenticate with your Algolia app
client = Algolia::SearchClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

# Save records in Algolia index
client.save_objects("<YOUR_INDEX_NAME>", movies)

puts("Done!")
