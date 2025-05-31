plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // RoomDB용 kapt 플러그인
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.diary"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.diary"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Room 라이브러리
    implementation(libs.androidx.room.runtime)    // Room 런타임
    kapt(libs.androidx.room.compiler)             // Room 컴파일러
    implementation(libs.androidx.room.ktx)        // Room 코루틴 확장

    // Lifecycle (ViewModel, Runtime KTX) - viewModelScope 사용 위해 필요
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
