<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Uploading file</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head> 
    <body>
        <h1>Uploading file</h1>

        <form action="upload"  enctype="multipart/form-data">
            <label>Enter file</label>
            <input type="file" name="file">
            <button type="submit">Upload</button>
        </form>
    </body>
</html>