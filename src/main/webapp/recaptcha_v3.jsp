<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PAW</title>
        <script src='https://www.google.com/recaptcha/api.js?render=6LfRb24lAAAAAMUv1RLT3t5rWUznxvCanGLeMQd1' />
        <script>
            grecaptcha.ready(function () {
                grecaptcha.execute('6LfRb24lAAAAAMUv1RLT3t5rWUznxvCanGLeMQd1', {action: 'formulario'})
                        .then(function (token) {
                            var recaptchaResponse = document.getElementById('recaptchaResponse');
                            recaptchaResponse.value = token;
                        });
            });
        </script>
    </head>
    <body>

        <h1>ReCaptcha: versión 3</h1>
        <form action="?" method="POST">

            <input type="hidden" name="recaptcha_response" id="recaptchaResponse">

            <button type="submit">Comprobar</button>
        </form>



    </body>
</html>
