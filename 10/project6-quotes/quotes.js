const search = document.getElementById("search-bar");

async function getRandomQuote(){
    const result = await fetch("https://usu-quotes-mimic.vercel.app/api/random");
    const quote = await result.json();
    //console.log(quote);
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
    //console.log(startQuote);
})

function clearQuotes(){
    document.getElementById("startup").innerHTML = "";
    document.getElementById("startup").hidden = true;
    document.getElementById("quotes").innerHTML = "";
}

async function getQuotes(author){
    const result = await fetch(`https://usu-quotes-mimic.vercel.app/api/search?query=${author}`);
    const quotes = await result.json()
    console.log(quotes);
    return quotes.results;
}

function displayQuotes(quotes){
    //debugger
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
        let quotes = await getQuotes(author);
        console.log(quotes);
        displayQuotes(quotes);
    }

    });