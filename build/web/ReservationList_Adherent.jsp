<%-- 
    Document   : ReservationList_Adherent
    Created on : 10 févr. 2017, 11:07:58
    Author     : l.IsSaM.l
--%>

<%@page import="Beans.ReservationP"%>
<%@page import="Beans.EmpruntP"%>
<%-- 
    Document   : ReservationList
    Created on : 5 févr. 2017, 01:12:52
    Author     : l.IsSaM.l
--%>
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
        <div id="page-wrapper" >
           
                
            <% Adherent currentAdherent = (Adherent)request.getSession().getAttribute("currentAdherent"); %>

                 
                 
                 <div class="row">
                      <!-- Ajouter Livre -->
                 
                <div class="col-md-12">
                
               
                    
                <!-- Advanced Tables -->
                    <div class="panel panel-default">
                    
                    <div class="panel-heading">
                        
                      <h4 class="well_titre_2"> Liste des livres</h4>
                      
                    
                        </div>
                        <div class="panel-body">
                             <div id="page-inner">
                                 
                                                                 
                                         <div class="form-group input-group">
                                            <input type="text" class="form-control" id="myInputTextField">
                                            <span class="input-group-btn">
                                                <button class="btn btn-default" type="button"><i class="fa fa-search"></i>
                                                </button>
                                            </span>
                                        </div>
                            <div class="table-responsive">
                                 <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                                           
                                                        <th></th>
                                                        <th>Titre du livre</th>
                                                        <th>Date Reservation</th>
                                                        <th>Anuulation</th>
                                                       
                                                


                                        </tr>
                                    </thead>
                                                    <tbody>
                                                    <!-- nb_forms=0 -->
                                                    <!-- foreach (Livre L: Liste_Livres -->
                                                    
                                                       
                                                    <%  ArrayList<ReservationP> li =  DAO.ReservationDAO.getAll(currentAdherent.getIdAdherent());
                                                       for ( ReservationP bk : li ) {  %>  
                                                <tr>
                                                      <td>
                                                                <i class="glyphicon glyphicon-book icon_in_button"></i>
                                                            </td>
                                                            <!-- normalement id="form.'nb_forms'."-->


                                                            <td><%=bk.getNomBook() %></td>
                                                            <td><%=bk.getDateReservation() %></td>
                                                            <td>
                                                       <center><a href="ReservationServlet?process=annuler&from=adherent&id_adherent=<%=bk.getIdAdherent() %>&id_book=<%= bk.getIdBook() %>"><input type="button" class="ConfirmerRerservation btn btn-success" value="Annuler"></a> </center>

                                                            </td>
                                                </tr>
                                                <% } %>

                                                        <!-- nb_forms++; -->
                                                    <!-- fin foreach -->
                                                        
                                                        
                                 </tbody>
                                                </table>
                                         </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div
        </div>
    </div>
               
    </div>
</div>
             <!-- /. PAGE INNER  -->
          
         <!-- /. PAGE WRAPPER  -->
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    
    <% if ( request.getAttribute("iteration") != null ) {
        int exETAT = (int) request.getAttribute("iteration");
         if (exETAT == 0 ) { %> 
    <script>
 
     console.log(0);
     nomAdherent = $("#NOMADHERENT").val();

                           $(".normal").hide();
                           $(".ss").text('Bonjour '+nomAdherent+' : EN ATTENTE');
                           $(".s").show();
    </script>
        <%  } if (exETAT == 2 ) { %>
            <script>
console.log(1);
  nomAdherent = $("#NOMADHERENT").val();                       
                           $(".normal").hide();
                           $(".ss").text('Bonjour '+ nomAdherent+ ' : BLOQUE ');
                           $(".s").show();
                                     </script>
                       <% } %>
                

    
    
    <% } %>
    
    <script src="assets/js/jquery-1.10.2.js"></script>
   
      <!-- BOOTSTRAP SCRIPTS -->
      <script src="assets/js/bootstrap.min.js"></script>   
    
    <script src="js/jquery.bootpop.js" ></script>
    <!-- METISMENU SCRIPTS -->
    <!--script src="assets/js/jquery.metisMenu.js"></script-->
     <!-- DATA TABLE SCRIPTS -->
 
    <script src="assets/js/dataTables/jquery.dataTables.js"></script>

         <!-- CUSTOM SCRIPTS -->
         <!--script src="assets/js/custom.js"></script-->
         <script src="js/ControlAdherent.js" ></script>
   
</body>
</html>