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
 
                var json = "<h4>Ajax Response</h4><pre>"
                    + JSON.stringify(data, null, 4) + "</pre>";
                $('#feedback').html(json);
 
                console.log("SUCCESS : ", data);
                $("#register-button").prop("disabled", false);
 
            },
            error: function (e) {
 
                var json = "<h4>Ajax Response Error</h4><pre>"
                    + e.responseText + "</pre>";
                $('#feedback').html(json);
 
                console.log("ERROR : ", e);
                $("#register-button").prop("disabled", false);
 
            }
        });
        
    });
 
});
