pipeline {
  agent any
  stages {
    stage('Cp application.yml') {
      steps {
        sh '''mkdir /root/.jenkins/workspace/parking_lot_sms_back_end_master/src/main/resources/
cp /mavenConfig/application.yml /root/.jenkins/workspace/parking_lot_sms_back_end_master/src/main/resources/application.yml'''
      }
    }
    stage('Maven Build') {
      steps {
        sh 'maven install'
      }
    }
  }
}