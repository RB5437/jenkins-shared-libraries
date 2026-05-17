// vars/docker_push.groovy

def call(String Project, String ImageTag, String dockerhubuser){

    echo "Pushing Docker image to DockerHub"

    withCredentials([
        usernamePassword(
            credentialsId: 'dockerHubcred',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {

        sh '''
        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
        '''

        sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
    }

    echo "Docker image pushed successfully"
}
