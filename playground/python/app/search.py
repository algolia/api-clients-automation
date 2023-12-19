from asyncio import run

from algoliasearch.search.client import SearchClient
from algoliasearch.search import __version__
from algoliasearch.search.config import Config
from algoliasearch.http.request_options import RequestOptions
from algoliasearch.http.transporter import EchoTransporter


async def main():
    print("SearchClient version", __version__)

    client = SearchClient.create("QPBQ67WNIG", "b590ae1153bf574215ca1605c19eb1fe")
    print("client initialized", client)

    echoClient = SearchClient(config=Config("QPBQ67WNIG", "b590ae1153bf574215ca1605c19eb1fe"), transporter=EchoTransporter(Config("QPBQ67WNIG", "b590ae1153bf574215ca1605c19eb1fe")))

    print("echo client initialized", echoClient)

    try:
        response = await client.search(
            search_method_params={"requests": [{"indexName": "nvim"}]},
            request_options=RequestOptions({"foo": "bar"}, {}, {"readTimeout": 1, "writeTimeout": 2}, {})
        )

        print("client response")
        print(response.to_json())

        response = await echoClient.search_with_http_info(
            search_method_params={"requests": [{"indexName": "nvim"}]},
            request_options=RequestOptions({"foo": "bar"}, {}, {"readTimeout": 1, "writeTimeout": 2}, {})
        )

        print("echo response")
        print(response.to_json())
    finally:
        await client.close()

        print("client closed")


run(main())
