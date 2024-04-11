import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeederComponent } from './heeder.component';

describe('HeederComponent', () => {
  let component: HeederComponent;
  let fixture: ComponentFixture<HeederComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [HeederComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HeederComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
