// pipeline {
//     agent any
//     sages {
//         stage ('pull source code') {
//             steps {
//                 git branch: 'main', url: 'https://github.com/Digambark07/my-css-pipeline.git'
//             }
//         }

//         stage ('build docker image') {
//             steps {
//                 sh 'docker build -t my-image digambarkare/jk-8 '
//             }
//         }

//         stage ('push docker image ') {
//             environment {
//                 registryCredntial = 'docker-cred'
//             steps {
//                 withDockerRegistry(credentialsId: 'docker-cred', url: 'https://hub.docker.com/repository/docker/digambarkare/jk-8')
//             }
//             }
//         }
//     }
// }

pipeline {
    agent any

    stages {  // Corrected spelling: 'satages' to 'stages'
        stage('Pull Source Code') {  // Corrected indentation and spacing
            steps {
                git branch: 'master', url: 'https://github.com/Digambark07/my-css-pipeline.git'
            }
        }

        stage('Build Docker Image') {  // Corrected spacing
            steps {
                sh 'docker build -t digambarkare/jk-8 ./mediplus-lite/'  // Corrected docker build command syntax
            }
        }

        stage('Push Docker Image') {  // Removed extra space and corrected the syntax
            environment {
                registryCredential = 'docker-cred'  // Fixed typo 'Credntial' to 'Credential'
            }
            steps {
                withDockerRegistry(credentialsId: 'docker-cred', url: 'https://index.docker.io/v1/') {
                    sh 'docker push digambarkare/jk-8'  // Added Docker push command inside withDockerRegistry
                }
            }
        }
    }
}
