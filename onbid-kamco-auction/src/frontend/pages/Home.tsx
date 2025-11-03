import React from 'react';
import { Link } from 'react-router-dom';
import BidFilter from '../components/BidFilter';
import BidCard from '../components/BidCard';
import useBids from '../hooks/useBids';

const Home: React.FC = () => {
    const { bids, loading, error } = useBids();

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error loading bids: {error.message}</div>;
    }

    return (
        <div>
            <h1>온비드 캠코 공매물건 조회</h1>
            <BidFilter />
            <div className="bid-list">
                {bids.map(bid => (
                    <Link key={bid.id} to={`/bids/${bid.id}`}>
                        <BidCard bid={bid} />
                    </Link>
                ))}
            </div>
        </div>
    );
};

export default Home;