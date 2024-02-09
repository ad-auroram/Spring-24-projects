//can use .defaulValue after getelement

const output = document.getElementById("payment");
//let payment = 232
//output.innerHTML = `$${payment} per month.`;
debugger
document.body.addEventListener("blur", (e)=>{
    const loan = parseFloat(document.getElementById("loan").value);
    const yrInterest = parseFloat(document.getElementById("interest").value);
    const years = parseFloat(document.getElementById("years").value);
    const months = years*12;
    const monthInt = yrInterest/12;

    let payment = loan*((monthInt*Math.pow((1+monthInt), months))/(Math.pow((1+monthInt), months)-1));

    output.innerHTML = `$${payment} per month.`;
});
