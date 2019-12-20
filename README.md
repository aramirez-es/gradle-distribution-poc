# Gradle Custom Distribution PoC

This is a PoC which aims to create a [Custom Gradle Distribution](https://docs.gradle.org/current/userguide/organizing_gradle_projects.html#sec:custom_gradle_distribution)
which would reduce duplication of common configurations needed usually inside mid to big corporations  — specially in a
microservices ecosystem which ends up in tons of repositories, along with standardisation of tasks through plugins
automatically applied.

## Components

This repository consists on three main components:

- The first one is the Custom Distribution itself, placed on [custom-gradle-distribution](./custom-gradle-distribution)
- On the other hand, the [custom-gradle-plugin](./custom-gradle-plugin) contains a custom plugin
- Finally, [example-project](./example-project) is an example of a project which should use both the GCD and the plugin.

On the other hand, the root folder contains some glue code to make everything works together.

## Development

This is repository with multiple Gradle projects (it's not a multimodule Gradle project).
In order for IntelliJ to import all the projects, you can import them by right-clicking on each `build.gradle.kts`
and selecting `Import gradle module`.


### Run

In the parent folder, run:

```bash
$ ./build.sh
```

so that:
- The **plugin** gets published locally.
- The **Gradle Custom Distribution** is created and published locally.
- And, the **example project** gets benefit of both, the tasks defined in the plugin and the common configuration
defined in the distribution.

## Further Read

- [Gradle's Init Scripts](https://docs.gradle.org/current/userguide/init_scripts.html)
- [https://github.com/gradle/gradle/issues/1262
- https://github.com/gradle/gradle/issues/1322

## License

This project is licensed under the MIT License - see the [LICENSE.md](./LICENSE.md) file for details

## Acknowledgement

I got inspired by [John Carter -- warlordofmars](https://github.com/warlordofmars/warlordofmars-gradle)
