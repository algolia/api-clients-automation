import base64
import hashlib
import hmac
import json
import time

from algoliasearch.agent_studio.client import AgentStudioClient


async def test_forge_secured_user_token():
    client = AgentStudioClient("appID", "apiKey")

    token = client.forge_secured_user_token(
        secret_key="my-secret-key",
        secret_key_id="my-key-id",
        user_id="user-123",
    )

    parts = token.split(".")
    assert len(parts) == 3

    header = json.loads(base64.urlsafe_b64decode(parts[0] + "=="))
    assert header["alg"] == "HS256"
    assert header["typ"] == "JWT"
    assert header["kid"] == "my-key-id"

    payload = json.loads(base64.urlsafe_b64decode(parts[1] + "=="))
    assert payload["sub"] == "user-123"
    assert abs(payload["exp"] - (int(time.time()) + 24 * 3600)) < 5

    expected_sig = base64.urlsafe_b64encode(
        hmac.new(
            b"my-secret-key",
            f"{parts[0]}.{parts[1]}".encode(),
            hashlib.sha256,
        ).digest()
    ).rstrip(b"=").decode()
    assert parts[2] == expected_sig

    await client.close()


async def test_forge_secured_user_token_custom_expiry():
    client = AgentStudioClient("appID", "apiKey")

    token = client.forge_secured_user_token(
        secret_key="my-secret-key",
        secret_key_id="my-key-id",
        user_id="user-456",
        expires_in=3600,
    )

    parts = token.split(".")
    payload = json.loads(base64.urlsafe_b64decode(parts[1] + "=="))
    assert abs(payload["exp"] - (int(time.time()) + 3600)) < 5

    await client.close()
