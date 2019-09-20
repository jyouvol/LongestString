#Longest word finder

- Assumptions
1. User of this application passes input string as commandLine argument.
2. User passes at least one word as input.
3. In case of multiple words with same size, unique words will be returned eliminating duplicates.

# Execution steps
This is a gradle project, so we will be using Gradle tasks to run our application and it's tests

- Steps
1. Clone the project <project link>
2. Build the Jar by running `sh gradlew.sh clean build`(for windows `gradlew.bat clean build`)
3. Execute the program by running command `java -jar build/libs/longest-string-0.1.0.jar "<your input string>"`

- To run tests execute the following command `sh gradlew test`(for windows `gradlew.bat test`)