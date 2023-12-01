# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

require 'date'
require 'time'

module Algolia
  class Action
    ADD_OBJECT = "addObject".freeze
    UPDATE_OBJECT = "updateObject".freeze
    PARTIAL_UPDATE_OBJECT = "partialUpdateObject".freeze
    PARTIAL_UPDATE_OBJECT_NO_CREATE = "partialUpdateObjectNoCreate".freeze
    DELETE_OBJECT = "deleteObject".freeze
    DELETE = "delete".freeze
    CLEAR = "clear".freeze

    def self.all_vars
      @all_vars ||= [ADD_OBJECT, UPDATE_OBJECT, PARTIAL_UPDATE_OBJECT, PARTIAL_UPDATE_OBJECT_NO_CREATE, DELETE_OBJECT, DELETE, CLEAR].freeze
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
      return value if Action.all_vars.include?(value)
      raise "Invalid ENUM value #{value} for class #Action"
    end
  end
end
