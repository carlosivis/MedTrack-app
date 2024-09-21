pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")


rootProject.name = "MedTrack"
include(":app")
include(":data:local")
include(":data:remote")
include(":core:core")
include(":core:navigation")
include(":core:commons")
include(":core:uikit")
include(":domain:medicine")
include(":models")
include(":feature:main")
include(":repository")
