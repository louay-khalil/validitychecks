# validitychecks

## Gradle project
Java 17

## Build and run

To build the project, Java and Gradle are required to be installed on your computer. Follow the steps below to build and start the project:

• Clone the git repo to your computer

        git clone https://github.com/louay-khalil/validitychecks.git


• Build the project with Gradle:

        ./gradlew build

• Start:

        java -jar build/libs/validitychecks-1.0-SNAPSHOT.jar

• 3 validity checks available at

        http://localhost:8080/validity-check/car-reg-num/{data}
        http://localhost:8080/validity-check/sin/{data}
        http://localhost:8080/validity-check/notnull/{data}

Replace '{data}' with check data, example:

        http://localhost:8080/validity-check/car-reg-num/abc123



