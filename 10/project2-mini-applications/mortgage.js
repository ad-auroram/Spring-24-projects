
const output = document.getElementById("payment");
const error = document.getElementById("calc-error");

function updateValue(){
    error.innerHTML = "";

    let loan = parseFloat(document.getElementById("loan").value);
    if (Number.isNaN(loan)){
        loan = 32000;
        error.innerHTML = "Please provide a loan amount."
    }
    let yrInterest = parseFloat(document.getElementById("interest").value)/100;
    if (Number.isNaN(yrInterest)){
        yrInterest = .055;
        error.innerHTML = "Please provide the percent interest."
    }
    let years = parseFloat(document.getElementById("years").value);
    if (Number.isNaN(years)) {
        years = 30;
        error.innerHTML = "Please provide a number of years.";
    }
    const months = years*12;
    const monthInt = yrInterest/12;
    
    let payment = loan*((monthInt*Math.pow((1+monthInt), months))/(Math.pow((1+monthInt), months)-1));
    output.innerHTML = `$${payment.toFixed(2)} per month.`;
}

output.innerHTML = "$181.69 per month."
document.getElementById("loan").addEventListener("blur", updateValue);
document.getElementById("interest").addEventListener("blur", updateValue);
document.getElementById("years").addEventListener("blur", updateValue);