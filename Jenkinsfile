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
        sh 'mvn install'
      }
    }
    stage('Deploy To Staging') {
      steps {
        sh '''cp /root/.jenkins/workspace/parking_lot_sms_back_end_master/target/sms-0.0.1-SNAPSHOT.jar /workspace/BackEnd/sms.jar
cd /workspace/BackEnd
p=`jps -l | grep sms | grep -P \'\\d+\' -o`
sudo kill -9 $p
JENKINS_NODE_COOKIE=dontKillMe
nohup java -jar sms.jar >run.txt 2>&1 &'''
      }
    }
  }
}