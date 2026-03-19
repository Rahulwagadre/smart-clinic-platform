import { useState } from "react";
import { signup } from "../api/authApi";

function SignupPage() {
  const [form, setForm] = useState({
    clinicName: "",
    email: "",
    password: "",
    phone: "",
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await signup(form);
      alert("Signup successful! Please login.");
    } catch (err) {
      alert("Signup failed");
    }
  };

  return (
    <div>
      <h2>Clinic Signup</h2>
      <form onSubmit={handleSubmit}>
        <input name="clinicName" placeholder="Clinic Name" onChange={handleChange} />
        <input name="email" placeholder="Email" onChange={handleChange} />
        <input name="password" type="password" placeholder="Password" onChange={handleChange} />
        <input name="phone" placeholder="Phone" onChange={handleChange} />
        <button type="submit">Signup</button>
      </form>
    </div>
  );
}

export default SignupPage;