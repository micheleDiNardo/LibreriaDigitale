import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibroDettaglioComponent } from './libro-dettaglio.component';

describe('LibroDettaglioComponent', () => {
  let component: LibroDettaglioComponent;
  let fixture: ComponentFixture<LibroDettaglioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LibroDettaglioComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LibroDettaglioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
