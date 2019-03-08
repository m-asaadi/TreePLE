<template>
  <div id="home">
  <div class="hello">
      <div class="bg"></div>
	<br> <br> <br><form action="/#/app">
  <div class="form-group row">
  <div class="col-xs-6 offset-sm-5 text-center">
    <label for="email" style="font-size:140%">Email address:</label>
    <input required type="email" class="form-control" id="email" placeholder="Email">
      <div class="valid-feedback">
        Looks good!>
      </div>
<div class="invalid-feedback">
        Please provide a valid email.
      </div>
  </div>
  </div>
  <div class="form-group row">
<div class="col-xs-6 offset-sm-5 text-center">
    <label for="pwd" style="font-size:140%" >Password:</label>
    <input required type="password" class="form-control" id="pwd" placeholder="Password">
<div class="valid-feedback">
        Looks good!>
      </div>
<div class="invalid-feedback">
        Please provide a password.
      </div>
  </div>
</div>
  <div class="checkbox row">
<div class="col-xs-6 offset-sm-5 text-center">
    <label style="font-size:120%" ><input type="checkbox" > Remember me</label>
  </div>
</div>
<div class="row">
<div class="container">
<div class="col-xs-4 col-sm-3 offset-sm-4">

  <button type="submit" style="font-size:120%" class="btn btn-secondary btn-block">Submit</button>

</div>
</div>
</div>
</form>

</div>
</div>
</template>

<script>
export default {
  name: 'hello',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->

<style scoped>

#home {
background-image: url("../assets/forest.jpg");
    height: 70em; 
    background-repeat: no-repeat;
    background-size: cover;

}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}


.btn-xl {
    padding: 40px 40px;
    font-size: 20px;
    border-radius: 20px;
}



</style>
