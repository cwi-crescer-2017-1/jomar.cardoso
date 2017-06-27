<%-- 
    Document   : index
    Created on : 27/06/2017, 01:10:00
    Author     : Jomar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css?family=Barrio" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/stylesheets.css">
    <title>Locadora Crescer</title>
</head>
<body>
    <div class="container-fluid">   
        <div class="row">
            <div class="col-md-12">
                <div class="banner row">
                    <div class="col-md-12">
                        <div class="row">
                            <div class="col-md-4 col-md-offset-3 col-sm-8 col-sm-offset-1">
                                <a href="#!/menu"><h1 class="">LOCADORA CRESCER</h1></a>
                            </div>
                            <div class=" usuarioLogado text-center col-md-offset-1 col-md-2  col-sm-3" ng-show="usuarioLogado">                    
                                <div class="user col-md-4 col-sm-4"></div>
                                <div class="col-md-8">
                                    <a href="#!/menu">Olá {{nomeIndexLogado}}
                                    <div><span>Bem vindo</span> </div></a>                                           
                                    <a href="#!/" ng-click="logout()"><p class="text-right">Sair</p></a>
                                </div>
                            </div>    
                            <div class="col-md-offset-1 col-md-2  col-sm-3 usuarioLogado text-center" ng-show="!usuarioLogado">
                                <div class="col-md-8 col-md-offset-2">
                                    <a href="#!/login">
                                        <div><span>Olá</span> </div>                                           
                                        <p>Entre ou Cadastre-se</p>
                                    </a>
                                </div>
                            </div>
                            <div class="container">    
                                <div class="row">
                                    <div class="col-md-4 col-md-offset-4">
                                        <h2 class="page-header">Login</h2>
                                        <form name="formLogin" method="post">
                                        <div class="form-group">
                                            <label for="login">Login</label>
                                            <input type="text" class="form-control" name="login">
                                        </div>
                                        <div class="form-group">
                                            <label for="senha">Senha</label>
                                            <input type="password" class="form-control" name="senha">
                                        </div>
                                        <button class="btn btn-default" type="button">Entrar</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="destaques-rotulo col-md-12">                
            </div>  
        </div>
    </div>
    <!-- ######################################################### ng view ##########################################################-->
   
    <!-- ######################################################### ng view ##########################################################-->
    <div class="container-fluid">   
        <div class="row">
            <div class="destaques-rotulo col-md-12">                
            </div>  
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="banner row">
                    <div class="col-md-8 col-md-offset-2 text-center" style="padding-top: 20px;">
                        Mussum Ipsum, cacilds vidis litro abertis. Si u mundo tá muito paradis? Toma um mé que o mundo vai girarzis! Praesent malesuada urna nisi, quis volutpat erat hendrerit non. Nam vulputate dapibus. Tá deprimidis, eu conheço uma cachacis que pode alegrar sua vidis. Não sou faixa preta cumpadi, sou preto inteiris, inteiris.
                    </div>
                </div>
            </div>
        </div>        
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</body>
</html>
