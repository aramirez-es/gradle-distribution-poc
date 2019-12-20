package es.aramirez

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.invoke

class CustomPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.run {
            tasks {
                register("showRepositories") {
                    doLast {
                        println("Configured Repositories:")
                        project.repositories.forEach { println(it.name) }
                    }
                }
            }
        }
    }
}
