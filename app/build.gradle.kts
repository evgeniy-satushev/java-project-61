plugins {
    id("java")
    id("checkstyle")
    id("se.patrikerdes.use-latest-versions") version "0.2.18"
    id("com.github.ben-manes.versions") version "0.41.0"
    application
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("hexlet.code.App")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.13.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.apache.commons:commons-math3:3.6.1")
    testImplementation("junit:junit:4.13.1")

}
tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}
tasks.jar {
    manifest {
        attributes(mapOf("Main-Class" to application.mainClass))
    }
}