pipeline {
    agent any

    environment {
        DOCKERHUB_USER = 'haroldbg'
        DOCKERHUB_CREDENTIALS = 'dockerhub-token'
        IMAGE_BACKEND = 'task-movil-api'
    }

    stages {

        stage('Build Backend') {
            steps {
                echo '⚙️ Construyendo imagen del backend...'
                sh 'docker build -t $DOCKERHUB_USER/$IMAGE_BACKEND:latest .'
            }
        }

        stage('Push to DockerHub') {
            steps {
                echo '⬆️ Subiendo imagen a Docker Hub...'
                withCredentials([string(credentialsId: "$DOCKERHUB_CREDENTIALS", variable: 'DOCKERHUB_PASS')]) {
                    sh 'echo $DOCKERHUB_PASS | docker login -u $DOCKERHUB_USER --password-stdin'
                    sh 'docker push $DOCKERHUB_USER/$IMAGE_BACKEND:latest'
                }
            }
        }

        stage('Deploy with Docker Compose') {
            steps {
                echo '🚀 Desplegando contenedores (PostgreSQL + Backend)...'
                sh 'docker-compose down || true'
                sh 'docker-compose up -d --build'
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline completado exitosamente.'
        }
        failure {
            echo '❌ Error en el pipeline. Revisa los logs.'
        }
    }
}

