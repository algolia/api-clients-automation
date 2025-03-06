require "json"
require "algolia"

records = JSON.parse(File.read("records.json"))

# use the region matching your applicationID
client = Algolia::IngestionClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

# setting `watch` to `true` will make the call synchronous
resp = client.push_task(
  "YOUR_TASK_ID",
  Algolia::Ingestion::PushTaskPayload.new(action: "addObject", records: records),
  true
)

puts(resp)
