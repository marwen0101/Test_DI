pipeline {
    agent any
    tools { 
        maven 'Maven 3.3.9' 
    }

    stages {
        stage('initialize') {
            steps {
		sh '''
                echo "building .... we are here wait"
                echo "M2_HOME = ${M2_HOME}"
	        '''
            }
        }
     stage('Build'){
	steps{
		sh 'mvn install'
	}

    }
	}
}
