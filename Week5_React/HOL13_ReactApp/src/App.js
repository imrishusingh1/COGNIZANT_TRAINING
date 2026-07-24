import React from 'react';

function App() {
  
  const [items, setItems] = React.useState([
    { id: 1, text: 'Learn React', done: true },
    { id: 2, text: 'Build Projects', done: false },
    { id: 3, text: 'Get Certified', done: false },
  ]);

  const toggle = (id) => setItems(prev =>
    prev.map(item => item.id === id ? {...item, done: !item.done} : item)
  );

  return (
    <div style={{fontFamily:'Arial', padding:'20px'}}>
      <h1>HOL 13 - Lists and Keys</h1>
      <ul>
        {items.map(item => (
          <li key={item.id}
            onClick={() => toggle(item.id)}
            style={{textDecoration: item.done ? 'line-through' : 'none', cursor:'pointer', padding:'5px'}}>
            {item.text}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
