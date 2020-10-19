# Registration API
  Simple spring boot application with API's for registration form UI (https://github.com/shreedhar-ansur/registrationAppFrontend.git).

## prerequisite

  JDK 1.8 or higher
  
  Maven 3 or higher
  
  MongoDB 3.0 or higher
  
  Set JAVA_HOME system environment variable to java home folder
 
## Steps to run project
  
  Step 1: checkout the project from git repository.
  
  Step 2: Run `"<path_to_mongo_installation_folder>\bin\mongod.exe" --dbpath "<path_to_empty_database_folder>\data"` to start mongo instance.
  
  Step 3: Run `mvn clean compile install spring-boot:run` to compile install and run the spring boot application. Navigate to `http://localhost:8080/`.
  
  Swagger documentation: `http://localhost:8080/swagger-ui/index.html`
