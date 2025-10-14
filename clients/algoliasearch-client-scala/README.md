<p align="center">
  <a href="https://www.algolia.com">
    <img alt="Algolia for Scala" src="https://user-images.githubusercontent.com/22633119/59600520-a8882400-9101-11e9-8034-2bf6d75bf962.png" >
  </a>

<h4 align="center">The perfect starting point to integrate <a href="https://algolia.com" target="_blank">Algolia</a> within your Scala project</h4>

  <p align="center">
      <a href="https://central.sonatype.com/artifact/com.algolia/algoliasearch-scala_2.13"><img src="https://img.shields.io/maven-central/v/com.algolia/algoliasearch-scala_2.13" alt="Maven Central"></img></a>
      <a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="Licence"></img></a>
  </p>
</p>

<p align="center">
  <a href="https://www.algolia.com/doc/libraries/sdk/install#scala" target="_blank">Documentation</a>  •
  <a href="https://discourse.algolia.com" target="_blank">Community Forum</a>  •
  <a href="https://stackoverflow.com/questions/tagged/algolia" target="_blank">Stack Overflow</a>  •
  <a href="https://github.com/algolia/algoliasearch-client-scala/issues" target="_blank">Report a bug</a>  •
  <a href="https://alg.li/support" target="_blank">Support</a>
</p>

## ✨ Features

* Supports Scala 2.13 and 3.3
* Asynchronous methods to target Algolia's API
* Json as case class

## 💡 Getting Started

**WARNING:**
The JVM has an infinite cache on successful DNS resolution.
As our hostnames points to multiple IPs, the load could be not evenly spread among our machines,
and you might also target a dead machine.

You should change this TTL by setting the property `networkaddress.cache.ttl`.
For example, to set the cache to 60 seconds:

```scala
java.security.Security.setProperty("networkaddress.cache.ttl", "60");
```

For debug purposes, you can enable debug logging on the API client.
It's using [slf4j](https://www.slf4j.org) so it should be compatible with most java loggers.

## 💡 Getting Started

To get started, add the algoliasearch-client-scala dependency to your project, with [Maven](https://maven.apache.org/), add the following dependency to your `pom.xml` file:

```xml
<dependency>
    <groupId>com.algolia</groupId>
    <artifactId>algoliasearch-scala_2.13</artifactId>
    <version>[2,)</version>
</dependency>
```

For snapshots, add the `sonatype` repository:
```xml
<repositories>
    <repository>
        <id>oss-sonatype</id>
        <name>oss-sonatype</name>
        <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>
```

If you're using `sbt`, add the following dependency to your `build.sbt` file:

```scala
libraryDependencies += "com.algolia" %% "algoliasearch-scala" % "[2,)"
```

For snapshots, add the `sonatype` repository:
```scala
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
```

You can now import the Algolia API client in your project and play with it.

```scala
import algoliasearch.api.SearchClient

val client = SearchClient(appId = "YOUR_APP_ID", apiKey = "YOUR_API_KEY")

// Add a new record to your Algolia index
val response = client.saveObject(
  indexName = "<YOUR_INDEX_NAME>",
  body = JObject(List(JField("objectID", JString("id")), JField("test", JString("val"))))
)

// Use the response
val value = Await.result(response, Duration(100, "sec"))

// Poll the task status to know when it has been indexed
client.waitTask("<YOUR_INDEX_NAME>", response.getTaskID())

// Fetch search results, with typo tolerance
val response = client.search(
  searchMethodParams = SearchMethodParams(
    requests = Seq(
      SearchForHits(
        indexName = "<YOUR_INDEX_NAME>",
        query = Some("<YOUR_QUERY>"),
        hitsPerPage = Some(50)
      )
    )
  )
)

// Use the response
val value = Await.result(response, Duration(100, "sec"))
```

For full documentation, visit the **[Algolia Scala API Client](https://www.algolia.com/doc/libraries/sdk/install#scala)**.

## ❓ Troubleshooting

Encountering an issue? Before reaching out to support, we recommend heading to our [FAQ](https://support.algolia.com/hc/sections/15061037630609-API-Client-FAQs) where you will find answers for the most common issues and gotchas with the client. You can also open [a GitHub issue](https://github.com/algolia/api-clients-automation/issues/new?assignees=&labels=&projects=&template=Bug_report.md)

## Contributing

This repository hosts the code of the generated Algolia API client for Scala, if you'd like to contribute, head over to the [main repository](https://github.com/algolia/api-clients-automation). You can also find contributing guides on [our documentation website](https://api-clients-automation.netlify.app/docs/introduction).

## 📄 License

The Algolia Scala API Client is an open-sourced software licensed under the [MIT license](LICENSE).
