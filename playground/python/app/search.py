from asyncio import run
from os import environ

from algoliasearch.search.client import SearchClient
from algoliasearch.http.helpers import SecuredApiKeyRestrictions
from algoliasearch.search import __version__
from dotenv import load_dotenv

load_dotenv("../.env")


async def main():
    print("SearchClient version", __version__)

    client = SearchClient(environ.get("ALGOLIA_APPLICATION_ID"), environ.get("ALGOLIA_ADMIN_KEY"))
    print("client initialized", client)

    try:
        resp = await client.replace_all_objects(
            index_name="test-flag",
            objects=[
              {
                "productType": "main",
                "name": {
                  "de": "Tasche „Sutton” medium Michael Kors tascher",
                  "en": "Bag ”Sutton” medium Michael Kors bags"
                },
                "description": {
                  "de": "Das ist ein Test"
                },
                "slug": {
                  "de": "michaelkors-tasche-sutton-30S4GTVS6L-gelb",
                  "en": "michaelkors-bag-sutton-30S4GTVS6L-yellow"
                },
                "categories": {
                  "de": {
                    "lvl0": [
                      "Frauen2",
                      "Frauen2"
                    ],
                    "lvl1": [
                      "Frauen2 > Koffer",
                      "Frauen2 > Koffer"
                    ],
                    "lvl2": [
                      "Frauen2 > Koffer > Schultertaschen",
                      "Frauen2 > Koffer > Handtaschen"
                    ]
                  },
                  "en": {
                    "lvl0": [
                      "Women",
                      "Women"
                    ],
                    "lvl1": [
                      "Women > Bags",
                      "Women > Bags"
                    ],
                    "lvl2": [
                      "Women > Bags > Shoulder bags",
                      "Women > Bags > Handbag"
                    ]
                  }
                },
                "categoryKeys": {
                  "de": [
                    "Frauen2",
                    "Koffer",
                    "Schultertaschen",
                    "Handtaschen"
                  ],
                  "en": [
                    "Women",
                    "Bags",
                    "Shoulder bags",
                    "Handbag"
                  ]
                },
                "attributes": {
                  "designer": {
                    "key": "michaelkors",
                    "label": "Michael Kors"
                  },
                  "gender": {
                    "key": "women",
                    "label": "Damen"
                  },
                  "madeInItaly": {
                    "key": "no",
                    "label": "no"
                  },
                  "season": "s15"
                },
                "searchableAttributes": {
                  "designer": {
                    "key": "michaelkors",
                    "label": "Michael Kors"
                  },
                  "gender": {
                    "key": "women",
                    "label": "Damen"
                  },
                  "madeInItaly": {
                    "key": "no",
                    "label": "no"
                  }
                },
                "createdAt": "2023-01-31T15:37:52.334Z",
                "masterVariantID": "1",
                "categoryPageId": [
                  "Frauen2",
                  "Frauen2",
                  "Frauen2 > Koffer",
                  "Frauen2 > Koffer",
                  "Frauen2 > Koffer > Handtaschen",
                  "Frauen2 > Koffer > Schultertaschen",
                  "Women",
                  "Women",
                  "Women > Bags",
                  "Women > Bags",
                  "Women > Bags > Handbag",
                  "Women > Bags > Shoulder bags"
                ],
                "variantIDs": [
                  "1"
                ],
                "_tags": [
                  "product:fff2bd4d-bb17-4e21-a0c4-0a8ea5e363f2"
                ],
                "variants": [
                  {
                    "id": "1",
                    "sku": "A0E200000001YNP",
                    "attributes": {
                      "articleNumberManufacturer": "30S4GTVS6L 724 SUN",
                      "articleNumberMax": "72999",
                      "baseId": "72999",
                      "color": {
                        "key": "yellow",
                        "label": {
                          "de": "gelb",
                          "en": "yellow",
                          "it": "giallo"
                        }
                      },
                      "colorFreeDefinition": {
                        "de": "sun",
                        "en": "sun"
                      },
                      "commonSize": {
                        "key": "oneSize",
                        "label": "one Size"
                      },
                      "matrixId": "A0E200000001YNP",
                      "size": "one size",
                      "style": {
                        "key": "sporty",
                        "label": "sporty"
                      }
                    },
                    "searchableAttributes": {
                      "articleNumberManufacturer": "30S4GTVS6L 724 SUN",
                      "articleNumberMax": "72999",
                      "baseId": "72999",
                      "color": {
                        "key": "yellow",
                        "label": {
                          "de": "gelb",
                          "en": "yellow",
                          "it": "giallo"
                        }
                      },
                      "colorFreeDefinition": {
                        "de": "sun",
                        "en": "sun"
                      },
                      "commonSize": {
                        "key": "oneSize",
                        "label": "one Size"
                      },
                      "matrixId": "A0E200000001YNP",
                      "size": "one size",
                      "style": {
                        "key": "sporty",
                        "label": "sporty"
                      }
                    },
                    "images": [
                      "https://s3-eu-west-1.amazonaws.com/commercetools-maximilian/products/072999_1_medium.jpg"
                    ],
                    "prices": {
                      "EUR": {
                        "min": 26639,
                        "max": 40625,
                        "customerGroups": [
                          {
                            "id": "c4dacbc0-b2a0-4b66-86f6-796edb0733af",
                            "price": 26639
                          }
                        ],
                        "priceValues": [
                          {
                            "id": "dd4f9010-c913-43f5-8fdd-639d414fcaeb",
                            "value": 40625
                          },
                          {
                            "id": "4384ac1d-94e5-4ee7-9141-1b07eeeb679b",
                            "value": 26639,
                            "customerGroupID": "c4dacbc0-b2a0-4b66-86f6-796edb0733af"
                          },
                          {
                            "id": "802a036a-d351-41ee-bc80-33be369c6e6b",
                            "value": 32500
                          },
                          {
                            "id": "a8d0a67f-9cf5-4c40-86f0-93a6fe1335f8",
                            "value": 32500
                          },
                          {
                            "id": "40a1365b-8f18-47c2-a906-2dd8847ade52",
                            "value": 32500
                          },
                          {
                            "id": "03dee877-1cb3-4e2d-9eb6-58703b5781ce",
                            "value": 31200
                          },
                          {
                            "id": "52ceeac3-16af-4d6d-92ec-168ef60c13b9",
                            "value": 38188
                          },
                          {
                            "id": "374ee6bb-16c3-490c-ab69-ab2a92cb144c",
                            "value": 30875
                          },
                          {
                            "id": "53bd8c8b-bee1-4278-a9a2-3ac03144aa3c",
                            "value": 34125
                          },
                          {
                            "id": "a63afeb1-401f-4ec9-9180-10caf9a08412",
                            "value": 29900
                          }
                        ]
                      },
                      "USD": {
                        "min": 26639,
                        "max": 40625,
                        "customerGroups": [
                          {
                            "id": "c4dacbc0-b2a0-4b66-86f6-796edb0733af",
                            "price": 26639
                          }
                        ],
                        "priceValues": [
                          {
                            "id": "97ff633e-3adb-4567-ba59-dd816b8036bb",
                            "value": 40625
                          },
                          {
                            "id": "71241f7f-a9f1-43e7-ac65-ab87972de2dc",
                            "value": 26639,
                            "customerGroupID": "c4dacbc0-b2a0-4b66-86f6-796edb0733af"
                          },
                          {
                            "id": "40483935-ff31-4e8a-8222-051cac632291",
                            "value": 31200
                          },
                          {
                            "id": "8a8d123e-3981-49b4-b987-29dcfa516831",
                            "value": 38188
                          },
                          {
                            "id": "22b5ca47-d714-4b3e-8b21-f6f108b1d7f6",
                            "value": 30875
                          },
                          {
                            "id": "737fd320-972a-4d01-adb8-a2e79d8e4824",
                            "value": 34125
                          },
                          {
                            "id": "d72e03a0-6241-4a8b-977d-0088a26fff53",
                            "value": 29900
                          }
                        ]
                      }
                    },
                    "isInStock": True,
                    "inventory": {
                      "no-channel": 1
                    }
                  }
                ],
                "objectID": "fff2bd4d-bb17-4e21-a0c4-0a8ea5e363f2"
              }],
            safe=True,
        )

        print(resp)
    finally:
        await client.close()

        print("client closed")


run(main())
