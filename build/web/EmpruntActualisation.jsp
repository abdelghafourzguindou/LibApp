<%-- 
    Document   : EmpruntActualisation
    Created on : 3 févr. 2017, 02:14:05
    Author     : l.IsSaM.l
--%>

<%@page import="Beans.EmpruntP"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    int IdAdherent = Integer.parseInt(request.getParameter("IdAdherent"));
    int idBook = Integer.parseInt(request.getParameter("id_book"));
    
    DAO.EmpruntDAO.Book_Remis(IdAdherent, idBook);
    ArrayList<EmpruntP> li_empr = DAO.EmpruntDAO.get_All_En_Cours(IdAdherent); 
                        if(li_empr.size() == 0 )
                        {
                        %>
                          <h2>Pas d'emprunts actuels pour cet adhérent</h2>
                        <% 
                        } else {   %>

                         <h2>Les emprunts actuels de cet adhérent</h2>
                         <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>id Livre</th>
                                    <th>Titre Livre</th>
                                    <th>Date d'emprunt</th>
                                    <th>Date max de remise</th>
                                    <th>Remettre</th>



                                </tr>
                                </thead>
                                <tbody>
                                    
                                <%    for ( EmpruntP Emp : li_empr ) { %>
                                 <tr>
                                    <td> <%=Emp.getIdBook() %> </td>
                                    <td> <%=Emp.getNomBook() %></td>
                                    <td><%=Emp.getDateSortie() %></td>
                                    <td><%=Emp.getDateMax() %></td>
                                    <td><a href="#" id="<%=Emp.getIdBook() %>" name="<%=IdAdherent%>"class='remettre'>Remettre</a></td>';
                                  <tr>
                                   

                                <% } } %>

                                </tbody>
                            </table>
                        </div>
                      </div>
                    </div>
                                
                        <br/><br/>
                        
                        <% ArrayList<EmpruntP> li_empr_Remis = DAO.EmpruntDAO.get_All_Remis(IdAdherent); 
                        if(li_empr_Remis.size() != 0 )
                        {
                        %>

                         <h2>Les emprunts Remise de cet adhérent</h2>
                         <div class="panel panel-default">
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                <tr>
                                    <th>id Livre</th>
                                    <th>Titre Livre</th>
                                    <th>Date d'emprunt</th>
                                    <th>Date max de remise</th>



                                </tr>
                                </thead>
                                <tbody>
                                    
                                <%    for ( EmpruntP Emp : li_empr_Remis ) { %>
                                 <tr>
                                    <td> <%=Emp.getIdBook() %> </td>
                                    <td> <%=Emp.getNomBook() %></td>
                                    <td><%=Emp.getDateSortie() %></td>
                                    <td><%=Emp.getDateMax() %></td>
                                   
                                  <tr>
                                   

                                <% } } %>

                                </tbody>
                            </table>
                        </div>
                      </div>
                    </div>
