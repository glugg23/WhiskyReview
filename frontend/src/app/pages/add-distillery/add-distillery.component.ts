import { Component, OnInit } from '@angular/core';
import { Region } from "../../models/region.model";
import { RegionService } from "../../core/services/region.service";

@Component({
    selector: 'app-add-distillery',
    templateUrl: './add-distillery.component.html',
    styleUrls: ['./add-distillery.component.scss']
})
export class AddDistilleryComponent implements OnInit {
    regions: Region[] = [];

    constructor(private regionService: RegionService) {
    }

    ngOnInit(): void {
        this.fetchRegions();
    }

    fetchRegions() {
        this.regionService.all().subscribe(data => this.regions = data);
    }
}
