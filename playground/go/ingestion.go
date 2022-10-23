package main

import (
	"fmt"
	"os"

	"github.com/algolia/algoliasearch-client-go/algolia/ingestion"

	"github.com/joho/godotenv"
)

func main() {
	fmt.Println("Go playground")
	godotenv.Load("../.env")
	appID := os.Getenv("ALGOLIA_APPLICATION_ID")
	apiKey := os.Getenv("ALGOLIA_ADMIN_KEY")
	client := ingestion.NewAPIClient(appID, apiKey, ingestion.NewConfiguration(ingestion.US))

	auth, err := client.CreateAuthentication(ingestion.NewAuthenticationCreate(
		ingestion.AUTHENTICATIONTYPE_ALGOLIA, "test-auth", ingestion.AuthAlgoliaAsAuthInput(ingestion.NewAuthAlgolia(appID, apiKey))))

	if err != nil {
		fmt.Println(err)

		return
	}

	dest, err := client.CreateDestination(ingestion.NewDestinationCreate(
		ingestion.DESTINATIONTYPE_SEARCH,
		"test-dest",
		ingestion.DestinationIndexPrefixAsDestinationInput(ingestion.NewDestinationIndexPrefix("commercetools_")),
		auth.AuthenticationID))

	if err != nil {
		fmt.Println(err)

		return
	}

	fmt.Println(dest)
}
