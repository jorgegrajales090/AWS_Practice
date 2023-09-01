# Comandos Docker

### Construir una imagen
```
docker build -t ecs-springboot-starter .
```

### Agregar un tag
```
docker tag ecs-springboot-starter-aws jorgegrajales090/ecs-springboot-starter-aws:latest
```

### Enviar la imagen a dockerhub
```
docker push jorgegrajales090/ecs-springboot-starter:latest
```

# Comandos AWS CLI

### Configurar cuenta de AWS CLI
aws configure


### Policies
Add inline policy.
Go to visual editor and select EKS service.
In action, select all EKS actions.
For resources select all.
For requested condition select none of them.


# Comandos Kubernetes y EKS
https://docs.aws.amazon.com/es_es/eks/latest/userguide/getting-started-eksctl.html

### Validar instalación kubectl
```
kubectl version --short --client
```

eksctl create cluster --name k8s-cluster --region us-east-2 --fargate

### Ver los recursos de kubernetes

kubectl get nodes -o wide

kubectl get pods -A -o wide
