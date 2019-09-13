import { TestBed } from '@angular/core/testing';

import { GeneradoService } from './generado.service';

describe('GeneradoService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GeneradoService = TestBed.get(GeneradoService);
    expect(service).toBeTruthy();
  });
});
