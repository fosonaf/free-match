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

    if (loading) return <div>Chargement des terrains...</div>;

    return (
        <div className="p-8">
            <h1 className="text-3xl font-bold mb-6">Terrains disponibles</h1>
            <div className="grid gap-6 md:grid-cols-2 lg:grid-cols-3">
                {fields.map(field => (
                    <Link
                        key={field.id}
                        to={`/field/${field.id}`}
                        className="border rounded-lg p-4 hover:shadow-lg transition"
                    >
                        <h2 className="text-xl font-semibold">{field.name}</h2>
                        <p className="text-gray-600">{field.address}, {field.city}</p>
                        <div className="mt-2 flex gap-2 flex-wrap">
                            {field.sports.map(s => (
                                <span key={s} className="bg-blue-100 text-blue-800 text-xs px-2 py-1 rounded">
                  {s}
                </span>
                            ))}
                        </div>
                    </Link>
                ))}
            </div>
        </div>
    );
}