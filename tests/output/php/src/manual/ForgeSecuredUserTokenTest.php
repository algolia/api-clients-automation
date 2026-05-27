<?php

namespace Algolia\AlgoliaSearch\Tests;

use Algolia\AlgoliaSearch\Api\AgentStudioClient;
use PHPUnit\Framework\TestCase;

/**
 * @internal
 *
 * @coversNothing
 */
class ForgeSecuredUserTokenTest extends TestCase
{
    public function testForgeSecuredUserToken(): void
    {
        $client = AgentStudioClient::create('appID', 'apiKey');

        $token = $client->forgeSecuredUserToken('my-secret-key', 'my-key-id', 'user-123');

        $parts = explode('.', $token);
        $this->assertCount(3, $parts);

        $header = json_decode(base64_decode(strtr($parts[0], '-_', '+/')), true);
        $this->assertSame('HS256', $header['alg']);
        $this->assertSame('JWT', $header['typ']);
        $this->assertSame('my-key-id', $header['kid']);

        $payload = json_decode(base64_decode(strtr($parts[1], '-_', '+/')), true);
        $this->assertSame('user-123', $payload['sub']);
        $this->assertEqualsWithDelta(time() + 24 * 3600, $payload['exp'], 5);

        $expectedSig = rtrim(strtr(base64_encode(hash_hmac('sha256', $parts[0].'.'.$parts[1], 'my-secret-key', true)), '+/', '-_'), '=');
        $this->assertSame($expectedSig, $parts[2]);
    }

    public function testForgeSecuredUserTokenCustomExpiry(): void
    {
        $client = AgentStudioClient::create('appID', 'apiKey');

        $token = $client->forgeSecuredUserToken('my-secret-key', 'my-key-id', 'user-456', 3600);

        $parts = explode('.', $token);
        $payload = json_decode(base64_decode(strtr($parts[1], '-_', '+/')), true);
        $this->assertEqualsWithDelta(time() + 3600, $payload['exp'], 5);
    }
}
