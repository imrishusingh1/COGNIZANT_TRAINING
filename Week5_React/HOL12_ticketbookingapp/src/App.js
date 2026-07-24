import React, { useState } from 'react';

const flights = [
  { id: 'AI101', from: 'Delhi', to: 'Mumbai', date: '2024-03-15', time: '08:00', price: 3500, seats: 42 },
  { id: 'IG202', from: 'Mumbai', to: 'Bangalore', date: '2024-03-15', time: '10:30', price: 2800, seats: 18 },
  { id: 'SG303', from: 'Chennai', to: 'Hyderabad', date: '2024-03-16', time: '14:00', price: 2200, seats: 55 },
  { id: 'VT404', from: 'Kolkata', to: 'Delhi', date: '2024-03-16', time: '16:45', price: 4200, seats: 7 },
];

function GuestPage({ onLogin }) {
  return (
    <div>
      <div style={{ backgroundColor: '#fff3e0', padding: '15px', borderRadius: '8px', marginBottom: '20px' }}>
        <p>🔒 You are browsing as a <strong>guest</strong>. Login to book tickets.</p>
        <button onClick={onLogin} style={btnStyle('#4CAF50')}>Login to Book</button>
      </div>
      <h3>Available Flights</h3>
      {flights.map(flight => (
        <FlightCard key={flight.id} flight={flight} canBook={false} />
      ))}
    </div>
  );
}

function UserPage({ onLogout }) {
  const [bookings, setBookings] = useState([]);
  const [message, setMessage] = useState('');

  const handleBook = (flight) => {
    setBookings(prev => [...prev, flight.id]);
    setMessage(`✅ Ticket booked for flight ${flight.id} (${flight.from} → ${flight.to})!`);
    setTimeout(() => setMessage(''), 3000);
  };

  return (
    <div>
      <div style={{ backgroundColor: '#e8f5e9', padding: '15px', borderRadius: '8px', marginBottom: '20px' }}>
        <p>✅ Logged in as <strong>User</strong>. You can book tickets!</p>
        <button onClick={onLogout} style={btnStyle('#f44336')}>Logout</button>
      </div>
      {message && (
        <div style={{ backgroundColor: '#4CAF50', color: 'white', padding: '10px', borderRadius: '5px', marginBottom: '10px' }}>
          {message}
        </div>
      )}
      {bookings.length > 0 && (
        <p>Your bookings: {bookings.join(', ')}</p>
      )}
      <h3>Available Flights</h3>
      {flights.map(flight => (
        <FlightCard key={flight.id} flight={flight} canBook={true} onBook={handleBook} />
      ))}
    </div>
  );
}

function FlightCard({ flight, canBook, onBook }) {
  const isLow = flight.seats < 10;

  return (
    <div style={{
      border: '1px solid #ddd',
      padding: '15px',
      marginBottom: '10px',
      borderRadius: '8px',
      display: 'flex',
      justifyContent: 'space-between',
      alignItems: 'center'
    }}>
      <div>
        <strong>{flight.id}</strong>: {flight.from} → {flight.to}
        <br />
        {flight.date} | {flight.time}
        <br />
        <span style={{ color: isLow ? 'red' : 'green' }}>
          {flight.seats} seats available {isLow ? '⚠️ (Low!)' : ''}
        </span>
      </div>
      <div style={{ textAlign: 'right' }}>
        <div style={{ fontSize: '20px', fontWeight: 'bold', color: '#1a237e' }}>₹{flight.price}</div>
        {}
        {canBook ? (
          <button onClick={() => onBook(flight)} style={btnStyle('#1a237e')}>Book Ticket</button>
        ) : (
          <button disabled style={{ ...btnStyle('#9e9e9e'), cursor: 'not-allowed' }}>Login to Book</button>
        )}
      </div>
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
  margin: '5px'
});

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <div style={{ fontFamily: 'Arial, sans-serif', padding: '20px', maxWidth: '900px', margin: '0 auto' }}>
      <h1 style={{ color: '#1a237e' }}>✈️ Ticket Booking App - ReactJS HOL 12</h1>
      <h4>Demonstrating: Conditional Rendering, Element Variables, Preventing Components from Rendering</h4>

      {}
      {isLoggedIn ? (
        <UserPage onLogout={() => setIsLoggedIn(false)} />
      ) : (
        <GuestPage onLogin={() => setIsLoggedIn(true)} />
      )}
    </div>
  );
}

export default App;
