/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function ()

{
    
    // Listener de la remise d un livre 
    $(".remettre").click(function () {
        var id_book = $(this).attr("id");
        var id_adherent = $(this).attr("name");
        Bootpop.ask('Voulez vous vraiment remettre le livre = '+id_book+' ?', {
            title: 'Confirmation',
            size: 'small',
            buttons: [
                {btnClass: 'btn btn-success',
                    btnLabel: 'YES',
                    btnValue: 'YES',
                    btnAction: function (answer)
                    {
                        $('.modal').modal('hide');
                        doModifier(id_book, id_adherent);

                    }
              }


            ],
        });

    });


   // Listener pour bloquer et debloquer 
   
   
  $("#bloquer").click(function () {
   $("#debloquer").show();
 
  
  });


  $("#debloquer").click(function () {
   $(this).hide();
   $("#bloquer").show();
  
  });

});


function doModifier(id_book, id_adherent)
{
    $.ajax
            ({
                url: 'EmpruntActualisation.jsp',
                Type: 'post',
                dataType: 'html',
                data: "id_book=" + id_book + "&IdAdherent=" + id_adherent,
                success: function (reponse)
                {
                    $("#actualiser").empty();
                    $("#actualiser").html(reponse);
                    $(".remettre").click(function () {
                        var id_book = $(this).attr("id");
                        var id_adherent = $(this).attr("name");
                        Bootpop.ask('Are you sure?', {
                            title: 'Confirmation',
                            size: 'small',
                            buttons: [
                                {btnClass: 'btn btn-success',
                                    btnLabel: 'YES',
                                    btnValue: 'YES',
                                    btnAction: function (answer)
                                    {
                                        $('.modal').modal('hide');
                                        doModifier(id_book, id_adherent);

                                    }
                                }


                          ],
                        });





                    });
                },
                error: function () {
                    alert("deconnexion");
                }
            });
}

