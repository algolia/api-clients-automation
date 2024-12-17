require 'dotenv'
require 'algolia'

Dotenv.load('../.env')

client = Algolia::SearchClient.create(ENV['ALGOLIA_APPLICATION_ID'], ENV['ALGOLIA_ADMIN_KEY'])
# set a custom user agent
client.add_user_agent_segment('Algolia for rails', "test")
res = client.browse_objects('qigbuery-RECORDS', {})
puts res

=begin
key = client.add_api_key(Algolia::Search::ApiKey.new(acl: ['search'], description: 'this is a test'))
puts key

created = client.wait_for_api_key('add', key.key)
puts created

new_key = Algolia::Search::ApiKey.new(description: 'this is another test')
updated = client.update_api_key(key.key, new_key)
puts updated

aa = client.wait_for_api_key('update', key.key, new_key)
puts aa

deleted = client.delete_api_key(key.key)
puts deleted

waitfor = client.wait_for_api_key('delete', key.key)
puts waitfor
=end
