pipeline {
  agent any

  tools {
    jdk   'jdk21'
    maven 'maven 3.9'
  }

  options { timestamps() }

  stages {
    stage('Build & Test') {
      steps {
        dir('calculadora') {
          script {
            if (isUnix()) {
              sh 'mvn -B -V -e clean test'
            } else {
              bat 'mvn -B -V -e clean test'
            }
          }
        }
      }
      post {
        always {
          // Publica y archiva los reportes desde la carpeta del proyecto
          dir('calculadora') {
            junit testResults: 'target/surefire-reports/TEST-*.xml',
                  keepLongStdio: true,
                  allowEmptyResults: false
            archiveArtifacts artifacts: 'target/surefire-reports/',
                              allowEmptyArchive: true
          }
        }
      }
    }
  }
}
