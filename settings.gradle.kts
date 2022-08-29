rootProject.name = "codegenerator"

include(
    ":cli",
    ":lib",
)

project(":cli").name = "generator-cli"
project(":lib").name = "generator-lib"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}
