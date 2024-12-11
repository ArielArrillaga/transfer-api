 Transfer API

 Repositorio del Proyecto

 El proyecto se encuentra disponible en mi repositorio de GitHub:
 https://github.com/ArielArrillaga/transfer-api

 Requisitos Previos
- Java 17
- Spring Boot 3
- Maven
- Mockoon

 Cómo Ejecutar el Proyecto

1. Clonar el repositorio:
   
   git clone https://github.com/ArielArrillaga/transfer-api.git
   cd transfer_api
   

2. Construir el proyecto con Maven:
   Ejecutar los siguientes comandos en la terminal:
   
   mvn clean install
   
   Durante el proceso de construcción, Maven generará clases a partir del archivo WSDL incluido en el proyecto.

3. Iniciar el mock con Mockoon:
<<<<<<< Updated upstream
   - Abrir Mockoon y cargar el archivo `mock.json` incluido en el proyecto.
=======
   - Abrir Mockoon y cargar el archivo `Transfers-Mock-get-recipients.json` incluido en el proyecto.
>>>>>>> Stashed changes
   - Seleccionar la opción que contiene una respuesta `200 OK` con todos los datos.
   - Hacer clic en "Run" para levantar la API mock en el puerto 3003. La URL del mock será:
    
     http://localhost:3003/servicios/transferenciasV2
  

4. Levantar el proyecto Spring Boot:
   Ejecutar el siguiente comando:

   mvn spring-boot:run


5. Probar el Proyecto:
   Una vez que el proyecto está en ejecución, se puede comunicar con la API Mock utilizando los siguientes datos:
   - `customerDocument = 1234`
   - `customer-document-type = DNI`

   Cualquier otra combinación de datos utilizará el servicio WSDL.

## Documentación de la API
El proyecto cuenta con Swagger para documentar la API. Acceder a la documentación interactiva en:

http://localhost:8080/swagger-ui/index.html


## Notas Adicionales
Las decisiones técnicas tomadas en este proyecto están documentadas en el archivo PDF titulado "Leer antes de ver el código" incluido en el repositorio.


