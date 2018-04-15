plugins {
    java
}

repositories {
    jcenter()
}

var JUnitVersion = "5.1.1"

dependencies {
    testCompile("org.junit.jupiter:junit-jupiter-api:${JUnitVersion}")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:${JUnitVersion}")
}

tasks {
    "test" (Test::class) {
        useJUnitPlatform()
    }
}