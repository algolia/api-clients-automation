<p align="center">
  <a href="https://www.algolia.com">
    <img alt="Algolia for Java" src="https://user-images.githubusercontent.com/22633119/59595532-4c6bd280-90f6-11e9-9d83-9afda3c85e96.png" >
  </a>

<h4 align="center">The perfect starting point to integrate <a href="https://algolia.com" target="_blank">Algolia</a> within your Java project</h4>

  <p align="center">
    <a href="https://search.maven.org/artifact/com.algolia/algoliasearch/"><img src="https://img.shields.io/maven-central/v/com.algolia/algoliasearch.svg" alt="CircleCI"></img></a>
    <a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="Licence"></img></a>
  </p>
</p>

<p align="center">
  <a href="https://www.algolia.com/doc/api-client/getting-started/install/java/" target="_blank">Documentation</a>  •
  <a href="https://discourse.algolia.com" target="_blank">Community Forum</a>  •
  <a href="http://stackoverflow.com/questions/tagged/algolia" target="_blank">Stack Overflow</a>  •
  <a href="https://github.com/algolia/algoliasearch-client-java/issues" target="_blank">Report a bug</a>  •
  <a href="https://www.algolia.com/doc/api-client/troubleshooting/faq/java/" target="_blank">FAQ</a>  •
  <a href="https://alg.li/support" target="_blank">Support</a>
</p>

## ✨ Features

* Support Java 8 and above
* Asynchronous and synchronous methods to interact with Algolia's API
* Thread-safe clients
* Typed requests and responses

## 💡 Getting Started

To get started, add the algoliasearch-client-java dependency to your project, either with [Maven](Maven):

```java
<dependency>
  <groupId>com.algolia</groupId>
  <artifactId>algoliasearch</artifactId>
  <version>4.0.0-beta.36</version>
</dependency>
```

or [Gradle](https://gradle.org/):

```java
dependencies {
  implementation 'com.algolia:algoliasearch:4.0.0-beta.36'
}
```

You can now import the Algolia API client in your project and play with it.

```java
import com.algolia.api.SearchClient;
import com.algolia.model.search.*;

SearchClient client = new SearchClient("YOUR_APP_ID", "YOUR_API_KEY");

// Add a new record to your Algolia index
client.saveObject("<YOUR_INDEX_NAME>", Map.of("objectID", "id", "test", "val"));

// Poll the task status to know when it has been indexed
client.waitForTask("<YOUR_INDEX_NAME>", response.getTaskID());

// Fetch search results, with typo tolerance
client.search(
  new SearchMethodParams()
    .setRequests(List.of(new SearchForHits().setIndexName("<YOUR_INDEX_NAME>").setQuery("<YOUR_QUERY>").setHitsPerPage(50))),
  Hit.class
);
```

For full documentation, visit the **[Algolia Java API Client](https://www.algolia.com/doc/api-client/getting-started/install/java/)**.

## ❓ Troubleshooting

Encountering an issue? Before reaching out to support, we recommend heading to our [FAQ](https://www.algolia.com/doc/api-client/troubleshooting/faq/java/) where you will find answers for the most common issues and gotchas with the client. You can also open [a GitHub issue](https://github.com/algolia/api-clients-automation/issues/new?assignees=&labels=&projects=&template=Bug_report.md)

## Contributing

This repository hosts the code of the generated Algolia API client for Java, if you'd like to contribute, head over to the [main repository](https://github.com/algolia/api-clients-automation). You can also find contributing guides on [our documentation website](https://api-clients-automation.netlify.app/docs/introduction).

## 📄 License

The Algolia Java API Client is an open-sourced software licensed under the [MIT license](LICENSE).
