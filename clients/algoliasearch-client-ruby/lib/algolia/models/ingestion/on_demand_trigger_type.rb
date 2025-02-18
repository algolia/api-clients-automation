# frozen_string_literal: true

# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

require "date"
require "time"

module Algolia
  module Ingestion
    class OnDemandTriggerType
      ON_DEMAND = "onDemand".freeze

      def self.all_vars
        @all_vars ||= [ON_DEMAND].freeze
      end

      # Builds the enum from string
      # @param [String] The enum value in the form of the string
      # @return [String] The enum value
      def self.build_from_hash(value)
        new.build_from_hash(value)
      end

      # Builds the enum from string
      # @param [String] The enum value in the form of the string
      # @return [String] The enum value
      def build_from_hash(value)
        return value if OnDemandTriggerType.all_vars.include?(value)
        raise "Invalid ENUM value #{value} for class #OnDemandTriggerType"
      end
    end
  end
end
