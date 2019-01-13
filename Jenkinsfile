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
      steps {
        sh 'gradle sonarqube'
      }
    }
  }
}