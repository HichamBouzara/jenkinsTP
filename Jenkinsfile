pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        sh '''gradle build ;
'''
        sh 'gradle javadoc'
      }
    }
    stage('sonarqube') {
      parallel {
        stage('sonarqube') {
          steps {
            sh 'gradle sonarqube'
          }
        }
        stage('TestReporting') {
          steps {
            sh 'gradle jacocoTestReport'
          }
        }
      }
    }
  }
}