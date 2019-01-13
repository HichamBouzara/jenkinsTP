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
    stage('Mail notification') {
      steps {
        sh 'ls'
      }
    }
    stage('Code analysis') {
      parallel {
        stage('Code analysis') {
          steps {
            sh 'gradle sonarqube'
          }
        }
        stage('Test reports') {
          steps {
            sh 'gradle jacocoTestReport'
          }
        }
      }
    }
    stage('Deployment') {
      steps {
        sh 'gradle uploadArchives	'
      }
    }
  }
}