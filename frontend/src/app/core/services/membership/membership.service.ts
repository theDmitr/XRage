import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Membership } from "../../../shared/models/membership.model";

@Injectable({
    providedIn: "root"
})
export class MembershipService {
    private apiUrl = "/api/membership"

    constructor(private httpClient: HttpClient) {}

    getAll(): Observable<Membership[]> {
        return this.httpClient.get<Membership[]>(this.apiUrl);
    }
}