/*
Be wary of these ${adjective} quests posted on the board of the local tavern:
- Looking for ${noun}-caster. Must be able to turn water into ${liquid}.
- Adventurers, bring me ${number} kobold ${pNoun}. Will pay in ${food}.
- When I was ${verb-ing} my clothes, I lost my magic ring at the bottom of the town ${noun2}. Please someone ${verb} it back for me?
*/

const genButton = document.getElementById("generate");

genButton.addEventListener("click", () =>{
    const output = document.getElementById("quests");
    const error = document.getElementById("quest-error");
    error.innerHTML = "";
    
    let adjective = document.getElementById("adjective").value;
    if (adjective === ""){
    error.innerHTML = "Missing an adjective!";
    }
    let noun = document.getElementById("noun").value;
    if (noun === "") error.innerHTML = "Missing a noun!";

    let liquid = document.getElementById("liquid").value;
    if (liquid === "") error.innerHTML = "Missing an liquid!";

    let number = document.getElementById("number").value;
    if (number === "") error.innerHTML = "Missing a number!";

    let pluralNoun = document.getElementById("pNoun").value;
    if (pluralNoun === "") error.innerHTML = "Missing a plural noun!";

    let food = document.getElementById("food").value;
    if (food === "") error.innerHTML = "Missing a food!";

    let verbIng = document.getElementById("verb-ing").value;
    if (verbIng === "") error.innerHTML = "Missing a verb ending in \"ing\"!";

    let noun2 = document.getElementById("noun2").value;
    if (noun2 === "") error.innerHTML = "Missing a noun!";

    let verb = document.getElementById("verb").value;
    if (verb === "") error.innerHTML = "Missing a verb!";

    

    let text = (
    `Be wary of these ${adjective} quests posted on the board of the local tavern: <br>` +
    `\n- Looking for ${noun}-caster. Must be able to turn water into ${liquid}. <br>` +
    `\n- Adventurers, bring me ${number} kobold ${pluralNoun}. Will pay in ${food}. <br>`+
    `\n- When I was ${verbIng} my clothes, I lost my magic ring at the bottom of the town ${noun2}. Please someone ${verb} it back for me? <br>`)
    
    if (error.innerHTML === ""){
        output.innerHTML =text;
    }else{
        output.innerHTML = "";
    }
;});

