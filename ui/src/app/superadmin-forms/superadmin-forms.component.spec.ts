import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuperadminFormsComponent } from './superadmin-forms.component';

describe('SuperadminFormsComponent', () => {
  let component: SuperadminFormsComponent;
  let fixture: ComponentFixture<SuperadminFormsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SuperadminFormsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SuperadminFormsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
