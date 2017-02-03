/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




 $(document).ready(function () {
          
   

           $(".modification").click(function() {
               var id_book = $(this).attr("id"); 
             
               
           } );  
           $(".suppression").on('click',function(){
               
               var id_book = $(this).attr("id");
               Bootpop.ask('Are you sure?', {
                 title : 'Confirmation',
                 size :  'small',
                 
                 buttons :  [ 
                     {   btnClass : 'btn btn-success', 
                         btnLabel : 'YES', 
                         btnValue : 'YES',
                         btnAction : function(answer)
                         {  
                             $('.modal').modal('hide');
                             delete_book(id_book);
                             
                         }
                     }  
                    
                 
                            ],  
                 
               });
               
                     
               
           } );  
        });
  
function modification(id_book)
{
    
 $.ajax
   ({
     url: 'books',
     Type: '<<<<<<<<<<<<<<<<<<',
     dataType: 'html',
     data:"id_book="+id_book+"&process=modifier",
     success: function(reponse) 
     {
     } 
    
    
});

}
function delete_book(id_book)
{
 $.ajax
   ({
     url: 'books',
     Type: 'POST',
     dataType: 'html',
     data:"id_book="+id_book+"&process=delete",
     success: function(reponse) 
     {
         $(".table-responsive").empty();
         $(".table-responsive").html(reponse);
         $(".suppression").on('click',function(){  
               
              var id_book = $(this).attr("id");
               Bootpop.ask('Are you sure?', {
                 title : 'Confirmation',
                 size :  'small',
                 
                 buttons :  [ 
                     {   btnClass : 'btn btn-success', 
                         btnLabel : 'YES', 
                         btnValue : 'YES',
                         btnAction : function(answer)
                         {  
                             $('.modal').modal('hide');
                             delete_book(id_book);
                             
                         }
                     }  
                    
                 
                            ],  
                 
               });
               
               
               

           } ); 
         
      
     },
      
     error: function() { alert("deconnexion"); } 
     
     
   });

    
}