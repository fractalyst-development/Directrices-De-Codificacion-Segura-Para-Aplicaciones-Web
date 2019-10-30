# COMANDOS ÚTILES

## NMAP
// Listar suites de cifrado del servidor

```bash
nmap --script ssl-enum-ciphers -p 8181 LOCALHOST
```

## _keytool_

### Formato no estándar
//keytool -genkeypair -alias ryj -keyalg RSA -validity 777 -keystore ryj-keystore
//keytool -importkeystore -srckeystore ryj-keystore -destkeystore ryj-keystore.pkcs12 -deststoretype pkcs12

### Localización de repositorios

// java cacerts: /usr/lib/jvm/jdk1.8.0_231/jre/lib/security/cacerts
// GF cacerts:   /home/usuario/glassfish-4.1.1/glassfish/domains/domain1/config/cacerts.jks

´´´bash
keytool -genkey -v -alias ryj12 -keyalg RSA -storetype PKCS12 -keystore ryj_cliente_ks.p12 -storepass Welcome1 -keypass Welcome1
keytool -export -alias ryj12 -keystore ryj_cliente_ks.p12 -storetype PKCS12 -storepass Welcome1 -rfc -file ryj-autofirmado.cer
keytool -import -file ryj-autofirmado.cer -keystore /home/usuario/glassfish-4.1.1/glassfish/domains/domain1/config/cacerts.jks -alias -ryj12 -storepass changeit
´´´

### SQLMap

´´´bash
sqlmap -r a1Request -p email --dump
sqlmap -u "http://localhost:8080/09_InyeccionDeCodigo/detalleUsuario.do" --data="email=usuario1%40testmail.com" -p email
´´´

### WebGoat

´´´bash
//split --bytes=40M webgoat-container-7.1-exec.jar WebGoat.0
cat WebGoat.0* > webgoat-container-7.1-exec.jar
java -jar webgoat-container-7.1-exec.jar
´´´
### SONARQUBE

#### Docker
´´´bash
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
// Levantar sonarqube
mvn sonar:sonar   -Dsonar.projectKey=demo   -Dsonar.host.url=http://127.0.0.1:9000   -Dsonar.login=3200becd008c58124176568354a2d54827bb29e1
// http://127.0.0.1:9000
// admin / admin

sudo docker container stop sonarqube

´´´