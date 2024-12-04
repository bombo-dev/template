dependencies {
    implementation(project(":common-libs:logging"))
    implementation(project(":common-libs:util"))
    implementation(project(":libs:application"))

    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}
