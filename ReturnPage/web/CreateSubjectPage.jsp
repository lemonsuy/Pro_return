<%-- 
    Document   : CreateSubjectPage
    Created on : Apr 14, 2017, 8:54:33 PM
    Author     : Lemon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="3.css">
        <title>Create subject Page</title>
    </head>
    <body>
          
        <div>
                   <h2>Create Subject</h2>
                   
                   <hr>
                   
            <form method="post" action="CreateSub"> 
                <p>id : <input type="text" name="id"></p>               
                <p>Subject name: <input type="text" name="name" ></p>                
                <p>Course_id : <input type="text" name="course_id" ></p>
                <input type="submit" name="submit">                    
            </form>                      
        </div>

    </body>
</html>
