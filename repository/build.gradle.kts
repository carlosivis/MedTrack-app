@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.dev.carlosivis.kotlin.domain)
}

dependencies {
    implementation(projects.core.commons)
    implementation(projects.models)
    api(projects.domain.medicine)
    implementation(libs.koin.core)
    implementation(libs.kotlinx.coroutines.core)
}
