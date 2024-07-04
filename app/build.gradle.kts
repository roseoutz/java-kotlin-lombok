import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    java
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    kotlin("kapt")
    kotlin("plugin.serialization")
    kotlin("plugin.lombok")
    id("io.freefair.lombok")
}

java.sourceCompatibility = JavaVersion.VERSION_17

kapt {
    keepJavacAnnotationProcessors = true
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
    configureEach {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
        exclude(group = "ch.qos.logback", module = "logback-classic")
        exclude(group = "org.apache.logging.log4j", module = "log4j-to-slf4j")
    }
}


dependencies {

    implementation("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework.boot:spring-boot-starter-web") {
        // log4j2 설정을 위해 스프링 부트 기본 로거인 logback 설정 제외한다
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }

    // Log4j2
    implementation("org.springframework.boot:spring-boot-starter-log4j2")

}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

tasks.withType(type = org.jetbrains.kotlin.gradle.internal.KaptGenerateStubsTask::class) {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
}

tasks.withType<Test> {
    useJUnitPlatform()
}