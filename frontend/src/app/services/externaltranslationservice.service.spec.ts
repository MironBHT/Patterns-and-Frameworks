import { TestBed } from '@angular/core/testing';

import { ExternaltranslationserviceService } from './externaltranslationservice.service';

describe('ExternaltranslationserviceService', () => {
  let service: ExternaltranslationserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExternaltranslationserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
