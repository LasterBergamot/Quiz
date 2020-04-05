$(function() {
    $("#playerPagePlayerDropDown").change(function(e) {
        var selectedPlayerUUID = $(this).val();                             
        
        var selectedPlayerJSON = {}
        selectedPlayerJSON["playerUUID"] = selectedPlayerUUID;
        
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/rest/fillPlayerFields",
            data: JSON.stringify(selectedPlayerJSON),
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
 
                document.getElementById("name").value = data.name;
                document.getElementById("age").value = data.age;
 
                console.log("SUCCESS : ", data);
 
            },
            error: function (e) {
                console.log("ERROR : ", e);
            }
        });
    });
});

function modifyPlayer() {
    var playerPagePlayerDropDown = document.getElementById("playerPagePlayerDropDown");
    var selectedPlayerUUID= playerPagePlayerDropDown.options[playerPagePlayerDropDown.selectedIndex].value;
    var selectedPlayerName = document.getElementById("name").value;
    var selectedPlayerAge = document.getElementById("age").value;

    var playerToModifyJSON = {}
    playerToModifyJSON["uuid"] = selectedPlayerUUID;
    playerToModifyJSON["name"] = selectedPlayerName;
    playerToModifyJSON["age"] = selectedPlayerAge;

    $("#modify-player-button").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/rest/modifyPlayer",
        data: JSON.stringify(playerToModifyJSON),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            alert("Player successfully modified!")
            console.log("SUCCESS : ", data);
            $("#modify-player-button").prop("disabled", false);
        },
        error: function (e) {
            alert("ERROR: something went wrong when trying to modify the player!")
            console.log("ERROR : ", e);
            $("#modify-player-button").prop("disabled", false);
        }
    });
}
