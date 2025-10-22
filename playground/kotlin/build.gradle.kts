plugins {
    kotlin("jvm") version "2.2.20"
    kotlin("plugin.serialization") version "2.2.20"
    id("application")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.algolia:algoliasearch-client-kotlin")
    implementation("io.ktor:ktor-client-okhttp:3.3.1")
    implementation("ch.qos.logback:logback-classic:1.5.20")
    implementation("io.github.cdimascio:dotenv-kotlin:6.5.1")
}

tasks.test {
    useJUnitPlatform()
}

application {
  mainClass.set("com.algolia.playground.${property("client")}Kt")
}
