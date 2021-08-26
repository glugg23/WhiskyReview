import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class RegionService {
    private endpoint: string = '/api/regions';

    constructor(private http: HttpClient) {
    }

    all(): Observable<any> {
        return this.http.get(this.endpoint);
    }
}
