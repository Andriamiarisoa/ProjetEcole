<%
    
%>

<h3>Etat de paiement Ecolage (projet Ecole)</h3>
    <div class="row">
        <div class="col-md-4 col-sm-6 col-xs-12">
            <form action="#" method="post">
                <select class="form-control form-group" name="mois">
                    <option value="mars">Mars</option>
                    <option value="fevrier">Fevrier</option>
                    <option value=null>Janvier</option>
                    <option value=null>Mois</option>
                </select>
                <select class="form-control form-group" name="Etat">
                    <option value=null>regler</option>
                    <option value=null>en cours</option>
                    <option value=null>retard</option>
                    <option value=null>Etat</option>
                </select>
                <button type="submit" style="float:right; margin-top: 0.25em" class="btn btn-success">Valider</button>
            </form>
        </div>
    </div>
    <div class="row" style="margin-top:2em">
        <div class="panel panel-default table-responsive">
            <table class="table table-hover table-striped">
                <tr>
                    <th>Nom</th>
                    <th>Prenom</th>
                    <th>Classe</th>
                    <th>Montant</th>
                    <th>Date de paiement</th>
                    <th>Etat</th>
                </tr>
                <tr>
                    <td>null</td>
                    <td>null</td>
                    <td>null</td>
                    <td>null</td>
                    <td>null</td>
                    <td>null</td>
                </tr>
            </table>    
        </div>
    </div>