import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDistilleryComponent } from './add-distillery.component';

describe('AddDistilleryComponent', () => {
    let component: AddDistilleryComponent;
    let fixture: ComponentFixture<AddDistilleryComponent>;

    beforeEach(async () => {
        await TestBed.configureTestingModule({
            declarations: [AddDistilleryComponent]
        })
            .compileComponents();
    });

    beforeEach(() => {
        fixture = TestBed.createComponent(AddDistilleryComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
