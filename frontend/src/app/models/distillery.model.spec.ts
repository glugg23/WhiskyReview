import { Distillery } from './distillery.model';
import { Region } from "./region.model";

describe('Distillery.Model', () => {
    it('should create an instance', () => {
        expect(new Distillery(1, 'Glenfiddich', new Region(1, 'Speyside'))).toBeTruthy();
    });
});
