pipeline {
    agent any
    satages {
        stage ('pull source code') {
            steps {
                git branch: 'main', url: 'https://github.com/Digambark07/my-css-pipeline.git'
            }
        }

        stage ('build docker image') {
            steps {
                sh 'docker build -t my-image digambarkare/jk-8 '
            }
        }

        stage ('push docker image ') {
            environment {
                registryCredntial = 'docker-cred'
            steps {
                withDockerRegistry(credentialsId: 'docker-cred', url: 'https://hub.docker.com/repository/docker/digambarkare/jk-8')
            }
            }
        }
    }
}
