pipeline {
    agent any

    tools {
        maven 'MAVEN3'
        jdk 'JDK17'
    }

    stages {

        stage('Clone Repository') {
            steps {
                git branch: 'dev', url: 'https://github.com/Rahulwagadre/smart-clinic-platform.git'
            }
        }

        stage('Build Project') {
            steps {
                dir('backend/smart-clinic-api') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage('Run Tests') {
            steps {
                dir('backend/smart-clinic-api') {
                    bat 'mvn test'
                }
            }
        }

        stage('Package Application') {
            steps {
                dir('backend/smart-clinic-api') {
                    bat 'mvn clean package'
                }
            }
        }

    }

    post {
        success {
            echo 'Build Successful!'
        }
        failure {
            echo 'Build Failed!'
        }
    }
}