# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

require 'date'
require 'time'

module Algolia
  module Recommend
    class RankingInfo
      # This field is reserved for advanced usage.
      attr_accessor :filters

      # Position of the most important matched attribute in the attributes to index list.
      attr_accessor :first_matched_word

      # Distance between the geo location in the search query and the best matching geo location in the record, divided by the geo precision (in meters).
      attr_accessor :geo_distance

      # Precision used when computing the geo distance, in meters.
      attr_accessor :geo_precision

      attr_accessor :matched_geo_location

      attr_accessor :personalization

      # Number of exactly matched words.
      attr_accessor :nb_exact_words

      # Number of typos encountered when matching the record.
      attr_accessor :nb_typos

      # Present and set to true if a Rule promoted the hit.
      attr_accessor :promoted

      # When the query contains more than one word, the sum of the distances between matched words (in meters).
      attr_accessor :proximity_distance

      # Custom ranking for the object, expressed as a single integer value.
      attr_accessor :user_score

      # Number of matched words, including prefixes and typos.
      attr_accessor :words

      # Wether the record are promoted by the re-ranking strategy.
      attr_accessor :promoted_by_re_ranking

      # Attribute mapping from ruby-style variable name to JSON key.
      def self.attribute_map
        {
          :filters => :filters,
          :first_matched_word => :firstMatchedWord,
          :geo_distance => :geoDistance,
          :geo_precision => :geoPrecision,
          :matched_geo_location => :matchedGeoLocation,
          :personalization => :personalization,
          :nb_exact_words => :nbExactWords,
          :nb_typos => :nbTypos,
          :promoted => :promoted,
          :proximity_distance => :proximityDistance,
          :user_score => :userScore,
          :words => :words,
          :promoted_by_re_ranking => :promotedByReRanking
        }
      end

      # Returns all the JSON keys this model knows about
      def self.acceptable_attributes
        attribute_map.values
      end

      # Attribute type mapping.
      def self.types_mapping
        {
          :filters => :Integer,
          :first_matched_word => :Integer,
          :geo_distance => :Integer,
          :geo_precision => :Integer,
          :matched_geo_location => :MatchedGeoLocation,
          :personalization => :Personalization,
          :nb_exact_words => :Integer,
          :nb_typos => :Integer,
          :promoted => :Boolean,
          :proximity_distance => :Integer,
          :user_score => :Integer,
          :words => :Integer,
          :promoted_by_re_ranking => :Boolean
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
          raise ArgumentError, "The input argument (attributes) must be a hash in `Algolia::RankingInfo` initialize method"
        end

        # check to see if the attribute exists and convert string to symbol for hash key
        attributes = attributes.each_with_object({}) do |(k, v), h|
          unless self.class.attribute_map.key?(k.to_sym)
            raise ArgumentError,
                  "`#{k}` is not a valid attribute in `Algolia::RankingInfo`. Please check the name to make sure it's valid. List of attributes: " + self.class.attribute_map.keys.inspect
          end

          h[k.to_sym] = v
        end

        if attributes.key?(:filters)
          self.filters = attributes[:filters]
        else
          self.filters = nil
        end

        if attributes.key?(:first_matched_word)
          self.first_matched_word = attributes[:first_matched_word]
        else
          self.first_matched_word = nil
        end

        if attributes.key?(:geo_distance)
          self.geo_distance = attributes[:geo_distance]
        else
          self.geo_distance = nil
        end

        if attributes.key?(:geo_precision)
          self.geo_precision = attributes[:geo_precision]
        end

        if attributes.key?(:matched_geo_location)
          self.matched_geo_location = attributes[:matched_geo_location]
        end

        if attributes.key?(:personalization)
          self.personalization = attributes[:personalization]
        end

        if attributes.key?(:nb_exact_words)
          self.nb_exact_words = attributes[:nb_exact_words]
        else
          self.nb_exact_words = nil
        end

        if attributes.key?(:nb_typos)
          self.nb_typos = attributes[:nb_typos]
        else
          self.nb_typos = nil
        end

        if attributes.key?(:promoted)
          self.promoted = attributes[:promoted]
        else
          self.promoted = nil
        end

        if attributes.key?(:proximity_distance)
          self.proximity_distance = attributes[:proximity_distance]
        end

        if attributes.key?(:user_score)
          self.user_score = attributes[:user_score]
        else
          self.user_score = nil
        end

        if attributes.key?(:words)
          self.words = attributes[:words]
        else
          self.words = nil
        end

        if attributes.key?(:promoted_by_re_ranking)
          self.promoted_by_re_ranking = attributes[:promoted_by_re_ranking]
        end
      end

      # Checks equality by comparing each attribute.
      # @param [Object] Object to be compared
      def ==(other)
        return true if equal?(other)

        self.class == other.class &&
          filters == other.filters &&
          first_matched_word == other.first_matched_word &&
          geo_distance == other.geo_distance &&
          geo_precision == other.geo_precision &&
          matched_geo_location == other.matched_geo_location &&
          personalization == other.personalization &&
          nb_exact_words == other.nb_exact_words &&
          nb_typos == other.nb_typos &&
          promoted == other.promoted &&
          proximity_distance == other.proximity_distance &&
          user_score == other.user_score &&
          words == other.words &&
          promoted_by_re_ranking == other.promoted_by_re_ranking
      end

      # @see the `==` method
      # @param [Object] Object to be compared
      def eql?(other)
        self == other
      end

      # Calculates hash code according to all attributes.
      # @return [Integer] Hash code
      def hash
        [filters, first_matched_word, geo_distance, geo_precision, matched_geo_location, personalization, nb_exact_words, nb_typos, promoted, proximity_distance, user_score, words,
         promoted_by_re_ranking].hash
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
            transformed_hash[key.to_s] = nil
          elsif type =~ /\AArray<(.*)>/i
            # check to ensure the input is an array given that the attribute
            # is documented as an array but the input is not
            if attributes[attribute_map[key]].is_a?(Array)
              transformed_hash[key.to_s] = attributes[attribute_map[key]].map { |v| _deserialize(::Regexp.last_match(1), v) }
            end
          elsif !attributes[attribute_map[key]].nil?
            transformed_hash[key.to_s] = _deserialize(type, attributes[attribute_map[key]])
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
          klass = Algolia::Recommend.const_get(type)
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
