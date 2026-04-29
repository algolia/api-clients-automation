# frozen_string_literal: true

require "algolia"
require "stringio"
require "test/unit"

class TestTransformationOptions < Test::Unit::TestCase
  # SearchClient.with_transformation builds ingestion transporter eagerly
  def test_with_transformation_builds_ingestion_transporter
    client = Algolia::SearchClient.with_transformation(
      "test-app-id",
      "test-api-key",
      Algolia::TransformationOptions.new("us")
    )

    assert_not_nil(client.instance_variable_get(:@ingestion_transporter))
  end

  # SearchClient without transformation_options has no ingestion transporter
  def test_no_ingestion_transporter_by_default
    client = Algolia::SearchClient.create("test-app-id", "test-api-key")

    assert_nil(client.instance_variable_get(:@ingestion_transporter))
  end

  # set_transformation_options replaces the ingestion transporter
  def test_set_transformation_options_replaces_transporter
    client = Algolia::SearchClient.with_transformation(
      "test-app-id",
      "test-api-key",
      Algolia::TransformationOptions.new("us")
    )

    previous = client.instance_variable_get(:@ingestion_transporter)
    assert_not_nil(previous)

    client.set_transformation_options(Algolia::TransformationOptions.new("eu"))

    current = client.instance_variable_get(:@ingestion_transporter)
    assert_not_nil(current)
    assert_not_equal(previous.object_id, current.object_id)
  end

  # set_transformation_options works when no previous transporter existed
  def test_set_transformation_options_without_previous
    client = Algolia::SearchClient.create("test-app-id", "test-api-key")

    assert_nil(client.instance_variable_get(:@ingestion_transporter))

    client.set_transformation_options(Algolia::TransformationOptions.new("us"))

    assert_not_nil(client.instance_variable_get(:@ingestion_transporter))
  end

  # set_transformation_region is deprecated but delegates correctly
  def test_set_transformation_region_deprecated_delegate
    client = Algolia::SearchClient.create("test-app-id", "test-api-key")

    assert_nil(client.instance_variable_get(:@ingestion_transporter))

    stderr_output = StringIO.new
    old_stderr = $stderr
    $stderr = stderr_output
    begin
      client.set_transformation_region("us")
    ensure
      $stderr = old_stderr
    end

    assert_not_nil(client.instance_variable_get(:@ingestion_transporter))
    assert_match(/deprecated/i, stderr_output.string)
  end

  # TransformationOptions raises when region is missing
  def test_transformation_options_requires_region
    assert_raise(ArgumentError) do
      Algolia::TransformationOptions.new("")
    end

    assert_raise(ArgumentError) do
      Algolia::TransformationOptions.new(nil)
    end
  end

  # TransformationOptions accepts optional ClientOptions
  def test_transformation_options_with_client_options
    co = Algolia::ClientOptions.new(read_timeout: 50_000)
    opts = Algolia::TransformationOptions.new("us", co)

    assert_equal("us", opts.region)
    assert_equal(50_000, opts.client_options.read_timeout)
  end

  # save_objects_with_transformation raises when no transformation_options set
  def test_save_objects_with_transformation_raises_without_options
    client = Algolia::SearchClient.create("test-app-id", "test-api-key")

    assert_raise(ArgumentError) do
      client.save_objects_with_transformation("my-index", [{"objectID" => "1"}])
    end
  end

  # partial_update_objects_with_transformation raises when no transformation_options set
  def test_partial_update_objects_with_transformation_raises_without_options
    client = Algolia::SearchClient.create("test-app-id", "test-api-key")

    assert_raise(ArgumentError) do
      client.partial_update_objects_with_transformation("my-index", [{"objectID" => "1"}])
    end
  end

  # replace_all_objects_with_transformation raises when no transformation_options set
  def test_replace_all_objects_with_transformation_raises_without_options
    client = Algolia::SearchClient.create("test-app-id", "test-api-key")

    assert_raise(ArgumentError) do
      client.replace_all_objects_with_transformation("my-index", [{"objectID" => "1"}])
    end
  end
end
