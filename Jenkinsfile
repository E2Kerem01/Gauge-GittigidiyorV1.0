pipeline {
    agent any
    stages {
        stage('git repo & clean') {
            steps {
               
                bat "git clone https://github.com/E2Kerem01/Gauge-GittigidiyorV1.0"
                bat "mvn clean -f Gauge-GittigidiyorV1.0"
            }
        }
        stage('install') {
            steps {
                bat "mvn install -f Gauge-GittigidiyorV1.0"
            }
        }
        stage('test') {
            steps {
                bat "mvn test -f Gauge-GittigidiyorV1.0"
            }
        }
        stage('package') {
            steps {
                bat "mvn package -f Gauge-GittigidiyorV1.0"
            }
        }
    }
}
