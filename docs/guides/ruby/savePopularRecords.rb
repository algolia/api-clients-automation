require "algolia"

begin
  client = Algolia::SearchClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  records = []

  client.browse_objects(
    index_name = "<YOUR_INDEX_NAME>"
  ) do |resp|
    resp.hits.each { |hit|
      record = hit
      record["isPopular"] = hit["nbFollowers"] > 1000000
      records.append(record)
    }
  end

  client.save_objects("<YOUR_INDEX_NAME>", records)
rescue Exception => e
  puts("An error occurred: #{e}")
end
