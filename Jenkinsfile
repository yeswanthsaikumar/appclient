pipeline {
    agent any

    stages {
        stage ('Build') {

            steps {
                bat "mvn -DskipTests clean install"
            }
        }
        
           stage ('Test') {

            steps {
               echo 'Hello world'
            }
        }
        
           stage ('Deploy') {

            steps {
               echo 'Hello world'
            }
        }
    }
}
