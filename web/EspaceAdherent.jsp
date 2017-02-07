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

            <% Adherent currentAdherent = (Adherent) request.getAttribute("CurrentAdherent");%>

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