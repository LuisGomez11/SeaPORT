import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GeneradosComponent } from './generados.component';

describe('GeneradosComponent', () => {
  let component: GeneradosComponent;
  let fixture: ComponentFixture<GeneradosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GeneradosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GeneradosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
