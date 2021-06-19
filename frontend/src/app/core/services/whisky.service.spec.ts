import { TestBed } from '@angular/core/testing';

import { WhiskyService } from './whisky.service';

describe('WhiskyService', () => {
    let service: WhiskyService;

    beforeEach(() => {
        TestBed.configureTestingModule({});
        service = TestBed.inject(WhiskyService);
    });

    it('should be created', () => {
        expect(service).toBeTruthy();
    });
});
