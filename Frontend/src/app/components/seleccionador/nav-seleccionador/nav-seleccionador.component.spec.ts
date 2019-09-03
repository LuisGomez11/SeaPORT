import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavSeleccionadorComponent } from './nav-seleccionador.component';

describe('NavSeleccionadorComponent', () => {
  let component: NavSeleccionadorComponent;
  let fixture: ComponentFixture<NavSeleccionadorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavSeleccionadorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavSeleccionadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
