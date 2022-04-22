<%@ include file = "header.jsp" %>
    </div>
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="login-panel panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Please Sign In</h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" action="/ProjetEcole">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Nom" name="nom" type="text" autofocus>
                                    </div>
                                    <div class="form-group" name="matiere">
                                        <select class="form-control">
                                            <option value="">matiere</option>
                                            <option value="">matiere2</option>
                                            <option value="">matiere3</option>
                                            <option value="">matiere4</option>
                                            <option value="">matiere5</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="password" name="pwd" type="password">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control btn btn-success" value="login" type="submit">
                                    </div>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

<%@ include file = "footer.jsp" %>