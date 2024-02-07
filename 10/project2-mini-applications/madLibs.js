/*
Be wary of these ${adjective} quests posted on the board of the local tavern:
- Looking for ${noun}-caster. Must be able to turn water into ${liquid}.
- Adventurers, bring me ${number} kobold ${pNoun}. Will pay in ${food}.
- When I was ${verb-ing} my clothes, I lost my magic ring at the bottom of the town ${noun2}. Please someone ${verb} it back for me?
*/

const adjective = document.getElementById("adjective").value
const noun = document.getElementById("noun").value;
const liquid = document.getElementById("liquid").value;
const number = document.getElementById("number").value;
const pluralNoun = document.getElementById("pNoun").value;
const food = document.getElementById("food").value;
const verbIng = document.getElementById("verb-ing").value;
const noun2 = document.getElementById("noun2").value;
const verb = document.getElementById("verb").value;

const genButton = document.getElementById("generate");
const output = document.getElementById("quests");

genButton.addEventListener("click", () =>{
    const text = (
    `Be wary of these ${adjective} quests posted on the board of the local tavern:` +
    `- Looking for ${noun}-caster. Must be able to turn water into ${liquid}.` +
    `- Adventurers, bring me ${number} kobold ${pNoun}. Will pay in ${food}.`+
    `- When I was ${verb-ing} my clothes, I lost my magic ring at the bottom of the town ${noun2}. Please someone ${verb} it back for me?`)

    output.innerHTML = `<div>${text}</div>`;
;});

