pipeline {

    agent any
    
    environment {
        //DOCKER_IMAGE = "your-registry/power-calc-service:${env.BUILD_ID}"
        REGISTRY_URL = "https://index.docker.io"
        REGISTRY_CREDS = "glob-docker-hub-creds"
        IMAGE_NAME = "pavel37/power-calc-service"
        DOCKER_IMAGE = "${IMAGE_NAME}:${env.BUILD_ID}"

        //K8S_NAMESPACE = "production"
        K8S_NAMESPACE = "powercalcrun"
    }

    parameters {
        string(name: 'BRANCH_NAME', defaultValue: 'main', description: 'Branch to build')
    }
    stages {
        stage('Initialize') {
            steps {
                script {
                    def dockerHome = tool 'JenkDocker'
                    env.PATH = "${dockerHome}/bin:${env.PATH}"
                }
            }
        }
        stage('Run for main branch') {
            when {
                expression {
                    BRANCH_NAME == 'main'
                }
            }
            stages {
                stage('Checkout') {
                    steps {
                        echo "Checkout code for branch:${BRANCH_NAME} ..."
                         git branch: "${BRANCH_NAME}", 
                             url: 'https://github.com/PavelK037/power-calculator.git'                    
                        //git 'https://github.com/PavelK037/power-calculator.git'
                        echo 'Finish Checking out code .'
                    }
                }
                stage("build") {
                    steps {
                        echo 'building the application ...'
                        sh "docker build -t ${IMAGE_NAME}:latest ."
                        echo 'the application built.'
                    }
                }
            }
        }
        // stage("test") {
        //     when {
        //         expression {
        //             BRANCH_NAME == 'dev'
        //         }
        //     }
        //     steps {
        //         echo 'testing the application ...'
        //     }
        // }
        // stage("deploy") {
        //     steps {
        //         echo 'deploying the application ...'
        //     }
        // }
    }
}