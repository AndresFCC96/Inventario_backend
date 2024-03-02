From <<openjdk>>:tagversion
COPY target/inventario 0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "java-app.jar"]