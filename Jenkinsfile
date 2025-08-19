pipeline {
  agent any

  tools {
    jdk   'jdk21'        // ← nombre exacto según Tools
    maven 'maven 3.9'    // ← nombre exacto según Tools
  }

  options { timestamps() }

  stages {
    stage('Build & Test') {
      steps {
        script {
          // Detecta dónde está el pom.xml
          def pomPath = fileExists('calculadora/pom.xml') ? 'calculadora/pom.xml' : 'pom.xml'
          if (isUnix()) {
            sh "mvn -B -V -e -f '${pomPath}' clean test"
          } else {
            bat "mvn -B -V -e -f \"${pomPath}\" clean test"
          }
        }
      }
    }
  }

  post {
    always {
      junit '/target/surefire-reports/*.xml'
      archiveArtifacts artifacts: '/target/surefire-reports/*.xml', allowEmptyArchive: true
    }
  }
}
