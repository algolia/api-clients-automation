plugins {
    kotlin("jvm") version "2.1.10"
    kotlin("plugin.serialization") version "2.1.10"
    id("application")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.algolia:algoliasearch-client-kotlin")
    implementation("io.ktor:ktor-client-okhttp:3.0.3")
    implementation("ch.qos.logback:logback-classic:1.5.16")
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.2")
}

tasks.test {
    useJUnitPlatform()
}

application {
  mainClass.set("com.algolia.playground.${property("client")}Kt")
}
