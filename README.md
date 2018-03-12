# Restful

After building the project with maven

run the jar using the command 
java -c "<path to the ojdbc jar>"-jar target/test-rest-service-0.1.0.jar

Once the server is up, you can hit the URL http://localhost:9000/hello-world

You will get the following result
{"id":1,"content":"Hello, Stranger!"}

http://localhost:9000/getCabins
	
0	
cabinId	1
cabinName	"presidential suite"
cabinDescription	"presidential"
1	
cabinId	2
cabinName	"Deluxe cabin"
cabinDescription	"Deluxe"
2	
cabinId	3
cabinName	"suite"
cabinDescription	"suite"
3	
cabinId	4
cabinName	"junior suite"
cabinDescription	"junior"
