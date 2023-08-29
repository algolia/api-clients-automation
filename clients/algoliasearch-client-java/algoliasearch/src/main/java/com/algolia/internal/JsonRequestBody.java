package com.algolia.internal;

import java.io.IOException;
import java.io.InputStream;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class JsonRequestBody extends RequestBody {

  private static final MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json");

  private final Source source;

  JsonRequestBody(InputStream stream) {
    this.source = Okio.source(stream);
  }

  @Nullable
  @Override
  public MediaType contentType() {
    return null;
  }

  @Override
  public void writeTo(@NotNull BufferedSink bufferedSink) throws IOException {
    bufferedSink.writeAll(source);
  }
}
