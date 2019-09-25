import { Component, OnInit } from '@angular/core';

declare var $ : any;

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    $(window).resize(function(){

      if ($(window).width() <= 550) {  

        $('.informacion').removeClass("pl-5");
        $('.informacion').addClass("pl-2");
        $('.informacion').css("width", "100%");

      }  else{

        $('.informacion').addClass("pl-5");
        $('.informacion').removeClass("pl-2");
        $('.informacion').css("width", "500px");

      }   

});
  }

}
