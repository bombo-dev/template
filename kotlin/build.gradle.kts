import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version Versions.springBootVersion apply false
    id("io.spring.dependency-management") version Versions.springDependencyManagementPluginVersion apply false
    id("com.coditory.integration-test") version Versions.integrationTestPluginVersion apply false
    kotlin("plugin.serialization") version Versions.kotlinVersion apply false
    kotlin("jvm") version Versions.kotlinVersion apply false
    kotlin("kapt") version Versions.kotlinVersion apply false
    kotlin("plugin.spring") version Versions.kotlinVersion apply false
    kotlin("plugin.jpa") version Versions.kotlinVersion apply false
}


allprojects {
    group = "com.bombo.template"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.jetbrains.kotlin.kapt")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")
    apply(plugin = "com.coditory.integration-test")
    apply(plugin = "org.jetbrains.kotlin.plugin.serialization")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    configure<DependencyManagementExtension> {
        imports {
            mavenBom("org.springframework.cloud:spring-cloud-dependencies:${Versions.springCloudDependenciesVersion}")
        }
        dependencies {
            dependency("io.mockk:mockk:${Versions.mockkVersion}")
            dependencySet("com.epages:${Versions.restdocsApiSepcVersion}") {
                entry("restdocs-api-spec")
                entry("restdocs-api-spec-mockmvc")
                entry("restdocs-api-spec-restassured")
                entry("restdocs-api-spec-webtestclient")
            }
        }
    }

    dependencies {
        val implementation by configurations
        val testImplementation by configurations
        val testRuntimeOnly by configurations
        val integrationImplementation by configurations
        val integrationRuntimeOnly by configurations

        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

        testImplementation("org.junit.jupiter:junit-jupiter-api")
        testImplementation("org.junit.jupiter:junit-jupiter-params")
        testImplementation("org.assertj:assertj-core")
        testImplementation("org.mockito:mockito-core")
        testImplementation("org.mockito:mockito-junit-jupiter")
        testImplementation("io.mockk:mockk")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

        integrationImplementation("org.junit.jupiter:junit-jupiter-api")
        integrationImplementation("org.junit.jupiter:junit-jupiter-params")
        integrationImplementation("org.assertj:assertj-core")
        integrationImplementation("org.mockito:mockito-core")
        integrationImplementation("org.mockito:mockito-junit-jupiter")
        integrationImplementation("io.mockk:mockk")
        integrationRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = Versions.javaVersion
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.getByName<BootJar>("bootJar") {
        enabled = false
    }

    tasks.getByName<Jar>("jar") {
        enabled = true
    }
}
