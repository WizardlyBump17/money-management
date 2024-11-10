import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("java")
}

group = "com.wizardlybump17.money-management"
version = "0.1.0"

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

    compileOnly("org.projectlombok:lombok:${lombok}")
    testCompileOnly("org.projectlombok:lombok:${lombok}")
    annotationProcessor("org.projectlombok:lombok:${lombok}")
    testAnnotationProcessor("org.projectlombok:lombok:${lombok}")

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