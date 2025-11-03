import React, { useEffect, useState } from 'react';
import { getFavorites } from '../services/apiClient';
import BidCard from '../components/BidCard';

const Favorites = () => {
    const [favorites, setFavorites] = useState([]);

    useEffect(() => {
        const fetchFavorites = async () => {
            const data = await getFavorites();
            setFavorites(data);
        };

        fetchFavorites();
    }, []);

    return (
        <div>
            <h1>My Favorite Bids</h1>
            <div className="favorites-list">
                {favorites.length > 0 ? (
                    favorites.map(bid => (
                        <BidCard key={bid.id} bid={bid} />
                    ))
                ) : (
                    <p>No favorite bids found.</p>
                )}
            </div>
        </div>
    );
};

export default Favorites;