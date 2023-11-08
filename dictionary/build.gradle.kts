plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "dev.sukhrob.dictionary"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "dev.sukhrob"
            artifactId = "dictionary"
            version = "1.1"
            artifact("$buildDir/outputs/aar/dictionary-release.aar")
        }

    }

    repositories {
        maven {
            name = "my-lib"
            url = uri("https://maven.pkg.github.com/SukhrobErgashev/oxford-dictionary")
            credentials {
//                username = System.getenv("GITHUB_USER")
//                password = System.getenv("GITHUB_TOKEN")
                username = "SukhrobErgashev"
                password = "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"
            }
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}