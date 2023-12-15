require 'dotenv'
require 'algolia'

Dotenv.load('../.env')

client = Algolia::SearchClient.create(ENV['ALGOLIA_APPLICATION_ID'], ENV['ALGOLIA_ADMIN_KEY'])
res = client.search_single_index('actors', {:search_params => Algolia::Search::SearchParamsObject.new(query: 'john')})
puts res
