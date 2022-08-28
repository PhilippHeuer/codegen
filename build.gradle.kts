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

dependencies {
    // cli
    implementation("org.jetbrains.kotlinx:kotlinx-cli:0.3.5")

    // openapi spec
    implementation("io.swagger.parser.v3:swagger-parser:2.1.2")

    // logging
    implementation("org.slf4j:slf4j-api:2.0.0")
    implementation("org.apache.logging.log4j:log4j:2.18.0")

    // test
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("generator.cli.MainKt")
}
