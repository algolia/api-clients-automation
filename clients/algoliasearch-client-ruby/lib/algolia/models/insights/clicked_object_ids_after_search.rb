# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

require "date"
require "time"

module Algolia
  module Insights
    # Click event after an Algolia request.  Use this event to track when users click items in the search results. If you're building your category pages with Algolia, you'll also use this event.
    class ClickedObjectIDsAfterSearch
      # Event name, up to 64 ASCII characters.  Consider naming events consistently—for example, by adopting Segment's [object-action](https://segment.com/academy/collecting-data/naming-conventions-for-clean-data/#the-object-action-framework) framework.
      attr_accessor :event_name

      attr_accessor :event_type

      # Index name (case-sensitive) to which the event's items belong.
      attr_accessor :index

      # Object IDs of the records that are part of the event.
      attr_accessor :object_ids

      # Position of the clicked item the search results.  You must provide 1 `position` for each `objectID`.
      attr_accessor :positions

      # Unique identifier for a search query.  The query ID is required for events related to search or browse requests. If you add `clickAnalytics: true` as a search request parameter, the query ID is included in the API response.
      attr_accessor :query_id

      # Anonymous or pseudonymous user identifier.  Don't use personally identifiable information in user tokens. For more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
      attr_accessor :user_token

      # Identifier for authenticated users.  When the user signs in, you can get an identifier from your system and send it as `authenticatedUserToken`. This lets you keep using the `userToken` from before the user signed in, while providing a reliable way to identify users across sessions. Don't use personally identifiable information in user tokens. For more information, see [User token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/).
      attr_accessor :authenticated_user_token

      # Timestamp of the event, measured in milliseconds since the Unix epoch. By default, the Insights API uses the time it receives an event as its timestamp.
      attr_accessor :timestamp

      # Attribute mapping from ruby-style variable name to JSON key.
      def self.attribute_map
        {
          :event_name => :eventName,
          :event_type => :eventType,
          :index => :index,
          :object_ids => :objectIDs,
          :positions => :positions,
          :query_id => :queryID,
          :user_token => :userToken,
          :authenticated_user_token => :authenticatedUserToken,
          :timestamp => :timestamp
        }
      end

      # Returns all the JSON keys this model knows about
      def self.acceptable_attributes
        attribute_map.values
      end

      # Attribute type mapping.
      def self.types_mapping
        {
          :event_name => :"String",
          :event_type => :"ClickEvent",
          :index => :"String",
          :object_ids => :"Array<String>",
          :positions => :"Array<Integer>",
          :query_id => :"String",
          :user_token => :"String",
          :authenticated_user_token => :"String",
          :timestamp => :"Integer"
        }
      end

      # List of attributes with nullable: true
      def self.openapi_nullable
        Set.new(
          []
        )
      end

      # Initializes the object
      # @param [Hash] attributes Model attributes in the form of hash
      def initialize(attributes = {})
        if (!attributes.is_a?(Hash))
          raise(
            ArgumentError,
            "The input argument (attributes) must be a hash in `Algolia::ClickedObjectIDsAfterSearch` initialize method"
          )
        end

        # check to see if the attribute exists and convert string to symbol for hash key
        attributes = attributes.each_with_object({}) { |(k, v), h|
          if (!self.class.attribute_map.key?(k.to_sym))
            raise(
              ArgumentError,
              "`#{k}` is not a valid attribute in `Algolia::ClickedObjectIDsAfterSearch`. Please check the name to make sure it's valid. List of attributes: " +
                self.class.attribute_map.keys.inspect
            )
          end

          h[k.to_sym] = v
        }

        if attributes.key?(:event_name)
          self.event_name = attributes[:event_name]
        else
          self.event_name = nil
        end

        if attributes.key?(:event_type)
          self.event_type = attributes[:event_type]
        else
          self.event_type = nil
        end

        if attributes.key?(:index)
          self.index = attributes[:index]
        else
          self.index = nil
        end

        if attributes.key?(:object_ids)
          if (value = attributes[:object_ids]).is_a?(Array)
            self.object_ids = value
          end
        else
          self.object_ids = nil
        end

        if attributes.key?(:positions)
          if (value = attributes[:positions]).is_a?(Array)
            self.positions = value
          end
        else
          self.positions = nil
        end

        if attributes.key?(:query_id)
          self.query_id = attributes[:query_id]
        else
          self.query_id = nil
        end

        if attributes.key?(:user_token)
          self.user_token = attributes[:user_token]
        else
          self.user_token = nil
        end

        if attributes.key?(:authenticated_user_token)
          self.authenticated_user_token = attributes[:authenticated_user_token]
        end

        if attributes.key?(:timestamp)
          self.timestamp = attributes[:timestamp]
        end
      end

      # Custom attribute writer method with validation
      # @param [Object] event_name Value to be assigned
      def event_name=(event_name)
        if event_name.nil?
          raise ArgumentError, "event_name cannot be nil"
        end

        if event_name.to_s.length > 64
          raise(
            ArgumentError,
            "invalid value for \"event_name\", the character length must be smaller than or equal to 64."
          )
        end

        if event_name.to_s.length < 1
          raise(
            ArgumentError,
            "invalid value for \"event_name\", the character length must be great than or equal to 1."
          )
        end

        pattern = /[\x20-\x7E]{1,64}/
        if event_name !~ pattern
          raise ArgumentError, "invalid value for \"event_name\", must conform to the pattern #{pattern}."
        end

        @event_name = event_name
      end

      # Custom attribute writer method with validation
      # @param [Object] object_ids Value to be assigned
      def object_ids=(object_ids)
        if object_ids.nil?
          raise ArgumentError, "object_ids cannot be nil"
        end

        if object_ids.length > 20
          raise ArgumentError, "invalid value for \"object_ids\", number of items must be less than or equal to 20."
        end

        if object_ids.length < 1
          raise ArgumentError, "invalid value for \"object_ids\", number of items must be greater than or equal to 1."
        end

        @object_ids = object_ids
      end

      # Custom attribute writer method with validation
      # @param [Object] positions Value to be assigned
      def positions=(positions)
        if positions.nil?
          raise ArgumentError, "positions cannot be nil"
        end

        if positions.length > 20
          raise ArgumentError, "invalid value for \"positions\", number of items must be less than or equal to 20."
        end

        if positions.length < 1
          raise ArgumentError, "invalid value for \"positions\", number of items must be greater than or equal to 1."
        end

        @positions = positions
      end

      # Custom attribute writer method with validation
      # @param [Object] query_id Value to be assigned
      def query_id=(query_id)
        if query_id.nil?
          raise ArgumentError, "query_id cannot be nil"
        end

        if query_id.to_s.length > 32
          raise(
            ArgumentError,
            "invalid value for \"query_id\", the character length must be smaller than or equal to 32."
          )
        end

        if query_id.to_s.length < 32
          raise ArgumentError, "invalid value for \"query_id\", the character length must be great than or equal to 32."
        end

        pattern = /[0-9a-f]{32}/
        if query_id !~ pattern
          raise ArgumentError, "invalid value for \"query_id\", must conform to the pattern #{pattern}."
        end

        @query_id = query_id
      end

      # Custom attribute writer method with validation
      # @param [Object] user_token Value to be assigned
      def user_token=(user_token)
        if user_token.nil?
          raise ArgumentError, "user_token cannot be nil"
        end

        if user_token.to_s.length > 129
          raise(
            ArgumentError,
            "invalid value for \"user_token\", the character length must be smaller than or equal to 129."
          )
        end

        if user_token.to_s.length < 1
          raise(
            ArgumentError,
            "invalid value for \"user_token\", the character length must be great than or equal to 1."
          )
        end

        pattern = /[a-zA-Z0-9_=\/+-]{1,129}/
        if user_token !~ pattern
          raise ArgumentError, "invalid value for \"user_token\", must conform to the pattern #{pattern}."
        end

        @user_token = user_token
      end

      # Custom attribute writer method with validation
      # @param [Object] authenticated_user_token Value to be assigned
      def authenticated_user_token=(authenticated_user_token)
        if authenticated_user_token.nil?
          raise ArgumentError, "authenticated_user_token cannot be nil"
        end

        if authenticated_user_token.to_s.length > 129
          raise(
            ArgumentError,
            "invalid value for \"authenticated_user_token\", the character length must be smaller than or equal to 129."
          )
        end

        if authenticated_user_token.to_s.length < 1
          raise(
            ArgumentError,
            "invalid value for \"authenticated_user_token\", the character length must be great than or equal to 1."
          )
        end

        pattern = /[a-zA-Z0-9_=\/+-]{1,129}/
        if authenticated_user_token !~ pattern
          raise ArgumentError, "invalid value for \"authenticated_user_token\", must conform to the pattern #{pattern}."
        end

        @authenticated_user_token = authenticated_user_token
      end

      # Checks equality by comparing each attribute.
      # @param [Object] Object to be compared
      def ==(other)
        return true if self.equal?(other)
        self.class == other.class &&
          event_name == other.event_name &&
          event_type == other.event_type &&
          index == other.index &&
          object_ids == other.object_ids &&
          positions == other.positions &&
          query_id == other.query_id &&
          user_token == other.user_token &&
          authenticated_user_token == other.authenticated_user_token &&
          timestamp == other.timestamp
      end

      # @see the `==` method
      # @param [Object] Object to be compared
      def eql?(other)
        self == other
      end

      # Calculates hash code according to all attributes.
      # @return [Integer] Hash code
      def hash
        [
          event_name,
          event_type,
          index,
          object_ids,
          positions,
          query_id,
          user_token,
          authenticated_user_token,
          timestamp
        ].hash
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
              transformed_hash[key.to_sym] = attributes[attribute_map[key]].map { |v|
                _deserialize(::Regexp.last_match(1), v)
              }
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
          # model
        else
          # models (e.g. Pet) or oneOf
          klass = Algolia::Insights.const_get(type)
          klass.respond_to?(:openapi_any_of) || klass.respond_to?(:openapi_one_of) ? klass.build(value) : klass
            .build_from_hash(value)
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
        elsif value.respond_to?(:to_hash)
          value.to_hash
        else
          value
        end
      end

    end

  end
end
