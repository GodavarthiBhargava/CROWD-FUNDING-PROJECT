import { Link } from 'react-router-dom';

export default function AdminNavbar() {
  return (
    <nav style={{ backgroundColor: "#333", padding: "15px" }}>
      <ul style={{ display: "flex", justifyContent: "center", gap: "20px", listStyle: "none", margin: 0, padding: 0 }}>
        <li><Link to="/adminhome" style={{ color: "white" }}>Dashboard</Link></li>
        <li><Link to="/viewusers" style={{ color: "white" }}>View Users</Link></li>
        <li><Link to="/viewcreators" style={{ color: "white" }}>View Creators</Link></li>
        <li><Link to="/logout" style={{ color: "white" }}>Logout</Link></li>
      </ul>
    </nav>
  );
}
