require 'dotenv'
require 'algolia'

Dotenv.load('../.env')

client = Algolia::AgentStudioClient.create(ENV['ALGOLIA_APPLICATION_ID'], ENV['ALGOLIA_ADMIN_KEY'], 'us')

response = client.list_agents
puts 'List of agents:'
response.agents.each do |agent|
  puts "- #{agent.name} (ID: #{agent.id})"
end
