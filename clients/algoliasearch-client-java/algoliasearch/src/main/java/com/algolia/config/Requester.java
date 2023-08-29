package com.algolia.config;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.Closeable;

public interface Requester extends Closeable {
  <T> T execute(HttpRequest httpRequest, RequestOptions requestOptions, Class<?> returnType, Class<?> innerType);

  <T> T execute(HttpRequest httpRequest, RequestOptions requestOptions, TypeReference<?> returnType);
}
