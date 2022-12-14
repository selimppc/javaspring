# Spring Boot 


#### TOPIC CRUD API

| CRUD Operation | HTTP Method | Response Code |
|--------|---------------------|---------------|
| Create | POST                | 201           |
| Read   | GET                 | 200           |
| Update | PATCH / PUT         | 200           |
| Delete | DELETE              | 200           |





### Setup Java and Maven in MAC

    Need Maven to install 
    Download version 19 (for example ) from https://jdk.java.net/19/
    and Install as below:

    For Mac

    Downloading Java for Mac OS:
    $ tar -xvf openjdk-19.0.1_macos-x64_bin.tar.gz
    $ sudo mv jdk-19.0.1.jdk /Library/Java/JavaVirtualMachines/
    
    Setting Environment Variables - JAVA_HOME and Path
    $ JAVA_HOME="/Library/Java/JavaVirtualMachines/jdk-13.0.1.jdk/Contents/Home"
    $ PATH="${JAVA_HOME}/bin:${PATH}"
    $ export PATH

    Verifying the JDK installation
    $ java -version


    Maven for Mac OS  https://maven.apache.org/download.cgi
    $ tar -xvf apache-maven-3.8.6-bin.tar.gz
    
    Setting Maven Environment Variables - M2_HOME and Path
    $ export M2_HOME="/Users/pankaj/Downloads/apache-maven-3.6.3"
    $ PATH="${M2_HOME}/bin:${PATH}"
    $ export PATH

    Verifying the Maven Installation
    $ mvn -version     


### Deployment

    Clean MVN ( clean the target | download necessary dependencies | compile run the unit tests )
    and Create a JAR file and make that aviable in the project directory 

    $ mvn clean install   

            = JAR FILE =  
            /target/demo-0.0.1-SNAPSHOT.jar

    Run JAR FILE :
    $ java -jar target/demo-0.0.1-SNAPSHOT.jar


    PUSH TO HEROKU
    https://docs.spring.io/spring-boot/docs/current/reference/html/deployment.html#deployment.cloud.heroku


### Heroku CLI

    Install Heroku for MAC
    $ brew tap heroku/brew && brew install heroku
    $ heroku login

    instructions:
    https://devcenter.heroku.com/articles/getting-started-with-java#prepare-the-app
    


### Docker

    Building and Running the Container
    $ docker build -t javaspring .

    Run the container
    $ docker run -it -p 8080:8080 javaspring

    Utils:
    $ docker ps -a
    $ docker stop container_id



### GENERATE RSA

    Note: keep the .pem inside : resources/certs directory

    # create rsa key pair
    $ openssl genrsa -out keypair.pem 2048

    # extract public key
    $ openssl rsa -in keypair.pem -pubout -out public.pem

    # create private key in PKCS#8 format
    $ openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem


### TASK SCHEDULER

    Dependency: awaitility
    We will use awaitility for scheduled.

    Step 1: Add annotation @EnableScheduling in main class
    Step 2: Use @Scheduled(fixedRate = 9000L) for 9 secs other are available like cron | fixedDelay


### ASYNC for concurrent 

    No Dependency is needed. 

    Step 1: Add annotation @EnableAsync in main class 
    Step 2: Make a config file like: AsyncConfiguration.java
    Step 3: Make a service and use annotaiton @Async for the method - with CompletableFuture
    Step 4: Use commandline tools or controller  - with CompletableFuture


### IMAGE UPLOAD and store into db tables by bytes

    API: POST / upload
    1. http://localhost:8080/api/v1/images/upload

    Get Image by Name:
    2. http://localhost:8080/api/v1/images/<name>/info

    Get Image info by Name
    3. http://localhost:8080/api/v1/images/<name>/info