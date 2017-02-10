<%-- 
    Document   : LivreAujourdui
    Created on : 8 févr. 2017, 23:26:10
    Author     : l.IsSaM.l
--%>

<%@page import="Beans.ReservationP"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="DAO.BookDAO"%>
<%@page import="Beans.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Beans.Adherent"%>
<html>
<head>
<%@include file="page_elements/header.jsp" %>
<style>
    .pagination .paginate_button a.paginate_button {
    color: #fffff !important;
}
.paging_full_numbers a.paginate_active {
    color: #fff !important;
}
</style>
   </head>
<body>
    <div id="wrapper">
  
      <%@include file="page_elements/navbar.jsp" %> 
        
      
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
           
                 
                 <div class="row">
                      <!-- Ajouter Livre -->
                 
                <div class="col-md-12">
                
               
                    
                <!-- Advanced Tables -->
                    <div class="panel panel-default">
                    
                    <div class="panel-heading">
                        
                      <h4 class="well_titre_2"> Livres d'aujourd'hui</h4>
                      
                    
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
                                                            <th>|</th>
                                                            <th>Id book</th>
                                                            <th>Nom book</th>
                                                            <th>Id Adherent</th>
                                                            <th>CIN </th>
                                                            <th>Nom adherent</th>
                                                            <th>Prenom</th>


                                        </tr>
                                    </thead>
                                                    <tbody>
                                                    <!-- nb_forms=0 -->
                                                    <!-- foreach (Livre L: Liste_Livres -->
                                                    
                                                       
                                                     <%  ArrayList<ReservationP> li = DAO.EmpruntDAO.getLivreAujourdui();
                                                       for ( ReservationP Em : li ) {  %>   
                                                <tr>
                                                     <td>
                                                            <i class="glyphicon glyphicon-book icon_in_button"></i>
                                                     </td>
                                                        <!-- normalement id="form.'nb_forms'."-->
                                                          
                                                   
                                                        <td><%=Em.getIdBook() %></td>
                                                        <td><%=Em.getNomBook() %></td>
                                                        <td><%=Em.getIdAdherent() %></td>
                                                        <td><%=Em.getCIN() %></td>
                                                        <td><%=Em.getNomAdherent() %></td>
                                                        <td><%=Em.getPrenomAdherent() %></td>
                                                        
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
    
        <script src="js/jquery-1.10.2.js" type="text/javascript"></script>
      <!-- BOOTSTRAP SCRIPTS -->
      <script src="assets/js/bootstrap.min.js"></script>   
    
    <script src="js/jquery.bootpop.js" ></script>
    <!-- METISMENU SCRIPTS -->
    <!--script src="assets/js/jquery.metisMenu.js"></script-->
     <!-- DATA TABLE SCRIPTS -->
 
    <script src="assets/js/dataTables/jquery.dataTables.js"></script>

         <!-- CUSTOM SCRIPTS -->
         <!--script src="assets/js/custom.js"></script-->
   
</body>
</html>