plugins {
    id("fabric-loom") version "1.2-SNAPSHOT"
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://maven.fabricmc.net/") }
}

dependencies {
    // To change the versions see the gradle.properties file
    minecraft("com.mojang:minecraft:1.16.1")
    mappings("net.fabricmc:yarn:1.16.1+build.21:v2")
    modImplementation("net.fabricmc:fabric-loader:0.14.21")

    // Fabric API
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.16.2+build.385-1.16.1")
}

tasks {
    processResources {
        inputs.property("version", project.version)

        filesMatching("fabric.mod.json") {
            expand(mutableMapOf("version" to project.version))
        }
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        withSourcesJar()
    }

    jar {
        from("LICENSE")
    }
}
