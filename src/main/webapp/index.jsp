<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tomee Swagger API Example</title>

    <link href='webjars/swagger-ui/2.2.6/css/typography.css' media='screen' rel='stylesheet' type='text/css'/>
    <link href='webjars/swagger-ui/2.2.6/css/reset.css' media='screen' rel='stylesheet' type='text/css'/>
    <link href='webjars/swagger-ui/2.2.6/css/screen.css' media='screen' rel='stylesheet' type='text/css'/>
    <link href='webjars/swagger-ui/2.2.6/css/reset.css' media='print' rel='stylesheet' type='text/css'/>
    <link href='webjars/swagger-ui/2.2.6/css/print.css' media='print' rel='stylesheet' type='text/css'/>

    <script src='webjars/swagger-ui/2.2.6/lib/object-assign-pollyfill.js' type='text/javascript'></script>
    <script src='webjars/swagger-ui/2.2.6/lib/jquery-1.8.0.min.js' type='text/javascript'></script>
    <script src='webjars/swagger-ui/2.2.6/lib/jquery.slideto.min.js' type='text/javascript'></script>
    <script src='webjars/swagger-ui/2.2.6/lib/jquery.wiggle.min.js' type='text/javascript'></script>
    <script src='webjars/swagger-ui/2.2.6/lib/jquery.ba-bbq.min.js' type='text/javascript'></script>
    <script src='webjars/swagger-ui/2.2.6/lib/handlebars-4.0.5.js' type='text/javascript'></script>
    <script src='webjars/swagger-ui/2.2.6/lib/lodash.min.js' type='text/javascript'></script>
    <script src='webjars/swagger-ui/2.2.6/lib/backbone-min.js' type='text/javascript'></script>
    <script src='webjars/swagger-ui/2.2.6/swagger-ui.js' type='text/javascript'></script>
    <script src='webjars/swagger-ui/2.2.6/lib/highlight.9.1.0.pack.js' type='text/javascript'></script>
    <script src='webjars/swagger-ui/2.2.6/lib/highlight.9.1.0.pack_extended.js' type='text/javascript'></script>

    <script src='webjars/swagger-ui/2.2.6/lib/jsoneditor.min.js' type='text/javascript'></script>
    <script src='webjars/swagger-ui/2.2.6/lib/marked.js' type='text/javascript'></script>
    <script src='webjars/swagger-ui/2.2.6/lib/swagger-oauth.js' type='text/javascript'></script>
</head>

<body class="swagger-section">
<div id="message-bar" class="swagger-ui-wrap">&nbsp;</div>
<div id="swagger-ui-container" class="swagger-ui-wrap"></div>

<script type="text/javascript">
    $(function () {
        new SwaggerUi({
            url: 'api/swagger',
            dom_id: 'swagger-ui-container',
            swaggerRequstHeaders: 'application/json', // if you don't want to use it add .json to the url
            sorter: 'alpha'
        }).load();
    });
</script>
</body>
</html>
