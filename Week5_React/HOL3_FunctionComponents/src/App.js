import React from 'react';

function Welcome({ name, role }) {
  const cardStyle = {
    backgroundColor: '#f0f8ff',
    border: '2px solid #4CAF50',
    borderRadius: '8px',
    padding: '15px',
    margin: '10px',
    maxWidth: '300px'
  };

  const headingStyle = {
    color: '#333',
    fontSize: '20px'
  };

  return (
    <div style={cardStyle}>
      <h2 style={headingStyle}>Welcome, {name}!</h2>
      <p>Role: <strong>{role}</strong></p>
    </div>
  );
}

function StudentCard({ name, course, grade }) {
  return (
    <div style={{
      backgroundColor: '#fff3e0',
      border: '1px solid #ff9800',
      borderRadius: '8px',
      padding: '15px',
      margin: '10px',
      display: 'inline-block',
      minWidth: '200px'
    }}>
      <h3 style={{ color: '#e65100' }}>{name}</h3>
      <p>Course: {course}</p>
      <p>Grade: <span style={{ fontWeight: 'bold', color: '#2e7d32' }}>{grade}</span></p>
    </div>
  );
}

function App() {
  return (
    <div style={{ fontFamily: 'Arial, sans-serif', padding: '20px' }}>
      <h1 style={{ color: '#1a237e' }}>ReactJS HOL 3 - Function Components & Styling</h1>

      <h2>Welcome Messages:</h2>
      <div style={{ display: 'flex', flexWrap: 'wrap' }}>
        <Welcome name="Alice" role="Administrator" />
        <Welcome name="Bob" role="Teacher" />
        <Welcome name="Carol" role="Student" />
      </div>

      <h2>Student Cards:</h2>
      <div>
        <StudentCard name="John Doe" course="React Development" grade="A+" />
        <StudentCard name="Jane Smith" course="Spring Boot" grade="A" />
        <StudentCard name="Mike Johnson" course="Microservices" grade="B+" />
      </div>
    </div>
  );
}

export default App;
