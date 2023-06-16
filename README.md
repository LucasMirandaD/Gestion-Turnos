# Instalación de dependencias 
- Windows, Mac and Linux (Ubuntu):
- Es necesario java 11
# 1_ Descargar e instalar Eclipse IDE for Java Developers (2022-09).
- Crear un nuevo espacio de trabajo para sus proyectos (eclipse-workspace).
https://www.eclipse.org/downloads/packages/release/2022-09/r/eclipse-ide-java-developers
# 2_ Descargar Drools 7.73.0 y extraer el archivo zip en un directorio.
Download Drools 7.73.0
https://www.google.com/url?q=https://download.jboss.org/drools/release/7.73.0.Final/droolsjbpm-integration-distribution-7.73.0.Final.zip&sa=D&source=docs&ust=1686615071809537&usg=AOvVaw1cDItUA_uOLYIEh0NIbXJ1
# 3_ Instalar JBoss Tools 4.25.0:
-  Ejecutar Eclipse IDE.
-  Seleccionar Help > Eclipse Marketplace….
-  Instalar JBoss Tools 4.25.0.Final
-  Sólo necesitaremos JBoss Tools Java Standard Tools. Las demás
herramientas son opcionales.
# 4_ Instalar: Drools Eclipse Integration:
-  Seleccionar Help > Install New Software….
-  En el cuadro combinado Trabajar con(Work with): escriba:
https://download.jboss.org/drools/release/7.48.0.Final/org.drools.updatesite/
-  Click Select all.
-  Asegúrese de que la casilla: "Contactar con todos los sitios de actualización
durante la instalación para encontrar el software necesario", está marcada.
# 5_ Crear Drools Runtime:
-  Seleccionar: Preferences > Drools > Installed Drools Runtime > Add… .
-  Elige cualquier nombre y selecciona la carpeta binaries del archivo drools,
que has instalado en el paso 2. La versión se determina automáticamente.
- ○ Click OK > Aplicar y cerrar(Click OK > Apply and Close)
# 6_ Create Test Project:
-  En Eclipse cambiar a perspectiva Drools: Drools perspective (Window >
Perspective > Open Perspective > Other > Drools).
-  Seleccionar File > New > Drools Project
-  Ahora puede elegir crear un nuevo proyecto con archivos de ejemplo y hacer
clic en Siguiente.
-  Enter a project name, select the drools runtime created earlier, and select
Add a sample HelloWorld rule file to this project. Click Finish.
-  Introducir un nombre de proyecto, seleccionar el drools runtime de drools
creado anteriormente y seleccionar: Add a sample HelloWorld rule file to
this project. Click en Finalizar.
-  Abra la clase que contiene el método main. Se encuentra en el
paquete:com.sample.
-  Para ejecutar el proyecto, haga clic con el botón derecho del ratón en el
editor y seleccione Depurar como > Aplicación Drools(Debug As > Drools
Application). Observe la salida.
-  Se pueden ignorar los SLF4J warnings or download la última versión y
agregar el slf4j-simple-x.x.xx.jar a el proyecto, build path (right
click the project > Build Path > Add External Archives > choose
slf4j-simple-x.x.xx.jar > OK).
- Fuente: https://wwu-pi.github.io/tutorials/lectures/lsp/030_install_drools.html
