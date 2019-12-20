initscript {
    repositories {
        mavenLocal()
    }
    dependencies {
        /**
         * This issue https://github.com/gradle/gradle/issues/1322 causes external plugins (the ones that reside
         * outside of this custom distribution) can not be applied by ID in a initscript. The workaround is to add
         * the plugins as dependencies into the classpath first, then apply then to the projects using the plugin's
         * implementation class instead of the Plugin's ID.
         */
        classpath("es.aramirez:custom-gradle-plugin:0.0.1")
    }
}

gradle.projectsEvaluated {
    rootProject.allprojects {
        apply<es.aramirez.CustomPlugin>()
    }
}
