package transport

import (
	"time"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/compression"
)

type Configuration struct {
	AppID  string
	ApiKey string //nolint:staticcheck

	Hosts                           []StatefulHost
	DefaultHeader                   map[string]string
	UserAgent                       string
	Requester                       Requester
	ReadTimeout                     time.Duration
	WriteTimeout                    time.Duration
	ConnectTimeout                  time.Duration
	Compression                     compression.Compression
	ExposeIntermediateNetworkErrors bool

	// RequestIDEnabled makes the transport send a Request-ID header, minted
	// once per call and reused across its retry attempts, so that Algolia
	// support can tie the attempts of one request together. It is forced by
	// the generated clients according to which APIs support it; a Request-ID
	// supplied through request options or DefaultHeader is never overwritten.
	RequestIDEnabled bool
}

type RequestConfiguration struct {
	ReadTimeout    *time.Duration
	WriteTimeout   *time.Duration
	ConnectTimeout *time.Duration
}
