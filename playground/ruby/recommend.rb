require 'dotenv'
require 'algolia'

Dotenv.load('../.env')

client = Algolia::RecommendClient.create(ENV['ALGOLIA_APPLICATION_ID'], ENV['ALGOLIA_ADMIN_KEY'])

res = client.get_recommendations(Algolia::Recommend::GetRecommendationsParams.new(
  requests: [
    Algolia::Recommend::RelatedQuery.new(
      index_name: "cts_e2e_browse",
      object_id: "Batman Dracula",
      model: "related-products",
      threshold: 0,
    )
  ]
))

puts res
