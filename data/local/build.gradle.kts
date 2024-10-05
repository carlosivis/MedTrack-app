plugins {
    id("dev.carlosivis.android.library")
    id("com.google.devtools.ksp")
}

android.namespace = "dev.carlosivis.medtrack.data.local"

dependencies {
    implementation(projects.core.commons)
    implementation(projects.repository)
    implementation(projects.models)
    implementation(libs.koin.android)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.gson)
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
}