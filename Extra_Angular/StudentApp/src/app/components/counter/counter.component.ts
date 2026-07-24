import { Component } from '@angular/core';

@Component({
  selector: 'app-counter',
  template: `
    <div class="card">
      <h2>Counter - HOL 3: Data Binding Demo</h2>

      <!-- String interpolation (one-way data binding) -->
      <p>Current count: <strong style="font-size:24px;color:#1a237e">{{ count }}</strong></p>

      <label>Step size: </label>
      <!-- Two-way data binding [(ngModel)] -->
      <input type="number" [(ngModel)]="step" min="1" max="10" style="width:60px;margin:0 10px;" />

      <!-- Event binding (click) -->
      <button class="btn btn-success" (click)="increment()">+ Increment</button>
      <button class="btn btn-danger" (click)="decrement()" [disabled]="count <= 0">- Decrement</button>
      <button class="btn btn-secondary" (click)="reset()">Reset</button>

      <!-- Property binding [ngStyle] - dynamically change style -->
      <p [ngStyle]="{'color': count < 0 ? 'red' : count === 0 ? 'gray' : 'green', 'fontWeight': 'bold'}">
        Status: {{ count < 0 ? 'Negative' : count === 0 ? 'Zero' : 'Positive' }}
      </p>

      <hr />
      <h3>Data Binding Types Summary:</h3>
      <ul>
        <li><strong>Interpolation:</strong> {{ '{{ count }}' }}</li>
        <li><strong>Property Binding:</strong> [disabled]="count <= 0"</li>
        <li><strong>Event Binding:</strong> (click)="increment()"</li>
        <li><strong>Two-Way Binding:</strong> [(ngModel)]="step"</li>
      </ul>
    </div>
  `
})
export class CounterComponent {
  count = 0;
  step = 1;

  increment(): void { this.count += this.step; }
  decrement(): void { this.count -= this.step; }
  reset(): void { this.count = 0; }
}
