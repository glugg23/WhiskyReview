import { Country } from './country.model';

describe('Country.Model', () => {
    it('should create an instance', () => {
        expect(new Country(1, 'Scotch')).toBeTruthy();
    });
});
