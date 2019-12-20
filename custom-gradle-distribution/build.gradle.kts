import org.gradle.distribution.DownloadGradle

plugins {
    base
    kotlin("jvm") version "1.3.61"
    `kotlin-dsl`
}

group = "es.aramirez"
version = "0.0.1"

tasks {
    val makeBuildDir by register("makeBuildDir") {
        doFirst {
            file(buildDir).mkdirs()
        }
    }

    val downloadGradle by register<DownloadGradle>("downloadGradle") {
        dependsOn(makeBuildDir)
        description = "Downloads the Gradle distribution with a given version."
        gradleVersion = "5.6.2"
        destinationDir = file(buildDir)
    }

    val customGradleDistribution by register<Zip>("customGradleDistribution") {
        dependsOn(downloadGradle)
        description = "Builds custom Gradle distribution and bundles initialization scripts."
        archiveName = "custom-gradle-distro-${downloadGradle.gradleVersion}-bin.zip"
        from(zipTree(downloadGradle.getDestinationFile()))
        into("${downloadGradle.getDistributionNameBase()}/init.d") {
            from("src/init.d")
        }
    }

    getByName("build").dependsOn(customGradleDistribution)
}

defaultTasks = mutableListOf("customGradleDistribution")

dependencies {
    implementation(kotlin("stdlib"))
}
repositories {
    mavenCentral()
}
