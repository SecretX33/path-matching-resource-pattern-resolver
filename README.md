# PathMatchingResourcePatternResolver

The `path-matching-resource-pattern-resolver` library is a small extraction from the Spring Framework's `PathMatchingResourcePatternResolver` class and its dependencies. It provides a standalone implementation that can be used in any Java project without requiring the entire Spring Framework. This library is self-contained and requires no additional dependencies.

## What it does

The `PathMatchingResourcePatternResolver` is a class that provides a powerful mechanism for resolving resources using Ant-style path patterns. It is particularly useful when you need to locate and load resources dynamically in a Java application.

The primary purpose of `PathMatchingResourcePatternResolver` is to find resources within a specified location or classpath based on a given pattern. It supports various resource types, including files, directories, and classpath resources. The pattern matching follows the conventions of Ant-style wildcard matching, allowing you to specify patterns with wildcards, such as `*` and `**`, to match multiple resources.

### Main advantages

The main advantages of using `PathMatchingResourcePatternResolver` are:

1. **Flexible resource resolution**: It allows you to define complex patterns to match resources based on specific criteria, such as file extensions, directories, or nested subdirectories.

2. **Classpath scanning**: It simplifies the process of scanning the classpath to locate resources dynamically. This is especially useful when you need to load resources at runtime, such as configuration files or template files.

3. **Support for various resource types**: It can resolve different types of resources, including files from the file system, resources from the classpath, or even resources from remote locations, allowing for a wide range of use cases.

## When should I use it

Consider using `PathMatchingResourcePatternResolver` when you need to dynamically locate and load resources in your Java project, especially if you require pattern-based matching or classpath scanning functionality. It provides a convenient and efficient way to handle resources, making it easier to manage and process them within your application.

## Credits

This library is made from classes extracted from the Spring Framework project, which can be found at [https://github.com/spring-projects/spring-framework](https://github.com/spring-projects/spring-framework). All credits for the original implementation go to the contributors and maintainers of the Spring Framework.

## Usage

To use the `path-matching-resource-pattern-resolver` library in your Java project, you can include it as a dependency from your build tool. It is published in Maven Central.

### 1. Import the library in your favorite build tool 

### Maven

Add the following dependency to your project's `pom.xml` file.

```xml
<dependency>
    <groupId>io.github.secretx33</groupId>
    <artifactId>path-matching-resource-pattern-resolver</artifactId>
    <version>0.1</version>
</dependency>
```

### Gradle

Add the following dependency to your project's `build.gradle` file.

```kts
implementation 'io.github.secretx33:path-matching-resource-pattern-resolver:0.1'
```

### Gradle (KTS)

Add the following dependency to your project's `build.gradle.kts` file.

```kts
implementation("io.github.secretx33:path-matching-resource-pattern-resolver:0.1")
```

### 2. In code

In in your Java code, follow the steps below.

1. Instantiate the resource resolver:

```java
ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
```

2. Use the resolver to find resources based on a given pattern:

```java
Resource[] resources = resolver.getResources("classpath:com/example/**/*.xml");
```

3. Process the obtained resources according to your project's needs.

## Examples

Here are a few examples to demonstrate how to use the `path-matching-resource-pattern-resolver` library:

### Find all XML files in a directory and its subdirectories:

```java
ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
Resource[] resources = resolver.getResources("classpath:com/example/**/*.xml");

for (Resource resource : resources) {
    // Process the resource
}
```

### Find all properties files in a specific package:

```java
ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
Resource[] resources = resolver.getResources("classpath:com/example/*.properties");

for (Resource resource : resources) {
    // Process the resource
}
```

### Load a single resource by its path:

```java
ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
Resource resource = resolver.getResource("classpath:com/example/config.properties");

if (resource.exists()) {
    // Process the resource
}
```

Please refer to the Spring Framework's documentation for more details on the supported resource patterns and their usage.

## Compiling

This project requires at least Java 11 in order to build and run. Use this command to build the project:

```shell
./gradlew build
```

## Issues

If you encounter any issues or have suggestions for improvement, please report them in the [issue tracker](https://github.com/SecretX33/path-matching-resource-pattern-resolver/issues) of the repository.

## Support

For support, please consult the Spring Framework's official documentation.

## License

This library is distributed under the Apache License 2.0, which is the same license used by the Spring Framework. Please refer to the [LICENSE](LICENSE) file for more details.

## Acknowledgments

We would like to express our gratitude to the Spring Framework community for their continuous support and contributions. Without their efforts, this library would not have been possible.

## Disclaimer

This library is provided as-is, without any warranties or guarantees. Use it at your own risk.
