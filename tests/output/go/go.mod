module gotests

go 1.21.11

toolchain go1.23.7

replace github.com/algolia/algoliasearch-client-go/v4 => ../../../clients/algoliasearch-client-go

require (
	github.com/algolia/algoliasearch-client-go/v4 v4.0.0
	github.com/joho/godotenv v1.5.1
	github.com/kinbiko/jsonassert v1.1.0
	github.com/stretchr/testify v1.11.1
)

require (
	github.com/davecgh/go-spew v1.1.1 // indirect
	github.com/pmezard/go-difflib v1.0.0 // indirect
	gopkg.in/yaml.v3 v3.0.1 // indirect
)
