import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("me.philippheuer.configuration") version "0.4.5"
    kotlin("jvm") version "1.7.10"
    application
}

projectConfiguration {
    language.set(me.philippheuer.projectcfg.domain.ProjectLanguage.KOTLIN)
    type.set(me.philippheuer.projectcfg.domain.ProjectType.APP)
    javaVersion.set(JavaVersion.VERSION_17)
}

group = "me.philipp.heuer"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // cli
    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.5")

    // kotlin test
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("generator.cli.MainKt")
}
