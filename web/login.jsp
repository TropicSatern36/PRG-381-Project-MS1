<%-- 
    Document   : login
    Created on : 21 Aug 2024, 12:33:19
    Author     : emile
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
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

        form input[type="text"], form input[type="password"], form button {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        form button {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        form input[type="submit"] {
            width: 100%;
            padding: 15px; 
            margin: 10px 0;
            border: none;
            border-radius: 4px;
            background: linear-gradient(45deg,#1F51FF, #81C784);; 
            color: white;
            font-size: 18px; 
            cursor: pointer;
            transition: background 0.3s ease;
        }
        

        form input[type="submit"]:hover {
            background: linear-gradient(45deg,#1F51FF, #81C784);; 
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1>Login</h1>
        <form action="welcome.jsp" method="POST">
            <input type="text" name="txtUsername" placeholder="Username" required />
            <input type="password" name="txtPassword" placeholder="Password" required />
            <input type="submit" value="Login" name="btnLogin" />
        </form>
</html>
