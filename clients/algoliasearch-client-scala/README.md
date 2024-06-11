<p align="center">
  <a href="https://www.algolia.com">
    <img alt="Algolia for Scala" src="https://user-images.githubusercontent.com/22633119/59600520-a8882400-9101-11e9-8034-2bf6d75bf962.png" >
  </a>

<h4 align="center">The perfect starting point to integrate <a href="https://algolia.com" target="_blank">Algolia</a> within your Scala project</h4>

  <p align="center">
      <a href="https://maven-badges.herokuapp.com/maven-central/com.algolia/algoliasearch-scala_2.13/"><img src="https://img.shields.io/maven-central/v/com.algolia/algoliasearch-scala_2.13" alt="Maven Central"></img></a>
      <a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="Licence"></img></a>
  </p>
</p>

<p align="center">
  <a href="https://www.algolia.com/doc/api-client/getting-started/install/scala/" target="_blank">Documentation</a>  •
  <a href="https://discourse.algolia.com" target="_blank">Community Forum</a>  •
  <a href="https://stackoverflow.com/questions/tagged/algolia" target="_blank">Stack Overflow</a>  •
  <a href="https://github.com/algolia/algoliasearch-client-scala/issues" target="_blank">Report a bug</a>  •
  <a href="https://www.algolia.com/doc/api-client/troubleshooting/faq/scala/" target="_blank">FAQ</a>  •
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

#### Install

With [Maven](https://maven.apache.org/), add the following dependency to your `pom.xml` file:

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

In 30 seconds, this quick start tutorial will show you how to index and search objects.

#### ⚡️ Getting Started

To start, you need to initialize the client. To do this, you need your **Application ID** and **API Key**.
You can find both on [your Algolia account](https://www.algolia.com/api-keys).

For full documentation,
visit the **[Algolia Scala API Client](https://www.algolia.com/doc/api-client/getting-started/install/scala/)**.

## ❓ Troubleshooting

Encountering an issue? Before reaching out to support,
we recommend heading to our [FAQ](https://www.algolia.com/doc/api-client/troubleshooting/faq/scala/) where you will find answers for the most common issues and gotchas with the client.

## 📄 License
Algolia Scala API Client is an open-sourced software licensed under the [MIT license](LICENSE).
