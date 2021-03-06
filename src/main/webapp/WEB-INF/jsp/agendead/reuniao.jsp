<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html lang="en">

<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="apple-touch-icon" sizes="76x76" href="img/apple-icon.png">
    <link rel="icon" type="image/png" href="img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>
        Cadastrar Aluno
    </title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
          name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <!-- CSS Files -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />
    <link href="css/paper-dashboard.css?v=2.0.1" rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <!-- <link href="assets/demo/demo.css" rel="stylesheet" /> -->
</head>

<div class="wrapper ">
    <div class="sidebar" data-color="white" data-active-color="danger">
        <div class="logo">
            <a href="https://www.creative-tim.com" class="simple-text logo-mini">
                <div class="logo-image-small">
                    <img src="img/logo-small.png">
                </div>
                <!-- <p>CT</p> -->
            </a>
            <a href="https://www.creative-tim.com" class="simple-text logo-normal">
                Professor Fulano
                <!-- <div class="logo-image-big">
                <img src="assets/img/logo-big.png">
                </div> -->
            </a>
        </div>
        <div class="sidebar-wrapper">
            <ul class="nav">
                <li class="">
                    <a href="../agendead/">
                        <i class="nc-icon nc-bank"></i>
                        <p>Início </p>
                    </a>

                </li>
                <li><a href="<c:url value="/cadastrarDisciplina"/>">
                    <i class="nc-icon nc-book-bookmark"></i>
                    <p>Cadastrar Disciplina</p>
                </a>
                </li>
                <li> <a href="<c:url value="/cadastrarProfessor"/>">
                    <i class="nc-icon nc-hat-3"></i>
                    <p>Cadastrar Professor</p>
                </a>
                </li>
                <li> <a href="<c:url value="/cadastrarAluno"/>">
                    <i class="nc-icon nc-single-02"></i>
                    <p>Cadastrar Aluno</p>
                </a></li>

            </ul>
        </div>
    </div>
    <div class="main-panel">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent">
            <div class="container-fluid">
                <div class="navbar-wrapper">
                    <div class="navbar-toggle">
                        <button type="button" class="navbar-toggler">
                            <span class="navbar-toggler-bar bar1"></span>
                            <span class="navbar-toggler-bar bar2"></span>
                            <span class="navbar-toggler-bar bar3"></span>
                        </button>
                    </div>
                    <a class="navbar-brand" href="javascript:;">Reunião XXXXXX</a>
                </div>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navigation">

                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link btn-magnify" href="javascript:;">
                                <i class="nc-icon nc-layout-11"></i>
                                <p>
                                    <span class="d-lg-none d-md-block">Stats</span>
                                </p>
                            </a>
                        </li>
                        <li class="nav-item btn-rotate dropdown">
                            <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="nc-icon nc-bell-55"></i>
                                <p>
                                    <span class="d-lg-none d-md-block">Some Actions</span>
                                </p>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link btn-rotate" href="javascript:;">
                                <i class="nc-icon nc-settings-gear-65"></i>
                                <p>
                                    <span class="d-lg-none d-md-block">Account</span>
                                </p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- End Navbar -->
        <div class="content">
            <div class="row ">

                <div class="col-md-12 center-block ">
                    <div class="card card-user">
                        <div class="card-header">
                            <h5 class="card-title">Reunião da disciplina XXXXXXXX</h5>
                        </div>
                        <div class="card-body">

                                <div class="row">
                                    <div class="col-md-5 pr-1">
                                        <div class="form-group">
                                            <p class="" style="font-size: 18px;">Ministrada pelo professor fulano</p>


                                        </div>
                                    </div>


                                </div>
                                <div class="row">
                                    <div class="col-md-6 pr-1">
                                        <div class="form-group">
                                            <span style="font-size: 18px;">Horário:</span> <p class="text-muted" style="font-size: 18px;"> 20:40 - 22:40</p>

                                        </div>
                                    </div>

                                </div>
                            <div class="row">
                                <div class="col-md-6 pr-1">
                                    <div class="form-group">

                                    </div>
                                </div>

                            </div>
                                <div class="row">
                                    <div class="card-body">
                                        <p class="" style="font-size: 18px; ">Alunos Registrados</p>
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead class=" text-primary">
                                                <th>
                                                    Nome
                                                </th>
                                                <th>
                                                    RGA
                                                </th>

                                                <th class="text-right">
                                                    Email
                                                </th>
                                                </thead>
                                                <tbody>
                                                <tr>
                                                    <td>
                                                        Dakota Rice
                                                    </td>
                                                    <td>
                                                        Niger
                                                    </td>

                                                    <td class="text-right">
                                                        $36,738
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Minerva Hooper
                                                    </td>
                                                    <td>
                                                        Curaçao
                                                    </td>

                                                    <td class="text-right">
                                                        $23,789
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Sage Rodriguez
                                                    </td>
                                                    <td>
                                                        Netherlands
                                                    </td>

                                                    <td class="text-right">
                                                        $56,142
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Philip Chaney
                                                    </td>
                                                    <td>
                                                        Korea, South
                                                    </td>

                                                    <td class="text-right">
                                                        $38,735
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Doris Greene
                                                    </td>
                                                    <td>
                                                        Malawi
                                                    </td>

                                                    <td class="text-right">
                                                        $63,542
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Mason Porter
                                                    </td>
                                                    <td>
                                                        Chile
                                                    </td>

                                                    <td class="text-right">
                                                        $78,615
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Jon Porter
                                                    </td>
                                                    <td>
                                                        Portugal
                                                    </td>

                                                    <td class="text-right">
                                                        $98,615
                                                    </td>
                                                </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>


                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="footer footer-black  footer-white ">
            <div class="container-fluid">
                <div class="row">
                    <nav class="footer-nav">
                        <ul>
                            <li><a href="https://www.creative-tim.com" target="_blank">Creative Tim</a></li>
                            <li><a href="https://www.creative-tim.com/blog" target="_blank">Blog</a></li>
                            <li><a href="https://www.creative-tim.com/license" target="_blank">Licenses</a></li>
                        </ul>
                    </nav>
                    <div class="credits ml-auto">
              <span class="copyright">
                © <script>
                  document.write(new Date().getFullYear())
                </script>, made with <i class="fa fa-heart heart"></i> by Creative Tim
              </span>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>