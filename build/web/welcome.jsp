<%-- 
    Document   : welcome
    Created on : 27 Aug 2024, 09:54:02
    Author     : emile
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome</title>
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
            color: white; 
            text-align: center;
        }


        .content-container {
            background: rgba(0, 0, 0, 0.7); 
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
            width: 50%;
            max-width: 600px;
        }

        h1 {
            margin-bottom: 20px;
        }

        p {
            font-size: 18px;
        }

        a {
            color: #4CAF50;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            color: #45a049;
        }
        input[type="submit"] {
        width: 15%;
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
    </style>
</head>
<body>
    <div class="content-container">
        <h1>Welcome Person Name here?</h1>
        <p>Logged in successfully!</p>
        <p>Is there supposed to be something else here?</p>
        <p>
            <form action="index.jsp" method="POST">
                <input type="submit" value="Logout" name="btnLogout" />
            </form>
        </p>
    </div>
</body>
</html>
