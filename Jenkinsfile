#!/usr/bin/env groovy
@Library('jenkins-shared-library')
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
                    pushImage 'elshahat20/my-app:2.0'
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