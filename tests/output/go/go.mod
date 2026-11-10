module gotests

go 1.21.11

replace github.com/algolia/algoliasearch-client-go/v4 => ../../../clients/algoliasearch-client-go

require (
	github.com/algolia/algoliasearch-client-go/v4 v4.0.0
	github.com/joho/godotenv v1.5.1
	github.com/kinbiko/jsonassert v1.1.0
	github.com/stretchr/testify v1.12.1
)

require go.yaml.in/yaml/v3 v3.0.5 // indirect
