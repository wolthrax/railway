function validate(){
   var x=document.forms['form']['login'].value;
   var y=document.forms['form']['password'].value;
   
   if (x.length==0){
      document.getElementById('login').innerHTML='*Login field is required';
      return false;
   }
   if (y.length==0){
      document.getElementById('password').innerHTML='*Password field is required';
      return false;
   }
}