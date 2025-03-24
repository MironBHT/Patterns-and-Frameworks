import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TranslationmodelComponent } from './translationmodel.component';

describe('TranslationmodelComponent', () => {
  let component: TranslationmodelComponent;
  let fixture: ComponentFixture<TranslationmodelComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TranslationmodelComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TranslationmodelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
