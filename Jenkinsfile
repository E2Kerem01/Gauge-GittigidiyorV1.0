pipeline {
    agent any

    stages {
       
        stage('Buid') {
            steps {
                echo 'Building'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing'
            }
        }
        emailext body: 'Test Message',
        subject: 'Test Subject',
        to: 'test@example.com'
        stage('Release') {
            steps {
                echo 'Releasing'
            }
        }
    }
}
