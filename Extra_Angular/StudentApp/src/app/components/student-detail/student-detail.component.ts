import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../../services/student.service';
import { Student } from '../../models/student.model';

@Component({
  selector: 'app-student-detail',
  template: `
    <div class="card" *ngIf="student">
      <h2>Student Detail</h2>
      <table>
        <tr><th>ID</th><td>{{ student.id }}</td></tr>
        <tr><th>Name</th><td>{{ student.name }}</td></tr>
        <tr><th>Email</th><td>{{ student.email }}</td></tr>
        <tr><th>Course</th><td>{{ student.course }}</td></tr>
        <tr><th>Grade</th><td>{{ student.grade }}</td></tr>
        <tr><th>Age</th><td>{{ student.age }}</td></tr>
        <tr>
          <th>Status</th>
          <td>
            <span [ngStyle]="{'color': student.active ? 'green' : 'gray'}">
              {{ student.active ? 'Active' : 'Inactive' }}
            </span>
          </td>
        </tr>
      </table>
      <br>
      <button class="btn btn-primary" [routerLink]="['/students/edit', student.id]">Edit</button>
      <button class="btn btn-secondary" (click)="goBack()">Back to List</button>
    </div>
    <div *ngIf="!student" class="card">
      <p>Student not found.</p>
      <button class="btn btn-secondary" (click)="goBack()">Back</button>
    </div>
  `
})
export class StudentDetailComponent implements OnInit {
  student: Student | undefined;

  constructor(
    private route: ActivatedRoute,
    private studentService: StudentService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.studentService.getStudentById(id).subscribe(s => this.student = s);
  }

  goBack(): void {
    this.router.navigate(['/students']);
  }
}
