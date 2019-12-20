gradle.settingsEvaluated {
    gradle.projectsEvaluated {
        rootProject.allprojects {
            repositories.clear()
            // Here you can configure your company's private repoiroty as follows:
            // https://docs.gradle.org/current/userguide/declaring_repositories.html#sub:accessing_secured_ivy_repositories
            repositories {
                mavenCentral {
                    name = "CompanyCustomRepository"
                }
            }
        }

        pluginManagement {
            repositories.clear()
            repositories {
                mavenCentral {
                    name = "CompanyCustomRepositoryForPlugins"
                }
            }
        }

        buildCache {
            local<DirectoryBuildCache> {
                isEnabled = true
            }

            // Here you can configure remote cache
            // https://docs.gradle.org/current/userguide/build_cache.html#sec:build_cache_configure
        }
    }
}
