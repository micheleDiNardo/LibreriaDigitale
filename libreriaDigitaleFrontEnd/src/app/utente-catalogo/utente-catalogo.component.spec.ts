import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UtenteCatalogoComponent } from './utente-catalogo.component';

describe('UtenteCatalogoComponent', () => {
  let component: UtenteCatalogoComponent;
  let fixture: ComponentFixture<UtenteCatalogoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UtenteCatalogoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UtenteCatalogoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
