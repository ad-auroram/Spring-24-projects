
let images = ["images/wizard1.jpg", "images/wizard2.jpg", "images/wizard3.jpg", "images/wizard4.jpg"];
let image=document.getElementById("carousel-example");
count = 0;

setInterval(switchImg, 5000);


function switchImg(){
    image.innerHTML = `<div id="image" class="image" style="background-image: url(${images[count]})"></div>`
    count+=1;
    if (count>images.length){
        count=0;
    }
}