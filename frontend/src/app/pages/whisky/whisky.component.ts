import { Component, OnInit } from '@angular/core';
import { WhiskyService } from "../../core/services/whisky.service";
import { Whisky } from "../../models/whisky.model";

@Component({
    selector: 'app-whisky',
    templateUrl: './whisky.component.html',
    styleUrls: ['./whisky.component.scss']
})
export class WhiskyComponent implements OnInit {
    whiskies: Whisky[] = [];

    constructor(private whiskyService: WhiskyService) {
    }

    ngOnInit(): void {
        this.fetchWhiskies();
    }

    fetchWhiskies() {
        this.whiskyService.getAllWhiskies().subscribe((data) => {
            this.whiskies = data.map((w: Whisky) => {
                let ageText = w.age != null ? ` ${w.age} Year Old` : '';
                let subtitleRegion = w.distillery.region != null ? `${w.distillery.region.name} ` : '';
                w.title = `${w.distillery.name}${ageText}`;
                w.subtitle = subtitleRegion + `${w.type.name} ${w.country.name} whisky`;
                return w;
            });
        });
    }
}
