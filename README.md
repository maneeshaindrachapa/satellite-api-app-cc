###Build Jar
`mvn clean install -DskipTests`


###Run Dockerfile

`sudo docker build -t <dockerhub_username>/satellite-api-app:v0.0.1 .`
<br><br>`docker push <dockerhub_username>/satellite-api-app:v0.0.1`


###Kubernetics Deployment
`kubectl apply -f deployments/my-sql-pv.yaml`<br><br>
`kubectl apply -f deployments/my-sql-pvc.yaml`<br><br>
`kubectl apply -f deployments/my-sql-deployment.yaml`<br><br>
`kubectl apply -f deployments/my-sql-service.yaml`<br><br>
`kubectl apply -f deployments/satellite-api-deployment.yaml`<br><br>
`kubectl apply -f deployments/satellite-api-service.yaml`<br><br>