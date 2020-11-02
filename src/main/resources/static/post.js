$(document).ready(
		function() {
			
			// SUBMIT FORM
			$("#playerForm").submit(function(event) {
				
				// PREVENT THE FORM FROM SUBMMITING VIA THE BROWSER
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {
				
				// PREPARE FORM DATA
				var formData = {
					number : $("#number").val(),
					firstName : $("#firstName").val(),
					lastName : $("#lastName").val(),
					team : $("#team").val()
				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "player",
					data : JSON.stringify(formData),
					dataType : 'json',
				})

			}

		})