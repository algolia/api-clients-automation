module gotests

go 1.22

toolchain go1.24.2

replace github.com/algolia/algoliasearch-client-go/v4 v4.0.0 => ../../../clients/algoliasearch-client-go

require (
	github.com/algolia/algoliasearch-client-go/v4 v4.0.0
	github.com/joho/godotenv v1.5.1
	github.com/kinbiko/jsonassert v1.2.0
	github.com/stretchr/testify v1.10.0
)

require (
	github.com/davecgh/go-spew v1.1.1 // indirect
	github.com/gabriel-vasile/mimetype v1.4.8 // indirect
	github.com/go-playground/locales v0.14.1 // indirect
	github.com/go-playground/universal-translator v0.18.1 // indirect
	github.com/go-playground/validator/v10 v10.26.0 // indirect
	github.com/leodido/go-urn v1.4.0 // indirect
	github.com/pmezard/go-difflib v1.0.0 // indirect
	golang.org/x/crypto v0.33.0 // indirect
	golang.org/x/net v0.34.0 // indirect
	golang.org/x/sys v0.30.0 // indirect
	golang.org/x/text v0.22.0 // indirect
	gopkg.in/yaml.v3 v3.0.1 // indirect
)
