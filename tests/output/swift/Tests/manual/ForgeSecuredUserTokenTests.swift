import Foundation
import XCTest

@testable import AlgoliaAgentStudio
@testable import AlgoliaCore

final class ForgeSecuredUserTokenTests: XCTestCase {
    func testForgeSecuredUserToken() throws {
        let client = try AgentStudioClient(appID: "appID", apiKey: "apiKey")

        let token = client.forgeSecuredUserToken(
            secretKey: "my-secret-key",
            secretKeyId: "my-key-id",
            userId: "user-123"
        )

        let parts = token.split(separator: ".").map(String.init)
        XCTAssertEqual(parts.count, 3)

        let headerData = try XCTUnwrap(Data(base64URLDecoded: parts[0]))
        let header = try XCTUnwrap(try JSONSerialization.jsonObject(with: headerData) as? [String: Any])
        XCTAssertEqual(header["alg"] as? String, "HS256")
        XCTAssertEqual(header["typ"] as? String, "JWT")
        XCTAssertEqual(header["kid"] as? String, "my-key-id")

        let payloadData = try XCTUnwrap(Data(base64URLDecoded: parts[1]))
        let payload = try XCTUnwrap(try JSONSerialization.jsonObject(with: payloadData) as? [String: Any])
        XCTAssertEqual(payload["sub"] as? String, "user-123")
        let exp = try XCTUnwrap(payload["exp"] as? Int)
        let expectedExp = Int(Date().timeIntervalSince1970) + 24 * 3600
        XCTAssertEqual(Double(exp), Double(expectedExp), accuracy: 5)

        let hmacHex = "\(parts[0]).\(parts[1])".hmac256(withKey: "my-secret-key")
        let hmacBytes = stride(from: 0, to: hmacHex.count, by: 2).map {
            UInt8(hmacHex[hmacHex.index(hmacHex.startIndex, offsetBy: $0)..<hmacHex.index(hmacHex.startIndex, offsetBy: $0 + 2)], radix: 16)!
        }
        let expectedSig = Data(hmacBytes).base64URLEncodedString()
        XCTAssertEqual(parts[2], expectedSig)
    }

    func testForgeSecuredUserTokenCustomExpiry() throws {
        let client = try AgentStudioClient(appID: "appID", apiKey: "apiKey")

        let token = client.forgeSecuredUserToken(
            secretKey: "my-secret-key",
            secretKeyId: "my-key-id",
            userId: "user-456",
            expiresIn: 3600
        )

        let parts = token.split(separator: ".").map(String.init)

        let payloadData = try XCTUnwrap(Data(base64URLDecoded: parts[1]))
        let payload = try XCTUnwrap(try JSONSerialization.jsonObject(with: payloadData) as? [String: Any])
        let exp = try XCTUnwrap(payload["exp"] as? Int)
        let expectedExp = Int(Date().timeIntervalSince1970) + 3600
        XCTAssertEqual(Double(exp), Double(expectedExp), accuracy: 5)
    }
}

private extension Data {
    init?(base64URLDecoded string: String) {
        var base64 = string
            .replacingOccurrences(of: "-", with: "+")
            .replacingOccurrences(of: "_", with: "/")
        while base64.count % 4 != 0 {
            base64.append("=")
        }
        self.init(base64Encoded: base64)
    }

    func base64URLEncodedString() -> String {
        base64EncodedString()
            .replacingOccurrences(of: "+", with: "-")
            .replacingOccurrences(of: "/", with: "_")
            .replacingOccurrences(of: "=", with: "")
    }
}
