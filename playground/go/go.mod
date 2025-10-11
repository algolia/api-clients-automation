module playground

go 1.23.0

toolchain go1.25.2

replace github.com/algolia/algoliasearch-client-go/v4 => ../../clients/algoliasearch-client-go

require (
	github.com/algolia/algoliasearch-client-go/v4 v4.15.3
	github.com/joho/godotenv v1.5.1
)
