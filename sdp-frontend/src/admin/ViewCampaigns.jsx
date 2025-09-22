import { useEffect, useState } from 'react';
import axios from 'axios';
import config from '../config';

export default function ViewCampaigns() {
  const [campaigns, setCampaigns] = useState([]);
  const [error, setError] = useState('');

  const fetchCampaigns = async () => {
    try {
      const response = await axios.get(`${config.url}/creator/viewcampaigns?creatorId=1`); 
      // TODO: Replace 1 with logged-in creator's ID
      setCampaigns(response.data);
    } catch (err) {
      setError("Failed to fetch campaigns: " + err.message);
    }
  };

  useEffect(() => {
    fetchCampaigns();
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h3 style={{ textAlign: "center" }}>My Campaigns</h3>

      {error ? (
        <p style={{ textAlign: "center", color: "red", fontWeight: "bold" }}>{error}</p>
      ) : campaigns.length === 0 ? (
        <p style={{ textAlign: "center", color: "gray" }}>No campaigns found</p>
      ) : (
        <table style={{ width: "100%", borderCollapse: "collapse", marginTop: "20px" }}>
          <thead>
            <tr>
              <th>ID</th>
              <th>Title</th>
              <th>Description</th>
              <th>Goal Amount</th>
              <th>Raised Amount</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            {campaigns.map((campaign) => (
              <tr key={campaign.id}>
                <td>{campaign.id}</td>
                <td>{campaign.title}</td>
                <td>{campaign.description}</td>
                <td>{campaign.goalAmount}</td>
                <td>{campaign.raisedAmount}</td>
                <td>{campaign.status}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}
