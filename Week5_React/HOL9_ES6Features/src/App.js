import React, { useState } from 'react';

const students = [
  { id: 1, name: 'Alice Johnson', course: 'React', score: 95 },
  { id: 2, name: 'Bob Smith', course: 'Spring Boot', score: 88 },
  { id: 3, name: 'Carol White', course: 'Microservices', score: 92 },
  { id: 4, name: 'David Brown', course: 'Angular', score: 78 },
  { id: 5, name: 'Eve Davis', course: 'Java FSE', score: 85 },
];

const getGrade = (score) => {
  if (score >= 90) return 'A';
  if (score >= 80) return 'B';
  if (score >= 70) return 'C';
  return 'D';
};

const StudentRow = ({ id, name, course, score }) => (
  <tr>
    <td style={{ padding: '10px', border: '1px solid #ddd' }}>{id}</td>
    <td style={{ padding: '10px', border: '1px solid #ddd' }}>{name}</td>
    <td style={{ padding: '10px', border: '1px solid #ddd' }}>{course}</td>
    <td style={{ padding: '10px', border: '1px solid #ddd' }}>{score}</td>
    <td style={{ padding: '10px', border: '1px solid #ddd', fontWeight: 'bold' }}>{getGrade(score)}</td>
  </tr>
);

function App() {
  const [filter, setFilter] = useState('');

  const filtered = students.filter(({ name, course }) =>
    name.toLowerCase().includes(filter.toLowerCase()) ||
    course.toLowerCase().includes(filter.toLowerCase())
  );

  const { length: totalStudents } = filtered;
  const avgScore = filtered.reduce((acc, { score }) => acc + score, 0) / totalStudents || 0;

  return (
    <div style={{ fontFamily: 'Arial, sans-serif', padding: '20px' }}>
      <h1>ReactJS HOL 9 - ES6 Features</h1>
      <h2>Student Scores - Demonstrating map(), arrow functions, destructuring</h2>

      <div style={{ marginBottom: '20px' }}>
        <label><strong>Search: </strong></label>
        <input
          type="text"
          value={filter}
          onChange={(e) => setFilter(e.target.value)}
          placeholder="Search by name or course..."
          style={{ padding: '8px', width: '300px', marginLeft: '10px' }}
        />
      </div>

      <p>Total: {totalStudents} students | Average Score: {avgScore.toFixed(1)}</p>

      <table style={{ borderCollapse: 'collapse', width: '100%' }}>
        <thead>
          <tr style={{ backgroundColor: '#1a237e', color: 'white' }}>
            <th style={{ padding: '10px' }}>ID</th>
            <th style={{ padding: '10px' }}>Name</th>
            <th style={{ padding: '10px' }}>Course</th>
            <th style={{ padding: '10px' }}>Score</th>
            <th style={{ padding: '10px' }}>Grade</th>
          </tr>
        </thead>
        <tbody>
          {}
          {filtered.map(student => (
            <StudentRow key={student.id} {...student} />
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
