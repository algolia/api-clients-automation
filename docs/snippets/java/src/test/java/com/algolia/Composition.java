package com.algolia.methods.snippets;

// >IMPORT
import com.algolia.api.CompositionClient;
import com.algolia.config.*;
// IMPORT<
import com.algolia.model.composition.*;
import java.util.*;

class SnippetCompositionClient {

  // Snippet for the search method.
  //
  // search
  void snippetForSearch() throws Exception {
    // >SEPARATOR search default
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.search("foo", new RequestBody().setParams(new Params().setQuery("batman")), Hit.class);
    // >LOG
    // SEPARATOR<
  }

  // Snippet for the searchForFacetValues method.
  //
  // searchForFacetValues
  void snippetForSearchForFacetValues() throws Exception {
    // >SEPARATOR searchForFacetValues default
    // Initialize the client
    CompositionClient client = new CompositionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Call the API
    client.searchForFacetValues(
      "foo",
      "brand",
      new SearchForFacetValuesRequest().setParams(new SearchForFacetValuesParams().setMaxFacetHits(10))
    );
    // >LOG
    // SEPARATOR<
  }
}
