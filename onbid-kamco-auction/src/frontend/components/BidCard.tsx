import React from 'react';

interface BidCardProps {
    title: string;
    description: string;
    bidAmount: number;
    bidEndDate: string;
    onFavoriteToggle: () => void;
    isFavorite: boolean;
}

const BidCard: React.FC<BidCardProps> = ({ title, description, bidAmount, bidEndDate, onFavoriteToggle, isFavorite }) => {
    return (
        <div className="bid-card">
            <h3>{title}</h3>
            <p>{description}</p>
            <p>Bid Amount: {bidAmount} 원</p>
            <p>End Date: {new Date(bidEndDate).toLocaleString()}</p>
            <button onClick={onFavoriteToggle}>
                {isFavorite ? 'Remove from Favorites' : 'Add to Favorites'}
            </button>
        </div>
    );
};

export default BidCard;