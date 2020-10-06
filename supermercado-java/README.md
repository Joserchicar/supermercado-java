# supermercado-java
proyecto web **Java** siguiendo el patron de **MVC** contra una base de datos **MySQL**
CMS para gestional los productos de un supermercado.
Tenemos dos roles diferentes para iniciar sesion.

1. Administrador [admin 123456]
2. Usuario normal[pepe 123456]

*Las contraseñas estan cifradas en MD5 dentro de la BBDD.*


## Tecnologia

-Maven 4.0.0
-java 8
-java servlet Api 3.1.0
- JSP 2.2
-JSTL 1.2
-Javax Validation Api 1.1
- bootstrap 4.5.0
font-awesome 5.13.0
datatables .net 1.10.21

Para ver mas detalles ver (pom.xml)[https://github.com/joserchicar/supermercado-java/)

TODO screenshot
- 
##configuracion de la BBDD

par acrear la BBDD disponemos de un **script-db.sql** en la raiz del poroyecto el cual crea el esquema ** supermercado** y las tablas necesarias  ademas de insertar datos de la prueba

Para realizar la conexion de la BBDD mirar el siguiente fichero ** src/main/webapp/META-INF/context.xml**

' <?xml version="1.0" encoding="UTF-8"?>
  <Context path="/ejemplo05">
      <Resource
          type="javax.sql.DataSource"
          auth="Container"
          name="jdbc/super"
          driverClassName="com.mysql.jdbc.Driver"
          url="jdbc:mysql://localhost:3306/supermercado"
          username="USUARIO"
          password="PASSWORD"
          maxActive="100"
          maxIdle="30"
          maxWait="10000"          
      />
 </Context> '




--TODO DIAGRAMA BBDD

## Ejecutar proyecto

Al ser proyecto java necesitamos un servidos de aplicaciones, en nuestro caso recomendamos** Apache TomCat 9.0**


## Estructura Clases del proyecto

Interesante la documentacion [JavaDoc API](https://) la cual esta accesible una vez ejecutado el proyecto en la propia barra de navegacion

Interesante consultar los siguientes Packages de java:


- **com.ipartek.formacion.listenner**- se ejecuta al arrancar la APP
- **com.ipartek.formacion.controller.backoffice** - controlador para usuario administrador
- **com.ipartek.formacion.controller.frontoffice** - controlador para usuario normal
- **com.ipartek.formacion.modelo.dao** Dao para relacional los pojos con las tablas de la BBDD
- **com.ipartek.formacion.pojos**. Clases para crear objetos de java
- **com.ipartek.formacion.seguridad **. Filtros de Seguridad.

    



