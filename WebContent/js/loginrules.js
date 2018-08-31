$(function() 
		
		{  
	
		$.validator.addMethod("loginRegex", 
				function(value, element) {
			return this.optional(element) || /^[a-z0-9\-]+$/i.test(value);}
			, "Username must contain only letters, numbers, or dashes.");
		
		
		$("form[name='login']").validate({
		    rules: {      
		    	username: {    
		        required: true,
		        loginRegex: true,
		        minlength: 5,
		        maxlength: 20
		        
		      },	
		      password: {
		        required: true,
		        minlength: 8,
		        maxlength: 24 
		      }
		    },
	    
		    messages: {      
		    	
		      username: {
		    	  	required: "Please provide a username",
		    	  	minlength: "Your username should be at least 5 characters long",
		    	  	maxlength: "Your username cannot be more than 20 characters long"
		    	  		
		      },
		      
		      password: {
			        required: "Please provide a password",
			        minlength: "Your password should be at least 8 characters long",
			        maxlength: "Your password cannot be more than 24 characters long"
			      }},
		      
	    submitHandler: function(form) {
	      form.submit();
	    }
  });
});