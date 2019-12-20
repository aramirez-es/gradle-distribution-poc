plugins {
    `kotlin-dsl`
    `maven-publish`
}

group = "es.aramirez"
version = "0.0.1"

gradlePlugin {
    plugins {
        register("customPlugin") {
            id = "es.aramirez.plugin"
            implementationClass = "es.aramirez.CustomPlugin"
        }
    }
}

publishing {
    repositories {
        mavenLocal()
    }
}

repositories {
    jcenter()
}
