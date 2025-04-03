import React, { useState } from "react";

function App() {
  const [formData, setFormData] = useState({
    name: "",
    height: "",
    weight: "",
    age: "",
  });
  const [bmiData, setBmiData] = useState(null);

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const calculateBMI = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch("http://localhost:8080/api/bmi/calculate", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(formData),
      });
      const data = await response.json();
      setBmiData(data);
    } catch (error) {
      console.error("Error calculating BMI:", error);
    }
  };

  return (
      <div className="flex flex-col items-center justify-center min-h-screen bg-gray-100">
        <h1 className="text-3xl font-bold mb-6">BMI Calculator</h1>
        <form onSubmit={calculateBMI} className="bg-white p-6 rounded-lg shadow-lg">
          <div className="mb-4">
            <label className="block text-gray-700">Name:</label>
            <input type="text" name="name" value={formData.name} onChange={handleChange} required className="border p-2 w-full rounded" />
          </div>
          <div className="mb-4">
            <label className="block text-gray-700">Height (cm):</label>
            <input type="number" name="height" value={formData.height} onChange={handleChange} required className="border p-2 w-full rounded" />
          </div>
          <div className="mb-4">
            <label className="block text-gray-700">Weight (kg):</label>
            <input type="number" name="weight" value={formData.weight} onChange={handleChange} required className="border p-2 w-full rounded" />
          </div>
          <div className="mb-4">
            <label className="block text-gray-700">Age:</label>
            <input type="number" name="age" value={formData.age} onChange={handleChange} required className="border p-2 w-full rounded" />
          </div>
          <button type="submit" className="bg-blue-500 text-white p-2 w-full rounded">Calculate BMI</button>
        </form>
        {bmiData && (
            <div className="mt-6 p-4 bg-green-200 rounded-lg shadow">
              <h2 className="text-xl font-bold">BMI Index: {bmiData.bmi}</h2>
              <p className="text-lg">Status: {bmiData.category}</p>
            </div>
        )}
      </div>
  );
}

export default App;
