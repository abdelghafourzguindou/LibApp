/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $(".AccepterAdh").click(function () {

        var id_adherent = $(this).attr("id");

        Bootpop.ask('Voulez vous vraiment l accepter?', {
            title: 'Confirmation',
            size: 'small',

            buttons: [
                {btnClass: 'btn btn-success',
                    btnLabel: 'YES',
                    btnValue: 'YES',
                    btnAction: function (answer)
                    {
                        $('.modal').modal('hide');
                        accepter_adh(id_adherent);

                    }
                }


            ],

        });

    });


});


function accepter_adh(id_adherent)
{

    $.ajax
            ({
                url : 'AdherentProcess',
                Type: 'POST',
                dataType: 'html',
                data: "process=accepte&id_adherent=" + id_adherent,
                success: function (reponse) {
                    //alert(reponse);

                    $(".table-responsive").empty();
                    $(".table-responsive").append("<table class=\"table table-striped table-bordered table-hover\" id=\"dataTables-example\"><thead><tr><th class=\"center\"></th><th class=\"center\">Code Adherent</th><th class=\"center\">CIN</th><th class=\"center\">Nom</th><th class=\"center\">Prenom</th><th class=\"center\">Profession</th><th colspan=\"2\"><center>Gestion</center></th></tr></thead><div id=\"corpTab\"><tbody>");
                    $.each($.parseJSON(reponse), function (i, repons) {

                        $(".table-responsive").append("<tr><td><i class=\"glyphicon glyphicon-book icon_in_button\"></i></td><td>" + repons.IdAdherent + "</td><td>" + repons.CodeAdherent + "</td><td>" + repons.CIN + "</td><td>" + repons.NomAdherent + "</td><td>" + repons.PrenomAdherent + "</td><td><center><input type=\"button\" class=\"AccepterAdh  btn btn-success\" id=\"" + repons.IdAdherent + "\" value=\"Accepter\"></center></td><td><center><input type=\"button\" class=\"ModifierAdh  btn btn-success\" id=\"" + repons.IdAdherent + "\" value=\"Refuser\"></center></td></tr>");

                        /*alert(repons.CodeAdherent);
                         alert(repons.CIN);
                         alert(repons.NomAdherent);
                         alert(repons.PrenomAdherent);
                         alert(repons.ProfessionAdherent);
                         alert(repons.etatAdherent);
                         alert("-------------");*/

                    });
                    $(".table-responsive").append("</tbody></div></table>");

                    $(".AccepterAdh").click(function () {

                        var id_adherent = $(this).attr("id");

                        Bootpop.ask('Voulez vous vraiment l accepter?', {
                            title: 'Confirmation',
                            size: 'small',

                            buttons: [
                                {btnClass: 'btn btn-success',
                                    btnLabel: 'YES',
                                    btnValue: 'YES',
                                    btnAction: function (answer)
                                    {
                                        $('.modal').modal('hide');
                                        accepter_adh(id_adherent);

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


