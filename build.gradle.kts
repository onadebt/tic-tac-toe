plugins {
    id("java")
    kotlin("jvm")
    checkstyle
    id("org.openrewrite.rewrite") version ("7.1.7")
    id("com.github.spotbugs") version "6.1.7"
    id("application")
}

group = "cz.muni.fi.pv260.team4.tictactoe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")

    testCompileOnly("org.projectlombok:lombok:1.18.36")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.36")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    spotbugsPlugins("com.h3xstream.findsecbugs:findsecbugs-plugin:1.13.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "cz.muni.fi.pv260.team4.tictactoe.Main"
    }
    from(configurations.runtimeClasspath.get().map(::zipTree))
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

application {
    mainClass = "cz.muni.fi.pv260.team4.tictactoe.Main"
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

rewrite {

}

checkstyle {
    toolVersion = "10.21.4"
}

spotbugs {
    toolVersion = "4.9.2"
    excludeFilter = File("${project.rootDir}/config/spotbugs/spotbugs-exclude.xml")
}