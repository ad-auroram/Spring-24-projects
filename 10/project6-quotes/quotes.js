const search = document.getElementById("search-bar");

async function getRandomQuote(){
    const result = await fetch("https://usu-quotes-mimic.vercel.app/api/random");
    const quote = await result.json();
    return quote;
}

window.addEventListener("load", async()=>{
    let startQuoteSpot = document.getElementById("startup-quote");
    let startAuthor = document.getElementById("startup-author");
    let startQuote = await getRandomQuote();
    startQuoteSpot.innerText=startQuote.content;
    if (startQuote.author === ""){
        startAuthor.innerText=""
    }else{
        startAuthor.innerText=`-${startQuote.author}`;
    }
})

function clearQuotes(){
    document.getElementById("startup").innerHTML = "";
    document.getElementById("startup").hidden = true;
    document.getElementById("quotes").innerHTML = "";
}

async function getQuotes(author){
    const result = await fetch(`https://usu-quotes-mimic.vercel.app/api/search?query=${author}`);
    const quotes = await result.json()
    return quotes.results;
}

function addListeners(quote){
    quote.addEventListener("click", () =>{
        togglePinned(quote);
    })
    quote.addEventListener("keypress", (e) =>{
        if (e.code === "Space"){
        togglePinned(quote);
        }
    })
}

function togglePinned(quote){
    if (quote.dataset.pinned==="false"){
        document.getElementById("quotes").removeChild(quote);
        document.getElementById("pinned").appendChild(quote);
        quote.dataset.pinned=true;
    }
    else if (quote.dataset.pinned==="true"){
        document.getElementById("pinned").removeChild(quote);
        document.getElementById("quotes").appendChild(quote);
        quote.style.order = 1;
        quote.dataset.pinned=false;
    }
}

function displayQuotes(quotes){
    for (const quote of quotes){
        const container= document.createElement("div");
        container.className = "quote";
        const quoteText=document.createElement("div");
        quoteText.className = "quote-content"
        quoteText.innerText = quote.content;
        container.appendChild(quoteText);
        const author = document.createElement("div");
        author.className="quote-author";
        author.innerText = `-${quote.author}`;
        container.appendChild(author);
        addListeners(container);
        container.dataset.pinned = false;
        container.tabIndex=0;
        console.log(container.dataset);
        document.getElementById("quotes").appendChild(container);
    }
}

function searchMode(){
    const search= document.getElementsByClassName("searching")
    if (search.length ===0){
        document.getElementById("title").className="searching"
        document.getElementById("title").id="";
        document.getElementById("search-bar").className="searching";
    }
}

search.addEventListener("keypress", async(e) => {
    if (e.code === "Enter"){
        searchMode();
        clearQuotes();
        let author = search.value;
        if (author ===""){
            error("Field cannot be blank!");
            return;
        }
        let quotes = await getQuotes(author);
        console.log(quotes);
        displayQuotes(quotes);
    }

    });

function error(message){
    const error = document.getElementById("error-message");
    error.innerHTML = message;
    error.dataset.open = "true";
    setTimeout(() => {
        error.dataset.open = false;
        error.innerHTML = "";
    }, 5000);
}