<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAW</title>
    </head>
    <body>

        <h1>Subida de ficheros</h1>
        <form action="upload" method="POST" enctype="multipart/form-data">

            <div>
                <label for="nombre">Nombre:</label>
                <input type="text" name="nombre" id="nombre" value=""/>
            </div>

            <div>
                <label for="fich">Elige un fichero:</label>
                <input type="file" name="fich" id="fich" >
            </div>
            <div>
                <button type="submit">Enviar</button>
            </div>
        </form>


    </body>
</html>
