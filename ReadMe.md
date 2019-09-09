#Company REST API

##Docker commands:  
Build:  `docker build -t <image-name> .`  
Run: `docker run -p 8080:8080 <image-name>`  
List containers: `docker container ls`  
Save: `docker save -o <filename.extension> <image-name>`  
Kill containers: `docker kill $(docker ps -q)`
