dependencies {
    implementation(project(":common-libs:logging"))
    implementation(project(":common-libs:util"))
    implementation(project(":common-libs:monitoring"))

    runtimeOnly(project(":libs:storage:db-core"))
    runtimeOnly(project(":libs:http-client"))
    implementation("org.springframework:spring-context")
    implementation("org.springframework:spring-tx")
}
