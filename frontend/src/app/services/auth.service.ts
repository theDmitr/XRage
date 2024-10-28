import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse, HttpHeaders, HttpResponse } from "@angular/common/http";
import { JwtResponseDto } from "../models/jwtResponseDto.model";

@Injectable({
    providedIn: 'root'
})
export class AuthService {
    private static apiUrl = 'api/auth'

    constructor(private httpClient: HttpClient) { }

    auth(username: string, password: string) {
        this.httpClient
            .post<JwtResponseDto>(AuthService.apiUrl, {username: username, password: password})
            .subscribe(r => this.setSession(r));
    }

    private setSession(authResult: JwtResponseDto) {
        console.log(authResult);
        //const expiresAt = moment().add(authResult.expiresIn,'second');

        //localStorage.setItem('id_token', authResult.idToken);
        //localStorage.setItem("expires_at", JSON.stringify(expiresAt.valueOf()) );
    }
}