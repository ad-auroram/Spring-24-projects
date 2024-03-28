document.getElementById("font-link").innerText=`
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
`

document.getElementById("navbar-html").innerText=`
<header id="nav-example">
<section class="container">
    <button id="nav-menu" class="material-symbols-outlined">menu</button>
    <h1 id="nav-title">Title</h1>
</section>
<section class="container">
    <a href="link here!" class="nav-link">Link</a>
    <a href="link here!" class="nav-link">Link</a>
    <a href="link here!" class="nav-link">Link</a>
    <a href="link here!" class="nav-link">Link</a>
</section>
</header>

`

document.getElementById("navbar-css").innerText=`
#nav-example{
    display:flex;
    flex-direction: row;
    top:0px;
    right:0px;
    left:0px;
    position:fixed;
    background-color: rgb(202, 172, 242);
    justify-content: space-between;
}

#nav-title{
    color: rgb(25, 23, 37);
    font-size: 40px;
}

#nav-menu{
    align-items: center;
    color: rgb(25, 23, 37);
    background-color: rgba(0,0,0,0);
    margin: 15px;
    border: none;
    border-radius: 15%;
    transition: all .3s ease;
    padding: 10px;
}

#nav-menu:hover{
    background-color: rgba(241, 195, 242, 1);
    box-shadow: 2px 3px rgba(0,0,0,.25)
}

.nav-link{
    color: rgb(25, 23, 37);
    font-size: 20px;
    text-align: center;
    padding: 35px;
    text-decoration: none;
    border-radius: 15%;
    transition: all .3s ease;
}

.nav-link:hover{
    background-color: rgb(241, 195, 242);
    box-shadow: 2px 3px rgba(0,0,0,.25)
}

.container{
    display: flex;
    align-items: center;
}

`

document.getElementById("navdrawer-html").innerText=`
<button id="menu-button">
    <span class="material-symbols-outlined">menu</span>
</button>

<nav id="drawer">
<a href="#nav-bar" class="nav-item"><span class="material-symbols-outlined">search</span>Navigation Bar</a>
<a href="#nav-drawer"class="nav-item"><span class="material-symbols-outlined">menu_open</span>Navigation Drawer</a>
<a href="#button"class="nav-item"><span class="material-symbols-outlined">arrow_selector_tool</span>Buttons</a>
<a href="#spinners"class="nav-item"><span class="material-symbols-outlined">progress_activity</span>Spinners</a>
<a href="#img-carousel"class="nav-item"><span class="material-symbols-outlined">theaters</span>Image Carousel</a>
</nav>
<div id="mask"></div>
`

document.getElementById("navdrawer-css").innerText=`
a{
    all:unset;
}

#menu-button{
    border: 2px solid rgb(20,20,20);
    border-radius: 10px;;
    padding: 15px;
    height: 60px;
    background-color: rgb(89, 81, 140);
    color: rgb(241, 195, 242);
    font-size: 18px;
    margin: 20px;
    transition: all .3s ease;
}

#menu-button:hover{
    background-color:rgb(241, 195, 242);
    color: rgb(89, 81, 140);
    box-shadow: 2px 5px rgba(0,0,0,.25);
}

#drawer{
    display:flex;
    flex-direction:column;
    color: rgb(25, 23, 37);
    background-color: rgb(202, 172, 242);
    position:fixed;
    overflow:auto;
    width:300px;
    justify-content:left;
    align-items:flex-start;
    top:80px;
    bottom:0px;
    left:-310px;
    transition: all .3s ease;
}

#drawer[data-open="true"]{
    left:0px;
}

.nav-item{
    display:flex;
    text-align: left;
    align-content: center;
    font-size: 18px;
    text-decoration: none;
    border-bottom: 2px solid rgb(25, 23, 37); 
    width:300px;
    padding:10px;
    transition: all .2s ease;
}

.nav-item:hover{
    background-color: rgb(25, 23, 37);
    color: rgb(202, 172, 242);
}

#mask{
    position:fixed;
    top:77;
    left:300;
    background-color: rgba(0,0,0,0);
    transition: background-color .2s ease;
}

#mask[data-open="true"] {
    background-color: rgba(0,0,0,.5);
    bottom: 0;
    right: 0;
}
`

document.getElementById("navdrawer-js").innerText=`
let open=false;
const drawer = document.getElementById("drawer");
const mask = document.getElementById("mask")

document.getElementById("menu-button").addEventListener("click", toggle)

mask.addEventListener("click", toggle);

//remove space between "$" and brackets
function toggle(){
    open=!open;
    drawer.dataset.open = $ {open};
    mask.dataset.open = $ {open};
}
`

document.getElementById("buttons-html").innerText=`
<button id="button1" class="buttons">Button 1</button>

<button id="button2" class="buttons">
    <span class="material-symbols-outlined"><span class="material-symbols-outlined" style="margin
    -right:5px;">thumb_up</span></span>
    <span>Button 2</span>
</button>

<button id="button3" class="buttons">
    <span class="material-symbols-outlined">search</span>
</button>

`

document.getElementById("buttons-css").innerText=`
.buttons{
    background-color: rgb(89, 81, 140);
    color: rgb(241, 195, 242);
    font-size: 18px;
    margin: 20px;
    transition: all .3s ease;
}

.buttons:hover{
    background-color:rgb(241, 195, 242);
    color: rgb(89, 81, 140);
    box-shadow: 2px 5px rgba(0,0,0,.25);
}

.buttons[data-pressed="true"] {
    box-shadow: none;
}

#button1{
    border: 2px solid rgb(20,20,20);
    border-radius: 10px;;
    padding: 15px;
    height: 60px;
}

#button2{
    display:flex;
    align-items: center;
    border: 2px solid rgb(20,20,20);
    border-radius: 10px;
    padding: 15px;
    height: 60px;
    justify-content: center;
}

#button3{
    border: 2px solid rgb(20,20,20);
    border-radius: 50%;
    padding: 20px;
    position: fixed;
    bottom: 50px;
    right: 50px;
}

`
document.getElementById("buttons-js").innerText=`
const button = document.getElementsById("button");
button.addEventListener("mousedown", (e) => {
    e.target.dataset.pressed = "true";
});
button.addEventListener("mouseup", (e) => {
    e.target.dataset.pressed = "false";
});
button.addEventListener("mouseleave", (e) => {
    e.target.dataset.pressed = "false";
});

`


document.getElementById("spinners-html").innerText=`
<div id="spin-ex1"></div>

<div id="spin-ex2">
    Loading...
</div>

<div id="spin-ex3">
    <div id="progress"></div>
</div>

`

document.getElementById("spinners-css").innerText=`
---Spinner 1---
#spin-ex1{
    padding:20px;
    margin: 20px;
    border: 5px solid rgb(0,0,0,.25);
    border-top: 5px solid rgb(241, 195, 242);
    border-radius: 50%;
    position: absolute;
    animation: mouse-spin;
    animation-duration: 2s;
    animation-iteration-count: infinite;
    animation-timing-function: linear;
}

@keyframes mouse-spin {
    0%{
        rotate: 0deg;
    }
    50%{
        rotate:180deg;
    }
    75%{
        rotate:270deg;
    }
    100%{
        rotate:360deg;
    }
}

---Spinner 2---
#spin-ex2{
    color: white;
    text-shadow: 2px 2px black;
    margin: 20px;
    animation: loading-text;
    animation-duration: 5s;
    animation-iteration-count: infinite;
    animation-timing-function: ease;
}

@keyframes loading-text{
    0%{
        color: white;
        text-shadow: 2px 2px black;
    }
    50%{
        color: rgba(0,0,0,0);
        text-shadow: rgba(0,0,0,0);
    }
}

---Spinner 3---
#spin-ex3{
    border: 3px solid rgb(25, 23, 37);
    height: 10px;
    width: 100px;
    margin: 15px;
    padding: 5px;
    border-radius: 15px;
}

#spin-ex3 #progress{
    position: absolute;
    background-color: rgb(241, 195, 242);
    width: 0px;
    height: 10px;
    border-radius: 15px;
    animation: progress-bar;
    animation-duration: 5s;
    animation-iteration-count: infinite;
    animation-timing-function: linear;
}

@keyframes progress-bar{
    0%{
        width:0px;
    }
    25%{
        width: 50px;
    }
    50%{
        width:75px;
    }
    75%{
        width:80px;
    }
    100%{
        width: 100px;
    }
}

`

document.getElementById("spinners-js").innerText=`
window.addEventListener("mousemove", (e)=>{
    let _el = document.getElementById('spin-ex1'); 
	_el.style.top = e.clientY-40 + "px"; 
	_el.style.left = e.clientX-40 + "px";
})

`


document.getElementById("carousel-html").innerText=`
<div id="carousel">
    <img id="image" class="image" src="images/wizard4.jpg" alt="collecting hymns" max-width="500px" height:auto>
</div>
`

document.getElementById("carousel-css").innerText= `
#carousel{
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    width: 50%;
    height: 15px;
    margin: auto;
    padding: 200px;
}

.image{
    background-position:center;
    width: 400px;
    height:auto;
    position: absolute;
    animation: fade;
    animation-duration: 5s;
    animation-timing-function: ease;
    animation-iteration-count: infinite;
}

@keyframes fade{
    0%{
        opacity: 0;
        left: 65%
    }
    15%{
        opacity: 100%;
        left: 40%;
    }
    85%{
        opacity: 100%;
        left:40%;
    }
    100%{
        opacity: 0;
        left:15%
    }

}
`

document.getElementById("carousel-js").innerText=`
let images = ["images/wizard1.jpg", "images/wizard2.jpg", "images/wizard3.jpg", "images/wizard4.jpg"];
let alts = ["pondering the orb", "meeting the guild", "absorbing wisdom", "collecting hymns"];
let image=document.getElementById("carousel");
count = 0;

setInterval(switchImg, 5000);


function switchImg(){
    //add backticks around the html and remove the space between the "$" and brackets
    image.innerHTML = <img id="image" class="image" src=$ {images[count]} alt="$ {alts[count]}" max-width="500px" height:auto>
    count+=1;
    if (count>images.length-1){
        count=0;
    }
}
`