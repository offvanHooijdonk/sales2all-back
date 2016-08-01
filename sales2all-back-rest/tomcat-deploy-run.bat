set MAVEN_OPTS=-Xdebug -Xmx256m -Xrunjdwp:transport=dt_socket,address=8006,server=y,suspend=n 
call mvn -Dmaven.tomcat.port=8087 tomcat:run
pause