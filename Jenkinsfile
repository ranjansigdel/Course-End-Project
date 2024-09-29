pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git 'https://github.com/ranjansigdel/Course-End-Project.git'
            }
        }
        stage('Build') {
            steps {
                sh 'npm install'  // or your project's build command
            }
        }
        stage('Test') {
            steps {
                sh 'npm test'  // or your project's test command
            }
        }
        stage('Deploy') {
            steps {
                sh 'scp -r * tomcat@9090:/path/to/tomcat/webapps/'
            }
        }
    }
}
