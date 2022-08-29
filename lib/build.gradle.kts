plugins {
    kotlin("jvm")
}

dependencies {
    // openapi spec
    api("io.swagger.parser.v3:swagger-parser:2.1.2")

    // template engine
    implementation("io.pebbletemplates:pebble:3.1.5")

    // arrow
    implementation(platform("io.arrow-kt:arrow-stack:1.1.2"))
    implementation("io.arrow-kt:arrow-core")

    // logging
    implementation("org.slf4j:slf4j-api:2.0.0")
    implementation("ch.qos.logback:logback-classic:1.4.0")

    // test
    testImplementation(kotlin("test"))
}
