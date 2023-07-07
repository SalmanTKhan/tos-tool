plugins {
    alias(libs.plugins.kotlin.jvm)
    application
}

group = "net.ormr.tos"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.clikt)

    implementation(libs.jdom2)
    implementation(libs.jaxen)

    implementation(libs.kxml2)

    implementation(libs.bundles.slf4j)

    testImplementation(kotlin("test"))
}

tasks {
    test {
        useJUnitPlatform()
    }

    compileKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}

application {
    mainClass.set("MainKt")
}

allprojects {
    repositories {
        mavenCentral()
    }
}