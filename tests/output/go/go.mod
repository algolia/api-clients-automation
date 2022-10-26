module tests

go 1.18

replace github.com/algolia/algoliasearch-client-go v1.0.0 => ../../../clients/algoliasearch-client-go

require (
	github.com/algolia/algoliasearch-client-go v1.0.0
	github.com/kinbiko/jsonassert v1.1.1
	github.com/stretchr/testify v1.8.1
)

require (
	github.com/davecgh/go-spew v1.1.1 // indirect
	github.com/pmezard/go-difflib v1.0.0 // indirect
	gopkg.in/yaml.v3 v3.0.1 // indirect
)
