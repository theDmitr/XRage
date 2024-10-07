import { CommonModule, NgFor } from "@angular/common";
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from "@angular/core";
import { HeaderComponent } from "./components/header/header.component";
import { RouterLink, RouterLinkActive, RouterOutlet } from "@angular/router";
import { provideHttpClient } from "@angular/common/http";
import { ServicesComponent } from "./components/services/services.component";

@NgModule({
    imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive],
    providers: [provideHttpClient()],
    declarations: [HeaderComponent, ServicesComponent],
    exports: [HeaderComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class CoreModule { }