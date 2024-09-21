plugins {
    id("dev.carlosivis.android.library")
    id("kotlin-kapt")
}

android.namespace = "dev.carlosivis.medtrack.data.local"

dependencies {
    implementation(project(":core:commons"))
    //implementation(libs.koin.android)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.gson)
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
}