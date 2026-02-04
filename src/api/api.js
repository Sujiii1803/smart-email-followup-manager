import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080/api",
});

export const fetchStats = () => API.get("/emails/stats");
export const fetchPendingEmails = () => API.get("/emails/pending");


export const demoEmails = [
  {
    id: 1,
    fromEmail: "recruiter@google.com",
    subject: "Interview Feedback – Google SWE Role",
    receivedAt: "2026-02-01T10:30:00",
  },
  {
    id: 2,
    fromEmail: "hr@amazon.com",
    subject: "Next Steps – SDE Interview",
    receivedAt: "2026-01-29T14:10:00",
  },
  {
    id: 3,
    fromEmail: "careers@microsoft.com",
    subject: "Application Update – Software Engineer",
    receivedAt: "2026-01-27T09:45:00",
  },
  {
    id: 4,
    fromEmail: "jobs@netflix.com",
    subject: "Recruiter Connect – Backend Role",
    receivedAt: "2026-01-25T18:20:00",
  },
];

export const demoStats = {
  totalEmails: 128,
  pendingReplies: 4,
  repliedEmails: 124,
};
