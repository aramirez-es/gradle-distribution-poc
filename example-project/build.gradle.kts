plugins {
    kotlin("jvm") version "1.3.61"
    application
}

group = "es.aramirez"
version = "0.0.1"

application.mainClassName = "Testing"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.apache.commons:commons-lang3:3.0")
}
