import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';

interface Field {
    id: string;
    name: string;
    address: string;
    city: string;
    sports: string[];
    latitude: number;
    longitude: number;
}

export default function FieldsPage() {
    const [fields, setFields] = useState<Field[]>([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetch('http://localhost:8080/api/fields')
            .then(r => r.json())
            .then(setFields)
            .finally(() => setLoading(false));
    }, []);

    if (loading) {
        return (
            <div style={{ minHeight: '100vh', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
                <div style={{ textAlign: 'center' }}>
                    <div style={{ display: 'inline-block', width: '3rem', height: '3rem', border: '4px solid #10b981', borderTopColor: 'transparent', borderRadius: '50%', animation: 'spin 1s linear infinite' }}></div>
                    <p style={{ marginTop: '1rem', color: '#4b5563', fontWeight: 500 }}>Chargement des terrains...</p>
                    <style>{`@keyframes spin { to { transform: rotate(360deg); } }`}</style>
                </div>
            </div>
        );
    }

    return (
        <div style={{ maxWidth: '80rem', margin: '0 auto', padding: '2rem 1rem' }}>
            <div style={{ marginBottom: '2rem' }}>
                <h1 style={{ fontSize: '2.25rem', fontWeight: 'bold', color: '#111', marginBottom: '0.5rem' }}>Terrains disponibles</h1>
                <p style={{ color: '#666' }}>Découvrez tous les terrains sportifs près de chez vous</p>
            </div>

            {fields.length === 0 ? (
                <div style={{ textAlign: 'center', padding: '3rem', background: 'white', borderRadius: '1rem', boxShadow: '0 1px 3px rgba(0,0,0,0.1)', border: '1px solid #f3f4f6' }}>
                    <svg style={{ width: '4rem', height: '4rem', color: '#9ca3af', margin: '0 auto 1rem' }} fill="none" stroke="currentColor" viewBox="0 0 24 24">
                        <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M17.657 16.657L13.414 20.9a1.998 1.998 0 01-2.827 0l-4.244-4.243a8 8 0 1111.314 0z" />
                        <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M15 11a3 3 0 11-6 0 3 3 0 016 0z" />
                    </svg>
                    <h3 style={{ fontSize: '1.25rem', fontWeight: 600, color: '#111', marginBottom: '0.5rem' }}>Aucun terrain disponible</h3>
                    <p style={{ color: '#666' }}>Les terrains seront bientôt ajoutés</p>
                </div>
            ) : (
                <div style={{ display: 'grid', gap: '1.5rem', gridTemplateColumns: 'repeat(auto-fill, minmax(300px, 1fr))' }}>
                    {fields.map(field => (
                        <Link
                            key={field.id}
                            to={`/field/${field.id}`}
                            style={{ background: 'white', borderRadius: '1rem', padding: '1.5rem', boxShadow: '0 4px 6px rgba(0,0,0,0.1)', border: '1px solid #f3f4f6', textDecoration: 'none', transition: 'all 0.2s' }}
                        >
                            <div style={{ width: '3rem', height: '3rem', backgroundColor: '#d1fae5', borderRadius: '0.75rem', display: 'flex', alignItems: 'center', justifyContent: 'center', marginBottom: '1rem' }}>
                                <svg style={{ width: '1.75rem', height: '1.75rem', color: '#059669' }} fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M17.657 16.657L13.414 20.9a1.998 1.998 0 01-2.827 0l-4.244-4.243a8 8 0 1111.314 0z" />
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M15 11a3 3 0 11-6 0 3 3 0 016 0z" />
                                </svg>
                            </div>

                            <h2 style={{ fontSize: '1.25rem', fontWeight: 'bold', color: '#111', marginBottom: '0.5rem' }}>
                                {field.name}
                            </h2>
                            <p style={{ color: '#666', fontSize: '0.875rem', marginBottom: '1rem', display: 'flex', alignItems: 'flex-start', gap: '0.5rem' }}>
                                <svg style={{ width: '1rem', height: '1rem', color: '#9ca3af', marginTop: '0.125rem', flexShrink: 0 }} fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M17.657 16.657L13.414 20.9a1.998 1.998 0 01-2.827 0l-4.244-4.243a8 8 0 1111.314 0z" />
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M15 11a3 3 0 11-6 0 3 3 0 016 0z" />
                                </svg>
                                <span>{field.address}, {field.city}</span>
                            </p>

                            <div style={{ display: 'flex', gap: '0.5rem', flexWrap: 'wrap' }}>
                                {field.sports.map(s => (
                                    <span
                                        key={s}
                                        style={{ backgroundColor: '#d1fae5', color: '#065f46', fontSize: '0.75rem', fontWeight: 500, padding: '0.25rem 0.75rem', borderRadius: '9999px' }}
                                    >
                                        {s}
                                    </span>
                                ))}
                            </div>
                        </Link>
                    ))}
                </div>
            )}
        </div>
    );
}