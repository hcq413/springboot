<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>freemarker静态模板</title>
</head>
<body>
<#list User as user>
    <li>${user.name}:${user.age}:${user.hobby}</li>
</#list>
</body>
</html>