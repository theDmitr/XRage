import { Injectable } from "@angular/core";
import { User } from "../models/user.model";
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse } from "@angular/common/http";
import { firstValueFrom } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class AuthService {
    private apiUrl = '/api/user'

    constructor(private httpClient: HttpClient) { }

    public async isAuthenticated(): Promise<boolean> {
        const user = new User('admin', 'cheesecake');

        let headers = new HttpHeaders();
        headers = headers.set('Authorization', 'Basic ' + btoa(user.username + ':' + user.password));

        try {
            const response = await firstValueFrom(
                this.httpClient.post<any[]>(
                    this.apiUrl + '/auth', null, { headers: headers, observe: 'response' }
                )
            );
            return response.ok;
        } catch (error) {
            return false;
        }
    }
}