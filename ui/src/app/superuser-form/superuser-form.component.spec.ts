import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuperuserFormComponent } from './superuser-form.component';

describe('SuperuserFormComponent', () => {
  let component: SuperuserFormComponent;
  let fixture: ComponentFixture<SuperuserFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SuperuserFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SuperuserFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
