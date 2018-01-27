function toggleActionView() {
    var yearSelectView = document.getElementById("chooseYearToggleView");
    var twoDatesSelectView = document.getElementById("chooseTwoDatesToggleView");
    var oneDateSelectView = document.getElementById("chooseOneDateToggleView");
    var globalExtremes = document.getElementById("globalExtremes");
    var actionSelect = document.getElementById("chooseAction").selectedIndex;

    yearSelectView.style.display = "none";
    twoDatesSelectView.style.display = "none";
    oneDateSelectView.style.display = "none";
    globalExtremes.style.display = "none";

    if (actionSelect === 0) {
        globalExtremes.style.display = "block";
    } else if (actionSelect === 1) {
        twoDatesSelectView.style.display = "block";
    } else if (actionSelect === 2) {
        oneDateSelectView.style.display = "block";
    } else if (actionSelect === 3) {
        yearSelectView.style.display = "block";
    }
}

toggleActionView().onload;