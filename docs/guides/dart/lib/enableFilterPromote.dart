import 'package:algolia_client_search/algolia_client_search.dart';

void enableFilterPromote() async {
  final condition = Condition(
    pattern: "{facet:brand}",
    anchoring: Anchoring.is_,
  );

  final consequence = Consequence(filterPromotes: true);

  // ignore: unused_local_variable
  final rule = Rule(
      objectID: "rule_with_filterPromotes",
      conditions: [condition],
      consequence: consequence);
}
