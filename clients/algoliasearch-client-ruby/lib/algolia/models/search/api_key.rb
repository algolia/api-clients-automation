# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

require 'date'
require 'time'

module Algolia
  # API key object.
  class ApiKey
    # [Permissions](https://www.algolia.com/doc/guides/security/api-keys/#access-control-list-acl) associated with the key. 
    attr_accessor :acl

    # Description of an API key for you and your team members.
    attr_accessor :description

    # Restricts this API key to a list of indices or index patterns. If the list is empty, all indices are allowed. Specify either an exact index name or a pattern with a leading or trailing wildcard character (or both). For example: - `dev_*` matches all indices starting with \"dev_\" - `*_dev` matches all indices ending with \"_dev\" - `*_products_*` matches all indices containing \"_products_\". 
    attr_accessor :indexes

    # Maximum number of hits this API key can retrieve in one query. If zero, no limit is enforced. > **Note**: Use this parameter to protect you from third-party attempts to retrieve your entire content by massively querying the index. 
    attr_accessor :max_hits_per_query

    # Maximum number of API calls per hour allowed from a given IP address or [user token](https://www.algolia.com/doc/guides/sending-events/concepts/usertoken/). Each time an API call is performed with this key, a check is performed. If there were more than the specified number of calls within the last hour, the API returns an error with the status code `429` (Too Many Requests).  > **Note**: Use this parameter to protect you from third-party attempts to retrieve your entire content by massively querying the index. 
    attr_accessor :max_queries_per_ip_per_hour

    # Force some [query parameters](https://www.algolia.com/doc/api-reference/api-parameters/) to be applied for each query made with this API key. It's a URL-encoded query string. 
    attr_accessor :query_parameters

    # Restrict this API key to specific [referrers](https://www.algolia.com/doc/guides/security/api-keys/in-depth/api-key-restrictions/#http-referrers). If empty, all referrers are allowed. For example: - `https://algolia.com/*` matches all referrers starting with \"https://algolia.com/\" - `*.algolia.com` matches all referrers ending with \".algolia.com\" - `*algolia.com*` allows everything in the domain \"algolia.com\". 
    attr_accessor :referers

    # Validity duration of a key (in seconds).  The key will automatically be removed after this time has expired. The default value of 0 never expires. Short-lived API keys are useful to grant temporary access to your data. For example, in mobile apps, you can't [control when users update your app](https://www.algolia.com/doc/guides/security/security-best-practices/#use-secured-api-keys-in-mobile-apps). So instead of encoding keys into your app as you would for a web app, you should dynamically fetch them from your mobile app's backend. 
    attr_accessor :validity

    # Attribute mapping from ruby-style variable name to JSON key.
    def self.attribute_map
      {
        :'acl' => :'acl',
        :'description' => :'description',
        :'indexes' => :'indexes',
        :'max_hits_per_query' => :'maxHitsPerQuery',
        :'max_queries_per_ip_per_hour' => :'maxQueriesPerIPPerHour',
        :'query_parameters' => :'queryParameters',
        :'referers' => :'referers',
        :'validity' => :'validity'
      }
    end

    # Returns all the JSON keys this model knows about
    def self.acceptable_attributes
      attribute_map.values
    end

    # Attribute type mapping.
    def self.openapi_types
      {
        :'acl' => :'Array<Acl>',
        :'description' => :'String',
        :'indexes' => :'Array<String>',
        :'max_hits_per_query' => :'Integer',
        :'max_queries_per_ip_per_hour' => :'Integer',
        :'query_parameters' => :'String',
        :'referers' => :'Array<String>',
        :'validity' => :'Integer'
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
        fail ArgumentError, "The input argument (attributes) must be a hash in `Algolia::ApiKey` initialize method"
      end

      # check to see if the attribute exists and convert string to symbol for hash key
      attributes = attributes.each_with_object({}) { |(k, v), h|
        if (!self.class.attribute_map.key?(k.to_sym))
          fail ArgumentError, "`#{k}` is not a valid attribute in `Algolia::ApiKey`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
        end
        h[k.to_sym] = v
      }

      if attributes.key?(:'acl')
        if (value = attributes[:'acl']).is_a?(Array)
          self.acl = value
        end
      else
        self.acl = nil
      end

      if attributes.key?(:'description')
        self.description = attributes[:'description']
      else
        self.description = ''
      end

      if attributes.key?(:'indexes')
        if (value = attributes[:'indexes']).is_a?(Array)
          self.indexes = value
        end
      end

      if attributes.key?(:'max_hits_per_query')
        self.max_hits_per_query = attributes[:'max_hits_per_query']
      else
        self.max_hits_per_query = 0
      end

      if attributes.key?(:'max_queries_per_ip_per_hour')
        self.max_queries_per_ip_per_hour = attributes[:'max_queries_per_ip_per_hour']
      else
        self.max_queries_per_ip_per_hour = 0
      end

      if attributes.key?(:'query_parameters')
        self.query_parameters = attributes[:'query_parameters']
      else
        self.query_parameters = ''
      end

      if attributes.key?(:'referers')
        if (value = attributes[:'referers']).is_a?(Array)
          self.referers = value
        end
      end

      if attributes.key?(:'validity')
        self.validity = attributes[:'validity']
      else
        self.validity = 0
      end
    end

    # Show invalid properties with the reasons. Usually used together with valid?
    # @return Array for valid properties with the reasons
    def list_invalid_properties
      warn '[DEPRECATED] the `list_invalid_properties` method is obsolete'
      invalid_properties = Array.new
      if @acl.nil?
        invalid_properties.push('invalid value for "acl", acl cannot be nil.')
      end

      invalid_properties
    end

    # Check to see if the all the properties in the model are valid
    # @return true if the model is valid
    def valid?
      warn '[DEPRECATED] the `valid?` method is obsolete'
      return false if @acl.nil?
      true
    end

    # Checks equality by comparing each attribute.
    # @param [Object] Object to be compared
    def ==(o)
      return true if self.equal?(o)
      self.class == o.class &&
          acl == o.acl &&
          description == o.description &&
          indexes == o.indexes &&
          max_hits_per_query == o.max_hits_per_query &&
          max_queries_per_ip_per_hour == o.max_queries_per_ip_per_hour &&
          query_parameters == o.query_parameters &&
          referers == o.referers &&
          validity == o.validity
    end

    # @see the `==` method
    # @param [Object] Object to be compared
    def eql?(o)
      self == o
    end

    # Calculates hash code according to all attributes.
    # @return [Integer] Hash code
    def hash
      [acl, description, indexes, max_hits_per_query, max_queries_per_ip_per_hour, query_parameters, referers, validity].hash
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
