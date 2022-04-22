
<%@page import="model.EleveClasseGlobal"%>
<%@page import="java.util.ArrayList"%>
<%
            ArrayList<EleveClasseGlobal> liste = (ArrayList<EleveClasseGlobal>)request.getAttribute("listeEleveClasse");
%>
<div class="container-fluid">
      <!-- /.row -->
      <div class="row">
      <div class="col-lg-12">
            <div class="panel panel-green">
                  <div class="panel-heading">
                  Liste des Eleves
                  </div>
                  <!-- /.panel-heading -->
                  <div class="panel-body">
                  <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                              <thead>
                              <tr>
                                    <th>Nom</th>
                                    <th>Prenom</th>
                                    <th>Niveau</th>
                                    <th>Annee scolaire</th>
                                    <th>supprimer</th>
                              </tr>
                              </thead>
                              <tbody>   
                              <% for (int idx = 0; idx < liste.size(); idx++) { %>
                                    <tr class="odd gradeX">
                                          <td><% out.println(liste.get(idx).getNom()); %></td>
                                          <td><% out.println(liste.get(idx).getPrenom()); %></td>
                                          <td><% out.println(liste.get(idx).getNiveau()); %></td>
                                          <td class="center"><% out.println(liste.get(idx).getAnneeScolaireDebut() + "-" + liste.get(idx).getAnneeScolaireFin()); %></td>
                                          <td class="center" style="text-align:center"><a href="/ProjetEcole/ListeEleveClasse?idClasse=<% out.println(request.getParameter("idClasse")); %>&idEleve=<% out.println(liste.get(idx).getIdEleve()); %>"><i class="fa fa-trash fa-fw"></i></a></td>
                                    </tr>
                              <% } %>
                              </tbody>
                        </table>
                  </div>
                  </div>
            </div>
      </div>
      </div>
</div>      
                