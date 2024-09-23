import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { HeaderComponent } from "./components/header/header.component";

@NgModule({
    imports: [CommonModule],
    declarations: [HeaderComponent],
    exports: [HeaderComponent]
})
export class SharedModule { }