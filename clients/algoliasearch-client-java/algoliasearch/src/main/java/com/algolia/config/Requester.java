package com.algolia.config;

import okhttp3.Call;
import okhttp3.Request;

public interface Requester extends AutoCloseable {
  Call newCall(Request request);
}
