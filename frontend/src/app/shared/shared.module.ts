import { CommonModule } from "@angular/common";
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from "@angular/core";
import { HeaderComponent } from "./components/header/header.component";

@NgModule({
    imports: [CommonModule],
    declarations: [HeaderComponent],
    exports: [HeaderComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class SharedModule { }