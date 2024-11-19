require "json"
require "algolia"

records = JSON.parse(File.read("/my-raw-records.json"))

# use the region matching your applicationID
client = Algolia::IngestionClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION")

run = client.push_task("YOUR_TASK_ID", Algolia::Ingestion::PushTaskPayload.new(action: "addObject", records: records))

# use runID in the Observability debugger
puts(run.run_id)
