# | Java | Back-end | Sistema de hoteleria

## Este repositorio contiene el código fuente de una aplicación CRUD utilizando JDBC y Swing ademas de tener persistencia en los datos.
  El programa fue creado con la intencion de aplicar conocimientos de Back-End en un problema de la vida real.
## 🖥️ Tecnologías Utilizadas:

- Java
- Eclipse
- Biblioteca JCalendar
- MySql
- Plugin WindowBuilder
- Biblioteca C3PO para crear Pool de conexiones

## Informacion importante!!
- Use Java versión 8 o superior para compatibilidad. </br></br>
- Recomiendo usar el editor de Eclipse para compatibilidad con la Interfaz Gráfica. </br></br>
- La interfaz contiene dos métodos importantes:</br></br>
- setResizable(false): determina el tamaño de la ventana, y a través del parámetro <strong>false</strong>, la pantalla no se puede maximizar;</br></br>
- setLocationRelativeTo(null): determina la ubicación de la ventana, y a través del parámetro <strong>null</strong> la mantiene centrada en la pantalla.</br></br>

## 📝 Cómo descargar:

#### 🔹 Fork

1 - Haz el <strong>fork</strong> del proyecto. En la parte superior derecha, al hacer clic en el icono se creará un repositorio del proyecto en tu cuenta personal de GitHub. 

2 - Una vez que tengas el repositorio <strong>forkado</strong> en tu cuenta, comprueba si la URL de la página es la del repositorio de tu cuenta.

3 - Haz clic en la opción <strong>Code</strong>. Se mostrarán tres formas de instalar el repositorio en su máquina, y destacamos dos:

</br>

#### 🔹 Clonar o descargar el ZIP

1 - Para clonar, simplemente copia el <em>url</em> ubicado justo debajo del HTTPS, crea una carpeta en tu computadora, abre el <em>cmd</em> o el <em>git bash</em> dentro de esa carpeta y luego ingresa el comando <strong>git clone</strong> y con el botón derecho del mouse dentro del terminal haz click en la opcion <strong>Paste</strong> para pegar el <em>url</em> y presiona <em>Enter</em>. 

2 - La segunda opción es descargar el código en un paquete <strong>"zipado"</strong> y extraer la carpeta a tu computadora.
</br></br>

## 📝 Eclipse

### ¿Cómo importar mi proyecto a Eclipse?

1 - Una vez dentro del Editor al lado izquierdo, haz clic en el <em>Files</em> que está en el menú en la parte superior, elige la opción <em>Open Projects from File System</em>.

Luego haz click en <em>Directory</em> y ubica el directorio del proyecto "clonado" o "extraído" en tu computadora. Haz click en <em>Finish</em> para completar la importación.

2 - La segunda forma de importar es en <em>File</em> en la opción <em>Import</em>. O a través del <strong>Project Explorer</strong> haz clic en el campo vacío con el botón derecho del mouse y elijas la opción <strong>Import</strong>.

Si te decides por el <strong>Import</strong>, se abrirá una ventana en la que tienes que hacer clic en la opción <em>Existing Projects Into Workspace</em> y en el botón <em>Next</em>.

Luego haz clic en el botón <em>Browse</em> y busca el proyecto en el directorio local.

## 📅 JCalendar

1.- Tras realizar la importación a tu editor, es necesario instalar la librería <strong>JCalendar</strong>, de lo contrário, el proyecto presentará un error y no será posible abrir la ventana de <strong>Reservas</strong>. </br>

Para instalar, se necesita descargar el paquete a través de ese enlace: 
🔹 [Link para el JCalendar](https://toedter.com/jcalendar/)

2.- El siguiente paso es extraer los archivos a una carpeta e importar los archivos desde la carpeta <strong>lib</strong> a una carpeta local e importar los archivos a Eclipse.

3.- Haz click con el botón derecho encima del proyecto ubicado en el <strong>Package Explorer</strong>, elijas la opción <em>Build Path</em> y <em>Configure Build Path</em>.

4.- El proyecto tendrá un mensaje de error que indica que la ruta de la biblioteca no existe en tu computadora. Haz click en <em>Libraries</em>, luego en <em>Classpath</em> seleccione el archivo JCalendar, elije la opción <em>Remove</em> y <em>Apply and Close</em>.

5.- Para importar el <strong>Jcalendar</strong> desde tu computadora, después de haber "extraído" los archivos de la descarga, pulsa en <em>ClassPath</em> y luego en <em>Add External JARS</em> agrega uno por uno  o selecciona todos de una vez y haz click en <em>Apply and Close</em>.

Por lo tanto, el proyecto debe contener los siguientes archivos después de las importaciones:

<p align="center" >
     <img width="600" heigth="600" src="https://user-images.githubusercontent.com/101413385/173695620-7a4893e9-b9a1-44d6-8b70-c94a85ea891e.png">
</p>

## Errores

### ⚠️ Descargué el proyecto pero los caracteres especiales no funcionan:
Si tu proyecto tiene errores de acentuacion 

1.- Ve a <em>Window</em> y haz clic en <em>Preferences</em>.

2.- Luego haz clic en <em>General</em> y en <em>Workspace</em>. Si tu <em>Text File Enconding</em> no está con el <strong>Default (UTF-8)</strong>, haz clic en <em>Other</em>, y eliges la opción <strong>UTF-8</strong>, y finaliza haciendo clic <em>Apply and Close</em>.

### 📊 Base de Dados

### ¿Cómo importar MySqlConnector al proyecto?

Es la misma ruta descrita para importar el <strong>JCalendar</strong>, haga clic con el botón derecho en el proyecto, <em>Build Path</em>, <em>Configure Build Path</em>, <em>Libraries</em>, <em>Add External JARs</em>. Para encontrar la ruta de este archivo <strong>.jar</strong>, ve al disco duro de tu computadora e ingresa a la carpeta  <em>Archivos de Programas (x86)</em>.

1.- Archivos de Programas (x86)

2.- MySQL

3.- Connector J 8.0

4.- My SQL Connector Java
