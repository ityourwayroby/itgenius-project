pipeline {
    agent any

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
                sh 'sh create-package.sh'
            }
        }



        stage('Deploy to server'){
            steps{
                sshPublisher(publishers: [sshPublisherDesc(configName: 'bappy-1',
                transfers: [sshTransfer(cleanRemote: false, excludes: '',
                execCommand: '''cd /home/ec2-user/
                sh deployment.sh''',
                execTimeout: 120000,
                flatten: false,
                makeEmptyDirs: false,
                noDefaultExcludes: false,
                patternSeparator: '[, ]+',
                remoteDirectory: '/home/ec2-user',
                remoteDirectorySDF: false,
                removePrefix: '',
                sourceFiles: '')],
                usePromotionTimestamp: false,
                useWorkspaceInPromotion: false,
                verbose: false)])
            }
        }
    }
}
