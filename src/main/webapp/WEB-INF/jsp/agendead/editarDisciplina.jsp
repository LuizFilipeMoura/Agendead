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
        Editar Disciplina
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
        <a href="/agendead">
        <button type="button" class="btn btn-primary">Voltar ao inicio</button>
        </a>
            <div class="h-100 d-flex justify-content-center align-items-center">
                <form action="sucessoDisciplina" method="post">
        <div class="form-group">
        <label >Nome</label>
        <input type="text" class="form-control" name="disciplina.nome" placeholder="Nome" value="${disciplina.nome}">

        </div>
                    <div class="form-group">
                            <label >Professor Responsavel</label>
                            <select name="idProfessor">
                            <c:forEach items="${professoresList}" var="professor">
                                    <option value="${professor.id}" ${professor.id == disciplina.professorResponsavel.id?'selected': ''} >${professor.nome}</option >
                            </c:forEach>
                            </select>
                    </div>

                    <div class="form-group">
                            <label >Carga Horaria</label>
                        <input type="number" class="form-control" name="disciplina.cargaHoraria" placeholder="Carga Horaria" value="${disciplina.cargaHoraria}">
        <input type="text" hidden class="form-control" name="disciplina.id" value="${disciplina.id}">

                        </div>
            <label >Alunos</label><br>
<%--            <c:forEach items="${alunosList}" var="aluno">--%>
<%--                    <label class="form-check-label" >${aluno.nome}</label>--%>
<%--                    <input type="checkbox" name="id" value="${aluno.id}"--%>
<%--                name="idAlunos" ${idAlunos ? 'checked' : '' }><br>--%>

<%--                    &lt;%&ndash;            <option name="disciplina.alunosMatriculados">${aluno.nome}</option >&ndash;%&gt;--%>
<%--            </c:forEach>--%>
        <c:forEach var="category" items="${alunosList}" varStatus="s">

            <input type="checkbox" name="alunos[${s.index}].id" value="${category.id}" /> ${category.nome}<br>

        </c:forEach>
                    <input type="submit" class="btn btn-primary" value="Editar Disciplina"></input>



        <c:forEach items="${errors}" var="erro">
                        <br> <label>${erro.category} <br> ${erro.message}</label><br>
                    </c:forEach>


                </form>
            </div>
