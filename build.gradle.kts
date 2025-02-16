import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("java")
    id("com.palantir.git-version") version "3.1.0"
}

apply(plugin = "java")
apply(plugin = "com.palantir.git-version")

val gitVersion: groovy.lang.Closure<String> by extra

println(properties["version"])

group = "com.wizardlybump17.money-management"
version = "${properties["version"]}-${gitVersion()}"

repositories {
    mavenCentral()
}

val junit = "5.11.0"
val lombok = "1.18.34"
val jetbrainsAnnotations = "24.1.0"
val bigMath = "2.3.2"

dependencies {
    testImplementation(platform("org.junit:junit-bom:${junit}"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    compileOnly("org.jetbrains:annotations:${jetbrainsAnnotations}")
    testCompileOnly("org.jetbrains:annotations:${jetbrainsAnnotations}")
    annotationProcessor("org.jetbrains:annotations:${jetbrainsAnnotations}")
    testAnnotationProcessor("org.jetbrains:annotations:${jetbrainsAnnotations}")

    implementation("ch.obermuhlner:big-math:${bigMath}")
}

tasks {
    test {
        useJUnitPlatform()
        testLogging {
            events(TestLogEvent.STARTED, TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED, TestLogEvent.STANDARD_OUT, TestLogEvent.STANDARD_ERROR)
        }
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(21)
    }

    java {
        withSourcesJar()
    }
}