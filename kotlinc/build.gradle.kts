plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "org.jetbrains.kotlin"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

configurations.all {
    exclude("org.jline", "jline")
}
dependencies {
    implementation("org.lsposed.hiddenapibypass:hiddenapibypass:4.3")

    implementation("org.jetbrains.kotlin:kotlin-scripting-compiler:1.8.21")
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:1.8.21")
    implementation("io.github.itsaky:nb-javac-android:17.0.0.3")
    implementation("org.jetbrains.intellij.deps:trove4j:1.0.20200330")
    implementation("org.jdom:jdom:2.0.2")

    implementation(files("libs/jaxp.jar"))
    api(files("libs/kotlin-compiler-1.9.0-RC.jar"))

    compileOnly(files("libs/the-unsafe.jar"))
}
