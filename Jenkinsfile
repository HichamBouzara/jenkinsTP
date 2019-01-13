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
    stage('sonarqube') {
      steps {
        sh '''/home/d3v/Downloads/d3v.deb/sonra/sonar-scanner-3.2.0.1227-linux/bin/sonar-scanner  /home/d3v/Desktop/jenkins/
'''
      }
    }
  }
}