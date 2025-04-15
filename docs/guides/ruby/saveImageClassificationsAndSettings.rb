require "algolia"

def get_image_labels(image_url, object_id, score_limit)
  # Implement your image classification logic here
  {"objectID" => "", "imageURL" => "", "objects" => []}
end

client = Algolia::SearchClient.create("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

records = []

client.browse_objects(
  "<YOUR_INDEX_NAME>"
) do |resp|
  resp.hits.each do |hit|
    image_url = hit["imageURL"]
    records << get_image_labels(image_url, hit["objectID"], 0.5)
  end
end

client.partial_update_objects("<YOUR_INDEX_NAME>", records, true)

facets = []
attributes = []

records.each do |record|
  record["objects"].each do |obj|
    obj.each do |key, values|
      if values.is_a?(Array)
        facets.push(
          "searchable(objects.#{key}.label)",
          "searchable(objects.#{key}.score)"
        )
        attributes << "objects.#{key}.label)"
      end
    end
  end
end

current_settings = client.get_settings("<YOUR_INDEX_NAME>")

settings = Algolia::Search::IndexSettings.new(
  searchable_attributes: (current_settings.searchable_attributes || []) + attributes,
  attributes_for_faceting: (current_settings.attributes_for_faceting || []) + facets
)

client.set_settings("<YOUR_INDEX_NAME>", settings)
