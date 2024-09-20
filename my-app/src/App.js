import './App.css';
import Dashboard from './Dashboard';
import { useState,useEffect } from 'react';
import { HashRouter, Routes, Route } from 'react-router-dom';
import SignIn from './SignIn';
import { AuthProvider } from './Context/AuthContext';
import ProtectedRoute from './ProtectedRoute';

function App() {
  const [loading, setLoading] = useState(false);
  // const [loader,setLoader]=useState(false);
  // const onLoader=()=> setLoader(true)
  // const offLoader=()=> setLoader(false)
  
  const toggleLoader=()=>{
      setLoading((prev) => !prev);
  }

  return (
    <AuthProvider>
      <div className="App">
      {loading && (
          <div className="loading-spinner">
            <div className="spinner"></div>
          </div>
        )}
        <HashRouter>
          <Routes>
            <Route path="/" element={<SignIn />} />
            <Route
              path="/dashboard"
              element={
                <ProtectedRoute>
                  <Dashboard toggleLoader={toggleLoader} />
                </ProtectedRoute>
              }
            />
          </Routes>
        </HashRouter>
      </div>
    </AuthProvider>
  );
}

export default App;
