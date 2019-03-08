<template>
<div>
<card>
<form>


<div class="form-group" id="forecast">
    <h2  style="font-size:200%; font-weight:bold;" >New Forecast</h2>
    <h3 id="plant" style="font-size:140%; text-align:left; font-weight:bold;"> Plant Trees For Forecast:</h3>
       <div class="form-group row">
         <form class="form-inline">
      <label for="landType" class="col-sm-1 col-form-label"> &nbsp;    &nbsp;   &nbsp;   </label>

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

      <label for="diameter" class="col-sm-2 col-form-label"> Diameter </label>
      <input required type="number" min="0" class="form-control mb-2 mr-sm-2 mb-sm-0" id="diameter" placeholder="canopy Diameter">
        </form>
</div>

<div class="form-group row">
  <form class="form-inline">
      <label for="municipality" class="col-sm-1.5 col-form-label">  &nbsp;   &nbsp;  &nbsp;Municipality </label>
      <select class="form-control" id="municipality">
        <option>Montreal</option>
        <option> Laval</option>
      </select>

      <label  for="latitude" class="col-sm-1.5 col-form-label"> &nbsp; &nbsp; Latitude </label>
      <input required type="number" class="form-control" id="latitude" placeholder="latitude">

       <label  for="longitude" class="col-sm-1.5 col-form-label"> &nbsp; &nbsp; Longitude </label>
      <input required type="number" class="form-control" id="longitude" placeholder="longitude">

      <label  for="number" class="col-sm-1.5 col-form-label"> &nbsp;  &nbsp;</label>
      <input required type="number" min="0" class="form-control" id="number" placeholder="number to plant"> 
  </form>
</div>

 <div class="col-xs-7 col-sm-4 row offset-sm-4 text-center">
      <button class="btn btn-secondary btn-block"> Plant for forecast</button><br>
</div>

<br>

 <br><h4 id="cut"  style="font-size:140%;font-weight:bold;  text-align:left;"> Cut Trees In Area For Forecast:</h4>


<div class="form-group row">
 <form class="form-inline">
       <div class="form-group row">
  <label for="exampleSelect1" class="col-sm-1.5 col-2 col-form-label">Municipality</label>
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
     
      <label  for="latitude" class="col-sm-1.5 col-form-label"> &nbsp; &nbsp; Latitude </label>
      <input required type="number" class="form-control" id="latitude" placeholder="latitude">

       <label  for="longitude" class="col-sm-1.5 col-form-label"> &nbsp; &nbsp; Longitude </label>
      <input required type="number" class="form-control" id="longitude"  placeholder="longitude">
	
      <label  for="number" class="col-sm-1.5 col-form-label"> &nbsp;  &nbsp;</label>
      <input required type="number" min="0" class="form-control" id="number" placeholder="number to cut"> 
</form>
</div>
      <div class="col-xs-7 col-sm-4 row offset-sm-4 text-center">
      <button class="btn btn-secondary btn-block"> Cut for forecast</button><br>
</div>


 <br><h4 id="cut"  style="font-size:140%;font-weight:bold;  text-align:left;"> Cut Specific Tree In For Forecast:</h4>


<div class="form-group row">
<form class="form-inline">
       
     
      <label  for="latitude" class="col-sm-1.5 col-form-label"> &nbsp; &nbsp; Latitude </label>
      <input required type="number" class="form-control" id="latitude" placeholder="latitude">

       <label  for="longitude" class="col-sm-1.5 col-form-label"> &nbsp; &nbsp; Longitude </label>
      <input required type="number" class="form-control" id="longitude" placeholder="longitude">
	
</form>
</div>
      <div class="col-xs-7 col-sm-4 row offset-sm-4 text-center">
      <button class="btn btn-secondary btn-block"> Cut for forecast</button><br>
</div> 
<br>
<br>
 <div class="col-xs-7 col-sm-4 row offset-sm-4 text-center">
     <button id="create"  style="font: bold 25px Arial" class="btn btn-secondary btn-block">  Create Forecast</button><br>
</div>

   

</div>

</form>
</card>


<br><br><div>
 <h2  style="font-size:200%; font-weight:bold;" >List Of Forecasts</h2>
<table class="table table-hover" style="width:100%">
<thead>
 <th> Description (hover for detail) </th>
  <th> ID </th>
  <th> Past Reports </th>
  <th>    </th>
</thead>
<tbody>
<tr v-for="forecast in forecasts" >
       <td><b-text v-b-popover.hover="'10 planted in Laval, 3 cut at 1.005, 3.6666 '" title="details">{{ forecast.name }}</b-text></td>
       <td>{{ forecast.id }}</td>
       <td>
        <ul>
          <li v-for="report in participant.report">
            {{report.date}}
          </li>
        </ul>
      </td>
       <td> <button id="create"  style="font: bold 25px Arial">  generate report</button></td>td>
		
                
          
  </tr>
      <tr>
         
          <td><b-text v-b-popover.hover="'10 planted in Laval, 3 cut at 1.005, 3.6666 '" title="details">
    Reem : first forecast
  </b-text></td>
          <td>4</td>
          <td>
        <ul>
          <li><a href="#"><b-text v-b-popover.hover="'BioDiv=0.9, Canopy=1000, CarbonSeq=4000 '" title="Attributes">
            2018-08-04
         </b-text></a></li>
          <li><a href="#">
            2018-01-03
          </a></li>
          <li><a href="#">
            2017-01-10
          </a></li>
        </ul>
      </td>

          <td> <button   style="font: bold 15px Arial">  generate report</button></td>
         
          
      </tr>
</tr>
</tbody>
      </table>
</div>  

</div>
 
</template>


<script>

</script>
<style>
#forecast {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    color: #7323d;
    background: #ffffff;
},
li { padding-left: 10px;
  },
#plant {
padding: 1px;},
#create {
padding: 10px;},
#cut {
padding: 1px;}
</style>
