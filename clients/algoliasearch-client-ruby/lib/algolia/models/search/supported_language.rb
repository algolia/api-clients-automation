# frozen_string_literal: true

# Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

require "date"
require "time"

module Algolia
  module Search
    class SupportedLanguage
      AF = "af".freeze
      AR = "ar".freeze
      AZ = "az".freeze
      BG = "bg".freeze
      BN = "bn".freeze
      CA = "ca".freeze
      CS = "cs".freeze
      CY = "cy".freeze
      DA = "da".freeze
      DE = "de".freeze
      EL = "el".freeze
      EN = "en".freeze
      EO = "eo".freeze
      ES = "es".freeze
      ET = "et".freeze
      EU = "eu".freeze
      FA = "fa".freeze
      FI = "fi".freeze
      FO = "fo".freeze
      FR = "fr".freeze
      GA = "ga".freeze
      GL = "gl".freeze
      HE = "he".freeze
      HI = "hi".freeze
      HU = "hu".freeze
      HY = "hy".freeze
      ID = "id".freeze
      IS = "is".freeze
      IT = "it".freeze
      JA = "ja".freeze
      KA = "ka".freeze
      KK = "kk".freeze
      KO = "ko".freeze
      KU = "ku".freeze
      KY = "ky".freeze
      LT = "lt".freeze
      LV = "lv".freeze
      MI = "mi".freeze
      MN = "mn".freeze
      MR = "mr".freeze
      MS = "ms".freeze
      MT = "mt".freeze
      NB = "nb".freeze
      NL = "nl".freeze
      NO = "no".freeze
      NS = "ns".freeze
      PL = "pl".freeze
      PS = "ps".freeze
      PT = "pt".freeze
      PT_BR = "pt-br".freeze
      QU = "qu".freeze
      RO = "ro".freeze
      RU = "ru".freeze
      SK = "sk".freeze
      SQ = "sq".freeze
      SV = "sv".freeze
      SW = "sw".freeze
      TA = "ta".freeze
      TE = "te".freeze
      TH = "th".freeze
      TL = "tl".freeze
      TN = "tn".freeze
      TR = "tr".freeze
      TT = "tt".freeze
      UK = "uk".freeze
      UR = "ur".freeze
      UZ = "uz".freeze
      ZH = "zh".freeze

      def self.all_vars
        @all_vars ||= [
          AF,
          AR,
          AZ,
          BG,
          BN,
          CA,
          CS,
          CY,
          DA,
          DE,
          EL,
          EN,
          EO,
          ES,
          ET,
          EU,
          FA,
          FI,
          FO,
          FR,
          GA,
          GL,
          HE,
          HI,
          HU,
          HY,
          ID,
          IS,
          IT,
          JA,
          KA,
          KK,
          KO,
          KU,
          KY,
          LT,
          LV,
          MI,
          MN,
          MR,
          MS,
          MT,
          NB,
          NL,
          NO,
          NS,
          PL,
          PS,
          PT,
          PT_BR,
          QU,
          RO,
          RU,
          SK,
          SQ,
          SV,
          SW,
          TA,
          TE,
          TH,
          TL,
          TN,
          TR,
          TT,
          UK,
          UR,
          UZ,
          ZH
        ].freeze
      end

      # Builds the enum from string
      # @param [String] The enum value in the form of the string
      # @return [String] The enum value
      def self.build_from_hash(value)
        new.build_from_hash(value)
      end

      # Builds the enum from string
      # @param [String] The enum value in the form of the string
      # @return [String] The enum value
      def build_from_hash(value)
        return value if SupportedLanguage.all_vars.include?(value)
        raise "Invalid ENUM value #{value} for class #SupportedLanguage"
      end
    end
  end
end
