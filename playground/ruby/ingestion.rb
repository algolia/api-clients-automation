require 'dotenv'
require 'algolia'

Dotenv.load('../.env')

client = Algolia::IngestionClient.create(ENV['ALGOLIA_APPLICATION_ID'], ENV['ALGOLIA_ADMIN_KEY'], 'us')
res = client.get_tasks()
puts res
