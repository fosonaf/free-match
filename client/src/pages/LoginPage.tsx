import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function LoginPage() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [isRegister, setIsRegister] = useState(false);
    const [username, setUsername] = useState('');
    const [error, setError] = useState('');
    const [loading, setLoading] = useState(false);
    const navigate = useNavigate();

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        setError('');
        setLoading(true);
        
        const endpoint = isRegister ? '/api/auth/register' : '/api/auth/login';
        const body = isRegister
            ? { email, password, username }
            : { email, password };

        try {
            const res = await fetch(`http://localhost:8080${endpoint}`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(body)
            });

            if (res.ok) {
                const data = await res.json();
                localStorage.setItem('token', data.token);
                localStorage.setItem('user', JSON.stringify({ id: data.userId, username: data.username }));
                navigate('/');
            } else {
                const data = await res.json();
                setError(data.message || 'Une erreur est survenue');
            }
        } catch (err) {
            setError('Erreur de connexion au serveur');
        } finally {
            setLoading(false);
        }
    };

    return (
        <div style={{ minHeight: '100vh', display: 'flex', justifyContent: 'center', alignItems: 'center', padding: '1rem' }}>
            <div style={{ width: '100%', maxWidth: '20rem' }}>
                <div style={{ textAlign: 'center', marginBottom: '2rem' }}>
                    <h1 style={{ fontSize: '1.5rem', fontWeight: 'bold', color: '#333' }}>FreeMatch</h1>
                    <p style={{ color: '#666', fontSize: '.875rem' }}>{isRegister ? 'Créer un compte' : 'Connexion'}</p>
                </div>

                {error && (
                    <div style={{ marginBottom: '1rem', padding: '.75rem', backgroundColor: '#fef2f2', color: '#e74c3c', fontSize: '.875rem', borderRadius: '.25rem' }}>
                        {error}
                    </div>
                )}

                <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '1rem' }}>
                    {isRegister && (
                        <div style={{ display: 'flex', flexDirection: 'column' }}>
                            <label style={{ fontSize: '.875rem', color: '#333' }}>Pseudo</label>
                            <input
                                type="text"
                                value={username}
                                onChange={e => setUsername(e.target.value)}
                                style={{ width: '100%', padding: '.5rem', border: '1px solid #ddd', borderRadius: '.25rem' }}
                                required
                            />
                        </div>
                    )}

                    <div style={{ display: 'flex', flexDirection: 'column' }}>
                        <label style={{ fontSize: '.875rem', color: '#333' }}>Email</label>
                        <input
                            type="email"
                            value={email}
                            onChange={e => setEmail(e.target.value)}
                            style={{ width: '100%', padding: '.5rem', border: '1px solid #ddd', borderRadius: '.25rem' }}
                            required
                        />
                    </div>

                    <div style={{ display: 'flex', flexDirection: 'column' }}>
                        <label style={{ fontSize: '.875rem', color: '#333' }}>Mot de passe</label>
                        <input
                            type="password"
                            value={password}
                            onChange={e => setPassword(e.target.value)}
                            style={{ width: '100%', padding: '.5rem', border: '1px solid #ddd', borderRadius: '.25rem' }}
                            required
                        />
                    </div>

                    <button type="submit" disabled={loading} style={{ width: '100%', padding: '.5rem', backgroundColor: '#34c759', color: '#fff', borderRadius: '.25rem', cursor: 'pointer', opacity: loading ? '.5' : '1' }}>
                        {loading ? 'Chargement...' : (isRegister ? 'S\'inscrire' : 'Se connecter')}
                    </button>
                </form>

                <div style={{ marginTop: '1rem', textAlign: 'center' }}>
                    <button onClick={() => { setIsRegister(!isRegister); setError(''); }} style={{ color: '#34c759', textDecoration: 'underline', cursor: 'pointer' }}>
                        {isRegister ? 'Déjà un compte ? Se connecter' : 'Créer un compte'}
                    </button>
                </div>
            </div>
        </div>
    );
}