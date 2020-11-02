GET: $(document).ready(
		function() {

			// GET REQUEST
			$("#getAll").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});

			// DO GET
			function ajaxGet() {
				$.ajax({
					type : "GET",
					url : "players",
					success : function(result) {
						if (result.status == "success") {
							$('#getResultDiv ul').empty();
							var custList = "";
							$.each(result.data, function(i, player) {
								var player = "Player Name = "
										+ player.firstName + ", Last Name = "
										+ player.lastName + "<br>";
								$('#getResultDiv .players-list').append(player)
							});
							console.log("Success: ", result);
						} else {
							$("#getResultDiv").html("<strong>Error</strong>");
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						$("#getResultDiv").html("<strong>Error</strong>");
						console.log("ERROR: ", e);
					}
				});
			}
		})
// $(document).ready(function() {
// $.ajax({
// type : "GET",
// url: "players"
// }).then(function(player) {
// $('.player-number').append(player.number);
// $('.player-firstName').append(player.firstName);
// $('.player-lastName').append(player.lastName);
// $('.player-team').append(player.team);
// });
// });
