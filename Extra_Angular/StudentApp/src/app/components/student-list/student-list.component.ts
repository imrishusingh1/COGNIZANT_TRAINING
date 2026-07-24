import { Component, OnInit } from '@angular/core';
import { Student } from '../../models/student.model';
import { StudentService } from '../../services/student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  students: Student[] = [];
  searchTerm: string = '';
  sortColumn: string = 'name';
  showActive: boolean = false;
  selectedCourse: string = '';

  courses = ['All', 'React', 'Spring Boot', 'Angular', 'Microservices', 'Java FSE'];

  constructor(private studentService: StudentService) {}

  ngOnInit(): void {
    this.loadStudents();
  }

  loadStudents(): void {
    this.studentService.getStudents().subscribe(students => {
      this.students = students;
    });
  }

  get filteredStudents(): Student[] {
    return this.students.filter(student => {
      const matchSearch = student.name.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
                          student.email.toLowerCase().includes(this.searchTerm.toLowerCase());
      const matchActive = !this.showActive || student.active;
      const matchCourse = !this.selectedCourse || this.selectedCourse === 'All' ||
                          student.course === this.selectedCourse;
      return matchSearch && matchActive && matchCourse;
    });
  }

  deleteStudent(id: number): void {
    if (confirm('Are you sure you want to delete this student?')) {
      this.studentService.deleteStudent(id).subscribe(() => {
        this.loadStudents();
      });
    }
  }

  toggleActive(student: Student): void {
    student.active = !student.active;
    this.studentService.updateStudent(student).subscribe();
  }

  sortBy(column: string): void {
    this.sortColumn = column;
    this.students = [...this.students].sort((a: any, b: any) => {
      return a[column] > b[column] ? 1 : -1;
    });
  }
}
