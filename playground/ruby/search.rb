require 'dotenv'
require 'algolia'

Dotenv.load('../.env')

client = Algolia::SearchClient.create(ENV['ALGOLIA_APPLICATION_ID'], ENV['ALGOLIA_ADMIN_KEY'])
res = client.search_single_index('contacts', Algolia::Search::SearchParamsObject.new(query: 'Jimmie'))
puts res
