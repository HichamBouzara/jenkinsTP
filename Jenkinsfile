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
        mail(subject: 'notification ', body: 'new deployment', to: 'fa_benrandja@esi.dz')
      }
    }
    stage('Code analysis') {
      parallel {
        stage('Code analysis') {
          steps {
            sh 'gradle sonarqube'
          }
        }
        stage('SonarQube') {
                    steps {
                       
                        withSonarQubeEnv('sonarqube') {
                          sh '/home/d3v/Downloads/d3v.deb/sonra/sonar-scanner-3.2.0.1227-linux/bin/sonar-scanner'
                        }
                          waitForQualityGate abortPipeline: false
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