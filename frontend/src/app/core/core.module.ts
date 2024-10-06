import { CommonModule } from "@angular/common";
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from "@angular/core";
import { HeaderComponent } from "./components/header/header.component";
import { RouterLink, RouterLinkActive, RouterOutlet } from "@angular/router";
import { provideHttpClient } from "@angular/common/http";

@NgModule({
    imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive],
    providers: [provideHttpClient()],
    declarations: [HeaderComponent],
    exports: [HeaderComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class CoreModule { }