<template>
<div id="planting"><br><br><br><br>
<br><h2> Plant Tree </h2><br>
<div class="container"><br>
<form action="/#/view">
  <div class="form-group row">
  <label for="example-text-input" class="col-2 col-form-label">Height</label>
  <div class="col-3">
    <input required type="number" min="0" class="form-control" id="example-height-input" placeholder="Height" required>
<div class="invalid-feedback">
        Please provide a valid height.
      </div>
 </div>
</div>
<div class="form-group row">
   <label for="example-text-input" class="col-2 col-form-label">Diameter</label>
  <div class="col-3">
    <input required type="number" min="0" class="form-control" placeholder="Diameter"  id="example-text-input">
  </div>
<div class="invalid-feedback">
        Please provide a valid Diameter.
      </div>
</div>
<div class="form-group row">
   <label for="example-text-input" class="col-2 col-form-label">Longitude</label>
  <div class="col-3">
    <input required type="number" class="form-control"   id="example-text-input" placeholder="longitude">
  </div>
<div class="invalid-feedback">
        Please provide a valid Longitude.
      </div>
</div>
<div class="form-group row">
  <label for="example-text-input" class="col-2 col-form-label">Latitude</label>
  <div class="col-3">
    <input type="number" required class="form-control"  id="example-text-input" placeholder="latitude">
  </div>
<div class="invalid-feedback">
        Please provide a valid Latitude.
      </div>
</div>
<div class="form-group row">
  <label for="exampleSelect1" class="col-2 col-form-label">Species</label>
<div class="col-3">
    <select class="form-control" id="exampleSelect1">
      <option>Willow</option>
      <option>RedMaple</option>
      <option>LobollyPine</option>
      <option>Sweetgum</option>
      <option>DouglasFir</option>
       <option>QuackingAspen</option>
 <option>SugarMaple</option>
 <option>Balsamfir</option>
 <option>FloweringDogwood</option>
<option>WhiteOak</option>
    </select>
</div>
</div>
<div class="form-group row">
  <label for="exampleSelect1" class="col-2 col-form-label">Municipality</label>
<div class="col-3">
    <select class="form-control" id="exampleSelect1">
      <option>Anjou</option>
      <option>Ahuntsic-Cartierville</option>
      <option>Côte-des-Neiges–Notre-Dame-de-Grâce</option>
      <option>Lachine</option>
      <option>LaSalle</option>
<option>Le Plateau-Mont-Royal</option>
<option>Le Sud-Ouest</option>
<option>L'Île-Bizard–Sainte-Geneviève</option>
<option>Mercier–Hochelaga-Maisonneuve </option>
<option>Montréal-Nord</option>
<option>Outremont</option>
<option>Pierrefonds-Roxboro</option>
<option>Rivière-des-Prairies–Pointe-aux-Trembles</option>
<option>Rosemont–La Petite-Patrie</option>
<option>Sainte-Anne-de-Bellevue</option>
    </select>
</div>
</div>
<div class="form-group row">
  <label for="exampleSelect1" class="col-2 col-form-label">LandType</label>
<div class="col-3">
    <select class="form-control" id="exampleSelect1">
      <option>Institutional</option>
      <option>Municipal</option>
      <option>Residential</option>
      <option>Park</option>
    </select>
</div>
</div>
<div class="row">
<div class="container">
<div class="col-xs-6 col-sm-3 offset-sm-2">

  <button type="submit" style="font-size:120%" class="btn btn-secondary btn-block">Plant</button>

</div>
</div>
</div>
</form>
</div>
</div>
</template>
<style>

 #planting { 
   background-image: url("../assets/Greenery.jpg");
    height: 7em; 
    background-repeat: repeat;
    background-size: 18em;
}
</style>

