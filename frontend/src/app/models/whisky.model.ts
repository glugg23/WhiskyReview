import { Distillery } from "./distillery.model";
import { Type } from "./type.model";
import { Country } from "./country.model";

export class Whisky {
    public id: number;
    public distillery: Distillery;
    public type: Type;
    public country: Country;
    public age?: number;
    public name?: string;

    public title: string = "";
    public subtitle: string = "";

    constructor(id: number, distillery: Distillery, type: Type, country: Country, age?: number, name?: string) {
        this.id = id;
        this.distillery = distillery;
        this.country = country;
        this.type = type;
        this.age = age;
        this.name = name;
    }
}
