# BestDay [Andromeda] Web Automation

Este proyecta se encuentra dividido en tres areas principalmente:

1. `src/main/java` contiene todo lo  relacionado con los objetos de las paginas, datos de prueba y funciones “helpers” que se utilizan de manera general en el proyecto. 
2. `src/main/resources` contiene los archivos de configuración de los diferentes dispositivos a automatizar, web, mobile, sauceLab, VSTS, etc. También están adjuntos los drivers de los navegadores.
3. `src/test/java` contiene toda la información relacionada a las pruebas en sí.

# Parametros
- `driver[driverName]` = nombre y localización de su driver seleccionado - ejemplo */Users/name/Desktop/chromedriver*
- `suiteFile` = nombre del testNG suite utilizado, localizado en el directorio raiz - ejemplo.  *testng-hotelSearch.xml*
- `driverConfig` = nombre del archivo JSON, con las configuraciones deseadas para su ejecución, localizado en *src/main/resources/cfg* directory - e.g. local_chrome.json

# Como ejecutar la automatización 
***Usando Chrome***

*Pre-requisitos*
- Descargar chromedriver
- Agregar webdriver.chrome.driver parametro o definir valor en el codigo
- Editar valores del archivo de configuración a utilizar (src/main/resources/cfg/local_chrome.json), en caso de ser necesario

> mvn clean compile test -Dwebdriver.chrome.driver=/Path/to/driver/chromedriver -DdriverConfig=local_chrome -DsuiteFile=testng-hotelSearch.xml

***Usando Firefox***
- Descargar geckodriver
- Agregar webdriver.gecko.driver parametro o definir valor en el codigo
- Editar valores del archivo de configuración a utilizar (src/main/resources/cfg/local_firefox.json), en caso de ser necesario

> mvn clean compile test -Dwebdriver.chrome.driver=/Path/to/driver/chromedriver -DdriverConfig=local_firefox -DsuiteFile=testng-hotelSearch.xml
