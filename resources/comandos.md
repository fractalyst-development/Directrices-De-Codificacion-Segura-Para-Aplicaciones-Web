# COMANDOS ÚTILES

## NMAP

// Listar suites de cifrado del servidor

```bash
nmap --script ssl-enum-ciphers -p 8181 LOCALHOST
```

## _keytool_

### Formato no estándar

```bash
//keytool -genkeypair -alias ryj -keyalg RSA -validity 777 -keystore ryj-keystore
//keytool -importkeystore -srckeystore ryj-keystore -destkeystore ryj-keystore.pkcs12 -deststoretype pkcs12
```

### Localización de repositorios

```bash
// java cacerts: /usr/lib/jvm/jdk1.8.0_231/jre/lib/security/cacerts
// GF cacerts:   /home/usuario/glassfish-4.1.1/glassfish/domains/domain1/config/cacerts.jks
```

```bash
keytool -genkey -v -alias ryj12 -keyalg RSA -storetype PKCS12 -keystore ryj_cliente_ks.p12 -storepass Welcome1 -keypass Welcome1
keytool -export -alias ryj12 -keystore ryj_cliente_ks.p12 -storetype PKCS12 -storepass Welcome1 -rfc -file ryj-autofirmado.cer
keytool -import -file ryj-autofirmado.cer -keystore /home/usuario/glassfish-4.1.1/glassfish/domains/domain1/config/cacerts.jks -alias -ryj12 -storepass changeit
```

### SQLMap

```bash
sqlmap -r a1Request -p email --dump
sqlmap -u "http://localhost:8080/09_InyeccionDeCodigo/detalleUsuario.do" --data="email=usuario1%40testmail.com" -p email
```

### WebGoat

```bash
//split --bytes=40M webgoat-container-7.1-exec.jar WebGoat.0
cat WebGoat.0* > webgoat-container-7.1-exec.jar
java -jar webgoat-container-7.1-exec.jar
```

## APPSENSOR

<https://github.com/jtmelton/appsensor>

<https://github.com/jtmelton/appsensor/blob/master/sample-apps/DemoSetup.md>

Start REST / WebSocket Server
go to this directory: <https://github.com/jtmelton/appsensor/tree/master/sample-apps/appsensor-ws-rest-server-with-websocket-boot>
run this command:

```bash
mvn spring-boot:run -DAPPSENSOR_WEB_SOCKET_HOST_URL=ws://localhost:8085/dashboard
```

Start REST Client Data Generator
go to this directory: <https://github.com/jtmelton/appsensor/tree/master/sample-apps/appsensor-ws-rest-client-boot-data-generator>
run this command:

```bash
mvn spring-boot:run
```

Start AppSensorUI
go to this directory: <https://github.com/jtmelton/appsensor/tree/master/appsensor-ui>
run this command:

```bash
mvn spring-boot:run -DAPPSENSOR_REST_REPORTING_ENGINE_URL=http://localhost:8085 -DAPPSENSOR_CLIENT_APPLICATION_ID_HEADER_NAME=X-Appsensor-Client-Application-Name2 -DAPPSENSOR_CLIENT_APPLICATION_ID_HEADER_VALUE=myclientapp -DAPPSENSOR_WEB_SOCKET_HOST_URL=ws://localhost:8085/dashboard -Dspring.datasource.url=jdbc:mysql://localhost/appsensor -Dspring.datasource.username=appsensor_user -Dspring.datasource.password=appsensor_pass
```

Login
open your browser to : <http://localhost:8084>
When prompted login with user analyst and password analyst.

### SONARQUBE

```bash
sudo systemctl status sonar
// sudo systemctl start sonar
// sudo systemctl start sonar
```

#### Docker

```bash
//sudo apt install docker
//sudo apt-get install docker.io
sudo docker pull sonarqube:7.9-community
// Desde una imagen local
//sudo docker save sonarqube > sonarqube.tar
//sudo docker load -i sonarqube.tar

sudo docker images
sudo docker run -d --name sonarqube -p 9000:9000 sonarqube:7.9-community
// sudo docker rm sonarqube
sudo docker ps
// analizar app
mvn sonar:sonar   -Dsonar.projectKey=demo   -Dsonar.host.url=http://127.0.0.1:9000   -Dsonar.login=3200becd008c58124176568354a2d54827bb29e1
mvn sonar:sonar \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=0c54f70d8f6bda84f368a5cd7e3dc88fb1553d1a
// http://127.0.0.1:9000
// admin / admin

sudo docker container stop sonarqube
```
