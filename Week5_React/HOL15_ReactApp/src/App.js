import React from 'react';

function App() {
  
  const [data, setData] = React.useState([]);
  const [loading, setLoading] = React.useState(true);
  const [count, setCount] = React.useState(0);

  React.useEffect(() => {
    
    const timer = setTimeout(() => {
      setData(['Item 1', 'Item 2', 'Item 3', 'Item 4', 'Item 5']);
      setLoading(false);
    }, 1500);
    return () => clearTimeout(timer); 
  }, []);

  React.useEffect(() => {
    document.title = `Count: \${count}`;
  }, [count]);

  return (
    <div style={{fontFamily:'Arial', padding:'20px'}}>
      <h1>HOL 15 - React Hooks</h1>
      <h3>useEffect + useState Demo</h3>
      <p>Count: <strong>{count}</strong> (check browser tab title!)</p>
      <button onClick={() => setCount(c => c+1)}>Increment</button>
      <h3>Data fetched with useEffect:</h3>
      {loading ? <p>Loading...</p> : <ul>{data.map((d,i) => <li key={i}>{d}</li>)}</ul>}
    </div>
  );
}

export default App;
