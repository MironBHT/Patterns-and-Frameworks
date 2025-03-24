import { TestBed } from '@angular/core/testing';

import { ModelperformanceService } from './modelperformance.service';

describe('ModelperformanceService', () => {
  let service: ModelperformanceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModelperformanceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
