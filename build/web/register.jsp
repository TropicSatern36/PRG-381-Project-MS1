<%-- 
    Document   : register
    Created on : 21 Aug 2024, 09:32:48
    Author     : emile
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <style>
        body {        
            background: url('background.jpg') no-repeat center center fixed;
            background-size: cover;
            height: 100vh;
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: Arial, sans-serif;
        }

        .form-container {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }

        h1 {
            margin-bottom: 20px;
        }

        form input[type="text"], form input[type="email"], form input[type="password"], form button {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        form button {
            background-color: #1F51FF;
            color: white;
            border: none;
            cursor: pointer;
        }

        form button:hover {
            background-color: #45a049;
        }
        
        .buttons {
        width: 100%;
        padding: 15px; 
        margin: 10px 0;
        border: none;
        border-radius: 4px;
        background: linear-gradient(45deg,#1F51FF, #81C784); 
        color: white;
        font-size: 18px; 
        cursor: pointer;
        transition: background 0.3s ease;
    }
    </style>
    </head>
    <body>
        <div class="form-container">
        <h1>Register</h1>
        
        <form name="display" action="display.jsp" method="POST">
            <table border="0">             
                <tbody>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="txtUsername" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td><input type="text" name="txtName" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Surname:</td>
                        <td><input type="text" name="txtSurname" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="txtPassword" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Phone Number:</td>
                        <td><input type="text" name="txtPhone" value="" size="50" /></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="txtEmail" placeholder="example@domain.com" size="50" /></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Register" name="btnRegister" class="buttons" />
            <input type="reset" value="Clear" name="btnClear" class="buttons" />
        </form>
        </div>
    </body>
</html>
