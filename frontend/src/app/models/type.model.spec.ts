import { Type } from './type.model';

describe('Type.Model', () => {
    it('should create an instance', () => {
        expect(new Type(1, 'Single malt')).toBeTruthy();
    });
});
