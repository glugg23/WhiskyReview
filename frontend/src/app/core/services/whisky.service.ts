import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class WhiskyService {
    private endpoint: string = '/api/whiskies';

    constructor(private http: HttpClient) {
    }

    getAllWhiskies(): Observable<any> {
        return this.http.get(this.endpoint);
    }
}
