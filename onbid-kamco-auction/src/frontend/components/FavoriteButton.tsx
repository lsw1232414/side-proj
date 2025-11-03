import React, { useState } from 'react';

interface FavoriteButtonProps {
  isFavorite: boolean;
  onToggleFavorite: () => void;
}

const FavoriteButton: React.FC<FavoriteButtonProps> = ({ isFavorite, onToggleFavorite }) => {
  const [isFavorited, setIsFavorited] = useState(isFavorite);

  const handleClick = () => {
    setIsFavorited(!isFavorited);
    onToggleFavorite();
  };

  return (
    <button onClick={handleClick}>
      {isFavorited ? 'Remove from Favorites' : 'Add to Favorites'}
    </button>
  );
};

export default FavoriteButton;