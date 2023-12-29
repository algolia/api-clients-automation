require 'dotenv'
require 'algolia'

Dotenv.load('../.env')

client = Algolia::IngestionClient.create(ENV['ALGOLIA_APPLICATION_ID'], ENV['ALGOLIA_ADMIN_KEY'], 'us')

res, status, headers = client.get_authentications_with_http_info(50)
puts res
puts status
puts headers
#res = client.get_tasks()
#puts res.tasks[0]
#res = client.get_task(res.tasks[1].task_id)
#puts res

#res = client.update_task(res.task_id, Algolia::Ingestion::TaskUpdate.new(enabled: false))
#puts res

#res = client.delete_task(res.task_id)
#puts res
