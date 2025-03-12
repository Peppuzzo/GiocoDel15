plugins {
  id("application")
  id("org.openjfx.javafxplugin") version "0.0.13"
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(project(":api"))
  implementation("org.openjfx:javafx-controls:17")
  implementation("org.openjfx:javafx-fxml:17")
  implementation("org.openjfx:javafx-graphics:17") // Aggiunto per SceneBuilder
}

javafx {
  version = "17"
  modules("javafx.controls", "javafx.fxml")
}

application {
  mainClass.set("org.example.app.App") // Controlla che questa classe esista
}

tasks.getByName<JavaExec>("run") {
  standardInput = System.`in`
}
