#!/usr/bin/env groovy
library 'identifier' : 'jenkins-shared-library@master','retriever': modernSCM(
    [
        $class: 'GitSCMSource',
        remote: 'https://gitlab.com/AbdelrahmanElshahat/jenkins-shared-library.git',
        credentials: 'github-credentials'
    ]
)

def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.9.9'
    } 
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                   buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                   buildImage 'elshahat20/my-app:2.0'
                }
            }
        }
        stage("docker login") {
            steps {
                script {
                    dockerLogin()
                }
            }
        }
        stage("push image") {
            steps {
                script {
                    dockerPush 'elshahat20/my-app:2.0'
                }
            }
        }
        stage("deploy") {
            steps {
                script { 
                    gv.deployApp()
                }
            }
        }
    }   
}