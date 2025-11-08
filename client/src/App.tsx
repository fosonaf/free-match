import { BrowserRouter, Routes, Route, Navigate, useNavigate, Link } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import FieldsPage from './pages/FieldsPage';
import './App.css';

// Composant Header
function Header() {
    const navigate = useNavigate();
    const user = JSON.parse(localStorage.getItem('user') || '{}');

    const handleLogout = () => {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        navigate('/login');
    };

    return (
        <header className="header">
            <div className="header-container">
                <div className="header-content">
                    {/* Logo et nom - Lien vers l'accueil */}
                    <Link to="/" className="logo-link">
                        <div className="logo-icon">
                            <svg style={{width: '1.5rem', height: '1.5rem', color: 'white'}} fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M13 10V3L4 14h7v7l9-11h-7z" />
                            </svg>
                        </div>
                        <span className="logo-text">FreeMatch</span>
                    </Link>

                    {/* Navigation et utilisateur */}
                    <div className="header-actions">
                        {/* Nom d'utilisateur */}
                        {user.username && (
                            <div className="user-info">
                                <svg style={{width: '1.25rem', height: '1.25rem', color: '#059669'}} fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z" />
                                </svg>
                                <span style={{fontWeight: 500}}>{user.username}</span>
                            </div>
                        )}

                        {/* Bouton de déconnexion */}
                        <button
                            onClick={handleLogout}
                            className="logout-btn"
                        >
                            <svg style={{width: '1.25rem', height: '1.25rem'}} fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M17 16l4-4m0 0l-4-4m4 4H7m6 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h4a3 3 0 013 3v1" />
                            </svg>
                            <span style={{display: 'none'}}>Déconnexion</span>
                        </button>
                    </div>
                </div>
            </div>
        </header>
    );
}

// Page d'accueil
function HomePage() {
    return (
        <div style={{ minHeight: '100vh', background: 'linear-gradient(to bottom right, #ecfdf5, #d1fae5)' }}>
            <Header />
            <main style={{ maxWidth: '80rem', margin: '0 auto', padding: '2rem 1rem' }}>
                {/* Hero Section */}
                <div style={{ textAlign: 'center', marginBottom: '3rem' }}>
                    <div style={{ display: 'inline-flex', alignItems: 'center', justifyContent: 'center', width: '4rem', height: '4rem', background: 'linear-gradient(to bottom right, #34d399, #059669)', borderRadius: '1rem', boxShadow: '0 10px 15px rgba(0,0,0,0.1)', marginBottom: '1rem' }}>
                        <svg style={{ width: '2rem', height: '2rem', color: 'white' }} fill="none" stroke="currentColor" viewBox="0 0 24 24">
                            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M13 10V3L4 14h7v7l9-11h-7z" />
                        </svg>
                    </div>
                    <h1 style={{ fontSize: '2.25rem', fontWeight: 'bold', color: '#111827', marginBottom: '0.75rem' }}>
                        Bienvenue sur FreeMatch
                    </h1>
                    <p style={{ fontSize: '1.125rem', color: '#4b5563', maxWidth: '42rem', margin: '0 auto' }}>
                        Organisez vos évènements sportifs facilement et rassemblez votre communauté !
                    </p>
                </div>

                {/* Cards Section */}
                <div style={{ display: 'grid', gap: '1.5rem', marginBottom: '2.5rem', gridTemplateColumns: 'repeat(auto-fit, minmax(250px, 1fr))' }}>
                    {/* Card 1 - Terrains */}
                    <Link
                        to="/fields"
                        style={{ background: 'white', borderRadius: '0.75rem', padding: '1.5rem', boxShadow: '0 4px 6px rgba(0,0,0,0.1)', border: '1px solid #f3f4f6', textDecoration: 'none', transition: 'all 0.2s' }}
                    >
                        <div style={{ width: '3rem', height: '3rem', backgroundColor: '#d1fae5', borderRadius: '0.5rem', display: 'flex', alignItems: 'center', justifyContent: 'center', marginBottom: '0.75rem' }}>
                            <svg style={{ width: '1.5rem', height: '1.5rem', color: '#059669' }} fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M17.657 16.657L13.414 20.9a1.998 1.998 0 01-2.827 0l-4.244-4.243a8 8 0 1111.314 0z" />
                                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M15 11a3 3 0 11-6 0 3 3 0 016 0z" />
                            </svg>
                        </div>
                        <h3 style={{ fontSize: '1.25rem', fontWeight: 'bold', color: '#111827', marginBottom: '0.5rem' }}>Terrains</h3>
                        <p style={{ color: '#4b5563' }}>
                            Découvrez tous les terrains disponibles près de chez vous
                        </p>
                    </Link>

                    {/* Card 2 - Évènements */}
                    <div style={{ background: 'white', borderRadius: '0.75rem', padding: '1.5rem', boxShadow: '0 4px 6px rgba(0,0,0,0.1)', border: '1px solid #f3f4f6' }}>
                        <div style={{ width: '3rem', height: '3rem', backgroundColor: '#dbeafe', borderRadius: '0.5rem', display: 'flex', alignItems: 'center', justifyContent: 'center', marginBottom: '0.75rem' }}>
                            <svg style={{ width: '1.5rem', height: '1.5rem', color: '#2563eb' }} fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z" />
                            </svg>
                        </div>
                        <h3 style={{ fontSize: '1.25rem', fontWeight: 'bold', color: '#111827', marginBottom: '0.5rem' }}>Évènements</h3>
                        <p style={{ color: '#4b5563' }}>
                            Créez et participez à des évènements sportifs
                        </p>
                    </div>

                    {/* Card 3 - Communauté */}
                    <div style={{ background: 'white', borderRadius: '0.75rem', padding: '1.5rem', boxShadow: '0 4px 6px rgba(0,0,0,0.1)', border: '1px solid #f3f4f6' }}>
                        <div style={{ width: '3rem', height: '3rem', backgroundColor: '#e9d5ff', borderRadius: '0.5rem', display: 'flex', alignItems: 'center', justifyContent: 'center', marginBottom: '0.75rem' }}>
                            <svg style={{ width: '1.5rem', height: '1.5rem', color: '#9333ea' }} fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M17 20h5v-2a3 3 0 00-5.356-1.857M17 20H7m10 0v-2c0-.656-.126-1.283-.356-1.857M7 20H2v-2a3 3 0 015.356-1.857M7 20v-2c0-.656.126-1.283.356-1.857m0 0a5.002 5.002 0 019.288 0M15 7a3 3 0 11-6 0 3 3 0 016 0zm6 3a2 2 0 11-4 0 2 2 0 014 0zM7 10a2 2 0 11-4 0 2 2 0 014 0z" />
                            </svg>
                        </div>
                        <h3 style={{ fontSize: '1.25rem', fontWeight: 'bold', color: '#111827', marginBottom: '0.5rem' }}>Communauté</h3>
                        <p style={{ color: '#4b5563' }}>
                            Rejoignez une communauté de passionnés de sport
                        </p>
                    </div>
                </div>

                {/* CTA Section */}
                <div style={{ background: 'linear-gradient(to right, #10b981, #059669)', borderRadius: '0.75rem', padding: '2rem', textAlign: 'center', color: 'white', boxShadow: '0 10px 15px rgba(0,0,0,0.1)' }}>
                    <h2 style={{ fontSize: '1.5rem', fontWeight: 'bold', marginBottom: '0.75rem' }}>
                        Prêt à commencer ?
                    </h2>
                    <p style={{ color: '#d1fae5', marginBottom: '1.5rem' }}>
                        Explorez les terrains disponibles et créez votre premier évènement sportif
                    </p>
                    <Link
                        to="/fields"
                        style={{ display: 'inline-flex', alignItems: 'center', gap: '0.5rem', background: 'white', color: '#059669', padding: '0.75rem 1.5rem', borderRadius: '0.75rem', fontWeight: 'bold', textDecoration: 'none', boxShadow: '0 10px 15px rgba(0,0,0,0.1)', transition: 'all 0.2s' }}
                    >
                        Voir les terrains
                        <svg style={{ width: '1.25rem', height: '1.25rem' }} fill="none" stroke="currentColor" viewBox="0 0 24 24">
                            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M13 7l5 5m0 0l-5 5m5-5H6" />
                        </svg>
                    </Link>
                </div>
            </main>
        </div>
    );
}

// Layout avec Header pour les pages authentifiées
function Layout({ children }: { children: React.ReactNode }) {
    return (
        <div style={{ minHeight: '100vh', background: 'linear-gradient(to bottom right, #ecfdf5, #d1fae5)' }}>
            <Header />
            <main>{children}</main>
        </div>
    );
}

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
                    path="/"
                    element={
                        <PrivateRoute>
                            <HomePage />
                        </PrivateRoute>
                    }
                />
                <Route
                    path="/fields"
                    element={
                        <PrivateRoute>
                            <Layout>
                                <FieldsPage />
                            </Layout>
                        </PrivateRoute>
                    }
                />
            </Routes>
        </BrowserRouter>
    );
}