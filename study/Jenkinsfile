pipeline{
    agent{
        node{
            label "win123"
        }
    }

    stages{
        stage ('Install stage'){

            steps{
                withMaven(maven : 'maven'){
                    bat 'mvn clean install'
                }
            }
        }
    }
}