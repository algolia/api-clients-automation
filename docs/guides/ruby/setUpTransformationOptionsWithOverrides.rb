require "algolia"

# Override the Ingestion API defaults. Any option you don't set keeps its default.
# Replace 'us' with 'eu' if your Algolia application uses the Europe analytics region.
client = Algolia::SearchClient.with_transformation(
  "ALGOLIA_APPLICATION_ID",
  "ALGOLIA_API_KEY",
  Algolia::TransformationOptions.new("us", connect_timeout: 5000, read_timeout: 30000)
)

# Save records, transforming them through the Push connector
client.save_objects_with_transformation(
  "<YOUR_INDEX_NAME>",
  [{objectID: "1", name: "Adam"}, {objectID: "2", name: "Benoit"}],
  true
)

puts("Done!")
