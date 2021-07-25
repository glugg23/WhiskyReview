import { Whisky } from './whisky.model';
import { Distillery } from "./distillery.model";
import { Type } from "./type.model";
import { Country } from "./country.model";

describe('Whisky', () => {
    it('should create an instance', () => {
        expect(new Whisky(1, new Distillery(1, 'Speyside'), new Type(1, 'Single malt'),
            new Country(1, 'Scotch'))).toBeTruthy();
    });
});
