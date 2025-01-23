import com.algolia.api.SearchClient;
import com.algolia.model.search.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class saveObjectsMovies {

  public static void main(String[] args) throws Exception {
    // Fetch sample dataset
    URL url = new URI("https://dashboard.algolia.com/api/1/sample_datasets?type=movie").toURL();
    InputStream stream = url.openStream();
    ObjectMapper mapper = new ObjectMapper();
    List<JsonNode> movies = mapper.readValue(stream, new TypeReference<List<JsonNode>>() {});
    stream.close();

    // Connect and authenticate with your Algolia app
    SearchClient client = new SearchClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY");

    // Save records in Algolia index
    client.saveObjects("<YOUR_INDEX_NAME>", movies);
    client.close();
  }
}
