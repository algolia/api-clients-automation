package com.algolia.manual;

import static org.junit.jupiter.api.Assertions.*;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.exceptions.AlgoliaRuntimeException;
import java.lang.reflect.Field;
import java.time.Duration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TransformationOptionsTest {

  @Test
  @DisplayName("TransformationOptions requires a non-empty region")
  void regionRequired() {
    assertThrows(AlgoliaRuntimeException.class, () -> new TransformationOptions(""));
    assertThrows(AlgoliaRuntimeException.class, () -> new TransformationOptions(null));
  }

  @Test
  @DisplayName("TransformationOptions with only region has null clientOptions")
  void regionOnlyHasNullClientOptions() {
    TransformationOptions opts = new TransformationOptions("us");
    assertEquals("us", opts.getRegion());
    assertNull(opts.getClientOptions());
  }

  @Test
  @DisplayName("TransformationOptions with ClientOptions forwards them")
  void clientOptionsForwarded() {
    ClientOptions ingestionOptions = ClientOptions.builder().setReadTimeout(Duration.ofSeconds(50)).build();
    TransformationOptions opts = new TransformationOptions("eu", ingestionOptions);
    assertEquals("eu", opts.getRegion());
    assertSame(ingestionOptions, opts.getClientOptions());
  }

  @Test
  @DisplayName("ingestion transporter is null when TransformationOptions not set")
  void ingestionTransporterNullWithoutConfig() throws Exception {
    try (SearchClient client = new SearchClient("app-id", "api-key")) {
      assertNull(ingestionTransporter(client));
    }
  }

  @Test
  @DisplayName("setTransformationOptions creates the ingestion transporter")
  void setTransformationOptionsCreatesIngestionTransporter() throws Exception {
    try (SearchClient client = new SearchClient("app-id", "api-key")) {
      assertNull(ingestionTransporter(client));
      client.setTransformationOptions(new TransformationOptions("us"));
      assertNotNull(ingestionTransporter(client));
    }
  }

  @Test
  @DisplayName("setTransformationOptions replaces the transporter on subsequent calls")
  void setTransformationOptionsReplacesPreviousTransporter() throws Exception {
    try (SearchClient client = SearchClient.withTransformation("app-id", "api-key", new TransformationOptions("us"))) {
      Object previous = ingestionTransporter(client);
      assertNotNull(previous);
      client.setTransformationOptions(new TransformationOptions("eu"));
      Object next = ingestionTransporter(client);
      assertNotNull(next);
      assertNotSame(previous, next);
    }
  }

  @Test
  @DisplayName("close() without TransformationOptions does not throw")
  void closeWithoutTransformationOptionsIsNoop() {
    assertDoesNotThrow(() -> new SearchClient("app-id", "api-key").close());
  }

  @Test
  @DisplayName("close() with TransformationOptions closes the ingestion transporter")
  void closeWithTransformationOptionsClosesTransporter() throws Exception {
    SearchClient client = SearchClient.withTransformation("app-id", "api-key", new TransformationOptions("us"));
    assertNotNull(ingestionTransporter(client));
    assertDoesNotThrow(client::close);
  }

  private static Object ingestionTransporter(SearchClient client) throws Exception {
    Field field = SearchClient.class.getDeclaredField("ingestionTransporter");
    field.setAccessible(true);
    return field.get(client);
  }
}
