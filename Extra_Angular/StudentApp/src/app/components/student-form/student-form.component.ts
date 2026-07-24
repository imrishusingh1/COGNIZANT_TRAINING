import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../../services/student.service';
import { Student } from '../../models/student.model';

@Component({
  selector: 'app-student-form',
  templateUrl: './student-form.component.html',
  styleUrls: ['./student-form.component.css']
})
export class StudentFormComponent implements OnInit {

  studentForm: FormGroup;
  isEditMode = false;
  studentId: number | null = null;
  submitted = false;

  courses = ['React', 'Spring Boot', 'Angular', 'Microservices', 'Java FSE'];
  grades = ['A+', 'A', 'B+', 'B', 'C', 'D'];

  constructor(
    private fb: FormBuilder,
    private studentService: StudentService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    
    this.studentForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]],
      email: ['', [Validators.required, Validators.email]],
      course: ['', Validators.required],
      grade: ['', Validators.required],
      age: ['', [Validators.required, Validators.min(18), Validators.max(60)]],
      active: [true]
    });
  }

  ngOnInit(): void {
    
    this.studentId = Number(this.route.snapshot.paramMap.get('id'));
    if (this.studentId) {
      this.isEditMode = true;
      
      this.studentService.getStudentById(this.studentId).subscribe(student => {
        if (student) {
          this.studentForm.patchValue(student);
        }
      });
    }
  }

  get f() { return this.studentForm.controls; }

  onSubmit(): void {
    this.submitted = true;

    if (this.studentForm.invalid) {
      return;
    }

    const studentData: Student = {
      id: this.studentId || 0,
      ...this.studentForm.value
    };

    if (this.isEditMode) {
      this.studentService.updateStudent(studentData).subscribe(() => {
        alert('Student updated successfully!');
        this.router.navigate(['/students']);
      });
    } else {
      this.studentService.addStudent(studentData).subscribe(() => {
        alert('Student added successfully!');
        this.router.navigate(['/students']);
      });
    }
  }

  onCancel(): void {
    this.router.navigate(['/students']);
  }
}
