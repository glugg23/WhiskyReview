import { Component, OnInit } from '@angular/core';
import { WhiskyService } from "../../core/services/whisky.service";

@Component({
    selector: 'app-whisky',
    templateUrl: './whisky.component.html',
    styleUrls: ['./whisky.component.scss']
})
export class WhiskyComponent implements OnInit {
    whiskies: any[] = [];

    constructor(private whiskyService: WhiskyService) {
    }

    ngOnInit(): void {
        this.fetchWhiskies();
    }

    fetchWhiskies() {
        this.whiskyService.getAllWhiskies().subscribe((data) => {
            this.whiskies = data.map((d: any) => JSON.stringify(d));
        });
    }
}
