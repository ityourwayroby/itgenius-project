pipeline {
    agent any

    environment {
        REGISTRY_CREDENTIAL = "dockerhub_creds"
    }

    stages {

        stage('Git') {
            steps {
                git branch: 'master',
                url: 'https://github.com/ityourwayroby/itgenius-project.git'
            }
        }

        stage('Test'){
            steps{
                echo 'test'
            }
        }

        stage('Docker build and push'){
            steps{
                script {
                    docker.withRegistry('', REGISTRY_CREDENTIAL) {
                sh """
                chmod +x ./mvnw
                ./mvnw clean install
                docker rmi -f itgeniusdevops/itgenius-docker-container-image &>/dev/null && echo 'Removed old images'
                docker build -t itgeniusdevops/itgenius-docker-container-image:v001 .
                docker push itgeniusdevops/itgenius-docker-container-image:v001
                """
                
                }
            }
        }
        }


/*
        stage('Deploy to server'){
            steps{
                sshPublisher(publishers: [sshPublisherDesc(configName: 'test-server',
                transfers: [sshTransfer(cleanRemote: false, excludes: '',
                execCommand: '''cd /home/ec2-user/
                sh deployment.sh''',
                execTimeout: 120000,
                flatten: false,
                makeEmptyDirs: false,
                noDefaultExcludes: false,
                patternSeparator: '[, ]+',
                remoteDirectory: '',
                remoteDirectorySDF: false,
                removePrefix: '',
                sourceFiles: '')],
                usePromotionTimestamp: false,
                useWorkspaceInPromotion: false,
                verbose: false)])
            }
        } */
    }
}
