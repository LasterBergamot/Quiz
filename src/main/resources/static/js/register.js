$(document).ready(function () {
 
    $("#register-player-form").submit(function (event) {
 
        //stop submit the form event. Do this manually using ajax post function
        event.preventDefault();
 
        var registerPlayerForm = {}
        registerPlayerForm["name"] = $("#name").val();
        registerPlayerForm["age"] = $("#age").val();

        console.log(registerPlayerForm);

        $("#register-button").prop("disabled", true);
        
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/rest/register",
            data: JSON.stringify(registerPlayerForm),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                alert("Player successfully registered!")
                console.log("SUCCESS : ", data);
                $("#register-button").prop("disabled", false);
            },
            error: function (e) {
                alert("ERROR: something went wrong when trying to register the player!")
                console.log("ERROR : ", e);
                $("#register-button").prop("disabled", false);
            }
        });
        
    });
 
});
