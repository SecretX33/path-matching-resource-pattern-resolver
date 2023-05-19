plugins {
    id("java-library")
    id("maven-publish")
}

group = "io.github.secretx33"
version = "0.1"

repositories {
    mavenCentral()
}

val javaVersion = 11

dependencies {
    compileOnly("org.jetbrains:annotations:24.0.1")
    compileOnly("org.checkerframework:checker-qual:3.34.0")
}

tasks.test {
    useJUnitPlatform()
}

java {
    withJavadocJar()
    withSourcesJar()
}

tasks.withType<JavaCompile> {
    options.apply {
        release.set(javaVersion)
        encoding = "UTF-8"
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}

tasks.javadoc {
    val options = options as StandardJavadocDocletOptions
    if (JavaVersion.current().isJava9Compatible) {
        options.addBooleanOption("html5", true)
    }
    options.addStringOption("Xdoclint:none", "-quiet")
}
