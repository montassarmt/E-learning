import { ComponentFixture, TestBed } from '@angular/core/testing'

import { CartMenuComponent } from './cart-menu.component'

describe('CartMenuComponent', () => {
  let component: CartMenuComponent
  let fixture: ComponentFixture<CartMenuComponent>

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CartMenuComponent],
    }).compileComponents()

    fixture = TestBed.createComponent(CartMenuComponent)
    component = fixture.componentInstance
    fixture.detectChanges()
  })

  it('should create', () => {
    expect(component).toBeTruthy()
  })
})
