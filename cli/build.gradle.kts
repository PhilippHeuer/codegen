plugins {
    kotlin("jvm")
    application
}

dependencies {
    // cli
    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.5")

    // lib
    implementation(project(":generator-lib"))

    // logging
    implementation("org.slf4j:slf4j-api:2.0.0")
    implementation("ch.qos.logback:logback-classic:1.4.0")

    // test
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("generator.cli.MainKt")
}

configurations {
    all {
        exclude(group = "'org.slf4j", module = "slf4j-simple")
    }
}
