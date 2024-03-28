
let images = ["images/wizard1.jpg", "images/wizard2.jpg", "images/wizard3.jpg", "images/wizard4.jpg"];
let alts = ["pondering the orb", "meeting the guild", "absorbing wisdom", "collecting hymns"];
let image=document.getElementById("carousel-example");
count = 0;

setInterval(switchImg, 5000);


function switchImg(){
    image.innerHTML = `<img id="image" class="image" src=${images[count]} alt="${alts[count]}" max-width="500px" height:auto>`
    count+=1;
    if (count>images.length-1){
        count=0;
    }
}