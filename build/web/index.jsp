<%@ include file = "header.jsp" %>
<%@ include file = "sidebar.jsp" %>
<div id="page-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Projet Ecole</h1>
            </div>
            <!-- /.col-lg-12 -->
            <% if(request.getParameter("page") != null && request.getParameter("page").contentEquals("1")){ %>
                <%@ include file = "ecolage.jsp" %>
            <% } else if(request.getParameter("page") != null && request.getParameter("page").contentEquals("2")){ %>
                <%@ include file = "insertEtudiant.jsp" %>
            <% } else if(request.getParameter("page") != null && request.getParameter("page").contentEquals("3")){ %>
                <%@ include file = "listeClasse.jsp" %>
            <% } else if(request.getParameter("page") != null && request.getParameter("page").contentEquals("4")){ %>
                <%@ include file = "listeEleve.jsp" %>
            <% } else if(request.getParameter("page") == null) {%>
                <%@ include file = "intro.jsp" %>
            <% } %>
        </div>
    </div> 
</div>
    
<%@ include file = "footer.jsp" %>
