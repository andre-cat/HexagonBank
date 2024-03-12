# HEXAGONAL ARCHITECTURE PROJECT

## Plugin scaffold-clean-architecture set up

1. Install [Java]
1. Install a [Gradle].
> ⚠️️ _It must be a [compatible version][gradle-java-compatibility] with the installed Java_
1. Create project folder
1. Open the project folder
1. Create `build.gradle` file with next command:
````gradle
plugins {
    id "co.com.bancolombia.cleanArchitecture" version "3.15.1"
}
````
1. Execute the next content:

```bash
gradle cleanArchitecture --package=co.com.hexagonbank --type=reactive --name=HexagonBank --coverage=jacoco --lombok=true --metrics=true --language=JAVA --javaVersion=VERSION_21
```

> **Note:** If you select Java 21 than you must make this operation with Gradle 8.4.

Then you can run the [following plugin](#plugin-commands) commands to create the elements on your project structure.

## Plugin commands

### Create modules

#### Model

`gradle generateModel --name=[modelName]`

#### Use case

`gradle generateUseCase --name=[useCaseName]`

#### Driven adapter

`gradle generateDrivenAdapter --type=[drivenAdapterType]`

#### Entry point

`gradle generateEntryPoint --type=[entryPointType]`

#### Helper

`gradle generateHelper --name=[helperName]`

### Delete modules

`gradle deleteModule --module=[name]`

[java]: https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html
[gradle]: https://gradle.org/releases/
[gradle-java-compatibility]: https://docs.gradle.org/current/userguide/compatibility.html