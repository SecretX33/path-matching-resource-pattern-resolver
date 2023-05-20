plugins {
    `java-library`
    `maven-publish`
    signing
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
            artifactId = rootProject.name
            from(components["java"])
            versionMapping {
                usage("java-api") {
                    fromResolutionOf("runtimeClasspath")
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
            pom {
                name.set(rootProject.name)
                description.set("Flexible resource pattern resolution library for Java applications. ")
                url.set("https://github.com/SecretX33/path-matching-resource-pattern-resolver")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                developers {
                    developer {
                        id.set("secretx33")
                        name.set("SecretX")
                        email.set("notyetmidnight@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com:SecretX33/path-matching-resource-pattern-resolver.git")
                    developerConnection.set("scm:git:ssh://github.com:SecretX33/path-matching-resource-pattern-resolver.git")
                    url.set("https://github.com/SecretX33/path-matching-resource-pattern-resolver")
                }
            }
        }
    }

    signing {
        useGpgCmd()
        sign(publishing.publications["maven"])
    }

    repositories {
        maven {
            credentials {
                username = System.getenv("SONATYPE_USER")
                password = System.getenv("SONATYPE_PASSWORD")
            }
            url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
        }
    }

    tasks.javadoc {
        val options = options as StandardJavadocDocletOptions
        if (JavaVersion.current().isJava9Compatible) {
            options.addBooleanOption("html5", true)
        }
        options.addStringOption("Xdoclint:none", "-quiet")
    }
}