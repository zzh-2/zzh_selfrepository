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
                    sh 'mvn clean install'
                }
            }
        }
    }
}
