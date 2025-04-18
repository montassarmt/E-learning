import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProposalListComponent } from './proposal-list.component';

describe('ProposalListComponent', () => {
  let component: ProposalListComponent;
  let fixture: ComponentFixture<ProposalListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProposalListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProposalListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
