package com.algolia.manual;

import static org.junit.jupiter.api.Assertions.*;

import com.algolia.api.AgentStudioClient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Instant;
import java.util.Base64;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ForgeSecuredUserTokenTest {

  private static final ObjectMapper mapper = new ObjectMapper();

  @Test
  @DisplayName("forgeSecuredUserToken with default expiry")
  void testForgeSecuredUserToken() throws Exception {
    AgentStudioClient client = new AgentStudioClient("test-app-id", "test-api-key");

    long beforeEpoch = Instant.now().getEpochSecond();
    String token = client.forgeSecuredUserToken("my-secret-key", "my-key-id", "user-123");
    long afterEpoch = Instant.now().getEpochSecond();

    String[] parts = token.split("\\.");
    assertEquals(3, parts.length, "JWT must have 3 parts");

    // Decode and verify header
    Map<String, Object> header = mapper.readValue(
      Base64.getUrlDecoder().decode(parts[0]),
      new TypeReference<Map<String, Object>>() {}
    );
    assertEquals("HS256", header.get("alg"));
    assertEquals("JWT", header.get("typ"));
    assertEquals("my-key-id", header.get("kid"));

    // Decode and verify payload
    Map<String, Object> payload = mapper.readValue(
      Base64.getUrlDecoder().decode(parts[1]),
      new TypeReference<Map<String, Object>>() {}
    );
    assertEquals("user-123", payload.get("sub"));
    long exp = ((Number) payload.get("exp")).longValue();
    long expectedExpMin = beforeEpoch + 24 * 3600;
    long expectedExpMax = afterEpoch + 24 * 3600;
    assertTrue(exp >= expectedExpMin && exp <= expectedExpMax + 5,
      "exp should be within 5 seconds of now + 24*3600, got " + exp);

    // Independently verify HMAC-SHA256 signature
    Mac mac = Mac.getInstance("HmacSHA256");
    mac.init(new SecretKeySpec("my-secret-key".getBytes(java.nio.charset.StandardCharsets.UTF_8), "HmacSHA256"));
    byte[] expectedSig = mac.doFinal((parts[0] + "." + parts[1]).getBytes(java.nio.charset.StandardCharsets.UTF_8));
    String expectedSigB64 = Base64.getUrlEncoder().withoutPadding().encodeToString(expectedSig);
    assertEquals(expectedSigB64, parts[2], "Signature must match independently computed HMAC-SHA256");

    client.close();
  }

  @Test
  @DisplayName("forgeSecuredUserToken with custom expiry")
  void testForgeSecuredUserTokenCustomExpiry() throws Exception {
    AgentStudioClient client = new AgentStudioClient("test-app-id", "test-api-key");

    long beforeEpoch = Instant.now().getEpochSecond();
    String token = client.forgeSecuredUserToken("my-secret-key", "my-key-id", "user-456", 3600);
    long afterEpoch = Instant.now().getEpochSecond();

    String[] parts = token.split("\\.");
    assertEquals(3, parts.length, "JWT must have 3 parts");

    // Decode and verify header
    Map<String, Object> header = mapper.readValue(
      Base64.getUrlDecoder().decode(parts[0]),
      new TypeReference<Map<String, Object>>() {}
    );
    assertEquals("HS256", header.get("alg"));
    assertEquals("JWT", header.get("typ"));
    assertEquals("my-key-id", header.get("kid"));

    // Decode and verify payload
    Map<String, Object> payload = mapper.readValue(
      Base64.getUrlDecoder().decode(parts[1]),
      new TypeReference<Map<String, Object>>() {}
    );
    assertEquals("user-456", payload.get("sub"));
    long exp = ((Number) payload.get("exp")).longValue();
    long expectedExpMin = beforeEpoch + 3600;
    long expectedExpMax = afterEpoch + 3600;
    assertTrue(exp >= expectedExpMin && exp <= expectedExpMax + 5,
      "exp should be within 5 seconds of now + 3600, got " + exp);

    // Independently verify HMAC-SHA256 signature
    Mac mac = Mac.getInstance("HmacSHA256");
    mac.init(new SecretKeySpec("my-secret-key".getBytes(java.nio.charset.StandardCharsets.UTF_8), "HmacSHA256"));
    byte[] expectedSig = mac.doFinal((parts[0] + "." + parts[1]).getBytes(java.nio.charset.StandardCharsets.UTF_8));
    String expectedSigB64 = Base64.getUrlEncoder().withoutPadding().encodeToString(expectedSig);
    assertEquals(expectedSigB64, parts[2], "Signature must match independently computed HMAC-SHA256");

    client.close();
  }
}
