def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'dockerHubcred', passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER')]) {
      sh "docker login -u ${DOCKER_USER} -p ${dockerHubcred}"
  }
  sh "docker push ${DOCKER_USER}/${Project}:${ImageTag}"
}
