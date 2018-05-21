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
		export JAVA_HOME="$(/usr/libexec/java_home -v 1.8)"
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
