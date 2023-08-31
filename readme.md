#Comandos Docker

Construir una imagen
```
docker build -t ecs-springboot-starter .
```
//Agregar un tag
docker tag ecs-springboot-starter-aws jorgegrajales090/ecs-springboot-starter-aws:latest

//Enviar la imagen a dockerhub
docker push jorgegrajales090/ecs-springboot-starter:latest


