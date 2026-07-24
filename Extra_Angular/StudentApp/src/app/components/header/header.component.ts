import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  template: `
    <header class="app-header">
      <div class="header-content">
        <h1>🎓 Student Management Portal</h1>
        <nav>
          <a routerLink="/students" routerLinkActive="active">Students</a>
          <a routerLink="/students/new" routerLinkActive="active">Add Student</a>
          <a routerLink="/counter" routerLinkActive="active">Counter (HOL 3)</a>
          <a routerLink="/data-binding" routerLinkActive="active">Data Binding (HOL 3)</a>
        </nav>
      </div>
    </header>
  `,
  styles: [`
    .app-header {
      background-color: #1a237e;
      color: white;
      padding: 15px 20px;
    }
    .header-content {
      max-width: 1200px;
      margin: 0 auto;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
    h1 { margin: 0; font-size: 22px; }
    nav a {
      color: white;
      text-decoration: none;
      margin-left: 20px;
      padding: 5px 10px;
      border-radius: 4px;
    }
    nav a:hover, nav a.active {
      background-color: rgba(255,255,255,0.2);
    }
  `]
})
export class HeaderComponent {}
