import { Region } from './region.model';

describe('Region.Model', () => {
    it('should create an instance', () => {
        expect(new Region(1, 'Speyside')).toBeTruthy();
    });
});
