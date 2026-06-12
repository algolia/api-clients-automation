require "algolia"

# Set transformation options with your transformation region to use the `*_with_transformation` helper methods.
# Replace 'us' with 'eu' if your Algolia application uses the Europe analytics region.
client = Algolia::SearchClient.with_transformation(
  "ALGOLIA_APPLICATION_ID",
  "ALGOLIA_API_KEY",
  Algolia::TransformationOptions.new("us")
)

# Save records, transforming them through the Push connector
client.save_objects_with_transformation(
  "<YOUR_INDEX_NAME>",
  [{objectID: "1", name: "Adam"}, {objectID: "2", name: "Benoit"}],
  true
)

puts("Done!")
