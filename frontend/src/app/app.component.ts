import { Component } from '@angular/core';
import { SharedModule } from './shared/shared.module';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: "./app.component.html",
  styleUrl: "./app.component.css",
  imports: [CommonModule, SharedModule, RouterOutlet]
})
export class AppComponent {
}
