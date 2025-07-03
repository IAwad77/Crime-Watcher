import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import UserForm          from "./pages/UserForm";
import ReportForm        from "./pages/ReportForm";
import AdminDashboard    from "./pages/AdminDashboard";
import HotspotDashboard  from "./pages/HotspotDashboard";

export default function App() {
  return (
    <BrowserRouter>
      <nav style={{ marginBottom: 12 }}>
        <Link to="/">User</Link> |{" "}
        <Link to="/report">Report</Link> |{" "}
        <Link to="/admin">Admin</Link> |{" "}
        <Link to="/hotspots">Hotspots</Link>
      </nav>

      <Routes>
        <Route path="/"          element={<UserForm />}         />
        <Route path="/report"    element={<ReportForm />}       />
        <Route path="/admin"     element={<AdminDashboard />}   />
        <Route path="/hotspots"  element={<HotspotDashboard />} />
      </Routes>
    </BrowserRouter>
  );
}
