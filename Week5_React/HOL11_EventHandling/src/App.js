import React, { useState, useRef } from 'react';

class Counter extends React.Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
    
    this.handleIncrement = this.handleIncrement.bind(this);
    this.handleDecrement = this.handleDecrement.bind(this);
    this.handleReset = this.handleReset.bind(this);
  }

  handleIncrement(syntheticEvent) {
    console.log('Synthetic event type:', syntheticEvent.type);
    this.setState(prevState => ({ count: prevState.count + 1 }));
  }

  handleDecrement() {
    this.setState(prevState => ({ count: prevState.count - 1 }));
  }

  handleReset() {
    this.setState({ count: 0 });
  }

  render() {
    const { count } = this.state;
    return (
      <div style={{ border: '1px solid #ddd', padding: '20px', borderRadius: '8px', margin: '10px 0' }}>
        <h3>Counter (Class Component with 'this')</h3>
        <p>Count: <strong style={{ fontSize: '24px', color: count < 0 ? 'red' : 'green' }}>{count}</strong></p>
        <button onClick={this.handleIncrement} style={btnStyle('#4CAF50')}>+ Increment</button>
        <button onClick={this.handleDecrement} style={btnStyle('#f44336')}>- Decrement</button>
        <button onClick={this.handleReset} style={btnStyle('#9e9e9e')}>Reset</button>
      </div>
    );
  }
}

function FormDemo() {
  const [formData, setFormData] = useState({ name: '', email: '' });
  const [submitted, setSubmitted] = useState(false);
  const nameRef = useRef();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault(); 
    console.log('Form submitted:', formData);
    setSubmitted(true);
    setTimeout(() => setSubmitted(false), 3000);
  };

  const handleKeyDown = (e) => {
    if (e.key === 'Enter') {
      console.log('Enter pressed in name field');
    }
  };

  return (
    <div style={{ border: '1px solid #ddd', padding: '20px', borderRadius: '8px', margin: '10px 0' }}>
      <h3>Form Event Handling (Function Component)</h3>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '10px' }}>
          <label>Name: </label>
          <input
            type="text"
            name="name"
            ref={nameRef}
            value={formData.name}
            onChange={handleChange}
            onKeyDown={handleKeyDown}
            placeholder="Enter name"
            style={{ padding: '8px', marginLeft: '10px' }}
          />
        </div>
        <div style={{ marginBottom: '10px' }}>
          <label>Email: </label>
          <input
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            placeholder="Enter email"
            style={{ padding: '8px', marginLeft: '10px' }}
          />
        </div>
        <button type="submit" style={btnStyle('#2196F3')}>Submit</button>
      </form>
      {submitted && (
        <p style={{ color: 'green' }}>
          ✅ Form submitted! Name: {formData.name}, Email: {formData.email}
        </p>
      )}
    </div>
  );
}

const btnStyle = (color) => ({
  backgroundColor: color,
  color: 'white',
  border: 'none',
  padding: '8px 15px',
  borderRadius: '4px',
  cursor: 'pointer',
  margin: '5px',
  fontSize: '14px'
});

function App() {
  return (
    <div style={{ fontFamily: 'Arial, sans-serif', padding: '20px' }}>
      <h1>ReactJS HOL 11 - Event Handling</h1>
      <p>Demonstrates: Synthetic events, 'this' keyword, event handlers in class and function components</p>
      <Counter />
      <FormDemo />
    </div>
  );
}

export default App;
