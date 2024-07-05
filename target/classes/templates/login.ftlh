<#import "base.ftlh" as base>

<@base.page>

    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        .header {
            background-color: black;
            color: white;
            padding: 10px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            text-align: center;
            height: 60px;
        }

        .header h1,
        .header p {
            margin: 0;
        }

        .header .auth-buttons {
            display: flex;
            gap: 15px;
        }

        .header button {
            font-size: 12px;
            padding: 8px 10px;
        }

        .header button.create-post {
            background-color: green;
            color: white;
            margin-right: 30px;
        }

        .header button.cpost {
            background-color: white;
            color: black;
        }

        .textShadowAnimation:hover {
            animation: textShadowAnimation 1s infinite alternate;
        }

        @keyframes textShadowAnimation {
            0% {
                text-shadow: 1px 1px 2px black, 0 0 0.1em white;
            }

            100% {
                text-shadow: 1px 1px 2px black, 0 0 1em white;
            }
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            margin-top: 50px;
            padding: 20px;
            background-color: #f9f9f9;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        form input[type="text"],
        form input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        form button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        form button:hover {
            background-color: #0056b3;
        }
    </style>

<form action="/auth/login-now" method="post">
    <h2>Login</h2>
    <label for="username">Username:</label>
    <input type="text" id="username" name="username">

    <label for="password">Password:</label>
    <input type="password" id="password" name="password">

    <button type="submit">Log In</button>
</form>

</@base.page>