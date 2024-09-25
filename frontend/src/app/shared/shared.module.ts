import { CommonModule } from "@angular/common";
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from "@angular/core";
import { HeaderComponent } from "./components/header/header.component";
import { RouterLink, RouterLinkActive, RouterModule, RouterOutlet, Routes } from "@angular/router";

@NgModule({
    imports: [CommonModule, RouterOutlet, RouterLink, RouterLinkActive],
    declarations: [HeaderComponent],
    exports: [HeaderComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SharedModule { }