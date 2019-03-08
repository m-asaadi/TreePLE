import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort
var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

function TreeDto (landType, treeSpecies, height, diameter, longitude, latitude, treeID, municipality) {
  this.treeSpecies = treeSpecies
  this.height = height
  this.diameter = diameter
  this.longitude = longitude
  this.latitude = latitude
  this.landType = landType
  this.treeID = treeID
  this.municipality = municipality
}

export default {
  name: 'TreePLE',
  data () {
    return {
      Trees: [],
      response: [],
      newTree: {
        userName: '',
        treeSpecies: '',
        height: '',
        diameter: '',
        longitude: '',
        latitude: '',
        landType: ''},
      errorTree: ''
    }
  },
  // ...

  created: function (landType, treeSpecies, height, diameter, longitude, latitude, municipalityName, userName) {
// Initializing trees from backend
    AXIOS.post(`/PlantTree/`.concat(userName), {}, {
      params: {
        userName: userName,
        treeSpecies: treeSpecies,
        height: height,
        diameter: diameter,
        longitude: longitude,
        latitude: latitude,
        landType: landType,
        newTree.municipalities: municipalityName }}
       ).then(response => {
      // JSON responses are automatically parsed.
         this.Trees.push(response.data)
         this.newTree = ''
         this.newTree.userName = ''
         this.newTree.treeSpecies = ''
         this.newTree.height = ''
         this.newTree.diameter = ''
         this.newTree.longitude = ''
         this.newTree.latitude = ''
         this.newTree.landType = ''
         this.errorTree = ''
       })
    .catch(e => {
      var errorMsg = e.response.data.message
    console.log(errorMsg)
    this.errorTree = errorMsg
  })  
   },
   methods: {
   }
}

