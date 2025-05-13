package transport

import (
	"time"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/compression"
)

type Configuration struct {
	Requester                       Requester
	DefaultHeader                   map[string]string
	AppID                           string
	APIKey                          string
	UserAgent                       string
	Hosts                           []StatefulHost
	ReadTimeout                     time.Duration
	WriteTimeout                    time.Duration
	ConnectTimeout                  time.Duration
	Compression                     compression.Compression
	ExposeIntermediateNetworkErrors bool
}

type RequestConfiguration struct {
	ReadTimeout    *time.Duration
	WriteTimeout   *time.Duration
	ConnectTimeout *time.Duration
}
