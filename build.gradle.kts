import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("kapt") version "1.9.10"
    application
}

group = "org.setu.gwalsh"
version = "1.1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.slf4j:slf4j-simple:1.6.1")
    implementation("io.github.microutils:kotlin-logging:1.6.22")
    implementation("com.google.code.gson:gson:2.8.9")

    kapt ("info.picocli:picocli-codegen:4.7.5")
    implementation ("info.picocli:picocli:4.7.5")
}

kapt {
    arguments {
        arg("project", "${project.group}/${project.name}")
    }
}

val jar by tasks.getting(Jar::class) {

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    manifest {
        attributes["Main-Class"] = "MainKt"
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }) {
        exclude("META-INF/*.RSA", "META-INF/*.SF", "META-INF/*.DSA")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "16"
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

application {
    mainClass.set("org.setu.gwalsh.console.main.MainKt")
}

//kotlin {
//    jvmToolchain(8)
//}