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
        Paper Dashboard 2 by Creative Tim
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

        <body class="">
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
        Aluno Fulano
        <!-- <div class="logo-image-big">
        <img src="assets/img/logo-big.png">
        </div> -->
        </a>
        </div>
        <div class="sidebar-wrapper">
        <ul class="nav">
        <li class="active ">
        <a href="./dashboard.jsp">
        <i class="nc-icon nc-bank"></i>
        <p>Início</p>
        </a>
        </li>
        <!-- <li>
        <a href="./icons.html">
        <i class="nc-icon nc-diamond"></i>
        <p>Icons</p>
        </a>
        </li>
        <li>
        <a href="./map.html">
        <i class="nc-icon nc-pin-3"></i>
        <p>Maps</p>
        </a>
        </li>
        <li>
        <a href="./notifications.html">
        <i class="nc-icon nc-bell-55"></i>
        <p>Notifications</p>
        </a>
        </li>
        <li>
        <a href="./user.html">
        <i class="nc-icon nc-single-02"></i>
        <p>User Profile</p>
        </a>
        </li>
        <li>
        <a href="./tables.html">
        <i class="nc-icon nc-tile-56"></i>
        <p>Table List</p>
        </a>
        </li>
        <li>
        <a href="./typography.html">
        <i class="nc-icon nc-caps-small"></i>
        <p>Typography</p>
        </a>
        </li>
        <li class="active-pro">
        <a href="./upgrade.html">
        <i class="nc-icon nc-spaceship"></i>
        <p>Upgrade to PRO</p>
        </a>
        </li>-->
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
        <a class="navbar-brand" href="javascript:;">Início</a>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation"
        aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
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
        <a class="nav-link dropdown-toggle" href="http://example.com" id="navbarDropdownMenuLink"
        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
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
        <div class="row">
        <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="card card-stats">
        <div class="card-body ">
        <div class="row">
        <div class="col-5 col-md-4">
        <div class="icon-big text-center icon-warning">
        <i class="nc-icon nc-calendar-60 text-warning"></i>
        </div>
        </div>
        <div class="col-7 col-md-8">
        <div class="numbers">
        <p class="card-category">Reuniões</p>
        <p class="card-title">3
        <p>
        </div>
        </div>
        </div>
        </div>
        <div class="card-footer ">
        <hr>
        <div class="stats">
        <i class="fa fa-calendar-o"></i>
        Hoje
        </div>
        </div>
        </div>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="card card-stats">
        <div class="card-body ">
        <div class="row">
        <div class="col-5 col-md-4">
        <div class="icon-big text-center icon-warning">
        <i class="nc-icon nc-book-bookmark text-success"></i>
        </div>
        </div>
        <div class="col-7 col-md-8">
        <div class="numbers">
        <p class="card-category">Disciplinas</p>
        <p class="card-title">4
        <p>
        </div>
        </div>
        </div>
        </div>
        <div class="card-footer ">
        <hr>
        <div class="stats">
        <i class="nc-icon nc-bulb-63"></i>
        Cursando
        </div>
        </div>
        </div>
        </div>
        <div class="col-lg-3 col-md-6 col-sm-6">
        <div class="card card-stats">
        <div class="card-body ">
        <div class="row">
        <div class="col-5 col-md-4">
        <div class="icon-big text-center icon-warning">
        <i class="nc-icon nc-hat-3 text-danger"></i>
        </div>
        </div>
        <div class="col-7 col-md-8">
        <div class="numbers">
        <p class="card-category">Professores</p>
        <p class="card-title">6
        <p>
        </div>
        </div>
        </div>
        </div>
        <div class="card-footer ">
        <hr>
        <div class="stats">
        <i class="nc-icon nc-book-bookmark"></i>
        Das suas disciplinas
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
        ©
        <script>
        document.write(new Date().getFullYear())
        </script>, made with <i class="fa fa-heart heart"></i> by Creative Tim
        </span>
        </div>
        </div>
        </div>
        </footer>
        </div>
        </div>
        <!--   Core JS Files   -->
        <script src="js/core/jquery.min.js"></script>
        <script src="js/core/popper.min.js"></script>
        <script src="js/core/bootstrap.min.js"></script>
        <script src="js/plugins/perfect-scrollbar.jquery.min.js"></script>
        <!--  Google Maps Plugin    -->
        <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
        <!-- Chart JS -->
        <script src="js/plugins/chartjs.min.js"></script>
        <!--  Notifications Plugin    -->
        <script src="js/plugins/bootstrap-notify.js"></script>
        <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
        <script src="js/paper-dashboard.min.js?v=2.0.1" type="text/javascript"></script>
        <!-- Paper Dashboard DEMO methods, don't include it in your project! -->
        <script src="demo/demo.js"></script>
        <script>
        $(document).ready(function () {
        // Javascript method's body can be found in assets/assets-for-demo/js/demo.js
        demo.initChartsPages();
        });
        </script>
        </body>

        </html>