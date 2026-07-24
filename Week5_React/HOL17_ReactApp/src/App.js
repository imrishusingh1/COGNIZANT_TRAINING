import React from 'react';

function App() {
  
  const ThemeContext = React.createContext();
  const [theme, setTheme] = React.useState('light');

  const toggleTheme = () => setTheme(t => t === 'light' ? 'dark' : 'light');

  const themeStyles = {
    light: { backgroundColor: '#ffffff', color: '#333333' },
    dark:  { backgroundColor: '#333333', color: '#ffffff' }
  };

  return (
    <ThemeContext.Provider value={{ theme, toggleTheme }}>
      <div style={{...themeStyles[theme], minHeight:'100vh', fontFamily:'Arial', padding:'20px'}}>
        <h1>HOL 17 - Context API</h1>
        <p>Current theme: <strong>{theme}</strong></p>
        <button onClick={toggleTheme} style={{padding:'10px 20px', cursor:'pointer'}}>
          Toggle to {theme === 'light' ? 'Dark' : 'Light'} Mode
        </button>
        <p>The theme is shared via Context API without prop drilling.</p>
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
