import Home from './Components/Home';
import About from './Components/About';
import Contact from './Components/Contact';

function App() {
  return (
    <div>
      <h1>Student Management Portal</h1>
      <nav style={{ display: 'flex', gap: '20px', padding: '10px', backgroundColor: '#4CAF50' }}>
        <a href="#home" style={{ color: 'white', textDecoration: 'none' }}>Home</a>
        <a href="#about" style={{ color: 'white', textDecoration: 'none' }}>About</a>
        <a href="#contact" style={{ color: 'white', textDecoration: 'none' }}>Contact</a>
      </nav>
      <div id="home"><Home /></div>
      <div id="about"><About /></div>
      <div id="contact"><Contact /></div>
    </div>
  );
}

export default App;
