plugins {
    kotlin("jvm") version "2.0.20"
    kotlin("plugin.serialization") version "2.0.20"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.algolia:algoliasearch-client-kotlin")
    implementation("io.ktor:ktor-client-okhttp:2.3.12")
    implementation("ch.qos.logback:logback-classic:1.5.7")
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")
}

tasks.test {
    useJUnitPlatform()
}