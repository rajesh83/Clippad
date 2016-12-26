      function trim(s) {
        return s.replace(/^s*/,"").replace(/s*$/,"");
      }

      function validate() {

        var user = document.loginform.user;
        var pswd = document.loginform.pswd;

        if(trim(user.value) == ""){
          alert("User id field is empty..");
          user.focus();
          return false;
        }

        if(trim(pswd.value) == ""){
          alert("Password field is empty..");
          pswd.focus();
          return false;
        }
      }  
        