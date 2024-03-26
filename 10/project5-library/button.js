const buttons = Object.values(document.getElementsByClassName("buttons"));

buttons.forEach(button =>{
    button.addEventListener("mousedown", (e) => {
        e.target.dataset.pressed = "true";
    });
    button.addEventListener("mouseup", (e) => {
        e.target.dataset.pressed = "false";
    });
    button.addEventListener("mouseleave", (e) => {
        e.target.dataset.pressed = "false";
    });
})