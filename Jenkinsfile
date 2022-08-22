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
         always{
              script{
                         allure includeProperties: false, jdk: 'jdk1.8', results: [[path: 'report/allure_raw']]
              }
         }

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
