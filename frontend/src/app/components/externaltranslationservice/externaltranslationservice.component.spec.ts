import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExternaltranslationserviceComponent } from './externaltranslationservice.component';

describe('ExternaltranslationserviceComponent', () => {
  let component: ExternaltranslationserviceComponent;
  let fixture: ComponentFixture<ExternaltranslationserviceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ExternaltranslationserviceComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ExternaltranslationserviceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
