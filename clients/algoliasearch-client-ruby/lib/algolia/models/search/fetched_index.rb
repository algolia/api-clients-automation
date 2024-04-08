# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

require 'date'
require 'time'

module Algolia
  module Search
    class FetchedIndex
      # Index name.
      attr_accessor :name

      # Index creation date. An empty string means that the index has no records.
      attr_accessor :created_at

      # Date and time when the object was updated, in RFC 3339 format.
      attr_accessor :updated_at

      # Number of records contained in the index.
      attr_accessor :entries

      # Number of bytes of the index in minified format.
      attr_accessor :data_size

      # Number of bytes of the index binary file.
      attr_accessor :file_size

      # Last build time.
      attr_accessor :last_build_time_s

      # Number of pending indexing operations. This value is deprecated and should not be used.
      attr_accessor :number_of_pending_tasks

      # A boolean which says whether the index has pending tasks. This value is deprecated and should not be used.
      attr_accessor :pending_task

      # Only present if the index is a replica. Contains the name of the related primary index.
      attr_accessor :primary

      # Only present if the index is a primary index with replicas. Contains the names of all linked replicas.
      attr_accessor :replicas

      # Attribute mapping from ruby-style variable name to JSON key.
      def self.attribute_map
        {
          :name => :name,
          :created_at => :createdAt,
          :updated_at => :updatedAt,
          :entries => :entries,
          :data_size => :dataSize,
          :file_size => :fileSize,
          :last_build_time_s => :lastBuildTimeS,
          :number_of_pending_tasks => :numberOfPendingTasks,
          :pending_task => :pendingTask,
          :primary => :primary,
          :replicas => :replicas
        }
      end

      # Returns all the JSON keys this model knows about
      def self.acceptable_attributes
        attribute_map.values
      end

      # Attribute type mapping.
      def self.types_mapping
        {
          :name => :String,
          :created_at => :String,
          :updated_at => :String,
          :entries => :Integer,
          :data_size => :Integer,
          :file_size => :Integer,
          :last_build_time_s => :Integer,
          :number_of_pending_tasks => :Integer,
          :pending_task => :Boolean,
          :primary => :String,
          :replicas => :'Array<String>'
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
          raise ArgumentError, "The input argument (attributes) must be a hash in `Algolia::FetchedIndex` initialize method"
        end

        # check to see if the attribute exists and convert string to symbol for hash key
        attributes = attributes.each_with_object({}) do |(k, v), h|
          unless self.class.attribute_map.key?(k.to_sym)
            raise ArgumentError,
                  "`#{k}` is not a valid attribute in `Algolia::FetchedIndex`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
          end

          h[k.to_sym] = v
        end

        if attributes.key?(:name)
          self.name = attributes[:name]
        else
          self.name = nil
        end

        if attributes.key?(:created_at)
          self.created_at = attributes[:created_at]
        else
          self.created_at = nil
        end

        if attributes.key?(:updated_at)
          self.updated_at = attributes[:updated_at]
        else
          self.updated_at = nil
        end

        if attributes.key?(:entries)
          self.entries = attributes[:entries]
        else
          self.entries = nil
        end

        if attributes.key?(:data_size)
          self.data_size = attributes[:data_size]
        else
          self.data_size = nil
        end

        if attributes.key?(:file_size)
          self.file_size = attributes[:file_size]
        else
          self.file_size = nil
        end

        if attributes.key?(:last_build_time_s)
          self.last_build_time_s = attributes[:last_build_time_s]
        else
          self.last_build_time_s = nil
        end

        if attributes.key?(:number_of_pending_tasks)
          self.number_of_pending_tasks = attributes[:number_of_pending_tasks]
        else
          self.number_of_pending_tasks = nil
        end

        if attributes.key?(:pending_task)
          self.pending_task = attributes[:pending_task]
        else
          self.pending_task = nil
        end

        if attributes.key?(:primary)
          self.primary = attributes[:primary]
        end

        if attributes.key?(:replicas)
          if (value = attributes[:replicas]).is_a?(Array)
            self.replicas = value
          end
        end
      end

      # Checks equality by comparing each attribute.
      # @param [Object] Object to be compared
      def ==(other)
        return true if equal?(other)

        self.class == other.class &&
          name == other.name &&
          created_at == other.created_at &&
          updated_at == other.updated_at &&
          entries == other.entries &&
          data_size == other.data_size &&
          file_size == other.file_size &&
          last_build_time_s == other.last_build_time_s &&
          number_of_pending_tasks == other.number_of_pending_tasks &&
          pending_task == other.pending_task &&
          primary == other.primary &&
          replicas == other.replicas
      end

      # @see the `==` method
      # @param [Object] Object to be compared
      def eql?(other)
        self == other
      end

      # Calculates hash code according to all attributes.
      # @return [Integer] Hash code
      def hash
        [name, created_at, updated_at, entries, data_size, file_size, last_build_time_s, number_of_pending_tasks, pending_task, primary, replicas].hash
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
