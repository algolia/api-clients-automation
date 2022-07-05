package com.algolia.utils;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JSON {

  private static ObjectMapper mapper;

  static {
    mapper = createMapper();
  }

  public static ObjectMapper createMapper() {
    mapper = JsonMapper.builder().disable(MapperFeature.ALLOW_COERCION_OF_SCALARS).build();
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    mapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    mapper.enable(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE);
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
    mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    // mapper.setDateFormat(new RFC3339DateFormat());
    mapper.registerModule(new JavaTimeModule());
    return mapper;
  }

  // Suppress default constructor for noninstantiability
  private JSON() {
    throw new AssertionError();
  }

  public static ObjectMapper getMapper() {
    return mapper;
  }
}
