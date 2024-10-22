plugins {
    id("dev.carlosivis.android.library")
}

android.namespace = "dev.carlosivis.medtrack.models"

dependencies {
    implementation(projects.domain.medicine)
    implementation(projects.data.local)
    implementation(projects.feature.main)
    implementation(libs.koin.core)
}
