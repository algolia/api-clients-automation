# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.
require "algolia"
require "test/unit"
require "dotenv"

require_relative "../helpers"

Dotenv.load("../../.env")

class TestInsightsClientE2E < Test::Unit::TestCase
  def setup
    @client = Algolia::InsightsClient.create(
      ENV.fetch("ALGOLIA_APPLICATION_ID", nil),
      ENV.fetch("ALGOLIA_ADMIN_KEY", nil),
      "us"
    )
  end

  # Many events type
  def test_push_events1
    res = @client.push_events_with_http_info(
      Algolia::Insights::InsightsEvents.new(
        events: [
          Algolia::Insights::ConvertedObjectIDsAfterSearch.new(
            event_type: "conversion",
            event_name: "Product Purchased",
            index: "products",
            user_token: "user-123456",
            authenticated_user_token: "user-123456",
            timestamp: 1740268800000,
            object_ids: ["9780545139700", "9780439784542"],
            query_id: "43b15df305339e827f0ac0bdc5ebcaa7"
          ),
          Algolia::Insights::ViewedObjectIDs.new(
            event_type: "view",
            event_name: "Product Detail Page Viewed",
            index: "products",
            user_token: "user-123456",
            authenticated_user_token: "user-123456",
            timestamp: 1740268800000,
            object_ids: ["9780545139700", "9780439784542"]
          )
        ]
      )
    )

    assert_equal(res.status, 200)
    res = @client.push_events(
      Algolia::Insights::InsightsEvents.new(
        events: [
          Algolia::Insights::ConvertedObjectIDsAfterSearch.new(
            event_type: "conversion",
            event_name: "Product Purchased",
            index: "products",
            user_token: "user-123456",
            authenticated_user_token: "user-123456",
            timestamp: 1740268800000,
            object_ids: ["9780545139700", "9780439784542"],
            query_id: "43b15df305339e827f0ac0bdc5ebcaa7"
          ),
          Algolia::Insights::ViewedObjectIDs.new(
            event_type: "view",
            event_name: "Product Detail Page Viewed",
            index: "products",
            user_token: "user-123456",
            authenticated_user_token: "user-123456",
            timestamp: 1740268800000,
            object_ids: ["9780545139700", "9780439784542"]
          )
        ]
      )
    )
    expected_body = JSON.parse("{\"message\":\"OK\",\"status\":200}")
    assert_equal(expected_body, union(expected_body, JSON.parse(res.to_json)))
  end

end
