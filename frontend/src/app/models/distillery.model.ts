import { Region } from "./region.model";

export class Distillery {
    public id: number;
    public name: string;
    public region?: Region;

    constructor(id: number, name: string, region?: Region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }
}
