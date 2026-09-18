package com.algolia.manual;

import static org.junit.jupiter.api.Assertions.*;

import com.algolia.api.SearchClient;
import com.algolia.config.ClientOptions;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * Pins the wire contract from API-141 / CR-12179: request bodies are pre-serialized to UTF-8 bytes
 * and declare their exact length, so requests carry {@code Content-Length} instead of {@code
 * Transfer-Encoding: chunked}.
 */
class RequestBodyContentLengthTest {

  static final class BodyCaptureInterceptor implements Interceptor {

    Long contentLength;
    String bodyUtf8;

    @Override
    public Response intercept(Chain chain) throws IOException {
      RequestBody body = chain.request().body();
      if (body != null) {
        contentLength = body.contentLength();
        Buffer buffer = new Buffer();
        body.writeTo(buffer);
        bodyUtf8 = buffer.readUtf8();
      }
      return new Response.Builder()
        .code(200)
        .request(chain.request())
        .protocol(Protocol.HTTP_2)
        .message("")
        .body(ResponseBody.create("{}", MediaType.parse("application/json")))
        .build();
    }
  }

  private static SearchClient clientWith(Interceptor interceptor) {
    return new SearchClient(
      "appId",
      "apiKey",
      ClientOptions.builder().setRequesterConfig(requester -> requester.addInterceptor(interceptor)).build()
    );
  }

  @Test
  @Timeout(10)
  @DisplayName("request bodies declare their exact UTF-8 byte length instead of chunked encoding")
  void requestBodiesDeclareExactUtf8Length() throws Exception {
    BodyCaptureInterceptor capture = new BodyCaptureInterceptor();
    Map<String, String> payload = new LinkedHashMap<String, String>();
    payload.put("message", "café");

    try (SearchClient client = clientWith(capture)) {
      client.customPost("1/test", null, payload);
      String expected = "{\"message\":\"café\"}";
      assertEquals(expected, capture.bodyUtf8);
      assertEquals(Long.valueOf(expected.getBytes(StandardCharsets.UTF_8).length), capture.contentLength);
    }
  }

  @Test
  @Timeout(10)
  @DisplayName("bodyless POST sends a fixed-length empty JSON object")
  void bodylessPostSendsFixedLengthEmptyObject() throws Exception {
    BodyCaptureInterceptor capture = new BodyCaptureInterceptor();

    try (SearchClient client = clientWith(capture)) {
      client.customPost("1/test");
      assertEquals("{}", capture.bodyUtf8);
      assertEquals(Long.valueOf(2L), capture.contentLength);
    }
  }
}
