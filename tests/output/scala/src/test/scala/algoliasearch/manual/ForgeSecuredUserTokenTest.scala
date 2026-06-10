package algoliasearch.manual

import algoliasearch.api.AgentStudioClient

import java.nio.charset.StandardCharsets
import java.util.Base64
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

import org.scalatest.funsuite.AnyFunSuite

class ForgeSecuredUserTokenTest extends AnyFunSuite {

  private def base64UrlDecode(s: String): Array[Byte] = {
    val padded = s.length % 4 match {
      case 2 => s + "=="
      case 3 => s + "="
      case _ => s
    }
    Base64.getUrlDecoder.decode(padded)
  }

  private def base64UrlEncode(data: Array[Byte]): String =
    Base64.getUrlEncoder.withoutPadding.encodeToString(data)

  test("forgeSecuredUserToken with default expiry") {
    val client = AgentStudioClient(appId = "appID", apiKey = "apiKey")

    val token = client.forgeSecuredUserToken("my-secret-key", "my-key-id", "user-123")

    val parts = token.split('.')
    assert(parts.length === 3)

    val headerJson = new String(base64UrlDecode(parts(0)), StandardCharsets.UTF_8)
    assert(headerJson.contains("\"alg\":\"HS256\""))
    assert(headerJson.contains("\"typ\":\"JWT\""))
    assert(headerJson.contains("\"kid\":\"my-key-id\""))

    val payloadJson = new String(base64UrlDecode(parts(1)), StandardCharsets.UTF_8)
    assert(payloadJson.contains("\"sub\":\"user-123\""))
    val expPattern = """"exp":(\d+)""".r
    val exp = expPattern.findFirstMatchIn(payloadJson).get.group(1).toLong
    val expectedExp = java.time.Instant.now.getEpochSecond + 24 * 3600
    assert(math.abs(exp - expectedExp) < 5, s"exp $exp should be within 5s of $expectedExp")

    val mac = Mac.getInstance("HmacSHA256")
    mac.init(new SecretKeySpec("my-secret-key".getBytes(StandardCharsets.UTF_8), "HmacSHA256"))
    val expectedSig = base64UrlEncode(mac.doFinal(s"${parts(0)}.${parts(1)}".getBytes(StandardCharsets.UTF_8)))
    assert(parts(2) === expectedSig)
  }

  test("forgeSecuredUserToken with custom expiry") {
    val client = AgentStudioClient(appId = "appID", apiKey = "apiKey")

    val token = client.forgeSecuredUserToken("my-secret-key", "my-key-id", "user-456", 3600)

    val parts = token.split('.')
    val payloadJson = new String(base64UrlDecode(parts(1)), StandardCharsets.UTF_8)
    val expPattern = """"exp":(\d+)""".r
    val exp = expPattern.findFirstMatchIn(payloadJson).get.group(1).toLong
    val expectedExp = java.time.Instant.now.getEpochSecond + 3600
    assert(math.abs(exp - expectedExp) < 5, s"exp $exp should be within 5s of $expectedExp")
  }
}
