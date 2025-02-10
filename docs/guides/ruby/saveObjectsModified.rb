require "json"
require "algolia"

begin
  client = Algolia::SearchClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

  products = JSON.parse(File.read("products.json"))

  records = []

  products.each do |product|
    reference = product["product_reference"]
    suffixes = []

    while reference.length > 1
      reference = reference[1..-1]
      suffixes << reference
    end

    product["product_reference_suffixes"] = suffixes
    records << product
  end

  client.save_objects("<YOUR_INDEX_NAME>", records)
rescue Exception => e
  puts("An error occurred: #{e}")
end
