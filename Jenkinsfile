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

    post{
    	 success {
              emailext(
                            body: '$DEFAULT_CONTENT',
                            subject: '$JOB_NAME',
                            from: '',
                            to: '$DEFAULT_RECIPIENTS'
                      )


         }
         failure {
              emailext(
                            body: '$DEFAULT_CONTENT',
                            subject: '$JOB_NAME',
                            from: '',
                            to: '$DEFAULT_RECIPIENTS'
                      )
         }
    }
}