import { Injectable } from "@angular/core";
import { User } from "../../../shared/models/user.model";
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse } from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class AuthService {
    constructor(private httpClient: HttpClient) { }

    public isAuthenticated(): boolean {
        const user = new User('admin', 'cheesecake');
        const httpOpts = {
            headers: new HttpHeaders({
                'Authorization': 'Basic ' + btoa(user.username + ':' + user.password)
            })
        };

        let auth: boolean = true;

        this.httpClient.get<HttpResponse<any>>(
            '/api/membership', 
            httpOpts
        ).subscribe(
            (data: HttpResponse<any>) => {
                console.log(data);
            },
            (err: HttpErrorResponse) => {
                auth = false;
            }
          );

        return auth;
    }
}