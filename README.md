## #Build Jar
`mvn clean install -DskipTests`


### Run Dockerfile
```
sudo docker build -t <dockerhub_username>/satellite-api-app:v0.0.1 .
docker push <dockerhub_username>/satellite-api-app:v0.0.1
```


### Kubernetics Deployment
```
kubectl apply -f deployments/my-sql-pv.yaml
kubectl apply -f deployments/my-sql-pvc.yaml
kubectl apply -f deployments/my-sql-deployment.yaml
kubectl apply -f deployments/my-sql-service.yaml
kubectl apply -f deployments/satellite-api-deployment.yaml
kubectl apply -f deployments/satellite-api-service.yaml
```
