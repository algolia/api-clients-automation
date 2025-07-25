package com.algolia;

import com.algolia.api.SearchClient;
import com.algolia.config.*;
import com.algolia.model.search.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class saveImageClassifications {

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
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
