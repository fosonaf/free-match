import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import FieldsPage from './pages/FieldsPage';

function PrivateRoute({ children }: { children: JSX.Element }) {
    const token = localStorage.getItem('token');
    return token ? children : <Navigate to="/login" />;
}

export default function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/login" element={<LoginPage />} />
                <Route
                    path="/fields"
                    element={
                        <PrivateRoute>
                            <FieldsPage />
                        </PrivateRoute>
                    }
                />
                <Route path="/" element={<Navigate to="/fields" />} />
            </Routes>
        </BrowserRouter>
    );
}