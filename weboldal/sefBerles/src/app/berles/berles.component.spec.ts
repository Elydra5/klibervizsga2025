import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BerlesComponent } from './berles.component';

describe('BerlesComponent', () => {
  let component: BerlesComponent;
  let fixture: ComponentFixture<BerlesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BerlesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BerlesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
