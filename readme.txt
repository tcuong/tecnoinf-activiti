## Bruno Viera 3.847.803-1 , Mathías Núñez 4.772.072-0 , Gastón Festari 4.178.229-7 ##
::: README :::

Para generar el WAR via Maven:

1 - Descargar e instalar Maven (se recomienda utilizar una versión igual o superior a la v3.0.4):
	Maven se encuentra disponible en: 
		- http://maven.apache.org/download.html
	
	Y las instrucciones de instalación en:
		- http://maven.apache.org/download.html#Installation
		
2 - Navegar mediante la línea de comando hasta el directorio donde se encuentra directorio "bedelias-super" del proyecto. 

	(ej: ~\tecnoinf-activiti\bedelias-super)

3 - Ejecutar el siguiente comando: 
	
		mvn clean install package -Dmaven.test.skip=true
	
	Esto empaquetará los proyectos en los archivos WAR correspondientes y los ubicará en la carpeta ".\target" de sus respectivos directorios.

Alternativamente, es posible ejecutar el script "maven_skip_tests.bat" ubicado en la carpeta "~\tecnoinf-activiti\scripts".