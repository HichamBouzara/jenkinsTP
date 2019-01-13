pipeline {
  agent any
  stages {
    stage('build') {
      parallel {
        stage('build') {
          steps {
            sh 'gradle build'
          }
        }
        stage('archivage') {
          steps {
            sh 'gradle javadoc'
          }
        }
      }
    }
  }
}