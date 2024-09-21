@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.dev.carlosivis.android.library)
    alias(libs.plugins.dev.carlosivis.android.compose)
}
true
android.namespace = "dev.carlosivis.medtrack.core.uikit"
dependencies{
    implementation(libs.coil.compose)
}