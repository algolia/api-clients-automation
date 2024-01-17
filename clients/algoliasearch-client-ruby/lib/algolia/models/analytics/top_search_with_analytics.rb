# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

require 'date'
require 'time'

module Algolia
  module Analytics
    class TopSearchWithAnalytics
      # User query.
      attr_accessor :search

      # Number of tracked _and_ untracked searches (where the `clickAnalytics` parameter isn't `true`).
      attr_accessor :count

      # [Click-through rate (CTR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate).
      attr_accessor :click_through_rate

      # Average [position](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-position) of clicked search result.
      attr_accessor :average_click_position

      # [Conversion rate (CR)](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#conversion-rate).
      attr_accessor :conversion_rate

      # Number of tracked searches. This is the number of search requests where the `clickAnalytics` parameter is `true`.
      attr_accessor :tracked_search_count

      # Number of click events.
      attr_accessor :click_count

      # Number of converted clicks.
      attr_accessor :conversion_count

      # Number of hits the search query matched.
      attr_accessor :nb_hits

      # Attribute mapping from ruby-style variable name to JSON key.
      def self.attribute_map
        {
          :search => :search,
          :count => :count,
          :click_through_rate => :clickThroughRate,
          :average_click_position => :averageClickPosition,
          :conversion_rate => :conversionRate,
          :tracked_search_count => :trackedSearchCount,
          :click_count => :clickCount,
          :conversion_count => :conversionCount,
          :nb_hits => :nbHits
        }
      end

      # Returns all the JSON keys this model knows about
      def self.acceptable_attributes
        attribute_map.values
      end

      # Attribute type mapping.
      def self.types_mapping
        {
          :search => :String,
          :count => :Integer,
          :click_through_rate => :Float,
          :average_click_position => :Integer,
          :conversion_rate => :Float,
          :tracked_search_count => :Integer,
          :click_count => :Integer,
          :conversion_count => :Integer,
          :nb_hits => :Integer
        }
      end

      # List of attributes with nullable: true
      def self.openapi_nullable
        Set.new([])
      end

      # Initializes the object
      # @param [Hash] attributes Model attributes in the form of hash
      def initialize(attributes = {})
        unless attributes.is_a?(Hash)
          raise ArgumentError, "The input argument (attributes) must be a hash in `Algolia::TopSearchWithAnalytics` initialize method"
        end

        # check to see if the attribute exists and convert string to symbol for hash key
        attributes = attributes.each_with_object({}) do |(k, v), h|
          unless self.class.attribute_map.key?(k.to_sym)
            raise ArgumentError,
                  "`#{k}` is not a valid attribute in `Algolia::TopSearchWithAnalytics`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
          end

          h[k.to_sym] = v
        end

        if attributes.key?(:search)
          self.search = attributes[:search]
        else
          self.search = nil
        end

        if attributes.key?(:count)
          self.count = attributes[:count]
        else
          self.count = nil
        end

        if attributes.key?(:click_through_rate)
          self.click_through_rate = attributes[:click_through_rate]
        else
          self.click_through_rate = nil
        end

        if attributes.key?(:average_click_position)
          self.average_click_position = attributes[:average_click_position]
        else
          self.average_click_position = nil
        end

        if attributes.key?(:conversion_rate)
          self.conversion_rate = attributes[:conversion_rate]
        else
          self.conversion_rate = nil
        end

        if attributes.key?(:tracked_search_count)
          self.tracked_search_count = attributes[:tracked_search_count]
        else
          self.tracked_search_count = nil
        end

        if attributes.key?(:click_count)
          self.click_count = attributes[:click_count]
        else
          self.click_count = nil
        end

        if attributes.key?(:conversion_count)
          self.conversion_count = attributes[:conversion_count]
        else
          self.conversion_count = nil
        end

        if attributes.key?(:nb_hits)
          self.nb_hits = attributes[:nb_hits]
        else
          self.nb_hits = nil
        end
      end

      # Custom attribute writer method with validation
      # @param [Object] click_through_rate Value to be assigned
      def click_through_rate=(click_through_rate)
        if click_through_rate.nil?
          raise ArgumentError, 'click_through_rate cannot be nil'
        end

        if click_through_rate > 1
          raise ArgumentError, 'invalid value for "click_through_rate", must be smaller than or equal to 1.'
        end

        if click_through_rate < 0
          raise ArgumentError, 'invalid value for "click_through_rate", must be greater than or equal to 0.'
        end

        @click_through_rate = click_through_rate
      end

      # Checks equality by comparing each attribute.
      # @param [Object] Object to be compared
      def ==(other)
        return true if equal?(other)

        self.class == other.class &&
          search == other.search &&
          count == other.count &&
          click_through_rate == other.click_through_rate &&
          average_click_position == other.average_click_position &&
          conversion_rate == other.conversion_rate &&
          tracked_search_count == other.tracked_search_count &&
          click_count == other.click_count &&
          conversion_count == other.conversion_count &&
          nb_hits == other.nb_hits
      end

      # @see the `==` method
      # @param [Object] Object to be compared
      def eql?(other)
        self == other
      end

      # Calculates hash code according to all attributes.
      # @return [Integer] Hash code
      def hash
        [search, count, click_through_rate, average_click_position, conversion_rate, tracked_search_count, click_count, conversion_count, nb_hits].hash
      end

      # Builds the object from hash
      # @param [Hash] attributes Model attributes in the form of hash
      # @return [Object] Returns the model itself
      def self.build_from_hash(attributes)
        return nil unless attributes.is_a?(Hash)

        attributes = attributes.transform_keys(&:to_sym)
        transformed_hash = {}
        types_mapping.each_pair do |key, type|
          if attributes.key?(attribute_map[key]) && attributes[attribute_map[key]].nil?
            transformed_hash[key.to_sym] = nil
          elsif type =~ /\AArray<(.*)>/i
            # check to ensure the input is an array given that the attribute
            # is documented as an array but the input is not
            if attributes[attribute_map[key]].is_a?(Array)
              transformed_hash[key.to_sym] = attributes[attribute_map[key]].map { |v| _deserialize(::Regexp.last_match(1), v) }
            end
          elsif !attributes[attribute_map[key]].nil?
            transformed_hash[key.to_sym] = _deserialize(type, attributes[attribute_map[key]])
          end
        end
        new(transformed_hash)
      end

      # Deserializes the data based on type
      # @param string type Data type
      # @param string value Value to be deserialized
      # @return [Object] Deserialized data
      def self._deserialize(type, value)
        case type.to_sym
        when :Time
          Time.parse(value)
        when :Date
          Date.parse(value)
        when :String
          value.to_s
        when :Integer
          value.to_i
        when :Float
          value.to_f
        when :Boolean
          if value.to_s =~ /\A(true|t|yes|y|1)\z/i
            true
          else
            false
          end
        when :Object
          # generic object (usually a Hash), return directly
          value
        when /\AArray<(?<inner_type>.+)>\z/
          inner_type = Regexp.last_match[:inner_type]
          value.map { |v| _deserialize(inner_type, v) }
        when /\AHash<(?<k_type>.+?), (?<v_type>.+)>\z/
          k_type = Regexp.last_match[:k_type]
          v_type = Regexp.last_match[:v_type]
          {}.tap do |hash|
            value.each do |k, v|
              hash[_deserialize(k_type, k)] = _deserialize(v_type, v)
            end
          end
        else # model
          # models (e.g. Pet) or oneOf
          klass = Algolia::Analytics.const_get(type)
          klass.respond_to?(:openapi_any_of) || klass.respond_to?(:openapi_one_of) ? klass.build(value) : klass.build_from_hash(value)
        end
      end

      # Returns the string representation of the object
      # @return [String] String presentation of the object
      def to_s
        to_hash.to_s
      end

      # to_body is an alias to to_hash (backward compatibility)
      # @return [Hash] Returns the object in the form of hash
      def to_body
        to_hash
      end

      def to_json(*_args)
        to_hash.to_json
      end

      # Returns the object in the form of hash
      # @return [Hash] Returns the object in the form of hash
      def to_hash
        hash = {}
        self.class.attribute_map.each_pair do |attr, param|
          value = send(attr)
          if value.nil?
            is_nullable = self.class.openapi_nullable.include?(attr)
            next if !is_nullable || (is_nullable && !instance_variable_defined?(:"@#{attr}"))
          end

          hash[param] = _to_hash(value)
        end
        hash
      end

      # Outputs non-array value in the form of hash
      # For object, use to_hash. Otherwise, just return the value
      # @param [Object] value Any valid value
      # @return [Hash] Returns the value in the form of hash
      def _to_hash(value)
        if value.is_a?(Array)
          value.compact.map { |v| _to_hash(v) }
        elsif value.is_a?(Hash)
          {}.tap do |hash|
            value.each { |k, v| hash[k] = _to_hash(v) }
          end
        elsif value.respond_to? :to_hash
          value.to_hash
        else
          value
        end
      end
    end
  end
end
