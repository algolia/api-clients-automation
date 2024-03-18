// Code generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost
// - read more on https://github.com/algolia/api-clients-automation. DO NOT EDIT.

package com.algolia.model.recommend;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;

/** ISO code for a supported language. */
public enum SupportedLanguage {
  AF("af"),

  AR("ar"),

  AZ("az"),

  BG("bg"),

  BN("bn"),

  CA("ca"),

  CS("cs"),

  CY("cy"),

  DA("da"),

  DE("de"),

  EL("el"),

  EN("en"),

  EO("eo"),

  ES("es"),

  ET("et"),

  EU("eu"),

  FA("fa"),

  FI("fi"),

  FO("fo"),

  FR("fr"),

  GA("ga"),

  GL("gl"),

  HE("he"),

  HI("hi"),

  HU("hu"),

  HY("hy"),

  ID("id"),

  IS("is"),

  IT("it"),

  JA("ja"),

  KA("ka"),

  KK("kk"),

  KO("ko"),

  KU("ku"),

  KY("ky"),

  LT("lt"),

  LV("lv"),

  MI("mi"),

  MN("mn"),

  MR("mr"),

  MS("ms"),

  MT("mt"),

  NB("nb"),

  NL("nl"),

  NO("no"),

  NS("ns"),

  PL("pl"),

  PS("ps"),

  PT("pt"),

  PT_BR("pt-br"),

  QU("qu"),

  RO("ro"),

  RU("ru"),

  SK("sk"),

  SQ("sq"),

  SV("sv"),

  SW("sw"),

  TA("ta"),

  TE("te"),

  TH("th"),

  TL("tl"),

  TN("tn"),

  TR("tr"),

  TT("tt"),

  UK("uk"),

  UR("ur"),

  UZ("uz"),

  ZH("zh");

  private final String value;

  SupportedLanguage(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static SupportedLanguage fromValue(String value) {
    for (SupportedLanguage b : SupportedLanguage.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}
