
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import WelcomePage from './components/Welcome/WelcomePage';
import LoginPage from './components/Login/LoginPage';
import StudentReport from './components/Student/StudentReport';
import StudentForm from './components/Student/StudentForm';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<WelcomePage />} />
        <Route path="/student/login" element={<LoginPage />} />
        <Route path="/student/report" element={<StudentReport />} />
        <Route path="/student/add" element={<StudentForm />} />
        <Route path="/student/edit/:id" element={<StudentForm />} />
        <Route path="*" element={<Navigate to="/student/report" replace />} />
      </Routes>
      <ToastContainer position="top-right" autoClose={3000} />
    </Router>
  );
}

export default App;