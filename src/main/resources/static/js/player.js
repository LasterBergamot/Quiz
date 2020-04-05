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
                console.log("SUCCESS : ", data);

                document.getElementById("name").value = data.playerName;
                document.getElementById("age").value = data.playerAge;
                
                var answerResultModelList = data.answerResultModelList;

                if (answerResultModelList.length > 0) {
                    var questionsAnswered = "<h3>Questions answered: " + answerResultModelList.length + "</h3>";
                    $("#questions-answered").html(questionsAnswered);

                    var table = "<table><tr><th>Category</th><th>Type</th><th>Difficulty</th><th>Question</th><th>Correct answer</th><th>Your answer</th><th>Answered correctly</th><th>Point</th></tr>";

                    for (var index = 0; index < answerResultModelList.length; index++) {
                        var category = answerResultModelList[index].categoryName;
                        var type = answerResultModelList[index].type;
                        var difficulty = answerResultModelList[index].difficulty;
                        var question = answerResultModelList[index].question;
                        var correctAnswer = answerResultModelList[index].correctAnswer;
                        var selectedAnswer = answerResultModelList[index].selectedAnswer;
                        var answeredCorrectly = answerResultModelList[index].answeredCorrectly;
                        var point = answerResultModelList[index].point;
    
                        var row = "<tr><td>" + category + "</td><td>" + type + "</td><td>" + difficulty + "</td><td>" + question + "</td><td>" + correctAnswer + "</td><td>" + selectedAnswer
                                    + "</td><td>" + answeredCorrectly + "</td><td>" + point + "</td></tr>";
                        table = table + row;
                    }

                    table = table + "</table>";
                    $("#answer-table").html(table);

                    var gainedPointsHTML = "<h3>Gained points: " + data.gainedPoints + "</h3>";
                    $("#gained-points").html(gainedPointsHTML);
                }  
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
