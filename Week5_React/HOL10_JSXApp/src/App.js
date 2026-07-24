import React from 'react';

function App() {
  const appName = "JSX Demo Application";
  const isLoggedIn = true;
  const items = ['React', 'JSX', 'ES6', 'Virtual DOM', 'Components'];

  const headerStyle = {
    backgroundColor: '#1a237e',
    color: 'white',
    padding: '20px',
    textAlign: 'center',
    borderRadius: '8px'
  };

  const listItemStyle = {
    padding: '8px 15px',
    margin: '5px 0',
    backgroundColor: '#e8eaf6',
    borderLeft: '4px solid #1a237e',
    borderRadius: '4px'
  };

  return (
    <div style={{ fontFamily: 'Arial, sans-serif', padding: '20px' }}>
      {}
      <header style={headerStyle}>
        <h1>{appName}</h1>
        {}
        <p>{isLoggedIn ? 'Welcome, User!' : 'Please log in'}</p>
      </header>

      <main style={{ padding: '20px' }}>
        <h2>ReactJS HOL 10 - JSX Features</h2>

        {}
        <p>Today is: <strong>{new Date().toLocaleDateString()}</strong></p>
        <p>Math result: <strong>{2 + 2 * 10}</strong></p>

        <h3>Topics covered in this HOL:</h3>
        <ul style={{ listStyle: 'none', padding: 0 }}>
          {}
          {items.map((item, index) => (
            <li key={index} style={listItemStyle}>{item}</li>
          ))}
        </ul>

        {}
        <div style={{
          backgroundColor: '#fff3e0',
          border: '1px solid #ff9800',
          padding: '15px',
          borderRadius: '8px',
          marginTop: '20px'
        }}>
          <h4>JSX Key Points:</h4>
          <ul>
            <li>JSX is syntactic sugar for React.createElement()</li>
            <li>Use className instead of class</li>
            <li>Use style with JavaScript object (camelCase)</li>
            <li>JavaScript expressions go in {'{}'}</li>
            <li>All elements must have a closing tag</li>
          </ul>
        </div>
      </main>
    </div>
  );
}

export default App;
