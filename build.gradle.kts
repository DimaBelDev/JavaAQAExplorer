plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    implementation("org.seleniumhq.selenium:selenium-java:4.18.0")
}

tasks.test {
    useJUnitPlatform()
}