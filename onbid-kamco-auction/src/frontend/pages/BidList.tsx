import React, { useEffect, useState } from 'react';
import { fetchBids } from '../services/apiClient';
import BidCard from '../components/BidCard';
import BidFilter from '../components/BidFilter';

const BidList = () => {
    const [bids, setBids] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const loadBids = async () => {
            try {
                const bidData = await fetchBids();
                setBids(bidData);
            } catch (err) {
                setError(err.message);
            } finally {
                setLoading(false);
            }
        };

        loadBids();
    }, []);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <div>
            <h1>Available Bids</h1>
            <BidFilter />
            <div className="bid-list">
                {bids.map(bid => (
                    <BidCard key={bid.id} bid={bid} />
                ))}
            </div>
        </div>
    );
};

export default BidList;