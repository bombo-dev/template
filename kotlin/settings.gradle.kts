plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "multi-kotlin"

include(
    "common-libs:logging",
    "common-libs:monitoring",
    "common-libs:util",
    "common-libs:tests",
    "apps:internal-api",
    "libs:storage:db-core",
    "libs:http-client",
    "libs:application",
)
