<template>

<div id="TreePLE">

   <br><br><br><br><br>
    <h2> List of all trees </h2><br><br>

<div class="dropdown">
 <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    List Trees By
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="#">All</a>
    <a class="dropdown-item" href="#">Municipality</a>
    <a class="dropdown-item" href="#">Species</a>
  </div>

</div>
 <br><div class="dropdown">
 <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Municipality
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="#">Anjou</a>
    <a class="dropdown-item" href="#">Ahuntsic-Cartierville
</a>
    <a class="dropdown-item" href="#">Côte-des-Neiges–Notre-Dame-de-Grâce </a>
<a class="dropdown-item" href="#">Lachine </a>
<a class="dropdown-item" href="#">LaSalle </a>
<a class="dropdown-item" href="#">Le Plateau-Mont-Royal</a>
<a class="dropdown-item" href="#">Le Sud-Ouest </a>
<a class="dropdown-item" href="#">L'Île-Bizard–Sainte-Geneviève </a>
<a class="dropdown-item" href="#">Mercier–Hochelaga-Maisonneuve </a>
<a class="dropdown-item" href="#">Montréal-Nord</a>
<a class="dropdown-item" href="#">Outremont</a>
<a class="dropdown-item" href="#">Pierrefonds-Roxboro</a>
<a class="dropdown-item" href="#">Rivière-des-Prairies–Pointe-aux-Trembles</a>
<a class="dropdown-item" href="#">Rosemont–La Petite-Patrie</a>
<a class="dropdown-item" href="#">Sainte-Anne-de-Bellevue</a>
<a class="dropdown-item" href="#">Saint-Laurent</a>
<a class="dropdown-item" href="#">Saint-Léonard</a>
<a class="dropdown-item" href="#">Verdun</a>
<a class="dropdown-item" href="#">Ville-Marie</a>
<a class="dropdown-item" href="#">Villeray–Saint-Michel–Parc-Extension</a>

  </div>

</div>
<br><div class="dropdown">
 <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Species
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="#">Willow</a>
    <a class="dropdown-item" href="#">RedMaple</a>
    <a class="dropdown-item" href="#">LobollyPine</a>
    <a class="dropdown-item" href="#">Sweetgum</a>
 <a class="dropdown-item" href="#">DouglasFir</a>
 <a class="dropdown-item" href="#">QuackingAspen</a>
 <a class="dropdown-item" href="#">SugarMaple</a>
 <a class="dropdown-item" href="#">Balsamfir</a>
 <a class="dropdown-item" href="#">FloweringDogwood</a>
 <a class="dropdown-item" href="#">WhiteOak</a>
  </div>
<br><br><div class="dropdown">
 <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Status
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="#">Planted</a>
    <a class="dropdown-item" href="#">Cut</a>
    <a class="dropdown-item" href="#">To be cut</a>
    <a class="dropdown-item" href="#">diseased</a>
 </div>
  </div>

</div>

    <br><table class="table table-hover" style="width:100%">
<thead>
 <th> Species </th>
  <th> Height </th>
   <th> Diameter </th>
    <th> Longitude </th>
     <th> Latitude </th>
      <th> Landtype </th>
        <th> Municipality </th>
	  <th> Status </th>
</thead>
<tbody>
<tr v-for="tree in Trees" >
      <td>{{ tree.treeSpecies }}</td>
       <td>{{ tree.height }}</td>
       <td>{{ tree.diameter }}</td>
        <td>{{ tree.longitude }}</td>
         <td>{{ tree.latitude }}</td>
           <td>{{ tree.landType }}</td>
            <td>{{tree.municipality.name}}</td>
             <td>{{tree.currentStatus.treeState}}</td>
                
          
  </tr>
      
</tbody>
      </table>
<p> </p>

    <p>
      <span v-if="errorTree" style="color:red">Error: {{errorTree}} </span>

    </p>
  </div>
</template>

<script src="./treePlanning.js"></script>

<style>

dropdown{
    display: inline;
}

 #TreePLE { 
   background-image: url("../assets/Greenery.jpg");
    height: 7em; 
    background-repeat: repeat;
    background-size: 18em;

    
  }
th, td {
    padding: 5px;
}

</style>


