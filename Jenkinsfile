pipeline{
    agent{
        node{
            label "Test"
        }
    }

    stages{
        stage ('cd dir and chmod'){
            steps{
                    sh "cd /var/lib/jenkins/workspace/'Maven zhihu'/src/test/resources/driver"
                    sh "chmod 777 chromedriver"
            }
        }

        stage ('Install stage'){
            steps{
                withMaven(maven : 'maven'){
                    sh "mvn clean install"
                }
            }
        }
    }
    
    post{
         always{
              script{
                         allure includeProperties: false, jdk: '', report: 'report/allure-report', results: [[path: 'target/allure-result']]
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
