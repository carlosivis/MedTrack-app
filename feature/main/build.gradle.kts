@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.dev.carlosivis.android.feature)
    alias(libs.plugins.dev.carlosivis.android.compose)
    id("kotlin-parcelize")
}
true

android.namespace = "dev.carlosivis.medtrack.presentation.main"

dependencies {
    implementation(projects.domain.medicine)
    implementation(platform(libs.kotlin.bom))
    implementation(libs.coil.compose)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.accompanist.placeholder)
    implementation(libs.androidx.material3.android)
}