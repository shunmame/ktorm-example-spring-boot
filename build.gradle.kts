import com.google.protobuf.gradle.id
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	// spring-initializer
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.20"
	kotlin("plugin.spring") version "1.9.20"

	// protobuf
	id("com.google.protobuf") version "0.9.4"

	// ktorm
	id("com.google.devtools.ksp") version "1.9.20-1.0.14"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	// spring-initializer
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// grpc
	implementation("io.github.lognet:grpc-spring-boot-starter:5.1.5")
	implementation("javax.annotation:javax.annotation-api:1.3.2")

	// jdbc
	implementation("org.springframework.boot:spring-boot-starter-jdbc:3.1.5")

	// ktorm
	implementation("org.postgresql:postgresql:42.6.0")
	implementation("org.ktorm:ktorm-core:3.6.0")
	implementation("org.ktorm:ktorm-support-postgresql:3.6.0")
	implementation("org.ktorm:ktorm-ksp-api:1.0.0-RC3")
	ksp("org.ktorm:ktorm-ksp-compiler:1.0.0-RC3")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

protobuf {
	protoc {
		artifact = "com.google.protobuf:protoc:3.25.0"
	}
	plugins{
		id("grpc"){
			artifact = "io.grpc:protoc-gen-grpc-java:1.59.0"
		}
	}
	generateProtoTasks{
		all().forEach{
			it.plugins{
				id("grpc")
			}
		}
	}
}
