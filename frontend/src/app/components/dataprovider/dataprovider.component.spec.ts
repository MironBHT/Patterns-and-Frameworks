import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DataproviderComponent } from './dataprovider.component';

describe('DataproviderComponent', () => {
  let component: DataproviderComponent;
  let fixture: ComponentFixture<DataproviderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DataproviderComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DataproviderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
