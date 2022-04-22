<%@page import="model.Classe"%>
<%@page import="java.util.ArrayList"%>
<%
      ArrayList<Classe> liste = (ArrayList<Classe>)request.getAttribute("listeClasse");
%>
<h2>Liste Classe</h2>
            <%   // for(int i = 0; i<4; i++) {
                  for (int idx = 0; idx < liste.size(); idx++) {
                  String o=String.valueOf(liste.get(idx).getId());
            %>
             
      <div class="col-lg-3 col-md-6">
            <div class="panel panel-green">
                  <div class="panel-heading">
                  <div class="row">
                        <div class="col-xs-3">
                              <i class="fa fa-mortar-board fa-5x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                              <div class="huge"><% out.println(liste.get(idx).getNiveau()); %></div>
                        </div>
                  </div>
                  </div>
                  <a href="ListeEleveClasse?idClasse=<%out.println(o);%>&page=4">
                  <div class="panel-footer">
                        <span class="pull-left">View Details</span>
                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

                        <div class="clearfix"></div>
                  </div>
                  </a>
            </div>
      </div>
<%}%>
<%//}%>