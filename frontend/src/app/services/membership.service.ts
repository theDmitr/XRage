import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { firstValueFrom, lastValueFrom, Observable } from "rxjs";
import { Membership } from "../models/membership.model";

@Injectable({
    providedIn: "root"
})
export class MembershipService {
    private apiUrl = "/api/membership"

    constructor(private httpClient: HttpClient) {}

    async getAll(): Promise<Membership[]> {
        return await lastValueFrom(this.httpClient.get<Membership[]>(this.apiUrl));
    }
}