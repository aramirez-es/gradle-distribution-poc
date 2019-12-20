plugins {
    // Base is the one that defines the base build lifecycle.
    // Further read on https://docs.gradle.org/current/userguide/base_plugin.html
    base
}

tasks {
    val plugin by registering(GradleBuild::class) {
        dir = file("custom-gradle-plugin")
        tasks = listOf("clean", "publish")
    }

    val exampleProject by registering(GradleBuild::class) {
        dir = file("example-project")
        tasks = listOf("clean", "build", "run", "showRepositories")
        dependsOn(plugin)
    }

    get("build").dependsOn(exampleProject)
}
