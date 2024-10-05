plugins {
    id("dev.carlosivis.android.library")
}

android.namespace = "dev.carlosivis.medtrack.repository"

dependencies {
    implementation(projects.core.commons)
    implementation(projects.models)
    api(projects.domain.medicine)
    implementation(libs.koin.core)
    implementation(libs.kotlinx.coroutines.core)
}
