@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.dev.carlosivis.kotlin.domain)
}
true

dependencies {
    implementation(projects.domain.medicine)
    implementation(projects.data.local)
    implementation(libs.koin.core)
}
