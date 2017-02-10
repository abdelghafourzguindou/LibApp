<%-- 
    Document   : bookInsert
    Created on : 2 févr. 2017, 01:29:18
    Author     : l.IsSaM.l
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <head>
<%@include file="page_elements/header.jsp" %>
   </head>
<body>
    <div id="wrapper">
    <%@include file="page_elements/navbar.jsp" %> 
          
       
        <!-- /. NAV SIDE  -->
        <div id="page-wrapper" >
            <div id="page-inner">
          
                 <!-- /. ROW  -->
                 <hr />
                 
                 <div class="col-md-12 center">
                    <form method="post" action="books">
                    <input type="text" hidden name="process" value="insert" />
                    <div class="well well-lg"             
                    <h4 class="well_titre">
                        <i class="glyphicon glyphicon-book"></i>
                        <span> Titre du Livre:</span><span class="mini_tabulation">
                            <input class="form-control" name="titreBook"  >
                        </span><br/>
                    
                    <div class="row col-md-8">
                    <div class="column">
                    <div class="row col-md-12">
                    

                    <br><span class="">Code du livre</span>
                    <span class="mini_tabulation"><input class="form-control form-username" name="codeBook" id="form-username"/>
                    </span><br/>

                    <br><span class="">Nom de l'auteur</span>
                    <span class="mini_tabulation"><input class="form-control form-username" name="auteurBook" id="form-username"/>
                    </span><br/>

                    <br> <span class="">Catégorie du livre</span>
                    <span class="mini_tabulation"><input class="form-control form-username" name="categorieBook" id="form-username"/>
                    </span><br/>
                    
                    <br><span class="">Date de parution du livre</span>
                    <span class="mini_tabulation"><input class="form-control form-username"  type="date" name="date" id="form-username"/>
                    </span><br/>
                    <br><span class="">Nombre de copies du livre</span>
                    <span class="mini_tabulation"><input class="form-control form-username" name="nombreCopieBook" id="form-username"/>
                    </span><br/>

                    <br/><br/>
                    </div></div></div>

                    <div class="row">
                    <div class="col-md-4">

            

                    <br/><hr/><br/>

                    <button  class="btn btn-info btn-lg bouton col-lg-12 col-md-12 col-sm-12 col-xs-12" id="enrigistrer">
                    <span class="glyphicon glyphicon-floppy-disk icon_in_button" aria-hidden="true"></span>
                    </button> 
                 
                    <p><br/><br/></p>
                    <a  href="bookList.jsp" class="btn btn-danger btn-lg bouton col-lg-12 col-md-12 col-sm-12 col-xs-12 bouton-supprimer-abonne"><span class="glyphicon glyphicon-remove icon_in_button" aria-hidden="true"></span>Annuler </a>
                    </div>

                     <br/><br/>
                    </div>
                  
                   
                    </div>
                        



                    </form>

                    </div>
                </div>
               
    </div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
    
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    
 
       <script src="login_ressources/js/jquery-1.11.1.min.js"></script>
                <!--script src="login_ressources/js/scripts.js"></script-->

        <script src="login_ressources/bootstrap/js/bootstrap.min.js"></script>
        <script src="login_ressources/js/jquery.backstretch.min.js"></script>

    
    
   
</body>
</html>

