package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class saveImageClassificationsAndSettings {

  static class Image {

    public String imageURL;
    public String objectID;
    public List<Map<String, Object>> objects;

    public Image(String imageURL, String objectID, List<Map<String, Object>> objects) {
      this.imageURL = imageURL;
      this.objectID = objectID;
      this.objects = objects;
    }
  }

  // Retrieve labels
  static Image getImageLabels(String imageURL, String objectID, float scoreLimit) {
    // Implement your image classification logic here
    return new Image(imageURL, objectID, new ArrayList<>());
  }

  public static void main(String[] args) throws Exception {
    // API key ACL should include editSettings / addObject
    try (SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY")) {
      var hits = client.browseObjects("<YOUR_INDEX_NAME>", Image.class);

      List<Image> records = new ArrayList<>();
      for (var hit : hits) {
        var image = getImageLabels(hit.imageURL, hit.objectID, 0.5f);
        records.add(image);
      }

      // Update records with image classifications
      client.partialUpdateObjects("<YOUR_INDEX_NAME>", records, true);

      List<String> facets = new ArrayList<>();
      List<String> attributes = new ArrayList<>();

      records.forEach(record -> {
        record.objects.forEach(object -> {
          object.forEach((key, values) -> {
            if (values instanceof Iterable) {
              facets.add("searchable(objects." + key + ".label)");
              facets.add("searchable(objects." + key + ".score)");
              attributes.add("objects." + key + ".label");
            }
          });
        });
      });

      var currentSettings = client.getSettings("<YOUR_INDEX_NAME>");

      var attributesForFaceting =
        currentSettings.getAttributesForFaceting() != null ? currentSettings.getAttributesForFaceting() : new ArrayList<String>();
      var searchableAttributes =
        currentSettings.getSearchableAttributes() != null ? currentSettings.getSearchableAttributes() : new ArrayList<String>();

      attributesForFaceting.addAll(facets);
      searchableAttributes.addAll(attributes);

      var settings = new IndexSettings().setAttributesForFaceting(attributesForFaceting).setSearchableAttributes(searchableAttributes);

      client.setSettings("<YOUR_INDEX_NAME>", settings);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
