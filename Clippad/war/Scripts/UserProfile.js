      function trim(s) {
        return s.replace(/^s*/,"").replace(/s*$/,"");
      }

      function validate() {

        var user = document.userform.user;
        var pswd = document.userform.pswd;
        var repswd = document.userform.repswd;
        var name = document.userform.name;
        var age = document.userform.age;
        var address = document.userform.address;

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


        if(trim(repswd.value) == ""){
          alert("Re-typed password field is empty..");
          repswd.focus();
          return false;
        }

        if(trim(pswd.value) != trim(repswd.value)){
          alert("Re-typed password doesn't match with the original password entered..");
          user.focus();
          return false;
        }

        if(trim(name.value) == ""){
          alert("Name field is empty..");
          name.focus();
          return false;
        }

      }
