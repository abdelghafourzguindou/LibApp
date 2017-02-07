<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>LibApp dashboard</title>
        <!-- BOOTSTRAP STYLES-->
        <link href="assets/css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLES-->
        <link href="assets/css/font-awesome.css" rel="stylesheet" />
        <!-- MORRIS CHART STYLES-->
        <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
        <!-- CUSTOM STYLES-->
        <link href="assets/css/custom.css" rel="stylesheet" />
        <!-- GOOGLE FONTS-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    </head>
    <body>
        <div id="wrapper">
            <%@include file="page_elements/navbar.jsp" %>
            <div id="page-wrapper" >
                <div id="page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <h2>Admin Dashboard</h2>   
                            <!--<h5>Welcome Jhon Deo , Love to see you back. </h5>-->
                        </div>
                    </div>              
                    <!-- /. ROW  -->
                    <hr />
                    <div class="row">
                        <div class="col-md-3 col-sm-6 col-xs-6">           
                            <div class="panel panel-back noti-box">
                                <span class="icon-box bg-color-red set-icon">
                                    <i class="fa fa-users" aria-hidden="true"></i>
                                </span>
                                <div class="text-box" >
                                    <a href="AdherentAttente.jsp"><p class="main-text"> <%=DAO.AdherentDAO.selectCountAdherentEnAttente() %> New</p> </a>
                                    <p class="text-muted">Adherent</p>
                                    
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs-6">           
                            <div class="panel panel-back noti-box">
                                <span class="icon-box bg-color-green set-icon">
                                    <i class="fa fa-bars"></i>
                                </span>
                                <div class="text-box" >
                                    <a href="#"><p class="main-text">30 Tasks</p></a>
                                    <p class="text-muted">Remaining</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs-6">           
                            <div class="panel panel-back noti-box">
                                <span class="icon-box bg-color-blue set-icon">
                                    <i class="fa fa-bell-o"></i>
                                </span>
                                <div class="text-box" >
                                    <a href="#"><p class="main-text">30 New</p></a>
                                    <p class="text-muted">Notifications</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6 col-xs-6">           
                            <div class="panel panel-back noti-box">
                                <span class="icon-box bg-color-brown set-icon">
                                    <i class="fa fa-plus-square" aria-hidden="true"></i>
                                </span>
                                <div class="text-box" >
                                    <a href="ReservationList.jsp"><p class="main-text"><%=DAO.ReservationDAO.selectCountReservation() %> new</p></a>
                                    <p class="text-muted">Resevation</p>
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr />                
                    <div class="row"> 


                        <div class="col-md-9 col-sm-12 col-xs-12" hidden>                     
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Bar Chart Example
                                </div>
                                <div class="panel-body">
                                    <div id="morris-bar-chart"></div>
                                </div>
                            </div>            
                        </div>
                        
                        
                   
                        
                        <!--<div class="col-md-6 col-sm-12 col-xs-12">-->
                            <!--<div class="panel panel-default">
                                <div class="panel-heading">
                                    Statistique
                                </div>-->
                                <div class="panel-body">
                                    <div id="morris-donut-chart"></div>
                                </div>
                           <!-- </div>
                        </div>-->
                  
                        
                        <!--<div class="col-md-3 col-sm-12 col-xs-12">                       
                            <div class="panel panel-primary text-center no-boder bg-color-green">
                                <div class="panel-body">
                                    <i class="fa fa-bar-chart-o fa-5x"></i>
                                    <h3>120 GB </h3>
                                </div>
                                <div class="panel-footer back-footer-green">
                                    Disk Space Available

                                </div>
                            </div>
                            <div class="panel panel-primary text-center no-boder bg-color-red">
                                <div class="panel-body">
                                    <i class="fa fa-edit fa-5x"></i>
                                    <h3>20,000 </h3>
                                </div>
                                <div class="panel-footer back-footer-red">
                                    Articles Pending

                                </div>
                            </div>                         
                        </div>-->

                    </div>

                   
                    <!-- /. ROW  -->           
                </div>
                <!-- /. PAGE INNER  -->
            </div>
            <!-- /. PAGE WRAPPER  -->
        </div>
        <!-- /. WRAPPER  -->
        <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
        <!-- JQUERY SCRIPTS -->
        <script src="assets/js/jquery-1.10.2.js"></script>
        <!-- BOOTSTRAP SCRIPTS -->
        <script src="assets/js/bootstrap.min.js"></script>
        <!-- METISMENU SCRIPTS -->
        <script src="assets/js/jquery.metisMenu.js"></script>
        <!-- MORRIS CHART SCRIPTS -->
        <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
        <script src="assets/js/morris/morris.js"></script>
        <!-- CUSTOM SCRIPTS -->
        <script src="assets/js/custom.js"></script>


    </body>
</html>
