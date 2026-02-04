import { useEffect, useState } from "react";
import {
  fetchPendingEmails,
  fetchStats,
  demoEmails,
  demoStats,
} from "../api/api";
import "../styles.css";

export default function Dashboard() {
  const [emails, setEmails] = useState([]);
  const [stats, setStats] = useState(null);
  const [search, setSearch] = useState("");
  const DEMO_MODE = true; 

  const getDaysAgo = (date) => {
    const diff =
      (new Date() - new Date(date)) / (1000 * 60 * 60 * 24);
    return Math.floor(diff);
  };

  useEffect(() => {
    if (DEMO_MODE) {
      setEmails(demoEmails);
      setStats(demoStats);
    } else {
      fetchPendingEmails().then((res) => setEmails(res.data));
      fetchStats().then((res) => setStats(res.data));
    }
  }, []);

  const filteredEmails = emails.filter(
    (e) =>
      e.fromEmail.toLowerCase().includes(search.toLowerCase()) ||
      e.subject.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <div className="container">
      <div className="demo-banner">
        🔵 Demo Mode: Showing tracked emails & follow-up status
      </div>

      <h1 className="title">📬 Email Follow-Up Dashboard</h1>
      <p className="subtitle">
        Automatically tracks emails you haven’t replied to and
        helps you follow up on time.
      </p>

     
      {stats && (
        <div className="stats-grid">
          <div className="stat-card">
            <h2>{stats.totalEmails}</h2>
            <p>Total Emails</p>
          </div>
          <div className="stat-card">
            <h2>{stats.pendingReplies}</h2>
            <p>Pending Replies</p>
          </div>
          <div className="stat-card">
            <h2>{stats.repliedEmails}</h2>
            <p>Replied</p>
          </div>
        </div>
      )}

      
      <input
        className="search"
        placeholder="🔍 Search by sender or subject..."
        value={search}
        onChange={(e) => setSearch(e.target.value)}
      />

      <h2 className="section-title">⏳ Pending Replies</h2>

      <div className="email-grid">
        {filteredEmails.map((email) => (
          <div key={email.id} className="email-card">
            <p><b>From:</b> {email.fromEmail}</p>
            <p><b>Subject:</b> {email.subject}</p>
            <p className="date">
              🕒 Pending for {getDaysAgo(email.receivedAt)} days
            </p>
            <button className="btn">Pending Reply</button>
          </div>
        ))}
      </div>
    </div>
  );
}
