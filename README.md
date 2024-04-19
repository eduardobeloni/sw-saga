# Install provided certificate

## Go to your java base
- $ cd /usr/lib/jvm/java-17-openjdk-amd64/lib/security/

## Run keytool
- $ sudo keytool -keystore cacerts -storepass changeit -noprompt -trustcacerts -importcert -alias
swapi -file sw-saga/swapi.dev.crt

# Start the application in background
- $ mvn spring-boot:run &

# Request examples
- $ curl --location --request GET 'http://localhost:8080/films/list'
- $ curl --location --request GET 'http://localhost:8080/films/detail/3'
- $ curl --location --request PATCH 'http://localhost:8080/films/update/3' --header 'Content-Type: text/plain' --data-raw 'Never mind'