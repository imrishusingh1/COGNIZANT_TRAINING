import React from 'react';

function App() {
  
  return (
    <div style={{fontFamily:'Arial', padding:'20px'}}>
      <h1>HOL 16 - React Router</h1>
      <p>This HOL requires react-router-dom package.</p>
      <p>Install with: <code>npm install react-router-dom</code></p>
      <p>Demonstrates: BrowserRouter, Routes, Route, Link, useParams, useNavigate</p>
      <div style={{backgroundColor:'#f5f5f5', padding:'15px', borderRadius:'8px'}}>
        <h3>Key Routing Concepts:</h3>
        <ul>
          <li>BrowserRouter - wraps the app for routing</li>
          <li>Routes - container for Route components</li>
          <li>Route path="/home" - maps URL to component</li>
          <li>Link to="/about" - navigation links</li>
          <li>useParams() - access URL parameters</li>
          <li>useNavigate() - programmatic navigation</li>
        </ul>
      </div>
    </div>
  );
}

export default App;
