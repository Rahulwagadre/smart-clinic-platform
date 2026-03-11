pipeline {
    agent any

    tools {
        maven 'MAVEN3'
        jdk 'JDK17'
    }

    stages {

        stage('Clone Repository') {
            steps {
                git 'https://github.com/Rahulwagadre/smart-clinic-platform.git'
            }
        }

        stage('Build Project') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package Application') {
            steps {
                bat 'mvn clean package'
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