// File generated by OpenAPI Generator (https://openapi-generator.tech), manual changes will be lost - read more on https://github.com/algolia/api-clients-automation.
package analytics

import (
	"github.com/algolia/algoliasearch-client-go/v4/algolia/transport"
)

var allowedRegions = [...]string{"de", "us"}

type Region string

const (
	DE Region = "de"
	US Region = "us"
)

// Configuration stores the configuration of the API client.
type Configuration struct {
	transport.Configuration

	Region Region
}
