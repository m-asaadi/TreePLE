import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort
var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

import * as VueGoogleMaps from 'vue2-google-maps'
import Vue from 'vue'

Vue.use(VueGoogleMaps, {
  load: {
    key: 'AIzaSyCDWKnVgX3DIKrH1Rbux7RvLtaV6fO21QE',
    v: '3'
    // libraries: 'places', //// If you need to use place input
  }
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
      treeData: {
        treeSpecies: '',
        height: '',
        diameter: '',
        longitude: '',
        latitude: '',
        landType: '',
        municipality: { municipalityName: '' }},
      positions: [],
      municipalities: [],
      newTree: {
        treeSpecies: '',
        height: '',
        diameter: '',
        longitude: '',
        latitude: '',
        landType: '',
        municipality: { municipalityName: '' }},
      errorMunicipalities: '',
      icon: {
        url: 'google.maps.SymbolPath.CIRCLE',
        size: {width: 26, height: 26, f: 'px', b: 'px'},
        scaledSize: {width: 23, height: 23, f: 'px', b: 'px'}
      },
      center: {lat: 45.549302, lng: -73.681559},
      markers: [],
      errorTree: ''
    }
  },
  // ...

  created: function () {
// Initializing trees from backend
    AXIOS.get(`/trees`)
    .then(response => {
      // JSON responses are automatically parsed.
      this.Trees = response.data
      for (var i = 0; i < this.Trees.length; i++) {
          this.markers.push({
            position: {
              lng: this.Trees[i].longitude,
              lat: this.Trees[i].latitude
            },
            icon: {
              url: 'http://maps.google.com/mapfiles/kml/shapes/parks.png',
              size: {width: 26, height: 26, f: 'px', b: 'px'},
              scaledSize: {width: 23, height: 23, f: 'px', b: 'px'}
            },
          })
      }
    })
    .catch(e => {
      this.errorTree = e
    })
    console.log('Trees listed')

    AXIOS.get('/municipalities')
    .then(response => {
      // JSON responses are automatically parsed.
      this.municipalities = response.data
    })
    .catch(e1 => {
      this.errorMunicipalities = e1
    })
    console.log('Events listed')
  },
  methods: {
  }
}

