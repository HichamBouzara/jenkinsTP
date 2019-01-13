pipeline {
  agent any
  stages {
    stage('build') {
      parallel {
        stage('build') {
          steps {
            sh '''gradle build ;
gradle javadoc'''
          }
        }
        stage('archivage') {
          steps {
            sh 'gradle javadoc'
          }
        }
      }
    }
    stage('sonarqube') {
      steps {
        sh 'gradle sonarqube'
      }
    }
  }
}