import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

export default function LoginPage() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [isRegister, setIsRegister] = useState(false);
    const [username, setUsername] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        const endpoint = isRegister ? '/api/auth/register' : '/api/auth/login';
        const body = isRegister
            ? { email, password, username }
            : { email, password };

        const res = await fetch(`http://localhost:8080${endpoint}`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(body)
        });

        if (res.ok) {
            const data = await res.json();
            localStorage.setItem('token', data.token);
            localStorage.setItem('user', JSON.stringify({ id: data.userId, username: data.username }));
            navigate('/fields');
        }
    };

    return (
        <div className="min-h-screen flex items-center justify-center bg-gray-50">
            <div className="max-w-md w-full space-y-8 p-8 bg-white rounded shadow">
                <h2 className="text-3xl font-bold text-center">
                    {isRegister ? 'Créer un compte' : 'Connexion'}
                </h2>
                <form onSubmit={handleSubmit} className="space-y-4">
                    {isRegister && (
                        <input
                            type="text"
                            placeholder="Pseudo"
                            value={username}
                            onChange={e => setUsername(e.target.value)}
                            className="w-full px-3 py-2 border rounded"
                            required
                        />
                    )}
                    <input
                        type="email"
                        placeholder="Email"
                        value={email}
                        onChange={e => setEmail(e.target.value)}
                        className="w-full px-3 py-2 border rounded"
                        required
                    />
                    <input
                        type="password"
                        placeholder="Mot de passe"
                        value={password}
                        onChange={e => setPassword(e.target.value)}
                        className="w-full px-3 py-2 border rounded"
                        required
                    />
                    <button type="submit" className="w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700">
                        {isRegister ? 'S’inscrire' : 'Se connecter'}
                    </button>
                </form>
                <p className="text-center">
                    {isRegister ? 'Déjà un compte ?' : 'Pas de compte ?'}
                    <button
                        onClick={() => setIsRegister(!isRegister)}
                        className="ml-1 text-blue-600 hover:underline"
                    >
                        {isRegister ? 'Se connecter' : 'S’inscrire'}
                    </button>
                </p>
            </div>
        </div>
    );
}