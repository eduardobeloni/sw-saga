# Start the application in background
- $ mvn spring-boot:run &

# Request examples
- $ curl --location --request GET 'http://localhost:8080/films/list'
- $ curl --location --request GET 'http://localhost:8080/films/detail/3'
- $ curl --location --request PATCH 'http://localhost:8080/films/update/3' --header 'Content-Type: text/plain' --data-raw 'Never mind'