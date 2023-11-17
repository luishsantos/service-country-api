#!groovy

buildAgentLabel = "any"
//jenkins vars
currentBuild.result = "SUCCESS"

try {
    stage("Setup") {
        node(buildAgentLabel) {
            stageStartTime = getCurrentTimeInMilliseconds()
   			currentStage = 'Setup'

            envSetup()
            
         	
        }
    }
    stage("Build") {
        node(buildAgentLabel) {
            stageStartTime = getCurrentTimeInMilliseconds()
   			currentStage = 'Build'

            build()
         
         	
        }
    }

    stage("Unit tests") {
        node(buildAgentLabel) {
            stageStartTime = getCurrentTimeInMilliseconds()
   			currentStage = 'Unit tests'

            unitTests()
         
         	
        }
    }
    
    stage("Quality Gate") {
        node(buildAgentLabel) {
          	stageStartTime = getCurrentTimeInMilliseconds()
            currentStage = 'Quality Gate'

            //qualityGate()

            
        }
    }
    

} catch (err) {
    echo err.toString()
    currentBuild.result = "FAILURE"
  	notifyTeams()
}



def envSetup() {

    deleteDir() //delete jenkins working dir for this project
    checkout scm //clones the git repository

    //version set
    dayOfYear = "${sh(script: "date +%y%j | tr -d '\n'", returnStdout: true)}"
    releaseVersionPrefix = 1.0
    path = "${dayOfYear}"
    versionCore = "${releaseVersionPrefix}.${path}.${env.BUILD_ID}"

    buildVersion = "${versionCore}"
    preReleaseVersion = "${versionCore}-dev"
    releaseVersion = "${env.BRANCH_NAME == 'main' ? buildVersion : preReleaseVersion}"
    
}

def build(){
    //ID set on build pipeline
    currentBuild.displayName = "#${BUILD_NUMBER} - ${releaseVersion}" 
    
    //building project
    sh """
        mvn clean install
    """
    withSonarQubeEnv(sonarToken) {
  		
    }


    //setting up version
    sh """
        git tag ${releaseVersion}
        git push ${repoName} --tags
    """
}

def unitTests(){
      withSonarQubeEnv(sonarToken) {
    }

    archiveArtifacts 'reports/*.*'

}


def qualityGate() {
    timeout(time: 1, unit: 'HOURS') {
        def qg = waitForQualityGate()
        if (qg.status != 'OK') {
            error "Pipeline aborted due to quality gate failure: ${qg.status}"
        }
    }
}
