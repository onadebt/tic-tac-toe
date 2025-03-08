plugins {
    id("java")
    kotlin("jvm")
    checkstyle
    id("org.openrewrite.rewrite") version("7.1.7")
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
    implementation(kotlin("stdlib-jdk8"))
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

rewrite {

}

checkstyle {
    toolVersion = "10.21.4"
}