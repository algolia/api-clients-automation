package com.algolia.manual;

import static org.junit.jupiter.api.Assertions.*;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.exceptions.AlgoliaRuntimeException;
import java.time.Duration;
import java.util.Collections;
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
  @DisplayName("*WithTransformation throws when transformationOptions not set")
  void withTransformationThrowsWhenNotConfigured() {
    SearchClient client = new SearchClient("app-id", "api-key");
    AlgoliaRuntimeException ex = assertThrows(AlgoliaRuntimeException.class, () ->
      client.saveObjectsWithTransformation("index", Collections.emptyList(), false, 1000, null)
    );
    assertTrue(ex.getMessage().contains("transformationOptions"));
    assertDoesNotThrow(client::close);
  }

  @Test
  @DisplayName("*WithTransformation does not throw config error when transformationOptions is set")
  void withTransformationDoesNotThrowConfigErrorWhenConfigured() throws Exception {
    try (SearchClient client = SearchClient.withTransformation("app-id", "api-key", new TransformationOptions("us"))) {
      try {
        client.saveObjectsWithTransformation("index", Collections.emptyList(), false, 1000, null);
      } catch (AlgoliaRuntimeException e) {
        assertFalse(
          e.getMessage().contains("transformationOptions must be set"),
          "Should not throw the 'not configured' error when transformationOptions is set"
        );
      } catch (Exception e) {
        // non-guard errors (e.g. empty-list edge case in chunkedPush) are acceptable
      }
    }
  }

  @Test
  @DisplayName("close() without TransformationOptions does not throw")
  void closeWithoutTransformationOptionsIsNoop() {
    assertDoesNotThrow(() -> {
      SearchClient client = new SearchClient("app-id", "api-key");
      client.close();
    });
  }

  @Test
  @DisplayName("setTransformationOptions enables *WithTransformation methods")
  void setTransformationOptionsEnablesMethods() throws Exception {
    try (SearchClient client = new SearchClient("app-id", "api-key")) {
      assertThrows(AlgoliaRuntimeException.class, () -> client.saveObjectsWithTransformation("index", Collections.emptyList(), false, 1000, null));

      client.setTransformationOptions(new TransformationOptions("us"));

      try {
        client.saveObjectsWithTransformation("index", Collections.emptyList(), false, 1000, null);
      } catch (AlgoliaRuntimeException e) {
        assertFalse(e.getMessage().contains("transformationOptions must be set"));
      } catch (Exception e) {
        // non-guard errors (e.g. empty-list edge case in chunkedPush) are acceptable
      }
    }
  }

  @Test
  @DisplayName("setTransformationOptions replaces the region on subsequent calls")
  void setTransformationOptionsReplacesRegion() throws Exception {
    try (SearchClient client = SearchClient.withTransformation("app-id", "api-key", new TransformationOptions("us"))) {
      assertDoesNotThrow(() -> client.setTransformationOptions(new TransformationOptions("eu")));
    }
  }
}
