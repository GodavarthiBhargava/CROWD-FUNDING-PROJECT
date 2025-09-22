import { useEffect, useState } from "react";
import axios from "axios";
import config from "../config";
import Button from '@mui/material/Button';
import DeleteIcon from '@mui/icons-material/Delete';
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

export default function ViewCreators() {
  const [creators, setCreators] = useState([]);
  const [error, setError] = useState("");

  const fetchCreators = async () => {
    try {
      const response = await axios.get(`${config.url}/admin/viewalleventmanagers`);
      setCreators(response.data);
    } catch (err) {
      setError("Failed to fetch creators: " + err.message);
    }
  };

  useEffect(() => {
    fetchCreators();
  }, []);

  const deleteCreator = async (id) => {
    try {
      const response = await axios.delete(`${config.url}/admin/deletemanager?mid=${id}`);
      toast.success(response.data);
      fetchCreators();
    } catch (err) {
      toast.error("Failed to delete creator: " + err.message);
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h3 style={{ textAlign: "center" }}>Campaign Creators</h3>
      <ToastContainer position="top-center" autoClose={3000} />
      {error ? (
        <p style={{ color: "red", textAlign: "center" }}>{error}</p>
      ) : (
        <table style={{ width: "100%", borderCollapse: "collapse" }}>
          <thead>
            <tr>
              <th>ID</th><th>Name</th><th>Email</th><th>Mobile</th><th>Company</th><th>Location</th><th>Action</th>
            </tr>
          </thead>
          <tbody>
            {creators.map(creator => (
              <tr key={creator.id}>
                <td>{creator.id}</td>
                <td>{creator.name}</td>
                <td>{creator.email}</td>
                <td>{creator.mobileno}</td>
                <td>{creator.company_name}</td>
                <td>{creator.company_location}</td>
                <td>
                  <Button
                    variant="outlined"
                    color="error"
                    startIcon={<DeleteIcon />}
                    onClick={() => deleteCreator(creator.id)}
                  >
                    Delete
                  </Button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}
