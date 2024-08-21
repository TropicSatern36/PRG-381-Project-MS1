<%-- 
    Document   : index
    Created on : 21 Aug 2024, 09:32:06
    Author     : emile
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
         <style>
            body {        
            background: url('https://img.freepik.com/free-vector/futuristic-background-with-lines_23-2148487905.jpg?t=st=1724228757~exp=1724232357~hmac=5f41634eddde12fd013e6b00693756ae6ae597cd99bf305301b2805a6681d108&w=1380') no-repeat center center fixed;
            background-size: cover;
            height: 100vh;
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: Arial, sans-serif;
            text-align: center
        }

            h1 {
                margin-bottom: 30px;
                color: white;
            }

            .button-container {
                display: flex;
                flex-direction: column;
                align-items: center;
                gap: 20px;
            }

            button {
                padding: 20px 40px;
                font-size: 24px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 8px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            button:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        
        
        <div class="button-container">
            <h1>Welcome</h1>
            <button onclick="window.location.href='login.jsp'">Login</button>
            <button onclick="window.location.href='register.jsp'">Register</button>
        </div>
    </body>
</html>
