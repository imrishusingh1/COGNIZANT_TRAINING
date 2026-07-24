import { Component } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  template: `
    <div class="card">
      <h2>Data Binding Demo - HOL 3</h2>

      <!-- 1. Interpolation -->
      <div class="demo-section">
        <h3>1. String Interpolation {{ '{{ }}' }}</h3>
        <input type="text" [(ngModel)]="message" placeholder="Type here..." />
        <p>You typed: <strong>{{ message }}</strong> ({{ message.length }} characters)</p>
      </div>

      <!-- 2. Property Binding -->
      <div class="demo-section">
        <h3>2. Property Binding [ ]</h3>
        <input type="checkbox" [(ngModel)]="isDisabled" /> Disable the button
        <!-- Property binding to [disabled] -->
        <button [disabled]="isDisabled" class="btn btn-primary" style="margin-left:10px">
          {{ isDisabled ? 'I am disabled' : 'Click me!' }}
        </button>
        <!-- Property binding to [src] -->
        <br><br>
        <img [src]="imageUrl" [alt]="imageAlt" style="height:60px;border-radius:4px;" />
        <p [title]="'Image: ' + imageAlt">Hover over the image to see title</p>
      </div>

      <!-- 3. Event Binding -->
      <div class="demo-section">
        <h3>3. Event Binding ( )</h3>
        <button class="btn btn-success" (click)="onButtonClick()" (mouseover)="onHover()">
          Click me (or hover)
        </button>
        <p>{{ eventMessage }}</p>
      </div>

      <!-- 4. Two-way Binding -->
      <div class="demo-section">
        <h3>4. Two-Way Binding [( )]</h3>
        <input type="text" [(ngModel)]="twoWayValue" placeholder="Two-way binding..." />
        <p>Value: {{ twoWayValue }}</p>
        <button class="btn btn-secondary" (click)="twoWayValue = 'Reset!'">Reset</button>
      </div>
    </div>
  `,
  styles: [`
    .demo-section { background:#f5f5f5; padding:15px; margin:15px 0; border-radius:8px; }
    .demo-section h3 { color: #1a237e; margin-bottom:10px; }
    input[type='text'] { padding:8px; border:1px solid #ddd; border-radius:4px; width:250px; }
  `]
})
export class DataBindingComponent {
  message = 'Hello Angular!';
  isDisabled = false;
  imageUrl = 'https://angular.io/assets/images/logos/angular/angular.png';
  imageAlt = 'Angular Logo';
  eventMessage = '';
  twoWayValue = 'Angular';

  onButtonClick(): void {
    this.eventMessage = 'Button was clicked at ' + new Date().toLocaleTimeString();
  }

  onHover(): void {
    this.eventMessage = 'Mouse is hovering over the button!';
  }
}
