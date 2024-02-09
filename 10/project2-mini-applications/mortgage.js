
const output = document.getElementById("payment");


function updateValue(){
    const loan = parseFloat(document.getElementById("loan").value);
    const yrInterest = parseFloat(document.getElementById("interest").value)/100;
    const years = parseFloat(document.getElementById("years").value);
    const months = years*12;
    const monthInt = yrInterest/12;

    let payment = loan*((monthInt*Math.pow((1+monthInt), months))/(Math.pow((1+monthInt), months)-1));
    output.innerHTML = `$${payment.toFixed(2)} per month.`;
}

document.getElementById("loan").addEventListener("blur", updateValue);
document.getElementById("interest").addEventListener("blur", updateValue);
document.getElementById("years").addEventListener("blur", updateValue);