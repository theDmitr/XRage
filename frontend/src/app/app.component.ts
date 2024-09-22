import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule],
  templateUrl: "./app.component.html",
  styles: [],
})
export class AppComponent {
  name=""
}
