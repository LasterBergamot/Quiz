function checkRadios() {
    let radioButtons = document.getElementsByClassName("quiz-radio");
    let numberOfQuestions = document.getElementsByClassName("all-question").length;
    let numberOfCheckedRadios = 0;

    if (radioButtons !== 'undefined') {
        for (let index = 0; index < radioButtons.length; index++) {
            if (radioButtons[index] !== 'undefined') {
                if (radioButtons[index].checked) {
                    numberOfCheckedRadios = numberOfCheckedRadios + 1;
                }
            }
        }
    }

    if (numberOfQuestions === numberOfCheckedRadios) {
        document.getElementById("answers-submit-button").click();
    } else {
        alert("Check every radio button!");
    }
}