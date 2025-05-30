import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SefListaComponent } from './sef-lista.component';

describe('SefListaComponent', () => {
  let component: SefListaComponent;
  let fixture: ComponentFixture<SefListaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SefListaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SefListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
