plugins {
	kotlin("jvm") version "1.9.22" // Testar com versão compatível
	kotlin("plugin.spring") version "1.9.22"
	id("org.springframework.boot") version "3.2.2" // Atualizado para versão estável
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.matheusroldao"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(17))
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}
tasks.withType<Test> {
	useJUnitPlatform()

	testLogging {
		events(
			org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED,
			org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED,
			org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
			org.gradle.api.tasks.testing.logging.TestLogEvent.STANDARD_OUT
		)
		showExceptions = true
		showCauses = true
		showStackTraces = true
		exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	compileOnly("org.projectlombok:lombok")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2") // Removida duplicata
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
