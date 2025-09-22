import { useState } from 'react';
import axios from 'axios';
import config from '../config';

export default function AddCreator() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    username: '',
    password: '',
    mobileno: '',
    bio: ''
  });

  const [message, setMessage] = useState('');
  const [error, setError] = useState('');

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.id]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post(`${config.url}/admin/addcreator`, formData);
      if (response.status === 200) {
        setMessage(response.data);
        setFormData({
          name: '',
          email: '',
          username: '',
          password: '',
          mobileno: '',
          bio: ''
        });
      }
    } catch (error) {
      if (error.response) {
        setError(error.response.data);
      } else {
        setError("An unexpected error occurred.");
      }
    }
  };

  return (
    <div>
      <h3 style={{ textAlign: "center", textDecoration: "underline" }}>Add Creator</h3>
      {message ? (
        <p style={{ textAlign: "center", color: "green", fontWeight: "bolder" }}>{message}</p>
      ) : (
        <p style={{ textAlign: "center", color: "red", fontWeight: "bolder" }}>{error}</p>
      )}

      <form onSubmit={handleSubmit}>
        <div>
          <label>Full Name</label>
          <input type="text" id="name" value={formData.name} onChange={handleChange} required />
        </div>
        <div>
          <label>Email</label>
          <input type="email" id="email" value={formData.email} onChange={handleChange} required />
        </div>
        <div>
          <label>Username</label>
          <input type="text" id="username" value={formData.username} onChange={handleChange} required />
        </div>
        <div>
          <label>Password</label>
          <input type="password" id="password" value={formData.password} onChange={handleChange} required />
        </div>
        <div>
          <label>Mobile Number</label>
          <input type="number" id="mobileno" value={formData.mobileno} onChange={handleChange} required />
        </div>
        <div>
          <label>Bio</label>
          <textarea id="bio" value={formData.bio} onChange={handleChange} placeholder="Write a short bio" />
        </div>
        <button type="submit">Add Creator</button>
      </form>
    </div>
  );
}
