import json

from algoliasearch.search.client import SearchClientSync


if __name__ == "__main__":
    try:
        _client = SearchClientSync("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")

        with open("products.json", "r", encoding="utf-8") as f:
            products = json.load(f)

            records = []

            for product in products:
                reference = product["product_reference"]

                suffixes = []
                while len(reference) > 1:
                    reference = reference[1:]
                    suffixes.append(reference)

                product["product_reference_suffixes"] = suffixes
                records.append(product)

        _client.save_objects(
            index_name="<YOUR_INDEX_NAME>",
            objects=records,
        )
    except Exception as e:
        print(f"Error: {e}")
