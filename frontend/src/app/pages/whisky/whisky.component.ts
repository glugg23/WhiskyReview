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
            this.whiskies = data;
        });
    }
}
