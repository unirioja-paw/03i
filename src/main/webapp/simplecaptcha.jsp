<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAW</title>
    </head>
    <body>

        <h1>Probando SimpleCaptcha</h1>
        <form action="comprobar" method="post">
            <div>
                <img src="simpleCaptcha.png"/>
            </div>
            <div>
                <label for="txtCaptcha">Teclea el texto de la imagen</label>
                <input type="text" name="txtCaptcha" id="txtCaptcha" value="" />
            </div>

            <div>
                <button type="submit">Comprobar</button>
            </div>
        </form>

    </body>
</html>
