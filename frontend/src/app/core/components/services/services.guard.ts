import { inject } from "@angular/core";
import { AuthService } from "../../services/auth/auth.service";

export const servicesGuard = () => {
    const authService = inject(AuthService);
    const auth = authService.isAuthenticated();
    if (!auth) {
        alert('Не авторизован!');
    }
    return auth;
};