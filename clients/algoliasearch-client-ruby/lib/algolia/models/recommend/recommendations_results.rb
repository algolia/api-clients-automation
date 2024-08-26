# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

require "date"
require "time"

module Algolia
  module Recommend
    class RecommendationsResults
      # A/B test ID. This is only included in the response for indices that are part of an A/B test.
      attr_accessor :ab_test_id

      # Variant ID. This is only included in the response for indices that are part of an A/B test.
      attr_accessor :ab_test_variant_id

      # Computed geographical location.
      attr_accessor :around_lat_lng

      # Distance from a central coordinate provided by `aroundLatLng`.
      attr_accessor :automatic_radius

      attr_accessor :exhaustive

      # See the `facetsCount` field of the `exhaustive` object in the response.
      attr_accessor :exhaustive_facets_count

      # See the `nbHits` field of the `exhaustive` object in the response.
      attr_accessor :exhaustive_nb_hits

      # See the `typo` field of the `exhaustive` object in the response.
      attr_accessor :exhaustive_typo

      # Facet counts.
      attr_accessor :facets

      # Statistics for numerical facets.
      attr_accessor :facets_stats

      # Index name used for the query.
      attr_accessor :index

      # Index name used for the query. During A/B testing, the targeted index isn't always the index used by the query.
      attr_accessor :index_used

      # Warnings about the query.
      attr_accessor :message

      # Number of hits selected and sorted by the relevant sort algorithm.
      attr_accessor :nb_sorted_hits

      # Post-[normalization](https://www.algolia.com/doc/guides/managing-results/optimize-search-results/handling-natural-languages-nlp/#what-does-normalization-mean) query string that will be searched.
      attr_accessor :parsed_query

      # Time the server took to process the request, in milliseconds.
      attr_accessor :processing_time_ms

      # Experimental. List of processing steps and their times, in milliseconds. You can use this list to investigate performance issues.
      attr_accessor :processing_timings_ms

      # Markup text indicating which parts of the original query have been removed to retrieve a non-empty result set.
      attr_accessor :query_after_removal

      attr_accessor :redirect

      attr_accessor :rendering_content

      # Time the server took to process the request, in milliseconds.
      attr_accessor :server_time_ms

      # Host name of the server that processed the request.
      attr_accessor :server_used

      # An object with custom data.  You can store up to 32kB as custom data.
      attr_accessor :user_data

      # Unique identifier for the query. This is used for [click analytics](https://www.algolia.com/doc/guides/analytics/click-analytics/).
      attr_accessor :query_id

      # Page of search results to retrieve.
      attr_accessor :page

      # Number of results (hits).
      attr_accessor :nb_hits

      # Number of pages of results.
      attr_accessor :nb_pages

      # Number of hits per page.
      attr_accessor :hits_per_page

      attr_accessor :hits

      # Attribute mapping from ruby-style variable name to JSON key.
      def self.attribute_map
        {
          :ab_test_id => :abTestID,
          :ab_test_variant_id => :abTestVariantID,
          :around_lat_lng => :aroundLatLng,
          :automatic_radius => :automaticRadius,
          :exhaustive => :exhaustive,
          :exhaustive_facets_count => :exhaustiveFacetsCount,
          :exhaustive_nb_hits => :exhaustiveNbHits,
          :exhaustive_typo => :exhaustiveTypo,
          :facets => :facets,
          :facets_stats => :facets_stats,
          :index => :index,
          :index_used => :indexUsed,
          :message => :message,
          :nb_sorted_hits => :nbSortedHits,
          :parsed_query => :parsedQuery,
          :processing_time_ms => :processingTimeMS,
          :processing_timings_ms => :processingTimingsMS,
          :query_after_removal => :queryAfterRemoval,
          :redirect => :redirect,
          :rendering_content => :renderingContent,
          :server_time_ms => :serverTimeMS,
          :server_used => :serverUsed,
          :user_data => :userData,
          :query_id => :queryID,
          :page => :page,
          :nb_hits => :nbHits,
          :nb_pages => :nbPages,
          :hits_per_page => :hitsPerPage,
          :hits => :hits
        }
      end

      # Returns all the JSON keys this model knows about
      def self.acceptable_attributes
        attribute_map.values
      end

      # Attribute type mapping.
      def self.types_mapping
        {
          :ab_test_id => :"Integer",
          :ab_test_variant_id => :"Integer",
          :around_lat_lng => :"String",
          :automatic_radius => :"String",
          :exhaustive => :"Exhaustive",
          :exhaustive_facets_count => :"Boolean",
          :exhaustive_nb_hits => :"Boolean",
          :exhaustive_typo => :"Boolean",
          :facets => :"Hash<String, Hash<String, Integer>>",
          :facets_stats => :"Hash<String, FacetStats>",
          :index => :"String",
          :index_used => :"String",
          :message => :"String",
          :nb_sorted_hits => :"Integer",
          :parsed_query => :"String",
          :processing_time_ms => :"Integer",
          :processing_timings_ms => :"Object",
          :query_after_removal => :"String",
          :redirect => :"Redirect",
          :rendering_content => :"RenderingContent",
          :server_time_ms => :"Integer",
          :server_used => :"String",
          :user_data => :"Object",
          :query_id => :"String",
          :page => :"Integer",
          :nb_hits => :"Integer",
          :nb_pages => :"Integer",
          :hits_per_page => :"Integer",
          :hits => :"Array<RecommendationsHit>"
        }
      end

      # List of attributes with nullable: true
      def self.openapi_nullable
        Set.new(
          []
        )
      end

      # List of class defined in allOf (OpenAPI v3)
      def self.openapi_all_of
        [
          :"BaseSearchResponse",
          :"RecommendationsHits",
          :"SearchPagination"
        ]
      end

      # Initializes the object
      # @param [Hash] attributes Model attributes in the form of hash
      def initialize(attributes = {})
        if (!attributes.is_a?(Hash))
          raise(
            ArgumentError,
            "The input argument (attributes) must be a hash in `Algolia::RecommendationsResults` initialize method"
          )
        end

        # check to see if the attribute exists and convert string to symbol for hash key
        attributes = attributes.each_with_object({}) { |(k, v), h|
          if (!self.class.attribute_map.key?(k.to_sym))
            raise(
              ArgumentError,
              "`#{k}` is not a valid attribute in `Algolia::RecommendationsResults`. Please check the name to make sure it's valid. List of attributes: " +
                self.class.attribute_map.keys.inspect
            )
          end

          h[k.to_sym] = v
        }

        if attributes.key?(:ab_test_id)
          self.ab_test_id = attributes[:ab_test_id]
        end

        if attributes.key?(:ab_test_variant_id)
          self.ab_test_variant_id = attributes[:ab_test_variant_id]
        end

        if attributes.key?(:around_lat_lng)
          self.around_lat_lng = attributes[:around_lat_lng]
        end

        if attributes.key?(:automatic_radius)
          self.automatic_radius = attributes[:automatic_radius]
        end

        if attributes.key?(:exhaustive)
          self.exhaustive = attributes[:exhaustive]
        end

        if attributes.key?(:exhaustive_facets_count)
          self.exhaustive_facets_count = attributes[:exhaustive_facets_count]
        end

        if attributes.key?(:exhaustive_nb_hits)
          self.exhaustive_nb_hits = attributes[:exhaustive_nb_hits]
        end

        if attributes.key?(:exhaustive_typo)
          self.exhaustive_typo = attributes[:exhaustive_typo]
        end

        if attributes.key?(:facets)
          if (value = attributes[:facets]).is_a?(Hash)
            self.facets = value
          end
        end

        if attributes.key?(:facets_stats)
          if (value = attributes[:facets_stats]).is_a?(Hash)
            self.facets_stats = value
          end
        end

        if attributes.key?(:index)
          self.index = attributes[:index]
        end

        if attributes.key?(:index_used)
          self.index_used = attributes[:index_used]
        end

        if attributes.key?(:message)
          self.message = attributes[:message]
        end

        if attributes.key?(:nb_sorted_hits)
          self.nb_sorted_hits = attributes[:nb_sorted_hits]
        end

        if attributes.key?(:parsed_query)
          self.parsed_query = attributes[:parsed_query]
        end

        if attributes.key?(:processing_time_ms)
          self.processing_time_ms = attributes[:processing_time_ms]
        else
          self.processing_time_ms = nil
        end

        if attributes.key?(:processing_timings_ms)
          self.processing_timings_ms = attributes[:processing_timings_ms]
        end

        if attributes.key?(:query_after_removal)
          self.query_after_removal = attributes[:query_after_removal]
        end

        if attributes.key?(:redirect)
          self.redirect = attributes[:redirect]
        end

        if attributes.key?(:rendering_content)
          self.rendering_content = attributes[:rendering_content]
        end

        if attributes.key?(:server_time_ms)
          self.server_time_ms = attributes[:server_time_ms]
        end

        if attributes.key?(:server_used)
          self.server_used = attributes[:server_used]
        end

        if attributes.key?(:user_data)
          self.user_data = attributes[:user_data]
        end

        if attributes.key?(:query_id)
          self.query_id = attributes[:query_id]
        end

        if attributes.key?(:page)
          self.page = attributes[:page]
        else
          self.page = nil
        end

        if attributes.key?(:nb_hits)
          self.nb_hits = attributes[:nb_hits]
        else
          self.nb_hits = nil
        end

        if attributes.key?(:nb_pages)
          self.nb_pages = attributes[:nb_pages]
        else
          self.nb_pages = nil
        end

        if attributes.key?(:hits_per_page)
          self.hits_per_page = attributes[:hits_per_page]
        else
          self.hits_per_page = nil
        end

        if attributes.key?(:hits)
          if (value = attributes[:hits]).is_a?(Array)
            self.hits = value
          end
        else
          self.hits = nil
        end
      end

      # Custom attribute writer method with validation
      # @param [Object] ab_test_variant_id Value to be assigned
      def ab_test_variant_id=(ab_test_variant_id)
        if ab_test_variant_id.nil?
          raise ArgumentError, "ab_test_variant_id cannot be nil"
        end

        if ab_test_variant_id < 1
          raise ArgumentError, "invalid value for \"ab_test_variant_id\", must be greater than or equal to 1."
        end

        @ab_test_variant_id = ab_test_variant_id
      end

      # Custom attribute writer method with validation
      # @param [Object] around_lat_lng Value to be assigned
      def around_lat_lng=(around_lat_lng)
        if around_lat_lng.nil?
          raise ArgumentError, "around_lat_lng cannot be nil"
        end

        pattern = /^(-?\d+(\.\d+)?),\s*(-?\d+(\.\d+)?)$/
        if around_lat_lng !~ pattern
          raise ArgumentError, "invalid value for \"around_lat_lng\", must conform to the pattern #{pattern}."
        end

        @around_lat_lng = around_lat_lng
      end

      # Custom attribute writer method with validation
      # @param [Object] page Value to be assigned
      def page=(page)
        if page.nil?
          raise ArgumentError, "page cannot be nil"
        end

        if page < 0
          raise ArgumentError, "invalid value for \"page\", must be greater than or equal to 0."
        end

        @page = page
      end

      # Custom attribute writer method with validation
      # @param [Object] hits_per_page Value to be assigned
      def hits_per_page=(hits_per_page)
        if hits_per_page.nil?
          raise ArgumentError, "hits_per_page cannot be nil"
        end

        if hits_per_page > 1000
          raise ArgumentError, "invalid value for \"hits_per_page\", must be smaller than or equal to 1000."
        end

        if hits_per_page < 1
          raise ArgumentError, "invalid value for \"hits_per_page\", must be greater than or equal to 1."
        end

        @hits_per_page = hits_per_page
      end

      # Checks equality by comparing each attribute.
      # @param [Object] Object to be compared
      def ==(other)
        return true if self.equal?(other)
        self.class == other.class &&
          ab_test_id == other.ab_test_id &&
          ab_test_variant_id == other.ab_test_variant_id &&
          around_lat_lng == other.around_lat_lng &&
          automatic_radius == other.automatic_radius &&
          exhaustive == other.exhaustive &&
          exhaustive_facets_count == other.exhaustive_facets_count &&
          exhaustive_nb_hits == other.exhaustive_nb_hits &&
          exhaustive_typo == other.exhaustive_typo &&
          facets == other.facets &&
          facets_stats == other.facets_stats &&
          index == other.index &&
          index_used == other.index_used &&
          message == other.message &&
          nb_sorted_hits == other.nb_sorted_hits &&
          parsed_query == other.parsed_query &&
          processing_time_ms == other.processing_time_ms &&
          processing_timings_ms == other.processing_timings_ms &&
          query_after_removal == other.query_after_removal &&
          redirect == other.redirect &&
          rendering_content == other.rendering_content &&
          server_time_ms == other.server_time_ms &&
          server_used == other.server_used &&
          user_data == other.user_data &&
          query_id == other.query_id &&
          page == other.page &&
          nb_hits == other.nb_hits &&
          nb_pages == other.nb_pages &&
          hits_per_page == other.hits_per_page &&
          hits == other.hits
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
          ab_test_id,
          ab_test_variant_id,
          around_lat_lng,
          automatic_radius,
          exhaustive,
          exhaustive_facets_count,
          exhaustive_nb_hits,
          exhaustive_typo,
          facets,
          facets_stats,
          index,
          index_used,
          message,
          nb_sorted_hits,
          parsed_query,
          processing_time_ms,
          processing_timings_ms,
          query_after_removal,
          redirect,
          rendering_content,
          server_time_ms,
          server_used,
          user_data,
          query_id,
          page,
          nb_hits,
          nb_pages,
          hits_per_page,
          hits
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
          klass = Algolia::Recommend.const_get(type)
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
