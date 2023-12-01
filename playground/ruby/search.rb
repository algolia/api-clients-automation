require 'algolia'

client = Algolia::SearchClient.initialize('ALGOLIA_APPLICATION_ID','ALGOLIA_ADMIN_KEY')
res = client.search('')
puts res
