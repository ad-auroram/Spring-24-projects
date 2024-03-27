
let open=false;
const drawer = document.getElementById("drawer");
const mask = document.getElementById("mask")

document.getElementById("menu-button").addEventListener("click", toggle)

mask.addEventListener("click", toggle);

function toggle(){
    open=!open;
    drawer.dataset.open = `${open}`;
    mask.dataset.open = `${open}`;
}