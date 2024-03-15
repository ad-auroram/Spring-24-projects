
/* To-do:
- Title of recipe: should accept with button or enter
- Ingredients: should accept with click or enter, display in list div
- Instructions, same as above
- store ingradients and instructions in arrays
-set things to clear with reset button, call weite recipe to file with save
*/

//buttons and input
const title = document.getElementById("title");
const ingredients = document.getElementById("ingr-inpt");
const addIngr = document.getElementById("ingr-button");
const instructions = document.getElementById("inst-inpt");
const addInst = document.getElementById("inst-button");
let items = [];
let steps = [];


const reset = document.getElementById("reset");
const save = document.getElementById("save");


addIngr.addEventListener("click", createIngrItem);
ingredients.addEventListener("keypress", (e) => {
    if (e.code === "Enter") {
        createIngrItem();
    }
});
//creates a list of ingredients
function createIngrItem(){
    const ingredient = ingredients.value;
    createItem(ingredient, "ingredients");
    items.push(ingredient);
    ingredients.value="";
}


//creates list of instuctions
addInst.addEventListener("click", createInstItem)
instructions.addEventListener("keypress", (e) => {
    if (e.code === "Enter") {
        createInstItem();
    }
});

function createInstItem(){
    const instruction = instructions.value;
    createItem(instruction, "instructions")
    steps.push(instruction);
    instructions.value="";
}

function createItem(item, section){
    if (item === ""){
        error("Field cannot be blank!")
        return;
    }
    const element = document.createElement("span");
    element.className = "item";
    element.role = "button";
    element.tabIndex= "0";
    element.innerText= item;
    element.addEventListener("click", () => {
        element.remove();
        if (items.includes(element.innerText)){
            items.pop(element.innerText);
        }
        if (steps.includes(element.innerText)){
            steps.pop(element.innerText);
        }
    });
    document.getElementById(section).appendChild(element);

}

function error(message){
    const error = document.getElementById("error-message");
    error.innerHTML = message;
    error.dataset.open = "true";
    setTimeout(() => {
        error.dataset.open = false;
        error.innerHTML = "";
    }, 5000);
}


//reset
reset.addEventListener("click", () =>{
    document.getElementById("ingredients").innerHTML = "";
    document.getElementById("instructions").innerHTML = "";
    ingredients.value="";
    instructions.value="";
    title.value="";
    items = [];
    steps = [];
})

save.addEventListener("click", () => {
    const recipe = {
        title: `${title.value}`,
        ingredients: items,
        instructions: steps
    }
    writeRecipeToFile(recipe);
})