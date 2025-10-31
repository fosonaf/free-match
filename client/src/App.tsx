import { useEffect, useState } from 'react'
import './index.css'

function App() {
    const [data, setData] = useState<any>(null)
    const [loading, setLoading] = useState(true)

    useEffect(() => {
        fetch('/api/ping')
            .then(r => r.json())
            .then(d => {
                setData(d)
                setLoading(false)
            })
            .catch(() => {
                setData({ status: 'error', app: 'API unreachable' })
                setLoading(false)
            })
    }, [])

    return (
        <div style={{
            background: 'white',
            padding: '2.5rem',
            borderRadius: '1.5rem',
            boxShadow: '0 20px 25px -5px rgba(0, 0, 0, 0.1)',
            maxWidth: '420px',
            width: '100%',
            textAlign: 'center'
        }}>
            <h1 style={{
                fontSize: '3rem',
                fontWeight: '800',
                color: '#059669',
                marginBottom: '1rem'
            }}>
                FreeMatch
            </h1>

            {loading ? (
                <p style={{ color: '#6b7280' }}>Connexion au serveur...</p>
            ) : (
                <div style={{
                    background: '#f3f4f6',
                    padding: '1.5rem',
                    borderRadius: '1rem',
                    marginTop: '1.5rem',
                    fontFamily: 'monospace',
                    fontSize: '0.9rem'
                }}>
                    <p><strong>Status:</strong> <span style={{ color: '#059669' }}>{data?.status || 'N/A'}</span></p>
                    <p><strong>App:</strong> {data?.app || 'N/A'}</p>
                </div>
            )}

            <p style={{
                marginTop: '2rem',
                fontSize: '0.75rem',
                color: '#9ca3af'
            }}>
                client + server = connected
            </p>
        </div>
    )
}

export default App
