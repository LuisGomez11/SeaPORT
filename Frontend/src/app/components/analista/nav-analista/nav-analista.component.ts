import { Component, OnInit } from '@angular/core';

declare var $:any;

@Component({
  selector: 'app-nav-analista',
  templateUrl: './nav-analista.component.html',
  styleUrls: ['./nav-analista.component.css']
})
export class NavAnalistaComponent implements OnInit {

  constructor() { }

  ngOnInit(){
    $('.navbar-nav>li>a').on('click', function(){
      $('.navbar-collapse').collapse('hide');
    });
    }

}
