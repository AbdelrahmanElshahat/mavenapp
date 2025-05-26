def buildApp(){
    echo 'Building the application...'
    sh 'mvn clean package -DskipTests'
}
def buildImage(){
    echo 'Building the docker image...'
    withCredentials([usernamePassword(credentialsId: 'docker-repo', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh "docker build -t elshahat20/my-app:1.0 ."
        sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin"
        sh "docker push elshahat20/my-app:1.0"
    }
}