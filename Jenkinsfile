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
                         allure includeProperties: false, jdk: '', report: 'report/allure-report', results: [[path: 'D:/Jenkins\workspace/first pipeline/report/allure-results']]
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
