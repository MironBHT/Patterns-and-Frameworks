import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModelconfigurationparameterComponent } from './modelconfigurationparameter.component';

describe('ModelconfigurationparameterComponent', () => {
  let component: ModelconfigurationparameterComponent;
  let fixture: ComponentFixture<ModelconfigurationparameterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModelconfigurationparameterComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModelconfigurationparameterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
