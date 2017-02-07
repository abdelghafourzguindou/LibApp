<%@page import="DAO.BookDAO"%>
<%@page import="Beans.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Beans.Adherent"%>
<html>

    <head>
        
        <%@include file="page_elements/header.jsp" %>
        
        <link href="css/win.css" rel="stylesheet">

        <style>
            
.s
{
  background-color: #000;
  position: absolute;
  top: 0px;
  right: 0px;
  width: 100%;
  height: 100%;
  opacity: 0.9;
  z-index: 50;
  display: none
}

        </style>

    </head>
    <body>
        
        <div id="wrapper">

            <%@include file="page_elements/navbarAdherent.jsp" %> 

            <!-- /. NAV SIDE  -->

         
            <div id="page-wrapper" >
                <div id="page-inner">
                    
                    
        
      
                    

                   



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

         <!--script type="text/javascript" src="js/ttw-simple-notifications-min.js"></script>    
         <script type="text/javascript" src="js/Notification.js"></script--> 


</body>
</html>