import { ComponentFixture, TestBed } from '@angular/core/testing'

import { ComingsoonComponent } from './comingsoon.component'

describe('ComingsoonComponent', () => {
  let component: ComingsoonComponent
  let fixture: ComponentFixture<ComingsoonComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ComingsoonComponent],
    }).compileComponents()

    fixture = TestBed.createComponent(ComingsoonComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})
