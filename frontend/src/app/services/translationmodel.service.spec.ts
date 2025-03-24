import { TestBed } from '@angular/core/testing';

import { TranslationmodelService } from './translationmodel.service';

describe('TranslationmodelService', () => {
  let service: TranslationmodelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TranslationmodelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
