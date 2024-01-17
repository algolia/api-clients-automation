# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

require 'date'
require 'time'

module Algolia
  module Abtesting
    class Variant
      # Number of add-to-cart events for this variant.
      attr_accessor :add_to_cart_count

      # Variant's [add-to-cart rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#add-to-cart-rate).
      attr_accessor :add_to_cart_rate

      # Variant's [average click position](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-position).
      attr_accessor :average_click_position

      # Number of click events for this variant.
      attr_accessor :click_count

      # Variant's [click-through rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#click-through-rate).
      attr_accessor :click_through_rate

      # Number of click events for this variant.
      attr_accessor :conversion_count

      # Variant's [conversion rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#conversion-rate).
      attr_accessor :conversion_rate

      # A/B test currencies.
      attr_accessor :currencies

      # A/B test description.
      attr_accessor :description

      attr_accessor :filter_effects

      # A/B test index.
      attr_accessor :index

      # Number of [searches without results](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#searches-without-results) for that variant.
      attr_accessor :no_result_count

      # Number of purchase events for this variant.
      attr_accessor :purchase_count

      # Variant's [purchase rate](https://www.algolia.com/doc/guides/search-analytics/concepts/metrics/#purchase-rate).
      attr_accessor :purchase_rate

      # Number of searches carried out during the A/B test.
      attr_accessor :search_count

      # Number of tracked searches. This is the number of search requests where the `clickAnalytics` parameter is `true`.
      attr_accessor :tracked_search_count

      # A/B test traffic percentage.
      attr_accessor :traffic_percentage

      # Number of users during the A/B test.
      attr_accessor :user_count

      # Attribute mapping from ruby-style variable name to JSON key.
      def self.attribute_map
        {
          :add_to_cart_count => :addToCartCount,
          :add_to_cart_rate => :addToCartRate,
          :average_click_position => :averageClickPosition,
          :click_count => :clickCount,
          :click_through_rate => :clickThroughRate,
          :conversion_count => :conversionCount,
          :conversion_rate => :conversionRate,
          :currencies => :currencies,
          :description => :description,
          :filter_effects => :filterEffects,
          :index => :index,
          :no_result_count => :noResultCount,
          :purchase_count => :purchaseCount,
          :purchase_rate => :purchaseRate,
          :search_count => :searchCount,
          :tracked_search_count => :trackedSearchCount,
          :traffic_percentage => :trafficPercentage,
          :user_count => :userCount
        }
      end

      # Returns all the JSON keys this model knows about
      def self.acceptable_attributes
        attribute_map.values
      end

      # Attribute type mapping.
      def self.types_mapping
        {
          :add_to_cart_count => :Integer,
          :add_to_cart_rate => :Float,
          :average_click_position => :Integer,
          :click_count => :Integer,
          :click_through_rate => :Float,
          :conversion_count => :Integer,
          :conversion_rate => :Float,
          :currencies => :'Hash<String, CurrenciesValue>',
          :description => :String,
          :filter_effects => :FilterEffects,
          :index => :String,
          :no_result_count => :Integer,
          :purchase_count => :Integer,
          :purchase_rate => :Float,
          :search_count => :Integer,
          :tracked_search_count => :Integer,
          :traffic_percentage => :Integer,
          :user_count => :Integer
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
          raise ArgumentError, "The input argument (attributes) must be a hash in `Algolia::Variant` initialize method"
        end

        # check to see if the attribute exists and convert string to symbol for hash key
        attributes = attributes.each_with_object({}) do |(k, v), h|
          unless self.class.attribute_map.key?(k.to_sym)
            raise ArgumentError,
                  "`#{k}` is not a valid attribute in `Algolia::Variant`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
          end

          h[k.to_sym] = v
        end

        if attributes.key?(:add_to_cart_count)
          self.add_to_cart_count = attributes[:add_to_cart_count]
        else
          self.add_to_cart_count = nil
        end

        if attributes.key?(:add_to_cart_rate)
          self.add_to_cart_rate = attributes[:add_to_cart_rate]
        else
          self.add_to_cart_rate = nil
        end

        if attributes.key?(:average_click_position)
          self.average_click_position = attributes[:average_click_position]
        else
          self.average_click_position = nil
        end

        if attributes.key?(:click_count)
          self.click_count = attributes[:click_count]
        else
          self.click_count = nil
        end

        if attributes.key?(:click_through_rate)
          self.click_through_rate = attributes[:click_through_rate]
        else
          self.click_through_rate = nil
        end

        if attributes.key?(:conversion_count)
          self.conversion_count = attributes[:conversion_count]
        else
          self.conversion_count = nil
        end

        if attributes.key?(:conversion_rate)
          self.conversion_rate = attributes[:conversion_rate]
        else
          self.conversion_rate = nil
        end

        if attributes.key?(:currencies)
          if (value = attributes[:currencies]).is_a?(Hash)
            self.currencies = value
          end
        else
          self.currencies = nil
        end

        if attributes.key?(:description)
          self.description = attributes[:description]
        else
          self.description = nil
        end

        if attributes.key?(:filter_effects)
          self.filter_effects = attributes[:filter_effects]
        end

        if attributes.key?(:index)
          self.index = attributes[:index]
        else
          self.index = nil
        end

        if attributes.key?(:no_result_count)
          self.no_result_count = attributes[:no_result_count]
        else
          self.no_result_count = nil
        end

        if attributes.key?(:purchase_count)
          self.purchase_count = attributes[:purchase_count]
        else
          self.purchase_count = nil
        end

        if attributes.key?(:purchase_rate)
          self.purchase_rate = attributes[:purchase_rate]
        else
          self.purchase_rate = nil
        end

        if attributes.key?(:search_count)
          self.search_count = attributes[:search_count]
        else
          self.search_count = nil
        end

        if attributes.key?(:tracked_search_count)
          self.tracked_search_count = attributes[:tracked_search_count]
        else
          self.tracked_search_count = nil
        end

        if attributes.key?(:traffic_percentage)
          self.traffic_percentage = attributes[:traffic_percentage]
        else
          self.traffic_percentage = nil
        end

        if attributes.key?(:user_count)
          self.user_count = attributes[:user_count]
        else
          self.user_count = nil
        end
      end

      # Checks equality by comparing each attribute.
      # @param [Object] Object to be compared
      def ==(other)
        return true if equal?(other)

        self.class == other.class &&
          add_to_cart_count == other.add_to_cart_count &&
          add_to_cart_rate == other.add_to_cart_rate &&
          average_click_position == other.average_click_position &&
          click_count == other.click_count &&
          click_through_rate == other.click_through_rate &&
          conversion_count == other.conversion_count &&
          conversion_rate == other.conversion_rate &&
          currencies == other.currencies &&
          description == other.description &&
          filter_effects == other.filter_effects &&
          index == other.index &&
          no_result_count == other.no_result_count &&
          purchase_count == other.purchase_count &&
          purchase_rate == other.purchase_rate &&
          search_count == other.search_count &&
          tracked_search_count == other.tracked_search_count &&
          traffic_percentage == other.traffic_percentage &&
          user_count == other.user_count
      end

      # @see the `==` method
      # @param [Object] Object to be compared
      def eql?(other)
        self == other
      end

      # Calculates hash code according to all attributes.
      # @return [Integer] Hash code
      def hash
        [add_to_cart_count, add_to_cart_rate, average_click_position, click_count, click_through_rate, conversion_count, conversion_rate, currencies, description, filter_effects,
         index, no_result_count, purchase_count, purchase_rate, search_count, tracked_search_count, traffic_percentage, user_count].hash
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
          klass = Algolia::Abtesting.const_get(type)
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
