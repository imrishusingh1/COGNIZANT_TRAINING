import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Student } from '../models/student.model';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private students: Student[] = [
    { id: 1, name: 'Alice Johnson', email: 'alice@example.com', course: 'React', grade: 'A', age: 22, active: true },
    { id: 2, name: 'Bob Smith', email: 'bob@example.com', course: 'Spring Boot', grade: 'B+', age: 24, active: true },
    { id: 3, name: 'Carol White', email: 'carol@example.com', course: 'Angular', grade: 'A+', age: 21, active: true },
    { id: 4, name: 'David Brown', email: 'david@example.com', course: 'Microservices', grade: 'B', age: 25, active: false },
    { id: 5, name: 'Eve Davis', email: 'eve@example.com', course: 'Java FSE', grade: 'A', age: 23, active: true },
  ];

  private nextId = 6;

  getStudents(): Observable<Student[]> {
    return of([...this.students]);
  }

  getStudentById(id: number): Observable<Student | undefined> {
    const student = this.students.find(s => s.id === id);
    return of(student);
  }

  addStudent(student: Student): Observable<Student> {
    student.id = this.nextId++;
    this.students.push({ ...student });
    return of(student);
  }

  updateStudent(updated: Student): Observable<Student> {
    const index = this.students.findIndex(s => s.id === updated.id);
    if (index > -1) {
      this.students[index] = { ...updated };
    }
    return of(updated);
  }

  deleteStudent(id: number): Observable<void> {
    this.students = this.students.filter(s => s.id !== id);
    return of(void 0);
  }

  getActiveStudents(): Observable<Student[]> {
    return of(this.students.filter(s => s.active));
  }
}
