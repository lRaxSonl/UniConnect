<#macro page>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="/css/style.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <style>
            a {
                text-decoration: none;
            }

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
                animation: textShadowAnimation 2s infinite alternate;
            }

            @keyframes textShadowAnimation {
                0% {
                    text-shadow: 2px 2px 2px grey, 0 0 0.1em white;
                }

                100% {
                    text-shadow: 2px 2px 2px grey, 0 0 1em white;
                }

            }
        </style>
    </head>


    <body>
    <header class="container-fluid bg-dark py-3">
        <div class="row justify-content-between align-items-center">
            <div class="col-md-2">
                <a href="/"><img src="/assets/img/icon.jpeg" alt="Left Image 1" class="img-fluid" style="width: 58px; height: 54px;"></a>
            </div>
            <div class="col-md-2">


                <form id="searchForm" method="get" action="/">
                    <input type="text" name="title">
                    <input type="submit" value="Search" style="display: none;">
                    <a href="javascript:void(0);" onclick="submitForm()">
                        <img src="/assets/img/search.jpeg" alt="Search Image" class="img-fluid" style="width: 38px; height: 38px;">
                    </a>
                </form>
            </div>


            <div class="col-md-3 text-center">
                <a href="/"><h1 class="text-white">UniConnect</h1></a>
            </div>

            <div class="col-md-1">
                <a href="/post/favorites" style="color: yellow;">Favotires</a>
            </div>

            <div class="col-md-1">
                <a href="/post/create" class="text-white">Create new post</a>
            </div>
            <div class="col-md-1">
                <a href="/login" class="text-white">Login</a>
            </div>
            <div class="col-md-1">
                <a href="/registration" class="text-white">Register</a>
            </div>
        </div>
    </header>

    <#nested>

    </body>



</html>
</#macro>