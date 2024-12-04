dependencies {
    implementation("org.springframework:spring-context:6.1.14")
    runtimeOnly(project(":libs:storage:db-core"))
    implementation(project(":libs:client"))
}
