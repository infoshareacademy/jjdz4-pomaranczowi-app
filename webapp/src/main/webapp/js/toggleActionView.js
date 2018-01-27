function toggleActionView() {
    var yearSelectView = document.getElementById("chooseYearToggleView");
    var twoDatesSelectView = document.getElementById("chooseTwoDatesToggleView");
    var oneDateSelectView = document.getElementById("chooseOneDateToggleView");
    var actionSelect = document.getElementById("chooseAction").selectedIndex;
    if (actionSelect === 1) {
        yearSelectView.style.display = "none";
        twoDatesSelectView.style.display = "block";
        oneDateSelectView.style.display = "none";
    } else if (actionSelect === 2) {
        yearSelectView.style.display = "none";
        twoDatesSelectView.style.display = "none";
        oneDateSelectView.style.display = "block";
    } else if (actionSelect === 3) {
        yearSelectView.style.display = "block";
        twoDatesSelectView.style.display = "none";
        oneDateSelectView.style.display = "none";
    } else {
        yearSelectView.style.display = "none";
        twoDatesSelectView.style.display = "none";
        oneDateSelectView.style.display = "none";
    }
}

toggleActionView().onload;