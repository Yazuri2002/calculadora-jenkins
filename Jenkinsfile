pipeline {
  agent any

  // Ajusta los nombres si en Tools los tienes distintos,
  // o elimina por completo este bloque si prefieres usar el PATH del agente.
  tools {
    jdk 'jdk-21'
    maven 'maven'
  }

  options { timestamps() }

  stages {
    stage('Checkout') {
      steps {
        checkout scm   // en Pipeline from SCM es redundante pero inofensivo
      }
    }

    stage('Build & Test') {
      steps {
        script {
          // Detecta dónde está el POM: en la raíz o dentro de "calculadora/"
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
      // Publica resultados de pruebas y archiva los XML
      junit '/target/surefire-reports/*.xml'
      archiveArtifacts artifacts: '/target/surefire-reports/*.xml', allowEmptyArchive: true
    }
  }
}
