import { Component } from '@angular/core';
import { SharedModule } from './shared/shared.module';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: "./app.component.html",
  imports: [SharedModule]
})
export class AppComponent {
}
