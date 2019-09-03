import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavAnalistaComponent } from './nav-analista.component';

describe('NavAnalistaComponent', () => {
  let component: NavAnalistaComponent;
  let fixture: ComponentFixture<NavAnalistaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavAnalistaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavAnalistaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
