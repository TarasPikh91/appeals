pipeline {
    agent any
    tools {
        maven 'apache-maven-3.8.3'
    }
    
//     parameters {
//         string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')

//         text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')

//         booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')

//         choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')

//         password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
//     }
    
    
    stages {
        stage('Example') {
            steps {
                echo 'Hello World'
                echo "Hello Person: ${params.PERSON}"
            }
        }
        
        stage('build') {
            steps {
                echo 'build stage'
                sh 'mvn --version'
            }
        }
    }
    post { 
        always { 
            echo 'I will always say Hello again!'
        }
    }
}
