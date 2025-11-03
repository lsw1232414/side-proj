import React, { useState } from 'react';

const BidFilter = ({ onFilterChange }) => {
    const [searchTerm, setSearchTerm] = useState('');
    const [minPrice, setMinPrice] = useState('');
    const [maxPrice, setMaxPrice] = useState('');
    const [status, setStatus] = useState('all');

    const handleSearchChange = (e) => {
        setSearchTerm(e.target.value);
        onFilterChange({ searchTerm: e.target.value, minPrice, maxPrice, status });
    };

    const handleMinPriceChange = (e) => {
        setMinPrice(e.target.value);
        onFilterChange({ searchTerm, minPrice: e.target.value, maxPrice, status });
    };

    const handleMaxPriceChange = (e) => {
        setMaxPrice(e.target.value);
        onFilterChange({ searchTerm, minPrice, maxPrice: e.target.value, status });
    };

    const handleStatusChange = (e) => {
        setStatus(e.target.value);
        onFilterChange({ searchTerm, minPrice, maxPrice, status: e.target.value });
    };

    return (
        <div className="bid-filter">
            <input
                type="text"
                placeholder="Search bids..."
                value={searchTerm}
                onChange={handleSearchChange}
            />
            <input
                type="number"
                placeholder="Min Price"
                value={minPrice}
                onChange={handleMinPriceChange}
            />
            <input
                type="number"
                placeholder="Max Price"
                value={maxPrice}
                onChange={handleMaxPriceChange}
            />
            <select value={status} onChange={handleStatusChange}>
                <option value="all">All</option>
                <option value="open">Open</option>
                <option value="closed">Closed</option>
            </select>
        </div>
    );
};

export default BidFilter;