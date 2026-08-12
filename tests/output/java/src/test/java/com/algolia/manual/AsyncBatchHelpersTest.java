package com.algolia.manual;

import static org.junit.jupiter.api.Assertions.*;

import com.algolia.api.SearchClient;
import com.algolia.config.ClientOptions;
import com.algolia.config.HttpRequest;
import com.algolia.config.RequestOptions;
import com.algolia.config.Requester;
import com.algolia.exceptions.AlgoliaApiException;
import com.algolia.exceptions.AlgoliaRuntimeException;
import com.algolia.model.search.Action;
import com.algolia.model.search.BatchRequest;
import com.algolia.model.search.BatchResponse;
import com.algolia.model.search.BatchWriteParams;
import com.algolia.model.search.GetTaskResponse;
import com.algolia.model.search.TaskStatus;
import com.algolia.utils.ChunkedHelperOptions;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * Regression tests for CR-11794: Java v4 async batch helpers ({@code chunkedBatchAsync}, {@code
 * saveObjectsAsync}, {@code partialUpdateObjectsAsync}, {@code deleteObjectsAsync}) and the sync
 * reimplementation on the async core (including {@code waitForTasks} polling after all batches and
 * the {@code deleteObjects(..., RequestOptions)} forward fix).
 */
class AsyncBatchHelpersTest {

  static final String INDEX = "my-index";

  /** Snapshot of one call through the stubbed {@link Requester}. */
  static final class CapturedRequest {

    final HttpRequest httpRequest;
    final RequestOptions requestOptions;
    final String path;
    final String method;

    /** Non-null only for {@code /batch} requests. */
    final BatchWriteParams batchBody;

    CapturedRequest(HttpRequest httpRequest, RequestOptions requestOptions) {
      this.httpRequest = httpRequest;
      this.requestOptions = requestOptions;
      this.path = httpRequest.getPath();
      this.method = httpRequest.getMethod();
      if (path != null && path.contains("/batch")) {
        this.batchBody = (BatchWriteParams) httpRequest.getBody();
      } else {
        this.batchBody = null;
      }
    }
  }

  /**
   * Requester stub that records batch/task traffic, tracks in-flight concurrency, optionally gates
   * completion, and can fail on the Nth {@code /batch} call. No real HTTP is performed.
   */
  static class CapturingRequester implements Requester {

    final List<CapturedRequest> captured = Collections.synchronizedList(new ArrayList<CapturedRequest>());
    final AtomicInteger currentInFlight = new AtomicInteger();
    final AtomicInteger maxInFlight = new AtomicInteger();
    final AtomicInteger nextTaskId = new AtomicInteger(1);
    final AtomicInteger batchCallCount = new AtomicInteger();

    volatile CyclicBarrier gate;
    volatile CountDownLatch latch;

    /** 1-based; {@code 0} means never fail. */
    volatile int failOnBatchCall;

    void setGate(CyclicBarrier gate) {
      this.gate = gate;
    }

    void setLatch(CountDownLatch latch) {
      this.latch = latch;
    }

    void setFailOnBatchCall(int failOnBatchCall) {
      this.failOnBatchCall = failOnBatchCall;
    }

    List<CapturedRequest> batchRequests() {
      List<CapturedRequest> batches = new ArrayList<CapturedRequest>();
      synchronized (captured) {
        for (CapturedRequest c : captured) {
          if (c.batchBody != null) {
            batches.add(c);
          }
        }
      }
      return batches;
    }

    private Object handle(HttpRequest httpRequest, RequestOptions requestOptions) throws Exception {
      CapturedRequest capturedRequest = new CapturedRequest(httpRequest, requestOptions);
      captured.add(capturedRequest);

      String path = httpRequest.getPath();
      boolean isBatch = path != null && path.contains("/batch");
      boolean isTask = path != null && path.contains("/task/");

      if (isBatch) {
        currentInFlight.incrementAndGet();
        maxInFlight.updateAndGet(prev -> Math.max(prev, currentInFlight.get()));
        try {
          awaitGates();
          int n = batchCallCount.incrementAndGet();
          if (failOnBatchCall > 0 && n == failOnBatchCall) {
            throw new AlgoliaApiException("simulated batch failure on call " + n, 500);
          }
          return new BatchResponse().setTaskID((long) nextTaskId.getAndIncrement());
        } finally {
          currentInFlight.decrementAndGet();
        }
      }

      if (isTask) {
        awaitGates();
        return new GetTaskResponse().setStatus(TaskStatus.PUBLISHED);
      }

      awaitGates();
      throw new AlgoliaRuntimeException("unexpected path in CapturingRequester: " + path);
    }

    private void awaitGates() throws Exception {
      CyclicBarrier barrier = this.gate;
      if (barrier != null) {
        barrier.await(5, TimeUnit.SECONDS);
      }
      CountDownLatch countDownLatch = this.latch;
      if (countDownLatch != null) {
        if (!countDownLatch.await(5, TimeUnit.SECONDS)) {
          throw new AlgoliaRuntimeException("CapturingRequester latch timed out");
        }
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T execute(HttpRequest httpRequest, RequestOptions requestOptions, Class<?> returnType, Class<?> innerType) {
      try {
        return (T) handle(httpRequest, requestOptions);
      } catch (AlgoliaRuntimeException e) {
        throw e;
      } catch (Exception e) {
        throw new AlgoliaRuntimeException(e);
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T execute(HttpRequest httpRequest, RequestOptions requestOptions, TypeReference<?> returnType) {
      try {
        return (T) handle(httpRequest, requestOptions);
      } catch (AlgoliaRuntimeException e) {
        throw e;
      } catch (Exception e) {
        throw new AlgoliaRuntimeException(e);
      }
    }

    @Override
    public void close() {}
  }

  static Map<String, String> record(String objectID) {
    Map<String, String> map = new HashMap<String, String>();
    map.put("objectID", objectID);
    return map;
  }

  static List<Map<String, String>> records(int count) {
    List<Map<String, String>> list = new ArrayList<Map<String, String>>();
    for (int i = 0; i < count; i++) {
      list.add(record("id-" + i));
    }
    return list;
  }

  static SearchClient client(CapturingRequester requester) {
    return new SearchClient("app-id", "api-key", ClientOptions.builder().setRequester(requester).build());
  }

  static void assertRequestSequenceEqual(List<CapturedRequest> expected, List<CapturedRequest> actual) {
    assertEquals(expected.size(), actual.size(), "request count");
    for (int i = 0; i < expected.size(); i++) {
      CapturedRequest e = expected.get(i);
      CapturedRequest a = actual.get(i);
      assertEquals(e.path, a.path, "path at index " + i);
      assertEquals(e.method, a.method, "method at index " + i);
      assertEquals(e.batchBody, a.batchBody, "BatchWriteParams at index " + i);
    }
  }

  @Test
  @Timeout(15)
  @DisplayName("chunkedBatchAsync splits into full chunks plus trailing partial (CR-11794)")
  void chunkedBatchAsyncSplitsChunksIncludingTrailingPartial() throws Exception {
    CapturingRequester requester = new CapturingRequester();
    List<Map<String, String>> objects = records(7);

    try (SearchClient client = client(requester)) {
      List<BatchResponse> responses = client.chunkedBatchAsync(INDEX, objects, Action.ADD_OBJECT, 3, null, null).get(10, TimeUnit.SECONDS);

      assertEquals(3, responses.size());
      List<CapturedRequest> batches = requester.batchRequests();
      assertEquals(3, batches.size());
      assertEquals(3, batches.get(0).batchBody.getRequests().size());
      assertEquals(3, batches.get(1).batchBody.getRequests().size());
      assertEquals(1, batches.get(2).batchBody.getRequests().size());

      assertEquals(record("id-0"), batches.get(0).batchBody.getRequests().get(0).getBody());
      assertEquals(record("id-2"), batches.get(0).batchBody.getRequests().get(2).getBody());
      assertEquals(record("id-3"), batches.get(1).batchBody.getRequests().get(0).getBody());
      assertEquals(record("id-6"), batches.get(2).batchBody.getRequests().get(0).getBody());

      for (CapturedRequest batch : batches) {
        assertTrue(batch.path.contains("/1/indexes/" + INDEX + "/batch"));
        assertEquals("POST", batch.method);
        for (BatchRequest req : batch.batchBody.getRequests()) {
          assertEquals(Action.ADD_OBJECT, req.getAction());
        }
      }
    }
  }

  @Test
  @Timeout(10)
  @DisplayName("chunkedBatchAsync empty Iterable completes with empty list and no HTTP (CR-11794)")
  void chunkedBatchAsyncEmptyIterableMakesNoRequests() throws Exception {
    CapturingRequester requester = new CapturingRequester();

    try (SearchClient client = client(requester)) {
      List<BatchResponse> responses = client
        .chunkedBatchAsync(INDEX, Collections.<Map<String, String>>emptyList(), Action.ADD_OBJECT, 3, null, null)
        .get(5, TimeUnit.SECONDS);

      assertTrue(responses.isEmpty());
      assertTrue(requester.captured.isEmpty());
    }
  }

  @Test
  @Timeout(10)
  @DisplayName("batchSize < 1 throws AlgoliaRuntimeException synchronously on sync and async (CR-11794)")
  void chunkedBatchRejectsNonPositiveBatchSize() throws Exception {
    CapturingRequester requester = new CapturingRequester();
    List<Map<String, String>> objects = records(1);

    try (SearchClient client = client(requester)) {
      assertThrows(AlgoliaRuntimeException.class, () -> client.chunkedBatchAsync(INDEX, objects, Action.ADD_OBJECT, 0, null, null));
      assertThrows(AlgoliaRuntimeException.class, () -> client.chunkedBatch(INDEX, objects, Action.ADD_OBJECT, false, 0, null, null));
      assertTrue(requester.captured.isEmpty(), "validation must happen before any HTTP");
    }
  }

  @Test
  @Timeout(20)
  @DisplayName("async core is sequential by default (maxConcurrency=1) (CR-11794)")
  void asyncCoreIsSequentialByDefault() throws Exception {
    CapturingRequester requester = new CapturingRequester();
    // 10 objects / batchSize 2 → 5 chunks (≥4)
    List<Map<String, String>> objects = records(10);

    try (SearchClient client = client(requester)) {
      client.chunkedBatchAsync(INDEX, objects, Action.ADD_OBJECT, 2, null, null).get(15, TimeUnit.SECONDS);

      List<CapturedRequest> batches = requester.batchRequests();
      assertTrue(batches.size() >= 4, "expected ≥4 chunks, got " + batches.size());
      assertEquals(1, requester.maxInFlight.get(), "default maxConcurrency must keep in-flight at 1");

      for (int i = 0; i < batches.size(); i++) {
        assertEquals(record("id-" + i * 2), batches.get(i).batchBody.getRequests().get(0).getBody());
      }
    }
  }

  @Test
  @Timeout(30)
  @DisplayName("maxConcurrency bounds in-flight /batch requests per wave (CR-11794)")
  void maxConcurrencyBoundsInFlightRequests() throws Exception {
    CapturingRequester requester = new CapturingRequester();
    CyclicBarrier barrier = new CyclicBarrier(3);
    requester.setGate(barrier);
    // 9 objects / batchSize 3 / maxConcurrency 3 → one wave of exactly 3 concurrent batches
    List<Map<String, String>> objects = records(9);
    ChunkedHelperOptions chunkedOptions = new ChunkedHelperOptions().setMaxConcurrency(3);

    try (SearchClient client = client(requester)) {
      client.chunkedBatchAsync(INDEX, objects, Action.ADD_OBJECT, 3, null, chunkedOptions).get(20, TimeUnit.SECONDS);

      assertEquals(3, requester.maxInFlight.get(), "must observe exactly 3 concurrent in-flight batches");
      assertEquals(3, requester.batchRequests().size());
    }
  }

  @Test
  @Timeout(15)
  @DisplayName("failed chunk fails the returned future with AlgoliaApiException cause (CR-11794)")
  void failedChunkFailsFutureWithAlgoliaApiExceptionCause() throws Exception {
    CapturingRequester requester = new CapturingRequester();
    requester.setFailOnBatchCall(2);
    List<Map<String, String>> objects = records(5); // batchSize 2 → chunks of 2/2/1

    try (SearchClient client = client(requester)) {
      ExecutionException thrown = assertThrows(ExecutionException.class, () ->
        client.chunkedBatchAsync(INDEX, objects, Action.ADD_OBJECT, 2, null, null).get(10, TimeUnit.SECONDS)
      );
      assertTrue(thrown.getCause() instanceof AlgoliaApiException, "cause must be AlgoliaApiException, got " + thrown.getCause());
    }
  }

  @Test
  @Timeout(20)
  @DisplayName("sync saveObjects emits identical request sequence to saveObjectsAsync (CR-11794)")
  void syncHelperEmitsIdenticalRequestsToAsync() throws Exception {
    List<Map<String, String>> objects = records(7);

    CapturingRequester asyncRequester = new CapturingRequester();
    CapturingRequester syncRequester = new CapturingRequester();

    try (SearchClient asyncClient = client(asyncRequester); SearchClient syncClient = client(syncRequester)) {
      asyncClient.saveObjectsAsync(INDEX, objects, 3, null, null).get(10, TimeUnit.SECONDS);
      syncClient.saveObjects(INDEX, objects, false, 3, null, null);

      assertRequestSequenceEqual(asyncRequester.batchRequests(), syncRequester.batchRequests());
    }

    CapturingRequester failingRequester = new CapturingRequester();
    failingRequester.setFailOnBatchCall(1);
    try (SearchClient client = client(failingRequester)) {
      AlgoliaApiException thrown = assertThrows(AlgoliaApiException.class, () -> client.saveObjects(INDEX, objects, false, 3, null, null));
      assertEquals(500, thrown.getStatusCode());
    }
  }

  @Test
  @Timeout(20)
  @DisplayName("sync waitForTasks polls getTask only after all /batch calls (CR-11794)")
  void syncWaitForTasksPollsAfterAllBatches() throws Exception {
    CapturingRequester requester = new CapturingRequester();
    List<Map<String, String>> objects = records(7); // batchSize 3 → 3 batches → 3 getTask

    try (SearchClient client = client(requester)) {
      client.saveObjects(INDEX, objects, true, 3, null, null);

      List<CapturedRequest> all = new ArrayList<CapturedRequest>(requester.captured);
      assertTrue(all.size() >= 6, "expected 3 batch + 3 getTask, got " + all.size());

      int lastBatchIndex = -1;
      int firstTaskIndex = -1;
      for (int i = 0; i < all.size(); i++) {
        CapturedRequest c = all.get(i);
        if (c.batchBody != null) {
          lastBatchIndex = i;
        } else if (c.path != null && c.path.contains("/task/")) {
          if (firstTaskIndex < 0) {
            firstTaskIndex = i;
          }
          assertEquals("GET", c.method);
        }
      }

      assertEquals(3, requester.batchRequests().size());
      assertTrue(firstTaskIndex > lastBatchIndex, "all getTask polls must come after all /batch calls");
    }
  }

  @Test
  @Timeout(15)
  @DisplayName("public async helpers map to the correct Action values (CR-11794)")
  void publicAsyncHelpersMapActionsCorrectly() throws Exception {
    List<Map<String, String>> objects = Arrays.asList(record("a"), record("b"));

    CapturingRequester saveRequester = new CapturingRequester();
    try (SearchClient client = client(saveRequester)) {
      client.saveObjectsAsync(INDEX, objects, 10, null, null).get(5, TimeUnit.SECONDS);
      assertEquals(Action.ADD_OBJECT, saveRequester.batchRequests().get(0).batchBody.getRequests().get(0).getAction());
    }

    CapturingRequester createRequester = new CapturingRequester();
    try (SearchClient client = client(createRequester)) {
      client.partialUpdateObjectsAsync(INDEX, objects, true, 10, null, null).get(5, TimeUnit.SECONDS);
      assertEquals(Action.PARTIAL_UPDATE_OBJECT, createRequester.batchRequests().get(0).batchBody.getRequests().get(0).getAction());
    }

    CapturingRequester noCreateRequester = new CapturingRequester();
    try (SearchClient client = client(noCreateRequester)) {
      client.partialUpdateObjectsAsync(INDEX, objects, false, 10, null, null).get(5, TimeUnit.SECONDS);
      assertEquals(
        Action.PARTIAL_UPDATE_OBJECT_NO_CREATE,
        noCreateRequester.batchRequests().get(0).batchBody.getRequests().get(0).getAction()
      );
    }
  }

  @Test
  @Timeout(15)
  @DisplayName("deleteObjectsAsync wraps IDs as {objectID} with DELETE_OBJECT (CR-11794)")
  void deleteObjectsAsyncBuildsDeleteRequests() throws Exception {
    CapturingRequester requester = new CapturingRequester();
    List<String> ids = Arrays.asList("x", "y", "z");

    try (SearchClient client = client(requester)) {
      client.deleteObjectsAsync(INDEX, ids, 2, null, null).get(5, TimeUnit.SECONDS);

      List<CapturedRequest> batches = requester.batchRequests();
      assertEquals(2, batches.size());
      assertEquals(2, batches.get(0).batchBody.getRequests().size());
      assertEquals(1, batches.get(1).batchBody.getRequests().size());

      BatchRequest first = batches.get(0).batchBody.getRequests().get(0);
      assertEquals(Action.DELETE_OBJECT, first.getAction());
      assertEquals(record("x"), first.getBody());
      assertEquals(record("y"), batches.get(0).batchBody.getRequests().get(1).getBody());
      assertEquals(record("z"), batches.get(1).batchBody.getRequests().get(0).getBody());
    }
  }

  @Test
  @Timeout(10)
  @DisplayName("deleteObjects(index, ids, requestOptions) forwards RequestOptions (CR-11794)")
  void deleteObjectsForwardsRequestOptions() throws Exception {
    CapturingRequester requester = new CapturingRequester();
    RequestOptions requestOptions = new RequestOptions()
      .addExtraHeader("X-Test-Forward", "cr-11794")
      .addExtraQueryParameters("forwarded", "yes");

    try (SearchClient client = client(requester)) {
      client.deleteObjects(INDEX, Arrays.asList("obj-1"), requestOptions);

      List<CapturedRequest> batches = requester.batchRequests();
      assertEquals(1, batches.size());
      // RequestOptions are applied by HttpRequester at send time; at the Requester boundary they
      // arrive as the execute(..., requestOptions, ...) argument (not merged onto HttpRequest).
      assertNotNull(batches.get(0).requestOptions, "requestOptions must be forwarded to the requester");
      assertEquals("cr-11794", batches.get(0).requestOptions.getHeaders().get("x-test-forward"));
      assertEquals("yes", batches.get(0).requestOptions.getQueryParameters().get("forwarded"));
    }
  }
}
