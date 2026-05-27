package manual

import (
	"crypto/hmac"
	"crypto/sha256"
	"encoding/base64"
	"encoding/json"
	"strings"
	"testing"
	"time"

	"github.com/stretchr/testify/require"

	agentStudio "github.com/algolia/algoliasearch-client-go/v4/algolia/agent-studio"
)

func TestForgeSecuredUserToken(t *testing.T) {
	client, err := agentStudio.NewClient("appID", "apiKey")
	require.NoError(t, err)

	token, err := client.ForgeSecuredUserToken("my-secret-key", "my-key-id", "user-123")
	require.NoError(t, err)

	parts := strings.Split(token, ".")
	require.Len(t, parts, 3)

	headerJSON, err := base64.RawURLEncoding.DecodeString(parts[0])
	require.NoError(t, err)
	var header map[string]any
	require.NoError(t, json.Unmarshal(headerJSON, &header))
	require.Equal(t, "HS256", header["alg"])
	require.Equal(t, "JWT", header["typ"])
	require.Equal(t, "my-key-id", header["kid"])

	payloadJSON, err := base64.RawURLEncoding.DecodeString(parts[1])
	require.NoError(t, err)
	var payload map[string]any
	require.NoError(t, json.Unmarshal(payloadJSON, &payload))
	require.Equal(t, "user-123", payload["sub"])
	exp := int64(payload["exp"].(float64))
	expectedExp := time.Now().Unix() + 24*3600
	require.InDelta(t, expectedExp, exp, 5)

	mac := hmac.New(sha256.New, []byte("my-secret-key"))
	mac.Write([]byte(parts[0] + "." + parts[1]))
	expectedSig := base64.RawURLEncoding.EncodeToString(mac.Sum(nil))
	require.Equal(t, expectedSig, parts[2])
}

func TestForgeSecuredUserTokenCustomExpiry(t *testing.T) {
	client, err := agentStudio.NewClient("appID", "apiKey")
	require.NoError(t, err)

	token, err := client.ForgeSecuredUserToken("my-secret-key", "my-key-id", "user-456", agentStudio.WithExpiresIn(3600))
	require.NoError(t, err)

	parts := strings.Split(token, ".")
	require.Len(t, parts, 3)

	payloadJSON, err := base64.RawURLEncoding.DecodeString(parts[1])
	require.NoError(t, err)
	var payload map[string]any
	require.NoError(t, json.Unmarshal(payloadJSON, &payload))
	exp := int64(payload["exp"].(float64))
	expectedExp := time.Now().Unix() + 3600
	require.InDelta(t, expectedExp, exp, 5)
}
