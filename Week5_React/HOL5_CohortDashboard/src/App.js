import React from 'react';
import styles from './App.module.css';

const cohorts = [
  { id: 1, name: 'Java FSE Batch 1', status: 'Ongoing', startDate: '2024-01-10', students: 45, trainer: 'Mr. Sharma' },
  { id: 2, name: 'React Development', status: 'Ongoing', startDate: '2024-02-01', students: 38, trainer: 'Ms. Priya' },
  { id: 3, name: 'Spring Boot Batch 3', status: 'Completed', startDate: '2023-10-01', students: 52, trainer: 'Mr. Ravi' },
  { id: 4, name: 'Microservices Training', status: 'Completed', startDate: '2023-11-15', students: 30, trainer: 'Ms. Kavya' },
  { id: 5, name: 'Angular HOL', status: 'Ongoing', startDate: '2024-03-01', students: 42, trainer: 'Mr. Kumar' },
];

function CohortCard({ cohort }) {
  const isOngoing = cohort.status === 'Ongoing';

  const cardStyle = {
    border: `2px solid ${isOngoing ? '#4CAF50' : '#9e9e9e'}`,
    borderRadius: '10px',
    padding: '15px',
    margin: '10px',
    backgroundColor: isOngoing ? '#f1f8e9' : '#f5f5f5',
    width: '280px',
    display: 'inline-block',
    verticalAlign: 'top'
  };

  const statusStyle = {
    display: 'inline-block',
    padding: '3px 10px',
    borderRadius: '12px',
    backgroundColor: isOngoing ? '#4CAF50' : '#9e9e9e',
    color: 'white',
    fontSize: '12px',
    fontWeight: 'bold'
  };

  return (
    <div style={cardStyle}>
      <h3 style={{ margin: '0 0 8px 0', color: '#333' }}>{cohort.name}</h3>
      <span style={statusStyle}>{cohort.status}</span>
      <p>Start Date: {cohort.startDate}</p>
      <p>Students: {cohort.students}</p>
      <p>Trainer: {cohort.trainer}</p>
    </div>
  );
}

function App() {
  const ongoing = cohorts.filter(c => c.status === 'Ongoing');
  const completed = cohorts.filter(c => c.status === 'Completed');

  return (
    <div className={styles.app}>
      <h1 className={styles.title}>My Academy - Cohort Dashboard</h1>

      <div className={styles.section}>
        <h2 className={styles.sectionTitle}>🟢 Ongoing Cohorts ({ongoing.length})</h2>
        <div>
          {ongoing.map(cohort => <CohortCard key={cohort.id} cohort={cohort} />)}
        </div>
      </div>

      <div className={styles.section}>
        <h2 className={styles.sectionTitle}>✅ Completed Cohorts ({completed.length})</h2>
        <div>
          {completed.map(cohort => <CohortCard key={cohort.id} cohort={cohort} />)}
        </div>
      </div>
    </div>
  );
}

export default App;
