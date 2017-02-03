<%@page import="DAO.BookDAO"%>
<%@page import="Beans.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Beans.Adherent"%>
<html>

    <head>
        <%@include file="page_elements/header.jsp" %>

    </head>
    <body>
        <div id="wrapper">

            <%@include file="page_elements/navbarAdherent.jsp" %> 

            <!-- /. NAV SIDE  -->
            
            <% Adherent currentAdherent = (Adherent)request.getAttribute("CurrentAdherent"); %>
            
            <div id="page-wrapper" >
                <div id="page-inner">

                    <div class="column col-lg-11 col-md-11 col-sm-12 col-xs-12 center">
                        <div class="abonnes_principal zone_grise_droite">              
                            <div class="well well-lg">
                                <div class="row">
                                    <h4 class="well_titre_2"> Liste des livres</h4>
                                    
                                    </div><br/><br/>
                                <!-- Advanced Tables -->
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">                                                    <thead>
                                                    <tr>
                                                        <th class="center"></th>
                                                        <th class="center">Titre du livre</th>
                                                        <th class="center">Auteur du livre</th>
                                                        <th class="center">Genre du livre</th>
                                                        <th class="center">Date d'apparution</th>
                                                        <th class="center">Nombre de copies disponibles</th>                                                            
                                                        <th colspan="2"><center>Reserver un Livre</center></th>
                                                </tr>
                                                </thead>
                                                <div id="corpTab">
                                                    <tbody>
                                                        <!-- nb_forms=0 -->
                                                        <!-- foreach (Livre L: Liste_Livres -->


                                                        <%  ArrayList<Book> li = BookDAO.getAll();
                                                       for ( Book bk : li ) {  %>   
                                                        <tr>
                                                            <td>
                                                                <i class="glyphicon glyphicon-book icon_in_button"></i>
                                                            </td>
                                                            <!-- normalement id="form.'nb_forms'."-->


                                                            <td><%=bk.getTitreBook() %></td>
                                                            <td><%=bk.getAuteurBook() %></td>
                                                            <td><%=bk.getCategorieBook() %></td>
                                                            <td><%=bk.getDateParution() %></td>
                                                            <td><%=bk.getNombreCopieBook() %></td>
                                                            <td>
                                                            <center>
                                                                <a href="ReservationServlet?id_book=<%=bk.getIdBook()%>&id_adherent=<%=currentAdherent.getIdAdherent()%>" > 
                                                                    <input type="button" class="Reservation btn btn-success" id_book="<%=bk.getIdBook()%>" id_adherent="<%=currentAdherent.getIdAdherent()%>" value="Reserver">
                                                                </a>
                                                            </center>
                                                            </td>
                       
                                                        </tr>
                                                    <% } %>

                                                    <!-- nb_forms++; -->
                                                    <!-- fin foreach -->


                                                    </tbody>
                                                </div>
                                            </table>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
    <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->

    <script src="assets/js/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP SCRIPTS -->
    <script src="assets/js/bootstrap.min.js"></script>

    <script src="js/jquery.bootpop.js" ></script>
    <!-- METISMENU SCRIPTS -->
    <script src="assets/js/jquery.metisMenu.js"></script>
    <!-- DATA TABLE SCRIPTS -->
    <script src="assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="assets/js/dataTables/dataTables.bootstrap.js"></script>

    <script type="text/javascript" src="dist/demo.js"></script>
    <script src="js/ControlBook.js" ></script>

    <!-- CUSTOM SCRIPTS -->
    <script src="assets/js/custom.js"></script>


</body>
</html>