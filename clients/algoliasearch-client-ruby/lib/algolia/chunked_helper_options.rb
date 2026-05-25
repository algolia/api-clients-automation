# frozen_string_literal: true

module Algolia
  # Optional configuration for chunked helpers that batch records and poll for task completion.
  #
  # Designed to grow over time; future shared helper config (e.g. timeout, batch size defaults)
  # should be added here instead of widening every helper's parameter list.
  class ChunkedHelperOptions
    DEFAULT_MAX_RETRIES = 100

    attr_reader :max_retries

    def initialize(max_retries: nil)
      @max_retries = max_retries
    end
  end
end
