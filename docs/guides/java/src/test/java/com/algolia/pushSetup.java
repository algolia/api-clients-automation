import com.algolia.api.IngestionClient;
import com.algolia.model.ingestion.*;
import com.fasterxml.jackson.databind.*;
import java.io.File;
import java.util.List;
import java.util.Map;

public class pushSetup {

  public static void main(String[] args) throws Exception {
    JsonNode content = new ObjectMapper().readTree(new File("records.json"));
    List<PushTaskRecords> records = new ObjectMapper().readerForListOf(Map.class).readValue(content);

    // use the region matching your applicationID
    IngestionClient client = new IngestionClient("ALGOLIA_APPLICATION_ID", "ALGOLIA_API_KEY", "ALGOLIA_APPLICATION_REGION");

    RunResponse run = client.pushTask("YOUR_TASK_ID", new PushTaskPayload().setAction(Action.ADD_OBJECT).setRecords(records));

    // use runID in the Observability debugger
    System.out.println(run.getRunID());

    client.close();
  }
}
