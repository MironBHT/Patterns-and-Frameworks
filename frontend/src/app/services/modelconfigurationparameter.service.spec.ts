import { TestBed } from '@angular/core/testing';

import { ModelconfigurationparameterService } from './modelconfigurationparameter.service';

describe('ModelconfigurationparameterService', () => {
  let service: ModelconfigurationparameterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModelconfigurationparameterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
