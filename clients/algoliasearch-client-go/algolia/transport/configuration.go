package transport

import (
	"time"

	"github.com/algolia/algoliasearch-client-go/v4/algolia/compression"
)

type Configuration struct {
	AppID  string
	ApiKey string

	Hosts          []string          `json:"host,omitempty"`
	DefaultHeader  map[string]string `json:"defaultHeader,omitempty"`
	UserAgent      string            `json:"userAgent,omitempty"`
	Debug          bool              `json:"debug,omitempty"`
	Requester      Requester
	ReadTimeout    time.Duration
	WriteTimeout   time.Duration
	ConnectTimeout time.Duration
	Compression    compression.Compression
}
