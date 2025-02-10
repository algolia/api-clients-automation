require "json"
require "algolia"

begin
  client = Algolia::SearchClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  records = JSON.parse(File.read("records.json"))
  chunk_size = 10000

  (0...records.length).step(chunk_size) do |begin_index|
    chunk = records[begin_index, chunk_size]
    client.save_objects("<YOUR_INDEX_NAME>", chunk)
  end

rescue Exception => e
  puts("An error occurred: #{e}")
end
