rootProject.name = "java-kotlin-combine"

include(":app")

pluginManagement {
    // gradle.properties 에서 가져온다
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    val liquibaseVersion: String by settings
    val querydslPluginVersion: String by settings
    val jvmConverterVersion: String by settings
    val lombokPluginVersion: String by settings

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.kapt" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.spring" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.jpa" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.serialization" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.lombok" -> useVersion(kotlinVersion)
                "org.springframework.boot" -> useVersion(springBootVersion)
                "io.spring.dependency-management" -> useVersion(springDependencyManagementVersion)
                "org.liquibase.gradle" -> useVersion(liquibaseVersion)
                "org.asciidoctor.jvm.convert" -> useVersion(jvmConverterVersion)
                "com.ewerk.gradle.plugins.querydsl" -> useVersion(querydslPluginVersion)
                "io.freefair.lombok" -> useVersion(lombokPluginVersion)
            }
        }
    }
}
