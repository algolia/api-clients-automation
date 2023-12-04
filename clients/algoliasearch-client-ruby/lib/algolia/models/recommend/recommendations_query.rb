# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

require 'date'
require 'time'

module Algolia
  class RecommendationsQuery
    attr_accessor :model

    # Unique object identifier.
    attr_accessor :object_id

    attr_accessor :query_parameters

    attr_accessor :fallback_parameters

    # Algolia index name.
    attr_accessor :index_name

    # Recommendations with a confidence score lower than `threshold` won't appear in results. > **Note**: Each recommendation has a confidence score of 0 to 100. The closer the score is to 100, the more relevant the recommendations are. 
    attr_accessor :threshold

    # Maximum number of recommendations to retrieve. If 0, all recommendations will be returned.
    attr_accessor :max_recommendations

    class EnumAttributeValidator
      attr_reader :datatype
      attr_reader :allowable_values

      def initialize(datatype, allowable_values)
        @allowable_values = allowable_values.map do |value|
          case datatype.to_s
          when /Integer/i
            value.to_i
          when /Float/i
            value.to_f
          else
            value
          end
        end
      end

      def valid?(value)
        !value || allowable_values.include?(value)
      end
    end

    # Attribute mapping from ruby-style variable name to JSON key.
    def self.attribute_map
      {
        :'model' => :'model',
        :'object_id' => :'objectID',
        :'query_parameters' => :'queryParameters',
        :'fallback_parameters' => :'fallbackParameters',
        :'index_name' => :'indexName',
        :'threshold' => :'threshold',
        :'max_recommendations' => :'maxRecommendations'
      }
    end

    # Returns all the JSON keys this model knows about
    def self.acceptable_attributes
      attribute_map.values
    end

    # Attribute type mapping.
    def self.openapi_types
      {
        :'model' => :'RecommendationModels',
        :'object_id' => :'String',
        :'query_parameters' => :'SearchParamsObject',
        :'fallback_parameters' => :'SearchParamsObject',
        :'index_name' => :'String',
        :'threshold' => :'Integer',
        :'max_recommendations' => :'Integer'
      }
    end

    # List of attributes with nullable: true
    def self.openapi_nullable
      Set.new([
      ])
    end

    # List of class defined in allOf (OpenAPI v3)
    def self.openapi_all_of
      [
      :'BaseRecommendRequest',
      :'BaseRecommendationsQuery'
      ]
    end

    # Initializes the object
    # @param [Hash] attributes Model attributes in the form of hash
    def initialize(attributes = {})
      if (!attributes.is_a?(Hash))
        fail ArgumentError, "The input argument (attributes) must be a hash in `Algolia::RecommendationsQuery` initialize method"
      end

      # check to see if the attribute exists and convert string to symbol for hash key
      attributes = attributes.each_with_object({}) { |(k, v), h|
        if (!self.class.attribute_map.key?(k.to_sym))
          fail ArgumentError, "`#{k}` is not a valid attribute in `Algolia::RecommendationsQuery`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
        end
        h[k.to_sym] = v
      }

      if attributes.key?(:'model')
        self.model = attributes[:'model']
      else
        self.model = nil
      end

      if attributes.key?(:'object_id')
        self.object_id = attributes[:'object_id']
      else
        self.object_id = nil
      end

      if attributes.key?(:'query_parameters')
        self.query_parameters = attributes[:'query_parameters']
      end

      if attributes.key?(:'fallback_parameters')
        self.fallback_parameters = attributes[:'fallback_parameters']
      end

      if attributes.key?(:'index_name')
        self.index_name = attributes[:'index_name']
      else
        self.index_name = nil
      end

      if attributes.key?(:'threshold')
        self.threshold = attributes[:'threshold']
      end

      if attributes.key?(:'max_recommendations')
        self.max_recommendations = attributes[:'max_recommendations']
      else
        self.max_recommendations = 0
      end
    end

    # Show invalid properties with the reasons. Usually used together with valid?
    # @return Array for valid properties with the reasons
    def list_invalid_properties
      warn '[DEPRECATED] the `list_invalid_properties` method is obsolete'
      invalid_properties = Array.new
      if @model.nil?
        invalid_properties.push('invalid value for "model", model cannot be nil.')
      end

      if @object_id.nil?
        invalid_properties.push('invalid value for "object_id", object_id cannot be nil.')
      end

      if @index_name.nil?
        invalid_properties.push('invalid value for "index_name", index_name cannot be nil.')
      end

      if !@threshold.nil? && @threshold > 100
        invalid_properties.push('invalid value for "threshold", must be smaller than or equal to 100.')
      end

      if !@threshold.nil? && @threshold < 0
        invalid_properties.push('invalid value for "threshold", must be greater than or equal to 0.')
      end

      invalid_properties
    end

    # Check to see if the all the properties in the model are valid
    # @return true if the model is valid
    def valid?
      warn '[DEPRECATED] the `valid?` method is obsolete'
      return false if @model.nil?
      return false if @object_id.nil?
      return false if @index_name.nil?
      return false if !@threshold.nil? && @threshold > 100
      return false if !@threshold.nil? && @threshold < 0
      true
    end

    # Custom attribute writer method with validation
    # @param [Object] threshold Value to be assigned
    def threshold=(threshold)
      if threshold.nil?
        fail ArgumentError, 'threshold cannot be nil'
      end

      if threshold > 100
        fail ArgumentError, 'invalid value for "threshold", must be smaller than or equal to 100.'
      end

      if threshold < 0
        fail ArgumentError, 'invalid value for "threshold", must be greater than or equal to 0.'
      end

      @threshold = threshold
    end

    # Checks equality by comparing each attribute.
    # @param [Object] Object to be compared
    def ==(o)
      return true if self.equal?(o)
      self.class == o.class &&
          model == o.model &&
          object_id == o.object_id &&
          query_parameters == o.query_parameters &&
          fallback_parameters == o.fallback_parameters &&
          index_name == o.index_name &&
          threshold == o.threshold &&
          max_recommendations == o.max_recommendations
    end

    # @see the `==` method
    # @param [Object] Object to be compared
    def eql?(o)
      self == o
    end

    # Calculates hash code according to all attributes.
    # @return [Integer] Hash code
    def hash
      [model, object_id, query_parameters, fallback_parameters, index_name, threshold, max_recommendations].hash
    end

    # Builds the object from hash
    # @param [Hash] attributes Model attributes in the form of hash
    # @return [Object] Returns the model itself
    def self.build_from_hash(attributes)
      return nil unless attributes.is_a?(Hash)
      attributes = attributes.transform_keys(&:to_sym)
      transformed_hash = {}
      openapi_types.each_pair do |key, type|
        if attributes.key?(attribute_map[key]) && attributes[attribute_map[key]].nil?
          transformed_hash["#{key}"] = nil
        elsif type =~ /\AArray<(.*)>/i
          # check to ensure the input is an array given that the attribute
          # is documented as an array but the input is not
          if attributes[attribute_map[key]].is_a?(Array)
            transformed_hash["#{key}"] = attributes[attribute_map[key]].map { |v| _deserialize($1, v) }
          end
        elsif !attributes[attribute_map[key]].nil?
          transformed_hash["#{key}"] = _deserialize(type, attributes[attribute_map[key]])
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
        klass = Algolia.const_get(type)
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

    # Returns the object in the form of hash
    # @return [Hash] Returns the object in the form of hash
    def to_hash
      hash = {}
      self.class.attribute_map.each_pair do |attr, param|
        value = self.send(attr)
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
