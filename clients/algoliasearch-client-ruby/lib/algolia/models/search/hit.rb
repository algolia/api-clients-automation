# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

require 'date'
require 'time'

module Algolia
  module Search
    # A single hit.
    class Hit
      # Unique object identifier.
      attr_accessor :object_id

      # Show highlighted section and words matched on a query.
      attr_accessor :_highlight_result

      # Snippeted attributes show parts of the matched attributes. Only returned when attributesToSnippet is non-empty.
      attr_accessor :_snippet_result

      attr_accessor :_ranking_info

      attr_accessor :_distinct_seq_id

      attr_accessor :additional_properties

      # Attribute mapping from ruby-style variable name to JSON key.
      def self.attribute_map
        {
          :object_id => :objectID,
          :_highlight_result => :_highlightResult,
          :_snippet_result => :_snippetResult,
          :_ranking_info => :_rankingInfo,
          :_distinct_seq_id => :_distinctSeqID
        }
      end

      # Returns all the JSON keys this model knows about
      def self.acceptable_attributes
        attribute_map.values
      end

      # Attribute type mapping.
      def self.types_mapping
        {
          :object_id => :String,
          :_highlight_result => :'Hash<String, HighlightResult>',
          :_snippet_result => :'Hash<String, SnippetResult>',
          :_ranking_info => :RankingInfo,
          :_distinct_seq_id => :Integer
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
          raise ArgumentError, "The input argument (attributes) must be a hash in `Algolia::Hit` initialize method"
        end

        if attributes.key?(:object_id)
          self.object_id = attributes[:object_id]
        else
          self.object_id = nil
        end

        if attributes.key?(:_highlight_result)
          if (value = attributes[:_highlight_result]).is_a?(Hash)
            self._highlight_result = value
          end
        end

        if attributes.key?(:_snippet_result)
          if (value = attributes[:_snippet_result]).is_a?(Hash)
            self._snippet_result = value
          end
        end

        if attributes.key?(:_ranking_info)
          self._ranking_info = attributes[:_ranking_info]
        end

        if attributes.key?(:_distinct_seq_id)
          self._distinct_seq_id = attributes[:_distinct_seq_id]
        end

        # add extra attribute to additional_properties
        self.additional_properties ||= {}
        self.additional_properties.merge!(attributes.reject { |k, _| self.class.attribute_map.key?(k.to_sym) })
      end

      # Checks equality by comparing each attribute.
      # @param [Object] Object to be compared
      def ==(other)
        return true if equal?(other)

        self.class == other.class &&
          object_id == other.object_id &&
          _highlight_result == other._highlight_result &&
          _snippet_result == other._snippet_result &&
          _ranking_info == other._ranking_info &&
          _distinct_seq_id == other._distinct_seq_id
      end

      # @see the `==` method
      # @param [Object] Object to be compared
      def eql?(other)
        self == other
      end

      # Calculates hash code according to all attributes.
      # @return [Integer] Hash code
      def hash
        [object_id, _highlight_result, _snippet_result, _ranking_info, _distinct_seq_id].hash
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

        # merge additional_properties into transformed_hash
        unless @additional_properties.nil?
          @additional_properties.each_pair do |k, v|
            transformed_hash[k.to_sym] = v
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
          klass = Algolia::Search.const_get(type)
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

        # also add attributes from additional_properties to hash
        self.additional_properties&.each_pair do |k, v|
          hash[k.to_sym] = _to_hash(v)
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
