# frozen_string_literal: true

# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

require "date"
require "time"

module Algolia
  module Ingestion
    class SourceSortKeys
      NAME = "name".freeze
      TYPE = "type".freeze
      UPDATED_AT = "updatedAt".freeze
      CREATED_AT = "createdAt".freeze

      def self.all_vars
        @all_vars ||= [NAME, TYPE, UPDATED_AT, CREATED_AT].freeze
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
        return value if SourceSortKeys.all_vars.include?(value)
        raise "Invalid ENUM value #{value} for class #SourceSortKeys"
      end
    end
  end
end
