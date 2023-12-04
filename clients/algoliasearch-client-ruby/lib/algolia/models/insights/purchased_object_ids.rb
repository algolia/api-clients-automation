# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

require 'date'
require 'time'

module Algolia
  # Use this event to track when users make a purchase unrelated to a previous Algolia request. For example, if you don't use Algolia to build your category pages, use this event.  To track purchase events related to Algolia requests, use the \"Purchased object IDs after search\" event. 
  class PurchasedObjectIDs
    # Can contain up to 64 ASCII characters.   Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework. 
    attr_accessor :event_name

    attr_accessor :event_type

    attr_accessor :event_subtype

    # Name of the Algolia index.
    attr_accessor :index

    # List of object identifiers for items of an Algolia index.
    attr_accessor :object_ids

    # Extra information about the records involved in the event—for example, to add price and quantities of purchased products.  If provided, must be the same length as `objectIDs`. 
    attr_accessor :object_data

    # If you include pricing information in the `objectData` parameter, you must also specify the currency as ISO-4217 currency code, such as USD or EUR.
    attr_accessor :currency

    # Anonymous or pseudonymous user identifier.   > **Note**: Never include personally identifiable information in user tokens. 
    attr_accessor :user_token

    # Time of the event in milliseconds in [Unix epoch time](https://wikipedia.org/wiki/Unix_time). By default, the Insights API uses the time it receives an event as its timestamp. 
    attr_accessor :timestamp

    # User token for authenticated users.
    attr_accessor :authenticated_user_token

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
        :'event_name' => :'eventName',
        :'event_type' => :'eventType',
        :'event_subtype' => :'eventSubtype',
        :'index' => :'index',
        :'object_ids' => :'objectIDs',
        :'object_data' => :'objectData',
        :'currency' => :'currency',
        :'user_token' => :'userToken',
        :'timestamp' => :'timestamp',
        :'authenticated_user_token' => :'authenticatedUserToken'
      }
    end

    # Returns all the JSON keys this model knows about
    def self.acceptable_attributes
      attribute_map.values
    end

    # Attribute type mapping.
    def self.openapi_types
      {
        :'event_name' => :'String',
        :'event_type' => :'ConversionEvent',
        :'event_subtype' => :'PurchaseEvent',
        :'index' => :'String',
        :'object_ids' => :'Array<String>',
        :'object_data' => :'Array<ObjectData>',
        :'currency' => :'String',
        :'user_token' => :'String',
        :'timestamp' => :'Integer',
        :'authenticated_user_token' => :'String'
      }
    end

    # List of attributes with nullable: true
    def self.openapi_nullable
      Set.new([
      ])
    end

    # Initializes the object
    # @param [Hash] attributes Model attributes in the form of hash
    def initialize(attributes = {})
      if (!attributes.is_a?(Hash))
        fail ArgumentError, "The input argument (attributes) must be a hash in `Algolia::PurchasedObjectIDs` initialize method"
      end

      # check to see if the attribute exists and convert string to symbol for hash key
      attributes = attributes.each_with_object({}) { |(k, v), h|
        if (!self.class.attribute_map.key?(k.to_sym))
          fail ArgumentError, "`#{k}` is not a valid attribute in `Algolia::PurchasedObjectIDs`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
        end
        h[k.to_sym] = v
      }

      if attributes.key?(:'event_name')
        self.event_name = attributes[:'event_name']
      else
        self.event_name = nil
      end

      if attributes.key?(:'event_type')
        self.event_type = attributes[:'event_type']
      else
        self.event_type = nil
      end

      if attributes.key?(:'event_subtype')
        self.event_subtype = attributes[:'event_subtype']
      else
        self.event_subtype = nil
      end

      if attributes.key?(:'index')
        self.index = attributes[:'index']
      else
        self.index = nil
      end

      if attributes.key?(:'object_ids')
        if (value = attributes[:'object_ids']).is_a?(Array)
          self.object_ids = value
        end
      else
        self.object_ids = nil
      end

      if attributes.key?(:'object_data')
        if (value = attributes[:'object_data']).is_a?(Array)
          self.object_data = value
        end
      end

      if attributes.key?(:'currency')
        self.currency = attributes[:'currency']
      end

      if attributes.key?(:'user_token')
        self.user_token = attributes[:'user_token']
      else
        self.user_token = nil
      end

      if attributes.key?(:'timestamp')
        self.timestamp = attributes[:'timestamp']
      end

      if attributes.key?(:'authenticated_user_token')
        self.authenticated_user_token = attributes[:'authenticated_user_token']
      end
    end

    # Show invalid properties with the reasons. Usually used together with valid?
    # @return Array for valid properties with the reasons
    def list_invalid_properties
      warn '[DEPRECATED] the `list_invalid_properties` method is obsolete'
      invalid_properties = Array.new
      if @event_name.nil?
        invalid_properties.push('invalid value for "event_name", event_name cannot be nil.')
      end

      if @event_name.to_s.length > 64
        invalid_properties.push('invalid value for "event_name", the character length must be smaller than or equal to 64.')
      end

      if @event_name.to_s.length < 1
        invalid_properties.push('invalid value for "event_name", the character length must be great than or equal to 1.')
      end

      pattern = Regexp.new(/[\x20-\x7E]{1,64}/)
      if @event_name !~ pattern
        invalid_properties.push("invalid value for \"event_name\", must conform to the pattern #{pattern}.")
      end

      if @event_type.nil?
        invalid_properties.push('invalid value for "event_type", event_type cannot be nil.')
      end

      if @event_subtype.nil?
        invalid_properties.push('invalid value for "event_subtype", event_subtype cannot be nil.')
      end

      if @index.nil?
        invalid_properties.push('invalid value for "index", index cannot be nil.')
      end

      if @object_ids.nil?
        invalid_properties.push('invalid value for "object_ids", object_ids cannot be nil.')
      end

      if @object_ids.length > 20
        invalid_properties.push('invalid value for "object_ids", number of items must be less than or equal to 20.')
      end

      if @object_ids.length < 1
        invalid_properties.push('invalid value for "object_ids", number of items must be greater than or equal to 1.')
      end

      if @user_token.nil?
        invalid_properties.push('invalid value for "user_token", user_token cannot be nil.')
      end

      if @user_token.to_s.length > 129
        invalid_properties.push('invalid value for "user_token", the character length must be smaller than or equal to 129.')
      end

      if @user_token.to_s.length < 1
        invalid_properties.push('invalid value for "user_token", the character length must be great than or equal to 1.')
      end

      pattern = Regexp.new(/[a-zA-Z0-9_=\/+-]{1,129}/)
      if @user_token !~ pattern
        invalid_properties.push("invalid value for \"user_token\", must conform to the pattern #{pattern}.")
      end

      invalid_properties
    end

    # Check to see if the all the properties in the model are valid
    # @return true if the model is valid
    def valid?
      warn '[DEPRECATED] the `valid?` method is obsolete'
      return false if @event_name.nil?
      return false if @event_name.to_s.length > 64
      return false if @event_name.to_s.length < 1
      return false if @event_name !~ Regexp.new(/[\x20-\x7E]{1,64}/)
      return false if @event_type.nil?
      return false if @event_subtype.nil?
      return false if @index.nil?
      return false if @object_ids.nil?
      return false if @object_ids.length > 20
      return false if @object_ids.length < 1
      return false if @user_token.nil?
      return false if @user_token.to_s.length > 129
      return false if @user_token.to_s.length < 1
      return false if @user_token !~ Regexp.new(/[a-zA-Z0-9_=\/+-]{1,129}/)
      true
    end

    # Custom attribute writer method with validation
    # @param [Object] event_name Value to be assigned
    def event_name=(event_name)
      if event_name.nil?
        fail ArgumentError, 'event_name cannot be nil'
      end

      if event_name.to_s.length > 64
        fail ArgumentError, 'invalid value for "event_name", the character length must be smaller than or equal to 64.'
      end

      if event_name.to_s.length < 1
        fail ArgumentError, 'invalid value for "event_name", the character length must be great than or equal to 1.'
      end

      pattern = Regexp.new(/[\x20-\x7E]{1,64}/)
      if event_name !~ pattern
        fail ArgumentError, "invalid value for \"event_name\", must conform to the pattern #{pattern}."
      end

      @event_name = event_name
    end

    # Custom attribute writer method with validation
    # @param [Object] object_ids Value to be assigned
    def object_ids=(object_ids)
      if object_ids.nil?
        fail ArgumentError, 'object_ids cannot be nil'
      end

      if object_ids.length > 20
        fail ArgumentError, 'invalid value for "object_ids", number of items must be less than or equal to 20.'
      end

      if object_ids.length < 1
        fail ArgumentError, 'invalid value for "object_ids", number of items must be greater than or equal to 1.'
      end

      @object_ids = object_ids
    end

    # Custom attribute writer method with validation
    # @param [Object] user_token Value to be assigned
    def user_token=(user_token)
      if user_token.nil?
        fail ArgumentError, 'user_token cannot be nil'
      end

      if user_token.to_s.length > 129
        fail ArgumentError, 'invalid value for "user_token", the character length must be smaller than or equal to 129.'
      end

      if user_token.to_s.length < 1
        fail ArgumentError, 'invalid value for "user_token", the character length must be great than or equal to 1.'
      end

      pattern = Regexp.new(/[a-zA-Z0-9_=\/+-]{1,129}/)
      if user_token !~ pattern
        fail ArgumentError, "invalid value for \"user_token\", must conform to the pattern #{pattern}."
      end

      @user_token = user_token
    end

    # Checks equality by comparing each attribute.
    # @param [Object] Object to be compared
    def ==(o)
      return true if self.equal?(o)
      self.class == o.class &&
          event_name == o.event_name &&
          event_type == o.event_type &&
          event_subtype == o.event_subtype &&
          index == o.index &&
          object_ids == o.object_ids &&
          object_data == o.object_data &&
          currency == o.currency &&
          user_token == o.user_token &&
          timestamp == o.timestamp &&
          authenticated_user_token == o.authenticated_user_token
    end

    # @see the `==` method
    # @param [Object] Object to be compared
    def eql?(o)
      self == o
    end

    # Calculates hash code according to all attributes.
    # @return [Integer] Hash code
    def hash
      [event_name, event_type, event_subtype, index, object_ids, object_data, currency, user_token, timestamp, authenticated_user_token].hash
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
