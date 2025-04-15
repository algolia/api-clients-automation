package com.algolia;

import com.algolia.config.*;
import com.algolia.model.search.*;
import java.util.List;

public class enableFilterPromote {

  public static void main(String[] args) throws Exception {
    Condition condition = new Condition().setAnchoring(Anchoring.IS).setPattern("{facet:brand}");

    Consequence consequence = new Consequence().setFilterPromotes(true);

    Rule rule = new Rule().setObjectID("rule_with_filterPromotes").setConditions(List.of(condition)).setConsequence(consequence);
  }
}
