<template>
  <div id="app">

    <nav class="navbar navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
      <a class="navbar-brand" href="/" style="font-size:140%" >TreePLE  <img src="./assets/logo.png"></a>

      <div class="navbar" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link offset-sm-9" style="font-size:140%" href="/#/Plant">Plant Tree<span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
            <a class="nav-link offset-sm-5" style="font-size:140%" href="/#/view">View Trees<span class="sr-only">(current)</span></a>
          </li>
         
           <li class="nav-item active">
            <a class="nav-link offset-sm-5" style="font-size:140%" href="/#/forecast">Forecasts <span class="sr-only">(current)</span></a>
          </li>

          <li class="nav-item active">
            <a class="nav-link offset-sm-5" href="/#/app" style="font-size:140%" > List Trees <span class="sr-only">(current)</span></a>
          </li>

          
        </ul>
	
      </div>
    </nav>
    
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'app'
}

</script>

<style>

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  
 
}

img {
  display:inline;
  width:3em;
  margin-right:5em;
}


</style>



