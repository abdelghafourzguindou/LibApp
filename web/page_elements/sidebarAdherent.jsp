<%-- 
    Document   : sidebarAdherent
    Created on : 3 f�vr. 2017, 18:14:20
    Author     : zGuindouOS
--%>


<!-- Balise de "modifier mon profil-->

<li>
    <a  href="profil.php"><i class="glyphicon glyphicon-cog"></i>Modifier le profil</a>
</li>	

<!-- Balise d'Livre-->

<li>
    <a href="bookList.jsp"><i class="glyphicon glyphicon-book"></i>Espace de livre<span class="fa arrow"></span></a>
</li>

<!-- Balise d'emprunt-->
<li>
    <a href="blank.php"><i class="glyphicon glyphicon-shopping-cart"></i>Espace d'emprunts<span class="fa arrow"></span></a>
</li>  
<!-- Balise de r�servation-->
<li>
    <a href="blank.php"><i class="glyphicon glyphicon-time"></i>Espace de r�servations<span class="fa arrow"></span></a>
    <ul class="nav nav-second-level">
        <li>
            <a href="../controleur/afficherReservation.php"><span class="glyphicon glyphicon-fullscreen sous_menu_icon" aria-hidden="true"></span>Afficher les r�servations</a>
        </li>
    </ul>
</li>  

