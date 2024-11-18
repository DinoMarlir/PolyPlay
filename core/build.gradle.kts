plugins {
    id("java")
    alias(libs.plugins.jvm)
}

dependencies {
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    compileOnly(libs.annotations)
}