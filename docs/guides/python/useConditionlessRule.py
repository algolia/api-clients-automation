from algoliasearch.search.client import SearchClientSync

from algoliasearch.search.models.consequence import Consequence
from algoliasearch.search.models.rule import Rule
from algoliasearch.search.models.time_range import TimeRange

_client = SearchClientSync("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")


object_id = "a-rule-id"

rule = Rule(
    object_id=object_id,
    consequence=Consequence(
        # Set relevant consequence
    ),
)

# Set validity (optional)
rule.validity = [
    TimeRange(
        var_from=1688774400,
        until=1738972800,
    ),
]

_client.save_rule(
    index_name="<YOUR_INDEX_NAME>",
    object_id=object_id,
    rule=rule,
)
