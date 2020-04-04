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
    alert(selectedPlayerUUID);
}