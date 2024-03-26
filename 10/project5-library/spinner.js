window.addEventListener("mousemove", (e)=>{
    let _el = document.getElementById('spin-ex1'); 
	_el.style.top = e.clientY-40 + "px"; 
	_el.style.left = e.clientX-40 + "px";
})