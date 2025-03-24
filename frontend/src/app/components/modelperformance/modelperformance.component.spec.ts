import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModelperformanceComponent } from './modelperformance.component';

describe('ModelperformanceComponent', () => {
  let component: ModelperformanceComponent;
  let fixture: ComponentFixture<ModelperformanceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModelperformanceComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModelperformanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
