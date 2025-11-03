import { useEffect, useState } from 'react';
import apiClient from '../services/apiClient';

const useBids = () => {
    const [bids, setBids] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchBids = async () => {
            try {
                const response = await apiClient.get('/bids');
                setBids(response.data);
            } catch (err) {
                setError(err);
            } finally {
                setLoading(false);
            }
        };

        fetchBids();
    }, []);

    return { bids, loading, error };
};

export default useBids;