document.getElementById("navbar-html").innerText=`
<header id="nav-example">
<section class="container">
    <button id="nav-menu" class="material-symbols-outlined">menu</button>
    <h1 id="nav-title">Title</h1>
</section>
<section class="container">
    <a href="link here!" class="nav-link">Link</a>
    <a href="link here!" class="nav-link">Link</a>
    <a href="link here!" class="nav-link">Link</a>
    <a href="link here!" class="nav-link">Link</a>
</section>
</header>

`

document.getElementById("navbar-css").innerText=`
#nav-example{
    display:flex;
    flex-direction: row;
    top:0px;
    right:0px;
    left:0px;
    position:fixed;
    background-color: rgb(202, 172, 242);
    justify-content: space-between;
}

#nav-title{
    color: rgb(25, 23, 37);
    font-size: 40px;
}

#nav-menu{
    align-items: center;
    color: rgb(25, 23, 37);
    background-color: transparent;
    margin: 15px;
    border: none;
}

.nav-link{
    color: rgb(25, 23, 37);
    font-size: 20px;
    text-align: center;
    padding: 35px;
    text-decoration: none;
    border-radius: 15%;
    transition: background-color .3s ease;
}

.nav-link:hover{
    background-color: rgb(241, 195, 242);
}

.container{
    display: flex;
    align-items: center;
}

`
    
