import React from 'react';

function App() {
  
  const [form, setForm] = React.useState({name:'', email:'', message:''});
  const [errors, setErrors] = React.useState({});

  const validate = () => {
    const err = {};
    if (!form.name) err.name = 'Name is required';
    if (!form.email.includes('@')) err.email = 'Valid email required';
    if (form.message.length < 10) err.message = 'Message must be at least 10 chars';
    return err;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const errs = validate();
    if (Object.keys(errs).length) { setErrors(errs); return; }
    alert('Form submitted: ' + JSON.stringify(form));
  };

  return (
    <div style={{fontFamily:'Arial', padding:'20px'}}>
      <h1>HOL 14 - React Forms</h1>
      <form onSubmit={handleSubmit}>
        <div><label>Name: <input value={form.name} onChange={e=>setForm({...form,name:e.target.value})}/></label>
        {errors.name && <span style={{color:'red'}}> {errors.name}</span>}</div>
        <div><label>Email: <input value={form.email} onChange={e=>setForm({...form,email:e.target.value})}/></label>
        {errors.email && <span style={{color:'red'}}> {errors.email}</span>}</div>
        <div><label>Message: <textarea value={form.message} onChange={e=>setForm({...form,message:e.target.value})}/></label>
        {errors.message && <span style={{color:'red'}}> {errors.message}</span>}</div>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default App;
