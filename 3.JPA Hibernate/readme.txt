1) Use product_db.sql file to create the database.
2) Store the ProductJpa folder in the tomcat's webapps folder
3)Compile the files:
(ensure that you are in the WEB-INF/classes folder)
(Linux)   javac -cp "../lib/*:../../../../lib/servlet-api.jar" Util/*.java Entity/ProductEn.java
(Windows) javac -cp "..\lib\*;..\..\..\..\lib\servlet-api.jar" Util\*.java Entity\ProductEn.java
