# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

require 'date'
require 'time'

module Algolia
  class MatchLevel
    NONE = "none".freeze
    PARTIAL = "partial".freeze
    FULL = "full".freeze

    def self.all_vars
      @all_vars ||= [NONE, PARTIAL, FULL].freeze
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
      return value if MatchLevel.all_vars.include?(value)
      raise "Invalid ENUM value #{value} for class #MatchLevel"
    end
  end
end
